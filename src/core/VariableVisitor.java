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


public class VariableVisitor implements ASTVisitor{

	private Map<String, Object> objects;
	
	public VariableVisitor(Map<String, Object> objects) {
		this.objects = objects;
	}
	
	@Override
	public Object visit(ClassVariableExpression varExpression) {
		Object object = varExpression.getVariableExpression().accept(this);
		String identifier = varExpression.getIdentifier();
		
		Class clazz = object.getClass();
		Field clazzField = null;
		Object objectField = null;
		try {
			clazzField = clazz.getDeclaredField(identifier);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			clazzField.setAccessible(true);
			objectField	= clazzField.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objectField;
	}

	@Override
	public Object visit(BaseVariableExpression baseVarExpression) {
		String id = baseVarExpression.getIdentifier();
		Object baseVarObject = objects.get(id);
		return baseVarObject;
	}

	@Override
	public Object visit(AssignExpression expression) {
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
	public Object visit(ValueIntegerExpression integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ValueExpression value) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
