package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.dal.CategoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteCategoryController {
    private Category categoryToBeDeleted;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    void cancelBtnAction(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void deleteBtnAction(ActionEvent event) {

        CategoryDAO dao = new CategoryDAO();
        try {
            dao.DeleteCategory(categoryToBeDeleted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Stage stage = (Stage) deleteBtn.getScene().getWindow();
        stage.close();

    }
    public void setCategoryToBeDeleted(Category categoryToBeDeleted) {

        this.categoryToBeDeleted = categoryToBeDeleted;
    }
}


