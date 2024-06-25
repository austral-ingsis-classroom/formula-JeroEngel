package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.behaviours.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.functions.Division;
import edu.austral.ingsis.math.visitor.functions.Module;
import edu.austral.ingsis.math.visitor.functions.Multiplication;
import edu.austral.ingsis.math.visitor.functions.Power;
import edu.austral.ingsis.math.visitor.functions.Sum;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Sum sum = new Sum(new Literal(1), new Literal(6));
    final Double result = evaluateVisitor.evaluate(sum);

    assertThat(result, equalTo(7d));
  }

  @Test
  public void shouldResolveSimpleFunction2() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Division div = new Division(new Literal(12), new Literal(2));
    final Double result = evaluateVisitor.evaluate(div);

    assertThat(result, equalTo(6d));
  }

  @Test
  public void shouldResolveSimpleFunction3() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Multiplication mult =
        new Multiplication(new Division(new Literal(9), new Literal(2)), new Literal(3));
    final Double result = evaluateVisitor.evaluate(mult);

    assertThat(result, equalTo(13.5d));
  }

  @Test
  public void shouldResolveSimpleFunction4() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Power pow = new Power(new Division(new Literal(27), new Literal(6)), new Literal(2));
    final Double result = evaluateVisitor.evaluate(pow);

    assertThat(result, equalTo(20.25d));
  }

  @Test
  public void shouldResolveSimpleFunction5() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Power pow = new Power(new Literal(36), new Division(new Literal(1), new Literal(2)));
    final Double result = evaluateVisitor.evaluate(pow);

    assertThat(result, equalTo(6d));
  }

  @Test
  public void shouldResolveSimpleFunction6() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Module mod = new Module(new Literal(136));
    final Double result = evaluateVisitor.evaluate(mod);

    assertThat(result, equalTo(136d));
  }

  @Test
  public void shouldResolveSimpleFunction7() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Module mod = new Module(new Literal(-136));
    final Double result = evaluateVisitor.evaluate(mod);

    assertThat(result, equalTo(136d));
  }

  @Test
  public void shouldResolveSimpleFunction8() {
    EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
    final Multiplication mult =
        new Multiplication(new Sum(new Literal(5), new Literal(-5)), new Literal(8));
    final Double result = evaluateVisitor.evaluate(mult);

    assertThat(result, equalTo(0d));
  }
}
