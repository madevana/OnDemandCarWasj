package com.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washpackdb")
public class WashPack {
	
	@Id
	@NotNull(message="Washpack id is not null")
	private int id;
	@NotNull(message="Washpack packageName is not null")
	private String packagename;
	@NotNull(message="Washpack costis not null")
	private int Cost;
	@NotNull(message="Washpack description is not null")
	private String description;
	public WashPack(@NotNull(message = "Washpack id is not null") int id,
			@NotNull(message = "Washpack packageName is not null") String packagename,
			@NotNull(message = "Washpack costis not null") int cost,
			@NotNull(message = "Washpack description is not null") String description) {
		super();
		this.id = id;
		this.packagename = packagename;
		Cost = cost;
		this.description = description;
	}
	public WashPack() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public int getCost() {
		return Cost;
	}
	public void setCost(int cost) {
		Cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "WashPack [id=" + id + ", packagename=" + packagename + ", Cost=" + Cost + ", description=" + description
				+ "]";
	}
	
	

	
}