package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.java.jdbc.DBConnection;
import com.java.util.Util_UI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class MenuPage extends JFrame {

	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;

	private JPanel contentPane;
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

	public void selectAll() { // 테이블 보여주기
		con = DBConnection.getConnection();
		try {
			//무비차트테이블인 rank_tb테이블에서 예매율이 높은순으로 내림차순정렬해서 보여줌
			pstmt = con.prepareStatement("SELECT * from rank_tb ORDER BY movie_percent DESC");
			tbModel.setRowCount(0);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[4];
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage frame = new MenuPage();
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
	public MenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("영화예매프로그램");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(228, 22, 289, 30);
		contentPane.add(lblTitle);

		JButton btnLogOut = new JButton("로그아웃");
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() { // 로그아웃버튼은 누르면 로그아웃
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

		JLabel lblMoiveChart = new JLabel("무비차트");
		lblMoiveChart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoiveChart.setFont(new Font("굴림", Font.BOLD, 25));
		lblMoiveChart.setBounds(289, 69, 156, 70);
		contentPane.add(lblMoiveChart);

		JButton btnMovieTicket = new JButton("영화예매");
		btnMovieTicket.setBackground(SystemColor.activeCaption);
		btnMovieTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SelectLocationPage();
			}
		});
		btnMovieTicket.setFont(new Font("굴림", Font.BOLD, 15));
		btnMovieTicket.setBounds(87, 429, 100, 100);
		contentPane.add(btnMovieTicket);

		JButton btnCheck = new JButton("예매조회");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CheckPage();
			}
		});
		btnCheck.setBackground(SystemColor.activeCaption);
		btnCheck.setFont(new Font("굴림", Font.BOLD, 15));
		btnCheck.setBounds(318, 429, 100, 100);
		contentPane.add(btnCheck);

		JButton btnMgr = new JButton("영화관리");
		btnMgr.setBackground(SystemColor.activeCaption);
		btnMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MgrMoviePage();
			}
		});
		btnMgr.setFont(new Font("굴림", Font.BOLD, 15));
		btnMgr.setBounds(557, 429, 100, 100);
		contentPane.add(btnMgr);

		tbModel = (new DefaultTableModel(new Object[][] {}, new String[] {"영화", "예매율","박스오피스","관객 수"}));
		table = new JTable(tbModel);
		table.setFont(new Font("굴림", Font.BOLD, 20)); //테이블 폰트조절
		table.setRowHeight(25);//셀의높이 조절

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 141, 570, 249);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer(); // 중앙 정렬
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		table.getColumn("영화").setPreferredWidth(300); //셀 넓이조절

		selectAll();
	}
}
