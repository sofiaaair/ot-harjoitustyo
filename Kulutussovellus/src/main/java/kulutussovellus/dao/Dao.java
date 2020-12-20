
package kulutussovellus.dao;
import java.sql.*;
import java.util.*;

/**
 * Interface for Data Access Objects 
 * 
 * @param <T> the type of object to be returned
 * @param <K> master key
 */
public interface Dao<T, K> {
    void create(T object) throws SQLException;
    T read(K key) throws SQLException;
    T update(T object) throws SQLException;
    void delete(K key) throws SQLException;
    
}
