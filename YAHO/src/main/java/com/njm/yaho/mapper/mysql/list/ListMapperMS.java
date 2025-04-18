package com.njm.yaho.mapper.mysql.list;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.njm.yaho.domain.mysql.list.animeListMSDTO;

@Mapper
public interface ListMapperMS {
	//전체 목록
	List<animeListMSDTO> selectAllAnime();
	//검색
	List<animeListMSDTO> searchAnime(String keyword);
	
}
