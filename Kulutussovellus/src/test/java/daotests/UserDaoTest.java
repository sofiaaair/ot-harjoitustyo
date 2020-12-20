package daotests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kulutussovellus.dao.UserDao;
import kulutussovellus.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author airassof
 */
public class UserDaoTest {
    UserDao userDao;
    User user;
    public UserDaoTest() {
    }
    

    
    @Before
    public void setUp() {
        userDao = new UserDao();
        userDao.removeAll();
        user= new User(1, "Matti", "Matteo", "1234");
    }
    
    @After
    public void tearDown() {
        userDao.removeAll();
    }    
   
    @Test
    public void createReturnsRigthName() throws Exception {
        
        userDao.create(user);
        
        assertEquals("Matti", userDao.read(1).getName());
        
    }
    
    @Test
    public void createReturnsRigthUserame() throws Exception {
        
        userDao.create(user);
        
        assertEquals("Matteo", userDao.read(1).getUsername());
        
    }
    
    @Test
    public void readReturnsRightUser() throws Exception {
        
        userDao.create(user);
        userDao.create(new User(2, "Olof", "hubiveikko", "mustikoira123"));
        
        User newUser = userDao.read(1);
        
        assertEquals(user.toString(), newUser.toString());
        
        
    }
    
    @Test
    public void updateUpdatesName() throws Exception {
        
        userDao.create(user);
        
        User newUser = new User(1, "Erkki", "Matteo", "1234");
        userDao.update(newUser);
        assertEquals("Erkki", userDao.read(1).getName());
        
    }
    
    @Test
    public void updateUpdatesUserName() throws Exception {
        
        userDao.create(user);
        
        User newUser = new User(1, "Matti", "GigitheGamer", "1234");
        userDao.update(newUser);
        assertEquals("GigitheGamer", userDao.read(1).getUsername());
        
    }
    
    
    @Test
    public void deleteDeletesRightUser() throws Exception {
        
        userDao.create(user);
        userDao.create(new User(2, "Maija", "Maikki88", "Ks350"));
       
        userDao.delete(2);
        userDao.create(new User(2, "Unto", "Untonen", "14930"));
        assertEquals("Id: 2 Name: Unto Username: Untonen Password: 14930", userDao.read(2).toString());
        
    }
    
    @Test
    public void removeAllRemovesAll() throws Exception {
        
        userDao.create(user);
        userDao.create(new User(2, "Maija", "Maikki88", "Ks350"));
        userDao.create(new User(3, "Unto", "Untonen", "14930"));
        
        userDao.removeAll();
        assertEquals(null, userDao.read(1));
        
    }
    
    @Test
    public void listMethodsListsTheCorrectNumberOfUsers() throws Exception {
        userDao.create(user);
        userDao.create(new User(2, "Maija", "Maikki88", "Ks350"));
        userDao.create(new User(3, "Unto", "Untonen", "14930"));
        userDao.create(new User(4, "Saara", "Gamer98", "go9382"));
        assertTrue(userDao.list().size() == 4);
        
    }
    
    
    @Test
    public void listMethodListsUsers() throws Exception {
        
        userDao.create(user);
        userDao.create(new User(3, "Maija", "Maikki88", "Ks350"));
        userDao.create(new User(2, "Unto", "Untonen", "14930"));
        
        assertEquals("Unto", userDao.list().get(1).getName());
        
        
    }
    
    @Test
    public void readUsingUsernameReturnsRigthUser() throws Exception {
        
        userDao.create(user);
        userDao.create(new User(2, "Unto", "Untonen", "14930"));
        User another = userDao.readUsingUsername("Matteo", "1234");
        assertEquals(user.toString(), another.toString());
        
        
    }
    
    @Test
    public void readUsingUsernameReturnsNull() throws Exception {
       
        User another = userDao.readUsingUsername("Matteo", "1234");
        assertEquals(null, another);
        
        
    }
    
    @Test
    public void readUsingUsernameHasRightParameter() throws Exception {
        
        userDao.create(user);
        String password = userDao.readUsingUsername("Matteo", "1234").getPassword();
        assertEquals(user.getPassword(), password);
    }
    
}
