package models

import play.api.Play.current
import scalikejdbc._
import com.typesafe.config._

trait DBConn {
  val appConf = ConfigFactory.load()
  val dbUrl = appConf.getString("db.default.url")
  val driverName = appConf.getString("db.default.driver")
  val dbUser = appConf.getString("db.default.user")
  val dbPassword = appConf.getString("db.default.password")
  
  Class.forName("com.mysql.jdbc.Driver")
  ConnectionPool.singleton(dbUrl, dbUser, dbPassword)
}

object DBTables {
  case class Kyokasyo(kyokasyo_id: Int, kyokasyo_mei: String,
    han_no: Int, kamoku_id: Int)
  case class Kamoku(kamoku_id: Int, kamoku_mei: String)
  case class Sho(kyokasyo_id: Int, sho_mei: String)
  case class Tangen(kyokasyo_id: Int, tangen_mei: String)
  case class Contents(kyokasyo_id: Int, page: Int, title: String,
    content: String, point: String, tags: String)
  
  object Kamoku extends DBConn {
    val * = (rs: WrappedResultSet) => Kamoku(
      rs.int("kamoku_id"),
      rs.string("kamoku_mei"))
    val read = (query: String) => DB readOnly { implicit session => 
      SQL("SELECT * FROM kamoku WHERE kamoku_id = ?").bind(query).map(*).list.apply()
    }
    val readAll = () => DB readOnly { implicit session => 
      SQL("SELECT * FROM kamoku").map(*).list.apply()
    }
    val insert = (kamoku_mei: String) => DB autoCommit { implicit session =>
      SQL("INSERT INTO kamoku (kamoku_mei) VALUES (?)").bind(kamoku_mei).update.apply()
    }
  }
  
  object Kyokasyo extends DBConn {
    val * = (rs: WrappedResultSet) => Kyokasyo(
      rs.int("kyokasyo_id"),
      rs.string("kyokasyo_mei"),
      rs.int("han_no"),
      rs.int("kamoku_id"))
    val read = (target: String, query: String) => DB readOnly { implicit session => 
      SQL("SELECT ? FROM kyokasyo WHERE ?").bind(target, query).map(*).list.apply()
    }
  }
}
