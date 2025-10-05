package db

import compass.CompassAnswers
import users.Role.USER
import users.User

/** Immutable domain object samples for unit tests */
object TestData {
  val user = User("Test", "User", USER)
  val compassAnswers = CompassAnswers("Buy groceries")
}
