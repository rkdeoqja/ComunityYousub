package com.yousub.DTO;

public class BackDTO {
	
	int bNo;
	int boardNo;
	String id;
	String nick;
	String bYoutuber;
	String bContent;
	String bDate;
	int bHit;
	
	
	public BackDTO(int bNo, int boardNo, String id, String nick, String bYoutuber, String bContent, String bDate,
			int bHit) {
		super();
		this.bNo = bNo;
		this.boardNo = boardNo;
		this.id = id;
		this.nick = nick;
		this.bYoutuber = bYoutuber;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
	}
	
	
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	public String getbYoutuber() {
		return bYoutuber;
	}
	public void setbYoutuber(String bYoutuber) {
		this.bYoutuber = bYoutuber;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	
	
}
