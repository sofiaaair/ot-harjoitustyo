
package kulutussovellus.domain;

public class User {
    
    Integer id;
    String name;
    String username;
    
    public User(int id, String name, String username){
        this.id = id;
        this.name = name;
        this.username = username;
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
}
