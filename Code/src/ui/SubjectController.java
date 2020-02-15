package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Course;
import model.Student;

public class SubjectController {
	
	private static Stage stage;
	
	private ArrayList<Course> totalSubjects;
	@FXML
	private ResourceBundle resources;
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
	private URL location;

	@FXML
	private TextField search;

	@FXML
	private Label subjects;

	@FXML
	void createSubject(MouseEvent event) {
		try {
			
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("createSubject.fxml"));
			Parent root = loader.load();
			CreateSubjectController csc = loader.getController();
			csc.recibirscenescacsc(StudentController.getStudentList());
			Scene s = new Scene(root);
			Stage st = new Stage();
			stage.close();
			csc.setStage(st);
			st.setTitle("Agregar materia a la agenda");
			st.setScene(s);
			st.setResizable(false);
			st.show();
		} catch (IOException e) {
			
		}
	}

	@FXML
	void goToTheStudents(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("student.fxml"));
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setTitle("Estudiantes");
			st.setScene(s);
			st.setResizable(false);
			st.show();
			
		} catch (IOException e) {
		} 
	}
	@FXML
    void reportAction(ActionEvent event) {

    }
	@FXML
	void initialize() {
		totalSubjects = new ArrayList<Course>();
		totalSubjects = StudentController.getSubjectsList();
		nameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
		profesorColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("teacherName"));
		nrcColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("nrc"));
		creditosColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("credits"));
		cantidadDeEstudiantesColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("studentsAmount"));
		ObservableList<Course> x = FXCollections.observableArrayList(StudentController.getStudentList().getSubjects());

		tableSubjects.setItems(x);
	
	}

	public static Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}