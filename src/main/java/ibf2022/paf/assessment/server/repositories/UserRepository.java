package ibf2022.paf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.models.UserRowMapper;

// TODO: Task 3
@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate template;

    private static final String findUSerByUSernameSQL = "select * from user where username = ?;";
    private static final String insertUserSQL = "insert into user(user_id,username,name) values (?,?,?);";
    
    public Optional<User> findUserByUSername(String username){

        List<User> result = template.query(findUSerByUSernameSQL, new UserRowMapper(), username);

        if(result.size()==0){
            return Optional.empty();
        }
        return Optional.of(result.get(0));
    }

    public String insertUser(User user) {

        String user_id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);

        if(user.getName()==null){
            String username = user.getUsername();
            String name = username.substring(0, 1).toUpperCase() + username.substring(1);   
            user.setName(name);
        }

        int insert = template.update(insertUserSQL,user_id,user.getUsername(),user.getName());
        if(insert>0){
            return user_id;
        }
        return "Failed to insert";
    }
}
