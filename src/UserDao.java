import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by User on 5/5/2019.
 */
public class UserDao implements Dao<User> {

    //an inside DB to ignore realDB
    List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User("ali", "ahmadi"));
        users.add(new User("marzieh", "sadeghi"));
    }


    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;

    }

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(params[0]));
        user.setFamily(Objects.requireNonNull(params[1]));

    }

    @Override
    public void delete(User user) {
        users.remove(user);

    }
}
