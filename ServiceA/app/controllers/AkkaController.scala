package controllers

import play.api.mvc._
import akka.actor._
import javax.inject._
import akka.pattern.ask

import scala.concurrent.duration._
import akka.util.Timeout

import scala.concurrent.ExecutionContext

@Singleton
class AkkaController @Inject()(
                                system: ActorSystem,
                                cc: ControllerComponents) (implicit ec: ExecutionContext) extends AbstractController(cc) {

  import akka.actor.HelloActor._

  val helloActor = system.actorOf(Props[HelloActor], "hello-actor")

  /*

   */
  def sayHello(name: String) = Action.async {

    implicit val timeout = Timeout(5 seconds)
    val future = helloActor ? SayHello(name)
    future.mapTo[String].map { message => Ok(message)}

  }

}