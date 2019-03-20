package Application;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ArticleTest {
    Article a;
    File f;
    Date d;

    @Before
    public void setUp() throws Exception {
        a = new Article();
        f = new File("test.txt");
        a.setFile(f);
        a.setStatus(Status.SUMBITTED);
        a.setTitle("Test");
        a.setDeadline(d);
    }

    @Test
    public void getTitle() {
        assertEquals(a.getTitle(), "Test");
    }

    @Test
    public void setTitle() {
        a.setTitle("change");
        assertEquals(a.getTitle(), "change");
    }

    @Test
    public void getFile() {
        File file = a.getFile();
        assertEquals(file, f);
    }

    @Test
    public void setFile() {
        File file = new File("test1.txt");
        a.setFile(file);
        assertEquals(a.getFile(), file);
    }

    @Test
    public void getStatus() {
        assertEquals(a.getStatus(), Status.SUMBITTED);
    }

    @Test
    public void setStatus() {
        a.setStatus(Status.ACCEPTED);
        assertEquals(a.getStatus(), Status.ACCEPTED);
    }
}