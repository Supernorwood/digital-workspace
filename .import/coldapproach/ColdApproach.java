package digital.valorantsoftware.scrum.coldapproach;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(
        name = "cold-approach"
)
public class ColdApproach {

    private static final Logger log = LoggerFactory.getLogger(ColdApproach.class);
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            name = "status"
    )
    @NonNull
    private String Status;
    @Column(
            name = "codeName"
    )
    @NonNull
    private String CodeName;
    @Column(
            name = "location"
    )
    @NonNull
    private String Location;
    @Column(
            name = "detail"
    )
    @NonNull
    private String Detail;
    @Column(
            name = "openDetail"
    )
    @NonNull
    private String OpenDetail;
    @Column(
            name = "closeDetail"
    )
    @NonNull
    private String CloseDetail;
    @Column(
            name = "finalDetail"
    )
    @NonNull
    private String FinalDetail;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getCodeName() {
        return this.CodeName;
    }

    public void setCodeName(String codeName) {
        this.CodeName = codeName;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getDetail() {
        return this.Detail;
    }

    public void setDetail(String detail) {
        this.Detail = detail;
    }

    public String getOpenDetail() {
        return this.OpenDetail;
    }

    public void setOpenDetail(String openDetail) {
        this.OpenDetail = openDetail;
    }

    public String getCloseDetail() {
        return this.CloseDetail;
    }

    public void setCloseDetail(String closeDetail) {
        this.CloseDetail = closeDetail;
    }

    public String getFinalDetail() {
        return this.FinalDetail;
    }

    public void setFinalDetail(String finalDetail) {
        this.FinalDetail = finalDetail;
    }

    public String toString() {
        Integer var10000 = this.getId();
        return "ColdApproach(id=" + var10000 + ", Status=" + this.getStatus() + ", CodeName=" + this.getCodeName() + ", Location=" + this.getLocation() + ", Detail=" + this.getDetail() + ", OpenDetail=" + this.getOpenDetail() + ", CloseDetail=" + this.getCloseDetail() + ", FinalDetail=" + this.getFinalDetail() + ")";
    }

    public ColdApproach() {
    }

    public ColdApproach(@NonNull final String Status, @NonNull final String CodeName, @NonNull final String Location, @NonNull final String Detail, @NonNull final String OpenDetail, @NonNull final String CloseDetail, @NonNull final String FinalDetail) {
        if (Status == null) {
            throw new NullPointerException("Status is marked non-null but is null");
        } else if (CodeName == null) {
            throw new NullPointerException("CodeName is marked non-null but is null");
        } else if (Location == null) {
            throw new NullPointerException("Location is marked non-null but is null");
        } else if (Detail == null) {
            throw new NullPointerException("Detail is marked non-null but is null");
        } else if (OpenDetail == null) {
            throw new NullPointerException("OpenDetail is marked non-null but is null");
        } else if (CloseDetail == null) {
            throw new NullPointerException("CloseDetail is marked non-null but is null");
        } else if (FinalDetail == null) {
            throw new NullPointerException("FinalDetail is marked non-null but is null");
        } else {
            this.Status = Status;
            this.CodeName = CodeName;
            this.Location = Location;
            this.Detail = Detail;
            this.OpenDetail = OpenDetail;
            this.CloseDetail = CloseDetail;
            this.FinalDetail = FinalDetail;
        }
    }
}
