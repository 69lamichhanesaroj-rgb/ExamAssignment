package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.bll.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddCategoryController {
    Logic logic = new Logic();

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField categoryName;

    @FXML
    private Button saveBtn;

    public void btnCancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }


    public void btnSaveAction(ActionEvent event) throws SQLException {
        Category categoryNew = new Category(null, categoryName.getText());
        categoryNew.setName(categoryName.getText());

        logic.createCategory(categoryNew);


        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
