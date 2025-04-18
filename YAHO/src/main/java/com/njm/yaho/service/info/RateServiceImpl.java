package com.njm.yaho.service.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.njm.yaho.domain.oracle.info.RatingChartDTO;
import com.njm.yaho.domain.oracle.info.RatingDTO;
import com.njm.yaho.mapper.oracle.info.RateMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateMapper rateMapper;

    @Override
    public int insertRate(RatingDTO dto) {
    	// TODO Auto-generated method stub
    	return rateMapper.insertRate(dto);
    }

    @Override
    public List<RatingDTO> selectRateListByAnime(int ANIME_ID) {
        return rateMapper.selectRateListByAnime(ANIME_ID);
    }

    @Override
    public Double getAverageScore(int ANIME_ID) {
        return rateMapper.getAverageScore(ANIME_ID);
    }
    @Override
    public RatingDTO getRate(long mno) {
    	// TODO Auto-generated method stub
    	return null;
    }
    
    //차트 정보
    @Override
    public List<RatingDTO> selectRateCount(int ANIME_ID) {
    	
    	return rateMapper.selectRateCount(ANIME_ID);
    }
    
}