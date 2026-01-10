package easv.college.examassignment.gui;

import easv.college.examassignment.be.Movie;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteMovieController {
    /**
     * This class is supposed to be deleted
     * Do not change anything here
     */

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteBtn;

    private Movie movieToBeDeleted;
    private ObservableList<Movie> movieLibrary;


    public void setMovieToBeDeleted(Movie movie) {
        this.movieToBeDeleted = movie;
    }
    public void setMovieLibrary(ObservableList<Movie> movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    @FXML
    void cancelBtnAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void deleteBtnAction(ActionEvent event) {

        if(movieToBeDeleted ==null){
    return;
    }
        movieLibrary.remove(movieToBeDeleted);


    }

}
