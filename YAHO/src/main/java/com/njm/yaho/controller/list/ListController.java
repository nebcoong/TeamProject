package com.njm.yaho.controller.list;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njm.yaho.domain.mysql.list.animeListMSDTO;
import com.njm.yaho.service.list.ListService;

@Controller
@RequestMapping("List")
public class ListController {
	private static Logger log = LoggerFactory.getLogger(ListController.class);
	
	@Autowired
	private ListService listService;

//	@GetMapping("List_list")
//	public String allList(animeListDTO dto, Model model) {
//		log.info("Call Get: list_list");
//		
//		List<animeListDTO> list = new ArrayList<>();
//		
//		//데이터 추가
//		animeListDTO anime1 = new animeListDTO();
//		anime1.setANIME_ID(1);
//		anime1.setTITLE("소시민 시즌2");
//		anime1.setTHUMNAIL_GARO_URL("/img/소시민 시즌2 2.png");
//		anime1.setTHUMNAIL_SERO_URL("/img/소시민 시즌2 1.png");
//		anime1.setSCORE(3.5);
//		anime1.setTAGS("미스터리, 일상");
//		anime1.setWEEKDAY("토요일");
//		anime1.setUPDATED_AT("20250405");
//		
//		animeListDTO anime2 = new animeListDTO();
//		anime2.setANIME_ID(2);
//		anime2.setTITLE("온라인 게임 신부");
//		anime2.setTHUMNAIL_GARO_URL("/img/가로 온라인게임신부.jpg");
//		anime2.setTHUMNAIL_SERO_URL("/img/세로 온라인게임신부.png");
//		anime2.setSCORE(2.2);
//		anime2.setTAGS("판타지");
//		anime2.setWEEKDAY("금요일");
//		anime2.setUPDATED_AT("20250301");
//		
//		animeListDTO anime3 = new animeListDTO();
//	    anime3.setANIME_ID(3);
//	    anime3.setTITLE("전대 레드 이세계에서 모험가 되다");
//	    anime3.setTHUMNAIL_GARO_URL("/img/전대 레드 이세계에서 모험가 되다 2.png");
//	    anime3.setTHUMNAIL_SERO_URL("/img/전대 레드 이세계에서 모험가 되다 1.png");
//	    anime3.setSCORE(4.0);
//	    anime3.setTAGS("판타지, 드라마, 탐험");
//	    anime3.setWEEKDAY("월요일");
//	    anime3.setUPDATED_AT("20250413");
//	    
//	    list.add(anime1);
//	    list.add(anime2);
//	    list.add(anime3);
//	    list.add(anime1);
//	    list.add(anime2);
//	    list.add(anime3);
//	    
//	    for(int i=0; i<list.size(); i++) {
//	    	 System.out.println(list.get(i));
//	    }
//	    
//	    model.addAttribute("list", list);
//	    
//	    return "List/list.html";	    
//	}
	//전체 리스트 불러오기
	@GetMapping("List_list")
	public String getAnimeList(@RequestParam(required = false) String tag, Model model) {
		List<animeListMSDTO> list = listService.selectAllAnime();

        model.addAttribute("list", list);
        model.addAttribute("selectedTag", tag); // 선택된 태그 표시용(선택사항)
        return "List/list.html";
	}
	//검색기능
	@GetMapping("/List/search")
	@ResponseBody
	public List<Map<String, Object>> searchAnime(@RequestParam("keyword") String keyword) {
	    List<animeListMSDTO> searchResult = listService.searchAnime(keyword);

	    return searchResult.stream().map(anime -> {
	        Map<String, Object> map = new HashMap<>();
	        map.put("title", anime.getTITLE());
	        map.put("score", anime.getSCORE());
	        map.put("tags", anime.getTAGS());
	        map.put("thumnailSeroUrl", anime.getTHUMNAIL_SERO_URL());
	        return map;
	    }).collect(Collectors.toList());
	}
}
