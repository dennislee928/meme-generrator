import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MemeFrame extends JFrame {
	private Meme meme;
	
	private ImageIcon img1;
	private JLabel label1;
	private ImageIcon img2;
	private JLabel label2;
 
	private JPanel uiPanel;
	private JPanel importPanel;
	private JPanel viewPanel;
 
	private JLabel importLabel;
	private JComboBox<String> importCombo;
	private JButton importButton;
 
	private JLabel exportLabel;
	private JTextField exportField;
	private JButton exportButton;
 
	private JLabel  fontStyleLabel;
	private JComboBox<String> styleCombo;
	private JLabel  fontColorLabel;
	private JComboBox<String> colorCombo;
	private JLabel  fontSizeLabel;
	private JTextField fontSizeField;
 
	private JRadioButton plainButton;
	private JRadioButton boldButton;
	private JRadioButton italicButton;
	private ButtonGroup group;
 
	private JLabel text;
	private JTextField textField;
 
	private JTextField x;
	private JTextField y;
	private JButton addText;
 
	private JButton viewButton;
	private JButton resetButton;
	private JButton shareButton;
 
	private users u;
 
	public MemeFrame() throws IOException{
		setSize(900, 300);
		setLayout(new BorderLayout());  
		createUI();  
  
		importPanel = new JPanel();
		importPanel.setSize(300, 300);
		importPanel.setBorder(new TitledBorder(new EtchedBorder(), "圖片"));
  
  //****************************************************
		try {
			img1 = new ImageIcon(blobtest.blobRead("White"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  //*****************************************************
  
		label1 = new JLabel(img1);
		importPanel.add(label1);
		add(importPanel, BorderLayout.CENTER);  
  
		viewPanel = new JPanel();
		viewPanel.setSize(300, 300);
		viewPanel.setBorder(new TitledBorder(new EtchedBorder(), "預覽"));
  
  //*******************************************************
		try {
			img2 = new ImageIcon(blobtest.blobRead("White"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  //*******************************************************
  
		label2 = new JLabel(img2);
		viewPanel.add(label2);
		add(viewPanel, BorderLayout.EAST);
  
		addBtnAction();
  
		setVisible(true);
		pack();
		setTitle("Test");
	}
 
 	public void setUsers(users u) {
 		this.u = u;
 }
 
 public void createUI() {
  importLabel = new JLabel("選擇圖片");
  importCombo = new JComboBox<String>();
  
  //*********************************************************************************
  try {
   Connection conn = SimpleDataSource.getConnection();
   PreparedStatement pstmt = conn.prepareStatement("SELECT PicName FROM Images");
   pstmt.executeQuery(); 
   ResultSet rs = pstmt.getResultSet();
   while(rs.next()) {
    String s = rs.getString("PicName");
    importCombo.addItem(s);
   }
   importButton = new JButton("匯入");
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  //*********************************************************************************

  
  exportLabel = new JLabel("匯出圖片");
  exportField = new JTextField(10);
  exportButton = new JButton("匯出");
  
  fontStyleLabel = new JLabel("文字風格");
  styleCombo = new JComboBox<String>();
  styleCombo.addItem("Arial Black");
  styleCombo.addItem("Berlin Sans FB");
  styleCombo.addItem("Bodoni MT");
  styleCombo.addItem("Comic Sans MS");
  styleCombo.addItem("Dialog");
  styleCombo.addItem("Elephant");
  styleCombo.addItem("Monospaced");
  styleCombo.addItem("Serif");
  styleCombo.addItem("Microsoft JhengHei");  
  styleCombo.addItem("Microsoft YaHei");
  
  fontColorLabel = new JLabel("文字顏色");
  colorCombo = new JComboBox<String>();
  colorCombo.addItem("Black");
  colorCombo.addItem("Blue");
  colorCombo.addItem("Cyan");
  colorCombo.addItem("Green");
  colorCombo.addItem("Dark Gray");
  colorCombo.addItem("Gray");
  colorCombo.addItem("Light Gray");
  colorCombo.addItem("Magenta");
  colorCombo.addItem("Orange");
  colorCombo.addItem("Pink");
  colorCombo.addItem("Red");
  colorCombo.addItem("White");
  colorCombo.addItem("Yellow");
  
  fontSizeLabel = new JLabel("文字大小");
  fontSizeField = new JTextField(10);
  
  plainButton = new JRadioButton("正常");
  boldButton = new JRadioButton("粗體");
  italicButton = new JRadioButton("斜體");
  group = new ButtonGroup();
  group.add(plainButton);
  group.add(boldButton);
  group.add(italicButton);
  
  text = new JLabel("文字內容");
  textField = new JTextField(10);
  
  x = new JTextField("x-軸");
  y = new JTextField("y-軸");
  addText = new JButton("加入文字");
  
  viewButton  = new JButton("預覽");
  resetButton = new JButton("重設");
  shareButton = new JButton("分享");
  
  uiPanel = new JPanel();
  uiPanel.setSize(300, 300);
  uiPanel.setLayout(new GridLayout(9, 3));
  uiPanel.add(importLabel);
  uiPanel.add(importCombo);
  uiPanel.add(importButton);
  
  uiPanel.add(exportLabel);
  uiPanel.add(exportField);
  uiPanel.add(exportButton);
  
  uiPanel.add(fontStyleLabel);
  uiPanel.add(styleCombo);
  uiPanel.add(new JLabel(""));
  
  uiPanel.add(fontColorLabel);
  uiPanel.add(colorCombo);
  uiPanel.add(new JLabel(""));
  
  uiPanel.add(fontSizeLabel);
  uiPanel.add(fontSizeField);
  uiPanel.add(new JLabel(""));
  
  uiPanel.add(plainButton);
  uiPanel.add(boldButton);
  uiPanel.add(italicButton);
  
  uiPanel.add(text);
  uiPanel.add(textField);
  uiPanel.add(new JLabel(""));
  
  uiPanel.add(x);
  uiPanel.add(y);
  uiPanel.add(addText);
  
  uiPanel.add(viewButton);
  uiPanel.add(resetButton);
  uiPanel.add(shareButton);
  
  uiPanel.setBorder(new TitledBorder(new EtchedBorder(), "編輯"));
  add(uiPanel, BorderLayout.WEST);
 }
 
 public void addBtnAction() {    
	 class ImportListener implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 try {
				 meme = new Meme(importCombo.getSelectedItem().toString());
    
				 //*********************************************************************************
				 img1 = new ImageIcon(blobtest.blobRead(importCombo.getSelectedItem().toString()));
				 //*********************************************************************************
    
				 label1.setIcon(img1);}
			 catch(Exception e) {
				 e.getMessage();}    
		 }
	 }
	 importButton.addActionListener(new ImportListener());
  
	 class ExportListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 try {
				 meme.exportImage(exportField.getText());
				 //JOptionPane.showMessageDialog(null, "已成匯出至下載資料夾");
			 }
			 catch(IOException e) {
				 e.getMessage();}
		 }
	 }
	 exportButton.addActionListener(new ExportListener());
    
	 class ViewListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 img2 = new ImageIcon(meme.getImage());
			 label2.setIcon(img2);}
	 }
	 viewButton.addActionListener(new ViewListener());
  
	 class TextListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 if(plainButton.isSelected())
				 meme.setFont(styleCombo.getSelectedItem().toString(),"Plain"  ,colorCombo.getSelectedItem().toString());
			 if(boldButton.isSelected())
				 meme.setFont(styleCombo.getSelectedItem().toString(),"Bold"   ,colorCombo.getSelectedItem().toString());
			 if(italicButton.isSelected())
				 meme.setFont(styleCombo.getSelectedItem().toString(),"Italic" ,colorCombo.getSelectedItem().toString());
			 meme.setFontSize(Integer.parseInt(fontSizeField.getText()));
			 meme.addText(textField.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
		 }
	 }
	 addText.addActionListener(new TextListener());
  
	 class ResetListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 try {
				 meme = new Meme(importCombo.getSelectedItem().toString());
				 img2 = new ImageIcon(meme.getImage());
				 label2.setIcon(img2);}
			 catch(IOException e) {
				 e.getMessage();}
		 }
	 }
	 resetButton.addActionListener(new ResetListener());
  
	 class ShareListener implements ActionListener {
		 public void actionPerformed(ActionEvent event) {
			 meme.shareImage("http://facebook.com/");
		 }
	 }
	 shareButton.addActionListener(new ShareListener());
 	}
}