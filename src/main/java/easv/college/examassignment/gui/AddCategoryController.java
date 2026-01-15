package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.bll.Logic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class AddCategoryController {
    Logic logic = new Logic();

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField categoryName;

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
