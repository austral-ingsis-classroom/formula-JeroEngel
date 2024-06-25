package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Module implements Function {
  private final Function function;

  public Module(Function function) {
    this.function = function;
  }

  public Function getFunction() {
    return function;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitModule(this);
  }
}
