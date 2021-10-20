package com.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class Post {
	private Integer userID;
	private Integer postID;
	private String postBody;
	private Date timeStamp;
	public Post(Integer userID, Integer postID, String postBody, Date timeStamp) {
		super();
		this.userID = userID;
		this.postID = postID;
		this.postBody = postBody;
		this.timeStamp = timeStamp;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
