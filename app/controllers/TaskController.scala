package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import service.TaskService

import scala.concurrent.ExecutionContext

class TaskController @Inject()(cc: ControllerComponents,taskService: TaskService)(implicit ec: ExecutionContext) extends AbstractController(cc) {
  def index = Action{
    val list = taskService.find
    Ok("Test")
  }
}
