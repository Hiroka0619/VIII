package models

import play.api.db._
import models.DBTables.Kamoku

object Subjects {
  def readAll():List[Kamoku] = Kamoku.read("kamoku_id > 0")
  
  def readOne(kamoku_id: Int): Kamoku = Kamoku.read("kamoku_id = "+kamoku_id).head
  
  def create(kamoku_mei: String): Either[Throwable, Boolean] =
    if(Kamoku.insert(kamoku_mei) > 0) Right(true)
    else Left(new Exception("insert fail"))
  
  def update() {}
  def delete() {}
  
}