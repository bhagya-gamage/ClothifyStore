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

    private int num = 1;

    EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);

    @FXML
    void btnAddEmOnAction(ActionEvent event) {

        Employee employee = new Employee(
                txtEmid.getText(),
                txtEmname.getText(),
                txtEmComname.getText(),
                txtEmAddress.getText(),
                txtEmEmail.getText()
        );
        if (employeeService.addEmployee(employee)){
            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Added !!").show();
        }
        loadTable();
    }

    private void loadTable(){
        ObservableList<Employee> all = employeeService.getAllEmployees();
        all.forEach(employee -> {
            System.out.println(employee);
        });
        employeetable.setItems(all);
    }

    @FXML
    void btnDeleteEmOnAction(ActionEvent event) {
        if (employeeService.deleteEmployee(txtEmid.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
            loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Not Deleted").show();
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
           loadTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Employee Not Updated!!").show();
        }
    }

    @FXML
    void btnViewEmOnAction(ActionEvent event) {
        String employeeId = txtEmid.getText().trim();

        if (employeeId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter Employee Id ").showAndWait();
        }else{
            Employee employee= EmployeeController.getInstance().searchEmployeeById(employeeId);
            if (employee==null){
                new Alert(Alert.AlertType.ERROR,"Employee Not Found ").showAndWait();
            }else {
                txtEmid.setEditable(false);
                txtEmname.setText(employee.getEmpId());
                txtEmComname.setText(employee.getCompanyName());
                txtEmAddress.setText(employee.getEmpAddress());
                txtEmEmail.setText(employee.getEmpEmail());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        colEmid.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colemname.setCellValueFactory(new PropertyValueFactory<>("empName"));
        colemcomname.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colemaddress.setCellValueFactory(new PropertyValueFactory<>("empAddress"));
        colememail.setCellValueFactory(new PropertyValueFactory<>("empEmail"));
        loadTable();
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

    private void generateId(){

        String id="";
        if(num<10){
            id=("EM000"+ num++);
            txtEmid.setText(id);
        }else if(num<100){
            id=("EM00"+ num++);
            txtEmid.setText(id);
        }else if(num<1000){
            id=("EM0"+ num++);
            txtEmid.setText(id);
        }else if(num<10000){
            id="EM"+ num++;
            txtEmid.setText(id);
        }

    }


}
