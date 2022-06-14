package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.java.jdbc.DBConnection;
import com.java.jdbc.MemberDao;
import com.java.jdbc.MemberDto;
import com.java.jdbc.MovieDao;
import com.java.jdbc.MovieDto;
import com.java.jdbc.RankDao;
import com.java.jdbc.RankDto;
import com.java.util.DateLabelFormatter;
import com.java.util.Util_UI;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.DateModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MgrMoviePage extends JFrame {

	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtMovieName;
	private JTextField txtMovieLocation;
	private JTextField txtMovieTime;
	private JTextField txtMovieRunTime;
	private JTextField txtMovieHall;
	private DefaultTableModel tbModel;
	private JTable table;

	public void dbClose() { // DB닫기
		try {
			if (rs != null) // ResultSet이 비어있지 않으면 ResultSet 닫기
				rs.close();
			if (stmt != null) // statement가 비어있지 않으면 statement 닫기
				stmt.close();
			if (pstmt != null)// preparetatement가 비어있지 않으면 preparetatement 닫기
				pstmt.close();
			if (con != null) // db 커넥션이 비어있지 않으면 닫기
				con.close();
		} catch (Exception e) {
			System.out.println(e + "=> DB닫기 실패");
		}
	}

	public void selectAll() {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from movie_tb order by movie_name ASC");
			tbModel.setRowCount(0);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[6];
				for (int i = 0; i < row.length; i++) {
					row[i] = rs.getString(i + 1);
				}
				tbModel.addRow(row);
			}
		} catch (Exception e) {

		} finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MgrMoviePage frame = new MgrMoviePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MgrMoviePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(703, 195, 237, 30);
		contentPane.add(datePicker);

		tbModel = (new DefaultTableModel(new Object[][] {},
				new String[] { "영화 제목", "상영 지역", "상영 날짜", "상영 길이", "상영 시간", "상영관" }));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 171, 579, 268);
		contentPane.add(scrollPane);
		table = new JTable(tbModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //마우스 클릭시 행의 정보를 텍스트에 표시
				int row = table.getSelectedRow(); // 행을 받아옴
					txtMovieName.setText((String) table.getValueAt(row, 0));
					txtMovieLocation.setText((String) table.getValueAt(row, 1));
					datePicker.getJFormattedTextField().setText((String) table.getValueAt(row, 2));
					txtMovieRunTime.setText((String) table.getValueAt(row, 3));
					txtMovieTime.setText((String) table.getValueAt(row, 4));
					txtMovieHall.setText((String) table.getValueAt(row, 5));		
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JLabel lblTitle = new JLabel("영화관리");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(402, 24, 160, 30);
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
		btnLogOut.setBounds(857, 49, 97, 23);
		contentPane.add(btnLogOut);

		JLabel lblUserName = new JLabel("홍길동");
		lblUserName.setText(Util_UI.name);
		lblUserName.setFont(new Font("굴림", Font.BOLD, 15));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(867, 24, 57, 15);
		contentPane.add(lblUserName);

		JLabel lbltext1 = new JLabel("님");
		lbltext1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltext1.setFont(new Font("굴림", Font.BOLD, 15));
		lbltext1.setBounds(915, 24, 57, 15);
		contentPane.add(lbltext1);

		JLabel lbl2 = new JLabel("추가/삭제");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("굴림", Font.BOLD, 20));
		lbl2.setBounds(742, 132, 128, 37);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("등록된 영화 목록");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("굴림", Font.BOLD, 20));
		lbl3.setBounds(192, 102, 190, 37);
		contentPane.add(lbl3);

		JButton btnAdd = new JButton("추가");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() { // 영화추가하기
			public void actionPerformed(ActionEvent e) {
				String movie_name = txtMovieName.getText().trim();
				String movie_location = txtMovieLocation.getText().trim();
				String movie_Runtime = txtMovieRunTime.getText().trim();
				String movie_time = txtMovieTime.getText().trim();
				String movie_hall = txtMovieHall.getText().trim();
				String movie_date = datePicker.getJFormattedTextField().getText();			
				// 빈칸있는지 확인하는 if문
				if (movie_name.length() == 0 || movie_location.length() == 0 || movie_Runtime.length() == 0      
						|| movie_time.length() == 0 || movie_hall.length() == 0) { 
					JOptionPane.showMessageDialog(null, "빈칸을 확인해 주세요.", "Error", JOptionPane.ERROR_MESSAGE);
				} else { //빈칸이 없으면
					MovieDto dto = new MovieDto(movie_name, movie_location, movie_date, movie_Runtime, movie_time,movie_hall);
					dto.setMovie_name(movie_name);
					dto.setMovie_date(movie_date);
					dto.setMovie_location(movie_location);
					dto.setMovie_hall(movie_hall);
					dto.setMovie_time(movie_time);
					dto.setMovie_Runtime(movie_Runtime);
					
					RankDao rdao = new RankDao();
					rdao.addRank(movie_name); //무비차트에 보일 영화이름을 테이블에 추가
					
					MovieDao dao = new MovieDao();
					int result = dao.addMovie(dto); //추가할 영화를 테이블에 추가하고 추가가 완료 되었는지 확인
					if (result == 1) { //1이면 추가성공
						JOptionPane.showMessageDialog(null, "영화를 추가하였습니다.");
						txtMovieName.setText("");	//빈칸으로 초기화
						txtMovieLocation.setText("");
						datePicker.getJFormattedTextField().setText("");
						txtMovieTime.setText("");
						txtMovieRunTime.setText("");
						txtMovieHall.setText("");
						selectAll();
					} else { //1이아니면 추가실패
						JOptionPane.showMessageDialog(null, "영화를 추가하지 못하였습니다.");
						dispose();
					}
				}
			}
		});
		btnAdd.setFont(new Font("굴림", Font.BOLD, 20));
		btnAdd.setBounds(840, 450, 100, 70);
		contentPane.add(btnAdd);

		JButton btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//변수에다 텍스트필드에 입력한 값을 집어넣어줌
				String movie_name = txtMovieName.getText().trim();
				String movie_location = txtMovieLocation.getText().trim();
				String movie_date = datePicker.getJFormattedTextField().getText();
				String movie_time = txtMovieTime.getText().trim();
				String movie_Runtime = txtMovieRunTime.getText().trim();
				String movie_hall = txtMovieHall.getText().trim();
				//빈칸을 확인하는 if문
				if (movie_name.length() == 0 || movie_location.length() == 0 || movie_Runtime.length() == 0
						|| movie_time.length() == 0 || movie_hall.length() == 0) { 
					JOptionPane.showMessageDialog(null, "빈칸을 확인해 주세요.", "Error", JOptionPane.ERROR_MESSAGE);
				} else { //빈칸이 없으면
					MovieDto dto = new MovieDto(movie_name, movie_location, movie_date, movie_Runtime, movie_time,movie_hall);
					dto.setMovie_name(movie_name);
					dto.setMovie_location(movie_location);
					dto.setMovie_date(movie_date);
					dto.setMovie_Runtime(movie_Runtime);
					dto.setMovie_time(movie_time);
					dto.setMovie_hall(movie_hall);

					MovieDao dao = new MovieDao();
					int result = dao.delMovie(dto);
					if (result == 1) { //영화 삭제 성공했다면
						JOptionPane.showMessageDialog(null, "영화를 삭제하였습니다.");
						txtMovieName.setText("");	//빈칸으로 초기화
						txtMovieLocation.setText("");
						datePicker.getJFormattedTextField().setText("");
						txtMovieTime.setText("");
						txtMovieRunTime.setText("");
						txtMovieHall.setText("");
						selectAll(); // 전체 목록 검색
					} else {
						JOptionPane.showMessageDialog(null, "영화를 삭제하지 못하였습니다.");
						selectAll(); // 전체 목록 검색
					}
				}
			}
		});
		btnDel.setBackground(SystemColor.activeCaption);
		btnDel.setFont(new Font("굴림", Font.BOLD, 20));
		btnDel.setBounds(705, 450, 100, 70);
		contentPane.add(btnDel);

		JButton btnPre = new JButton("이전");
		btnPre.setBackground(SystemColor.activeCaption);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPage();
			}
		});
		btnPre.setFont(new Font("굴림", Font.BOLD, 20));
		btnPre.setBounds(33, 450, 100, 70);
		contentPane.add(btnPre);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(456, 235, 484, 188);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lbl4 = new JLabel("영화 이름:");
		lbl4.setFont(new Font("굴림", Font.BOLD, 15));
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lbl4);

		txtMovieName = new JTextField();
		panel.add(txtMovieName);
		txtMovieName.setColumns(10);

		JLabel lb5 = new JLabel("상영 지역:");
		lb5.setHorizontalAlignment(SwingConstants.RIGHT);
		lb5.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lb5);

		txtMovieLocation = new JTextField();
		txtMovieLocation.setColumns(10);
		panel.add(txtMovieLocation);

		JLabel lbl7 = new JLabel("상영 길이:");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl7);

		txtMovieRunTime = new JTextField();
		txtMovieRunTime.setColumns(10);
		panel.add(txtMovieRunTime);

		JLabel lbl6 = new JLabel("상영 시간:");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl6);

		txtMovieTime = new JTextField();
		txtMovieTime.setColumns(10);
		panel.add(txtMovieTime);

		JLabel lbl8 = new JLabel("상영 관:");
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl8.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lbl8);

		txtMovieHall = new JTextField();
		txtMovieHall.setColumns(10);
		panel.add(txtMovieHall);

		JLabel lbl1 = new JLabel("날짜:");
		lbl1.setBounds(454, 195, 237, 23);
		contentPane.add(lbl1);
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setFont(new Font("굴림", Font.BOLD, 15));

		selectAll();

	}

}
