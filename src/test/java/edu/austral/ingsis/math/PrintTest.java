package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.behaviours.PrinterVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintTest {

  private PrinterVisitor printVisitor;

  @BeforeEach
  public void setUp() {
    printVisitor = new PrinterVisitor();
  }

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "( 1.0 + 6.0 )";
    final Sum sum = new Sum(new Literal(1), new Literal(6));
    final String result = sum.accept(printVisitor);

    assertThat(result, equalTo(expected));
  }

  @Test
  public void shouldPrintFunction2() {
    final String expected = "( 12.0 / 2.0 )";
    final Division div = new Division(new Literal(12), new Literal(2));
    final String result = div.accept(printVisitor);

    assertThat(result, equalTo(expected));
  }

  @Test
  public void shouldPrintFunction3() {
    final String expected = "( ( 9.0 / 2.0 ) * 3.0 )";
    final Multiplication mult = new Multiplication(new Division(new Literal(9), new Literal(2)), new Literal(3));
    final String result = mult.accept(printVisitor);

    assertThat(result, equalTo(expected));
  }

  @Test
  public void shouldPrintFunction4() {
    final String expected = "( ( 27.0 / 6.0 ) ^ 2.0 )";
    final Power pow = new Power(new Division(new Literal(27), new Literal(6)), new Literal(2));
    final String result = pow.accept(printVisitor);

    assertThat(result, equalTo(expected));
  }

  @Test
public void shouldPrintFunction6() {
  final String expected = "( |value| - -8.0 )"; // changed from "( |value| - 8.0 )"
  final Subtract sub = new Subtract(new Module(new Variable("value",1.0)), new Literal(-8));
  final String result = sub.accept(printVisitor);

  assertThat(result, equalTo(expected));
}

  @Test
  public void shouldPrintFunction8() {
    final String expected = "( ( 5.0 - i ) * 8.0 )";
    final Multiplication mult = new Multiplication(new Subtract(new Literal(5), new Variable("i",1.0)), new Literal(8));
    final String result = mult.accept(printVisitor);

    assertThat(result, equalTo(expected));
  }
}