package study;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Modal extends JDialog{
	public Modal(Window parent,JLabel label) {
		super(parent,"Modal Practice",ModalityType.APPLICATION_MODAL);
		setSize(400,260);
		setLayout(null);
		JLabel lb = new JLabel("Enter Text");
		lb.setFont(new Font("Tahoma",Font.PLAIN,25));
		lb.setBounds(100,60,200,150); //x,y,가로,세로
		JTextField field = new JTextField(10);
		field.setBounds(100,80,200,30);
		JButton btn = new JButton("change?");
		btn.setBounds(100,130,200,400);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(field.getText());//label에 있는 Text 설정
				dispose();//Modal 종료
			}
			
		});
		add(field);
		add(btn);
		add(lb);
	}
}
