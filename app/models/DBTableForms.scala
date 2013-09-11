package models

import play.api.data._
import play.api.data.Forms._

import models.DBTables._

object DBTableForms {
  val KamokuForm = Form(
    mapping(
      "kamoku_id" -> number,
      "kamoku_mei" -> text
      )(Kamoku.apply)(Kamoku.unapply)
    )
  val KyokasyoFrom = Form(
    mapping(
      "kyokasyo_id" -> number,
      "kyokasyo_mei" -> text,
      "han_no" -> number,
      "kamoku_id" -> number)(Kyokasyo.apply)(Kyokasyo.unapply)
    )
}