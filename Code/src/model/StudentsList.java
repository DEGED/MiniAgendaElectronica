package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class StudentsList {

	public static final String STUDENTS_ROUTE = "C:\\Users\\johan\\eclipse-workspace\\MiniAgendaElectronica\\Code/data/estudiantes.csv";
	public static final String SUBJECTS_ROUTE = "C:\\Users\\johan\\eclipse-workspace\\MiniAgendaElectronica\\Code/data/materias.csv";

	// RELATIONS
	private ArrayList<Student> students;

	private ArrayList<Course> subjects;

	public ArrayList<Course> getSubjects() {
		return subjects;
	}

	// COSTRUCTOR
	public StudentsList() {
		students = new ArrayList<Student>();
		subjects = new ArrayList<Course>();
	}

	// METHODS

	public double subjectAverage() {
		int totalStudents = students.size();
		double total = 0;
		for (int i = 0; i < students.size(); i++) {
			total += students.get(i).getCourses().size();
		}
		total = total / totalStudents;
		return total;
	}

	public double creditsAverage() {
		int totalStudents = students.size();
		double total = 0;
		for (int i = 0; i < students.size(); i++) {
			Student actualStudent = students.get(i);
			for (int j = 0; j < actualStudent.getCourses().size(); j++) {
				total += actualStudent.getCourses().get(j).getCreditsInt();
			}
		}
		return total / totalStudents;
	}

	public Student searchStudentByName(String name) {
		if (containsStudent("Name", name) == 1){
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getName().equals(name)){
					return students.get(i);
				}
			}
		} else if(containsStudent("Name", name) == -1){
			throw new IllegalArgumentException("Unexpected value: ");

		}
		return null;

	}

	public Student searchStudentByLastName(String lastName) {
		if (containsStudent("lastName", lastName) == 1) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getLastName().equals(lastName)) {
					return students.get(i);
				}
			}
		} else {
			throw new IllegalArgumentException("Unexpected value: ");

		}
		return null;

	}

	public Student searchStudentByPhone(String phone) {
		if (containsStudent("phone", phone) == 1) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getTelephone().equals(phone)) {
					return students.get(i);
				}
			}
		} else {
			throw new IllegalArgumentException("Unexpected value: ");

		}
		return null;

	}

	public Student searchStudentByEmailAddres(String emailAddres) {
		if (containsStudent("email", emailAddres) == 1) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getEmailAddres().equals(emailAddres)) {
					return students.get(i);
				}
			}
		} else {
			throw new IllegalArgumentException("Unexpected value: ");

		}
		return null;

	}

	public int containsStudent(String typeOfSearch, String criterion) {
		
		if (typeOfSearch.equals("Name")) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().equalsIgnoreCase(criterion)) {
					return 1;
				}
			}
			
		} else if (typeOfSearch.equalsIgnoreCase("lastName")) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getLastName().equals(criterion)) {
					return 1;
				}
			}
		} else if (typeOfSearch.equalsIgnoreCase("phone")) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getTelephone().equals(criterion)) {
					return 1;
				}
			}
		} else if (typeOfSearch.equalsIgnoreCase("email")) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getEmailAddres().equals(criterion)) {
					return 1;
				} 
			}
		}
		return -1;
	}

	public void addStudent(Student newOne) {
		students.add(newOne);
		sortStudents();
	}

	public void sortStudents() {
		int n = students.size();
		for (int i = 1; i <= n - 1; i++) {
			String x = students.get(i).getName();
			Student temp = students.get(i);
			int j = i - 1;
			while (j >= 0 && x.compareTo(students.get(j).getName()) < 0) {
				students.set(j + 1, students.get(j));
				j = j - 1;
			}
			students.set(j + 1, temp);
		}
	}

	public void deleteAStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(id)) {
				students.remove(i);
			}
		}
	}

	// GETTERS AND SETTERS

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void loadStudentsFile() throws IOException {
		FileReader fr = new FileReader(new File(STUDENTS_ROUTE));
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String[] parts = line.split(",");
			Student toAdd = new Student(parts[0], parts[1], parts[2], parts[5], parts[3], parts[4], parts[6]);
			students.add(toAdd);
			line = br.readLine();
		}
		fr.close();
		br.close();
	}

	public void loadSubjectsFile() throws IOException {
		FileReader fr = new FileReader(new File(SUBJECTS_ROUTE));
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String[] parts = line.split(",");
			String[] parts2 = parts[4].split(";");
			Course toAdd = new Course(parts[0],parts[1],parts[2],parts[3],parts2[0]);
			subjects.add(toAdd);
			System.out.println(subjects.get(0).getSubject());
			System.out.println(subjects.get(0).getTeacherName());
			System.out.println(subjects.get(0).getnrc());
			System.out.println(subjects.get(0).getCredits());
			System.out.println(subjects.get(0).getStudentsAmount());

			line = br.readLine();
		}
		fr.close();
		br.close();
	}

	public void studentsSave() throws FileNotFoundException {
		PrintWriter writting = new PrintWriter(new File(STUDENTS_ROUTE));
		String sep = "Nombre,apellido,telefono,semestre,email,id,urlPhoto" + "\n";
		writting.print(sep);
		String tmp = "";

		for (int i = 0; i < students.size(); i++) {
			tmp += students.get(i).getName() + "," + students.get(i).getLastName() + ","
					+ students.get(i).getTelephone() + "," + students.get(i).getSemester() + ","
					+ students.get(i).getEmailAddres() + "," + students.get(i).getId() + ","
					+ students.get(i).getUrlPhoto() + "\n";
		}
		writting.print(tmp);
		writting.close();
	}

	public void subjectsSave() throws FileNotFoundException {
		PrintWriter writting = new PrintWriter(new File(STUDENTS_ROUTE));
		String sep = "Nombre del curso, Profesor, Numero del grupo, nrc, creditos, numero de estudiantes" + "\n";
		writting.print(sep);
		String tmp = "";

		for (int i = 0; i < students.size(); i++) {
			tmp += students.get(i).getName() + "," + students.get(i).getLastName() + ","
					+ students.get(i).getTelephone() + "," + students.get(i).getEmailAddres() + ","
					+ students.get(i).getId() + "," + students.get(i).getSemester() + "," + "null" + "\n";

		}
		writting.print(tmp);
		writting.close();
	}
	
}