package compass

import ch.tutteli.atrium.api.fluent.en_GB.toContain
import ch.tutteli.atrium.api.fluent.en_GB.toEqual
import ch.tutteli.atrium.api.verbs.expect
import db.DBTest
import db.TestData.compassAnswers
import org.junit.jupiter.api.Test

class CompassRepositoryTest: DBTest() {
  val repository = CompassRepository(db)

  @Test fun `save & load`() {
    repository.save(compassAnswers)
    expect(repository.get(compassAnswers.id)).toEqual(compassAnswers)
    expect(repository.list()).toContain(compassAnswers)
  }
}
