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

public class EmployeeMainFormController {

    @FXML
    private TableColumn<?, ?> colEmid;

    @FXML
    private TableColumn<?, ?> colemaddress;

    @FXML
    private TableColumn<?, ?> colemcomname;

    @FXML
    private TableColumn<?, ?> colememail;

    @FXML
    private TableColumn<?, ?> colemname;

    @FXML
    private TableView<?> employeetable;

    @FXML
    private TextField txtEmAddress;

    @FXML
    private TextField txtEmComname;

    @FXML
    private TextField txtEmid;

    @FXML
    private TextField txtEmname;

    @FXML
    void btnAddEmOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteEmOnAction(ActionEvent event) {

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
    void btnUpdateEmOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewEmOnAction(ActionEvent event) {

    }

}
