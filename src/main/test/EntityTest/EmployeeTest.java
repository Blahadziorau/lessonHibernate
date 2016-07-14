package EntityTest;

import com.gmail.rollerxander.Entity.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Java on 13.07.2016.
 */
public class EmployeeTest {

    private Employee employee = new Employee();

    @Before  // метод выполняется перед тестами
    public void begin() {
        employee.setName("Vasya");
        employee.setId(30L);
    }

    @Test
    public void getNametest() {
        Assert.assertEquals("Vasya", employee.getName());
    }

    @Test
    public void getIdTest() {
        Assert.assertEquals(Long.valueOf(30L), employee.getId());
    }
}
