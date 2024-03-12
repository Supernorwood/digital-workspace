package digital.valorantsoftware.workspace.story;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = {SQLException.class})
public class IncomeStreamService {

    @Autowired
    IncomeStreamRepository incomeStreamRepository;
    public static final double GOAL_NUMBER = 500_000.00;

    //method in service to return constant - controller calls to do the work
    public double findGoal(){
        return GOAL_NUMBER;
    }





    public Double calculatedEarnedTotal() {
        List<IncomeStream> incomeStreams = incomeStreamRepository.findAll();
        //calculating total earnings across all income streams
        double totalEarnings = 0.0;
        for (IncomeStream incomeStream : incomeStreams) {
            totalEarnings += incomeStream.getEstimatedEarningsPerYear();
        }

        return totalEarnings;
    }

    public Double percentageOfTotalEarnings() {
        // Calculate percentage (handle potential division by zero)
        double percentOfEarnings = calculatedEarnedTotal();
        double percentage = (percentOfEarnings / GOAL_NUMBER) * 100.0;
        if (GOAL_NUMBER == 0) {
            percentage = 0.0; // Avoid division by zero
        }

        return percentage;
    }


    public Double distanceToGoal() {
        // Calculate distance to goal
        double totalEarnings = calculatedEarnedTotal();
        double distance = Math.max(0.0, GOAL_NUMBER - totalEarnings);

        return distance;
    }



    @Autowired
    public IncomeStreamService(IncomeStreamRepository userStoryRepository) {

        this.incomeStreamRepository = userStoryRepository;

    }

    public IncomeStream save(IncomeStream project) {

        return this.incomeStreamRepository.save(project);

    }

    public List<IncomeStream> findAll() {

        return this.incomeStreamRepository.findAll();

    }

    public IncomeStream findById(Long id) {

        return this.incomeStreamRepository.findById(id).orElse(null);

    }

/*    public List<UserStory> findByStatus(String status) {

        return this.userStoryRepository.findByStatus(status);

    }*/

    public void delete(Long id) {

        this.incomeStreamRepository.deleteById(id);

    }

}
