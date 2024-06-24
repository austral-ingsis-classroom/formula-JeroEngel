package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.Visitor;

public interface Function {
  <T> T accept(Visitor<T> visitor);
}