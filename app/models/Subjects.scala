package models

import models.DBTables.Kamoku

object Subjects {
  def readAll():List[Kamoku] = Kamoku.readAll()
  
  def readOne(kamoku_id: Int): Kamoku = Kamoku.read(kamoku_id.toString).head
  
  def create(kamoku_mei: String): Either[Throwable, Boolean] =
    if(Kamoku.insert(kamoku_mei) > 0) Right(true)
    else Left(new Exception("insert fail"))
  
  def update() {}
  def delete() {}
  
}