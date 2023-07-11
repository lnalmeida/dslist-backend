package com.lndev.dslist.dto;

import com.lndev.dslist.projections.GameMinProjection;

public class GameProjectionDTO {

	private long id;
	private String title;
	private int year;
	private String imgUrl;
	private String shortDescription;
	private Integer position;
	
	public GameProjectionDTO() {
	}

	public GameProjectionDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
		position = projection.getPosition();
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public Integer getPosition() {
		return position;
	}
	
	
}
