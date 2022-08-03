package expression;

import core.ASTVisitor;

public class BaseVariableExpression implements ASTExpression{
	
	private String identifier;
	
	public BaseVariableExpression(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}
	
}
