package workspace;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Mark Robinson
 */
public class GUI extends JFrame {
	RPNCalc calc = new RPNCalc();
	JTextField textIn = new JTextField();
	JTextField textOut = new JTextField("0.0");

	private void initLayout() {
		JPanel panel = new JPanel(new BorderLayout());

		JButton addition = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton division = new JButton("/");
		JButton enter = new JButton("Enter");
		JButton clear = new JButton("Clear");

		addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOut.setText(Double.toString(calc.add()));
			}
		});

		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOut.setText(String.valueOf(calc.subtract()));
			}
		});

		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOut.setText(String.valueOf(calc.multiply()));
			}
		});

		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOut.setText(String.valueOf(calc.divide()));
			}
		});

		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calc.enter(Double.parseDouble(textIn.getText()));
					textIn.setText("");
				} catch (NumberFormatException ex) {
					textIn.setText("");
				}
			}
		});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.clear();
				textIn.setText("");
				textOut.setText("");
			}
		});

		textIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				textIn.setText("");
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(3, 6));
		JPanel buttonPanelUpper = new JPanel(new GridLayout(2, 1));

		buttonPanelUpper.add(textIn);
		buttonPanelUpper.add(textOut);

		buttonPanel.add(addition);
		buttonPanel.add(subtract);
		buttonPanel.add(multiply);
		buttonPanel.add(division);
		buttonPanel.add(enter);
		buttonPanel.add(clear);

		panel.add(buttonPanelUpper, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		textIn.setText("Input");
		textOut.setText("Output");

		this.add(panel);
		this.pack();
	}

	public GUI() {
		super("RPN Calculator");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();

		this.setBounds((dim.width * 10) / 100, (dim.height * 10) / 100,
				(dim.width * 20) / 100, (dim.height * 20) / 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		initLayout();
	}
}
