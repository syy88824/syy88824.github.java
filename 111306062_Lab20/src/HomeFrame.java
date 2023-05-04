import java.awt.*;

import javax.swing.*;

public class HomeFrame extends JFrame {
	JLabel label = new JLabel();
	JPanel helloPanel;
	public HomeFrame(String userName) {
		this.setTitle("Home");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		label.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		helloPanel = new JPanel();
		helloPanel.add(label);
		helloPanel.setPreferredSize(new Dimension(500, 100));
		this.setLayout(new BorderLayout(20, 60));
		this.getContentPane().add(helloPanel, BorderLayout.CENTER);
		this.getContentPane().add(new JPanel(), BorderLayout.SOUTH);
		this.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		label.setText("Hello "+userName+"!");
	}
	public JPanel getPanel() {
		return helloPanel;
	}
}
