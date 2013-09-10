package models

import play.api.data._
import play.api.data.Forms._

import models.DBTables._

object DBTableFroms {
  val KyokasyoFrom = Form(
    mapping(
      "kyokasyo_id" -> number,
      "kyokasyo_mei" -> text,
      "han_no" -> number,
      "kamoku_id" -> number)(Kyokasyo.apply)(Kyokasyo.unapply)
    )
}