package user.dao;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import user.domain.User;

public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(User user) {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            return ps;
        });
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
            new Object[] {id},
            (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            });
    }

    public void deleteAll() {
        jdbcTemplate.update(connection -> connection.prepareStatement("delete from users"));
    }

    public int getCount() {
        return this.jdbcTemplate.queryForInt("select count(*) from users");
    }
}
