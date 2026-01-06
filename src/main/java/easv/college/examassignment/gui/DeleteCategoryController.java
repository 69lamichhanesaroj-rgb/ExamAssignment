package easv.college.examassignment.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteCategoryController {

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

    }

}
