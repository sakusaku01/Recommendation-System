package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

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
    Date addDate;
    Date editDate;
}
