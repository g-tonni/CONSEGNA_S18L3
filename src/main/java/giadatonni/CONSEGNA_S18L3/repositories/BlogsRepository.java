package giadatonni.CONSEGNA_S18L3.repositories;

import giadatonni.CONSEGNA_S18L3.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogsRepository extends JpaRepository<Blog, UUID> {

    @Query("SELECT b FROM Blog b WHERE b.utente.utenteId = :utenteId")
    public List<Blog> findAllBlogByUtenteId(UUID utenteId);
}
