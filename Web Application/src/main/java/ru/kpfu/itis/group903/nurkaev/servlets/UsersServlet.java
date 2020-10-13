package ru.kpfu.itis.group903.nurkaev.servlets;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepository;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepositoryJdbcImpl;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;
import ru.kpfu.itis.group903.nurkaev.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    public static final String URL = "jdbc:postgresql://localhost:5432/java_lab_pract_2020";
    public static final String USER = "postgres";
    public static final String PASSWORD = "9aw25pxj";
    public static final String DRIVER = "org.postgresql.Driver";

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setUsername(USER);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setDriverClassName(DRIVER);
        hikariConfig.setMaximumPoolSize(10);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        this.usersService = new UsersServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        // test save
//        User user = new User(null, "Питер", "Паркер", 21);
//        usersService.save(user);

//        // test update and findById
//        User user1 = new User(null, "Spider", "Man", 21);
//        usersService.save(user1);
//        user1.setFirstName("Человек");
//        user1.setLastName("Паук");
//        user1.setAge(22);
//        usersService.update(user1);
//        System.out.println(usersService.findById(user1.getId()).get());

//        // test delete
//        User user2 = new User(null, "Alexander", "Brin", 40);
//        usersService.save(user2);
//        usersService.delete(user2);

        // test findAll
        System.out.println(usersService.getAllUsers());

        // test findAllByAge
        System.out.println(usersService.getUsersByAge(18));
    }
}
