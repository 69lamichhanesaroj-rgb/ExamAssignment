package easv.college.examassignment.gui;

import easv.college.examassignment.MovieApplication;
import easv.college.examassignment.be.CatMovie;
import easv.college.examassignment.be.Category;
import easv.college.examassignment.be.Movie;
import easv.college.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    private TableColumn<?, ?> IMDBRatingColoumn;

    @FXML
    private Button addCategoryBtn;

    @FXML
    private Button addEditMovieBtn;

    @FXML
    private TableColumn<CatMovie, Category> catMovieColoumn;

    @FXML
    private ListView<Category> categoryList;

    @FXML
    private Button deleteMovieBtn;


    @FXML
    private Button deleteCategoryBtn;
    @FXML
    private Button closeMainStage;


    @FXML
    private TableColumn<?, ?> lastviewColoumn;

    @FXML
    private TableView<Movie> title;

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
    private TableColumn<Movie, String> movieTitleColoumn;

    @FXML
    private TableColumn<?, ?> userRatingColoumn;

    private Logic logic = new Logic();
    private final ObservableList<Movie> movieLibrary = FXCollections.observableArrayList();
    private final ObservableList<CatMovie> catMovieList = FXCollections.observableArrayList();
    private final ObservableList<Category> categoryLibrary = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadData();
      /*  try {
            categoryLibrary.addAll(logic.getAllCategories()); // load from db
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //catMovieColoumn.setItems(catMovieList);

       */
        // loadCategories();
    }

    private void LoadData() {
        List<Movie> movies = logic.getAllMovies();
        List<Category> categories = logic.getAllCategories();
        movieLibrary.addAll(movies);
        categoryLibrary.addAll(categories);
        title.setItems(movieLibrary);
        categoryList.setItems(categoryLibrary);
    }

    @FXML
    void addCategoryActionBtn(ActionEvent event) throws IOException {

        openWindow("addCategory-view.fxml", "Add Category");


    }


    @FXML
    void addEditMovieActionBtn(ActionEvent event) throws IOException {

        openWindow("newAndEditMovie-view.fxml", "Add Movie");


    }

    @FXML
    void deleteMovieActionBtn(ActionEvent event) throws IOException {
        Movie selectedMovie = title.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            showAlert("Please select a movie to delete");
            return;
        }

        openWindow("deleteMovie-view.fxml", "Delete Movie");
        DeleteMovieController deleteMovieController = new DeleteMovieController();
        deleteMovieController.setMovieToBeDeleted(selectedMovie);
        deleteMovieController.setMovieLibrary(movieLibrary);

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
        openWindow("deleteCategory-view.fxml", "Delete Category");
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

    private void openWindow(String fxmlFileName, String windowTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/easv/college/examassignment/%s".formatted(fxmlFileName)));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}