package compass

import db.Entity
import db.Id
import klite.jdbc.nowSec
import java.time.Instant

data class CompassAnswers(
  val compassSlug: String,
  val lang: String,
  val answers: Map<String, Int>,
  val results: Map<String, Double> = emptyMap(),
  val ipAddress: String? = null,
  val userAgent: String? = null,
  val updatedAt: Instant = nowSec(),
  override val id: Id<CompassAnswers> = Id()
): Entity<CompassAnswers>
