package ibf2022.paf.assessment.server.controllers;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
public class TasksController {

    @Autowired
    private TodoService svc;

    @PostMapping(path="/task", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView saveTasks(@RequestBody MultiValueMap<String, String> map, Model model) {
        // extract user
        User u = new User();
        u.setUsername(map.get("username").get(0));

        // extract tasks
        List<Task> tasks = new LinkedList<>();
        for(Integer i = 0; i < ((map.size()-1)/3); i++) {
            tasks.add(new Task(
                map.get("description-" + i).get(0),
                Integer.parseInt(map.get("priority-" + i).get(0)),
                LocalDate.parse(map.get("dueDate-" + i).get(0))
            ));
        }

        ModelAndView mav = new ModelAndView();

        try {
            svc.upsertTask(u, tasks);
        } catch (DataAccessException e) {
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            mav.setViewName("error");
            return mav;
        }

        mav.addObject("taskCount", tasks.size());
        mav.addObject("username", u.getUsername());
        mav.setViewName("result");
        mav.setStatus(HttpStatus.OK);

        return mav;
    }
    
}
