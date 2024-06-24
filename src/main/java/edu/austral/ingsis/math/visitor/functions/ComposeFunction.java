package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;

public abstract class ComposeFunction implements Function {
  private final Function first_argument;
  private final Function second_argument;

  public ComposeFunction(Function first_argument, Function second_argument) {
    this.first_argument = first_argument;
    this.second_argument = second_argument;
  }

  public Function getFirstArgument() {
    return first_argument;
  }

  public Function getSecondArgument() {
    return second_argument;
  }

  abstract String getOperator();
}