package com.edu.dao;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dto.FriendDTO;

public class FriendDAO {

	public int insertFriend(FriendDTO dto){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			String sql=("INSERT INTO FRIEND VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJumin1());
			pstmt.setString(3, dto.getJumin2());
			pstmt.setString(4, dto.getTel1());
			pstmt.setString(5, dto.getTel2());
			pstmt.setString(6, dto.getTel3());
			pstmt.setInt(7, dto.getGender());
			pstmt.setInt(8, dto.getRead());
			pstmt.setInt(9, dto.getMovie());
			pstmt.setInt(10, dto.getMusic());
			pstmt.setInt(11, dto.getGame());
			pstmt.setInt(12, dto.getShopping());
			n = pstmt.executeUpdate();
	
			if(n>0)
				commit(conn);
		}catch(SQLException e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}

	public List<FriendDTO> getList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		List<FriendDTO> list = new ArrayList<>();
		FriendDTO dto = null;
		
		try {
			String sql = "SELECT * FROM FRIEND";
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				dto = new FriendDTO();
				dto.setName(res.getString("NAME"));
				dto.setJumin1(res.getString("JUMIN1"));
				dto.setJumin2(res.getString("JUMIN2"));
				dto.setTel1(res.getString("TEL1"));
				dto.setTel2(res.getString("TEL2"));
				dto.setTel3(res.getString("TEL3"));					
				dto.setGender(res.getInt("GENDER"));
				dto.setRead(res.getInt("READ"));
				dto.setMovie(res.getInt("MOVIE"));
				dto.setMusic(res.getInt("MUSIC"));
				dto.setGame(res.getInt("GAME"));
				dto.setShopping(res.getInt("SHOPPING"));
				
				list.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
				
		return list;
	}

	public int modifyFriend(FriendDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			String sql=("UPDATE FRIEND SET TEL1=?, TEL2=?, TEL3=?,READ=?,MOVIE=?,MUSIC=?,GAME=?,SHOPPING=? WHERE NAME=?");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTel1());
			pstmt.setString(2, dto.getTel2());
			pstmt.setString(3, dto.getTel3());
			pstmt.setInt(4, dto.getRead());
			pstmt.setInt(5, dto.getMovie());
			pstmt.setInt(6, dto.getMusic());
			pstmt.setInt(7, dto.getGame());
			pstmt.setInt(8, dto.getShopping());
			pstmt.setString(9, dto.getName());
			n = pstmt.executeUpdate();
	
			if(n>0)
				commit(conn);
		}catch(SQLException e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}
	
	public int deleteFriend(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			String sql=("DELETE FROM FRIEND WHERE NAME=?");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			n = pstmt.executeUpdate();
	
			if(n>0)
				commit(conn);
		}catch(SQLException e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return n;
	}
}
