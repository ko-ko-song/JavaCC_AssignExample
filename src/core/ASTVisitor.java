package core;

import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.ValueExpression;

public interface ASTVisitor {
	Object visit(ClassVariableExpression classVarExpression);
	Object visit(BaseVariableExpression baseVarExpression);
	Object visit(AssignExpression assignExpression);
	Object visit(ValueExpression valueExpression);
}
