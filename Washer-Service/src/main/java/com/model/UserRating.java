package com.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="userratingdb")
public class UserRating {
    @Id
    @NotNull(message="washername should not be empty")
    private String washerName;
    @NotNull(message="rating should not be empty")
	 private int rating;
    @NotNull(message="review should not be empty")
	 private String review;
	public UserRating(@NotNull(message = "washername should not be empty") String washerName,
			@NotNull(message = "rating should not be empty") int rating,
			@NotNull(message = "review should not be empty") String review) {
		super();
		this.washerName = washerName;
		this.rating = rating;
		this.review = review;
	}
	public UserRating() {
		super();
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "UserRating [washerName=" + washerName + ", rating=" + rating + ", review=" + review + "]";
	}
    

}
