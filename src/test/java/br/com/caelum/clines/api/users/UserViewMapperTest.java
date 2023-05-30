package br.com.caelum.clines.api.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.caelum.clines.shared.domain.User;

public class UserViewMapperTest {

    private final String NAME = "Fulano";
    private final String EMAIL = "fulano@email.com";
    private final String PASSWORD = "123456";

    private UserViewMapper mapper;

    @Test
    void shouldConvertUserToUserView() {
        var user = new User(NAME, EMAIL, PASSWORD);
        mapper = new UserViewMapper();

        var userView = mapper.map(user);

        Assertions.assertThat(userView.getName()).isEqualTo(user.getName());
        Assertions.assertThat(userView.getEmail()).isEqualTo(user.getEmail());

    }
}
