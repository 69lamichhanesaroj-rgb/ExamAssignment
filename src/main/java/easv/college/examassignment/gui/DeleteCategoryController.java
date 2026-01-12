package easv.college.examassignment.gui;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.dal.CategoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteCategoryController {
    /**
     * This class is supposed to be deleted
     * Do not change anything here
     */
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
        dao.deleteCategory(categoryToBeDeleted);

        Stage stage = (Stage) deleteBtn.getScene().getWindow();
        stage.close();

    }
    public void setCategoryToBeDeleted(Category categoryToBeDeleted) {

        this.categoryToBeDeleted = categoryToBeDeleted;
    }
}


