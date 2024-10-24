package service.custom.impl;

import dto.Employee;
import dto.Item;
import entity.EmployeeEntity;
import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ItemDao;
import repository.custom.impl.ItemDaoImpl;
import service.custom.ItemService;
import util.DaoType;

public class ItemServiceImpl implements ItemService {
    ItemDaoImpl itemDao=DaoFactory.getInstance().getDaoType(DaoType.ITEM);;

    @Override
    public boolean addItem(Item item) {
        return itemDao.save(new ModelMapper().map(item, ItemEntity.class));
    }

    @Override
    public boolean deleteItem(String id) {
        return itemDao.delete(id);
    }

    @Override
    public ObservableList<Item> getAll() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        itemDao.getAll().forEach(item -> {
            Item item1 = new ModelMapper().map(item,Item.class);
            items.add(item1);
        });
        return items;
    }

    @Override
    public boolean updateItem(Item item) {
           return itemDao.update(new ModelMapper().map(item, ItemEntity.class));
    }

    @Override
    public Item searchItem(String id) {
        ItemEntity itemEntity = itemDao.search(id);
        return itemEntity ==null? null : new ModelMapper().map(itemEntity, Item.class) ;
    }

    @Override
    public ObservableList<String> getAllItemIds() {
        ObservableList<ItemEntity> all = itemDao.getAll();
        ObservableList<String> itemId= FXCollections.observableArrayList();
        for (ItemEntity item : all){
            itemId.add(item.getItemId());
        }
        return itemId;
    }

}
