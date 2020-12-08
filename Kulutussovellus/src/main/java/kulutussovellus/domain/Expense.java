
package kulutussovellus.domain;


public class Expense {
    
    int id;
    double amount;
    String type;
    int userid;
    
    public Expense() {
        
    }
    
    
    
    
    public Expense(int id, double amount, String type, int userid) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.userid = userid;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String getType() {
        return this.type;
    }
    
    public int getUserId() {
        return this.userid;
    }
    
    
    public String toString() {
        return this.id + " " + this.amount + " " + this.type;
    }
}
