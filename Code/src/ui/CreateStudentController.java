package ui;
import model.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class CreateStudentController {
	
	private Stage stage;
	//relations
	private StudentsList student;
	private StudentController sc;
	
	@FXML
	private ImageView image;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

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
	private TextField semester;

    @FXML
    private TextField URLimage;

	@FXML
	void done(MouseEvent event) throws IOException {
		if (name.getText().equals("") && lastName.getText().equals("") && telephone.getText().equals("")
				&& email.getText().equals("") && id.getText().equals("") && semester.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR, "Debe ingresar algún valor", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		} else if (name.getText().equals("") || lastName.getText().equals("") || telephone.getText().equals("")
				|| email.getText().equals("") || id.getText().equals("") || semester.getText().equals("")) {
			
			Alert alert2 = new Alert(AlertType.ERROR, "Debe llenar todos los campos");
			alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert2.show();
		}
		else {
			boolean fine = true;

			/*if (!telephone.getText().equals("")) {
				try {
					int telephoneInteger = Integer.parseInt(telephone.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine = false;
					Alert alert = new Alert(AlertType.ERROR, "El NRC debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}

			if (!id.getText().equals("")) {
				try {
					int idInteger = Integer.parseInt(id.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine = false;
					Alert alert = new Alert(AlertType.ERROR,
							"El número de creditos de un curso debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}

			if (!semester.getText().equals("")) {
				try {
					int semesterInteger = Integer.parseInt(semester.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine = false;
					Alert alert = new Alert(AlertType.ERROR,
							"El número de creditos de un curso debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}*/

			if (fine) {
				
				/*public Student(String name, String lastName, String telephone, String id, String semester, String emailAddres,
						Image photo) {*/
				
				try{
					//Esto es para evitar se pongan URL invalidos
					URL url = new URL(URLimage.getText());
					URLConnection conn = url.openConnection();
					InputStream in = conn.getInputStream();
					
					Student a1 = new Student(name.getText(), lastName.getText(), telephone.getText(), id.getText(), semester.getText()
							, email.getText(), URLimage.getText());
					
					student.addStudent(a1);
					
					student.studentsSave();
					
					Alert alert = new Alert(AlertType.CONFIRMATION, "Se ha guardado el estudiante con exito",
							ButtonType.CLOSE);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
					stage.close();

					StudentController.getStage().show();

					
				
				
					
					
				}catch (IOException e) {
					Alert alert = new Alert(AlertType.CONFIRMATION, "Por favorintroduzca una URL valida",
							ButtonType.CLOSE);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}
		}
	}

	@FXML
	void initialize() {
	}
	
	public void recibirscenescacsc(StudentsList studentList) {
		student = studentList;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}