import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
object SerializeBool extends App{

  sealed trait BooleanExpression
  case object True extends BooleanExpression
  case object False extends BooleanExpression
  case class Variable(symbol: String) extends BooleanExpression
  case class Not(e: BooleanExpression) extends BooleanExpression
  case class Or(e1: BooleanExpression, e2: BooleanExpression) extends BooleanExpression
  case class And(e1: BooleanExpression, e2: BooleanExpression) extends BooleanExpression


  /* encode for BooleanExpression to JSON */

  def jsonEncode(expression: BooleanExpression): String = {
    expression.asJson.noSpaces
  }


  /* decode for JSON to BooleanExpression*/

  def jsonDecode(json: String): Either[io.circe.Error, SerializeBool.BooleanExpression] = {
    decode[BooleanExpression](json)
  }
}

