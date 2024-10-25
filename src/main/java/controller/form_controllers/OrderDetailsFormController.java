package controller.form_controllers;

import controller.dto_controllers.EmployeeController;
import controller.dto_controllers.OrderController;
import dto.Employee;
import dto.Order;
import dto.OrderDetails;
import entity.OrderEntity;
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
import service.custom.OrderService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsFormController implements Initializable {

    public TextField txtcustname;
    public TextField txtcustaddress;
    public TextField txtemail;
    public TextField txtdate;
    public TextField txttotal;
    public TableColumn colocustname;
    public TableColumn colocustemail;
    @FXML
    private TableColumn<?, ?> coldate;


    @FXML
    private TableColumn<?, ?> coloorderid;

    @FXML
    private TableColumn<?, ?> coltimece;

    @FXML
    private TableColumn<?, ?> coltotal;

    @FXML
    private TableView<OrderDetails> ordertable;

    @FXML
    private TextField txtorderid;

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
    void btnSearchOrderOnAction(ActionEvent event) {
        String orderId = txtorderid.getText().trim();

        if (orderId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Order Id ").showAndWait();
        }else{
            OrderEntity order= OrderController.getInstance().searchOrderById(orderId);
            if (order==null){
                new Alert(Alert.AlertType.ERROR,"Order Not Found ").showAndWait();
            }else {
                txtorderid.setEditable(false);
                txtcustname.setText(order.getCustName());
                txtcustaddress.setText(order.getCustEmail());
                txtdate.setText(String.valueOf(order.getOrderDate()));
                txtemail.setText(String.valueOf(order.getOrderTime()));
                txttotal.setText(String.valueOf(order.getOrderTotal()));
            }
        }
    }

    OrderService orderService = ServiceFactory.getInstance().getServiceType(ServiceType.ORDER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coloorderid.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colocustname.setCellValueFactory(new PropertyValueFactory<>("custName"));
        colocustemail.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        coltimece.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
        coltotal.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));

        loadTable();
        ordertable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));
    }

    private void setTextToValues(OrderDetails newValue) {
//        txtorderid.setText(String.valueOf(newValue.getOrder()));
//        txtcustname.setText(newValue.g());
//        txtEmComname.setText(newValue.getCompanyName());
//        txtEmAddress.setText(newValue.getEmpAddress());
//        txtEmEmail.setText(newValue.getEmpEmail());
    }

    private void loadTable(){
        ObservableList<OrderDetails> all = orderService.getAllOrders();
        ordertable.setItems(all);
    }
}
