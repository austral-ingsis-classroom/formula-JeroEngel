
package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;

public class PrinterVisitor implements Visitor<String> {

  public String print(Function function) {
    return function.accept(this);
  }
  @Override
  public String visitLiteral(Literal literal) {
    return String.valueOf(literal.getValue());
  }

  @Override
  public String visitVariable(Variable variable) {
    return variable.getName();
  }

  @Override
  public String visitSum(Sum addition) {
    return "( " + addition.getFirstArgument().accept(this) + " + " + addition.getSecondArgument().accept(this) + " )";
  }

  @Override
  public String visitSubtract(Subtract subtraction) {
    return "( " + subtraction.getFirstArgument().accept(this) + " - " + subtraction.getSecondArgument().accept(this) + " )";
  }

  @Override
  public String visitMultiplication(Multiplication multiplication) {
    return "( " + multiplication.getFirstArgument().accept(this) + " * " + multiplication.getSecondArgument().accept(this) + " )";
  }

  @Override
  public String visitDivision(Division division) {
    return "( " + division.getFirstArgument().accept(this) + " / " + division.getSecondArgument().accept(this) + " )";
  }

  @Override
  public String visitPower(Power power) {
    return "( " + power.getFirstArgument().accept(this) + " ^ " + power.getSecondArgument().accept(this) + " )";
  }

  @Override
  public String visitModule(Module module) {
    return "|" + module.getFunction().accept(this) + "|";
  }
}
