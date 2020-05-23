package Display;

//user interaction
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//java swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display implements ActionListener {

	private JFrame frame;
	private Canvas canvas;
	private static JTextArea text;
	static JLabel words = new JLabel();
	
	private String title;
	private int length, height;
	
	public Display(String t, int l, int h) {
		title = t;
		length = l;
		height = h;
		create();
	}
	
	private void create() {
		frame = new JFrame(title);
		frame.setSize(length, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		/*JPanel panel = new JPanel();
		panel.setSize(500, 400);
        frame.add(panel);
        addComponents(panel);*/
		
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(length, height));
		canvas.setMinimumSize(new Dimension(length, height));
		canvas.setMaximumSize(new Dimension(length, height));
		
		frame.add(canvas);
		//frame.pack(); if ok
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addComponents(JPanel panel) {
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

	public void actionPerformed(ActionEvent a) {
		try{
		String writing = a.getActionCommand();
		if(writing.equals("Enter")) {  
            words.setText(text.getText()); 
        }
		}catch(Exception ex) {System.out.println(ex);}
	}
}
