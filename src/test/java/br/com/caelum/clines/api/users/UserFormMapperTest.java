package br.com.caelum.clines.api.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserFormMapperTest {

    private final String NAME = "Fulano";
    private final String EMAIL = "fulano@email.com";
    private final String PASSWORD = "123456";

    private UserFormMapper mapper;

    @Test
    void testMap() {
        var userForm = new UserForm(NAME, EMAIL, PASSWORD);
        mapper = new UserFormMapper();

        var user = mapper.map(userForm);

        Assertions.assertThat(user.getName()).isEqualTo(userForm.getName());
        Assertions.assertThat(user.getEmail()).isEqualTo(userForm.getEmail());
    }
}
