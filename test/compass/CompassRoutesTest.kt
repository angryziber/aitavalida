package compass

import ch.tutteli.atrium.api.fluent.en_GB.toEqual
import ch.tutteli.atrium.api.verbs.expect
import db.BaseMocks.Companion.exchange
import db.TestData.compassAnswers
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class CompassRoutesTest {
  val repository = mockk<CompassRepository>(relaxed = true)
  val routes = CompassRoutes(repository)

  @Test fun save() {
    every { exchange.remoteAddress } returns "127.0.0.1"
    every { exchange.header("user-agent") } returns "User-Agent"

    val id = routes.save(compassAnswers, exchange)

    val saved = compassAnswers.copy(ipAddress = "127.0.0.1", userAgent = "User-Agent")
    expect(id).toEqual(saved.id)
    verify { repository.save(saved) }
  }
}
