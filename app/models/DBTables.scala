package models

import play.api.Play.current
//import play.api.db._
import play.api.db.DB
import anorm._
import anorm.SqlParser._

object DBTables {
  case class Kyokasyo(kyokasyo_id: Int, kyokasyo_mei: String,
    han_no: Int, kamoku_id: Int)
  case class Kamoku(kamoku_id: Int, kamoku_mei: String)
  case class Sho(kyokasyo_id: Int, sho_mei: String)
  case class Tangen(kyokasyo_id: Int, tangen_mei: String)
  case class Contents(kyokasyo_id: Int, page: Int, title: String,
    content: String, point: String, tags: String)

  object Kyokasyo {
    val parseKyokasyo = {
      get[Int]("kyokasyo_id")~
      get[String]("kyokasyo_mei")~
      get[Int]("han_no")~
      get[Int]("kamoku_id") map {
        case kyokasyo_id~kyokasyo_mei~han_no~kamoku_id =>
          Kyokasyo(kyokasyo_id, kyokasyo_mei, han_no, kamoku_id)
      }
    }
    def getKyokasyo(target: String, query: String) :List[Kyokasyo] = {
      var kyokasyo_list: List[Kyokasyo] = List.empty
      DB.withConnection { implicit conn =>
        kyokasyo_list = SQL("SELECT {target} FROM kyokasyo WHERE {qyery}")
          .on("target" -> target, "query" -> query)
          .as(parseKyokasyo*).toList//ORDER BY hoge
        kyokasyo_list
      }
    }
  }
  object Kamoku{
    val parseKamoku = {
      get[Int]("kamoku_id")~
      get[String]("kamoku_mei") map {
        case kamoku_id~kamoku_mei => Kamoku(kamoku_id, kamoku_mei)
      }
    }
  }
}
