package kg.megacom.Recommendation.system.Recommendation.system.services;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.PopularDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicResponse;

import java.util.List;

public interface PopularServices extends BaseServices<PopularDTO>{
    List<MusicRepoResponse> getPopular(int lang);
}
