package easv.college.examassignment.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAndEditMovieController implements Initializable {
    FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField IMBDRating;

    @FXML
    private Button cancelBtn;

    @FXML
    private ComboBox<?> comboboxCategory;

    @FXML
    private TextField filePath;

    @FXML
    private TextField movieTitle;

    @FXML
    private TextField userRating;

    @FXML
    void cancelAddEditMovieAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void chooseFilePathActionBtn(ActionEvent event) {
        try {
            fileChooser.setInitialDirectory(new File(NewAndEditMovieController.class.getResource("/easv/college/examassignment/MoviesAssets").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        File file = fileChooser.showOpenDialog(null);
        filePath.setText(file.getAbsolutePath());

    }

    @FXML
    void saveMovieActionBtn(ActionEvent event) {
        String title = movieTitle.getText();
        Float ratingIMBD = Float.parseFloat(IMBDRating.getText());
        Float ratingUser = Float.parseFloat(userRating.getText());
        String catMovie = comboboxCategory.getSelectionModel().getSelectedItem().toString();


        // close window
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
