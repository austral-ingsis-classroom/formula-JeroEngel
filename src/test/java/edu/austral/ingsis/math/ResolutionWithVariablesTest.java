package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.behaviours.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function sum = new Sum(new Literal(1), new Variable("x", 3d));
    final Double result = evaluateVisitor.evaluate(sum);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function div = new Division(new Literal(12), new Variable("div", 4d));
    final Double result = evaluateVisitor.evaluate(div);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function mult =
        new Multiplication(
            new Division(new Literal(9), new Variable("x", 3d)), new Variable("y", 4d));
    final Double result = evaluateVisitor.evaluate(mult);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function pow =
        new Power(new Division(new Literal(27), new Variable("a", 9d)), new Variable("b", 3d));
    final Double result = evaluateVisitor.evaluate(pow);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function pow = new Power(new Variable("z", 36d), new Division(new Literal(1), new Literal(2)));
    final Double result = evaluateVisitor.evaluate(pow);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function sub = new Subtract(new Module(new Variable("value", 8d)), new Literal(8));
    final Double result = evaluateVisitor.evaluate(sub);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = -8 */
  @Test
  public void shouldResolveFunction7() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function sub =
        new Subtract(
            new edu.austral.ingsis.math.visitor.functions.Module(new Variable("value", -8d)),
            new Literal(8));
    final Double result = evaluateVisitor.evaluate(sub);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    Function mult =
        new Multiplication(new Subtract(new Literal(5), new Variable("i", 2d)), new Literal(8));
    final Double result = evaluateVisitor.evaluate(mult);

    assertThat(result, equalTo(24d));
  }
}
