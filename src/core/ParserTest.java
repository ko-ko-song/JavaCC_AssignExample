package core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import expression.ASTExpression;
import expression.AssignExpression;
import expression.BaseVariableExpression;
import expression.ClassVariableExpression;
import model.Person;
import parser.AssignParser;
import parser.ParseException;


public class ParserTest {
	
	private AssignParser parser = null;
	
	public ASTExpression parseLine(String varString) {
		InputStream inputStream = new ByteArrayInputStream(varString.getBytes());
		try {
			if(parser == null) {
				parser = new AssignParser(inputStream);
			}
			else {
				parser.ReInit(inputStream);
			}
			ASTExpression varExpression = parser.one_line();
			return varExpression;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("return null");
		return null;
	}
	
	public static void main(String[] args) {
	
		ParserTest parserTest = new ParserTest();
		
		HashMap<String, Object> objects = new HashMap<>();
		
		Person person = new Person();
		person.setId("person001");
		person.setName("song");
		person.setAge(26);

		objects.put("person001", person);
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if(input.equals("exit")) 
				break;
			
			ASTExpression expression = parserTest.parseLine(input);
			
			Object object = null;
			
			if(expression instanceof AssignExpression) {
				ASTVisitor assignVisitor = new AssignVisitor(objects);
				object = expression.accept(assignVisitor);
			}
			else if(expression instanceof ClassVariableExpression| expression instanceof BaseVariableExpression){
				ASTVisitor varVisitor = new VariableVisitor(objects);
				object = expression.accept(varVisitor);
			}
			
			System.out.println(object);
		}
		
		
	}
	
}
