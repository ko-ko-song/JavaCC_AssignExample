package expression;

import core.ASTVisitor;

public class ValueExpression implements ASTExpression{

	public ValueExpression value;
	
	public ValueExpression() {
		value = null;
	}
	
	public ValueExpression(String s) {
		this.value = new ValueStringExpression(s);
	}

	public ValueExpression(int i) {
		this.value = new ValueStringExpression(i);
	}
	
	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}
}
