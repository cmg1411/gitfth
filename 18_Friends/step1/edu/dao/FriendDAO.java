package com.edu.dao;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edu.dto.FriendDTO;

public class FriendDAO {

	public int insertFriend(FriendDTO dto) throws SQLException {
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

}
