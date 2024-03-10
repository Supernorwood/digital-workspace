package digital.valorantsoftware.scrum.coldapproach;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(
        rollbackOn = {SQLException.class}
)
public class ColdApproachService {

    ColdApproachRepository coldApproachRepository;

    @Autowired
    public ColdApproachService(ColdApproachRepository coldApproachRepository) {
        this.coldApproachRepository = coldApproachRepository;
    }

    public ColdApproach saveColdApproach(ColdApproach coldApproach) {
        return (ColdApproach) this.coldApproachRepository.save(coldApproach);
    }

    public List<ColdApproach> fetchAllColdApproaches() {
        return this.coldApproachRepository.findAll();
    }

    public void deleteColdApproach(Integer id) {
        this.coldApproachRepository.deleteById(id);
    }
}
