package ch.danirey.newtypes

/**
 * https://dotty.epfl.ch/docs/reference/new-types/union-types.html
 */
trait SwisspassIdentity {
  def swisspassId: String
}

trait ZvvIdentity {
  def zvvNr: String
}

trait LocalKeycloakIdentity {
  def username: String
}

def identify(identiy: SwisspassIdentity | ZvvIdentity | LocalKeycloakIdentity): Unit = {
  identiy match {
    case s: SwisspassIdentity => s.swisspassId
    case z: ZvvIdentity => z.zvvNr
    case k: LocalKeycloakIdentity => k.username
  }
}

