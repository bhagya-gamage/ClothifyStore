package service.custom.impl;

import dto.Item;
import entity.ItemEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ItemDao;
import service.custom.ItemService;
import util.DaoType;

public class ItemServiceImpl implements ItemService {
    @Override
    public boolean addItem(Item item) {
        ItemEntity entity = new ModelMapper().map(item, ItemEntity.class);

        ItemDao itemDao = DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

        itemDao.save(entity);

        System.out.println("Service Layer : " + item);
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public ObservableList<Item> getAll() {
        return null;
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public Item searchItem(String id) {
        return null;
    }

    @Override
    public ObservableList<String> getItemIds() {
        return null;
    }
}
