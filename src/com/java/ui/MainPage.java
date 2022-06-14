package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.java.jdbc.MemberDao;
import com.java.jdbc.MemberDto;
import com.java.util.Util_UI;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.SystemColor;

public class MainPage extends JFrame {

	private JPanel pnlMain;
	private JTextField txtPw;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(300, 100, 800, 600);
		setLocationRelativeTo(null);
		pnlMain = new JPanel();
		pnlMain.setBackground(Color.WHITE);
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(null);

		txtPw = new JPasswordField();
		txtPw.setToolTipText("PW");
		txtPw.setBounds(200, 300, 300, 40);
		pnlMain.add(txtPw);
		txtPw.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("ID");
		txtEmail.setColumns(10);
		txtEmail.setBounds(200, 250, 300, 40);
		pnlMain.add(txtEmail);

		JLabel lblTitle = new JLabel("영화예매프로그램");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(300, 17, 168, 30);
		pnlMain.add(lblTitle);

		JButton btnLogin = new JButton("Login"); // 로그인 버튼
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.setBounds(519, 251, 105, 89);
		pnlMain.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() { // 로그인 버튼을 눌렀을때
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText().trim();
				String pw = txtPw.getText().trim();			
				MemberDao dao = new MemberDao();
				int result = dao.login(email, pw); //반환값을 확인하여 로그인 성공인지 아닌지 확인(1이면 성공)		
				if (email.length() == 0 && pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.", "Login", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText("");
					txtPw.setText("");
				}else if (email.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Login", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText("");
				}else if (pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "Login", JOptionPane.ERROR_MESSAGE);
					txtPw.setText("");
				}else if(result == 1) {	//로그인성공이면
					dao.showName(email, pw); //회원표시
					Util_UI.keyEmail = email; //예매정보를 저장하는 테이블에 쓰일 email을 전역변수에 저장
					dispose();
					new MenuPage(); //메뉴페이지로 이동
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디또는 비밀번호가 일치하지 않습니다.", "Login", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText("");
					txtPw.setText("");
				}
			}
		});

		JButton btnFindPw = new JButton("PW찾기"); // PW찾기 버튼
		btnFindPw.setBackground(SystemColor.activeCaption);
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
					dispose();
					new FindPwPage();
			}
		});
		btnFindPw.setBounds(319, 396, 105, 27);
		pnlMain.add(btnFindPw);
		

		JButton btnSignUp = new JButton("회원가입"); // 회원가입버튼
		btnSignUp.setBackground(SystemColor.activeCaption);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUpPage();
			}
		});
		btnSignUp.setBounds(319, 435, 105, 27);
		pnlMain.add(btnSignUp);
		
	}
}
