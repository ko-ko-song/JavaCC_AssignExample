package expression;

import core.ASTVisitor;

public class ValueStringExpression extends ValueExpression implements ASTExpression{

	private String value;
	
	public ValueStringExpression(Object value) {
		this.value = (String)value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = (String)value;
	}

	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

}
