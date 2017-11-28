package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPageView extends JFrame {
	private JPanel myPane;
	private JLabel jl1;
	private JLabel jl2;
	private JButton jb1;
	private JButton jb2;

	public MainPageView(String s) {
		super(s);
		setSize(400, 450);
		setLocationRelativeTo(null);

		myPane = new JPanel();
		setContentPane(myPane);
		// myPane.setBackground();

		jl1 = new JLabel("Create Account               ");
		jl2 = new JLabel("Create Reservation           ");

		jb1 = new JButton("create     ");
		jb2 = new JButton("reserve    ");
		myPane.add(jl1);
		myPane.add(jl2);
		myPane.add(jb1);
		myPane.add(jb2);
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateUserView cv = new CreateUserView();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
