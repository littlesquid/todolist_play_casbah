package repository

import akka.actor.ActorSystem
import com.mongodb.casbah.Imports._
import javax.inject.{Inject, Singleton}
import model.TaskData
import play.api.MarkerContext
import play.api.libs.concurrent.CustomExecutionContext
import spray.json.JsString

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class TaskRepositoryImpl @Inject()()(implicit ec: ExecutionContext) {
  private implicit def buildJsonString(list: List[DBObject]): String =
    list.mkString(",")

  val taskList = List(
    TaskData(1,"test","test"),
    TaskData(2,"test","test"),
    TaskData(3,"test","test")
  )
  def create(data: TaskData)(implicit mc: MarkerContext): Future[Int] = ???

  def list()(implicit mc: MarkerContext) = {

    val mongoConn = MongoConnection()
    val mongoColl = mongoConn("todolist")("task").find.toList
    println(mongoColl)
    mongoColl
  }

  def get(id: Int)(implicit mc: MarkerContext): Future[Option[TaskData]] = ???
}


