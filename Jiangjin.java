package main;

import javax.swing.JTextArea;

class Jiangjin {
	double answer, number;
	JTextArea text;
	public double geta() {
		answer = number * 20;
		return answer;
	}
	public double getb() {
		answer = number * 25;
		return answer;
	}
	public double getc() {
		answer = number * 30;
		return answer;
	}
	public double getd() {
		answer = (number - 100) * 5;
		if (number < 100) {
			answer = 0;
			text.append("\n初级管理人员工作量不足100小时，无法获得奖金");
		}
		return answer;
	}
	public double gete() {
		answer = (number - 50) * 10;
		if (number < 50) {
			answer = 0;
			text.append("\n中级管理人员工作量不足50小时，无法获得奖金");
		}
		return answer;
	}
	public double getf() {
		answer = number * 15;
		return answer;
	}
	public void set(double a) {
		number = a;
	}
	public void setJTextArea(JTextArea textShow) {
		text = textShow;
	}
}