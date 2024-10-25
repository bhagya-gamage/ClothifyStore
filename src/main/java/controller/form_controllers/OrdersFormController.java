package controller.form_controllers;

import controller.dto_controllers.ItemController;
import controller.dto_controllers.OrderController;
import dto.Cart;
import dto.Item;
import dto.Order;
import dto.OrderDetails;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersFormController implements Initializable {

    public TextField txtcustid;
    public TextField txtcustname;
    public TextField txtcustemail;
    public Label lblTime;
    public Label lblDate;
    public TextField txtCustname;
    public TextField txtcustEmail;
    @FXML
    private ComboBox<String> cmbitemid;

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
    private TableView<Cart> ordertable;

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

    ObservableList<Cart> cart = FXCollections.observableArrayList();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        coloitemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        coloitemname.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        coloqty.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        colounitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colototal.setCellValueFactory(new PropertyValueFactory<>("total"));

        String itemId = cmbitemid.getValue().toString();
        String itemName = txtitemname.getText();
        Integer qty = Integer.parseInt(txtqty.getText());
        Double unitPrice = Double.parseDouble(txtunitprice.getText());
        String itemSize = txtitemsize.getText();
        Double total = unitPrice*qty;

        cart.add(new Cart(itemId,itemName,qty,unitPrice,itemSize,total));
        calcNetTotal();

        ordertable.setItems(cart);
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
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException {
        String orderId = txtorderid.getText();

        Order order=new Order(orderId,LocalTime.now(),Double.parseDouble(lbltot.getText()),txtCustname.getText(),txtcustEmail.getText(),LocalDate.now());
        ObservableList <OrderDetails> orderDetails =  FXCollections.observableArrayList();
        cart.forEach(obj-> {
            orderDetails.add(new OrderDetails(order,obj.getItemId(),obj.getItemName(),obj.getItemQty(),obj.getUnitPrice(),obj.getItemSize()));
        });

        OrderController.getInstance().placeOrder(order,orderDetails);
        new Alert(Alert.AlertType.INFORMATION,"Order Added !!").show();

//        if(){
//            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();
//        }else{
//            new Alert(Alert.AlertType.INFORMATION,"Employee Added !!").show();
//        }

    }

    private void calcNetTotal(){
        Double total = 0.0;

        for(Cart cart1:cart){
            total+=cart1.getTotal();
        }

        lbltot.setText(total.toString());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemIds();
        cmbitemid.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue)->{
            if (newValue!=null){
                textToTextFiels(newValue);
            }
        }));
        loadDateAndTime();
    }

    private void textToTextFiels(String id) {
        Item item = ItemController.getInstance().searchItem(id);
        txtitemname.setText(item.getItemName());
        txtitemsize.setText(item.getItemSize());
        txtunitprice.setText(item.getUnitPrice());
    }

    private void loadDateAndTime() {

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = f.format(date);
        lblDate.setText(dateNow);

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime now = LocalTime.now();
            lblTime.setText(now.getHour()+" : "+now.getMinute()+" : "+now.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadItemIds(){
        ObservableList<String> ids =ItemController.getInstance().getItemIds();
        cmbitemid.setItems(ids);
    }
}
