import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//
public class ManagerFrame extends JFrame {

	String server = "jdbc:mysql://140.119.19.73:9306/";
	String database = "MG10";
	String config = "?useUnicode=true&characterEncoding=utf8";
	String url = server + database + config;
	String username = "MG10";
	String password = "rgan7r";

	JTextArea area = new JTextArea();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JTextField f1 = new JTextField();

	public ManagerFrame() throws SQLException {
		summit();
		DeletedUser();
		CreateFindUser();
		setSize(500, 500);
		setVisible(true);
		setTitle("Manage");
	}

	public void CreateFindUser() {
		setLayout(new GridLayout(3, 1));
		JLabel l1 = new JLabel();
		l1.setText("請輸入ID:");

		JButton btn1 = new JButton("查詢!");

		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(f1.getText());
				// ManagerFrame m = new ManagerFrame();
				// m.setVisible(false);
				try {
					FindUser(id);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					area.append(FindUser(id));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		btn1.addActionListener(new Send());
		p1.setLayout(new GridLayout(2, 2));
		p1.add(l1);
		p1.add(f1);
		p2.add(btn1);
		p3.setLayout(new GridLayout(1, 1));
		p3.add(area);
		add(p1);
		add(p2);
		add(p3);

	}

	public void getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		String s = "INSERT INTO `Manager`(`Manager_ID`, `Manager_PassWord`, `Manaer_Name`) VALUES ('1','104306007','lee')";
		Statement stat = conn.createStatement();

		stat.executeUpdate(s);

	}

	public String FindUser(int id) throws SQLException {
		String str = "查無此人";
		String s = "SELECT * FROM `User_data` WHERE User_id='" + id + "'";
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stat = conn.createStatement();

		stat.executeQuery(s);
		ResultSet rs = stat.executeQuery(s);

		String NAME;

		String PASSWORD;

		int ID;

		while (rs.next() == true) {
			ID = rs.getInt("User_id");
			PASSWORD = rs.getString("User_password");
			NAME = rs.getString("User_name");
			str = ("User_ID:" + ID + "\n" + "User_password:" + PASSWORD + "\n" + "User_name:" + NAME + "\n");
			return str;
		}

		return str;
	}

	public void DeletedUser() throws SQLException {
		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Statement stat = null;
				try {
					stat = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String str1 = "DELETE FROM `User_data` WHERE User_id='" + f1.getText() + "'";
				try {
					stat.executeUpdate(str1);
					area.append("成功刪除!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//
			}
		}
		JButton DBtn = new JButton();
		DBtn.addActionListener(new Send());
		DBtn.setText("刪除");
		p3.add(DBtn);
	}

	public void summit() throws SQLException {
		// String str = "查無此人";
		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String s = "SELECT * FROM `User_data` ";
				Connection conn;
				try {
					conn = DriverManager.getConnection(url, username, password);

					Statement stat = conn.createStatement();

					stat.executeQuery(s);
					ResultSet rs = stat.executeQuery(s);

					String NAME;

					String PASSWORD;

					int ID;
					

					while (rs.next() == true) {
						ID = rs.getInt("User_id");
						area.append("" + ID+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		JButton SEBtn=new JButton();
		SEBtn.addActionListener(new Send());
		SEBtn.setText("顯示全部人");
		p2.add(SEBtn);		
	}

	public static void main(String[] args) throws IOException, SQLException {
		ManagerFrame f = new ManagerFrame();

	}

}
