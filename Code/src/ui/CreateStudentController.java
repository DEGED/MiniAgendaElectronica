package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
			
			//canvas.getGraphicsContext2D().drawImage(image, 0, 0,1111, 635);
		} catch (IOException e) {
		} catch (IllegalArgumentException e) {
		}
	}

	@FXML
	void cancel(MouseEvent event) {

	}

	@FXML
	void done(MouseEvent event) {

	}

	@FXML
	void initialize() {

	}
}