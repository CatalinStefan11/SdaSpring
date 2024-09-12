package ro.sda.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This is a class containing integration tests

// @SpringBootTest is used to create an Integration Test that load the complete application context, including all the
// beans, configurations and dependencies

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddBooksIt() throws Exception {
        String bookJson = """
                        {
                            "title": "Harry Potter Deathly Hallows",
                            "author": "J.K. Rowling",
                            "price": 130,
                            "gender": "Fairy tale"
                        }
                """;

        mockMvc.perform(post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @Sql("/data.sql")
    void testFindAllBooksIt() throws Exception {
        mockMvc.perform(get("/book/all"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

}
