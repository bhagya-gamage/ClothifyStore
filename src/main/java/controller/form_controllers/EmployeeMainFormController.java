package controller.form_controllers;

import dto.Employee;
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
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeMainFormController implements Initializable {

    public TextField txtEmEmail;
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
    private TableView<Employee> employeetable;

    @FXML
    private TextField txtEmAddress;

    @FXML
    private TextField txtEmComname;

    @FXML
    private TextField txtEmid;

    @FXML
    private TextField txtEmname;

    //EmployeeService service = EmployeeController.getInstance();

    @FXML
    void btnAddEmOnAction(ActionEvent event) {

        EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);
        Employee employee = new Employee(
                txtEmid.getText(),
                txtEmname.getText(),
                txtEmComname.getText(),
                txtEmAddress.getText(),
                txtEmEmail.getText()
        );

        employeeService.addEmployee(employee);
        if (employeeService.addEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added !!").show();
        }
    }

//    private void loadTable(){
//        ObservableList<Employee> all = service.getAll();
//        employeetable.setItems(all);
//    }

    @FXML
    void btnDeleteEmOnAction(ActionEvent event) {

        EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

        employeeService.deleteEmployee(txtEmid.getText());
        if (employeeService.deleteEmployee(txtEmid.getText())){
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
    void btnUpdateEmOnAction(ActionEvent event) {

        EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

        Employee employee = new Employee(
                txtEmid.getText(),
                txtEmname.getText(),
                txtEmComname.getText(),
                txtEmAddress.getText(),
                txtEmEmail.getText()
        );

        employeeService.updateEmployee(employee);

        if (employeeService.updateEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Updated!!").show();
           // loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Updated!!").show();
        }
    }

    @FXML
    void btnViewEmOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmid.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colemname.setCellValueFactory(new PropertyValueFactory<>("description"));
        colemcomname.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colemaddress.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colememail.setCellValueFactory(new PropertyValueFactory<>("qty"));
        //loadTable();
        employeetable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        }));
    }

    private void setTextToValues(Employee newValue) {
        txtEmid.setText(newValue.getEmpId());
        txtEmname.setText(newValue.getEmpName());
        txtEmComname.setText(newValue.getCompanyName());
        txtEmAddress.setText(newValue.getEmpAddress());
        txtEmEmail.setText(newValue.getEmpEmail());
    }


}
