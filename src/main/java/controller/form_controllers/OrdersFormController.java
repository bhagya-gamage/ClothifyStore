package controller.form_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersFormController {

    @FXML
    private ComboBox<?> cmbitemid;

    @FXML
    private TableColumn<?, ?> coloitemid;

    @FXML
    private TableColumn<?, ?> coloitemname;

    @FXML
    private TableColumn<?, ?> coloqty;

    @FXML
    private TableColumn<?, ?> colototal;

    @FXML
    private TableColumn<?, ?> colounitprice;

    @FXML
    private Label lbltot;

    @FXML
    private TableView<?> ordertable;

    @FXML
    private TextField txtempid;

    @FXML
    private TextField txtitemname;

    @FXML
    private TextField txtitemsize;

    @FXML
    private TextField txtorderid;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtunitprice;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        coloitemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        coloitemname.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        coloqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colounitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colototal.setCellValueFactory(new PropertyValueFactory<>("total"));

        String itemId = cmbitemid.getValue().toString();
        String itemName = txtitemname.getText();
        Integer qty = Integer.parseInt(txtqty.getText());
        Double unitPrice = Double.parseDouble(txtunitprice.getText());
        Double total = unitPrice*qty;



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
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
