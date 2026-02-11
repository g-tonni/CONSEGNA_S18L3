package giadatonni.CONSEGNA_S18L3.controllers;

import giadatonni.CONSEGNA_S18L3.entities.User;
import giadatonni.CONSEGNA_S18L3.payload.UserPayload;
import giadatonni.CONSEGNA_S18L3.services.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public Page<User> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "surname") String orderBy){
        return usersService.findAll(page,size,orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody UserPayload body){
        return usersService.postaUtente(body);
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable UUID userId){
        return usersService.trovaUtente(userId);
    }

    @PutMapping("/{userId}")
    public User putUser(@PathVariable UUID userId, @RequestBody UserPayload body){
        return usersService.modificaUtente(userId, body);
    }

    /*
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long userId){
        usersService.eliminaUtente(userId);
    }*/
}
