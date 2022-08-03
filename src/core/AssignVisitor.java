package core;

import java.lang.reflect.Field;
import java.util.Map;

import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import expression.OperatorExpression;
import expression.ValueExpression;
import expression.ValueIntegerExpression;
import expression.ValueStringExpression;

public class AssignVisitor implements ASTVisitor{

	private Map<String,Object> objects;
	
	public AssignVisitor(Map<String, Object> objects) {
		this.objects = objects;
	}
	
	@Override
	public Object visit(ClassVariableExpression classVarExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BaseVariableExpression baseVarExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignExpression assignExpression) {
		
		FormulaVisitor formulaVisitor = new FormulaVisitor(objects);
		Object value = assignExpression.right().accept(formulaVisitor);
		
		VariableVisitor varVisitor = new VariableVisitor(objects);
		ClassVariableExpression var = (ClassVariableExpression) assignExpression.left();
		
		String varIdentifier = var.getIdentifier();
		Object exVar = var.getVariableExpression().accept(varVisitor);
		Class clazz = exVar.getClass();
		
		try {
			Field field = clazz.getDeclaredField(varIdentifier);
			field.setAccessible(true);
			try {
				field.set(exVar, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return value;
	}

	@Override
	public Object visit(ValueIntegerExpression valueExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ValueStringExpression string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OperatorExpression operator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ValueExpression value) {
		// TODO Auto-generated method stub
		return null;
	}

}
