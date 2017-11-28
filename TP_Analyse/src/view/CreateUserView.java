package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateUserView extends JFrame{
	private JPanel myPane;
	public CreateUserView(){
		super();
		setSize(400, 450);
		setLocationRelativeTo(null);

		myPane = new JPanel();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
