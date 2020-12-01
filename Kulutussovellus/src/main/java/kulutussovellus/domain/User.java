
package kulutussovellus.domain;

public class User {
    
    Integer id;
    String name;
    String username;
    String password;
    
    public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Id: " + getId() + " Name: " + getName() + " Username: " + getUsername() + " Password: " + getPassword();
    }
    
}
