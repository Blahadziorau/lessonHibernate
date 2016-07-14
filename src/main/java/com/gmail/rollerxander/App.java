package com.gmail.rollerxander;

import com.gmail.rollerxander.Entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure().build();
        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .buildMetadata();


        SessionFactory factory = metadata.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

      /*  Employee superBoss = new Employee();
        session.save(superBoss);
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setBoss(superBoss);
            session.save(employee);
            List<Employee> employees1= new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Employee employee1= new Employee();
                employee1.setBoss(employee);
                employees1.add(employee1);
                session.save(employee1);
            }
            employee.setEmployees(employees1);

            employees.add(employee);
            session.saveOrUpdate(employee);
        }
        superBoss.setEmployees(employees);


        session.update(superBoss);

        session.close();
        factory.close();*/

        transaction.commit();

        System.out.println("**********************************************");

        Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.isNull("boss"));
        Employee boss = (Employee) criteria.uniqueResult();

        System.out.println("**********************************************");
         session.close();

        session=factory.openSession();
        Employee e= session.get(Employee.class,null);
        System.out.println(e.getEmployees());

        session.close();
        factory.close();

    }
}
