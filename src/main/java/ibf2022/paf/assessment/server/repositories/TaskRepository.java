package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;

import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

// TODO: Task 6

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void insertTask(Task t, User u) {
        jdbc.update(INSERT_TASK, t.getDescription(), t.getPriority(), t.getDueDate().toString(), u.getUserId());
    }
}
