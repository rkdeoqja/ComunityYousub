package com.yousub.DTO;

import java.sql.Timestamp;

public class ItemsDTO {
	
	int boardNo;
	int no;
	String id;
	String nick;
	String chName;
	String iContent;
	Timestamp iDate;
	
	
	public ItemsDTO(int boardNo, int no, String id, String nick, String chName, String iContent, Timestamp iDate) {
		super();
		this.boardNo = boardNo;
		this.no = no;
		this.id = id;
		this.nick = nick;
		this.chName = chName;
		this.iContent = iContent;
		this.iDate = iDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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

	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getiContent() {
		return iContent;
	}
	public void setiContent(String iContent) {
		this.iContent = iContent;
	}
	public Timestamp getiDate() {
		return iDate;
	}
	public void setiDate(Timestamp iDate) {
		this.iDate = iDate;
	}
	
	

}
