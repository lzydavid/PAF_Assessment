package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7
@Service
public class TodoService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    @Transactional(rollbackFor = TaskInsertException.class)
    public void upsertTask(String username,List<Task> tasks) throws TaskInsertException {

        Optional<User> opt = userRepository.findUserByUSername(username);

        if(opt.isPresent()){
            //get existing User
            User user = opt.get();

            for (Task task : tasks) {
                task.setUserId(user.getUserId());
                Boolean taskInsert  = taskRepository.insertTask(task);
                if(!taskInsert){
                    throw new TaskInsertException();
                }
            }
        }
        else{
            User newUser = new User();
            newUser.setUsername(username);
            String userId = userRepository.insertUser(newUser);

            for (Task task : tasks) {
                task.setUserId(userId);
                Boolean taskInsert = taskRepository.insertTask(task);
                if(!taskInsert){
                    throw new TaskInsertException();
                }
            }
        }

    }
}
