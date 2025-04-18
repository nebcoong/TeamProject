package com.njm.yaho.domain.oracle.info;

import lombok.Data;

@Data

public class RatingDTO {
	private int SCORE_ID;
	private int ANIME_ID;
	private String SCORE_CONTENT;
	private double SCORE_SCORE;
	private String USER_ID;
	
	private Integer COUNT;
}
