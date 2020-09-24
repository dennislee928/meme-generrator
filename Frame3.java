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

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame3 {

	ImageIcon photo1 = new ImageIcon(
			ImageIO.read(new URL("https://api.time.com/wp-content/uploads/2020/01/smudge-the-cat-interview.jpg")));

	JLabel labelPic1 = new JLabel(photo1);

	JLabel title = new JLabel();

	JTextField t22 = new JTextField();
	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	JTextField fileName = new JTextField();
	//
	
	
	JRadioButton jrb = new JRadioButton("黑色");
	JRadioButton jrb2 = new JRadioButton("白色");
	JRadioButton jrb3 = new JRadioButton("紅色");
	JRadioButton jrb4 = new JRadioButton("藍色");
	JRadioButton jr5 = new JRadioButton("綠色");

	JTextField field1 = new JTextField();
	JTextField field2 = new JTextField();
	JTextField field3 = new JTextField();
	JTextField field4 = new JTextField();

	JButton btn = new JButton("製作!");
	// JTextArea area=new JTextArea();

	JLabel l1 = new JLabel("請輸入大小><:");
	JLabel l2 = new JLabel("請輸入想添加的文字><:");
	JLabel l3 = new JLabel("請輸入文字x座標:");
	JLabel l4 = new JLabel("請輸入文字y座標:");

	JTextArea area1 = new JTextArea();
	JPanel panel3 = new JPanel();
	// ------------------------------------
	private users u1;

	public Frame3() throws IOException {
		CreateTextFieldAndLabel();
		CreateRadioButton();
		CreateFrame();
		SetPic();

	}
	
	public void setUsers(users u) {
		this.u1 = u;
	}

	public JFrame CreateFrame() {
		title.setText("請於右側輸入想添加的文字!!><");
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());
		panel.add(area1, BorderLayout.SOUTH);
		panel.add(btn, BorderLayout.CENTER);
		f.setSize(1000, 1000);
		p2.setSize(100, 20);
		// p1.add(jr5);
		f.setLayout(new GridLayout(4, 1));
		f.add(p1);
		f.add(p2);
		f.add(panel3);

		f.add(panel);
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

	};//

	public void CreateTextFieldAndLabel() throws IOException {
		
		JPanel p1=new JPanel();
		JPanel px=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		
		
		p1.setLayout(new GridLayout(1,2));
		px.setLayout(new GridLayout(1,2));
		p3.setLayout(new GridLayout(1,2));
		p4.setLayout(new GridLayout(1,2));
		p5.setLayout(new GridLayout(1,2));
		
		
		
		
		p2.setLayout(new GridLayout(4, 0));
JLabel l=new JLabel("請輸入檔名:");
p1.add(l);		
p1.add(fileName);
		
		px.add(l1);
		px.add(field1);
		p3.add(l2);
		p3.add(field2);
		p4.add(l3);
		p4.add(field3);
		p5.add(l4);
		p5.add(field4);
		
		p2.add(p1);
		p2.add(px);
		p2.add(p3);
		p2.add(p4);
		p2.add(p5);

		ImageIcon imageIcon = new ImageIcon(
				ImageIO.read(new URL("https://api.time.com/wp-content/uploads/2020/01/smudge-the-cat-interview.jpg")));

		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg);

		JLabel labelPic1 = new JLabel(imageIcon);
		panel3.add(labelPic1);
		panel3.setSize(500, 500);

	}

	public void SetPic() {

		

		class setpic1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.valueOf(field1.getText());
				
				String strFile= fileName.getText();
				
				
				String str = field2.getText();
				int numX = Integer.valueOf(field3.getText());
				int numY = Integer.valueOf(field4.getText());
				//
				System.out.println(num1);
				area1.append("大小"+num1+"\n");
				JFrame f = new JFrame();
				f.setSize(500, 500);
				BufferedImage image = null;
				System.out.println("這裡");
				try {
					image = ImageIO.read(
							new URL("https://api.time.com/wp-content/uploads/2020/01/smudge-the-cat-interview.jpg"));
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
					area1.append("顏色:黑"+"\n");
//
				} else if (jrb2.isSelected() == true) {
					g.setColor(Color.WHITE);
					area1.append("顏色:白"+"\n");

				} else if (jrb3.isSelected() == true) {
					g.setColor(Color.RED);
					area1.append("顏色:紅"+"\n");
				} else if (jrb3.isSelected() == true) {
					g.setColor(Color.blue);
					area1.append("顏色:藍");
				} else if (jrb.isSelected() == true) {
					g.setColor(Color.green);
					area1.append("顏色:綠"+"\n");
				}
				area1.append("x位置:"+numX+":y位置:"+numY+"\n");
				area1.append(strFile+".png已經儲存!"+"\n");

				g.drawString(str, numX, numY);
//
				

				try {
					ImageIO.write(image, "png", new File(strFile+".png"));
					ImageIcon photo2 = new ImageIcon(strFile+".png");
					
					Image image1 = photo2.getImage();
					Image newimg = image1.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
					
					photo2 = new ImageIcon(newimg);
					
					g.dispose();
					JLabel labelPic2 = new JLabel(photo2);
					JPanel p = new JPanel();
					p.add(labelPic2);
					f.add(p);
					f.setTitle("MEME");
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}btn.addActionListener(new setpic1());

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Frame3 f = new Frame3();
		// f.Create();
	}

}
