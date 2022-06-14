package com.java.util;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Util_Calendar {

	// 날짜 포맷 형식
	DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy-MM-dd(E)");
	DateTimeFormatter d = DateTimeFormatter.ofPattern("d일");
	DateTimeFormatter day = DateTimeFormatter.ofPattern("E");
	static DateTimeFormatter ymdhm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	static LocalDateTime today = LocalDateTime.now(); // 오늘 날짜

	public static String getDate; // 선택한 예매날짜를 저장하는 변수

	public static String todayDate = (today.format(ymdhm)); // 예매할때 현재시간을 저장하는 변수

//--------------버튼의 텍스트를 해당 날짜로 변경---------------------
	public void setDate(JButton btn, int i) { // 버튼의 텍스트를 날짜로 변경하고, 선택한 날짜를 저장
		btn.setText(today.plusDays(i).format(d)); // 버튼의 텍스트를 오늘날짜로 변경
	}

//------------------월, 화, 수, 목, 금, 토, 일 중 해당하는 요일로 표시-----------------------
	public void setDay(JLabel lbl, int i) { // 월 화 수 목 금 토 일 표시
		lbl.setText(today.plusDays(i).format(day)); // 요일로 날짜 포맷 변경
	}

//---------------------토요일이나 일요일이면 글씨색깔을 RED로 변경---------------
	public void isWeekend(JLabel lbl) { // 만약 토요일이나 일요일이면 텍스트색깔 red로 변경
		String txtlbl = lbl.getText().trim();
		if (txtlbl.equals("토") || txtlbl.equals("일")) {
			lbl.setForeground(Color.red);
		}
	}

//-----------------선택한 날짜를 DB에 들어갈 변수에 저장-------------------------
	public void getDate(JButton btn, int i) { // 선택한 날짜 변수에 저장
		getDate = (today.plusDays(i).format(ymd)); // getDate에 오늘날짜 + (i)일의 yyyy-mm-dd 형태로 날짜저장
		Util_UI.srtDate = getDate; // 저장한 날짜를 전역변수 srtDate에 저장
		//System.out.println("선택한 날짜:" + getDate);
	}

}
