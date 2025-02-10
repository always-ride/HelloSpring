package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MyApplication.class) // Startet nur den Web-Teil von Spring Boot
class MyApplicationTest {

    @Autowired
    private MockMvc mockMvc; // Simuliert HTTP-Anfragen an den Controller

    @Test
    void home_shouldReturnHelloWorld() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // Erwartet HTTP 200 OK
                .andExpect(content().string("Hello Spring!")); // Erwartet den String "Hello World!"
    }
}
