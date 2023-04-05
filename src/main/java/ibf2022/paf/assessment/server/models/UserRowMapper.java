package ibf2022.paf.assessment.server.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setUsername(rs.getString("username"));
        user.setName(rs.getString("name"));
        return user;
    }
    
}
