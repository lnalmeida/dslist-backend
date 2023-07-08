package com.lndev.dslist.dto;

import java.util.Optional;

import com.lndev.dslist.entities.Game;
import com.lndev.dslist.projections.GameMinProjection;

public class GameMinDTO {
	private long id;
	private String title;
	private int year;
	private String imgUrl;
	private String shortDescription;
	private Integer position;
	
	public GameMinDTO() {}

	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
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
	
}