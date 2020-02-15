package ui;

import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.text.TabExpander;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class StudentController {
	private static  StudentsList studentList;

	private static ArrayList<Course> subjectsList;
	
	private boolean flag = true;
	
	private static Stage stage;
	
	public static  StudentsList getStudentList() {
		return studentList;
	}
	@FXML
	private ResourceBundle resources;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> telephoneColumn;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> semesterColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

	@FXML
	private URL location;

	@FXML
	private TextField search;


	@FXML
	void addStudent(MouseEvent event) {
		try {
			Node source = (Node) event.getSource();
		    Stage stage = (Stage) source.getScene().getWindow();
		    stage.close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("createStudent.fxml"));
			Parent root = loader.load();
			CreateStudentController csc = (CreateStudentController) loader.getController();
			csc.recibirscenescacsc(studentList);
			Scene s = new Scene(root);
			Stage st = new Stage();
			csc.setStage(stage);
			st.setTitle("Agregar estudiante a la agenda");
			st.setScene(s);
			st.setResizable(false);
			st.show();
			
			
		    
		} catch (IOException e) {
		}
	}

	@FXML
	void goToTheSubjects(MouseEvent event) throws IOException {
		Parent root;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("subject.fxml"));
		root = loader.load();
		SubjectController sc = loader.getController();
		Scene s = new Scene(root);
			Stage st = new Stage();
			sc.setStage(st);
			st.setTitle("Materias");
			st.setScene(s);
			st.setResizable(false);
			st.show();
		
	}

	public void showStudents() {

	}

	@FXML
	void initialize() throws IOException {
		if (flag) {
			studentList = new StudentsList();
			studentList.loadStudentsFile();
			studentList.loadSubjectsFile();
			System.out.println(studentList.getSubjects().get(0).getSubject());
			nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
			telephoneColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("telephone"));
			emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("emailAddres"));
			idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
			semesterColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("semester"));
			ObservableList<Student> x = FXCollections.observableArrayList(studentList.getStudents());
			studentsTable.setItems(x);
			flag = false;
		}else if (flag==false) {
			refresh();
		}
	}

	public TableColumn<Student, String> getNameColumn() {
		return nameColumn;
	}

	public TableColumn<Student, String> getLastNameColumn() {
		return lastNameColumn;
	}

	public TableColumn<Student, String> getTelephoneColumn() {
		return telephoneColumn;
	}

	public TableColumn<Student, String> getEmailColumn() {
		return emailColumn;
	}

	public TableColumn<Student, String> getIdColumn() {
		return idColumn;
	}

	public TableColumn<Student, String> getSemesterColumn() {
		return semesterColumn;
	}

	public void recibirscenecscasc(StudentsList b) {
		studentList = b;
	}
	public  void  refresh() throws IOException {
		studentsTable.getItems().clear();
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("telephone"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("emailAddres"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
		semesterColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("semester"));
		ObservableList<Student> x = FXCollections.observableArrayList(studentList.getStudents());
		studentsTable.setItems(x);
	}
	@FXML
	void handleRowSelect(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("showStudent.fxml"));
					Parent root = loader.load();

					ShowStudentController temp = (ShowStudentController) loader.getController();
					Student row = studentsTable.getSelectionModel().getSelectedItem();

					temp.fill( row.getName(), row.getLastName(),
							row.getTelephone(), row.getId(),row.getSemester(),
							row.getEmailAddres(), row.getUrlPhoto());
					
					Scene s = new Scene(root);
					stage.close();
					Stage st = new Stage();
					st.setTitle("Informacion del estudiante");
					st.setScene(s);
					st.setResizable(false);
					temp.setStage(st);

					st.showAndWait();
				
					
					
					
					
					
				} catch (IOException e) {}
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR, "Por favor seleccione un estudiante", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
		}
	}
	 @FXML
	 void emailItemMenu(ActionEvent event) {

	 }
	 
    @FXML
    void lastNameItemMenu(ActionEvent event) {
    	
    }

    @FXML
    void nameItemMenu(ActionEvent event) {
    	
    }

    @FXML
    void telephoneItemMenu(ActionEvent event) {

    }
	public static Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		StudentController.stage = stage;
	}

	public static ArrayList<Course> getSubjectsList() {
		return subjectsList;
	}
}
