package com.yousub.DTO;

import java.sql.Timestamp;

public class OfferDTO {
	
			int boardNo;
			int oNo;
			String id;
			String nick;
			String oUrl;
			String offerId;
			String oContent;
			Timestamp oDate;
			int oHit;
			
			
			public OfferDTO(int boardNo, int oNo, String id, String nick, String oUrl, String offerId, String oContent,
					Timestamp oDate, int oHit) {
				super();
				this.boardNo = boardNo;
				this.oNo = oNo;
				this.id = id;
				this.nick = nick;
				this.oUrl = oUrl;
				this.offerId = offerId;
				this.oContent = oContent;
				this.oDate = oDate;
				this.oHit = oHit;
			}
			
			
			public int getBoardNo() {
				return boardNo;
			}
			public void setBoardNo(int boardNo) {
				this.boardNo = boardNo;
			}
			public int getoNo() {
				return oNo;
			}
			public void setoNo(int oNo) {
				this.oNo = oNo;
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
			public String getoUrl() {
				return oUrl;
			}
			public void setoUrl(String oUrl) {
				this.oUrl = oUrl;
			}
			
			public String getOfferId() {
				return offerId;
			}


			public void setOfferId(String offerId) {
				this.offerId = offerId;
			}


			public String getoContent() {
				return oContent;
			}
			public void setoContent(String oContent) {
				this.oContent = oContent;
			}
			public Timestamp getoDate() {
				return oDate;
			}
			public void setoDate(Timestamp oDate) {
				this.oDate = oDate;
			}
			public int getoHit() {
				return oHit;
			}
			public void setoHit(int oHit) {
				this.oHit = oHit;
			}
			
}
