package controller.dto_controllers;


import dto.Employee;
import dto.Item;
import javafx.collections.ObservableList;
import service.custom.ItemService;

import service.custom.impl.ItemServiceImpl;

public class ItemController {
    private final ItemService itemService= new ItemServiceImpl();
    private static ItemController instance;
    private ItemController(){}


    public static ItemController getInstance() {
        return instance==null?instance=new ItemController():instance;
    }

    public boolean addItem(Item item){
        return itemService.addItem(item);
    }

    public Item searchItem(String id){
        return itemService.searchItem(id);
    }

    public boolean updateItem(Item item){
        return itemService.updateItem(item);
    }
    public boolean deleteItem(String id){
        return itemService.deleteItem(id);
    }
//    public ObservableList<String> getAll(){
//        return itemService.getAll();
//    }
}
