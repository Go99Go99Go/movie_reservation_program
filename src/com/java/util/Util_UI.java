package com.java.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.jdbc.MemberDao;
import com.java.ui.MainPage;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Util_UI extends JFrame {

	Color yellow_green = new Color(154, 205, 50); // yellow green의 RGB값
	Color sky = new Color(80, 188, 223); // yellow green의 RGB값
//---------JTable에 정보를 받아올때 쓰는 row, col-----------	
	public static int row = 0; // 선택한 행
	public static int col = 0; // 선택한 열

	public static String pw = ""; // 비밀번호 찾기할때 비밀번호를 저장하는 전역변수
	public static String name = ""; // 로그인한 회원의 이름을 보여줄때 사용하는 전역변수

	public static int cntAdult; // 선택한 성인의 수
	public static int cntChild; // 선택한 청소년의 수
	public static int price; // 총 금액을 저장하는 전역변수
	public static int headCount; // 선택한 인원의 수
	public static int cntSeat; // 선택한 좌석의 수

	public static String srtLocation; // 선택한 지역
	public static String srtMovie = ""; // 선택한 영화
	public static String srtRunTime = ""; // 선택한 영화의 상영길이
	public static String srtDate = ""; // 선택한 날짜
	public static String srtHall = ""; // 선택한 상영 관
	public static String srtTime = ""; // 선택한 시간
	public static String srtSeat = ""; // 선택한 좌석번호

	public static String now = ""; // 예매된 영화를 삭제 할때 삭제 조건으로 쓰이는 전역변수
	public static String keyEmail = ""; // 예매된 영화정보를 불러올때 회원의 email과 함께 예매정보를 저장할때 쓰이는 전역변수
	// -------------------인원 선택------------------------

	public void isSelectAdult(JButton btn, JButton obtn1, JButton obtn2, JButton obtn3, JButton obtn4, JButton obtn5,
			JButton obtn6, JButton obtn7, JButton obtn8) { // 선택한 버튼말고 다른 버튼을 하얀색으로 바꾸는 메소드
		if (btn.getBackground().equals(Color.white)) {
			btn.setBackground(sky);
			obtn1.setBackground(Color.white);
			obtn2.setBackground(Color.white);
			obtn3.setBackground(Color.white);
			obtn4.setBackground(Color.white);
			obtn5.setBackground(Color.white);
			obtn6.setBackground(Color.white);
			obtn7.setBackground(Color.white);
			obtn8.setBackground(Color.white);
		}
		cntAdult = Integer.parseInt(btn.getText()); // 선택한 성인인원의 수를 cntAdult에 넣음
		System.out.println("성인 : " + cntAdult);
	}

	public void isSelectChild(JButton btn, JButton obtn1, JButton obtn2, JButton obtn3, JButton obtn4, JButton obtn5,
			JButton obtn6, JButton obtn7, JButton obtn8) { // 선택한 버튼말고 다른 버튼을 하얀색으로 바꾸는 메소드
		if (btn.getBackground().equals(Color.white)) {
			btn.setBackground(sky);
			obtn1.setBackground(Color.white);
			obtn2.setBackground(Color.white);
			obtn3.setBackground(Color.white);
			obtn4.setBackground(Color.white);
			obtn5.setBackground(Color.white);
			obtn6.setBackground(Color.white);
			obtn7.setBackground(Color.white);
			obtn8.setBackground(Color.white);
		}
		cntChild = Integer.parseInt(btn.getText()); // 선택한 청소년 인원의 수를 cntChild에 넣음
		System.out.println("청소년 : " + cntChild);
	}

	//------------좌석이 선택됨에 따라 색깔을 바꾸고 선택한 좌석이 선택한 인원보다 적거나 많은지 확인하는 메서드
	public void isSelectSeat(JButton btn) { // 좌석이 선택되어있는지 확인하고 좌석상태에 따른 행동을 실행하는 메서드 (좌석 선택은 색깔로 구분)
		if (cntSeat < headCount) { // 선택한 좌석의 수가 선택한 인원보다 많은지 확인
			if (btn.getBackground().equals(Color.white)) { // 만약 선택하지않은 좌석을 클릭했다면 yellow_green으로 배경색변경 후, 좌석의 수에 1를 더함
				btn.setBackground(yellow_green);
				cntSeat += 1; // 좌석의 수에 1추가
			} else { // 만약 선택한 좌석을 클릭했다면 배경색을 white로 변경 후, 좌석의 수에 1를 뺌
				btn.setBackground(Color.white);
				cntSeat -= 1;
			}
		} else if (btn.getBackground().equals(yellow_green)) { // 선택한 좌석이 선택되있으면 선택해제하고 좌석의 수에 1를 뺌
			btn.setBackground(Color.white);
			cntSeat -= 1;
		} else { // 선택했을때, 선택한 좌석이 선택되어있지않고, 인원수보다 고른 좌석의 수가 더 클경우
			JOptionPane.showMessageDialog(null, "좌석을 모두 선택하였습니다."); // 좌석을 모두 선택했다는 메시지 출력
		}
	}

}
