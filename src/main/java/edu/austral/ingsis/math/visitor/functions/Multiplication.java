package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Multiplication extends ComposeFunction {
  public Multiplication(Function first_argument, Function second_argument) {
    super(first_argument, second_argument);
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitMultiplication(this);
  }

  @Override
  String getOperator() {
    return "*";
  }
}
