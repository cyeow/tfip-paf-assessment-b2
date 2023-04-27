package ibf2022.paf.assessment.server.repositories;

import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbc;
    
    public Optional<User> findUserByUsername(String username) {
        SqlRowSet rs = jdbc.queryForRowSet(SELECT_USER_BY_USERNAME, username);
        if(rs.next()) {
            User u = new User();
            u.setUserId(rs.getString("user_id"));
            u.setUsername(rs.getString("username"));
            u.setName(rs.getString("name"));
            return Optional.of(u);
        }
        return Optional.empty();
    }

    public String insertUser(User user) {
        user.setUserId(generateUUID());
        jdbc.update(INSERT_USER, user.getUserId(), user.getUsername(), user.getName());
        return user.getUserId();
    }

    private String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0,8);
    }
}
