
package kulutussovellus.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;



/**
 * Class of expenses used in the application.
 */
public class Expense {
    /* ... */
    private int id;
    private double amount;
    private String type;
    private int userid;
    
    /**
     * Constructor creates an Expense object.
     */
    public Expense() {
        
    }
    
    /**
     *  Constructor creates the Expense object.
     *  @param amount Amount of money
     *  @param type Type of expense
     *  @param userid Users id
     * 
     */
    public Expense(double amount, String type, int userid) {

        this.amount = amount;
        this.type = type;
        this.userid = userid;
    }
    
        /**
     *  Constructor creates the Expense object.
     *  @param id Id of object
     *  @param amount Amount of money
     *  @param type Type of expense
     *  @param userid Users id
     * 
     */
    public Expense(int id, double amount, String type, int userid) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.userid = userid;
        
    }
    
    /**
     * Setter to change type of Expense.
     * @param type type of Expense
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Setter to change amount of Expense.
     * @param amount amount of money
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    /**
     * Setter to change id of Expense.
     * @param id object's desired id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Getter to get id of Expense.
     * @return object's id
     */
    public int getId() {
        return this.id;
    }
    /**
     * Getter to get amount of Expense.
     * @return object's amount
     */
    public double getAmount() {
        return this.amount;
    }
    /**
     * Getter to get type of Expense.
     * @return object's type
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Getter to get user-related id.
     * @return object's user-related id
     */
    public int getUserId() {
        return this.userid;
    }

    /**
     * toString to Expense
     * @return toString
     */
    public String toString() {
        return this.amount + " " + this.type;
    }
}
