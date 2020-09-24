import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;

public class Meme {
 private File importFile;
 private File exportFile;
 private BufferedImage tempImage;
 private Font font;
 private int fontSize;
 private Graphics graphic;
 private String imageLocation;
 
 public Meme(String image) throws IOException{
  this.imageLocation = "C:\\eclipse-file\\FinalProject-v2\\img\\" + image + ".png";
  this.importFile = new File(imageLocation);
  tempImage = ImageIO.read(importFile);
  tempImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
  graphic = tempImage.getGraphics();
  this.fontSize = 30;
 }
 
 public String getImageLocation() {
  return this.imageLocation;
 }
 
 public Image getImage() {
  return this.tempImage;
 }
 
 public void setFontSize(int fontSize) {
  this.fontSize = fontSize;
 } 
 
 public void exportImage(String fileName) throws IOException{
  graphic.dispose();
  
  //***************************************************************
  exportFile = new File(SaveFile.save(fileName)+".png");
  //***************************************************************
  
  ImageIO.write(tempImage, "png", exportFile);
 } 
 
 public void addText(String text, int x, int y) {
  graphic.drawString(text, x, y);
 } 
 
 public void setFont(String fontStyle, String fontChange, String fontColor) {
  switch(fontChange) {
  case "Plain"  : font = new Font(fontStyle, 0, fontSize);break;
  case "Bold"   : font = new Font(fontStyle, 1, fontSize);break;
  case "Italic" : font = new Font(fontStyle, 2, fontSize);break;
  }
  graphic.setFont(font);
  switch(fontColor) {
  case "Blue"       : graphic.setColor(Color.BLUE);    break;
  case "Red"      : graphic.setColor(Color.RED);     break;
  case "Green"    : graphic.setColor(Color.GREEN);   break;
  case "Yellow"   : graphic.setColor(Color.YELLOW);  break;
  case "Gray"     : graphic.setColor(Color.GRAY);    break;
  case "Pink"     : graphic.setColor(Color.PINK);    break;
  case "Black"    : graphic.setColor(Color.BLACK);   break;
  case "White"    : graphic.setColor(Color.WHITE);   break;
  case "Orange"   : graphic.setColor(Color.ORANGE);  break;
  case "Cyan"     : graphic.setColor(Color.CYAN);    break;
  case "Magenta"   : graphic.setColor(Color.MAGENTA);  break;
  case "Light Gray" : graphic.setColor(Color.LIGHT_GRAY); break;
  case "Dark Gray"  : graphic.setColor(Color.DARK_GRAY);  break;
  }
 }
 
 public void shareImage(String url) {
  try {
   URI ttt = URI.create(url);
   Desktop dp = Desktop.getDesktop();
   if(dp.isSupported(Desktop.Action.BROWSE))
    dp.browse(ttt);
  }
  catch(NullPointerException e) {
   e.printStackTrace();
  }
  catch(IOException e) {
   e.printStackTrace();
  } 
 } 
}