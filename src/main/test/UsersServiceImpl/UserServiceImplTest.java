package UsersServiceImpl;

import com.gmail.rollerxander.dao.EmployeeDao;
import com.gmail.rollerxander.service.UserService;
import com.gmail.rollerxander.service.impl.UserServiceImpl;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
   @Mock
    private EmployeeDao dao;

    private UserService service= new UserServiceImpl(dao);
    @Before
    public  void init(){
        service = new UserServiceImpl(dao);
        Mockito.when(dao.getByCriteria(Restrictions.gt("id",0L))).thenReturn(new ArrayList<>());
    }

    @Test
    public  void getUserTest(){
        Assert.assertEquals(6,service.getUsers().size());
    }
}
