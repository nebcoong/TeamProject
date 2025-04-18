package com.njm.yaho.service.info;

import java.util.List;

import com.njm.yaho.domain.oracle.info.RatingChartDTO;
import com.njm.yaho.domain.oracle.info.RatingDTO;

public interface RateService {
	int insertRate(RatingDTO dto);
	
	List<RatingDTO> selectRateListByAnime(int ANIME_ID);
    
	Double getAverageScore(int ANIME_ID);
    
    RatingDTO getRate(long mno);
    
    List<RatingDTO> selectRateCount(int ANIME_ID);
}
