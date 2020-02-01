package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;

public class CreateStudentController {

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
	void addPhoto(MouseEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
		FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
		FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image imageLoaded = SwingFXUtils.toFXImage(bufferedImage, null);
			image.setImage(imageLoaded);
		} catch (IOException e) {
		} catch (IllegalArgumentException e) {
		}
	}

	@FXML
	void cancel(MouseEvent event) throws Throwable {

	}

	@FXML
	void done(MouseEvent event) {
		if (name.getText().equals("") && lastName.getText().equals("") && telephone.getText().equals("")
				&& email.getText().equals("") && id.getText().equals("") && semester.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR, "Debe ingresar algún valor", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		} else {
			boolean fine = true;

			if (!telephone.getText().equals("")) {
				try {
					int telephoneInteger = Integer.parseInt(telephone.getText());
					fine = true;
				} catch (NumberFormatException e) {
					fine=false;
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
					fine=false;
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
					fine=false;
					Alert alert = new Alert(AlertType.ERROR,
							"El número de creditos de un curso debe ser un número entero", ButtonType.OK);
					alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
					alert.show();
				}
			}

			// Literalmente todo lo que falta por hacer de este metodo se debe completar en
			// este else

			// Aquí se llama al modelo y se crea un objeto tipo estudiante
			// Si algún campo está vacío, se tomará el valor como ""
			//

			if (fine) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Se ha guardado el estudiante con exito",
						ButtonType.OK);
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				alert.show();
			}
		}
	}

	@FXML
	void initialize() {

	}
}