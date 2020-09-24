import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterFrame extends JFrame {

 String server = "jdbc:mysql://140.119.19.73:9306/";
 String database = "MG10";
 String config = "?useUnicode=true&characterEncoding=utf8";
 String url = server + database + config;
 String username = "MG10";
 String password = "rgan7r";
 JLabel l1 = new JLabel("註冊帳號:");
 JLabel l2 = new JLabel("註冊密碼:");
 JLabel l3 = new JLabel("您的名字:");
 JLabel l4 = new JLabel("推薦人帳號:");

 JTextField f1 = new JTextField();
 JTextField f2 = new JTextField();
 JTextField f3 = new JTextField();
 JTextField f4 = new JTextField();
 JButton btn1 = new JButton("送出註冊");
 JRadioButton rbtn1 = new JRadioButton("我有推薦人!");

 JTextArea area = new JTextArea();

 public RegisterFrame() throws MalformedURLException, IOException {
  ImageIcon imageIcon = new ImageIcon(
    ImageIO.read(new URL("https://i.ytimg.com/vi/Uj038RIp3tE/maxresdefault.jpg")));

  Image image = imageIcon.getImage(); // transform it
  Image newimg = image.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
  imageIcon = new ImageIcon(newimg);

  JLabel labelPic1 = new JLabel(imageIcon);

  //
  RegisterBtn();
  setLayout(new BorderLayout());
  JPanel p1 = new JPanel();
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();
  p2.add(rbtn1);
  p1.setLayout(new GridLayout(4, 2));
  p1.add(l1);
  p1.add(f1);

  p1.add(l2);
  p1.add(f2);

  p1.add(l3);
  p1.add(f3);

  p1.add(l4);
  p1.add(f4);

  p3.setLayout(new GridLayout(1, 2));
  p3.add(btn1);
  p3.add(area);

  add(p1, BorderLayout.NORTH);
  add(labelPic1, BorderLayout.CENTER);
  add(p2, BorderLayout.WEST);
  add(p3, BorderLayout.SOUTH);
  setTitle("註冊~~");
  setSize(600, 500);
  setVisible(true);

 }

 public void RegisterBtn() {
  class Send implements ActionListener {
   public void actionPerformed(ActionEvent e) {
    String ID = f1.getText();
    String NAME = f3.getText();
    String PASSWORD = f2.getText();

    int numID = Integer.valueOf(ID);

    try {
     users u1 = FindUser(numID);

     if (u1 != null) {
      area.append("已經註冊了!!"+"\n");
     }

     if (u1 == null && rbtn1.isSelected() == false) {

      String s = "INSERT INTO `User_data`(`User_id`, `User_name`, `User_password`, `Coin`) VALUES ('"
        + ID + "','" + NAME + "','" + PASSWORD + "','100')";

      Connection conn = DriverManager.getConnection(url, username, password);
      
   //   
      Statement stat = conn.createStatement();

      stat.executeUpdate(s);
      area.append("註冊成功!"+"\n");
      conn.close();

     } else if (u1 == null && rbtn1.isSelected() == true) {
      String ReID = f4.getText();
      int numID2 = Integer.valueOf(ReID);

      users u2 = FindUser(numID2);
      if (u2 != null) {
       String s = "INSERT INTO `User_data`(`User_id`, `User_name`, `User_password`, `Coin`) VALUES ('"
         + ID + "','" + NAME + "','" + PASSWORD + "','150')";
       Connection conn = DriverManager.getConnection(url, username, password);
       Statement stat = conn.createStatement();
       Connection conn2 = DriverManager.getConnection(url, username, password);
       Statement stat2 = conn2.createStatement();
       String s2 = "SELECT  Coin FROM User_data WHERE  User_id="+numID2+";";
       
       stat2.executeQuery(s2);
       ResultSet rs2=stat2.executeQuery(s2);
       if(rs2.next()==true) {
       int coin=rs2.getInt("Coin");
       coin=coin+100;
       
       String s3="UPDATE User_data SET `Coin`="+coin+" WHERE User_id="+numID2;
       
       Connection conn3 = DriverManager.getConnection(url, username, password);
       Statement stat3 = conn3.createStatement();
       stat3.executeUpdate(s3);
       
       }
       
       
       
       stat.executeUpdate(s);
       area.append("註冊成功!多領50金幣!"+"\n");
      } else {
       area.append("推薦人不存在!!"+"\n");
      }
//
     }
     ;

    } catch (SQLException e1) {
     // TODO Auto-generated catch block
     e1.printStackTrace();
    }

   }
  }
  btn1.addActionListener(new Send());

 }

 public users FindUser(int id) throws SQLException {
  String str = "查無此人";
  String s = "SELECT * FROM User_data WHERE User_id='" + id + "'";
  Connection conn = DriverManager.getConnection(url, username, password);
  Statement stat = conn.createStatement();
  users u1 = null;

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
   return u1;
  }

  return u1;
 }

 public static void main(String[] args) throws MalformedURLException, IOException {
  // TODO Auto-generated method stub

  RegisterFrame f = new RegisterFrame();

 }

}