package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.dal.CategoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddCategoryController {

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField categoryName;

    @FXML
    private Button saveBtn;

    @FXML
    void btnCancelAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnSaveAction(ActionEvent event) throws SQLException {
        Category categoryNew = new Category(null, categoryName.getText());
        categoryNew.setName(categoryName.getText());

        CategoryDAO dao = new CategoryDAO();
        dao.addCategory(categoryNew);

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();





    }

}
