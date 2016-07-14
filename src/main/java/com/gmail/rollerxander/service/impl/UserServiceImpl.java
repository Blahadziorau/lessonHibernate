package com.gmail.rollerxander.service.impl;

import com.gmail.rollerxander.Entity.Employee;
import com.gmail.rollerxander.dao.EmployeeDao;
import com.gmail.rollerxander.dao.impl.EmployeeDAOImpl;
import com.gmail.rollerxander.service.UserService;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Java on 04.07.2016.
 */
public class UserServiceImpl implements UserService {
  // private static final Logger LOGGER =Logger.getLogger(UserServiceImpl.class);

    private EmployeeDao dao= new EmployeeDAOImpl();

    public UserServiceImpl(EmployeeDao employeeDao){
        dao= employeeDao;
    }

    @Override
    public List<Employee> getUsers() {
       // LOGGER.debug("getUser");
        return dao.getByCriteria(Restrictions.gt("id",0L));
    }

    @Override
    public boolean deleteLast(List<Employee> employees) {
        int last= employees.size()-1;
        Employee employee = employees.remove(last);
        return dao.delete(employee);
    }

    @Override
    public List<Employee> filterByName(List<Employee> employees, String name) {
        return employees
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .collect(Collectors.toList());
    }


}
