package Application;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/***
 * JUnit test class for User.java
 */
public class UserTest {

    User u;

    @Before
    public void setUp() throws Exception {
        u = new User();
    }

    @Test
    public void getSetUsername() {
        String username = "johnSmith";
        u.setUsername(username);
        assertEquals(u.getUsername(), username);
    }

    @Test
    public void getSetPassword() {
        String pw = "carleton";
        u.setPassword(pw);
        assertEquals(u.getPassword(), pw);
    }

    @Test
    public void getSetFirstName() {
        String firstName="john";
        u.setFirstName(firstName);
        assertEquals(u.getFirstName(), firstName);
    }

    @Test
    public void getSetLastName() {
        String lastName = "Smith";
        u.setLastName(lastName);
        assertEquals(u.getLastName(), lastName);
    }

    @Test
    public void getSetEmail() {
        String email="@gmail.com";
        u.setEmail(email);
        assertEquals(u.getEmail(), email);
    }
}