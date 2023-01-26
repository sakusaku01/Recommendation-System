package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class PopularDTO {

    Long id;
    int orderNum;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;

    MusicDTO musicId;
}
