package domaintests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kulutussovellus.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {
    
    User user;
    public UserTest() {
    }
    
    
    @Before
    public void setUp() {
        user = new User(1, "Matti", "Matti1", "1234");
    }
    

    @Test
    public void constructorSetCorrectValues() {
        assertEquals("Id: 1 Name: Matti Username: Matti1 Password: 1234", user.toString());
    }
    
    @Test
    public void usernameUpdateWorks(){
        user.setUsername("Mattero");
        assertEquals("Mattero", user.getUsername());
    }
    
    @Test
    public void nameUpdateWorks(){
        user.setName("Kaaleppi");
        assertEquals("Kaaleppi", user.getName());
    }
    
    @Test
    public void passwordUpdateWorks(){
        user.setPassword("BaiBo5");
        assertEquals("BaiBo5", user.getPassword());
    }
    
}
