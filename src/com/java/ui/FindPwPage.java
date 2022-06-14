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

public class FindPwPage extends JFrame {

	private JPanel pnlMain;
	private JTextField txtEmail;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPwPage frame = new FindPwPage();
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
	public FindPwPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		pnlMain = new JPanel();
		pnlMain.setBackground(Color.WHITE);
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(null);

		JLabel lblTitle = new JLabel("비밀번호찾기");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setBounds(300, 17, 160, 30);
		pnlMain.add(lblTitle);

		JButton btnFindPw = new JButton("PW찾기"); // PW찾기 버튼
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이메일과 이름을 변수에 저장
				String email = txtEmail.getText().trim();
				String name = txtName.getText().trim();			
				MemberDao dao = new MemberDao();
				dao.findPw(email, name);// 일치하는 이메일과 이름 검색
			}
		});
		btnFindPw.setBackground(SystemColor.activeCaption);
		btnFindPw.setBounds(319, 396, 105, 27);
		pnlMain.add(btnFindPw);

		JButton btnGoMain = new JButton("메인화면"); // 메인화면으로
		btnGoMain.setBackground(SystemColor.activeCaption);
		btnGoMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainPage();
			}
		});
		btnGoMain.setBounds(319, 435, 105, 27);
		pnlMain.add(btnGoMain);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-189, 224, 760, 98);
		pnlMain.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		
		
		JLabel lblNewLabel = new JLabel("이메일:");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		

			txtEmail = new JTextField();
			txtEmail.setFont(new Font("굴림", Font.PLAIN, 15));
			panel.add(txtEmail);
			txtEmail.setToolTipText("ID");
			txtEmail.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("이름:");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(lblNewLabel_1);
			
			txtName = new JTextField();
			txtName.setFont(new Font("굴림", Font.PLAIN, 15));
			txtName.setToolTipText("ID");
			txtName.setColumns(10);
			panel.add(txtName);
	
	}
}
