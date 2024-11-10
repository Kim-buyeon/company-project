package study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class App {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Hello");
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 10, 754, 369);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JCheckBox checkBox = new JCheckBox("Edit");
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setFont(new Font("굴림", Font.PLAIN, 20));
		checkBox.setBounds(122, 22, 183, 23);
		panel.add(checkBox);
		textField = new JTextField();
		textField.setEnabled(false);// textField에 아무것도 적을 수 없음
		textField.setBounds(121, 69, 517, 198);
		panel.add(textField);
		textField.setColumns(10);
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = checkBox.isSelected();
				textField.setEnabled(isChecked);
				// textField.setEnabled(checkbox.isSelected());
			}

		});

	}
}
