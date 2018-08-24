package cn.yrf.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestByJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		String url = "jdbc:hsqldb:file:D:/SoftWareInstall/HSqlDB/test;shutdown=true";
		System.out.println("第一步 url 用户名 密码");
		Connection c = DriverManager.getConnection(url, "root", "root");
		Statement st = c.createStatement();
		System.out.println("第二步 执行查询语句");
		ResultSet rs = st.executeQuery("select * from category");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + "****" + name);

		}
		System.out.println("第三步 关闭连接");
		st.close();
		c.close();
		System.out.println("第四步 成功");

	}
}
