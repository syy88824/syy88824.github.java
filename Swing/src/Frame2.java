import java.awt.*;
import javax.swing.*;

public class Frame2 extends JFrame {
	public Frame2(String name) {
		this.setSize(new Dimension(500,700));
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("this is default color"), BorderLayout.CENTER);
	//Set up a button at south
		JButton south = new JButton("South");
		panel.add(south, BorderLayout.SOUTH);
		south.setBackground(new Color(255,153,204));
		south.setPreferredSize(new Dimension(0,150));
	//Set up a button at north
		JButton north = new JButton("North");
		panel.add(north, BorderLayout.NORTH);
		north.setBackground(new Color(204,153,255));
		north.setPreferredSize(new Dimension(0,150));
		north.setFont(new Font("Comic Sans MS",Font.BOLD + Font.ITALIC,30));
		north.setForeground(Color.white);
	//Set up a button at west
		JButton west = new JButton("west");
		panel.add(west, BorderLayout.WEST);
		west.setBackground(new Color(204,255,153));
		west.setPreferredSize(new Dimension(150,0));
	//Set up a button at east
		JButton east = new JButton("east");
		panel.add(east, BorderLayout.EAST);
		east.setBackground(new Color(153,204,255));
		east.setPreferredSize(new Dimension(150,0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
