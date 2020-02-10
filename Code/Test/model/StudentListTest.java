package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class StudentsListTest {

	private StudentsList students;

	public void setupScenary1() throws IOException {
		students = new StudentsList();
		students.loadStudentsFile();
		
	}

	public void setupScenary2() {
		students = new StudentsList();
		Student x = new Student("Juan David", "Hernandez Valderrama", "1234567890", "maicol@vojabes.com", "0987654321",
				"5", "");
		Student y = new Student("Juan David", "Lectamo Caicedo", "1234567890", "yo@vojabes.com", "0987654321", "5", "");
		Student z = new Student("Johann Andrei", "Ocampo Torres", "1234567890", "vene@vojabes.com", "0987654321", "5",
				"");
		Student w = new Student("Juan Jose", "Calderon Vojabes", "1234567890", "yummi@vojabes.com", "0987654321", "1",
				"");

		students.addStudent(x);
		students.addStudent(y);
		students.addStudent(z);
		students.addStudent(w);
	}

	@Test
	public void loadFileTest() throws IOException {
		setupScenary1();
		assertTrue(students.getStudents().get(0).getName().equals("Alberto"));
		assertTrue(students.getStudents().get(0).getLastName().equals("Alvarez"));
		assertTrue(students.getStudents().get(0).getTelephone().equals("3155462882"));
		assertTrue(students.getStudents().get(0).getEmailAddres(),students.getStudents().get(0).getEmailAddres().equals("asd"));
		assertTrue(students.getStudents().get(0).getId().equals("asd"));
		assertTrue(students.getStudents().get(0).getSemester().equals("ads"));
		
		assertTrue(students.getStudents().get(1).getName().equals("Alejandro"));
		assertTrue(students.getStudents().get(1).getLastName().equals("Martinez Martinez"));
		assertTrue(students.getStudents().get(1).getTelephone().equals("3112345674"));
		assertTrue(students.getStudents().get(1).getEmailAddres().equals("alejomam2011@gmail.com"));
		assertTrue(students.getStudents().get(1).getId().equals("A00354350"));
		assertTrue(students.getStudents().get(1).getSemester().equals("5"));
		assertTrue(students.getStudents().get(2).getName().equals("Ana Maria"));
		assertTrue(students.getStudents().get(2).getLastName().equals(" Muñoz Valencia"));
		assertTrue(students.getStudents().get(2).getTelephone().equals("3017980082"));
		assertTrue(students.getStudents().get(2).getEmailAddres().equals("cnscanamariamv@gmail.com"));
		assertTrue(students.getStudents().get(2).getId().equals("A00352237"));
		assertTrue(students.getStudents().get(2).getSemester().equals("5"));
		assertTrue(students.getStudents().get(3).getName().equals("Carlos"));
		assertTrue(students.getStudents().get(3).getLastName().equals("Perez"));
		assertTrue(students.getStudents().get(3).getTelephone().equals("3155462882"));
		assertTrue(students.getStudents().get(3).getEmailAddres().equals("carlos@vojabes.com"));
		assertTrue(students.getStudents().get(3).getId().equals("A00356210"));
		assertTrue(students.getStudents().get(3).getSemester().equals("6"));
	}
	
	@Test
	public void searchStudentByNameTest() throws IOException {
		setupScenary1();
		
		Student toFind = students.searchStudentByName("Manuel");
		assertTrue(toFind.getName().equals("Manuel"));
	}
	@Test
	public void searchStudentByLastName() throws IOException {
		setupScenary1();
		Student toFind = students.searchStudentByLastName("Balanta Quintero");
		assertTrue(toFind.getLastName().equals("Balanta Quintero"));
	}
	@Test
	public void searchStudentByTelephone() throws IOException {
		setupScenary1();
		Student toFind = students.searchStudentByPhone("3218746583");
		assertTrue(toFind.getTelephone().equals("3218746583"));
	}
	@Test
	public void searchStudentByEmail() throws IOException {
		setupScenary1();
		Student toFind = students.searchStudentByEmailAddres(("mbalantaq@gmail.com"));
		assertTrue(toFind.getEmailAddres().equals("mbalantaq@gmail.com"));
	}

	@Test
	public void containsStudentTest() throws IOException {
		setupScenary1();
		int find = students.containsStudent("Name", "Manuel");
		assertTrue(find==1);
		find = students.containsStudent("lastName", "Balanta Quintero");
		assertTrue(find==1);
		find = students.containsStudent("phone", "3218746583");
		assertTrue(find==1);
		find = students.containsStudent("email", "mbalantaq@gmail.com");
		assertTrue(find==1);
	}
	@Test
	public void addStudentTest() {
		setupScenary2();
		Student newOne = new Student("Alberto","albarez","123","alberto@","A002","2","url");
		students.addStudent(newOne);
		assertTrue(students.getStudents().get(0).getName().equals("Alberto"));
	}
	@Test 
	public void sortStudentsTest() {
		setupScenary2();
		students.sortStudents();
		assertTrue(students.getStudents().get(0).getName().equals("Johann Andrei"));
		assertTrue(students.getStudents().get(1).getName().equals("Juan David"));
		assertTrue(students.getStudents().get(2).getName().equals("Juan David"));
		assertTrue(students.getStudents().get(3).getName().equals("Juan Jose"));
	}
	@Test
	public void deleteSAtudentTest() throws IOException {
		setupScenary1();
		students.deleteAStudent("A00351728");
		int find = students.containsStudent("lastName", "Balanta Quintero");
		assertTrue(find==-1);
	}
}
