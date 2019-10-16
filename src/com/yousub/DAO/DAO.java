package com.yousub.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.yousub.DTO.BelieveDTO;
import com.yousub.DTO.DTO;
import com.yousub.DTO.ItemsDTO;
import com.yousub.DTO.OfferDTO;
import com.yousub.DTO.ReplyDTO;

public class DAO {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String cId = "yousub";
		String cPw = "oracle_11g";
	
	public void memberJoin(String id,String pw,String nick,String name,String email,String pwhint) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String joinQuery = "INSERT INTO test "+
								"(no,id,pw,nick,name,email,pwhint,joda) "+
								"VALUES(member_seq.nextval, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = con.prepareStatement(joinQuery);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			pstmt.setString(3,nick);
			pstmt.setString(4,name);
			pstmt.setString(5,email);
			pstmt.setString(6,pwhint);
			
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//memberJoin
	
	public DTO loginCheck(String id, String pw) {
		
		DTO dto =null;
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String tpw;
		int x=-1;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String checkQuery = "SELECT * FROM test WHERE id=?";
			pstmt = con.prepareStatement(checkQuery);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String userid = rs.getString("id");
				tpw = rs.getString("pw");
				String nick = rs.getString("nick");
				String name=rs.getString("name");
				String email = rs.getString("email");
				String pwhint = rs.getString("pwhint");
				Timestamp joda = rs.getTimestamp("joda");
				System.out.println("입력한 비밀번호 : "+pw+",저장된 비밀번호: "+tpw);
				if(tpw.equals(pw)) {
					dto = new DTO(no,userid,pw,nick,name,email,pwhint,joda);
					System.out.println("로그인 성공페이지");
					
				}else {
					System.out.println("비밀번호가 다릅니다");
					
				}
				
			}else {
				System.out.println("아이디가 일치하지 않습니다.");
				
			}
			
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}//loginCheck
	
	public String idCheck(String id) {
		String checkId=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String query ="SELECT id FROM test WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println(id + "dao 해당아이디가 존재합니다");
				checkId = "";
				
			}else{
				System.out.println(id+"dao 해당아이디를 사용할수 있습니다");
				 checkId=id;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return checkId;
	}//idCheck()
	
	public ArrayList<DTO> memberInfo(String userId){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String memberInfoQuery = "SELECT no, id, pw, nick, name, email, pwhint, joda From test WHERE id= ?";
			pstmt = con.prepareStatement(memberInfoQuery);
			pstmt.setString(1, userId);
			rs	= pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pwhint = rs.getString("pwhint");
				Timestamp joda = rs.getTimestamp("joda");
				
				DTO dto = new DTO(no,id,pw,nick,name,email,pwhint,joda);
				dtos.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
				
		return dtos;
	}//memberInfo()
	
	public boolean infoChange(String id , String pw) {
		boolean isPw = false;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		
		System.out.println("infoChange():"+id);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String infoChangeQuery = "UPDATE test SET pw=? WHERE id=?";
			pstmt = con.prepareStatement(infoChangeQuery);
			pstmt.setString(1,pw);
			pstmt.setString(2,id);
			int rn = pstmt.executeUpdate();
			
			if(rn>0) {
				isPw=true;
				System.out.println("rn:"+rn+",isPw:"+isPw);
			}else {
				isPw=false;
				System.out.println("rn:"+rn+",isPw"+isPw);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return isPw;
		
	}//infoChange()
	
	public void bWrite(String id,String nick,String bTitle,String bUrl,String bContent) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String bQuery= "INSERT INTO test_believe (bno,id,nick,btitle,burl,bcontent,bdate,bhit,boardNo) "
					+"VALUES(believe_seq.nextval, ?, ?, ?, ?, ?, SYSDATE, 0,1)";
			pstmt = con.prepareStatement(bQuery);
			pstmt.setString(1, id);
			pstmt.setString(2, nick);
			pstmt.setString(3, bTitle);
			pstmt.setString(4, bUrl);
			pstmt.setString(5, bContent);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//bWrite()

	public ArrayList<BelieveDTO> bList(){
		ArrayList<BelieveDTO> bdtos =new ArrayList<BelieveDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String bListQuery="SELECT * FROM test_believe ORDER BY bDate DESC";
			pstmt = con.prepareStatement(bListQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bNo = rs.getInt("bNo");
				String id= rs.getString("id");
				String nick = rs.getString("nick");
				String bTitle = rs.getString("bTitle");
				String bUrl = rs.getString("bUrl");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int boardNo = rs.getInt("boardNo");
				BelieveDTO bdto = new BelieveDTO(bNo,id,nick,bTitle,bUrl,bContent,bDate,bHit,boardNo);
				bdtos.add(bdto);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return bdtos;
	}//bList
	
	public BelieveDTO believeView(String strNo) {
		upHit(strNo);
		BelieveDTO bdto = null;
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String bViewQuery = "SELECT * FROM test_believe WHERE bNo = ?";
			pstmt = con.prepareStatement(bViewQuery);
			pstmt.setInt(1, Integer.parseInt(strNo));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bNo = rs.getInt("bNo");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String bTitle = rs.getString("bTitle");
				String bUrl = rs.getString("bUrl");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int boardNo = rs.getInt("boardNo");
				bdto = new BelieveDTO(bNo,id,nick,bTitle,bUrl,bContent,bDate,bHit,boardNo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return bdto;
	}
	
	public void believeDelete(String strbNo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String bDeleteQuery = "DELETE FROM test_Believe WHERE bNo=?";
			pstmt = con.prepareStatement(bDeleteQuery);
			pstmt.setInt(1,Integer.parseInt(strbNo));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//believeDelete
	
	public void replyAdd(String strId,String strNick,String strBoardNo,String strBno,String strReContent) {
		
		Connection con= null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String reAddQuery =  "INSERT INTO test_reply (boardNo,bNo,id,nick,reContent,reDate,reHit,reHate,reNo) "
					+"VALUES(?,?,?,?,?,SYSDATE,0,0,reply_seq.NEXTVAL)";
			pstmt = con.prepareStatement(reAddQuery);
			pstmt.setInt(1, Integer.parseInt(strBoardNo));
			pstmt.setInt(2, Integer.parseInt(strBno));
			pstmt.setString(3, strId);
			pstmt.setString(4, strNick);
			pstmt.setString(5, strReContent);
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
	}//replyAdd()
	
	public ArrayList<ReplyDTO> reView(String strBoradNo,String strBno){
		ArrayList<ReplyDTO> redtos = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String reViewQuery = "SELECT * FROM test_reply WHERE boardNo=? AND bNo=? ORDER BY reDate desc";
			pstmt = con.prepareStatement(reViewQuery);
			pstmt.setInt(1, Integer.parseInt(strBoradNo));
			pstmt.setInt(2, Integer.parseInt(strBno));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				int bNo = rs.getInt("bNo");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String reContent = rs.getString("reContent");
				Timestamp reDate = rs.getTimestamp("reDate");
				int reHit = rs.getInt("reHit");
				int reHate = rs.getInt("reHate");
				int reNo =rs.getInt("reNo");
				ReplyDTO redto = new ReplyDTO(boardNo,bNo,id,nick,reContent,reDate,reHit,reHate,reNo);
				
				redtos.add(redto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return redtos;
	}//reView
	
	private void upHit(String bNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName(driver);
			connection = 
					DriverManager.getConnection(url,cId,cPw);
			String query = "UPDATE test_believe SET bHit = bHit+1 WHERE bno=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bNo);
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn: "+rn);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//upHit
	
	public void upReHit(String reNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName(driver);
			connection = 
					DriverManager.getConnection(url,cId,cPw);
			String query = "UPDATE test_reply SET reHit = reHit+1 WHERE reNo=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(reNo));
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn: "+rn);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//upReHit
	
	public void upReHate(String reNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName(driver);
			connection = 
					DriverManager.getConnection(url,cId,cPw);
			String query = "UPDATE test_reply SET reHate = reHate+1 WHERE reNo=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,Integer.parseInt(reNo));
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn: "+rn);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//upReHate
	
	public void reDelete(String reNo) {
		
		Connection con= null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String redelQuery = "DELETE FROM test_reply WHERE reNo=?";
			pstmt = con.prepareStatement(redelQuery);
			pstmt.setInt(1, Integer.parseInt(reNo));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//reDelete
	
	
	public void itemWrite(String id,String nick,String chName,String iContent) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String itemWQuery = "INSERT INTO test_items (boardNo,no,id,nick,chName,iContent,iDate) VALUES(2,item_seq.nextval,?,?,?,?,SYSDATE)";
			pstmt = con.prepareStatement(itemWQuery);
			pstmt.setString(1, id);
			pstmt.setString(2, nick);
			pstmt.setString(3, chName);
			pstmt.setString(4, iContent);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//itemWrite
	
	public ArrayList<ItemsDTO> iList(){
		ArrayList<ItemsDTO> idtos = new ArrayList<ItemsDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String iLQuery = "SELECT * FROM test_items";
			pstmt = con.prepareStatement(iLQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int boardNo = rs.getInt("boardNo");
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String chName = rs.getString("chName");
				String iContent = rs.getString("iContent");
				Timestamp iDate = rs.getTimestamp("iDate");
				ItemsDTO idto = new ItemsDTO(boardNo,no,id,nick,chName,iContent,iDate);
				
				idtos.add(idto);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return idtos;
	}//iList
	
	public ArrayList<ReplyDTO> reBest() {
		
		ArrayList<ReplyDTO> redtos = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String bestReQuery = "SELECT * FROM test_reply ORDER BY reHit DESC";
			pstmt = con.prepareStatement(bestReQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				int bNo = rs.getInt("bNo");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String reContent = rs.getString("reContent");
				Timestamp reDate= rs.getTimestamp("reDate");
				int reHit = rs.getInt("reHit");
				int reHate = rs.getInt("reHate");
				int reNo = rs.getInt("reNo");
				ReplyDTO redto = new ReplyDTO(boardNo,bNo,id,nick,reContent,reDate,reHit,reHate,reNo);
				redtos.add(redto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return redtos;
	}//reBest
	
	public ArrayList<ReplyDTO> reNew(){
		
		ArrayList<ReplyDTO> reNdtos = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String reNewQuery = "SELECT * FROM test_reply ORDER BY reDate DESC";
			pstmt = con.prepareStatement(reNewQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				int bNo = rs.getInt("bNo");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String reContent = rs.getString("reContent");
				Timestamp reDate= rs.getTimestamp("reDate");
				int reHit = rs.getInt("reHit");
				int reHate = rs.getInt("reHate");
				int reNo = rs.getInt("reNo");
				ReplyDTO reNedto = new ReplyDTO(boardNo,bNo,id,nick,reContent,reDate,reHit,reHate,reNo);
				
				reNdtos.add(reNedto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return reNdtos;
	}//reNew
	
	public ArrayList<OfferDTO> offerList(){
		ArrayList<OfferDTO> odtos = new ArrayList<OfferDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,cId,cPw);
			String offerListQuery = "SELECT * FROM test_offer ORDER BY oDate DESC";
			pstmt = con.prepareStatement(offerListQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardNo = rs.getInt("boardNo");
				int oNo = rs.getInt("oNo");
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				String oUrl = rs.getString("oUrl");
				String oTitle = rs.getString("oTitle");
				String oContent = rs.getString("oContent");
				Timestamp oDate = rs.getTimestamp("oDate");
				int oHit = rs.getInt("oHit");
				
				OfferDTO odto = new OfferDTO(boardNo,oNo,id,nick,oUrl,oTitle,oContent,oDate,oHit);
				odtos.add(odto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return odtos;
	}
	
}
