package model;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class StudentsListTest {
	private StudentsList students;
	private StudentsList pred;

	public void setupScenary1() {
		students = new StudentsList();

		Student x = new Student("Juan David", "Hernandez Valderrama", "1234567890", "maicol@vojabes.com", "0987654321",
				"5", null);
		Student y = new Student("Juan David", "Lectamo Caicedo", "1234567890", "yo@vojabes.com", "0987654321", "5",
				null);
		Student z = new Student("Johann Andrei", "Ocampo Torres", "1234567890", "vene@vojabes.com", "0987654321", "5",
				null);
		Student w = new Student("Juan Jose", "Calderon Vojabes", "1234567890", "yummi@vojabes.com", "0987654321", "1",
				null);

		students.addStudent(x);
		students.addStudent(y);
		students.addStudent(z);
		students.addStudent(w);
	}

	public void setupScenary2() {
		pred = new StudentsList();
	}

	@Test
	public void loadFileTest() throws IOException {
		setupScenary1();
		setupScenary2();

		// pred.loadFile();

		for (int I = 0; I < students.getStudents().size(); I++) {
			// assertTrue(
			// "The name of: " + pred.getStudents().get(I).getName() + " should be: "
			// + students.getStudents().get(I).getName(),
			// pred.getStudents().get(I).getName().equals(students.getStudents().get(I).getName()));

			assertTrue(
					"The last name of: " + pred.getStudents().get(I).getLastName() + " should be: "
							+ students.getStudents().get(I).getLastName(),
					pred.getStudents().get(I).getLastName().equals(students.getStudents().get(I).getLastName()));

		}
	}
}