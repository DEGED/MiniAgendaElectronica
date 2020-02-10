package ui;

import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	private StudentsList studentList;

	private Stage stage;

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("createStudent.fxml"));
			Parent root = loader.load();

			CreateStudentController csc = (CreateStudentController) loader.getController();
			csc.recibirscenescacsc(studentList);
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setTitle("Agregar estudiante a la agenda");
			st.setScene(s);
			st.setResizable(false);
			st.showAndWait();
		} catch (IOException e) {
		}
	}

	@FXML
	void goToTheSubjects(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("subject.fxml"));
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setTitle("Materias");
			st.setScene(s);
			st.setResizable(false);
			st.showAndWait();
		} catch (IOException e) {
		}
	}

	public void showStudents() {

	}

	@FXML
	void initialize() throws IOException {
		studentList = new StudentsList();
		studentList.loadStudentsFile();
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("telephone"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("emailAddres"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
		semesterColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("semester"));
		ObservableList<Student> x = FXCollections.observableArrayList(studentList.getStudents());
		studentsTable.setItems(x);
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

	@FXML
	void handleRowSelect(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("showStudent.fxml"));
					Parent root = loader.load();

					ShowStudentController temp = (ShowStudentController) loader.getController();
					Student row = studentsTable.getSelectionModel().getSelectedItem();

					temp.fill("Name: " + row.getName(), "Last name: " + row.getLastName(),
							"Telephone: " + row.getTelephone(), "Id: " + row.getId(), "Semester: " + row.getSemester(),
							"Email: " + row.getEmailAddres(), row.getPhoto());

					Scene s = new Scene(root);
					Stage st = new Stage();
					st.setTitle("Informacion del estudiante");
					st.setScene(s);
					st.setResizable(false);
					st.showAndWait();
				} catch (IOException e) {}
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR, "Por favor seleccione un estudiante", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
		}
	}
}