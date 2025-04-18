package com.njm.yaho.controller.schedule;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njm.yaho.controller.info.RateControllerTest;
import com.njm.yaho.domain.oracle.info.RatingDTO;
import com.njm.yaho.service.info.RateService;
import com.njm.yaho.service.schedule.ScheduleService;

@Controller
@RequestMapping("/Schedule")
public class AnimeScheduleController {
	private static final Logger log = LoggerFactory.getLogger(RateControllerTest.class);
	
	@Autowired
	private ScheduleService service;
	
	@Autowired
	private RateService Rateservice;
	
	@GetMapping("animeSchedule")
	public void showAnimeList(Model model) {
        // 요일 리스트 (요일 순서 보장)
        List<String> daysOfWeek = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일");

        // 모델에 데이터 추가
        model.addAttribute("daysOfWeek", daysOfWeek);
        model.addAttribute("animeByDay", service.WeekdayAnimeList());
        
        int anime_id = 999;
		List<RatingDTO> list = Rateservice.selectRateListByAnime(999);
		log.info("list : " + list);
		
		model.addAttribute("list",list);
		
		//모델에 평균
		
		double grade = Rateservice.getAverageScore(anime_id);
		log.info("평균: "+ grade);
		
		model.addAttribute("grade",grade);
		
		String mark = "";

		if (grade >= 1.0 && grade < 2.0) {
		    mark = "별로에요";
		} else if (grade < 3.0) {
		    mark = "평범해요";
		} else if (grade < 4.0) {
		    mark = "훌륭해요";
		} else {
		    mark = "명작";
		}

		model.addAttribute("gradeMark", mark);
		
		//막대그래프
		
		List<RatingDTO> ratingList = Rateservice.selectRateCount(999);

	    // 5개의 구간 정의: 0~1, 1~2, 2~3, 3~4, 4~5
	    List<String> scoreLabels = Arrays.asList("0~1", "1~2", "2~3", "3~4", "4~5");
	    int[] countPerRange = new int[5];

	    for (RatingDTO dto : ratingList) {
	        double score = dto.getSCORE_SCORE();
	        int count = dto.getCOUNT();

	        if (score >= 0 && score < 1) {
	            countPerRange[0] += count;
	        } else if (score >= 1 && score < 2) {
	            countPerRange[1] += count;
	        } else if (score >= 2 && score < 3) {
	            countPerRange[2] += count;
	        } else if (score >= 3 && score < 4) {
	            countPerRange[3] += count;
	        } else if (score >= 4 && score <= 5) {
	            countPerRange[4] += count;
	        }
	    }

	    // 리스트로 변환하여 모델에 전달
	    List<Integer> countList = Arrays.stream(countPerRange).boxed().collect(Collectors.toList());

	    model.addAttribute("scoreList", scoreLabels); // X축 레이블
	    model.addAttribute("countList", countList);   // Y축 값

	    log.info("X축 구간: " + scoreLabels);
	    log.info("Y축 count: " + countList);
	    
	    //도넛
	    double maleRatio = 20.0;   // 백분율
	    double femaleRatio = 80.0;
	    
	    model.addAttribute("maleRatio", maleRatio);
	    model.addAttribute("femaleRatio", femaleRatio);
	    
	    log.info("남자: "+maleRatio);
	    log.info("여자: "+femaleRatio);
	    
	    
	    
	
        //System.out.println("애니 요일별 리스트: " + service.WeekdayAnimeList());
	}
}
