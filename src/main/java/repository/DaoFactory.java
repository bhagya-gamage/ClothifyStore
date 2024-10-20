package repository;

import repository.custom.impl.EmployeeDaoImpl;
import repository.custom.impl.ItemDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDao>T getDaoType(DaoType type){
        switch (type){
            case EMPLOYEE:return (T) new EmployeeDaoImpl();
            case ITEM:return (T) new ItemDaoImpl();
            case SUPPLIER:return (T) new SupplierDaoImpl();
        }
        return null;
    }
}
