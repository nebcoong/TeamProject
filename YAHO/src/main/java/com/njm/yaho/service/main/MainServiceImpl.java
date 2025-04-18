package com.njm.yaho.service.main;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njm.yaho.domain.mysql.main.MainMSDTO;
import com.njm.yaho.mapper.mysql.main.MainMapperMS;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainMapperMS mapperMS;
	
	@Override
	public List<MainMSDTO> getTodayAnimeList() {
		String[] koreanDays = { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일" };
	    int dayIndex = LocalDate.now().getDayOfWeek().getValue() % 7; // 월:1 ~ 일:7
	    String today =  koreanDays[dayIndex - 1];
	    
		return mapperMS.getTodayAnimeList(today);
	}

}
