package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Division extends ComposeFunction {
  public Division(Function first_argument, Function second_argument) {
    super(first_argument, second_argument);
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitDivision(this);
  }

  @Override
  String getOperator() {
    return "/";
  }
}
