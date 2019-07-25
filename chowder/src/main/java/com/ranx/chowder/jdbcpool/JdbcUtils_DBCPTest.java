package com.ranx.chowder.jdbcpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 
 * @author ranx
 * @date 2018年11月30日 上午15:19:43
 *
 */
public class JdbcUtils_DBCPTest {

	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement st = null;                                                                                                                                                                   
		ResultSet rs = null;
		try {
			conn = JdbcUtils_DBCP.getConnection();
			String sql = "insert into test1(name) values(?)";
			st = conn.prepareStatement(sql);
			st.setString(1, "gfd");
			st.executeUpdate();
			//获取db自动生成的主键
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}
}
