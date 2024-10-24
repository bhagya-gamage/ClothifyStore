package controller.form_controllers;

import dto.Employee;
import dto.Item;
import dto.Supplier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import service.custom.ItemService;
import service.custom.SupplierService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

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
    private TableView<Supplier> suppliertable;

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

    SupplierService supplierService = ServiceFactory.getInstance().getServiceType(ServiceType.SUPPLIER);

    @FXML
    void btnAddSupOnAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                txtSupid.getText(),
                txtSuoname.getText(),
                txtComname.getText(),
                txtsupAddress.getText(),
                txtsupemail.getText(),
                txtitem.getText()
        );

        if (supplierService.addSupplier(supplier)){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Supplier Not Added !!").show();
        }
        loadTable();
    }

    @FXML
    void btnDeleteSupOnAction(ActionEvent event) {
        if (supplierService.deleteSupplier(txtSupid.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Deleted").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Supplier Not Deleted").show();
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
    void btnUpdateSupOnAction(ActionEvent event) {

        Supplier supplier = new Supplier(
                txtSupid.getText(),
                txtSuoname.getText(),
                txtComname.getText(),
                txtsupAddress.getText(),
                txtsupemail.getText(),
                txtitem.getText()
        );

        supplierService.updateSupplier(supplier);

        if (supplierService.updateSupplier(supplier)){
            new Alert(Alert.AlertType.INFORMATION,"Supplier Updated!!").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Supplier Not Updated!!").show();
        }

    }

    @FXML
    void btnViewSupOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colsupid.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colsupname.setCellValueFactory(new PropertyValueFactory<>("supName"));
        colcomname.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colsupaddress.setCellValueFactory(new PropertyValueFactory<>("supAddress"));
        colsupemail.setCellValueFactory(new PropertyValueFactory<>("supEmail"));
        colitem.setCellValueFactory(new PropertyValueFactory<>("item"));
        loadTable();
        suppliertable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));
    }

    private void setTextToValues(Supplier newValue) {
        txtSupid.setText(newValue.getSupId());
        txtSuoname.setText(newValue.getSupName());
        txtComname.setText(newValue.getCompanyName());
        txtsupAddress.setText(newValue.getSupAddress());
        txtsupemail.setText(newValue.getSupEmail());
        txtitem.setText(newValue.getItem());
    }


    private void loadTable(){
        ObservableList<Supplier> all = supplierService.getAll();
        suppliertable.setItems(all);
    }

}
