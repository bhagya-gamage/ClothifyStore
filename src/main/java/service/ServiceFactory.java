package service;

import repository.custom.impl.SupplierDaoImpl;
import service.custom.impl.*;
import util.ServiceType;

import static util.DaoType.*;

public class ServiceFactory {
    private static ServiceFactory instance;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance==null?instance=new ServiceFactory():instance;
    }

    public <T extends SuperService>T getServiceType(ServiceType type){
        switch (type){
            case EMPLOYEE:return (T) new EmployeeServiceImpl();
            case ITEM:return (T) new ItemServiceImpl();
            case SUPPLIER:return (T) new SupplierServiceImpl();
            case ORDER:return (T) new OrderServiceImpl();
            case ADMIN:return (T) new AdminServiceImpl();


        }
        return null;
    }
}
