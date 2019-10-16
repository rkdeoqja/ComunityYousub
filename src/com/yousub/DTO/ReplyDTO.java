package com.yousub.DTO;

import java.sql.Timestamp;

public class ReplyDTO {

	int boardNo ;
	int bNo;
	String id ;
	String nick;
	String reContent;
	Timestamp reDate;
	int reHit;
	int reHate;
	int reNo;
	
	public ReplyDTO(int boardNo, int bNo, String id, String nick, String reContent, Timestamp reDate, int reHit,
			int reHate,int reNo) {
		super();
		this.boardNo = boardNo;
		this.bNo = bNo;
		this.id = id;
		this.nick = nick;
		this.reContent = reContent;
		this.reDate = reDate;
		this.reHit = reHit;
		this.reHate = reHate;
		this.reNo = reNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
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

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Timestamp getReDate() {
		return reDate;
	}

	public void setReDate(Timestamp reDate) {
		this.reDate = reDate;
	}

	public int getReHit() {
		return reHit;
	}

	public void setReHit(int reHit) {
		this.reHit = reHit;
	}

	public int getReHate() {
		return reHate;
	}

	public void setReHate(int reHate) {
		this.reHate = reHate;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}
	
	
	
}
