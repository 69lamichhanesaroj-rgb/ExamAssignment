package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.net.URL;
import java.sql.Date;
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


    public void cancelAddEditMovieAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }


    public void chooseFilePathActionBtn(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");


        File file = fileChooser.showOpenDialog(cancelBtn.getScene().getWindow());
        filePath.setText(file.getAbsolutePath());

    }


    public void saveMovieActionBtn(ActionEvent event) {
//        String title = movieTitle.getText().trim();
//        Float ratingIMBD = Float.parseFloat(IMBDRating.getText());
//        Float ratingUser = Float.parseFloat(userRating.getText());
//        String catMovie = comboboxCategory.getSelectionModel().getSelectedItem().toString();
        logic.createMovie(movieTitle.getText(), Float.parseFloat(IMBDRating.getText()), filePath.getText(), new Date(2024-1-1), Float.parseFloat(userRating.getText()));

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
