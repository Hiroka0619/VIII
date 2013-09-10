package controllers

import play.api._
import play.api.mvc._

import models._
import models.SearchOption

object Application extends Controller {
  
  def main = Action { implicit req =>
    val search_form = SearchOption.SearchOptionForm
    Ok(views.html.main(search_form))
  }
  
  def search = TODO
}