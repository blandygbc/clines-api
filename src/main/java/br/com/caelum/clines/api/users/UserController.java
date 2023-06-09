package br.com.caelum.clines.api.users;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    UserView show(@PathVariable Long id) {
        return service.showUserBy(id);
    }

    @GetMapping
    List<UserView> list() {
        return service.listAllUser();
    }

    @PostMapping
    ResponseEntity<URI> createBy(@RequestBody @Valid UserForm form) {
        var id = service.createUserBy(form);

        var uri = URI.create("/users/").resolve(id);

        return created(uri).build();
    }
}
