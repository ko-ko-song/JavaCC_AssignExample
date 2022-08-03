package expression;

import core.ASTVisitor;

public interface ASTExpression {
	Object accept(ASTVisitor visitor);
}
