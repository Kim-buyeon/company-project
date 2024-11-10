package study;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtons {//그룹 생성해서 그 중 하나 선택
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JRadioButton korBtn = new JRadioButton("Korea");
		JRadioButton engBtn = new JRadioButton("English");
		JRadioButton chiBtn = new JRadioButton("Chinese");
		ButtonGroup group = new ButtonGroup();
		korBtn.setActionCommand("kor");//ui상에서 볼 때 이 값으로 보이게 해줌 
		engBtn.setActionCommand("end");
		chiBtn.setActionCommand("chi");
		
		group.add(korBtn);
		group.add(engBtn);
		group.add(chiBtn);
		Font font = new Font("Arial",Font.BOLD,24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chiBtn.setFont(font);
		engBtn.setSelected(true);//자동으로 선택되어져 있음.
		korBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
		});
		engBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
		});
		chiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
		});
		panel.add(korBtn);//button panel에 일일이 하나씩 추가해주어야함 swing해서 지원하는 것이 아니기 떄문
		panel.add(engBtn);
		panel.add(chiBtn);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
