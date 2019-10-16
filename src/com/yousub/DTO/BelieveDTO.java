package com.yousub.DTO;

import java.sql.Timestamp;

public class BelieveDTO {
	int bNo;
	String id;
	String nick;
	String bTitle;
	String bUrl="";
	String bContent;
	Timestamp bDate;
	int bHit;
	int boardNo = 1;
	
	
	public BelieveDTO(int bNo, String id, String nick, String bTitle, String bUrl, String bContent, Timestamp bDate,
			int bHit,int boardNo) {
		super();
		this.bNo = bNo;
		this.id = id;
		this.nick = nick;
		this.bTitle = bTitle;
		this.bUrl = bUrl;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.boardNo = boardNo;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbUrl() {
		return bUrl;
	}
	public void setbUrl(String bUrl) {
		this.bUrl = bUrl;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	

	
}
