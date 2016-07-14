package com.gmail.rollerxander.dao;

import com.gmail.rollerxander.Entity.Employee;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Java on 27.06.2016.
 */
public interface EmployeeDao {
     Employee getById(Long id);

     List<Employee> getByCriteria(Criterion criteria);

    boolean saveOrUpdate(Employee employee);

    boolean delete(Long id);

    boolean delete(Employee employee);
}
