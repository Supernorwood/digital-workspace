package digital.valorantsoftware.scrum.coldapproach;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"cold-approach"})
public class ColdApproachController {

    @Autowired
    ColdApproachService coldApproachService;

    public ColdApproachController() {
        System.out.println();
        System.out.println("*** ");
        System.out.println("*** init -- ColdApproachController");
        System.out.println("*** ");
        System.out.println();
    }

    @GetMapping({"/"})
    public String hello() {
        return "ColdApproachController";
    }

    @GetMapping({"/health-check"})
    public String returnHealthCheckContentJSON() {
        return "ColdApproachController API Is Up!";
    }

    @GetMapping({"/all-cold-approaches"})
    public List<ColdApproach> fetchAllColdApproaches() {
        System.out.println("enter > fetchAllColdApproaches");
        List<ColdApproach> activityTaskList = this.coldApproachService.fetchAllColdApproaches();
        System.out.println("the list of cold approaches");
        System.out.println(activityTaskList);
        System.out.println("exit < fetchAllColdApproaches");
        return activityTaskList;
    }

    @PostMapping({"/add-cold-approach"})
    public ColdApproach saveColdApproach(@RequestBody final String responseString) {
        System.out.println("enter > saveColdApproach");
        System.out.println("in:  " + responseString);
        JSONObject jsonObject = new JSONObject(responseString);
        System.out.println("jsonObject: ");
        System.out.println(jsonObject);
        ColdApproach coldApproach = new ColdApproach();
        coldApproach.setStatus(jsonObject.getString("coldApproachStatus"));
        coldApproach.setCodeName(jsonObject.getString("coldApproachCodeName"));
        coldApproach.setLocation(jsonObject.getString("coldApproachLocation"));
        coldApproach.setDetail(jsonObject.getString("coldApproachDetail"));
        coldApproach.setOpenDetail(jsonObject.getString("coldApproachOpenDetail"));
        coldApproach.setCloseDetail(jsonObject.getString("coldApproachCloseDetail"));
        coldApproach.setFinalDetail(jsonObject.getString("coldApproachFinalDetail"));
        coldApproach = this.coldApproachService.saveColdApproach(coldApproach);
        System.out.println("exit < saveColdApproach");
        return coldApproach;
    }

    @GetMapping({"/delete-cold-approach/{id}"})
    public String read(@PathVariable("id") int id) {
        System.out.println("id : " + id);
        this.coldApproachService.deleteColdApproach(id);
        return "DELETED";
    }
}
