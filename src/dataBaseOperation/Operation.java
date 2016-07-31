package dataBaseOperation;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
//import java.sql.Date;//�����������������÷���insertCustomerInforʱ�����������޷�����
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Operation {
	static Connection conn;
	// 驱动
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://127.0.0.1:3306/hotel";
	static String user = "root";
	static String password = "1234";

	public static void Connect() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean FindInforByRoomnumber(String roomNumber)
			throws SQLException, UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "select * from roominfor where roomNumber=" + roomNumber;
		ResultSet rs = statement.executeQuery(sql);
		int isBooked = 0;
		while (rs.next()) {
			isBooked = rs.getInt("isBooked");
			// isBooked = new Integer(isBooked.getBytes("UTF-8"), "UTF-8");
			// System.out.println("����״̬�� " + isBooked);
		}
		if (0 == isBooked)

			return false;
		else
			return true;
	}

	// public static void FindByName(String name) throws SQLException,
	// UnsupportedEncodingException {
	//
	// Statement statement = conn.createStatement();
	// String sql = "select * from customer where name='" + name + "'";
	// ResultSet rs = statement.executeQuery(sql);
	//
	// String roomNumber = null;
	// String IDnumber = null;
	//
	// while (rs.next()) {
	// roomNumber = rs.getString("roomNumber");
	// IDnumber = rs.getString("IDnumber");
	// roomNumber = new String(roomNumber.getBytes("UTF-8"), "UTF-8");
	// IDnumber = new String(IDnumber.getBytes("UTF-8"), "UTF-8");
	// }
	// rs.close();
	// // conn.close();
	// }

	public static void insertCustomerInfor(String name, String IDnumber,
			String dStartDate, String dEndDate, int Countdays,
			String phoneNumber, String SingleOrDouble) throws SQLException {
		Statement statement = conn.createStatement();

		String sql = "insert into customer (name,IDnumber,StartDate,EndDate,Countdays,phoneNumber,SingleOrDouble,fareOfHousing) values("
				+ "'"
				+ name
				+ "'"
				+ ","
				+ "'"
				+ IDnumber
				+ "'"
				+ ","
				+ "'"
				+ dStartDate
				+ "'"
				+ ","
				+ "'"
				+ dEndDate
				+ "'"
				+ ","
				+ Countdays
				+ ","
				+ "'"
				+ phoneNumber
				+ "'"
				+ ","
				+ "'"
				+ SingleOrDouble + "'" + ",";

		// statement.execute(sql + "'" + name + "'" + "," + "'" + IDnumber + "'"
		// + "," + "'" + dStartDate + "'" + "," + "'" + dEndDate + "'"
		// + "," + Countdays + "," + "'" + phoneNumber + "'" + "," + "'"
		// + SingleOrDouble + "'" + ")");
		if (SingleOrDouble.equals("singleRoom")) {

			sql +=  (100*Countdays)+")";//单人房100元一天
		}
		else 
			sql +=  (200*Countdays)+")";//双人房200元每天
		statement.execute(sql);

		String sql2 = "update  customer set sum=pub+bar+coffee+taxi+fareOfHousing";
		statement.execute(sql2);// 计算总帐目
	}

	public static void insertChangeRoomInfor(String name, String roomNumber)
			throws SQLException {

		Statement statement = conn.createStatement();
		String sql1 = "update roominfor set isBooked=1              where roomNumber="
				+ roomNumber;
		String sql2 = "update roominfor set master= " + "'" + name + "'"
				+ "where roomNumber=" + roomNumber;
		statement.execute(sql1);
		statement.execute(sql2);

	}

	public static void updateWhenRegister(String name) throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "update customer set isHasRegister=1 where name=" + "'"
				+ name + "'";
		statement.execute(sql);
	}

	// 登记时选择房间
	public static void updateWhenRegister(String name, String roomNumber)
			throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "update customer set roomNumber=" + roomNumber
				+ " where name=" + "'" + name + "'";
		statement.execute(sql);
	}

	public static Vector getName() throws SQLException,
			UnsupportedEncodingException {

		Statement statement = conn.createStatement();
		String sql = "select * from customer";
		ResultSet rs = statement.executeQuery(sql);
		String name = null;
		Vector v = new Vector();
		while (rs.next()) {
			name = rs.getString("name");
			name = new String(name.getBytes("UTF-8"), "UTF-8");
			v.add(name);
		}
		rs.close();
		return v;
	}

	public static String getMasterofRoom(String roomNumber)
			throws SQLException, UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "select * from roominfor where roomNumber=" + roomNumber;
		ResultSet rs = statement.executeQuery(sql);
		String Master = null;
		while (rs.next()) {
			Master = rs.getString("Master");
			Master = new String(Master.getBytes("UTF-8"), "UTF-8");
		}
		return Master;
	}

	public static void changeRoom(String ID1, String ID2) throws SQLException,
			UnsupportedEncodingException { // 用于更换房间的函数

		Statement statement = conn.createStatement();
		String sql1 = "UPDATE roominfor SET isBooked = 0 WHERE roomNumber = "
				+ ID1;
		statement.execute(sql1); // sql1是把原房间的isBooked属性改为0
		String sql2 = "SELECT master FROM roominfor WHERE roomNumber = " + ID1;
		ResultSet rs = statement.executeQuery(sql2);
		String name = null;
		while (rs.next()) {
			name = rs.getString("master");

			name = new String(name.getBytes("UTF-8"), "UTF-8");
		}

		System.out.println(name); // sql2用于获取原房间的客户名称

		String sql11 = "UPDATE customer SET roomNumber =  " + ID2
				+ "   WHERE roomNumber = " + ID1;
		statement.execute(sql11); // sql6用于把客户表的房间号改成变化后的

		String sql3 = "UPDATE roominfor" + "" + " SET master = '' "
				+ " WHERE roomNumber = " + ID1;
		statement.execute(sql3); // sql3用于删除原房间的客户名
		String sql4 = "UPDATE roominfor SET master = " + "'" + name + "'"
				+ " WHERE roomNumber = " + ID2;
		statement.execute(sql4); // sql4用于把客户姓名填入新房间号的数据库记录中
		String sql5 = "UPDATE roominfor SET isBooked = 1                WHERE roomNumber = "
				+ ID2;
		statement.execute(sql5);

	}

	// 其他服务
	public static void service(boolean a, boolean b, boolean c, boolean d,
			String roomNumber) throws SQLException {
		if (a == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET pub = 50 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (b == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET bar = 10 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (c == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET taxi = 20 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (d == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET coffee = 30 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		Statement statement = conn.createStatement();
		String sql2 = "update  customer set sum=pub+bar+coffee+taxi+fareOfHousing";
		statement.execute(sql2);// 计算总帐目

	}

	public static void checkout(String roomNumber) throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "UPDATE roominfor SET isBooked = 0 WHERE roomNumber = "
				+ roomNumber;
		String sql2 = "UPDATE roominfor SET master = "+"'"+ "'"+ "WHERE roomNumber = "
				+ roomNumber;
		statement.execute(sql);
		statement.execute(sql2);
		//删除customer个人记录
		String sql3 = "DELETE from customer  WHERE roomNumber = "
				+ roomNumber;
		statement.execute(sql3);
	}

	// 根据name查询消费记录
	public static Vector consumption(String name) throws SQLException,
			UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM customer WHERE name = " + "'" + name + "'";
		ResultSet rs = statement.executeQuery(sql);
		int pub = 0;
		int bar = 0;
		int taxi = 0;
		int coffee = 0;
		int fareOfHousing = 0;
		int sum = 0;
		while (rs.next()) {
			pub = rs.getInt("pub");
			bar = rs.getInt("bar");
			taxi = rs.getInt("taxi");
			coffee = rs.getInt("coffee");
			fareOfHousing = rs.getInt("fareOfHousing");
			sum = rs.getInt("sum");
		}
		Vector v = new Vector();
		v.add(name);
		v.add(String.valueOf(pub));
		v.add(String.valueOf(bar));
		v.add(String.valueOf(taxi));
		v.add(String.valueOf(coffee));
		v.add(String.valueOf(fareOfHousing));
		v.add(String.valueOf(sum));
		System.out.println(String.valueOf(pub));
		// return String.valueOf(pub);//数字转换为字符串
		return v;
	}
}
