package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaSort {

	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(
				new Student(20110771, "Lee"),
				new Student(20110771, "Hwn"),
				new Student(20110770, "Ahn"),
				new Student(20110772, "Hole"));
		
		Collections.sort(students);
	
		students.stream().forEach(System.out::println);
	}
}
