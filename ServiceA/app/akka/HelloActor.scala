package akka

import akka.actor.Actor

class HelloActor extends Actor {

  override def receive: Receive = {
    case "hello" => sender() ! "hello world from Akka"
  }

}
