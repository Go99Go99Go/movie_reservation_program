package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.java.util.Util_Calendar;
import com.java.util.Util_UI;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.DateModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class SelectHeadCountPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectHeadCountPage frame = new SelectHeadCountPage();
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
	public SelectHeadCountPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Color sky = new Color(80, 188, 223); // 하늘색 RGB

		JLabel lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(300, 17, 160, 30);
		contentPane.add(lblTitle);

		JButton btnLogOut = new JButton("로그아웃");
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?","Logout",JOptionPane.YES_NO_OPTION);
				if(result ==JOptionPane.YES_OPTION ) {
					new MainPage();	
					dispose();	
				}
			}
		});
		btnLogOut.setBounds(638, 54, 97, 23);
		contentPane.add(btnLogOut);

		JLabel lblUserName = new JLabel("홍길동");
		lblUserName.setText(Util_UI.name);
		lblUserName.setFont(new Font("굴림", Font.BOLD, 15));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(648, 29, 57, 15);
		contentPane.add(lblUserName);

		JLabel lbltext1 = new JLabel("님");
		lbltext1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltext1.setFont(new Font("굴림", Font.BOLD, 15));
		lbltext1.setBounds(696, 29, 57, 15);
		contentPane.add(lbltext1);

		JButton btnPre = new JButton("이전");
		btnPre.setBackground(Color.GRAY);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new SelectTimePage();
			}
		});
		btnPre.setFont(new Font("굴림", Font.BOLD, 20));
		btnPre.setBounds(44, 430, 100, 70);
		contentPane.add(btnPre);

		JPanel pnlNum = new JPanel();
		pnlNum.setBackground(Color.WHITE);
		pnlNum.setBounds(29, 122, 719, 287);
		contentPane.add(pnlNum);
		pnlNum.setLayout(new GridLayout(0, 9, 5, 5));

		JLabel lblAdult = new JLabel("성인");
		lblAdult.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult.setFont(new Font("굴림", Font.BOLD, 20));
		pnlNum.add(lblAdult);

		JLabel lblAdult_1 = new JLabel("");
		lblAdult_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_1);

		JLabel lblAdult_2 = new JLabel("");
		lblAdult_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2);

		JLabel lblAdult_3 = new JLabel("");
		lblAdult_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_3.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_3);

		JLabel lblAdult_3_1 = new JLabel("");
		lblAdult_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_3_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_3_1);

		JLabel lblAdult_4 = new JLabel("");
		lblAdult_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_4.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_4);

		JLabel lblAdult_1_1 = new JLabel("");
		lblAdult_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_1_1);

		JLabel lblAdult_2_1 = new JLabel("");
		lblAdult_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2_1);

		JLabel lblAdult_2_1_1 = new JLabel("");
		lblAdult_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2_1_1);

		Util_UI ui = new Util_UI(); // Util_UI의 메소드를 사용하기 위해 객체생성

		JButton btnAdult0 = new JButton("0");
		JButton btnAdult1 = new JButton("1");
		JButton btnAdult2 = new JButton("2");
		JButton btnAdult3 = new JButton("3");
		JButton btnAdult4 = new JButton("4");
		JButton btnAdult5 = new JButton("5");
		JButton btnAdult6 = new JButton("6");
		JButton btnAdult7 = new JButton("7");
		JButton btnAdult8 = new JButton("8");

		btnAdult0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult0, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult1, btnAdult0, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});
		btnAdult2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult2, btnAdult1, btnAdult0, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult3, btnAdult1, btnAdult2, btnAdult0, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult4, btnAdult1, btnAdult2, btnAdult3, btnAdult0, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult5, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult0, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult6, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult0, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult7, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult0,
						btnAdult8);
			}
		});

		btnAdult8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult8, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult0);
			}
		});

		btnAdult0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectAdult(btnAdult0, btnAdult1, btnAdult2, btnAdult3, btnAdult4, btnAdult5, btnAdult6, btnAdult7,
						btnAdult8);
			}
		});

		btnAdult0.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult0.setBackground(new Color(80, 188, 223));
		pnlNum.add(btnAdult0);

		btnAdult1.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult1.setBackground(Color.WHITE);
		pnlNum.add(btnAdult1);

		btnAdult2.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult2.setBackground(Color.WHITE);
		pnlNum.add(btnAdult2);

		btnAdult3.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult3.setBackground(Color.WHITE);
		pnlNum.add(btnAdult3);

		btnAdult4.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult4.setBackground(Color.WHITE);
		pnlNum.add(btnAdult4);

		btnAdult5.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult5.setBackground(Color.WHITE);
		pnlNum.add(btnAdult5);

		btnAdult6.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult6.setBackground(Color.WHITE);
		pnlNum.add(btnAdult6);

		btnAdult7.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult7.setBackground(Color.WHITE);
		pnlNum.add(btnAdult7);

		btnAdult8.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdult8.setBackground(Color.WHITE);
		pnlNum.add(btnAdult8);

		JLabel lblChild = new JLabel("청소년");
		lblChild.setHorizontalAlignment(SwingConstants.CENTER);
		lblChild.setFont(new Font("굴림", Font.BOLD, 20));
		pnlNum.add(lblChild);

		JLabel lblAdult_1_2 = new JLabel("");
		lblAdult_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_1_2);

		JLabel lblAdult_2_2 = new JLabel("");
		lblAdult_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2_2.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2_2);

		JLabel lblAdult_3_2 = new JLabel("");
		lblAdult_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_3_2.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_3_2);

		JLabel lblAdult_3_1_1 = new JLabel("");
		lblAdult_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_3_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_3_1_1);

		JLabel lblAdult_4_1 = new JLabel("");
		lblAdult_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_4_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_4_1);

		JLabel lblAdult_1_1_1 = new JLabel("");
		lblAdult_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_1_1_1);

		JLabel lblAdult_2_1_2 = new JLabel("");
		lblAdult_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2_1_2);

		JLabel lblAdult_2_1_1_1 = new JLabel("");
		lblAdult_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		pnlNum.add(lblAdult_2_1_1_1);

		// -------------------------------------------------------

		JButton btnChild0 = new JButton("0");
		JButton btnChild1 = new JButton("1");
		JButton btnChild2 = new JButton("2");
		JButton btnChild3 = new JButton("3");
		JButton btnChild4 = new JButton("4");
		JButton btnChild5 = new JButton("5");
		JButton btnChild6 = new JButton("6");
		JButton btnChild7 = new JButton("7");
		JButton btnChild8 = new JButton("8");

		btnChild0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild0, btnChild1, btnChild2, btnChild3, btnChild4, btnChild5, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild1, btnChild0, btnChild2, btnChild3, btnChild4, btnChild5, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild2, btnChild1, btnChild0, btnChild3, btnChild4, btnChild5, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild3, btnChild1, btnChild2, btnChild0, btnChild4, btnChild5, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild4, btnChild1, btnChild2, btnChild3, btnChild0, btnChild5, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild5, btnChild1, btnChild2, btnChild3, btnChild4, btnChild0, btnChild6, btnChild7,
						btnChild8);
			}
		});
		btnChild6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild6, btnChild1, btnChild2, btnChild3, btnChild4, btnChild5, btnChild0, btnChild7,
						btnChild8);
			}
		});
		btnChild7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild7, btnChild1, btnChild2, btnChild3, btnChild4, btnChild5, btnChild6, btnChild0,
						btnChild8);
			}
		});
		btnChild8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectChild(btnChild8, btnChild1, btnChild2, btnChild3, btnChild4, btnChild5, btnChild6, btnChild0,
						btnChild0);
			}
		});

		btnChild0.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild0.setBackground(sky);
		pnlNum.add(btnChild0);

		btnChild1.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild1.setBackground(Color.WHITE);
		pnlNum.add(btnChild1);

		btnChild2.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild2.setBackground(Color.WHITE);
		pnlNum.add(btnChild2);

		btnChild3.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild3.setBackground(Color.WHITE);
		pnlNum.add(btnChild3);

		btnChild4.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild4.setBackground(Color.WHITE);
		pnlNum.add(btnChild4);

		btnChild5.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild5.setBackground(Color.WHITE);
		pnlNum.add(btnChild5);

		btnChild6.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild6.setBackground(Color.WHITE);
		pnlNum.add(btnChild6);

		btnChild7.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild7.setBackground(Color.WHITE);
		pnlNum.add(btnChild7);

		btnChild8.setFont(new Font("굴림", Font.BOLD, 15));
		btnChild8.setBackground(Color.WHITE);
		pnlNum.add(btnChild8);

		JLabel lblAdult_5 = new JLabel("좌석 선택");
		lblAdult_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_5.setFont(new Font("굴림", Font.BOLD, 20));
		lblAdult_5.setBounds(285, 29, 192, 68);
		contentPane.add(lblAdult_5);

		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnAdult0.getBackground().equals(sky) && btnChild0.getBackground().equals(sky)) { //만약 인원을 선택하지 않았다면
					JOptionPane.showMessageDialog(null, "인원을 선택해주세요.");
				} else {
					Util_UI.headCount = Util_UI.cntAdult + Util_UI.cntChild; //성인 수와 청소년 수를  총 인원 수에 저장
					Util_UI.price = (Util_UI.cntAdult * 14000) + (Util_UI.cntChild * 12000); //성인 수와 청소년 수를 계산해 총 가격을 전역변수에 저장
				//System.out.println(Util_UI.headCount);
					dispose();
					new SelectSeatPage();
				}
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 20));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(331, 430, 100, 70);
		contentPane.add(btnNext);

	}
}
