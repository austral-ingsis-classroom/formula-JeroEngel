package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;

import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.behaviours.ListVariableVisitor;
import edu.austral.ingsis.math.visitor.functions.Module;
import edu.austral.ingsis.math.visitor.functions.Sum;
import edu.austral.ingsis.math.visitor.functions.Division;
import edu.austral.ingsis.math.visitor.functions.Multiplication;
import edu.austral.ingsis.math.visitor.functions.Power;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  private ListVariableVisitor listVariableVisitor;

  @BeforeEach
  public void setUp() {
    listVariableVisitor = new ListVariableVisitor();
  }

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Sum sum = new Sum(new Literal(1), new Literal(6));
    List<String> result = sum.accept(listVariableVisitor);
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Division div = new Division(new Literal(12), new Variable("div", 1.0));
    List<String> result = div.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Multiplication mult = new Multiplication(new Division(new Literal(9), new Variable("x", 1.0)), new Variable("y",1.0));
    List<String> result = mult.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Power pow = new Power(new Division(new Literal(27), new Variable("a", 1.0)), new Variable("b",1.0));
    List<String> result = pow.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Power pow = new Power(new Variable("z",1.0), new Division(new Literal(1), new Literal(2)));
    List<String> result = pow.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Sum sum = new Sum(new Module(new Variable("value",1.0)), new Literal(-8));
    List<String> result = sum.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Multiplication mult = new Multiplication(new Sum(new Literal(5), new Variable("i",1.0)), new Literal(8));
    List<String> result = mult.accept(listVariableVisitor);
    assertThat(result, containsInAnyOrder("i"));
  }
}