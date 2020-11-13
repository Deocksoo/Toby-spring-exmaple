package user.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

class UserDaoTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        dataSource = applicationContext.getBean("dataSource", DataSource.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    void checkBeans() throws SQLException {
        System.out.println(dataSource.getConnection().getClientInfo());
        System.out.println(userDao);
    }
}