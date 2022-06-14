package com.java.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.java.jdbc.MemberDao;
import com.java.jdbc.MemberDto;
import com.java.util.Util_UI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class SelectSeatPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSeatPage frame = new SelectSeatPage();
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
	public SelectSeatPage() {
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		btnPre.setBackground(SystemColor.activeCaption);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util_UI.price = 0; //총 가격 초기화
				Util_UI.headCount = 0; // 총 인원 수를 초기화
				Util_UI.cntAdult = 0;
				Util_UI.cntChild = 0;
				Util_UI.cntSeat = 0;
				dispose();
				new SelectHeadCountPage(); //인원 선택 페이지로 이동
			}
		});
		btnPre.setFont(new Font("굴림", Font.BOLD, 20));
		btnPre.setBounds(265, 508, 100, 30);
		contentPane.add(btnPre);

		txtScreen = new JTextField();
		txtScreen.setFont(new Font("굴림", Font.BOLD, 15));
		txtScreen.setText("SCREEN");
		txtScreen.setHorizontalAlignment(SwingConstants.CENTER);
		txtScreen.setBounds(75, 17, 555, 24);
		contentPane.add(txtScreen);
		txtScreen.setColumns(10);

		JPanel pnlSelectSit = new JPanel();
		pnlSelectSit.setBackground(SystemColor.activeCaption);
		pnlSelectSit.setBounds(110, 50, 491, 353);
		contentPane.add(pnlSelectSit);
		pnlSelectSit.setLayout(new GridLayout(0, 10, 5, 5));

		JLabel lblF_1_10 = new JLabel("");
		lblF_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_10.setForeground(Color.WHITE);
		lblF_1_10.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_10);

		JLabel lblF_1_9 = new JLabel("");
		lblF_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_9.setForeground(Color.WHITE);
		lblF_1_9.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_9);

		JLabel lblF_1_8 = new JLabel("");
		lblF_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_8.setForeground(Color.WHITE);
		lblF_1_8.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_8);

		JLabel lblF_1_7 = new JLabel("");
		lblF_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_7.setForeground(Color.WHITE);
		lblF_1_7.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_7);

		JLabel lblF_1_6 = new JLabel("");
		lblF_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_6.setForeground(Color.WHITE);
		lblF_1_6.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_6);

		JLabel lblF_1_5 = new JLabel("");
		lblF_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_5.setForeground(Color.WHITE);
		lblF_1_5.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_5);

		JLabel lblF_1_4 = new JLabel("");
		lblF_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_4.setForeground(Color.WHITE);
		lblF_1_4.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_4);

		JLabel lblF_1_3 = new JLabel("");
		lblF_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_3.setForeground(Color.WHITE);
		lblF_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_3);

		JLabel lblF_1_2 = new JLabel("");
		lblF_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_2.setForeground(Color.WHITE);
		lblF_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_2);

		JLabel lblF_1_1_1 = new JLabel("");
		lblF_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_1_1.setForeground(Color.WHITE);
		lblF_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_1_1);

		JLabel lblA = new JLabel("A");
		lblA.setForeground(Color.WHITE);
		pnlSelectSit.add(lblA);
		lblA.setFont(new Font("굴림", Font.BOLD, 20));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);

		Util_UI ui = new Util_UI(); // Util_UI의 메소드를 사용하기 위해 객체생성

		
		
		JButton btnA1 = new JButton("1");
		btnA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ui.isSelectSeat(btnA1); // 좌석이 선택안되있으면 선택하고 선택되어있으면 선택해제하는 메서드

			}
		});
		btnA1.setBackground(Color.WHITE);
		btnA1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA1);
		
		

		JButton btnA2 = new JButton("2");
		btnA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ui.isSelectSeat(btnA2);
			}
		});
		btnA2.setBackground(Color.WHITE);
		btnA2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA2);

		JButton btnA3 = new JButton("3");
		btnA3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA3);
			}
		});
		btnA3.setBackground(Color.WHITE);
		btnA3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA3);

		JButton btnA4 = new JButton("4");
		btnA4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA4);
			}
		});
		btnA4.setBackground(Color.WHITE);
		btnA4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA4);

		JButton btnA5 = new JButton("5");
		btnA5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA5);
			}
		});
		btnA5.setBackground(Color.WHITE);
		btnA5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA5);

		JButton btnA6 = new JButton("6");
		btnA6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA6);
			}
		});
		btnA6.setBackground(Color.WHITE);
		btnA6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA6);

		JButton btnA7 = new JButton("7");
		btnA7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA7);
			}
		});
		btnA7.setBackground(Color.WHITE);
		btnA7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA7);

		JButton btnA8 = new JButton("8");
		btnA8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnA8);
			}
		});
		btnA8.setBackground(Color.WHITE);
		btnA8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnA8);

		JLabel lblA_1 = new JLabel("");
		lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblA_1.setForeground(Color.WHITE);
		lblA_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblA_1);

		JLabel lblB = new JLabel("B");
		lblB.setForeground(Color.WHITE);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblB);

		JButton btnB1 = new JButton("1");
		btnB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB1);
			}
		});
		btnB1.setBackground(Color.WHITE);
		btnB1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB1);

		JButton btnB2 = new JButton("2");
		btnB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB2);
			}
		});
		btnB2.setBackground(Color.WHITE);
		btnB2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB2);

		JButton btnB3 = new JButton("3");
		btnB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB3);
			}
		});
		btnB3.setBackground(Color.WHITE);
		btnB3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB3);

		JButton btnB4 = new JButton("4");
		btnB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB4);

			}
		});
		btnB4.setBackground(Color.WHITE);
		btnB4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB4);

		JButton btnB5 = new JButton("5");
		btnB5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB5);

			}
		});
		btnB5.setBackground(Color.WHITE);
		btnB5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB5);

		JButton btnB6 = new JButton("6");
		btnB6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB6);
			}
		});
		btnB6.setBackground(Color.WHITE);
		btnB6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB6);

		JButton btnB7 = new JButton("7");
		btnB7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB7);
			}
		});
		btnB7.setBackground(Color.WHITE);
		btnB7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB7);

		JButton btnB8 = new JButton("8");
		btnB8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnB8);
			}
		});
		btnB8.setBackground(Color.WHITE);
		btnB8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnB8);

		JLabel lblB_1 = new JLabel("");
		lblB_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblB_1);

		JLabel lblC = new JLabel("C");
		lblC.setForeground(Color.WHITE);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblC);

		JButton btnC1 = new JButton("1");
		btnC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC1);
			}
		});
		btnC1.setBackground(Color.WHITE);
		btnC1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC1);

		JButton btnC2 = new JButton("2");
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC2);
			}
		});
		btnC2.setBackground(Color.WHITE);
		btnC2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC2);

		JButton btnC3 = new JButton("3");
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC3);
			}
		});
		btnC3.setBackground(Color.WHITE);
		btnC3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC3);

		JButton btnC4 = new JButton("4");
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC4);
			}
		});
		btnC4.setBackground(Color.WHITE);
		btnC4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC4);

		JButton btnC5 = new JButton("5");
		btnC5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC5);
			}
		});
		btnC5.setBackground(Color.WHITE);
		btnC5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC5);

		JButton btnC6 = new JButton("6");
		btnC6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC6);
			}
		});
		btnC6.setBackground(Color.WHITE);
		btnC6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC6);

		JButton btnC7 = new JButton("7");
		btnC7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC7);
			}
		});
		btnC7.setBackground(Color.WHITE);
		btnC7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC7);

		JButton btnC8 = new JButton("8");
		btnC8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnC8);
			}
		});
		btnC8.setBackground(Color.WHITE);
		btnC8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnC8);

		JLabel lblC_1 = new JLabel("");
		lblC_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblC_1.setForeground(Color.WHITE);
		lblC_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblC_1);

		JLabel lblD = new JLabel("D");
		lblD.setForeground(Color.WHITE);
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblD);

		JButton btnD1 = new JButton("1");
		btnD1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD1);
			}
		});
		btnD1.setBackground(Color.WHITE);
		btnD1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD1);

		JButton btnD2 = new JButton("2");
		btnD2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD2);
			}
		});
		btnD2.setBackground(Color.WHITE);
		btnD2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD2);

		JButton btnD3 = new JButton("3");
		btnD3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD3);
			}
		});
		btnD3.setBackground(Color.WHITE);
		btnD3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD3);

		JButton btnD4 = new JButton("4");
		btnD4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD4);
			}
		});
		btnD4.setBackground(Color.WHITE);
		btnD4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD4);

		JButton btnD5 = new JButton("5");
		btnD5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD5);
			}
		});
		btnD5.setBackground(Color.WHITE);
		btnD5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD5);

		JButton btnD6 = new JButton("6");
		btnD6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD6);
			}
		});
		btnD6.setBackground(Color.WHITE);
		btnD6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD6);

		JButton btnD7 = new JButton("7");
		btnD7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD7);
			}
		});
		btnD7.setBackground(Color.WHITE);
		btnD7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD7);

		JButton btnD8 = new JButton("8");
		btnD8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnD8);
			}
		});
		btnD8.setBackground(Color.WHITE);
		btnD8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnD8);

		JLabel lblD_1 = new JLabel("");
		lblD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblD_1.setForeground(Color.WHITE);
		lblD_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblD_1);

		JLabel lblE = new JLabel("E");
		lblE.setForeground(Color.WHITE);
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblE);

		JButton btnE1 = new JButton("1");
		btnE1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE1);
			}
		});
		btnE1.setBackground(Color.WHITE);
		btnE1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE1);

		JButton btnE2 = new JButton("2");
		btnE2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE2);
			}
		});
		btnE2.setBackground(Color.WHITE);
		btnE2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE2);

		JButton btnE3 = new JButton("3");
		btnE3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE3);
			}
		});
		btnE3.setBackground(Color.WHITE);
		btnE3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE3);

		JButton btnE4 = new JButton("4");
		btnE4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE4);
			}
		});
		btnE4.setBackground(Color.WHITE);
		btnE4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE4);

		JButton btnE5 = new JButton("5");
		btnE5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE5);
			}
		});
		btnE5.setBackground(Color.WHITE);
		btnE5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE5);

		JButton btnE6 = new JButton("6");
		btnE6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE6);
			}
		});
		btnE6.setBackground(Color.WHITE);
		btnE6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE6);

		JButton btnE7 = new JButton("7");
		btnE7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE7);
			}
		});
		btnE7.setBackground(Color.WHITE);
		btnE7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE7);

		JButton btnE8 = new JButton("8");
		btnE8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnE8);
			}
		});
		btnE8.setBackground(Color.WHITE);
		btnE8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnE8);

		JLabel lblE_1 = new JLabel("");
		lblE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1.setForeground(Color.WHITE);
		lblE_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblE_1);

		JLabel lblF = new JLabel("F");
		lblF.setForeground(Color.WHITE);
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF);

		JButton btnF1 = new JButton("1");
		btnF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF1);
			}
		});
		btnF1.setBackground(Color.WHITE);
		btnF1.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF1);

		JButton btnF2 = new JButton("2");
		btnF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF2);
			}
		});
		btnF2.setBackground(Color.WHITE);
		btnF2.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF2);

		JButton btnF3 = new JButton("3");
		btnF3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF3);
			}
		});
		btnF3.setBackground(Color.WHITE);
		btnF3.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF3);

		JButton btnF4 = new JButton("4");
		btnF4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF4);
			}
		});
		btnF4.setBackground(Color.WHITE);
		btnF4.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF4);

		JButton btnF5 = new JButton("5");
		btnF5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF5);
			}
		});
		btnF5.setBackground(Color.WHITE);
		btnF5.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF5);

		JButton btnF6 = new JButton("6");
		btnF6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF6);
			}
		});
		btnF6.setBackground(Color.WHITE);
		btnF6.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF6);

		JButton btnF7 = new JButton("7");
		btnF7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF7);
			}
		});
		btnF7.setBackground(Color.WHITE);
		btnF7.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF7);

		JButton btnF8 = new JButton("8");
		btnF8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.isSelectSeat(btnF8);
			}
		});
		btnF8.setBackground(Color.WHITE);
		btnF8.setFont(new Font("굴림", Font.BOLD, 15));
		pnlSelectSit.add(btnF8);

		JLabel lblF_1 = new JLabel("");
		lblF_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1.setForeground(Color.WHITE);
		lblF_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1);

		JLabel lblF_1_1 = new JLabel("");
		lblF_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblF_1_1.setForeground(Color.WHITE);
		lblF_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		pnlSelectSit.add(lblF_1_1);

		Color yellow_green = new Color(154, 205, 50);
		
		JButton btnNext = new JButton("다음");
		btnNext.setBackground(SystemColor.activeCaption);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Util_UI.cntSeat == Util_UI.headCount) { // 선택한 좌석의 수와 선택한 인원의 수가 같다면		
					dispose();
					if(btnA1.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A1 ";
					}
					if(btnA2.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A2 ";
					}
					if(btnA3.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A3 ";
					}
					if(btnA4.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A4 ";
					}
					if(btnA5.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A5 ";
					}
					if(btnA6.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A6 ";
					}
					if(btnA7.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A7 ";
					}
					if(btnA8.getBackground().equals(yellow_green)) {
						Util_UI.srtSeat = Util_UI.srtSeat + "A8 ";
					}
					new CompletePage();
				} else { // 선택한 좌석의 수와 인원의 수가 같지않다면
					JOptionPane.showMessageDialog(null, "좌석을 선택해주세요."); // 좌석을 선택해달라는 메시지출력
				}
				System.out.println("선택한 좌석:"+Util_UI.srtSeat);
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 20));
		btnNext.setBounds(379, 508, 97, 30);
		contentPane.add(btnNext);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(110, 413, 491, 71);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel lblNewLabel = new JLabel("성인:");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);

		JLabel lblCntAdult = new JLabel("0명");
		lblCntAdult.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblCntAdult);
		lblCntAdult.setText(Integer.toString(Util_UI.cntAdult) + "명"); // 선택한 성인의 수 표시

		JLabel lblAdultPrice = new JLabel("0원");
		lblAdultPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblAdultPrice);
		lblAdultPrice.setText(Integer.toString(Util_UI.cntAdult * 14000) + "원"); // 성인은 인당 14000원

		JLabel lblNewLabel_1_1 = new JLabel("청소년:");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1_1);

		JLabel lblCntChild = new JLabel("0명");
		lblCntChild.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblCntChild);
		lblCntChild.setText(Integer.toString(Util_UI.cntChild) + "명"); // 선택한 청소년의 수 표시

		JLabel lblChildPrice = new JLabel("0원");
		lblChildPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblChildPrice);
		lblChildPrice.setText(Integer.toString(Util_UI.cntChild * 12000) + "원"); // 청소년은 인당 12000원

		JLabel lblNewLabel_1_1_1 = new JLabel("총 금액:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel_1_1_1);

		JLabel lblChildPrice_1 = new JLabel("");
		lblChildPrice_1.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lblChildPrice_1);

		JLabel lbltotalPrice = new JLabel("0원");
		lbltotalPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		panel.add(lbltotalPrice);
		lbltotalPrice.setText(Integer.toString((Util_UI.price)) + "원"); 

	}
}
