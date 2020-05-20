import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

public class Main implements ActionListener {
	static JFrame frame = new JFrame("simulator");
	private static JTextField userText;
	private static JTextArea text;
	static Scanner input = new Scanner(System.in);
	static JLabel words = new JLabel();
	static ActionListener statement;
	
	public static void main(String[] args) {
		new Main();
	}
	
	Main(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000,700));
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
	}
	
	public void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel title = new JLabel("Welcome to the simulator");
		title.setBounds(100,30,160,25);
        panel.add(title);
        
        JLabel enter = new JLabel("Type here:");
		enter.setBounds(600,80,160,25);
        panel.add(enter);
        
        text = new JTextArea(20,20);
        text.setBounds(600,105,300,110);
        panel.add(text);
        
        words.setBounds(100,200,300,20);
        panel.add(words);
        
        JButton button = new JButton("Enter");
        button.setBounds(700, 220, 80, 25);
        panel.add(button);
        button.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {} });
        button.addActionListener(this);
        
        panel.setBackground(Color.pink);
	}
	
	public static boolean writingChecker(JTextField statement) {
		if(statement != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		try{
		String writing = a.getActionCommand();
		if(writing.equals("Enter")) {  
            words.setText(text.getText()); 
        }
		}catch(Exception ex) {System.out.println(ex);}
	}
}