package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate template;

    public final static String insertTaskSQL = "insert into task(user_id,description,priority,due_date) value (?,?,?,?);";

    //'1b80114c','swim',2,'2023-4-4'
    public boolean insertTask(Task task) {
       int inserted = template.update(insertTaskSQL, task.getUserId(),task.getDesctiption(),task.getPriority(),task.getDueDate());
        return inserted>0;
    }
}
