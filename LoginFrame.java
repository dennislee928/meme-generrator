import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
//import jdk.javadoc.internal.doclets.toolkit.util.Group;
import javax.swing.*;

public class LoginFrame extends JFrame {

	JLabel l1 = new JLabel("請輸入一般使用者帳號ID:");
	JTextField f1 = new JTextField();

	JLabel l2 = new JLabel("請輸入一般使用者密碼:");
	JTextField f2 = new JTextField();

	int i = 0;

	JLabel l3 = new JLabel("請輸入管理員ID:");
	JTextField f3 = new JTextField();

	JLabel l4 = new JLabel("請輸入管理員密碼:");
	JTextField f4 = new JTextField();

	JRadioButton btn1 = new JRadioButton("一般使用者");
	JRadioButton btn2 = new JRadioButton("管理員");

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	JButton bx = new JButton("提交");
	JButton xbobo = new JButton("沒有帳號嗎?" + "\n" + "點此註冊!");

	Border blackline = BorderFactory.createLineBorder(Color.BLUE);
	Border Greenline = BorderFactory.createLineBorder(Color.GREEN);
	Border Redline = BorderFactory.createLineBorder(Color.RED);

	String server = "jdbc:mysql://140.119.19.73:9306/";
	String database = "MG10";
	String config = "?useUnicode=true&characterEncoding=utf8";
	String url = server + database + config;
	String username = "MG10";
	String password = "rgan7r";
	
	users u1;

//
	public LoginFrame() throws Exception, IOException {
		Reset();
		OpenRegister();
		ImageIcon imageIcon = new ImageIcon(
				ImageIO.read(new URL("https://assets.juksy.com/files/articles/97856/800x_100_w-5e2992d086356.jpg")));
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);

		JLabel labelPic1 = new JLabel(imageIcon);

		JPanel main = new JPanel();
		main.setLayout(new GridLayout(4, 1));

		Buttons();
		p1.setLayout(new GridLayout(2, 2));
		p2.setLayout(new GridLayout(2, 2));
		p3.setLayout(new GridLayout(1, 2));
		p4.setLayout(new GridLayout(1, 2));

		p1.add(l1);
		p1.add(f1);
		p1.setBorder(blackline);

		p1.add(l2);
		p1.add(f2);

		p2.add(l3);
		p2.add(f3);

		p2.add(l4);
		p2.add(f4);

		p3.setBorder(Redline);
		p3.add(btn1);
		p3.add(btn2);
		p3.add(xbobo);

		p2.setBorder(Greenline);
		setLayout(new BorderLayout());
//
		main.add(p1);
		main.add(p2);
		main.add(p3);

		// add(p4);
		main.add(bx);
		add(main, BorderLayout.CENTER);
		add(labelPic1, BorderLayout.SOUTH);
		setSize(500, 1000);
		setVisible(true);

		setTitle("Login");
	}

	public void OpenRegister() {
		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				try {
					RegisterFrame r = new RegisterFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		xbobo.addActionListener(new Send());

	}

	public boolean FindUser() throws SQLException {

		boolean x = false;

		String id = f1.getText();
		String password = f2.getText();

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
			u1 = new users("" + ID, PASSWORD);
			x = true;
			return x;

		}
		return x;

	}

	public void Reset() {
		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				f1.setText("");
				f2.setText("");
				f3.setText("");
				f4.setText("");

				f1.setEditable(true);
				f2.setEditable(true);
				f3.setEditable(true);
				f4.setEditable(true);

			}

		}
		JButton res = new JButton("重設");
		res.addActionListener(new Send());
		p3.add(res);

	}

	public void Buttons() {

		ButtonGroup g = new ButtonGroup();

		g.add(btn1);
		g.add(btn2);

		class Send implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String id = f1.getText();
				String Password = f2.getText();
				String str1 = f3.getText();
				String str2 = f4.getText();
//int numID=Integer.valueOf(id)

				String str = "查無此人";
				String s = "SELECT * FROM `User_data` WHERE User_id='" + id + "'";
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
				users u1 = null;

				try {
					stat.executeQuery(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = stat.executeQuery(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String NAME;
//
				String PASSWORD = null;

				String ID = null;
//
				try {
					while (rs.next() == true) {
						ID = rs.getString("User_id");
						PASSWORD = rs.getString("User_password");
						NAME = rs.getString("User_name");
					}

					boolean x = (id.equalsIgnoreCase(ID) == true && PASSWORD.equalsIgnoreCase(Password));

					if (btn1.isSelected() == true && i < 6 && x == true) {
						f3.setText("");
						f4.setText("");
						f3.setEditable(false);
						f4.setEditable(false);

						f1.setEditable(true);
						f2.setEditable(true);
						i = i + 1;
						main m = new main();
						m.setUsers(getUsers());

					} else if (btn2.isSelected() == true && i < 6) {

						f1.setText("");
						f2.setText("");
						// System.out.println("!!!!");
						f1.setEditable(false);
						f2.setEditable(false);

						f3.setEditable(false);
						f4.setEditable(false);
						// String str1= f3.getText();
						// String str2=f4.getText();
						i = i + 1;

						System.out.println(str1);
						if (str1.equalsIgnoreCase("1") == true && str2.equalsIgnoreCase("104306007") == true) {
							System.out.println(str1);
							ManagerFrame f = new ManagerFrame();
						}
					} else if (btn1.isSelected() == false && btn2.isSelected() == false) {
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "請選擇您的身分!");

					} else if (i >= 6) {
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "登入太多次!休息一下再來~~");

					}
					// System.out.println(i);

				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		bx.addActionListener(new Send());

	}
	
	public users getUsers() {
		return this.u1;
	}

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		LoginFrame l = new LoginFrame();
	}

}
