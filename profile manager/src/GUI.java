import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JOptionPane{
	//Use these Strings to log on
	private String logOnUsername = "Java271";
	
	JTextField usernametxt = new JTextField();
	
    public GUI() {
    	
    	JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(800, 200));
		frame.setSize(new Dimension(400, 150));
		frame.setTitle("Login Screen");
		frame.setLayout(new BorderLayout());

		//labels in JPanel
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new GridLayout(2, 1));
		JLabel username = new JLabel("Username");
		JLabel password = new JLabel("Password");
		
		//add labels to JPanel
		panelLabel.add(username);
		panelLabel.add(password);
		
		//static text fields in GUI
		JPanel panelTextbox = new JPanel();
		panelTextbox.setLayout(new GridLayout(2, 1));

		panelTextbox.add(usernametxt);
		
		//layout for JPanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		
		//log on button
		JButton logOn = new JButton("Log On");
		logOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				logOn();
			}

			private void logOn() {
				if(usernametxt.getText().equals(logOnUsername)) {
					showMessageDialog(null, "Welcome!!! Both username and password are matched");
				}else {
					showMessageDialog(null, "User name or password is incorrect");
				}
			}
		});
		
		//register button
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//empty per instructions
			}
		});
		
		//cancel button
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cancel();
			}

			private void cancel() {
				showMessageDialog(null, "Goodbye!");
				frame.dispose();
			}
		});
		
		//clear button
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				clear();
			}

			private void clear() {
				usernametxt.setText("");
			}
		});
		
		//add buttons to JPanel
		panel.add(logOn);
		panel.add(register);
		panel.add(cancel);
		panel.add(clear);
		
		//directional layout
		frame.add(panel, BorderLayout.SOUTH);
		frame.add(panelLabel, BorderLayout.WEST);
		frame.add(panelTextbox, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
