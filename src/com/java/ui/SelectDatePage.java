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

public class SelectDatePage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDatePage frame = new SelectDatePage();
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
	public SelectDatePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Calendar cal = Calendar.getInstance();// 날짜 함수

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

				Util_UI.srtDate = ""; // 선택한 날짜
				dispose();
				new SelectMoviePage();
			}
		});
		btnPre.setFont(new Font("굴림", Font.BOLD, 20));
		btnPre.setBounds(44, 430, 100, 70);
		contentPane.add(btnPre);

		// ------------------------------날짜 계산---------------------------------------

		DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy년");	//0000년 날짜 포맷 형식
		DateTimeFormatter m = DateTimeFormatter.ofPattern("M월");	//0월 날짜 포맷 형식
		LocalDateTime today = LocalDateTime.now(); //오늘 날짜
		
		// 현재 연도 구하기
		JLabel lblYear = new JLabel("년");
		lblYear.setText(today.format(yyyy)); //이번 년도로 텍스트 변경
		lblYear.setFont(new Font("굴림", Font.BOLD, 30));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(312, 94, 148, 30);
		contentPane.add(lblYear);

		// 현재 월 구하기
		JLabel lblMonth = new JLabel("월");
		lblMonth.setText(today.format(m));	//이번 달로 텍스트 변경
		lblMonth.setForeground(SystemColor.textHighlight);
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("굴림", Font.BOLD, 20));
		lblMonth.setBounds(312, 146, 148, 30);
		contentPane.add(lblMonth);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(44, 207, 691, 183);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 7, 5, 5));

		//-----------요일 계산------------

		Util_Calendar ucal = new Util_Calendar();
		
		JLabel lbl1 = new JLabel("1");
		ucal.setDay(lbl1, 0);
		ucal.isWeekend(lbl1);	//토요일이나 일요일이면 lbl1색상 red로 변경
		lbl1.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lbl1);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl2 = new JLabel("2");
		ucal.setDay(lbl2, 1);
		ucal.isWeekend(lbl2);	//토요일이나 일요일이면 lbl2색상 red로 변경
		lbl2.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(lbl2);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl3 = new JLabel("3");
		ucal.setDay(lbl3, 2);
		ucal.isWeekend(lbl3);	//토요일이나 일요일이면 lbl3색상 red로 변경
		lbl3.setFont(new Font("굴림", Font.BOLD, 20));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl3);

		JLabel lbl4 = new JLabel("4");
		ucal.setDay(lbl4, 3);
		ucal.isWeekend(lbl4);	//토요일이나 일요일이면 lbl4색상 red로 변경
		lbl4.setFont(new Font("굴림", Font.BOLD, 20));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl4);

		JLabel lbl5 = new JLabel("5");
		ucal.setDay(lbl5,4);
		ucal.isWeekend(lbl5);	//토요일이나 일요일이면 lbl5색상 red로 변경
		lbl5.setFont(new Font("굴림", Font.BOLD, 20));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl5);

		JLabel lbl6 = new JLabel("6");
		ucal.setDay(lbl6,5);
		ucal.isWeekend(lbl6);	//토요일이나 일요일이면 lbl6색상 red로 변경
		lbl6.setFont(new Font("굴림", Font.BOLD, 20));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl6);

		JLabel lbl7 = new JLabel("7");
		ucal.setDay(lbl7,6);
		ucal.isWeekend(lbl7);	//토요일이나 일요일이면 lbl7색상 red로 변경
		lbl7.setFont(new Font("굴림", Font.BOLD, 20));
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl7);

		// -----------------일 수 계산--------------------
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ucal.getDate(btn1,0); //선택한 버튼의 날짜 전역변수에 저장
				dispose();
				new SelectTimePage();//시간 선택페이지로 이동
			}
		});
		ucal.setDate(btn1,0);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("굴림", Font.PLAIN, 20));
		btn1.setBackground(SystemColor.activeCaption);
		panel.add(btn1);

		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn2,1);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn2,1);// 버튼의 텍스트를 1일 후로 변경
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(new Color(153, 180, 209));
		btn2.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn2);

		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn3,2);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn3,2); // 버튼의 텍스트를 2일 후로 변경
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(new Color(153, 180, 209));
		btn3.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn3);

		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn4,3);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn4,3);
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(new Color(153, 180, 209));
		btn4.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn4);

		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn5,4);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn5,4);
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(new Color(153, 180, 209));
		btn5.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn5);

		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn6,5);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn6,5);
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(new Color(153, 180, 209));
		btn6.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn6);

		JButton btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucal.getDate(btn7,6);
				dispose();
				new SelectTimePage();
			}
		});
		ucal.setDate(btn7,6);
		btn7.setForeground(Color.WHITE);
		btn7.setBackground(new Color(153, 180, 209));
		btn7.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(btn7);

		JLabel lblToday = new JLabel("Today");
		lblToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblToday.setForeground(SystemColor.textHighlight);
		lblToday.setFont(new Font("굴림", Font.BOLD, 20));
		lblToday.setBounds(36, 177, 108, 30);
		contentPane.add(lblToday);
		
		JLabel lblAdult_5 = new JLabel("날짜 선택");
		lblAdult_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult_5.setFont(new Font("굴림", Font.BOLD, 20));
		lblAdult_5.setBounds(284, 17, 192, 68);
		contentPane.add(lblAdult_5);

	}
}
