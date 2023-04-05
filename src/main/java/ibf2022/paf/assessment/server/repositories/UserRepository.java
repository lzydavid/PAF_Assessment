package ibf2022.paf.assessment.server.repositories;

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
    private static final String checkIfReccordExistByUsernameSQL = "select exists (select * from user where username = ?);";

    public Optional<User> findUSerByUSername(String username){

        Optional<User> result = Optional.ofNullable( template.queryForObject(findUSerByUSernameSQL, new UserRowMapper(),username)) ;

        return result;
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

    public Boolean checkIfUserExist(String username) {

        Boolean exist = template.queryForObject(checkIfReccordExistByUsernameSQL, Boolean.class,username);
        return exist;
    }
}
