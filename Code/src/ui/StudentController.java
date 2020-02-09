package ui;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXConsole;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentController {
	
	//Relation
	
	private StudentsList a;

	private Student temp;
	
	private Stage stage;
	@FXML
	private ResourceBundle resources;

    @FXML
    private TableView<Student> studentsTable;
    
    @FXML
    private TableColumn<Student,String> nameColum;

    @FXML
    private TableColumn<Student,String> lastNameColumn;

    @FXML
    private TableColumn<Student,String> telephoneColumn;

    @FXML
    private TableColumn<Student,String> semesterColumn;

    @FXML
    private TableColumn<Student,String> emailColumn;

    @FXML
    private TableColumn<Student,String> idColumn;
    
	@FXML
	private URL location;

	@FXML
	private TextField search;

	@FXML
	private Label students;

	@FXML
	void addStudent(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("createStudent.fxml"));
			Parent root = loader.load();
			
			CreateStudentController csc = (CreateStudentController) loader.getController();
			csc.recibirscenescacsc(a);
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
		
		a = new StudentsList();
		a.loadStudentsFile();
		nameColum.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		telephoneColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("telephone"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("emailAddres"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
		semesterColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("semester"));
		ObservableList<Student> x = FXCollections.observableArrayList(a.getStudents());
		studentsTable.setItems(x);
	}
	
	
	public TableColumn<Student, String> getNameColum() {
		return nameColum;
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
		a = b;
	}
	@FXML
    void handleRowSelect(MouseEvent event) {
		
	    if(event.getClickCount()==2) {
	    	Student row = studentsTable.getSelectionModel().getSelectedItem();
	    	Stage genericStage = new Stage();
	    	genericStage.initModality(Modality.APPLICATION_MODAL);
	    	genericStage.initOwner(stage);
	    	VBox generic = new VBox(20);
	    	Scene scene = new Scene(generic, 500, 800);
	    	ImageView view = new ImageView();
	    	Label rowName = new Label();
	    	Label rowLastName = new Label();
	    	Label rowTelephone = new Label();
	    	Label rowEmailAddres = new Label();
	    	Label rowId = new Label();
	    	Label rowSemeter = new Label();
//	    	ImageView x = 
//Poner la imagen aqui
	    	rowName.setText("Name: "+row.getName());
	    	rowLastName.setText("Last name: "+row.getLastName());
	    	rowTelephone.setText("Telephone: "+row.getTelephone());
	    	rowEmailAddres.setText("Email addres: "+row.getId());
	    	rowId.setText("Id: "+row.getSemester());
	    	rowSemeter.setText("semester: "+row.getEmailAddres());
//	    	Agregar la imagen al generic de primera ya que esta muestra las cosas segun el orden de agregado 
	    	generic.getChildren().add(rowName);
	    	generic.getChildren().add(rowLastName);
	    	generic.getChildren().add(rowTelephone);
	    	generic.getChildren().add(rowEmailAddres);
	    	generic.getChildren().add(rowId);
	    	generic.getChildren().add(rowSemeter);
	    	generic.setAlignment(Pos.CENTER);
		  
	    	genericStage.setScene(scene);
	    	genericStage.show();
	    	
	    }
    }
}