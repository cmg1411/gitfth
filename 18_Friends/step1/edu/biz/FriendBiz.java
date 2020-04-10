package com.edu.biz;

import java.sql.SQLException;

import com.edu.dao.FriendDAO;
import com.edu.dto.FriendDTO;

public class FriendBiz {

	public int insertFriend(FriendDTO dto) throws SQLException {
		FriendDAO dao = new FriendDAO();
		int n = dao.insertFriend(dto);
		return n;
	}

}
