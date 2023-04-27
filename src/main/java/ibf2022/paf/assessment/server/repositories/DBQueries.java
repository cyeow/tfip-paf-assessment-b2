package ibf2022.paf.assessment.server.repositories;

public class DBQueries {
    
    public static final String SELECT_USER_BY_USERNAME = "SELECT * FROM user WHERE username = ?;";
    
    public static final String INSERT_USER = "INSERT INTO user (user_id, username, name) VALUES (?, ?, ?);";

    public static final String INSERT_TASK = "INSERT INTO task (description, priority, due_date, user_id) VALUES (?, ?, ?, ?);";
}
