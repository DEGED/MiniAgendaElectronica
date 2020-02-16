package ui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Course;
import model.Student;
import model.StudentsList;

public class StudentSubjectsController {
	private ArrayList<Course> courses;
	private Student student;
	private StudentsList studentsList;
	private Stage stage;
    @FXML
    private TextField search;

    public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@FXML
    private TableView<Course> tableSubjects;

    @FXML
    private TableColumn<Course,String> nameColumn;

    @FXML
    private TableColumn<Course,String> profesorColumn;

    @FXML
    private TableColumn<Course,String> nrcColumn;

    @FXML
    private TableColumn<Course,String> creditosColumn;

    @FXML
    private TableColumn<Course,String> cantidadDeEstudiantesColumn;

    @FXML
    void matricularAction(ActionEvent event) {

    }

    @FXML
    void searchSubjectAction(KeyEvent event) {
    	switch (event.getCode()) {
		 case ENTER:
    	Course newCourseToAdd = studentsList.searchSubjectByNrc(search.getText());
    	System.out.println(student.getName());
    	studentsList.addSubjectToAStudent(student.getName(), newCourseToAdd);
    	refresh();
		 default:
			 break;
			
		}
			 
    }
    @FXML
    public void initialize() {
		    	
		nameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
		profesorColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("teacherName"));
		nrcColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("nrc"));
		creditosColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("credits"));
		cantidadDeEstudiantesColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("studentsAmount"));
		
    	
    }
    public void refresh() {
    	courses = student.getCourses();
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
		profesorColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("teacherName"));
		nrcColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("nrc"));
		creditosColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("credits"));
		cantidadDeEstudiantesColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("studentsAmount"));
		ObservableList<Course> x = FXCollections.observableArrayList(courses);

		tableSubjects.setItems(x);
    }
    
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public StudentsList getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(StudentsList studentsList) {
		this.studentsList = studentsList;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
