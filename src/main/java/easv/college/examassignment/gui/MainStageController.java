package easv.college.examassignment.gui;

import easv.college.examassignment.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStageController {

    @FXML
    private TableColumn<?, ?> IMDBRatingColoumn;

    @FXML
    private Button addCategoryBtn;

    @FXML
    private Button addMovieBtn;

    @FXML
    private TableColumn<?, ?> categoryColoumn;

    @FXML
    private ListView<?> categoryList;

    @FXML
    private Button deleteMovieBtn;

    @FXML
    private Button editMovieBtn;

    @FXML
    private Button deleteCategoryBtn;
    @FXML
    private Button closeMainStage;


    @FXML
    private TableColumn<?, ?> lastviewColoumn;

    @FXML
    private TableView<?> movieTitleColoumn;

    @FXML
    private RadioButton rating2;

    @FXML
    private RadioButton rating3;

    @FXML
    private RadioButton rating4;

    @FXML
    private RadioButton rating5;

    @FXML
    private RadioButton rating6;

    @FXML
    private RadioButton rating7;

    @FXML
    private RadioButton rating8;

    @FXML
    private RadioButton rating9;

    @FXML
    private ToggleGroup ratingIMBD;

    @FXML
    private TextField searchBox;

    @FXML
    private Button searchMovie;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private TableColumn<?, ?> userRatingColoumn;

    @FXML
    void addCategoryActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/addCategory-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Add Category");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void addMovieActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/newMovie-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Add Movie");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void deleteMovieActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/deleteMovie-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Delete Movie");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void editMovieActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/editMovie-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Edit Movie");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void clearActionBtn(ActionEvent event) {

    }

    @FXML
    void closeMainStageAction(ActionEvent event) {
        Stage stage = (Stage) closeMainStage.getScene().getWindow();
        stage.close();

    }

    @FXML
    void deleteCategoryActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/deleteCategory-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Delete Category");
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void radioBtn2Action(MouseEvent event) {

    }

    @FXML
    void radioBtn3Action(MouseEvent event) {

    }

    @FXML
    void radioBtn4Action(MouseEvent event) {

    }

    @FXML
    void radioBtn5Action(MouseEvent event) {

    }

    @FXML
    void radioBtn6Action(MouseEvent event) {

    }

    @FXML
    void radioBtn7Action(MouseEvent event) {

    }

    @FXML
    void radioBtn8Action(MouseEvent event) {

    }

    @FXML
    void radioBtn9Action(MouseEvent event) {

    }

    @FXML
    void searchActionBtn(MouseEvent event) {

    }

}
