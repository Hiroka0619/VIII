package models

import play.api.data._
import play.api.data.Forms._

case class SearchOption(
    kamoku_id: Option[Int],
    kyokasyo_id: Option[Int],
    page_start: Option[Int],
    page_end: Option[Int],
    tag: Option[String],
    freeword: Option[String]
    )

object SearchOption {
  val SearchOptionForm = Form(
    mapping(
      "kamoku_id" -> optional(number),
      "kyokasyo_id" -> optional(number),
      "page_start" -> optional(number),
      "page_end" -> optional(number),
      "tag" -> optional(text),
      "freeword" -> optional(text)
    )(SearchOption.apply)(SearchOption.unapply)
  )
}