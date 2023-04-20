import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
	public Frame(String title) {
		super(title);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700, 800);
		JPanel contain = new JPanel();
		this.setContentPane(contain);
		//contain.set
		JButton butt = new JButton("click me");
		contain.add(butt);
		JButton okbutt = new JButton("OK");
		this.getRootPane().setDefaultButton(okbutt);
		contain.add(okbutt);
		JLabel cra = new JLabel("crayon");
		contain.add(cra);
		cra.setFont(getFont());
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
		String timeStr = stf.format(new Date());
		okbutt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cra.setText("OK");
			}			
		});
		butt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contain.add(new JLabel(timeStr));
				cra.setText("Clicked");
			}			
		});
		this.setVisible(true);
	}
}
