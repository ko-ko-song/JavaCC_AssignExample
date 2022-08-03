package expression;

import core.ASTVisitor;

public class ValueExpression implements ASTExpression{

	private Object value;
	
	public ValueExpression(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

}
