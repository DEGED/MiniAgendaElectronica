package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class CreateSubjectController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField name;

	@FXML
	private TextField teacher;

	@FXML
	private TextField nrc;

	@FXML
	private TextField credits;

	@FXML
	void done(MouseEvent event) {
		if (name.getText().equals("") && teacher.getText().equals("") && nrc.getText().equals("")
				&& credits.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR, "Debe ingresar algún valor", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		} else {
			boolean fine = true;

			if (!nrc.getText().equals("")) {
				try {
					int nrcInteger = Integer.parseInt(nrc.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine = false;
					Alert alert = new Alert(AlertType.ERROR, "El NRC debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}

			if (!credits.getText().equals("")) {
				try {
					int creditsInteger = Integer.parseInt(credits.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine = false;
					Alert alert = new Alert(AlertType.ERROR,
							"El número de creditos de un curso debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}

			// Literalmente todo lo que falta por hacer de este metodo se debe completar en
			// este else

			// Aquí se llama al modelo y se crea un objeto tipo materia
			// Si algún campo está vacío, se tomará el valor como ""
			//

			if (fine) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Se ha guardado la materia con exito", ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
		}
	}

	@FXML
	void initialize() {

	}
}