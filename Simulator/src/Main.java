import java.awt.Dimension;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Main {
	private static JTextField userText;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main();
	}
	
	Main(){
		JFrame frame = new JFrame("simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000,700));
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel title = new JLabel("Welcome to the simulator");
		title.setBounds(100,30,160,25);
        panel.add(title);
        
        JLabel enter = new JLabel("Type here:");
		enter.setBounds(600,80,160,25);
        panel.add(enter);
        
        userText = new JTextField(20);
        userText.setBounds(600,105,300,110);
        panel.add(userText);
        
        JButton button = new JButton("Enter");
        button.setBounds(700, 220, 80, 25);
        panel.add(button);
	}
	
	public static boolean writingChecker(JTextField statement) {
		if(statement != null) {
			return true;
		} else {
			return false;
		}
	}
}