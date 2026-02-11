package giadatonni.CONSEGNA_S18L3.services;

import giadatonni.CONSEGNA_S18L3.entities.Blog;
import giadatonni.CONSEGNA_S18L3.entities.User;
import giadatonni.CONSEGNA_S18L3.exceptions.NotFoundException;
import giadatonni.CONSEGNA_S18L3.payload.BlogPayload;
import giadatonni.CONSEGNA_S18L3.repositories.BlogsRepository;
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
public class BlogsService {

    private final BlogsRepository blogsRepository;
    private final UsersService usersService;

    public Page<Blog> findAll(int page, int size, String orderBy){
        if (size > 100) size = 100;
        if (size < 0) size = 0;
        if (page > 30) page = 30;
        if (page < 0) page = 0;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.blogsRepository.findAll(pageable);
    }

   public Blog postaBlog(BlogPayload body) {
        User found = this.usersService.trovaUtente(UUID.fromString(body.getUtenteId()));
        Blog nuovoBlog = new Blog(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoLettura(), found);
        this.blogsRepository.save(nuovoBlog);
        System.out.println("Blog salvato");
        return nuovoBlog;
    }

    /* public Blog trovaBlog(long blogId){
        Blog found = null;
        for (int i = 0; i < listaBlog.size(); i++) {
            if (listaBlog.get(i).getBlogId() == blogId){
                found = listaBlog.get(i);
            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public Blog modificaBlog(long blogId, BlogPayload body){
        Blog found = null;
        for (int i = 0; i < listaBlog.size(); i++) {
            if (listaBlog.get(i).getBlogId() == blogId){
                found = listaBlog.get(i);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setContenuto(body.getContenuto());
                found.setTempoLettura(body.getTempoLettura());
            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public void eliminaBlog(long blogId){
        Blog found = null;
        for (int i = 0; i < listaBlog.size(); i++) {
            if (listaBlog.get(i).getBlogId() == blogId){
                found = listaBlog.get(i);
                listaBlog.remove(listaBlog.get(i));
            }
        }
        if (found == null) throw new NotFoundException(blogId);
    }*/
}
