package interview;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Test5 {

	public static void main(String[] args) {

		List<Emplyees> emp 
		
		List<Emplyees>  empL = empList.stream().sorted(Comparator.comparing(Employee::salary).reversed()).limit(2).skip(1).collect(Collectors.toList());
		
		
		Map<String, Integer> map =   empList.stream().collect(Collectors.groupingBy(Employee:: getName, Collectors.counting()));
		
		
	}

	
	
}
