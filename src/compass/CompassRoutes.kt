package compass

import auth.Public
import db.Id
import klite.HttpExchange
import klite.annotations.POST
import klite.jdbc.nowSec

class CompassRoutes(private val repository: CompassRepository) {
  @POST("/answers") @Public
  fun save(answers: CompassAnswers, e: HttpExchange): Id<CompassAnswers> {
    val answers = answers.copy(ipAddress = e.remoteAddress, userAgent = e.header("user-agent"), updatedAt = nowSec())
    repository.save(answers)
    return answers.id
  }
}
