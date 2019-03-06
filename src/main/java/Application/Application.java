package Application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.Assert.assertTrue;

@SpringBootApplication
public class Application {

    @Autowired User user;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetUserName() {
        String username = "testname";
        user = new User();
        user.setUsername(username);
        assertTrue("getUserName test failed", user.getUsername().equals("username"));
    }

    @Test
    public void testSetUserName(){
        user = new User();
        assertTrue("setUserName test failed", user.getUsername()==null);
    }

}