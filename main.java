import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class main extends JFrame {
	JFrame mainFrame	   = new JFrame();
	JPanel imagePanel	   = new JPanel();
	JPanel buttonPanel	   = new JPanel();
	JLabel databaseLabel   = new JLabel();
	JLabel searchLabel	   = new JLabel();
	JButton databaseButton = new JButton("從資料庫選擇圖片");
	JButton searchButton   = new JButton("讓問號貓貓幫你自己決定素材!");
	users u1;

	public main() throws MalformedURLException, IOException {
		setTitle("Select Your Material!");
		CreateLabel();
		CreateOther();
		CreateRandom();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(imagePanel, BorderLayout.CENTER);
		mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		mainFrame.setSize(410, 250);
		mainFrame.setVisible(true);

	}
	
	public void setUsers(users u) {
		this.u1 = u;
	}

//-----------------------------------------------------------------
	public void CreateLabel() throws MalformedURLException, IOException {
		// ------------------------------
		ImageIcon imageIcon2 = new ImageIcon(ImageIO.read(
				new URL("https://stickershop.line-scdn.net/stickershop/v1/product/10060443/LINEStorePC/main.png")));
		Image image2 = imageIcon2.getImage();
		Image newimg2 = image2.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		imageIcon2 = new ImageIcon(newimg2);
		databaseLabel = new JLabel(imageIcon2);
		// -----------------------------------------		
		ImageIcon imageIcon4 = new ImageIcon(
				ImageIO.read(new File("C:\\Users\\User\\108_2\\FinalProject\\img\\Cry_Cat.png")));
		Image image4 = imageIcon4.getImage();
		Image newimg4 = image4.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		imageIcon4 = new ImageIcon(newimg4);
		searchLabel = new JLabel(imageIcon4);
		// -----------------------------------------
		imagePanel.setLayout(new GridLayout(1, 2));		
		imagePanel.add(searchLabel);		
		imagePanel.add(databaseLabel);		
		buttonPanel.setLayout(new GridLayout(1,2));
	}



	// ----------------------------------------------------------
	public void CreateOther() {
		class Other implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
				MemeFrame f = new MemeFrame();
				f.setUsers(u1);}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		databaseButton.addActionListener(new Other());
		buttonPanel.add(databaseButton);
	}

	// ----------------------------------------------------------
	public void CreateRandom() {
		class Random implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					Frame4 f = new Frame4();
					f.setUsers(u1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		searchButton.addActionListener(new Random());
		buttonPanel.add(searchButton);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		main m1 = new main();
		// m1.create();
	}

}
