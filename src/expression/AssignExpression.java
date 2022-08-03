package expression;

import core.ASTVisitor;

public class AssignExpression implements ASTExpression{

	private ClassVariableExpression left;
	private ValueExpression right;
	
	public AssignExpression(ASTExpression left, ASTExpression right) {
		this.left = (ClassVariableExpression)left;
		this.right = (ValueExpression)right;
	}
	
	public ASTExpression left() {
		return left;
	}

	public ASTExpression right() {
		return right;
	}

	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}
	
}
