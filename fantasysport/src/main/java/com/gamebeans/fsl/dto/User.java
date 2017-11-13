package com.gamebeans.fsl.dto;

import org.json.JSONObject;

public class User
{
	private long id;
	private String emailID;
	private String mobileNumber;
	private String facebookID;
	private int gameId;
	private String userReg;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getFacebookID() {
		return facebookID;
	}
	public void setFacebookID(String facebookID) {
		this.facebookID = facebookID;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getUserReg() {
		return userReg;
	}
	public void setUserReg(String userReg) {
		this.userReg = userReg;
	}
	
	public JSONObject toJSONObject() throws Exception
	{
		JSONObject messageBody = new JSONObject();
		messageBody.put( "uid", this.id );
		messageBody.put( "emailID", this.emailID );
		messageBody.put( "mobileNumber", this.mobileNumber );
		messageBody.put( "facebookID", this.facebookID );
		messageBody.put( "userReg", this.userReg );
		messageBody.put("gameId", this.gameId);

		return messageBody;
	}

	public JSONObject fromJSONString( String value ) throws Exception
	{
		JSONObject messageBody = new JSONObject( value );

		this.id = messageBody.optLong( "id" );
		this.emailID = messageBody.optString( "email" );
		this.mobileNumber = messageBody.optString( "mobile" );
		this.facebookID = messageBody.optString( "fbid" );
		this.gameId=messageBody.optInt("gameid");
		this.userReg = messageBody.optString( "userReg" );

		return messageBody;
	}
	
}