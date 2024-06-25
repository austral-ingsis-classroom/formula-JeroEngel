package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public class Literal implements Function {
  private final double value;

  public Literal(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitLiteral(this);
  }
}
