package model;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Student implements Comparable<Student> {

	// ATRIBUTES
	private String name;
	private String lastName;
	private String telephone;
	private String emailAddres;
	private String id;
	private String semester;
	private Image photo;

	// RELATIONS
	private ArrayList<Course> courses;

	// CONSTRUCTOR
	public Student(String name, String lastName, String telephone, String id, String semester, String emailAddres,
			Image photo) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.emailAddres = emailAddres;
		this.id = id;
		this.semester = semester;
		this.setPhoto(photo);
		courses = new ArrayList<Course>();
	}

	// METHODS
	public void deleteACourse(String subject) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getSubject().equals(subject)) {
				courses.remove(i);
			}
		}
	}

	public void editACourse(Course editedCourse, String subject) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getSubject().equals(subject)) {
				courses.add(i, editedCourse);
			}
		}
	}

	@Override
	public int compareTo(Student o) {
		if (name.compareTo(o.getName()) == 1) {
			return 1;
		} else if (name.compareTo(o.getName()) == -1) {
			return -1;
		} else {
			return 0;
		}
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getEmailAddres() {
		return emailAddres;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	
}