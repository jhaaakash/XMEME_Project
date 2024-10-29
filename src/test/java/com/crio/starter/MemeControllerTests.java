package com.crio.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.annotation.DirtiesContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;






@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // Ensure each test starts with a clean context
public class MemeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMemes_EmptyDatabase_ReturnsEmptyList() throws Exception {
        mockMvc.perform(get("/memes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0)); // Assert that the returned list is empty
    }

    @Test
    public void testPostMoreThan100Memes_ReturnsLatest100() throws Exception {
        String endpoint = "/memes/";
        for (int i = 1; i <= 150; i++) {
            String memeJson = "{\"name\": \"user" + i + "\", \"caption\": \"caption" + i + "\", \"url\": \"http://example.com/meme" + i + ".jpg\"}";
            mockMvc.perform(post(endpoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(memeJson))
                    .andExpect(status().isCreated());
        }

        mockMvc.perform(get(endpoint))
                .andExpect(status().isOk());
				}
}
