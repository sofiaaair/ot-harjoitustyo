
package kulutussovellus.domain;


public class Expense {
    
    int id;
    int amount;
    String type;
    int userid;
    
    public Expense() {
        
    }
    
    public Expense(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }
    
    public Expense(int id, int amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public String getType() {
        return this.type;
    }
    
    
    public String toString() {
        return this.id + " " + this.amount + " " + this.type;
    }
}
