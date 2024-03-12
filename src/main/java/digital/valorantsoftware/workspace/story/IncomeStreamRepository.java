package digital.valorantsoftware.workspace.story;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeStreamRepository extends JpaRepository<IncomeStream, Long> {

    List<IncomeStream> findByIdAllIgnoreCase(Long id);

    //List<IncomeStream> findall();

    //List<UserStory> findByNameIgnoreCase(String name);
   // List<UserStory> findByStatus(String status);

}
