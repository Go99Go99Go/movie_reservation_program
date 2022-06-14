package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.java.jdbc.MovieDao;
import com.java.jdbc.MovieDto;
import com.java.jdbc.RSV_MovieDao;
import com.java.jdbc.RSV_MovieDto;
import com.java.jdbc.RankDao;
import com.java.util.Util_Calendar;
import com.java.util.Util_UI;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.DateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;

public class CompletePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtMovieName;
	private JTextField txtDate;
	private JTextField txtLocation;
	private JTextField txtPeople;
	private JTextField txtSeat;
	private JTextField txtPrice;
	private JTextField txtNow;
	private JButton btnCancle;
	private JTextField txtHall;
	private JTextField txtTime;
	private JTextField txtRunTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletePage frame = new CompletePage();
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
	public CompletePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("예매확인");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(300, 17, 160, 30);
		contentPane.add(lblTitle);

		JButton btnLogOut = new JButton("로그아웃");
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Logout", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
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

		btnCancle = new JButton("예매취소");
		btnCancle.setBackground(SystemColor.activeCaption);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ------초기화------
				Util_UI.cntAdult = 0; // 선택한 성인의 수
				Util_UI.cntChild = 0; // 선택한 청소년의 수
				Util_UI.price = 0; // 총 금액을 저장하는 전역변수
				Util_UI.headCount = 0; // 선택한 인원의 수
				Util_UI.cntSeat = 0; // 선택한 좌석의 수
				Util_UI.srtLocation = ""; // 선택한 지역
				Util_UI.srtMovie = ""; // 선택한 영화
				Util_UI.srtRunTime = ""; // 선택한 영화의 상영길이
				Util_UI.srtDate = ""; // 선택한 날짜
				Util_UI.srtHall = ""; // 선택한 상영 관
				Util_UI.srtTime = ""; // 선택한 시간
				Util_UI.srtSeat = ""; // 선택한 좌석번호
				Util_UI.now = ""; // 예매된 영화를 삭제 할때 삭제 조건으로 쓰이는 전역변수

				dispose();
				new MenuPage();
			}
		});
		btnCancle.setFont(new Font("굴림", Font.BOLD, 15));
		btnCancle.setBounds(243, 452, 100, 70);
		contentPane.add(btnCancle);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-138, 97, 739, 345);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lbl3 = new JLabel("극장 위치:");
		panel.add(lbl3);
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("굴림", Font.BOLD, 15));

		txtLocation = new JTextField();
		txtLocation.setText(Util_UI.srtLocation); // 선택한 지역 표시
		txtLocation.setBackground(new Color(255, 255, 255));
		txtLocation.setEditable(false);
		panel.add(txtLocation);
		txtLocation.setColumns(10);

		JLabel lbl2 = new JLabel("날짜:");
		panel.add(lbl2);
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("굴림", Font.BOLD, 15));

		txtDate = new JTextField();
		txtDate.setText(Util_UI.srtDate); // 선택한 날짜 표시
		txtDate.setBackground(new Color(255, 255, 255));
		txtDate.setEditable(false);
		panel.add(txtDate);
		txtDate.setColumns(10);
		txtDate.setText(Util_Calendar.getDate);

		JLabel lbl1 = new JLabel("영화 이름:");
		panel.add(lbl1);
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setFont(new Font("굴림", Font.BOLD, 15));

		txtMovieName = new JTextField();
		txtMovieName.setText(Util_UI.srtMovie); // 선택한 영화 표시
		txtMovieName.setBackground(new Color(255, 255, 255));
		txtMovieName.setEditable(false);
		panel.add(txtMovieName);
		txtMovieName.setColumns(10);

		JLabel lbl2_1 = new JLabel("상영 시간:");
		lbl2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl2_1);

		txtTime = new JTextField();
		txtTime.setText(Util_UI.srtTime); // 선택한 시간표시
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		txtTime.setBackground(Color.WHITE);
		panel.add(txtTime);

		JLabel lbl2_1_1 = new JLabel("상영 길이:");
		lbl2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl2_1_1);

		txtRunTime = new JTextField();
		txtRunTime.setText(Util_UI.srtRunTime); // 선택한 영화의 상영길이 표시
		txtRunTime.setEditable(false);
		txtRunTime.setColumns(10);
		txtRunTime.setBackground(Color.WHITE);
		panel.add(txtRunTime);

		JLabel lblNewLabel_1_2 = new JLabel("관람 인원:");
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 15));

		txtPeople = new JTextField();
		txtPeople.setBackground(new Color(255, 255, 255));
		txtPeople.setEditable(false);
		panel.add(txtPeople);
		txtPeople.setColumns(10);
		txtPeople.setText("성인 " + Util_UI.cntAdult + "명" + " 청소년 " + Util_UI.cntChild + "명");

		JLabel lbl1_1 = new JLabel("상영 관:");
		lbl1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl1_1);

		txtHall = new JTextField();
		txtHall.setText(Util_UI.srtHall); // 선택한 상영관 표시
		txtHall.setEditable(false);
		txtHall.setColumns(10);
		txtHall.setBackground(Color.WHITE);
		panel.add(txtHall);

		JLabel lblNewLabel_1_1_2 = new JLabel("좌석:");
		panel.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 15));

		txtSeat = new JTextField();
		txtSeat.setBackground(new Color(255, 255, 255));
		txtSeat.setEditable(false);
		panel.add(txtSeat);
		txtSeat.setColumns(10);
		Util_UI ui = new Util_UI();
		txtSeat.setText(Util_UI.srtSeat);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("예매한 날짜:");
		panel.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));

		txtNow = new JTextField();
		txtNow.setBackground(new Color(255, 255, 255));
		txtNow.setEditable(false);
		panel.add(txtNow);
		txtNow.setColumns(10);
		txtNow.setText(Util_Calendar.todayDate); // 예매할때 현재 시간을 나타냄

		JLabel lblNewLabel_1_1_1_1 = new JLabel("결제 금액:");
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));

		txtPrice = new JTextField();
		txtPrice.setBackground(new Color(255, 255, 255));
		txtPrice.setEditable(false);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		txtPrice.setText(Integer.toString((Util_UI.price)) + "원");

		JButton btnOk = new JButton("예매완료");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//변수에 텍스트필드값 저장
				String email = Util_UI.keyEmail;
				String movie_location = txtLocation.getText().trim();
				String movie_date = txtDate.getText().trim();
				String movie_name = txtMovieName.getText().trim();
				String movie_time = txtTime.getText().trim();
				String movie_runtime = txtRunTime.getText().trim();
				String movie_people = txtPeople.getText().trim();
				String movie_hall = txtHall.getText().trim();
				String movie_seat = txtSeat.getText().trim();
				String movie_now = txtNow.getText().trim();
				String movie_price = txtPrice.getText().trim();

				RSV_MovieDto dto = new RSV_MovieDto(email, movie_location, movie_date, movie_name, movie_time,
						movie_runtime, movie_people, movie_hall, movie_seat, movie_now, movie_price);
				dto.setMovie_name(email);
				dto.setMovie_location(movie_location);
				dto.setMovie_date(movie_date);
				dto.setMovie_name(movie_name);
				dto.setMovie_time(movie_time);
				dto.setMovie_runtime(movie_runtime);
				dto.setMovie_people(movie_people);
				dto.setMovie_hall(movie_hall);
				dto.setMovie_seat(movie_seat);
				dto.setMovie_now(movie_now);
				dto.setMovie_price(movie_price);

				RankDao rdao = new RankDao();
				int a = rdao.updateRank(Util_UI.price, Util_UI.headCount, movie_name); // 예매한 정보를 바탕으로 무비차트업데이트
				if (a == 1) {
					System.out.println("무비차트 업데이트성공");
				} else {
					System.out.println("무비차트 업데이트실패");
				}

				RSV_MovieDao dao = new RSV_MovieDao();
				int result = dao.addRSV_Movie(dto); //예매정보 테이블에 데이터 추가
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "예약 되었습니다.");
					// 초기화
					Util_UI.cntAdult = 0; // 선택한 성인의 수
					Util_UI.cntChild = 0; // 선택한 청소년의 수
					Util_UI.price = 0; // 총 금액을 저장하는 전역변수
					Util_UI.headCount = 0; // 선택한 인원의 수
					Util_UI.cntSeat = 0; // 선택한 좌석의 수
					Util_UI.srtLocation = ""; // 선택한 지역
					Util_UI.srtMovie = ""; // 선택한 영화
					Util_UI.srtRunTime = ""; // 선택한 영화의 상영길이
					Util_UI.srtDate = ""; // 선택한 날짜
					Util_UI.srtHall = ""; // 선택한 상영 관
					Util_UI.srtTime = ""; // 선택한 시간
					Util_UI.srtSeat = ""; // 선택한 좌석번호
					Util_UI.now = ""; // 예매된 영화를 삭제 할때 삭제 조건으로 쓰이는 전역변수
					dispose();
					new MenuPage(); // 메인화면으로 이동
				} else {
					JOptionPane.showMessageDialog(null, "예약하지 못하였습니다.");
				}
			}
		});
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.setFont(new Font("굴림", Font.BOLD, 15));
		btnOk.setBounds(397, 452, 100, 70);
		contentPane.add(btnOk);

	}
}
