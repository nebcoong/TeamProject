package com.njm.yaho.mapper.oracle.schedule;

import org.apache.ibatis.annotations.Mapper;

import com.njm.yaho.domain.oracle.user.UserDTO;

@Mapper
public interface UserGender {
	int countGender(UserDTO dto);
}
