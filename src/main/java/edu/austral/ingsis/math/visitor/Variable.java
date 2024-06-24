package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Variable implements Function{
  private final String name;
  private final Double value;

  public Variable(String name, Double value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Double getValue() {
    return value;
  }
  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitVariable(this);
  }
}