package com.gmail.rollerxander.dao;

import com.gmail.rollerxander.dao.impl.EmployeeDAOImpl;
import com.gmail.rollerxander.dao.util.HibernateUtil;

/**
 * Created by Java on 27.06.2016.
 */
public class App {
    private static EmployeeDao dao = new EmployeeDAOImpl();

    public static void main(String[] args) {



        HibernateUtil.closeFactory();
    }
}