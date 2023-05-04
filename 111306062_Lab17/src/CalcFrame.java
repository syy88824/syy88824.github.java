import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CalcFrame extends JFrame {
	private JButton btnEqual;
	private JTextField textFieldA, textFieldB;
	private JRadioButton rbtnAdd, rbtnSub, rbtnMul, rbtnDiv;
	private JTextArea outputArea;
	private ButtonGroup group = new ButtonGroup();

//constructor
	public CalcFrame() {
		outputArea = new JTextArea(8, 12);
		outputArea.setEditable(false);
		createTextField();
		createButton();
		createRbtn();
		createLayout();
		setSize(600, 200);
	}

	private void createTextField() {
		textFieldA = new JTextField(10);
		textFieldB = new JTextField(10);
	}
	
	private void createRbtn() {
		rbtnAdd = new JRadioButton("+");	
		rbtnSub = new JRadioButton("-");
		rbtnMul = new JRadioButton("*");
		rbtnDiv = new JRadioButton("/");	
		group.add(rbtnAdd);
		group.add(rbtnSub);
		group.add(rbtnMul);
		group.add(rbtnDiv);
	}

	private void createButton() {
		btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ope = null;
				if (rbtnAdd.isSelected()) {
					ope = "+";
				}else if(rbtnSub.isSelected()) {
					ope = "-";
				}else if(rbtnMul.isSelected()) {
					ope = "*";
				}else if(rbtnDiv.isSelected()) {
					ope = "/";
				}
				outputArea.append(getResult(Double.parseDouble(textFieldA.getText()),ope,Double.parseDouble(textFieldB.getText())));				
			}
		});
	}

	private String getResult(double a, String op, double b) {
		String result = null;
		switch (op) {
		case "+":
			result = a+op+b+"="+String.format("%.2f",a+b)+"\n";
			break;
		case "-":
			result = a+op+b+"="+String.format("%.2f",a-b)+"\n";
			break;
		case "*":
			result = a+op+b+"="+String.format("%.2f",a*b)+"\n";
			break;
		case "/":
			result = a+op+b+"="+String.format("%.2f",a/b)+"\n";
			break;
		}
		return result;
	}

	private void createLayout() {
		JPanel flow_panel = new JPanel();
		JPanel rbtn_panel = new JPanel(new GridLayout(4, 1));
		rbtn_panel.add(this.rbtnAdd);
		rbtn_panel.add(this.rbtnSub);
		rbtn_panel.add(this.rbtnMul);
		rbtn_panel.add(this.rbtnDiv);
		flow_panel.add(this.textFieldA);
		flow_panel.add(rbtn_panel);
		flow_panel.add(this.textFieldB);
		flow_panel.add(this.btnEqual);
		flow_panel.add(new JScrollPane(outputArea));
		add(flow_panel);
	}
}