package day1223;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame
{
	//멤버변수로 버튼을 생성, default 생성자 외에 버튼 내 문자열 넣기도 가능
	JButton btn1 = new JButton("Hello");
	
	public MyFrame()
	{
		super(); //생략가능, JFrame이 가진 디폴트 생성자가 상속
		this.setBounds(300, 100, 300, 300);
		this.setLayout(null);
		//btn1 위치 지정
		btn1.setBounds(30, 30, 100, 30);
		
		//프레임에 추가
		this.add(btn1);
		
		//btn1 이벤트 (메시지 핸들링)
		btn1.addActionListener(new ActionListener() {
			
			private Component MyFrame;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(this.MyFrame, "버튼이벤트입니다");
			}
		});
		
		this.setVisible(true); //프레임을 보이게 한다
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료
	}
}

public class Ex6Jframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame my = new MyFrame();
	}

}
