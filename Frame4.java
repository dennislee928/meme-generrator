import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//自行上傳url
public class Frame4 {
 static String server = "jdbc:mysql://140.119.19.73:9306/";
 static String database = "MG10";
 static String config = "?useUnicode=true&characterEncoding=utf8";
 static String urldb = server + database + config;
 static String username = "MG10";
 String password = "rgan7r";

 ImageIcon photo1 = new ImageIcon(ImageIO.read(new URL("https://xi-winnie.gengen.co/img/card8.png?20190706")));

 JLabel labelPic1 = new JLabel(photo1);

 JLabel title = new JLabel();

 JLabel REID=new JLabel("請輸入你的ID~~~");
 JTextField confirmID= new JTextField();
 JTextField t22 = new JTextField();
 JTextField fileName = new JTextField();

 JFrame f = new JFrame();

 JPanel p1 = new JPanel();
 JPanel p2 = new JPanel();

 JRadioButton jrb = new JRadioButton("黑色");
 JRadioButton jrb2 = new JRadioButton("白色");
 JRadioButton jrb3 = new JRadioButton("紅色");
 JRadioButton jrb4 = new JRadioButton("藍色");
 JRadioButton jr5 = new JRadioButton("綠色");

 JTextField field1 = new JTextField();
 JTextField field2 = new JTextField();
 JTextField field3 = new JTextField();
 JTextField field4 = new JTextField();
 JTextField URL = new JTextField();

 JButton btn = new JButton("預覽!");
 // JTextArea area=new JTextArea();

 JLabel l1 = new JLabel("請輸入大小><:");
 JLabel l2 = new JLabel("請輸入想添加的文字><:");
 JLabel l3 = new JLabel("請輸入文字x座標:");
 JLabel l4 = new JLabel("請輸入文字y座標:");
 JLabel l5 = new JLabel("請輸入圖片網址:");

 JTextArea area1 = new JTextArea();
 JPanel panel3 = new JPanel();
 JScrollPane jp;
 // ------------------------------------
 private users u1;

 public Frame4() throws IOException {
  
  
  f.setTitle("Frame4");
  CreateTextFieldAndLabel();
  CreateRadioButton();
  CreateFrame();
  SetPic();

 }
 
 public void setUsers(users u) {
	 this.u1 = u;
 }

 public JFrame CreateFrame() {
  JPanel pxxx=new JPanel();
  pxxx.setLayout(new GridLayout(2,1));
  pxxx.add(REID);
  pxxx.add(confirmID);
  f.add(pxxx);
  
  
  jp = new JScrollPane(area1);

  JLabel l = new JLabel("請輸入存檔名稱:");
  JPanel px = new JPanel();
  px.setLayout(new GridLayout(1, 2));
  px.add(l);
  px.add(fileName);

  title.setText("請於右側輸入想添加的文字!!><");
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();

  panel1.setLayout(new GridLayout(2, 1));
  URL.setSize(50, 1);
  panel1.add(l5);
  panel1.add(URL);
  //

  panel.setLayout(new BorderLayout());

  panel.add(btn, BorderLayout.CENTER);
  f.setSize(550, 800);
  p2.setSize(100, 20);
  // p1.add(jr5);
  f.setLayout(new GridLayout(8, 1));
  f.add(px);
  f.add(panel1);
  f.add(p1);
  f.add(p2);
  f.add(panel3);

  f.add(panel);
  JPanel pxx = new JPanel();
  pxx.setLayout(new GridLayout(1, 1));
  pxx.add(jp);
  f.add(pxx);
  f.setVisible(true);
  return f;

 }

 public void CreateRadioButton() {

  ButtonGroup buttonGroup = new ButtonGroup();
  buttonGroup.add(jrb);
  buttonGroup.add(jrb2);
  buttonGroup.add(jrb3);
  buttonGroup.add(jrb4);
  buttonGroup.add(jr5);
  p1.add(jr5);
  p1.add(jrb4);
  p1.add(jrb3);
  p1.add(jrb2);
  p1.add(jrb);

 };

