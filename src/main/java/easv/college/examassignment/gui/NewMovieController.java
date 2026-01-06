package easv.college.examassignment.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewMovieController {

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

    }

    @FXML
    void saveMovieActionBtn(ActionEvent event) {

    }

}
