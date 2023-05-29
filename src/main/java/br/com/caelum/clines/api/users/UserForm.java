package br.com.caelum.clines.api.users;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    @NotNull
    String name;
    @NotNull
    String email;
    @NotNull
    String password;
}
