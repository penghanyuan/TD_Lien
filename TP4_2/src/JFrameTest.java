import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFrameTest extends JFrame {

	private JPanel myPane;
	private JTextField jt1;
	private JLabel jl1;
	private JButton jb1;
	private JTextArea ja1;

	public JFrameTest (String s){  
      super(s);  
      setSize(400,450);  
      setLocationRelativeTo(null);  
        
      myPane=new JPanel();  
      setContentPane(myPane);  
     // myPane.setBackground();  
  
      jl1=new JLabel("A");
      jt1 = new JTextField(20);
      
      jb1 = new JButton();
      ja1 = new JTextArea(5,20);
      ja1.setLineWrap(true);
      
      myPane.add(jl1);   
      myPane.add(jt1);
      myPane.add(jb1);
      myPane.add(new JScrollPane(ja1));
      jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = jt1.getText();
				jl1.setText(text);
				System.out.println(text);
				ja1.setText(text);
			}
		});
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setVisible(true);  
  }
	public void showImage(byte[] data){
		jl1.setIcon(new ImageIcon(data));
		
	}

}
