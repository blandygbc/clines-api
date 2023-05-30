package br.com.caelum.clines.api.users;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.caelum.clines.shared.domain.User;

@SpringBootTest
@TestPropertySource(properties = { "DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop" })
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class UserControllerTest {

    private final String NAME = "Fulano";
    private final String EMAIL = "fulano@email.com";
    private final String PASSWORD = "123456";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldReturn404WhenNotExistUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1234"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void shouldReturnAnUserById() throws Exception {
        var user = new User(NAME, EMAIL, PASSWORD);
        entityManager.persist(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.equalTo(user.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.equalTo(user.getEmail())));
    }
}
