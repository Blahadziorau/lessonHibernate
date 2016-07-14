package com.gmail.rollerxander.dao.impl;

import com.gmail.rollerxander.Entity.Employee;
import com.gmail.rollerxander.dao.EmployeeDao;
import com.gmail.rollerxander.dao.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Java on 27.06.2016.
 */
public class EmployeeDAOImpl implements EmployeeDao {
    @Override
    public Employee getById(Long id) {
        Session session = HibernateUtil.getSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return null;
    }

    @Override
    public List<Employee> getByCriteria(Criterion criterion) {
        Session session = HibernateUtil.getSession();
        Criteria c = session.createCriteria(Employee.class);
        c.add(criterion);
        List<Employee> employees = c.list();
        session.close();
        return employees;
    }

    @Override
    public boolean saveOrUpdate(Employee employee) {

        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean result;
        Session session = HibernateUtil.getSession();
        Employee employee = session.load(Employee.class, id);
        result = delete(employee, session);
        session.close();
        return result;
    }

    @Override
    public boolean delete(Employee employee) {
        boolean result;
        Session session = HibernateUtil.getSession();
        result = delete(employee, session);
        session.close();
        return result;
    }


    public boolean delete(Employee employee, Session session) {
        if (employee != null) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            return true;
        }
        return false;
    }
}
