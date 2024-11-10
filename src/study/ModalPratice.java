package study;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModalPratice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModalPratice window = new ModalPratice();
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
	public ModalPratice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 804, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 790, 479);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("My Modal Course");
		lblNewLabel.setFont(new Font("궁서체", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 33, 505, 111);
		panel.add(lblNewLabel);

		JButton button = new JButton("Open Modal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modal m = new Modal(frame, lblNewLabel);// frame과 Modal 사이 연결
				m.setVisible(true);
			}
		});
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		button.setBounds(112, 189, 511, 111);
		panel.add(button);

	}
}
