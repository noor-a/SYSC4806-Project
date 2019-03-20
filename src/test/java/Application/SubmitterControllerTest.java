package Application;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SubmitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Submitter submitter;

    @Test
    public void createSubmitter() throws Exception {
        String username = "testuser";
        String password = "testpassword";
        String firstname = "John";
        String lastname = "Doe";
        String email = "test@mail.ca";

        //MvcResult mvcResult = this.mockMvc.perform(get("registerSubmitter"))
    }
}