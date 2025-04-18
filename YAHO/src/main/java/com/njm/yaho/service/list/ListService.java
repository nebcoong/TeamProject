package com.njm.yaho.service.list;

import java.util.List;

import org.springframework.stereotype.Service;

import com.njm.yaho.domain.mysql.list.animeListMSDTO;

@Service
public interface ListService {
	
	List<animeListMSDTO> selectAllAnime();
	List<animeListMSDTO> searchAnime(String keyword);
}
