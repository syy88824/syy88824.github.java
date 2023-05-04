import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame {
	private User user = new User();
	private HomeFrame frame;
	private JTextField tfUserName, tfPassword;
	private JButton btnEnroll, btnLogin;
	private JPanel panel = (JPanel) this.getContentPane();

	public LoginFrame() {
		tfUserName = new JTextField(20);
		tfPassword = new JTextField(20);
		btnEnroll = new JButton("Enroll");
		btnLogin = new JButton("Login");
		this.setContentPane(panel);
		this.setSize(new Dimension(500,300));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createLayout();
		click();
	}

	private void createLayout() {
		JPanel uPanel = new JPanel();
		uPanel.add(new JLabel("Username:"));
		uPanel.add(tfUserName);
		uPanel.setPreferredSize(new Dimension(500, 40));
		JPanel pPanel = new JPanel();
		pPanel.add(new JLabel("Password:"));
		pPanel.add(tfPassword);
		pPanel.setPreferredSize(new Dimension(500, 40));
		JPanel bPanel = new JPanel();
		bPanel.add(btnEnroll);
		bPanel.add(btnLogin);
		bPanel.setPreferredSize(new Dimension(500, 40));
		JPanel allPannel = new JPanel();
		allPannel.add(uPanel);
		allPannel.add(pPanel);
		allPannel.add(bPanel);
		setLayout(new BorderLayout(20, 40));
		getContentPane().add(new JPanel(), BorderLayout.NORTH);
		getContentPane().add(allPannel, BorderLayout.CENTER);
		getContentPane().add(new JPanel(), BorderLayout.SOUTH);
		
	}
	public void click() {		
		btnEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = tfUserName.getText();
				String password = tfPassword.getText();
				try {
					user.add(userName, password);
					System.out.println("Enrolled successfully.");
				} catch (UserError e1) {
					// TODO Auto-generated catch block
						JFrame frame1 = new JFrame();
						JOptionPane.showMessageDialog(frame1, "UserError : "+e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (PasswordError e2) {
					// TODO Auto-generated catch block
					if(password.length()!=8) {
						JFrame frame2 = new JFrame();
						JOptionPane.showMessageDialog(frame2, "PasswordError : "+e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = tfUserName.getText();
				String password = tfPassword.getText();
				try {
					user.checkUserExist(userName);
					try {
						user.checkPassword(userName, password);						
						frame = new HomeFrame(userName);
						setContentPane(frame.getPanel());
						setVisible(true);
					} catch(PasswordError e4) {
						// TODO Auto-generated catch block
						JFrame frame4 = new JFrame();
						JOptionPane.showMessageDialog(frame4, "PasswordError : "+e4.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (UserError e3) {
					// TODO Auto-generated catch block
					JFrame frame3 = new JFrame();
					JOptionPane.showMessageDialog(frame3, "UserError : "+e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}			
		});
	}
}