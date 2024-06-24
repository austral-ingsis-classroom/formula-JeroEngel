package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Power extends ComposeFunction {
  public Power(Function first_argument, Function second_argument) {
    super(first_argument, second_argument);
  }
  @Override
  String getOperator() {
    return "^";
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitPower(this);
  }
}