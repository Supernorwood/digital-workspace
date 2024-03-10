package digital.valorantsoftware.workspace.story;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Entity
@Table(name = "userstory")
public class UserStory {

    private static final Logger log = LoggerFactory.getLogger(UserStory.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //   @NonNull
    @Column(name = "estimatedEarningsPerYear")
    private Double estimatedEarningsPerYear;

    //   @NonNull
    @Column(name = "name")
    private String name;

    //  @NonNull
    @Column(name = "description")
    private String description;

    //  @NonNull
    @Column(name = "source")
    private String source;

//    //  @NonNull
//    @Column(name = "category")
//    private String category;
    //   @NonNull




/*    // Use java.util.Date for timestamps
    private Date insertDate;
    private Date updateDate;*/

    public UserStory() {
    }

    public UserStory(double estimatedEarningsPerYear, String source, String name, String description) {
        this.estimatedEarningsPerYear = estimatedEarningsPerYear;
        this.source = source;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "IncomeStream{" +
                "estimatedEarningsPerYear=" + estimatedEarningsPerYear +
                ", source='" + source + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }


    public double getEstimatedEarningsPerYear() {
        return estimatedEarningsPerYear;
    }

    public void setEstimatedEarningsPerYear(double estimatedEarningsPerYear) {
        this.estimatedEarningsPerYear = estimatedEarningsPerYear;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
