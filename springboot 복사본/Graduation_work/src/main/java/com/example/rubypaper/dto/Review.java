package com.example.rubypaper.dto;

public class Review {
	
	private String review_id;
	private String shoes_id;
	private int rating;
	private String reviewText;
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public String getShoes_id() {
		return shoes_id;
	}
	public void setShoes_id(String shoes_id) {
		this.shoes_id = shoes_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", shoes_id=" + shoes_id + ", rating=" + rating + ", reviewText="
				+ reviewText + "]";
	}

}
