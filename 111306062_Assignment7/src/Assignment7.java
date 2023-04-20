import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Assignment7 {
	static JFrame f = new JFrame("Frame");
	static OXGameManager manager = new OXGameManager();
	static JButton[] btns = new JButton[9];
	static JLabel score = new JLabel(String.format("O: %d ; X: %d", manager.getScoreO(),manager.getScoreX()));
	static JButton reStart = new JButton("ReStart");
	static JButton finish = new JButton("Finish");

	public static void main(String[] args) {
		f.setVisible(true);
		f.setSize(750,900);
		f.getContentPane().setLayout(new GridLayout(4,3));
		score.setFont(new Font("Arial", Font.PLAIN, 40));
		reStart.setFont(new Font("Arial", Font.PLAIN, 40));
		finish.setFont(new Font("Arial", Font.PLAIN, 40));
		reStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				manager.initialize();
				for (int i = 0; i < 9; i++) {
					btns[i].setEnabled(true);
					btns[i].setText(Integer.toString(i));
				}				
			}			
		});
		class Finish implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}			
		}
		finish.addActionListener(new Finish());
		
		for (int i = 0; i < 9; i++) {
			JButton btn = new JButton();
			int index = i;
			btn.setText(Integer.toString(i));
			btn.setFont(new Font("Arial", Font.PLAIN, 50));
// Implement the checkerboard button //
			btns[i] = btn;			
			btn.addActionListener((event)->{
				btn.setText(manager.play(index));
				manager.checkWin();
				btn.setEnabled(false);
				score.setText(String.format("O: %d ; X: %d", manager.getScoreO(),manager.getScoreX()));
				if (manager.finish()) {
					for (int j = 0; j < 9; j++) {
						btns[j].setEnabled(false);
					}
				}
			});	
		}
		f.add(score);
		f.add(reStart);
		f.add(finish);
		for (int i = 0; i < 9; i++) {
			f.add(btns[i]);
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
