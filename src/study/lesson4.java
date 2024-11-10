package study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class lesson4 {

	private JFrame frame;
	private JTextField name;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lesson4 window = new lesson4();
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
	public lesson4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/JAVA_LAB/Swing1/welcome1.jpg").getImage());
		frame.setSize(691, 527);
		frame.getContentPane().add(welcomePanel);
		frame.getContentPane().setLayout(null);
		String data[][] = customer.getCustomers();
		String[] headers = new String[] { "Name", "Phone", "Gender", "Age", "Note" };

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 677, 467);
		tablePanel.setVisible(false);
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);// 2차원 배열의 데이터,헤더가 되는 String 1차 배열
		table.setRowHeight(15);
		table.setFont(new Font("Sanserif", Font.BOLD, 10));
		table.setAlignmentX(0);
		table.setSize(800, 400);
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(183, 53, 482, 404);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);

		search = new JTextField();
		search.setBounds(12, 10, 653, 33);
		search.setFont(new Font("굴림", Font.PLAIN, 17));
		tablePanel.add(search);
		search.setColumns(10);
		JPanel mainpanel = new JPanel();
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mainpanel.setVisible(true);
			}

		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\bu200\\OneDrive\\사진\\카메라 앨범\\11.jpg"));
		btnNewButton_2.setBounds(25, 76, 132, 196);
		tablePanel.add(btnNewButton_2);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {// 키보드 누르고 난 후 키가 적용할 때
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());// 없는 행인 경우 테이블 정렬
				table.setRowSorter(trs);// JTable에 RowSorter 객체를 설정하여 테이블의 행들을 정렬할 수 있게 만드는 구문
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});// 키 변동 값이 있을 경우 작동

		TableColumnModel columnModels = table.getColumnModel();// 열 간격 조정

		mainpanel.setBackground(new Color(240, 240, 240));
		mainpanel.setBounds(0, 0, 677, 490);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		mainpanel.setVisible(true);

		JLabel lblNewLabel = new JLabel("Welcome this is Main Panel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(97, 20, 495, 72);
		mainpanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 90, 150, 57);
		mainpanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(12, 158, 150, 57);
		mainpanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(12, 238, 150, 57);
		mainpanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Phone");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(348, 90, 150, 57);
		mainpanel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Birthday");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(358, 158, 150, 57);
		mainpanel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Note");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(358, 238, 150, 57);
		mainpanel.add(lblNewLabel_1_5);
		name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 16));
		name.setBounds(160, 91, 176, 57);
		mainpanel.add(name);
		name.setColumns(10);

		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(501, 91, 176, 57);
		mainpanel.add(phone);

		age = new JTextField();
		age.setFont(new Font("굴림", Font.PLAIN, 16));
		age.setColumns(10);
		age.setBounds(160, 157, 176, 57);
		mainpanel.add(age);

		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.PLAIN, 16));
		birthday.setColumns(10);
		birthday.setBounds(501, 158, 176, 57);
		mainpanel.add(birthday);

		JComboBox gender = new JComboBox(new String[] { "male", "female" });
		gender.setFont(new Font("굴림", Font.PLAIN, 18));
		gender.setBounds(174, 232, 172, 63);
		mainpanel.add(gender);

		JTextArea note = new JTextArea();
		note.setBounds(501, 225, 164, 231);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));// 테두리 지정
		mainpanel.add(note);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				// customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved sucessfully");
				mainpanel.setVisible(false);
			}

		});
		btnNewButton.setBounds(249, 352, 226, 72);
		mainpanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // 경계선 배경과 같게해줌으로써 거슬리는 경계선 안 보이게 하기
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainpanel.setVisible(false);
				tablePanel.setVisible(true);
			}

		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\bu200\\OneDrive\\사진\\welcome.jpg"));
		btnNewButton_1.setBounds(20, 352, 186, 101);
		mainpanel.add(btnNewButton_1);
		columnModels.getColumn(0).setPreferredWidth(100);// 첫 번쨰 열 간격 조정
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setFont(new Font("Lato", Font.BOLD, 8));
		lblLogIn.setBounds(10, 10, 10, 10);
		welcomePanel.add(lblLogIn);
		JTextField Id = new JTextField();
		Id.setFont(new Font("Lato", Font.PLAIN, 5));
		Id.setToolTipText("Enter ID");
		Id.setBounds(6, 6, 6, 6);
		welcomePanel.add(Id);
		JPasswordField password = new JPasswordField();
		password.setBounds(6, 6, 6, 6);
		welcomePanel.add(password);
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Lato", Font.BOLD, 5));
		lblId.setBounds(5, 5, 5, 5);
		welcomePanel.add(lblId);
		JLabel lblps = new JLabel("PS:");
		lblps.setFont(new Font("Lato", Font.BOLD, 5));
		lblps.setBounds(5, 5, 5, 5);
		welcomePanel.add(lblps);
		JButton btnLongIn = new JButton("");
		btnLongIn.setIcon(new ImageIcon("C:/JAVA_LAB/Swing1/welcome1.jpg"));
		btnLongIn.setPressedIcon(new ImageIcon("C:/JAVA_LAB/Swing1/welcome.jpg"));
		// 버튼 눌렸을 때 이미지 변화
		btnLongIn.setBounds(4, 4, 4, 4);
		btnLongIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Welcome Danny");
					welcomePanel.setVisible(false);// 로그인 화면 안보이게 함
					mainpanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "you failed to log in");
				}
			}

		});
		welcomePanel.add(btnLongIn);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JMenuBar menuBar() {// 메뉴 보여주게 해줌
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		bar.add(fileMenu);
		bar.add(aboutMenu);
		JMenuItem openFIle = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFIle);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return bar;
	}

	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel() {
			// 기본 생성자
		}

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}

		public int getWidth() {
			return img.getWidth(null);
		}

		public int getHeight() {
			return img.getHeight(null);
		}

		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, null);
		}
	}
}
