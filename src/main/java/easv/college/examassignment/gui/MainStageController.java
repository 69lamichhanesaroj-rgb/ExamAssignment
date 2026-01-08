package easv.college.examassignment.gui;

import easv.college.examassignment.HelloApplication;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    private TableColumn<?, ?> IMDBRatingColoumn;

    @FXML
    private Button addCategoryBtn;

    @FXML
    private Button addEditMovieBtn;

    @FXML
    private TableColumn<CatMovie,Category> catMovieColoumn;

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
    private TableView<Movie> movieTitleColoumn;

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
    private TableColumn<Movie,String> title;

    @FXML
    private TableColumn<?, ?> userRatingColoumn;

    private Logic logic;
    private ObservableList<Movie> movieLibrary;
    private ObservableList<CatMovie> catMovieList; // selected catedgory to the specific movie
    private ObservableList<Category> categoryLibrary;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logic = new Logic();
        movieLibrary = FXCollections.observableArrayList();
        catMovieList = FXCollections.observableArrayList();
        categoryLibrary = FXCollections.observableArrayList();

        movieTitleColoumn.setItems(movieLibrary);
        //catMovieColoumn.setItems(catMovieList);






    }

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
    void addEditMovieActionBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/easv/college/examassignment/newAndEditMovie-view.fxml"));
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
