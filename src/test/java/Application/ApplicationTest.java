package Application;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    User user;

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
        assertTrue("Test Failed", user.getUsername().equals("username"));
    }

    @Test
    public void testSetUserName(){
        user = new User();
        assertTrue("Test Failed", user.getUsername().equals(null));

    }

}