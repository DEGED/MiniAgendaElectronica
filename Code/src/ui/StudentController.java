package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StudentController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField search;
	
	@FXML
    private Label students;

	@FXML
	void addStudent(MouseEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("createStudent.fxml"));
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setTitle("Agregar estudiante a la agenda");
			st.setScene(s);
			st.setResizable(false);
			st.showAndWait();
		} catch (IOException e) {}
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
		} catch (IOException e) {}
	}

	@FXML
	void initialize() {

	}
}