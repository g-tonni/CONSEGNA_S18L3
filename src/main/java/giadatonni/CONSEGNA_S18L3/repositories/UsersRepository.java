package giadatonni.CONSEGNA_S18L3.repositories;

import giadatonni.CONSEGNA_S18L3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
}
