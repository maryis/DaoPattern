import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 5/5/2019.
 */
public class MyApp {

    private static Dao ud=null;

    public static void main(String[] args) {

        ud=new UserDao();
        List<User> users=new ArrayList<User>();//it is needed to allow us Lambda and user.getname()
        users=ud.getAll();

        System.out.println("Before Delete");

        users.forEach( user->System.out.println(user.getName()));

        ud.delete(ud.get(0).orElse(new User("nist","nist")));//by using orElse, we cast an optional<User> to User

        System.out.println("After Delete");


        users=ud.getAll();

        users.forEach( user->System.out.println(user.getName()));

    }


}
