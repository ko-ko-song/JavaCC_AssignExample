package expression;

import core.ASTVisitor;

public class OperatorExpression implements ASTExpression{

	private ASTExpression left;
	private ASTExpression right;
	private int operator;
	
	public static final int PLUS = 0; 
	public static final int MINUS = 1;
	public static final int MULTIPLE = 2;
	public static final int DIVIDE = 3;
	
	public OperatorExpression(ASTExpression left, ASTExpression right, int operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}
	
	public OperatorExpression(ASTExpression left, ASTExpression right, String operator) {
		this.left = left;
		this.right = right;
		
		switch(operator) {
			case "+":
				this.operator = PLUS;
				break;
			case "-":
				this.operator = MINUS;
				break;
			case "*":
				this.operator = MULTIPLE;
				break;
			case "/":
				this.operator = DIVIDE;
				break;
			default :
				break;
		}
	}
	
	public ASTExpression left() {
		return this.left;
	}
	
	public ASTExpression right() {
		return this.right;
	}
	
	public int operator() {
		return this.operator;
	}
	
	@Override
	public Object accept(ASTVisitor visitor) {
		return visitor.visit(this);
	}

}
