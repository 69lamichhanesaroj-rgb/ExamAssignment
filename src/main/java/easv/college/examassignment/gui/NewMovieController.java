package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.be.Movie;
import easv.college.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewMovieController implements Initializable {
    Logic logic = new Logic();
    private final ObservableList<Category> categories = FXCollections.observableArrayList();
    private Movie movieToEdit;

    @FXML
    private Button btnCloseWindow;
    @FXML
    private TextField txtFilePath;
    @FXML
    private TextField txtMovieTitle;
    @FXML
    private TextField txtIMBDRating;
    @FXML
    private TextField txtUserRating;
    @FXML
    private ComboBox<Category> cbox1;
    @FXML
    private ComboBox<Category> cbox2;
    @FXML
    private ComboBox<Category> cbox3;
    @FXML
    private ComboBox<Category> cbox4;
    @FXML
    private ComboBox<Category> cbox5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Category> categories1 = logic.getAllCategories();
        categories.addAll(categories1);
        cbox1.setItems(categories);
        cbox2.setItems(categories);
        cbox3.setItems(categories);
        cbox4.setItems(categories);
        cbox5.setItems(categories);
    }

    public void btnCancel(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();

    }

    public void btnChooseFilePath(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        File file = fileChooser.showOpenDialog(btnCloseWindow.getScene().getWindow());
        txtFilePath.setText(file.getAbsolutePath());
    }

    public void btnSave(ActionEvent event) {
        if (movieToEdit == null) {
            //Add new movie 'mode'
            logic.createMovie(
                    txtMovieTitle.getText(),
                    Float.parseFloat(txtIMBDRating.getText()),
                    txtFilePath.getText(),
                    new java.sql.Date(System.currentTimeMillis()),
                    Float.parseFloat(txtUserRating.getText())
            );
        } else {
            //Edit a movie 'mode'
            movieToEdit.setName(txtMovieTitle.getText());
            movieToEdit.setImdbRating(Float.parseFloat(txtIMBDRating.getText()));
            movieToEdit.setUserRating(Float.parseFloat(txtUserRating.getText()));
            movieToEdit.setFileLink(txtFilePath.getText());

            logic.editMovie(movieToEdit);
        }
        ((Stage) btnCloseWindow.getScene().getWindow()).close();
    }

    public void setMovie(Movie movie){
        this.movieToEdit = movie;

        if(movieToEdit != null){
            txtMovieTitle.setText(movie.getName());
            txtIMBDRating.setText(String.valueOf(movie.getImdbRating()));
            txtUserRating.setText(String.valueOf(movie.getUserRating()));
            txtFilePath.setText(movie.getFileLink());
        }
    }
}
