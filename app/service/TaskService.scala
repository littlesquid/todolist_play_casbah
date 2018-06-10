package service

import javax.inject.Inject
import model.TaskData
import play.api.MarkerContext
import repository.TaskRepositoryImpl
import v1.post.PostData

import scala.concurrent.{ExecutionContext, Future}

class TaskService @Inject()(taskRepo:TaskRepositoryImpl)(implicit ec: ExecutionContext){
  def find(implicit mc: MarkerContext) = {
    taskRepo.list()
  }

  private def createPostResource(p: TaskData): TaskData = {
    TaskData(p.id, p.title, p.body)
  }
}
