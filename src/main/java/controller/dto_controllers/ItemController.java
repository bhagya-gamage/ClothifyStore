package controller.dto_controllers;


import service.custom.ItemService;

import service.custom.impl.ItemServiceImpl;

public class ItemController {
    private final ItemService itemService= new ItemServiceImpl();
    private static ItemController instance;
    private ItemController(){}


    public static ItemController getInstance() {
        return instance==null?instance=new ItemController():instance;
    }
}
