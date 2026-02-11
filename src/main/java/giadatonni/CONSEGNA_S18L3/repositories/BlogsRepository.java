package giadatonni.CONSEGNA_S18L3.repositories;

import giadatonni.CONSEGNA_S18L3.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogsRepository extends JpaRepository<Blog, UUID> {
}
