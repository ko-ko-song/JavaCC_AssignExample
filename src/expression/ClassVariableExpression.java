package expression;

import core.ASTVisitor;

public class ClassVariableExpression implements ASTExpression{

	private ASTExpression	 	variableExpression;
	private String				identifier;
	
	public ClassVariableExpression(ASTExpression variableExpression, String identifier) {
		this.variableExpression = variableExpression;
		this.identifier = identifier;
	}
	
	public ASTExpression getVariableExpression() {
		return variableExpression;
	}

	public void setVariableExpression(ASTExpression variableExpression) {
		this.variableExpression = variableExpression;
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
