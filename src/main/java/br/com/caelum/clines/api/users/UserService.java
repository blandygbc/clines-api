package br.com.caelum.clines.api.users;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserViewMapper viewMapper;
    private final UserFormMapper formMapper;

    public UserView showUserBy(String normalize) {
        return null;
    }

    public List<UserView> listAllUser() {
        return repository.findAll().stream().map(viewMapper::map).collect(Collectors.toList());
    }

    public String createUserBy(@Valid UserForm form) {
        return null;
    }

}
