package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SignUpPage extends JFrame {

	private JPanel pnlMain;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JTextField txtPw;
	private JTextField txtPwOk;
	private JButton btnGoMain;
	private JButton btnSignUp;
	private JPanel panel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		pnlMain = new JPanel();
		pnlMain.setBackground(Color.WHITE);
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(300, 17, 160, 30);
		pnlMain.add(lblTitle);
		
		btnGoMain = new JButton("메인화면");
		btnGoMain.setBackground(SystemColor.activeCaption);
		btnGoMain.setForeground(Color.BLACK);
		btnGoMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainPage();
			}
		});
		btnGoMain.setBounds(330, 500, 105, 27);
		pnlMain.add(btnGoMain);
		
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setBackground(SystemColor.activeCaption);
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setEnabled(false);
		btnSignUp.addActionListener(new ActionListener() { // 로그인 버튼을 눌렀을때
			public void actionPerformed(ActionEvent e) {
				//입력되어 있는 텍스트의 값을 받아서 변수에 저장
				String email = txtEmail.getText().trim();
				String name = txtUserName.getText().trim();
				String id = txtEmail.getText().trim();
				String pw = txtPw.getText().trim();
				String pwok = txtPwOk.getText().trim();
				if (name.length() == 0 || id.length() == 0 || pw.length() == 0 || pwok.length() == 0) { //텍스트가 하나라도 빈칸이라면
					JOptionPane.showMessageDialog(null, "빈칸을 확인해 주세요.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
				}else if(!pw.equals(pwok)){ //입력한 비밀번호와 비밀번호확인이 동일하지 않다면
					JOptionPane.showMessageDialog(null, "비밀번호가 동일하지 않습니다.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
				}else{	//빈칸도 없고 비밀번호 확인도 입력한 비밀번호와 동일하다면
					MemberDto dto = new MemberDto(email, pw, name); 
					dto.setEmail(email);
					dto.setPw(pw);
					dto.setName(name);		
					MemberDao dao = new MemberDao();
					int result = dao.signUp(dto); //insert로 member_tb테이블에 데이터 저장
					if(result == 1) {
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						dispose();
						new MainPage(); //메인페이지로 이동
					}else {
						JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.");
						dispose();
					}					
				}
			}
			
		});
		btnSignUp.setBounds(330, 450, 105, 27);
		pnlMain.add(btnSignUp);
		
		JButton btnEmailChk = new JButton("중복확인");
		btnEmailChk.setBackground(Color.WHITE);
		btnEmailChk.setForeground(Color.BLACK);
		btnEmailChk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText().trim();
				MemberDao dao = new MemberDao();			
				int result = dao.emailCheck(email);	
				if(result == 1 ) {
					JOptionPane.showMessageDialog(null, "중복된 이메일입니다.");
					txtEmail.setText("");
				}else if(email.length()==0){
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.");
				}else {
					JOptionPane.showMessageDialog(null, "사용가능한 이메일입니다.");
					btnSignUp.setEnabled(true);	//회원가입버튼 활성화
					txtEmail.setEnabled(false); //이메일입력텍스트박스 비활성화
				}
			}
		});
		btnEmailChk.setBounds(537, 240, 105, 27);
		pnlMain.add(btnEmailChk);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 183, 525, 192);
		pnlMain.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblName = new JLabel("이름:");
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtUserName = new JTextField();
		panel.add(txtUserName);
		txtUserName.setToolTipText("ID");
		txtUserName.setColumns(10);
		
		JLabel lblId = new JLabel("이메일:");
		panel.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtEmail = new JTextField();
		panel.add(txtEmail);
		txtEmail.setToolTipText("ID");
		txtEmail.setColumns(10);
		
		JLabel lblPw = new JLabel("비밀번호:");
		panel.add(lblPw);
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtPw = new JPasswordField();
		panel.add(txtPw);
		txtPw.setToolTipText("ID");
		txtPw.setColumns(10);
		
		JLabel lblPwOk = new JLabel("비밀번호 확인:");
		panel.add(lblPwOk);
		lblPwOk.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtPwOk = new JPasswordField();
		panel.add(txtPwOk);
		txtPwOk.setToolTipText("ID");
		txtPwOk.setColumns(10);
	}
}
