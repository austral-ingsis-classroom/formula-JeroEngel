
package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {

  public Double evaluate(Function function) {
    return function.accept(this);
  }

  @Override
  public Double visitLiteral(Literal literal) {
    return literal.getValue();
  }

  @Override
  public Double visitVariable(Variable variable) {
    return variable.getValue();
  }

  @Override
  public Double visitSum(Sum addition) {
    return addition.getFirstArgument().accept(this) + addition.getSecondArgument().accept(this);
  }

  @Override
  public Double visitSubtract(Subtract subtraction) {
    return subtraction.getFirstArgument().accept(this) - subtraction.getSecondArgument().accept(this);
  }

  @Override
  public Double visitMultiplication(Multiplication multiplication) {
    return multiplication.getFirstArgument().accept(this) * multiplication.getSecondArgument().accept(this);
  }

  @Override
  public Double visitDivision(Division division) {
    return division.getFirstArgument().accept(this) / division.getSecondArgument().accept(this);
  }

  @Override
  public Double visitPower(Power power) {
    return Math.pow(power.getFirstArgument().accept(this), power.getSecondArgument().accept(this));
  }

  @Override
  public Double visitModule(Module module) {
    return module.getFunction().accept(this) > 0 ? module.getFunction().accept(this) : -module.getFunction().accept(this);
  }
}
