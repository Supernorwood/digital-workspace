package digital.valorantsoftware.workspace.story;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("income")
public class IncomeStreamController {

    @Autowired
    IncomeStreamService incomeStreamService;



    public IncomeStreamController() {

        System.out.println("## ");

        System.out.println("## init > UserStoryController");

        System.out.println("## ");

    }

    @GetMapping("")
    public String hello() {

        return "User Story API";

    }

    @GetMapping("/health")
    public String health() {

        return "OK";

    }

    @GetMapping("/")
    public List<IncomeStream> findAll() {

        System.out.println("enter > findAll");

        List<IncomeStream> userStoryList = this.incomeStreamService.findAll();

        System.out.println("projectList / ");

        System.out.println(userStoryList);

        System.out.println("exit < findAll");

        return userStoryList;

    }

    @PutMapping("/")
    IncomeStream createUserStory(@RequestBody IncomeStream userStory) {

        System.out.println("enter > createUserStory");

        System.out.println("userStory / " + userStory);

        return this.incomeStreamService.save(userStory);

    }

    @GetMapping("/{id}")
    IncomeStream findById(@PathVariable Long id) {

        return this.incomeStreamService.findById(id);

    }

  /*  @GetMapping("/byStatus/{status}")
    List<UserStory> findByStatus(@PathVariable String status) {

        return this.incomeStreamService.findByStatus(status);

    }*/

    @PostMapping("/update")
    public IncomeStream updateUserStory(@RequestBody IncomeStream project) {

        System.out.println("enter > updateUserStory");

        System.out.println("userStory / " + project);

        IncomeStream responseUserStory = this.incomeStreamService.save(project);

        System.out.println("responseUserStory / " + responseUserStory);

        System.out.println("exit < updateUserStory");

        return responseUserStory;

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        this.incomeStreamService.delete(id);

    }


    /*
     * add end points to user story api
     * continue customizing and rename
     * add target number (for dashboard) query based - endpoint for target
     * endpoint how much made, EP for diff, EP for progress %
     * */

    @GetMapping("/goal")
    public Double findGoal() {

        System.out.println("enter > findGoal");

        Double userStoryList = this.incomeStreamService.findGoal();

        System.out.println("projectList / ");

        System.out.println(userStoryList);

        System.out.println("exit < findGoal");

        return userStoryList;

    }

    @GetMapping("earned")
    public Double earned() {

       return this.incomeStreamService.calculatedEarnedTotal();

    }

    @GetMapping("percentEarned")
    public Double percentEarned() {

        return this.incomeStreamService.percentageOfTotalEarnings();

    }

    @GetMapping("distanceToGoal")
    public Double distanceToGoal() {

        return this.incomeStreamService.distanceToGoal();

    }


    /*
    * now can print EP with target
    * and Income streams
    * aggregation fx made and move to svc function
    *
    * */

    /*{
    "estimatedEarningsPerYear" : 150000.00,
    "name" : "Privtae Paper",
    "source" : "YT",
    "description" : "hustle"
}

{
    "estimatedEarningsPerYear" : 100000.00,
    "name" : "Gov Con",
    "source" : "USA",
    "description" : "feet up"
}
*/

}
