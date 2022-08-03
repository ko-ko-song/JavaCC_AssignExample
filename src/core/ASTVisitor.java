package core;

import expression.OperatorExpression;
import expression.ValueExpression;
import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.ValueIntegerExpression;
import expression.ValueStringExpression;

public interface ASTVisitor {
	Object visit(ClassVariableExpression classVar);
	Object visit(BaseVariableExpression baseVar);
	Object visit(AssignExpression assign);
	Object visit(ValueIntegerExpression integer);
	Object visit(ValueStringExpression string);
	Object visit(OperatorExpression operator);
	Object visit(ValueExpression value);
}
