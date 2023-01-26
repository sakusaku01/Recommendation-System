package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.Recommendation.system.Recommendation.system.model.enums.RoleStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class RoleDTO {

    Long id;
    RoleStatus name;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date editDate;
}
