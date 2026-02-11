package giadatonni.CONSEGNA_S18L3.services;

import giadatonni.CONSEGNA_S18L3.entities.User;
import giadatonni.CONSEGNA_S18L3.exceptions.NotFoundException;
import giadatonni.CONSEGNA_S18L3.exceptions.ValidationException;
import giadatonni.CONSEGNA_S18L3.payload.UserPayload;
import giadatonni.CONSEGNA_S18L3.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Page<User> findAll(int page, int size, String orderBy){
        if (size > 100) size = 100;
        if (size < 0) size = 0;
        if (page > 30) page = 30;
        if (page < 0) page = 0;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.usersRepository.findAll(pageable);
    }

   public User postaUtente(UserPayload body) {
        if(this.usersRepository.existsByEmail(body.getEmail())) throw new ValidationException("Email già in uso");
        User nuovoUtente = new User(body.getNome(), body.getCognome(), body.getEmail(), body.getDataNascita());
        this.usersRepository.save(nuovoUtente);
        System.out.println("Utente salvato");
        return nuovoUtente;
   }

    public User trovaUtente(UUID userId){
        User found = this.usersRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));
        return found;
    }

    /* public User modificaUtente(long userId, UserPayload body){
        User found = null;
        for (int i = 0; i < listaUser.size(); i++) {
            if (listaUser.get(i).getUserId() == userId){
                found = listaUser.get(i);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataNascita(body.getDataNascita());
            }
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    public void eliminaUtente(long userId){
        User found = null;
        for (int i = 0; i < listaUser.size(); i++) {
            if (listaUser.get(i).getUserId() == userId){
                found = listaUser.get(i);
                listaUser.remove(listaUser.get(i));
            }
        }
        if (found == null) throw new NotFoundException(userId);
    }
*/
}
