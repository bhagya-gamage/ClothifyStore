package controller.form_controllers;

import dto.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {

    @FXML
    private ComboBox<?> cmbusertype;

    @FXML
    private TextField txtconfpassword;

    @FXML
    private TextField txtuseremail;

    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtuserpassword;

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
    void btnRegisterOnAction(ActionEvent event) {
//        Employee employee = new Employee(
//                cmbusertype.getValue().toString(),
//                txtusername.getText(),
//                txtuseremail.getText(),
//                txtuserpassword.getText(),
//                txtconfpassword.getText()
//        );
//
//        if (){
//            new Alert(Alert.AlertType.INFORMATION," Registered !!").show();
//
//        }else {
//            new Alert(Alert.AlertType.ERROR,"Not Registered !!").show();
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<String> type= FXCollections.observableArrayList();
//        type.add("Admin");
//        type.add("Employee");
//        cmbusertype.setItems(type);
    }
}
