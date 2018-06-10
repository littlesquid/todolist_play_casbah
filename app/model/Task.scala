package model

import com.mongodb.casbah.commons.MongoDBList
import play.api.libs.json._

case class TaskData(
                 id: Int,
                 title: String,
                 body: String
               )


object TaskData{
  implicit object TaskFormat extends Format[TaskData]{
    def writes(task: TaskData):JsValue ={
      val taskSeq = Seq(
        "id" -> JsNumber(task.id),
        "title" -> JsString(task.title),
        "body" -> JsString(task.body)
      )
      JsObject(taskSeq)
    }

    def reads(json: JsValue): JsResult[TaskData] ={
      JsSuccess(TaskData(0,"",""))
    }
  }
  implicit val taskWrites = new Writes[TaskData] {
    override def writes(o: TaskData): JsValue = Json.obj(
      "id" -> o.id,
      "title" -> o.title,
      "body" -> o.body
    )
  }

  def writesTaskData(taskData: TaskData)={
    taskWrites.writes(taskData)
  }

}





