package com.gmail.rollerxander.service;

import com.gmail.rollerxander.Entity.Employee;

import java.util.List;

/**
 * Created by Java on 04.07.2016.
 */
public interface UserService {
    List<Employee> getUsers();
    boolean deleteLast(List<Employee> employees);
    List<Employee> filterByName(List<Employee> employees, String name);
}
