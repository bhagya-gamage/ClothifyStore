package service.custom.impl;

import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierService;
import util.DaoType;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierEntity entity = new ModelMapper().map(supplier, SupplierEntity.class);

        SupplierDao supplierDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);

        supplierDao.save(entity);

        System.out.println("Service Layer : " + supplier);
        return false;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public ObservableList<Supplier> getAll() {
        return null;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public Supplier searchSupplier(String id) {
        return null;
    }

    @Override
    public ObservableList<String> getCustomerIds() {
        return null;
    }
}
