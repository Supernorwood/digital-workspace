package digital.valorantsoftware.scrum.coldapproach;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColdApproachRepository extends JpaRepository<ColdApproach, Integer> {

    Optional<ColdApproach> findByIdAllIgnoreCase(Integer id);
}
