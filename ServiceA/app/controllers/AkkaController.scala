package controllers

import play.api.mvc._
import akka.actor._
import javax.inject._
import akka.pattern.ask
import scala.concurrent.duration._
import akka.util.Timeout
//import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.concurrent.Execution.Implicits._

@Singleton
class AkkaController @Inject()(
                                system: ActorSystem,
                                cc: ControllerComponents) extends AbstractController(cc) {

  import akka.HelloActor

  val helloActor = system.actorOf(Props[HelloActor], "hello-actor")

  def sayHello = Action.async {

    implicit val timeout = Timeout(5 seconds)
    val future = helloActor ? "hello"
    future.mapTo[String].map { message => Ok(message)}

  }

}