package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    TaskRepository taskRepo;

    @Autowired
    UserRepository userRepo;

    @Transactional(rollbackFor=DataAccessException.class)
    public void upsertTask(User u, List<Task> tasks) {
        // check if user exists
        Optional<User> optU = userRepo.findUserByUsername(u.getUsername());
        if(optU.isPresent()) {
            u = optU.get();
        } else {
            u.setName(u.getUsername().substring(0,1).toUpperCase() + u.getUsername().substring(1).toLowerCase());
            u.setUserId(userRepo.insertUser(u));
        }

        // add tasks
        for(Task t : tasks) {
            taskRepo.insertTask(t, u);
        }
    }
}
