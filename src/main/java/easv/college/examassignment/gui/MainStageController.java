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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    private TableColumn<Movie, Float> IMDBRatingColoumn;

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
    private TableColumn<Movie, Date> lastviewColoumn;

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
    private TableColumn<Movie, Float> userRatingColoumn;

    private Logic logic = new Logic();
    private final ObservableList<Movie> movieLibrary = FXCollections.observableArrayList();
    private final ObservableList<CatMovie> catMovieList = FXCollections.observableArrayList();
    private final ObservableList<Category> categoryLibrary = FXCollections.observableArrayList();

    Movie movieToDelete;
    Category categoryToDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        doubleClickToPlay();
    }

    /**
     * Do NOT use this method for refreshing data
     */
    private void loadData() {
        lastviewColoumn.setCellValueFactory(new PropertyValueFactory<>("lastView"));
        movieTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
        IMDBRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("imdbRating"));

        movieLibrary.addAll(logic.getAllMovies());
        categoryLibrary.addAll(logic.getAllCategories());
        title.setItems(movieLibrary);
        categoryList.setItems(categoryLibrary);
    }

    /**
     * Use this method for refreshing data
     */
    private void refreshData() {
        movieLibrary.removeAll();
        movieLibrary.addAll(logic.getAllMovies());
        title.setItems(movieLibrary);

        categoryLibrary.removeAll();
        categoryLibrary.addAll(logic.getAllCategories());
        categoryList.setItems(categoryLibrary);
    }

    public void addCategoryActionBtn(ActionEvent event) throws IOException {

        openWindow("addCategory-view.fxml", "Add Category");


    }

    public void addEditMovieActionBtn(ActionEvent event) throws IOException {

        openWindow("newAndEditMovie-view.fxml", "Add Movie");


    }

    public void deleteMovieActionBtn(ActionEvent event) {
        Movie selectedMovie = title.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            warningPopUp.setText("Please select a movie to delete");
            return;
        }

        if (movieToDelete == null) {
            warningPopUp.setText("Are you sure you want to delete " + selectedMovie.getName() + " ?");
            movieToDelete = selectedMovie;
        } else if (Objects.equals(movieToDelete, selectedMovie)) {
            movieLibrary.remove(selectedMovie);
            logic.deleteMovie(selectedMovie);
            title.getSelectionModel().clearSelection();
            warningPopUp.setText(" Movie Deleted! ");
            movieToDelete = null;
        } else {
            warningPopUp.setText("Are you sure you want to delete " + selectedMovie.getName() + " ?");
            movieToDelete = selectedMovie;
        }
    }

    public void clearActionBtn(ActionEvent event) {
        searchBox.clear();
        ratingIMBD.selectToggle(null);
        movieLibrary.setAll(logic.getAllMovies());
        title.setItems(movieLibrary);


    }

    public void closeMainStageAction(ActionEvent event) {
        Stage stage = (Stage) closeMainStage.getScene().getWindow();
        stage.close();
    }

    public void deleteCategoryActionBtn(ActionEvent event) {
        Category selectedCategory = categoryList.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            warningPopUp.setText("Please select a category to delete");
            return;
        }

        if (categoryToDelete == null) {
            warningPopUp.setText("Are you sure you want to delete " + selectedCategory.getName() + " ?");
            categoryToDelete = selectedCategory;
        } else if (Objects.equals(categoryToDelete, selectedCategory)) {
            categoryLibrary.remove(selectedCategory);
            logic.deleteCategory(selectedCategory);
            categoryList.getSelectionModel().clearSelection();
            warningPopUp.setText(" Category Deleted! ");
            categoryToDelete = null;
        } else {
            warningPopUp.setText("Are you sure you want to delete " + selectedCategory.getName() + " ?");
            categoryToDelete = selectedCategory;
        }
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

    public void onSearchBtnPress(MouseEvent event) {
        String searchText = searchBox.getText();
        Toggle selectedToggle = ratingIMBD.getSelectedToggle();
        Integer selectedRating = null;
        if (selectedToggle != null) {
            RadioButton radioButton = (RadioButton) selectedToggle;
            selectedRating = Integer.parseInt(radioButton.getText());
        }
    }

    public void doubleClickToPlay(){
        title.setRowFactory(tv -> {
            TableRow<Movie> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Movie selectedMovie = row.getItem();
                    logic.playMovie(selectedMovie);
                }
            });

            return row;
        });
    }
}


