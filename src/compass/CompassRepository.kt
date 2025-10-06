package compass

import db.CrudRepository
import db.getJson
import db.jsonb
import klite.jdbc.create
import klite.toValues
import java.sql.ResultSet
import javax.sql.DataSource

class CompassRepository(db: DataSource): CrudRepository<CompassAnswers>(db, "compass_answers") {
  override fun CompassAnswers.persister() = toValues(
    CompassAnswers::answers to jsonb(answers),
    CompassAnswers::results to jsonb(results)
  )
  override fun ResultSet.mapper() = create(
    CompassAnswers::answers to getJson<Map<String, Int>>("answers"),
    CompassAnswers::results to getJson<Map<String, Double>>("results")
  )
}
