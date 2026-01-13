package easv.college.examassignment.examassignment.gui;

import easv.college.examassignment.examassignment.MovieApplication;
import easv.college.examassignment.examassignment.be.CatMovie;
import easv.college.examassignment.examassignment.be.Category;
import easv.college.examassignment.examassignment.be.Movie;
import easv.college.examassignment.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Label warningPopUp;

    @FXML
    private TableColumn<Movie, String> movieTitleColoumn;

    @FXML
    private TableColumn<?, ?> userRatingColoumn;

    private boolean areYouSure;

    private Logic logic = new Logic();
    private final ObservableList<Movie> movieLibrary = FXCollections.observableArrayList();
    private final ObservableList<CatMovie> catMovieList = FXCollections.observableArrayList();
    private final ObservableList<Category> categoryLibrary = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
      /*  try {
            categoryLibrary.addAll(logic.getAllCategories()); // load from db
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //catMovieColoumn.setItems(catMovieList);

       */
        // loadCategories();
    }

    private void loadData() {
        lastviewColoumn.setCellValueFactory(new PropertyValueFactory<>("lastView"));
        movieTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
        IMDBRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("imdbRating"));

        List<Movie> movies = logic.getAllMovies();
        List<Category> categories = logic.getAllCategories();
        movieLibrary.addAll(movies);
        categoryLibrary.addAll(categories);
        title.setItems(movieLibrary);
        categoryList.setItems(categoryLibrary);
    }

    public void addCategoryActionBtn(ActionEvent event) throws IOException {

        openWindow("addCategory-view.fxml", "Add Category");


    }

    public void addEditMovieActionBtn(ActionEvent event) throws IOException {

        openWindow("newAndEditMovie-view.fxml", "Add Movie");


    }

    public void deleteMovieActionBtn(ActionEvent event) throws IOException {
        Movie selectedMovie = title.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            warningPopUp.setText("Please select a movie to delete");
            return;
        }
        else if(!areYouSure) {warningPopUp.setText("Are you sure you want to delete" + selectedMovie.getName());
        areYouSure = true;
        return;}

        movieLibrary.remove(selectedMovie);
        System.out.println("Movie deleted");
        areYouSure = false;


    }

    public void clearActionBtn(ActionEvent event) {

    }

    public void closeMainStageAction(ActionEvent event) {
        Stage stage = (Stage) closeMainStage.getScene().getWindow();
        stage.close();
    }

    public void deleteCategoryActionBtn(ActionEvent event) throws IOException {
         Category selectedCategory = categoryList.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            warningPopUp.setText("Please select a category to delete");
            return;
        }
        else if(!areYouSure) {warningPopUp.setText("Are you sure you want to delete" + selectedCategory.getName());
        areYouSure = true;
        return;}
        logic.deleteCategory(selectedCategory);
        loadData();
        areYouSure = false;


    }

    public void radioBtn2Action(MouseEvent event) {

    }

    public void radioBtn3Action(MouseEvent event) {

    }

    public void radioBtn4Action(MouseEvent event) {

    }

    public void radioBtn5Action(MouseEvent event) {

    }

    public void radioBtn6Action(MouseEvent event) {

    }

    public void radioBtn7Action(MouseEvent event) {

    }

    public void radioBtn8Action(MouseEvent event) {

    }

    public void radioBtn9Action(MouseEvent event) {

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

    public void searchActionBtn(MouseEvent event) {
        String searchText = searchBox.getText();
        Toggle selectedToggle = ratingIMBD.getSelectedToggle();
        int selectedRating = 0;
        if (selectedToggle != null) {
            RadioButton radioButton = (RadioButton) selectedToggle;
            selectedRating = Integer.parseInt(radioButton.getText());
        }

    }
}