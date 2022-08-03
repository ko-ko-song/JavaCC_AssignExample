package core;

import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.ValueExpression;

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
	public Object visit(ValueExpression valueExpression) {
		return valueExpression.getValue();
	}

}
