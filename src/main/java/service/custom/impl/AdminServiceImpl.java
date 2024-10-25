package service.custom.impl;

import dto.Admin;
import entity.AdminEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.AdminDao;
import service.custom.AdminService;
import util.DaoType;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao= DaoFactory.getInstance().getDaoType(DaoType.ADMIN);

    @Override
    public boolean addAdmin(Admin admin) {
        AdminEntity entity = new ModelMapper().map(admin,AdminEntity.class);
        return adminDao.save(entity);
    }
}