 public void CreateTextFieldAndLabel() throws IOException {
  String url = URL.getText();
  p2.setLayout(new GridLayout(2, 4));
  p2.add(l1);
  p2.add(field1);
  p2.add(l2);
  p2.add(field2);
  p2.add(l3);
  p2.add(field3);
  p2.add(l4);
  p2.add(field4);

  ImageIcon imageIcon = new ImageIcon(ImageIO.read(new URL(
    "https://stickershop.line-scdn.net/stickershop/v1/product/10060443/LINEStorePC/main.png;compress=true")));

  Image image = imageIcon.getImage(); // transform it
  Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
  imageIcon = new ImageIcon(newimg);

  JLabel labelPic1 = new JLabel(imageIcon);
  panel3.add(labelPic1);
  panel3.setSize(1000, 1000);

 }

 public void SetPic() {

  class setpic1 implements ActionListener {
   public void actionPerformed(ActionEvent e) {
    String strFileName = fileName.getText();
    int num1 = Integer.valueOf(field1.getText());

    String url = URL.getText();

    String str = field2.getText();
    int numX = Integer.valueOf(field3.getText());
    int numY = Integer.valueOf(field4.getText());
    //
    System.out.println(num1);
    area1.append("大小" + num1 + "\n");
    JFrame f = new JFrame();
    f.setSize(500, 500);
    BufferedImage image = null;
    System.out.println("這裡");
    try {
     image = ImageIO.read(new URL(url));
    } catch (IOException e1) {
     // TODO Auto-generated catch block
     e1.printStackTrace();
    }
//
    Graphics g = image.getGraphics();

    Font font1 = new Font(Font.DIALOG, Font.BOLD, num1);
    g.setFont(font1);
    if (jrb.isSelected() == true) {
     g.setColor(Color.BLACK);
     area1.append("顏色:黑" + "\n");

    } else if (jrb2.isSelected() == true) {
     g.setColor(Color.WHITE);
     area1.append("顏色:白" + "\n");

    } else if (jrb3.isSelected() == true) {
     g.setColor(Color.RED);
     area1.append("顏色:紅" + "\n");
    } else if (jrb3.isSelected() == true) {
     g.setColor(Color.blue);
     area1.append("顏色:藍");
    } else if (jrb.isSelected() == true) {
     g.setColor(Color.green);
     area1.append("顏色:綠" + "\n");
    }
    area1.append("x位置:" + numX + ":y位置:" + numY + "\n");
    area1.append(strFileName + ".png已經儲存!" + "\n");

    g.drawString(str, numX, numY);
//

    try {
     ImageIO.write(image, "png", new File(strFileName + ".png"));
     ImageIcon photo2 = new ImageIcon(strFileName + ".png");

     Image image1 = photo2.getImage();
     Image newimg = image1.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);

     photo2 = new ImageIcon(newimg);

     JLabel labelPic2 = new JLabel(photo2);
     JPanel p = new JPanel();
     p.add(labelPic2);
     f.add(p);
     f.setTitle(strFileName);
     f.setVisible(true);
     g.dispose();
    } catch (IOException e1) {
     // TODO Auto-generated catch block
     e1.printStackTrace();
    }
   // try {
    String idget = confirmID.getText();
    
    try {
     System.out.println(idget);
     if (idget.equals(null)==false) {
      JFrame frame = new JFrame();
      
      String s = "SELECT Coin FROM User_data WHERE User_id=" + idget + ";";
      Connection conn;
     
       conn = DriverManager.getConnection(urldb, username, password);
      
      Statement stat = conn.createStatement();
      stat.executeQuery(s);
      ResultSet rs = stat.executeQuery(s);
      
      if (rs.next() == true) {
       int coin = rs.getInt("Coin");
       System.out.println("coin:"+coin);
       //coin = rs.getInt("Coin");
       if ((coin - 5) >= 0) {
        coin = coin - 5;
        JOptionPane.showMessageDialog(frame, "錢錢有:" + coin);
        String sCoin = " UPDATE User_data SET `Coin`=" + coin + " WHERE User_id=" + idget+";";
        stat.executeUpdate(sCoin);
       } else {
        String string = "錢錢不夠囉!!!!快找人來一起玩!!";
        JOptionPane.showMessageDialog(frame, string);
       }

      } else {
       JOptionPane.showMessageDialog(frame, "你是誰!!");
      }

    // }
    //}// catch (SQLException ex1) {
     //JFrame frame = new JFrame();
     //JOptionPane.showMessageDialog(frame, "有甚麼出錯了呢:(");
    }

   
  }catch(SQLException ex) {  ex.printStackTrace();};
    
   }}
  btn.addActionListener(new setpic1());

 }

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  Frame4 f = new Frame4();
  // f.Create();
 }

}