package service.custom.impl;

import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierService;
import util.DaoType;

public class SupplierServiceImpl implements SupplierService {
    SupplierDao supplierDao=DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);;

    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier,SupplierEntity.class);
        return  supplierDao.save(entity);
    }

    @Override
    public boolean deleteSupplier(String id) {
        return supplierDao.delete(id);
    }

    @Override
    public ObservableList<Supplier> getAll() {
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        supplierDao.getAll().forEach(supplier -> {
            Supplier supplier1 = new ModelMapper().map(suppliers,Supplier.class);
            suppliers.add(supplier1);
        });
        return suppliers;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.update(new ModelMapper().map(supplier, SupplierEntity.class));
    }

    @Override
    public Supplier searchSupplier(String id) {
        return null;
    }

   }
