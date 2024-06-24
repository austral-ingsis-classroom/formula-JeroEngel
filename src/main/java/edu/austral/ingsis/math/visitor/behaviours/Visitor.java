package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;

public interface Visitor<T> {
  T visitLiteral(Literal literal);
  T visitVariable(Variable variable);
  T visitSum(Sum addition);
  T visitSubtract(Subtract subtraction);
  T visitMultiplication(Multiplication multiplication);
  T visitDivision(Division division);
  T visitPower(Power power);
  T visitModule(Module module);
}