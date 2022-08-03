package core;

import java.util.Map;

import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.OperatorExpression;
import expression.ValueExpression;
import expression.ValueIntegerExpression;
import expression.ValueStringExpression;

public class FormulaVisitor implements ASTVisitor{

	private Map<String,Object> objects;
	
	public FormulaVisitor(Map<String,Object> objects) {
		this.objects = objects;
	}
	
	@Override
	public Object visit(OperatorExpression operator) {
		Object leftValue =	operator.left().accept(this);
		Object rightValue = operator.right().accept(this);
		
		if(leftValue instanceof String|| rightValue instanceof String) {
			if(operator.operator() == OperatorExpression.PLUS) {
				return leftValue.toString() + rightValue.toString();
			}
		}
		else {
			switch(operator.operator()) {
			case OperatorExpression.PLUS:
				return (int)leftValue + (int)rightValue;
				
			case OperatorExpression.MINUS:
				return (int)leftValue - (int)rightValue;
				
			case OperatorExpression.MULTIPLE:
				return (int)leftValue * (int)rightValue;
				
			case OperatorExpression.DIVIDE:
				return (int)leftValue / (int)rightValue;
				
			default:
				return null;
			}
		}
		return null;
	}

	@Override
	public Object visit(ClassVariableExpression classVarExpression) {
		VariableVisitor varVisitor = new VariableVisitor(objects);
		return classVarExpression.accept(varVisitor);
	}

	@Override
	public Object visit(BaseVariableExpression baseVarExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignExpression assignExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ValueIntegerExpression integer) {
		return integer.getValue();
	}

	@Override
	public Object visit(ValueStringExpression string) {
		return string.getValue();
	}

	@Override
	public Object visit(ValueExpression value) {
		return null;
	}


}
