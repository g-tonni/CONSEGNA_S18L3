package giadatonni.CONSEGNA_S18L3.services;

import giadatonni.CONSEGNA_S18L3.entities.User;
import giadatonni.CONSEGNA_S18L3.exceptions.NotFoundException;
import giadatonni.CONSEGNA_S18L3.payload.UserPayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UsersService {
    private List<User> listaUser;

    public User postaUtente(UserPayload body) {
        User nuovoUtente = new User(body.getNome(), body.getCognome(), body.getEmail(), body.getDataNascita());
        this.listaUser.add(nuovoUtente);
        return nuovoUtente;
    }

    public User trovaUtente(long userId){
        User found = null;
        for (int i = 0; i < listaUser.size(); i++) {
            if (listaUser.get(i).getUserId() == userId){
                found = listaUser.get(i);
            }
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    public User modificaUtente(long userId, UserPayload body){
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

}
