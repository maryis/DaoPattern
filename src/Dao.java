import java.util.List;
import java.util.Optional;

/**
 * Created by User on 5/5/2019.
 */
public interface Dao<T> {
    
    // connection  or  EntityManager object 

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

}
