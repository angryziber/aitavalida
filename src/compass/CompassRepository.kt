package compass

import db.CrudRepository
import db.Entity
import db.Id
import db.getJson
import db.jsonb
import klite.jdbc.ColName
import klite.jdbc.UpdatableEntity
import klite.jdbc.create
import klite.jdbc.nowSec
import klite.toValues
import java.sql.ResultSet
import java.time.Instant
import javax.sql.DataSource

class CompassRepository(db: DataSource): CrudRepository<CompassAnswers>(db, "compass_answers") {
  override fun CompassAnswers.persister() = toValues(CompassAnswers::answers to jsonb(answers))
  override fun ResultSet.mapper(): CompassAnswers = create(CompassAnswers::answers to getJson<Map<String, Int>>("answers"))
}

data class CompassAnswers(
  val compassSlug: String,
  val lang: String,
  val ipAddress: String?,
  val userAgent: String?,
  val answers: Map<String, Int>,
  val updatedAt: Instant = nowSec(),
  override val id: Id<CompassAnswers> = Id()
): Entity<CompassAnswers>
