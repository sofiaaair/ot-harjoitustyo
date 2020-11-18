
package kulutussovellus.domain;


public class Expense {
    
    int id;
    int amount;
    String type;
    
    public Expense(int id, int amount, String type){
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
    
    public void setType(String type){
        this.type= type;
    }
    
    public void setAmount(int amount){
        this.amount= amount;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public String getType(){
        return this.type;
    }
}
