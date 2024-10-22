package controller.dto_controllers;


import service.custom.SupplierService;

import service.custom.impl.SupplierServiceImpl;

public class SupplierController {
    private final SupplierService supplierService= new SupplierServiceImpl();
    private static SupplierController instance;
    private SupplierController(){}


    public static SupplierController getInstance() {
        return instance==null?instance=new SupplierController():instance;
    }
}
