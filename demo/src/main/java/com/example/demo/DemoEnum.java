package com.example.demo;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;





interface StringOperation {
    String getDescription();
    String apply(String input);
}

interface Operator{
	String apply(String input);
}

public class DemoEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoEnum demo = new DemoEnum();
		Arrays.stream(BasicStringOperation.class.getEnumConstants()).forEach(System.out::println);
		
		System.out.println(demo.getOperationDescription(BasicStringOperation.TO_UPPER));
		System.out.println(demo.applyOperation(BasicStringOperation.TO_UPPER,"ashwini"));
		
		SampleEnumMap mp = new SampleEnumMap();
		System.out.println(mp.apply(ImmutableOperation.INVERT_CASE, "sRIHAN"));
	}
	
	public String getOperationDescription(StringOperation stringOperation) {
        return stringOperation.getDescription();
    }
	
	public String applyOperation(StringOperation op, String str) {
		return op.apply(str);
	}
	
	

}



enum BasicStringOperation implements StringOperation{
	TRIM("Removing leading and trailing spaces."){
		@Override
		public String apply(String input) {
			// TODO Auto-generated method stub
			return input.trim();
		}
	},
    TO_UPPER("Changing all characters into upper case."){
		@Override
		public String apply(String input) {
			// TODO Auto-generated method stub
			return input.toUpperCase();
		}
	},
    REVERSE("Reversing the given string."){
		@Override
		public String apply(String input) {
			// TODO Auto-generated method stub
			return new StringBuilder(input).reverse().toString();
		}
	};

	private String description;
    // constructor and getter override
	
    BasicStringOperation(String string) {
		// TODO Auto-generated constructor stub
    	description=string;
	}
    
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	
	

}

//Extending an Enum Without Changing the Code, use EnumMap
enum ImmutableOperation {
    REMOVE_WHITESPACES, TO_LOWER, INVERT_CASE
}

class SampleEnumMap{
	private static final Map<ImmutableOperation,Operator> operationMap; 
	
	static {
		operationMap = new EnumMap<>(ImmutableOperation.class);
		operationMap.put(ImmutableOperation.REMOVE_WHITESPACES,input -> input.replaceAll("\\s", ""));
		operationMap.put(ImmutableOperation.INVERT_CASE,StringUtils::swapCase );
		operationMap.put(ImmutableOperation.TO_LOWER, String::toLowerCase);
		
		//validate Enum
		if( Arrays.stream(ImmutableOperation.values())
				.anyMatch( it->!operationMap.containsKey(it) )
				)
				throw new IllegalStateException("Unmapped enum constant found!");
			
		
	}
	
	public String apply(ImmutableOperation opr,String str) {
		return operationMap.get(opr).apply(str);
	}
}


