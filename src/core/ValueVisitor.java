package core;

import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.OperatorExpression;
import expression.ValueExpression;
import expression.ValueIntegerExpression;
import expression.ValueStringExpression;

public class ValueVisitor implements ASTVisitor{

	@Override
	public Object visit(ClassVariableExpression classVarExpression) {
		// TODO Auto-generated method stub
		return null;
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
	public Object visit(ValueIntegerExpression valueExpression) {
		return valueExpression.getValue();
	}

	@Override
	public Object visit(ValueStringExpression string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OperatorExpression operator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ValueExpression value) {
		// TODO Auto-generated method stub
		return null;
	}

}
