package akka.actor

import akka.actor.HelloActor._

/*
Companion Object
 */
object HelloActor {
  case class SayHello(name: String)
}

class HelloActor extends Actor {

  override def receive: Receive = {
    case SayHello(name: String)  => sender() ! s"hello world from $name"
  }

}
