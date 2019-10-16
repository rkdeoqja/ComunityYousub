package com.yousub.DTO;

import java.sql.Timestamp;

public class DTO {

	int no;
	String id;
	String pw;
	String nick;
	String name;
	String email;
	String pwhint;
	Timestamp joda;
	
	
	public DTO(int no, String id, String pw, String nick, String name, String email, String pwhint, Timestamp joda) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.name = name;
		this.email = email;
		this.pwhint = pwhint;
		this.joda = joda;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwhint() {
		return pwhint;
	}
	public void setPwhint(String pwhint) {
		this.pwhint = pwhint;
	}
	public Timestamp getJoda() {
		return joda;
	}
	public void setJoda(Timestamp joda) {
		this.joda = joda;
	}
	
	
}
