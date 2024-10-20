package controller.form_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemsFormController {

    @FXML
    private ComboBox<?> cmbitemtype;

    @FXML
    private TableColumn<?, ?> colitemid;

    @FXML
    private TableColumn<?, ?> colitemname;

    @FXML
    private TableColumn<?, ?> colitemqty;

    @FXML
    private TableColumn<?, ?> colitemsize;

    @FXML
    private TableColumn<?, ?> colitemtype;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableView<?> itemtable;

    @FXML
    private TextField txtitemid;

    @FXML
    private TextField txtitemname;

    @FXML
    private TextField txtitemqty;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtsize;

    @FXML
    void btnAddItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

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
    void btnUpdateItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewItemOnAction(ActionEvent event) {

    }

}
