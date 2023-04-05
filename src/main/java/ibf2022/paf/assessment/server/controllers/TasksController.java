package ibf2022.paf.assessment.server.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TaskInsertException;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    @Autowired
    TodoService svc;

    @PostMapping(path = "/task",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<ModelAndView> postTask(@RequestBody String form) {
        
        List<Task> tasks = new ArrayList<>();
        int tasksCount =0;

        String[] forms = form.split("&");

        String username = forms[0].split("=")[1];

        System.out.println(username);

        for (int i = 1; i < forms.length; i=i+3) {
            Task task = new Task();
            String description = forms[i].split("=")[1].replace("+", " ");
            task.setDesctiption(description);
            String priority = forms[i+1].split("=")[1];
            task.setPriority(Integer.parseInt(priority));
            String dueDate = forms[i+2].split("=")[1];
            task.setDueDate(Date.valueOf(dueDate));
            tasks.add(task);
            tasksCount++;
        }

        try {
            svc.upsertTask(username, tasks);
        } catch (TaskInsertException e) {
            ModelAndView mv = new ModelAndView("error");
            return new ResponseEntity<ModelAndView>(mv,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("taskCount", tasksCount);
        mv.addObject("username", username);

        return new ResponseEntity<ModelAndView>(mv,HttpStatus.OK);
    }
}
