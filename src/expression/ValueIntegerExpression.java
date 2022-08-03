package expression;

import core.ASTVisitor;

public class ValueIntegerExpression extends ValueExpression implements ASTExpression{

	private int value;
	
	public ValueIntegerExpression(Object value) {
		this.value = (int)value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = (int)value;
	}

	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

}
