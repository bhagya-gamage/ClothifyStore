package controller.form_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SupplierFormController {

    public TextField txtitem;
    public TableColumn colitem;
    @FXML
    private TableColumn<?, ?> colcomname;

    @FXML
    private TableColumn<?, ?> colsupaddress;

    @FXML
    private TableColumn<?, ?> colsupemail;

    @FXML
    private TableColumn<?, ?> colsupid;

    @FXML
    private TableColumn<?, ?> colsupname;

    @FXML
    private TableView<?> suppliertable;

    @FXML
    private TextField txtComname;

    @FXML
    private TextField txtSuoname;

    @FXML
    private TextField txtSupid;

    @FXML
    private TextField txtsupAddress;

    @FXML
    private TextField txtsupemail;

    @FXML
    void btnAddSupOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteSupOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashBoard_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateSupOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewSupOnAction(ActionEvent event) {

    }

}
