package controller.dto_controllers;


import dto.Item;
import dto.Supplier;
import javafx.scene.control.Alert;
import service.custom.SupplierService;

import service.custom.impl.SupplierServiceImpl;

import java.util.regex.Pattern;

public class SupplierController {
    private final SupplierService supplierService= new SupplierServiceImpl();
    private static SupplierController instance;
    private SupplierController(){}


    public static SupplierController getInstance() {
        return instance==null?instance=new SupplierController():instance;
    }

    public boolean addSupplier(Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    public Supplier searchSupplier(String id){
        return supplierService.searchSupplier(id);
    }

    public boolean updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id){
        return supplierService.deleteSupplier(id);
    }


}
