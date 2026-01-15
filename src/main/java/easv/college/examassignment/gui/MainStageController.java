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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public class MainStageController implements Initializable {

    @FXML
    private TableColumn<Movie, Float> IMDBRatingColoumn;

    @FXML
    private TableColumn<CatMovie, Category> catMovieColoumn;

    @FXML
    private ListView<Category> categoryList;

    @FXML
    private Button closeMainStage;

    @FXML
    private TableColumn<Movie, Date> lastviewColoumn;

    @FXML
    private TableView<Movie> title;

    @FXML
    private ToggleGroup ratingIMBD;

    @FXML
    private TextField searchBox;

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
        unwantedMovies();
        unwatchedMovies();
    }

    /**
     * Do NOT use this method for refreshing data
     */
    private void loadData() {
        lastviewColoumn.setCellValueFactory(new PropertyValueFactory<>("lastView"));
        movieTitleColoumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
        IMDBRatingColoumn.setCellValueFactory(new PropertyValueFactory<>("imdbRating"));
        catMovieColoumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        movieLibrary.addAll(logic.getAllMovies());
        categoryLibrary.addAll(logic.getAllCategories());
        title.setItems(movieLibrary);
        categoryList.setItems(categoryLibrary);
    }

    /**
     * Use this method for refreshing data
     */
    private void refreshData() {
        movieLibrary.clear();
        movieLibrary.addAll(logic.getAllMovies());
        title.setItems(movieLibrary);

        categoryLibrary.clear();
        categoryLibrary.addAll(logic.getAllCategories());
        categoryList.setItems(categoryLibrary);
    }

    public void addCategoryActionBtn(ActionEvent event) throws IOException {

        openWindow("addCategory-view.fxml", "Add Category");


    }

    public void addEditMovieActionBtn(ActionEvent event) throws IOException {
        Movie selectedMovie = title.getSelectionModel().getSelectedItem();
        openMovieWindow(selectedMovie);
    }

    private void openMovieWindow(Movie movie) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                MovieApplication.class.getResource(
                        "/easv/college/examassignment/newAndEditMovie-view.fxml"
                )
        );

        Parent root = loader.load();

        NewMovieController controller = loader.getController();
        controller.setMovie(movie);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(movie == null ? "Add Movie" : "Edit Movie");
        stage.setResizable(false);
        stage.showAndWait();

        refreshData();
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


    private void openWindow(String fxmlFileName, String windowTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/easv/college/examassignment/%s".formatted(fxmlFileName)));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
        refreshData();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void onSearchBtnPress(ActionEvent event) {
        String searchText = searchBox.getText();
        Toggle selectedToggle = ratingIMBD.getSelectedToggle();
        Float selectedRating = null;
        if (selectedToggle != null) {
            RadioButton radioButton = (RadioButton) selectedToggle;
            selectedRating = Float.parseFloat(radioButton.getText());
        }
        List<Movie> movies = logic.filterMovies(searchText, selectedRating);
        title.setItems(FXCollections.observableArrayList(movies));
    }

    public void doubleClickToPlay() {
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

    private void unwantedMovies()
    {
        for (Movie movie : movieLibrary)
        {
            if (movie.getUserRating() <= 6)
            {
                showAlert("You have movies with a score of 6 or lower");
            }
        }
    }

    private void unwatchedMovies()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        Date twoYearsAgo = calendar.getTime();

        boolean foundUnwatched = false;

        for (Movie movie : movieLibrary)
        {
            java.sql.Date lastView = movie.getLastView();

            if (lastView != null && lastView.before(twoYearsAgo))
            {
                foundUnwatched = true;
                break;
            }
        }

        if (foundUnwatched)
        {
            showAlert("You have movies you haven't watched for two years");
        }
    }
}


