package db

import compass.CompassAnswers
import users.Role.USER
import users.User

/** Immutable domain object samples for unit tests */
object TestData {
  val user = User("Test", "User", USER)
  val compassAnswers = CompassAnswers("compass-slug", "en", "kesklinn", mapOf("1" to 1, "2" to 2), mapOf("sde" to 0.9))
}
