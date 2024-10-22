package controller.form_controllers;

import controller.dto_controllers.ItemController;
import dto.Employee;
import dto.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import service.custom.ItemService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsFormController implements Initializable {

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
    private TableView<Item> itemtable;

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
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);
        Item item = new Item(
                txtitemid.getText(),
                txtitemname.getText(),
                txtitemqty.getText(),
                txtprice.getText(),
                txtsize.getText()
        );

        itemService.addItem(item);
        if (itemService.addItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Added !!").show();
        }
    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

        itemService.deleteItem(txtitemid.getText());
        if (itemService.deleteItem(txtitemid.getText())){
            new Alert(Alert.AlertType.INFORMATION).show();
            //loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
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
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

        Item item = new Item(
                txtitemid.getText(),
                txtitemname.getText(),
                txtitemqty.getText(),
                txtprice.getText(),
                txtsize.getText()
        );

        itemService.updateItem(item);

        if (itemService.updateItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Updated!!").show();
            //loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Updated!!").show();
        }
    }

    @FXML
    void btnViewItemOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colitemid.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colitemname.setCellValueFactory(new PropertyValueFactory<>("description"));
        colitemqty.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colitemsize.setCellValueFactory(new PropertyValueFactory<>("qty"));
        //loadTable();
        itemtable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));
    }

    private void setTextToValues(Item newValue) {
        txtitemid.setText(newValue.getItemId());
        txtitemname.setText(newValue.getItemName());
        txtitemqty.setText(newValue.getItemQty());
        txtprice.setText(newValue.getItemSize());
        txtsize.setText(newValue.getUnitPrice());
    }

//    private void loadTable(){
//        ObservableList<Item> all = service1.getAll();
//        employeetable.setItems(all);
//    }
}
