import javax.swing.JFrame;
import java.io.IOException;

public class FinalProjectViewer {
	private static users u1;
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		LoginFrame login = new LoginFrame();
		u1 = login.getUsers();
	}

}
