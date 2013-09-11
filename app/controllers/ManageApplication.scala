package controllers

import play.api._
import play.api.mvc._

object ManageApplication extends Controller {
  
  def top = Action { implicit req =>
    Ok(views.html.manage.top())
  }
  
  def subjects = Action { implicit req =>
    Ok(views.html.manage.subjects())
  }
  
  def textbooks = TODO
  
}