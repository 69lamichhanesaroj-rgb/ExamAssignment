package easv.college.examassignment.gui;

import easv.college.examassignment.MovieApplication;
import easv.college.examassignment.be.Category;
import easv.college.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class NewAndEditMovieController implements Initializable {
    Logic logic = new Logic();
    private ObservableList<Category> categories = FXCollections.observableArrayList();

    @FXML
    private TextField IMBDRating;

    @FXML
    private Button cancelBtn;

    @FXML
    private ComboBox<Category> comboboxCategory;

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

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");


        File file = fileChooser.showOpenDialog(cancelBtn.getScene().getWindow());
        filePath.setText(file.getAbsolutePath());

    }

    @FXML
    void saveMovieActionBtn(ActionEvent event) {
        String title = movieTitle.getText().trim();
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
        List<Category> categories1 = logic.getAllCategories();
        categories.addAll(categories1);
        comboboxCategory.setItems(categories);
    }
}
