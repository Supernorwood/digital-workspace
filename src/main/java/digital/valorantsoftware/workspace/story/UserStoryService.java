package digital.valorantsoftware.workspace.story;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = {SQLException.class})
public class UserStoryService {

    public static final double GOAL_NUMBER = 500_000.00;

    //method in service to return constant - controller calls to do the work
    public double findGoal(){
        return GOAL_NUMBER;
    }

    public Double calculatedEarnedTotal() {

        return this.userStoryRepository.findAll();

        double percentage = (totalEarnings / GOAL_NUMBER) * 100.0;
        if (GOAL_NUMBER == 0) {
            percentage = 0.0; // Avoid division by zero
        }

    }

    UserStoryRepository userStoryRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {

        this.userStoryRepository = userStoryRepository;

    }

    public UserStory save(UserStory project) {

        return this.userStoryRepository.save(project);

    }

    public List< UserStory> findAll() {

        return this.userStoryRepository.findAll();

    }

    public UserStory findById(Long id) {

        return this.userStoryRepository.findById(id).orElse(null);

    }

/*    public List<UserStory> findByStatus(String status) {

        return this.userStoryRepository.findByStatus(status);

    }*/

    public void delete(Long id) {

        this.userStoryRepository.deleteById(id);

    }

}
