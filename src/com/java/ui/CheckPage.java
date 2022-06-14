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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.java.jdbc.DBConnection;
import com.java.jdbc.MovieDto;
import com.java.jdbc.RSV_MovieDao;
import com.java.jdbc.RSV_MovieDto;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckPage extends JFrame {

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
	private JButton btnCancle;
	private JTable table;
	private DefaultTableModel tbModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckPage frame = new CheckPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

	public void selectAll() { //예약된 정보 보여주기
		con = DBConnection.getConnection();
		try {
			//예약된 정보는 로그인한 유저의 이메일과 함께 저장되서 예약테이블인 rsv_movie_tb에 이메일로 검색을 해서 예약된 정보 출력
			pstmt = con.prepareStatement("SELECT * from rsv_movie_tb WHERE email = " + Util_UI.keyEmail);
			tbModel.setRowCount(0);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[10];
				for (int i = 0; i < row.length; i++) {
					row[i] = rs.getString(i + 2);
				}
				tbModel.addRow(row);
			}
		} catch (Exception e) {

		} finally {
			dbClose();
		}
	}

	/**
	 * Create the frame.
	 */
	public CheckPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("예매조회");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(402, 22, 160, 30);
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
		btnLogOut.setBounds(857, 54, 97, 23);
		contentPane.add(btnLogOut);

		JLabel lblUserName = new JLabel("홍길동");
		lblUserName.setText(Util_UI.name);
		lblUserName.setFont(new Font("굴림", Font.BOLD, 15));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(867, 29, 57, 15);
		contentPane.add(lblUserName);

		JLabel lbltext1 = new JLabel("님");
		lbltext1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltext1.setFont(new Font("굴림", Font.BOLD, 15));
		lbltext1.setBounds(915, 29, 57, 15);
		contentPane.add(lbltext1);

		btnCancle = new JButton("예매취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util_UI.now = (String) table.getValueAt(Util_UI.row, 8);
				System.out.println("선택한 행" + Util_UI.now);
				RSV_MovieDao dao = new RSV_MovieDao();
				int result = dao.delRSV_Movie(Util_UI.keyEmail, Util_UI.now); // 삭제 성공했는지 삭제 실패했는지 반환값을 확인하기 위한 변수
				if (result == 1) { // 삭제 성공했다면
					JOptionPane.showMessageDialog(null, "영화 예매를 취소하였습니다."); // 영화예매취소 성공메시지
					selectAll(); // 새로고침
				} else {
					JOptionPane.showMessageDialog(null, "영화 예매를 취소하지 못하였습니다."); // 영화예매취소 실패메시지
					selectAll(); // 새로고침
				}
			}
		});
		btnCancle.setBackground(SystemColor.activeCaption);
		btnCancle.setFont(new Font("굴림", Font.BOLD, 15));
		btnCancle.setBounds(434, 449, 100, 70);
		contentPane.add(btnCancle);

		JButton btnPre = new JButton("이전");
		btnPre.setBackground(SystemColor.activeCaption);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPage();
			}
		});

		btnPre.setFont(new Font("굴림", Font.BOLD, 20));
		btnPre.setBounds(40, 447, 100, 70);
		contentPane.add(btnPre);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { // 마우스 클릭 이벤트

				Util_UI.row = table.getSelectedRow(); // 행을 받아옴
				
			}
		});
		scrollPane.setBounds(12, 87, 960, 344);
		contentPane.add(scrollPane);

		tbModel = (new DefaultTableModel(new Object[][] {},
				new String[] { "지역", "예매날짜", "영화", "상영시간", "상영길이", "인원", "상영관", "좌석번호", "예매시간", "결제가격" }));
		table = new JTable(tbModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("굴림", Font.BOLD, 11));
		table.setRowHeight(25);
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // 셀 중앙정렬을 위한 코드
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		table.getColumn("지역").setPreferredWidth(10); // 셀 넓이조절
		table.getColumn("상영시간").setPreferredWidth(30); // 셀 넓이조절
		table.getColumn("상영길이").setPreferredWidth(30); // 셀 넓이조절
		table.getColumn("예매시간").setPreferredWidth(100); // 셀 넓이조절
		table.getColumn("상영관").setPreferredWidth(10); // 셀 넓이조절
		table.getColumn("결제가격").setPreferredWidth(30); // 셀 넓이조절
		selectAll();

	}
}
