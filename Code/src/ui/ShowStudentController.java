package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowStudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label lastName;

    @FXML
    private Label telephone;

    @FXML
    private Label email;

    @FXML
    private Label id;

    @FXML
    private Label semester;

    @FXML
    void initialize() {
    	
    }
    
    protected void fill(String nameRecived, String lastNameRecived, String telephoneRecived, String idRecived, String semesterRecived, String emailAddresRecived,
			Image photoRecived) {
    	name.setText(nameRecived);
    	lastName.setText(lastNameRecived);
    	telephone.setText(telephoneRecived);
    	email.setText(emailAddresRecived);
    	id.setText(idRecived);
    	semester.setText(semesterRecived);
    	image.setImage(photoRecived);
    }
}