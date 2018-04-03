package tn.iit.moving_car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class SendCarNumber extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textF;
	private final Action action = new SwingAction();
	private JTextPane textPane;
	private JTextPane txtpnMax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendCarNumber frame = new SendCarNumber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public SendCarNumber() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn = new JButton("start");
		btn.setToolTipText("");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn.setAction(action);
		btn.setBounds(167, 153, 89, 23);
		contentPane.add(btn);

		textF = new JTextField();
		textF.setBounds(167, 108, 86, 20);
		textF.setText("5");
		contentPane.add(textF);
		textF.setColumns(10);

		textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setBounds(288, 108, 65, 20);
		contentPane.add(textPane);

		txtpnMax = new JTextPane();
		txtpnMax.setText("car number max 5 :");
		txtpnMax.setBackground(SystemColor.menu);
		txtpnMax.setBounds(153, 77, 137, 20);
		contentPane.add(txtpnMax);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String n = textF.getText();
			if (n.matches("[0-9]+") /* && Integer.valueOf(n)<6 */ ) {
				new Pan(n);
			} else {
				textPane.setText("error");
				textPane.setBackground(new Color(255, 0, 0));
			}

		}
	}
}
