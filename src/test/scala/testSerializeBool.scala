import org.scalatest.FunSuite

class testSerializeBool extends FunSuite{

  /* test for True */

  var trueJson = "{\"True\":{}}";
  test("SerializeBool.jsonEncode for True") {
    assert(SerializeBool.jsonEncode(SerializeBool.True) ===  trueJson)
  }
  test("SerializeBool.jsonDecode for True") {
    assert(SerializeBool.jsonDecode((trueJson)).toString === "Right(True)")
  }
  test("Integration test for True") {
    var json = SerializeBool.jsonEncode(SerializeBool.True)
    assert(SerializeBool.jsonDecode((json)).toString === "Right(True)")
  }

  /* test for False */

  var falseJson = "{\"False\":{}}";
  test("SerializeBool.jsonEncode for False") {
    assert(SerializeBool.jsonEncode(SerializeBool.False) ===  falseJson)
  }
  test("SerializeBool.jsonDecode for False") {
    assert(SerializeBool.jsonDecode((falseJson)).toString === "Right(False)")
  }
  test("Integration test for False") {
    var json = SerializeBool.jsonEncode(SerializeBool.False)
    assert(SerializeBool.jsonDecode((json)).toString === "Right(False)")
  }

  /* test for Vairable */

  var variableJson = "{\"Variable\":{\"symbol\":\"True\"}}"
  test("SerializeBool.jsonEncode for Variable") {
    assert(SerializeBool.jsonEncode(SerializeBool.Variable("True")) ===  variableJson)
  }
  test("SerializeBool.jsonDecode for Variable") {
    assert(SerializeBool.jsonDecode((variableJson)).toString === "Right(Variable(True))")
  }
  test("Integration test for Variable") {
    var json = SerializeBool.jsonEncode(SerializeBool.Variable("True"))
    assert(SerializeBool.jsonDecode((json)).toString === "Right(Variable(True))")
  }

  /* test for Not */

  var notJson = "{\"Not\":{\"e\":{\"True\":{}}}}";
  test("SerializeBool.jsonEncode for Not") {
    assert(SerializeBool.jsonEncode(SerializeBool.Not(SerializeBool.True)) ===  notJson)
  }
  test("SerializeBool.jsonDecode for Not") {
    assert(SerializeBool.jsonDecode((notJson)).toString === "Right(Not(True))")
  }
  test("Integration test for Not") {
    var json = SerializeBool.jsonEncode(SerializeBool.Not(SerializeBool.True));
    assert(SerializeBool.jsonDecode((json)).toString === "Right(Not(True))")
  }

  /* test for Or */

  var orJson = "{\"Or\":{\"e1\":{\"True\":{}},\"e2\":{\"True\":{}}}}"
  test("SerializeBool.jsonEncode for Or") {
    assert(SerializeBool.jsonEncode(SerializeBool.Or(SerializeBool.True, SerializeBool.True)) ===  orJson)
  }
  test("SerializeBool.jsonDecode for Or") {
    assert(SerializeBool.jsonDecode((orJson)).toString === "Right(Or(True,True))")
  }
  test("Integration test for Or") {
    var json = SerializeBool.jsonEncode(SerializeBool.Or(SerializeBool.True, SerializeBool.True))
    assert(SerializeBool.jsonDecode((json)).toString === "Right(Or(True,True))")
  }

  /* test for And */

  var andJson = "{\"And\":{\"e1\":{\"True\":{}},\"e2\":{\"True\":{}}}}"
  test("SerializeBool.jsonEncode for And") {
    assert(SerializeBool.jsonEncode(SerializeBool.And(SerializeBool.True, SerializeBool.True)) ===  andJson)
  }
  test("SerializeBool.jsonDecode for And") {
    assert(SerializeBool.jsonDecode((andJson)).toString === "Right(And(True,True))")
  }
  test("Integration test for And") {
    var json = SerializeBool.jsonEncode(SerializeBool.And(SerializeBool.True, SerializeBool.True))
    assert(SerializeBool.jsonDecode((json)).toString === "Right(And(True,True))")
  }

}
