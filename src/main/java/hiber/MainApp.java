package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car = new Car("CADILLAC", 300);
        Car car2 = new Car("VOLVO", 250);
        User user1 = new User("Ivan", "Poslednyy", "ivan11@mail,ru");
        user1.setCar(car);
        User user2 = new User("Vova", "Perviy", "vova12@mail,ru");
        user2.setCar(car2);

        userService.addUser(user1);
        userService.addUser(user2);
        User user14 = userService.getUserByCar("CADILLAC", 300);
        System.out.println(user14);
        User useer = userService.getUserByCar("VOLVO", 250);
        System.out.println(useer);


        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }


        context.close();
    }
}
