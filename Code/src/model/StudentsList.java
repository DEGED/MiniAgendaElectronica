package model;

import java.util.ArrayList;

public class StudentsList {

	//RELATIONS 
	private ArrayList<Student> students;
	
	
	//COSTRUCTOR
	public StudentsList() {
		
		students = new ArrayList<Student>();
	}

	//METHODS
	
	public double subjectAverage() {
		int totalStudents = students.size();
		double total = 0;
		for (int i = 0; i < students.size(); i++) {
			total+=students.get(i).getCourses().size();
		}
		total = total/totalStudents;
		return total;
	}
	
	public double creditsAverage() {
		int totalStudents = students.size();
		double total = 0;
		for (int i = 0; i < students.size(); i++) {
			Student actualStudent = students.get(i);
			for (int j = 0; j < actualStudent.getCourses().size(); j++) {
				total += actualStudent.getCourses().get(j).getCredits();
			}
		}
		return total/totalStudents;
	}
	
	public Student searchStudentByName(String name) {
		if(containsStudent(1, name)==1) {
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getName().equals(name)) {
					return students.get(i);
				}
			}
		}else {
			throw new IllegalArgumentException("Unexpected value: ");
			
		}
		return null;
			
	}
	public Student searchStudentByLastName(String lastName) {
		if(containsStudent(1, lastName)==1) {
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getLastName().equals(lastName)) {
					return students.get(i);
				}
			}
		}else {
			throw new IllegalArgumentException("Unexpected value: ");
			
		}
		return null;
			
	}
	public Student searchStudentByPhone(String phone) {
		if(containsStudent(1, phone)==1) {
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getTelephone().equals(phone)) {
					return students.get(i);
				}
			}
		}else {
			throw new IllegalArgumentException("Unexpected value: ");
			
		}
		return null;
			
	}
	public Student searchStudentByEmailAddres(String emailAddres) {
		if(containsStudent(1, emailAddres)==1) {
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getEmailAddres().equals(emailAddres)) {
					return students.get(i);
				}
			}
		}else {
			throw new IllegalArgumentException("Unexpected value: ");
			
		}
		return null;
			
	}
	public int containsStudent(int typeOfSearch, String criterion) {
		if(typeOfSearch==1){
			
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getName().equals(criterion)) {
					return 1;
				}else {
					return -1;
				}
					
			}
		}
		else if(typeOfSearch==2){
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getLastName().equals(criterion)) {
					return 1;
				}else {
					return -1;
				}
			}
		}
		else if(typeOfSearch==3){
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getTelephone().equals(criterion)) {
					return 1;
				}else {
					return -1;
				}
			}
		}
		else if(typeOfSearch==4){
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getEmailAddres().equals(criterion)) {
					return 1;
				}else {
					return -1;
				}
			}
		}
		return -1;
	}
	public void addStudent(Student newOne) {
		students.add(newOne);		
		sortStudents();	
	}
	
	public void sortStudents(){
		int n = students.size();
	    for(int i = 1; i <= n - 1; i++){
	        String x = students.get(i).getName();
	        Student temp = students.get(i);
	        int j = i - 1;
	        while (j >= 0 && x.compareTo(students.get(j).getName())<0) {
	        	students.set(j+1,students.get(j));
	            j = j - 1;
	        }
	        students.set(j + 1, temp);
	    }
	}
	
	public void deleteAStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId().equals(id)) {
				students.remove(i);
			}
		}
	}
	
	
	//GETTERS AND SETTERS
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
