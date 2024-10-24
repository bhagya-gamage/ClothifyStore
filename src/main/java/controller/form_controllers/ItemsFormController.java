package controller.form_controllers;

import controller.dto_controllers.EmployeeController;
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

    private int num = 1;


    ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

    @FXML
    void btnAddItemOnAction(ActionEvent event) {
        Item item = new Item(
                txtitemid.getText(),
                txtitemname.getText(),
                txtitemqty.getText(),
                txtprice.getText(),
                txtsize.getText()
        );

        if (itemService.addItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Added !!").show();
        }
        loadTable();
    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

        if (itemService.deleteItem(txtitemid.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Item Deleted").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Deleted").show();
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
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Item Not Updated!!").show();
        }
    }

    @FXML
    void btnViewItemOnAction(ActionEvent event) {
        String itemId = txtitemid.getText().trim();

        if (itemId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Item Id ").showAndWait();
        }else{
            Item item= ItemController.getInstance().searchItem(itemId);
            if (item==null){
                new Alert(Alert.AlertType.ERROR,"Item Not Found ").showAndWait();
            }else {
                txtitemid.setEditable(false);
                txtitemname.setText(item.getItemId());
                txtitemqty.setText(String.valueOf(item.getItemQty()));
                txtprice.setText(String.valueOf(item.getUnitPrice()));
                txtsize.setText(item.getItemSize());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        colitemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colitemname.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colitemqty.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colitemsize.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        loadTable();
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

    private void loadTable(){
        ObservableList<Item> all = itemService.getAll();
        itemtable.setItems(all);
    }

    private void generateId(){

        String id="";
        if(num<10){
            id=("I000"+ num++);
            txtitemid.setText(id);
        }else if(num<100){
            id=("I00"+ num++);
            txtitemid.setText(id);
        }else if(num<1000){
            id=("I"+ num++);
            txtitemid.setText(id);
        }else if(num<10000){
            id="I"+ num++;
            txtitemid.setText(id);
        }

    }

}
