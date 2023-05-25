package br.com.caelum.clines.api.users;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;
import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("{code}")
    UserView show(@PathVariable String code) {
        return service.showUserBy(normalize(code));
    }

    @GetMapping
    List<UserView> list() {
        return service.listAllUser();
    }

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid UserForm form) {
        var code = service.createUserBy(form);

        var uri = URI.create("/users/").resolve(code);

        return created(uri).build();
    }
}
