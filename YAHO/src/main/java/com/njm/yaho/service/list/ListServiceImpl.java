package com.njm.yaho.service.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njm.yaho.domain.mysql.list.animeListMSDTO;
import com.njm.yaho.mapper.mysql.list.ListMapperMS;

@Service
public class ListServiceImpl implements ListService {
	// MySQL Mapper
	@Autowired
	private ListMapperMS mapperMS;
	
	@Override
	public List<animeListMSDTO> selectAllAnime() {
		return mapperMS.selectAllAnime();
	}
	@Override
	public List<animeListMSDTO> searchAnime(String keyword) {
		return mapperMS.searchAnime(keyword);
	}
}
