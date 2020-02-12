package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Student;
import model.StudentsList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ShowStudentController {

	private Student copyStudent;
	
	private Stage stage;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
    @FXML
    private ImageView image;

    @FXML
    private TextField name;

    @FXML
    private TextField lastName;

    @FXML
    private TextField telephone;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField Semester;

    @FXML
    void editarButton(ActionEvent event) {
    	name.setEditable(true);
    	lastName.setEditable(true);
    	telephone.setEditable(true);
    	email.setEditable(true);
    	id.setEditable(true);
    	Semester.setEditable(true);
    	copyStudent = new Student(name.getText(), lastName.getText(), telephone.getText(), id.getText(), Semester.getText(), email.getText(), location.toString());
    }

    @FXML
    void guardarButton(ActionEvent event) throws IOException {
    	name.setEditable(true);
    	lastName.setEditable(true);
    	telephone.setEditable(true);
    	email.setEditable(true);
    	id.setEditable(true);
    	Semester.setEditable(true);
    	Student newOne = new Student(name.getText(), lastName.getText(), telephone.getText(), id.getText(), Semester.getText(), email.getText(), location.toString());
	    StudentController.getStudentList().deleteAStudent(copyStudent.getId());
	    StudentController.getStudentList().addStudent(newOne);
	    getStage().show();
	    stage.close();    
    }
    protected void fill(String nameRecived, String lastNameRecived, String telephoneRecived, String idRecived,
		String semesterRecived, String emailAddresRecived, String UrlImage) throws IOException {
		name.setText(nameRecived);
		lastName.setText(lastNameRecived);
		telephone.setText(telephoneRecived);
		email.setText(emailAddresRecived);
		id.setText(idRecived);
		Semester.setText(semesterRecived);
		URL url = new URL(UrlImage);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		image.setImage(new Image(in));
	}
  
    @FXML
    public void initializate(){
    	name.setEditable(false);
    	lastName.setEditable(false);
    	telephone.setEditable(false);
    	email.setEditable(false);
    	id.setEditable(false);
    	Semester.setEditable(false);
    }
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
