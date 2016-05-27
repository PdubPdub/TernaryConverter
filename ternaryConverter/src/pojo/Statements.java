package pojo;

public class Statements {

	private String converted = null;
	private String outputCmd = "System.out";
	private String formated = null;
	private String result = null;
	
	public String converter (String input){
		
		//String condition = input.replaceAll("^[^\\(]+","");
		String condition = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
	
		String conditionRemoved = input.replace("(" + condition + ")", "");
		System.out.println(conditionRemoved);
		String ifOut = input.substring(input.indexOf("{") + 1, input.indexOf("}"));
		
		String ifOutRemoved = conditionRemoved.replace("{" + ifOut + "}", "");
		String elseRemoved = ifOutRemoved.replace("else", "");
		
		String elseOut = ifOutRemoved.substring(ifOutRemoved.indexOf("{") + 1, ifOutRemoved.indexOf("}"));
		
		String varName = null;
		String cmdName = null;
		
		String varIfAssign = null;
		String varElseAssign = null;
		String cmdIfOut = null;
		String cmdElseOut = null;
		
		int dog = 0;
		String test = null;
		//String elseOut = elseRemoved.substring(input.indexOf("{") + 1, input.indexOf("}"));
		//condition = condition.replaceAll("^[^\\{]+","");
		//condition = condition.replaceAll("[^\\)]+$", "");

		ifOut = ifOut.replace(";", "");
		ifOut = ifOut.trim();
		
		elseOut = elseOut.replace(";", "");
		elseOut = elseOut.trim();
		
		//System.out.println((test < 4) ? "Retard" : "Monkey");

		//StringBuilder sb = new StringBuilder(condition + ifOut + elseOut);
		int x = 0;
		dog = (x < 20) ? 1 : 2;
		//dog = (test == null) ? "woof" : "wookie";
		char charEnd = ifOut.charAt(ifOut.length() - 1);
		
		System.out.println(charEnd);
		
		
		System.out.print( x < 20 ? "This is if statement" : "This is else statement");
		
		if(ifOut.contains(outputCmd) && elseOut.contains(outputCmd)){
			
			//result = "System.out type";
			
			int parenth = ifOut.indexOf("(");
			
			cmdName = ifOut.substring(0, parenth);
			
			cmdIfOut = ifOut.substring(parenth + 1, ifOut.length() - 1);
			cmdElseOut = elseOut.substring(parenth + 1, elseOut.length() - 1);
			
			StringBuilder sbIf = new StringBuilder(cmdName + "(" + condition + " ? " + cmdIfOut + " : " + cmdElseOut + ");");
			
			result = sbIf.toString();
		
		}else if(ifOut.charAt(ifOut.length() - 1) == '"' || ifOut.charAt(ifOut.length() - 1) == '\'' 
				|| Character.isDigit(ifOut.charAt(ifOut.length() - 1)) ){
			
			int operator = ifOut.indexOf("=");
			
			if(operator != -1){
				varName = ifOut.substring(0, operator);
				varName = varName.trim();
				
				varIfAssign = ifOut.substring(operator + 1, ifOut.length());
				//varIfAssign = varIfAssign.trim();
				
				varElseAssign = elseOut.substring(operator + 1, elseOut.length());
				//varElseAssign = varElseAssign.trim();	
			}
			
			StringBuilder sbElse = new StringBuilder(varName + " = " + "(" + condition + ")" 
			+ " ? " + varIfAssign + " : " + varElseAssign + ";");
			
			result = sbElse.toString();
		}	
		return result;
	}
	
}