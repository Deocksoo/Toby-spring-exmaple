package user.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import user.domain.User;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserDaoTest {
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @AfterEach
    void tearDown() throws SQLException {
        userDao.deleteAll();
    }

    @Test
    @DisplayName("새로운 User를 추가한다.")
    void add() throws SQLException {
        User user1 = new User("deocks", "덕수", "deocksword");
        User user2 = new User("jj", "재주", "jassword");

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User userGet1 = userDao.get(user1.getId());
        assertThat(userGet1.getName()).isEqualTo((user1.getName()));
        assertThat(userGet1.getPassword()).isEqualTo(user1.getPassword());

        User userGet2 = userDao.get(user2.getId());
        assertThat(userGet2.getName()).isEqualTo((user2.getName()));
        assertThat(userGet2.getPassword()).isEqualTo(user2.getPassword());
    }

    @Test
    @DisplayName("존재하지 않는 User id로 조회시 예외가 발생한다.")
    void getUserFailure() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        assertThatThrownBy(() -> userDao.get("unknwon_id"))
            .isInstanceOf(EmptyResultDataAccessException.class);
    }

    @Test
    @DisplayName("총 User가 몇 명인지 조회한다.")
    void count() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        User user1 = new User("deocks", "덕수", "deocksword");
        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        User user2 = new User("jj", "재주", "jassword");
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User user3 = new User("ki", "광일", "jassword");
        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }
}