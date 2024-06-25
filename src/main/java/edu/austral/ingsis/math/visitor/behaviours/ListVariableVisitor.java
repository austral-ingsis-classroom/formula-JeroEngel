package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Literal;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import java.util.ArrayList;
import java.util.List;

public class ListVariableVisitor implements Visitor<List<String>> {

  public List<String> getVariables(Function function) {
    return function.accept(this);
  }

  @Override
  public List<String> visitLiteral(Literal literal) {
    return List.of();
  }

  @Override
  public List<String> visitVariable(Variable variable) {
    return List.of(variable.getName());
  }

  @Override
  public List<String> visitSum(Sum addition) {
    List<String> first = new ArrayList<>(addition.getFirstArgument().accept(this));
    List<String> second = addition.getSecondArgument().accept(this);
    first.addAll(second);
    return first;
  }

  @Override
  public List<String> visitSubtract(Subtract subtraction) {
    List<String> first = new ArrayList<>(subtraction.getFirstArgument().accept(this));
    List<String> second = subtraction.getSecondArgument().accept(this);
    first.addAll(second);
    return first;
  }

  @Override
  public List<String> visitMultiplication(Multiplication multiplication) {
    List<String> first = new ArrayList<>(multiplication.getFirstArgument().accept(this));
    List<String> second = multiplication.getSecondArgument().accept(this);
    first.addAll(second);
    return first;
  }

  @Override
  public List<String> visitDivision(Division division) {
    List<String> first = new ArrayList<>(division.getFirstArgument().accept(this));
    List<String> second = division.getSecondArgument().accept(this);
    first.addAll(second);
    return first;
  }

  @Override
  public List<String> visitPower(Power power) {
    List<String> first = new ArrayList<>(power.getFirstArgument().accept(this));
    List<String> second = power.getSecondArgument().accept(this);
    first.addAll(second);
    return first;
  }

  @Override
  public List<String> visitModule(Module module) {
    return new ArrayList<>(module.getFunction().accept(this));
  }
}
