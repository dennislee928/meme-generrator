import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*; 
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.sql.*; 

public class blobtest { 
 private static Connection conn = null; 
 private static PreparedStatement pstmt = null; 
 private static ResultSet rs = null; 
 private File file = null; 
 static String server = "jdbc:mysql://140.119.19.73:9306/";
 static String database = "MG10";
 static String config = "?useUnicode=true&characterEncoding=utf8";
 static String url = server + database + config;
 static String username = "MG10";
 static String password = "rgan7r";

 public blobtest() 
 { 
 } 

 public static Image blobRead(String picName) throws Exception 
 { 
  
  try 
  { 
   conn = DriverManager.getConnection(url,username,password); 
   pstmt = conn.prepareStatement("select Images.Image from Images where PicName=?"); 
   pstmt.setString(1,picName); //傳入要取的圖片的ID 
   pstmt.executeQuery(); 
   rs = pstmt.getResultSet();
   if(rs.next()) {
    Blob aBlob = rs.getBlob("Image");
    InputStream is1 = aBlob.getBinaryStream(1, aBlob.length());
    BufferedImage imag=ImageIO.read(is1);
    Image image = imag;
    ImageIcon icon =new ImageIcon(image);
    //lblImage.setIcon(icon); 
    return image;
   } 
  } 
  catch(Exception e) 
  { 
   System.out.println("[OutPutFile error : ]" + e.getMessage()); 
  } 
  finally 
  { 
   rs.close(); 
   pstmt.close(); 
   conn.close(); 
  }
  return null; 
 } 
}