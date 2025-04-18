package com.njm.yaho.mapper.oracle.info;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njm.yaho.domain.oracle.info.RatingChartDTO;
import com.njm.yaho.domain.oracle.info.RatingDTO;

@Mapper
public interface RateMapper {
    int insertRate(RatingDTO dto);
    
    List<RatingDTO> selectRateListByAnime(int ANIME_ID);
    
    Double getAverageScore(int ANIME_ID);
    
    List<RatingDTO> selectRateCount(int ANIME_ID);
    
}