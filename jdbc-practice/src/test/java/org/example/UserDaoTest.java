package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    // 테스트 코드가 실행하기 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    // DAO = Data access Object
    @Test
    void createTest() throws SQLException {
        UserDao userDao = new UserDao();

//        userDao.create(new User("wizard", "password", "name", "email"));
        userDao.create2(new User("wizard", "password", "name", "email"));

        User user = userDao.findByUserId2("wizard");
        assertThat(user).isEqualTo(new User("wizard", "password", "name", "email"));
    }
}
