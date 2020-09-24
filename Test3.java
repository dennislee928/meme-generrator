import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Test3 {

	public JFrame CreatePreview() throws IOException {
		JFrame f = new JFrame();
		f.setSize(1000, 1000);
		JPanel p = new JPanel();

		

		JButton btn = new JButton();
		btn.setText("Submit");

		Font myFont = new Font("Serif", Font.BOLD, 25);
		Font myFont2 = new Font("Serif", Font.BOLD, 50);
		Font myFont3 = new Font("Serif", Font.BOLD, 100);

		ButtonGroup group = new ButtonGroup();
		

		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		b1.setText("小");
		b2.setText("中");
		b3.setText("大");

		
		JLabel l = new JLabel();
		//l.setText("安安");
		
		JLabel labelPic2;
		
		
		// ---------------------------------------------------
		class SetFontSizeSmall implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = null;
				try {
					image = ImageIO.read(this.getClass().getResource("/cat.png"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Graphics g = image.getGraphics();
				
				
				
				l.setFont(myFont);
				g.setFont( myFont ); 
				g.drawString("安安", 100, 100);
				
				l.paintComponents(g);
				try {
					ImageIO.write(image, "png", new File("test.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ImageIcon photo2 = new ImageIcon("test.png");
				JLabel labelPic2 = new JLabel(photo2);
				p.add(l);
			//	JFrame f2=new JFrame();
				//f2.setSize(200, 200);
				//f2.add(labelPic2);
				//f2.setVisible(true);
			}
		}

		class SetFontSizeMedium implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = null;
				
				try {
					image = ImageIO.read(this.getClass().getResource("/cat.png"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Graphics g = image.getGraphics();
				JRadioButton btn1 = new JRadioButton();
				l.setFont(myFont2);
				g.setFont( myFont2 );
				l.paintComponents(g);
				p.add(l);
				
				
				
				try {
					ImageIO.write(image, "png", new File("test.png"));
					ImageIcon photo2 = new ImageIcon("test.png");
					JLabel labelPic2 = new JLabel(photo2);
					p.add(l);
					//JFrame f2=new JFrame();
					//f2.add(labelPic2);
					//f2.setSize(200, 200);
				//	f2.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}

		class SetFontSizeBig implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = null;
				try {
					image = ImageIO.read(this.getClass().getResource("/cat.png"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Graphics g = image.getGraphics();
				JRadioButton btn1 = new JRadioButton();
				l.setFont(myFont3);
				g.setFont( myFont ); 
				g.drawString("安安", 100, 100);
				l.paintComponents(g);
				try {
					ImageIO.write(image, "png", new File("test.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ImageIcon photo2 = new ImageIcon("test.png");
				JLabel labelPic2 = new JLabel(photo2);
				p.add(l);
			//	JFrame f2=new JFrame();
				//f2.setSize(200, 200);
				//f2.add(labelPic2);
				
			//	f2.setVisible(true);
			}
		}

		b1.addActionListener(new SetFontSizeSmall());
		b2.addActionListener(new SetFontSizeMedium());
		b3.addActionListener(new SetFontSizeBig());

		// ---------------------------------------------------
		/*
		 * class SetFontSize implements ActionListener { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * 
		 * if (btn1.isSelected()) { g.setFont( myFont ); l.setFont(myFont);
		 * 
		 * } else if (btn2.isSelected()) { g.setFont( myFont2 ); l.setFont(myFont); }
		 * else if (btn3.isSelected()) { g.setFont( myFont3 ); l.setFont(myFont);
		 * 
		 * } g.drawString("Hello World!", 100, 100); g.dispose();
		 * 
		 * } }
		 */
		// btn.addActionListener(new SetFontSize());

		p.setLayout(new GridLayout(3, 3));
		p.add(l);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		// p.add(btn);

		f.add(p);
		f.setVisible(true);
		return f;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test3 t = new Test3();
		t.CreatePreview();

	}
}