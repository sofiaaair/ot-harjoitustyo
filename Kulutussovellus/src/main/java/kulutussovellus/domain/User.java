
package kulutussovellus.domain;
/**
 * Class of application users
 */
public class User {
    /* ... */
    private Integer id;
    private String name;
    private String username;
    private String password;
    
    /**
     * Constructor creates a User object
     * @param id user's individual id
     * @param name user's name
     * @param username user's username
     * @param password user's password
     */
    public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        
    }
    
    /**
     * Getter to get user's Name
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter to get user's username
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Getter to get user's id
     * @return id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter for obtaining user's password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Setter to set a name for user
     * @param name user's desired name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter to set a username for user
     * @param username user's desired username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Setter to set a password for user
     * @param password user's desired password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * toString to User
     * @return toString
     */
    @Override
    public String toString() {
        return "Id: " + getId() + " Name: " + getName() + " Username: " + getUsername() + " Password: " + getPassword();
    }
    
}
