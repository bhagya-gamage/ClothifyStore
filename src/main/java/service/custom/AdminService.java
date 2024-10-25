package service.custom;

import dto.Admin;
import dto.Employee;
import service.SuperService;

public interface AdminService extends SuperService {
    boolean addAdmin(Admin admin);
}
