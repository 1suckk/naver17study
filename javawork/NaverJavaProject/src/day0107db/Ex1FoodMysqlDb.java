package day0107db;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
select database();

use study502;

create table foodrest
(
	num smallint auto_increment primary key,
    foodname varchar(30),
    foodprice int,
    foodsize varchar(20) default '보통'
);

create table foodorder
(
	idx smallint auto_increment primary key,
    num smallint,
    ordername varchar(20),
    ordercnt smallint,
    bookingday varchar(30),
    constraint fk_foodorder_num foreign key(num) references foodrest(num)
);
 */


public class Ex1FoodMysqlDb extends JFrame{
	FoodModel foodModel = new FoodModel();
	DefaultTableModel foodResTableModel;
	DefaultTableModel foodOrderTableModel;
	JTable foodResTable;
	JTable foodOrderTable;
	
	JButton btnFoodResAdd, btnFoodResDel;
	JButton btnFoodOrderAdd, btnFoodOrderDel;
	JTextField tfFoodNum, tfOrderName, tfOrderCnt, tfBookingDay;
	JTextField tfFoodName, tfFoodPrice, tfFoodSize;
	
	public Ex1FoodMysqlDb() {
		// TODO Auto-generated constructor stub
		super("메뉴등록예약");
		this.setBounds(200, 100, 1000, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		btnFoodResAdd = new JButton("메뉴등록");
		btnFoodResDel = new JButton("메뉴삭제");
		btnFoodOrderAdd = new JButton("예약하기");
		btnFoodOrderDel = new JButton("예약취소");
		
		tfFoodName = new JTextField(7);
		tfFoodPrice = new JTextField(7);
		tfFoodSize = new JTextField(5);
		
		p1.add(new JLabel("메뉴명"));
		p1.add(tfFoodName);
		p1.add(new JLabel("가격등록"));
		p1.add(tfFoodPrice);
		p1.add(new JLabel("사이즈"));
		p1.add(tfFoodSize);
		
		p1.add(btnFoodResAdd);
		p1.add(btnFoodResDel);
		p1.add(btnFoodOrderAdd);
		p1.add(btnFoodOrderDel);
		this.add("North", p1);
		
		//좌측 메뉴 보이게 하기
		String[] menuTitle = {"번호", "메뉴명", "가격", "사이즈"};
		foodResTableModel = new DefaultTableModel(menuTitle, 0);
		foodResTable = new JTable(foodResTableModel);
		this.add("West", new JScrollPane(foodResTable));
		
		//생성된 메뉴 테이블에 db 데이터 출력
		writeFoodMenu();
		
		//가운데 예약 테이블 보이게 하기
		String[] orderTitle = {"번호", "예약자", "메뉴명", "가격", "사이즈", "인원수", "예약일"};
		foodOrderTableModel = new DefaultTableModel(orderTitle, 0);
		foodOrderTable = new JTable(foodOrderTableModel);
		this.add("Center", new JScrollPane(foodOrderTable));
		//생성된 예약자 테이블에 예약 내용 출력
		writeFoodOrderJoin();
		
		
		//하단에 예약 내용 입력부분 추가
		tfOrderName = new JTextField(5);
		tfOrderCnt = new JTextField(3);
		tfBookingDay = new JTextField(10);
		tfFoodNum = new JTextField(3);
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel("메뉴번호"));
		p2.add(tfFoodNum);
		
		p2.add(new JLabel("예약자명"));
		p2.add(tfOrderName);
		
		p2.add(new JLabel("인원수"));
		p2.add(tfOrderCnt);
		
		p2.add(new JLabel("예약시간"));
		p2.add(tfBookingDay);
		
		this.add("South", p2);
		
		//메뉴등록
		btnFoodResAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String foodName = tfFoodName.getText();
				int foodPrice = Integer.parseInt(tfFoodPrice.getText());
				String foodSize = tfFoodSize.getText();
				
				//삽입 메서드 호출
				foodModel.foodmenuInsert(foodName, foodPrice, foodSize);
				//테이블 다시 출력
				writeFoodMenu();
				//입력데이터 초기화
				tfFoodName.setText("");
				tfFoodPrice.setText("");
				tfFoodSize.setText("");
			}
		});
		
		//메뉴삭제
		btnFoodResDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = foodResTable.getSelectedRow();
				if (row == -1)
				{
					JOptionPane.showConfirmDialog(Ex1FoodMysqlDb.this, "삭제하려는 메뉴를 선택하세요");
					return;
				}
				
				int num = Integer.parseInt(foodResTable.getValueAt(row, 0).toString());
				System.out.println(num);
				
				//해당 메뉴를 예약한 갯수를 구하기
				int cnt = foodModel.getOrderMenuCount(num);
				if (cnt == 0) {
					foodModel.deleteFoodMenu(num);
					JOptionPane.showConfirmDialog(Ex1FoodMysqlDb.this, "삭제되었습니다.");
					writeFoodMenu();
				} else {
					JOptionPane.showConfirmDialog(Ex1FoodMysqlDb.this, "먼저 예약되어서 삭제안됩니다 먼저 예약취소 하세요!");
				}
			}
		});
		
		//예약버튼 
		btnFoodOrderAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num = Integer.parseInt(tfFoodNum.getText());
				String orderName = tfOrderName.getText();
				int orderCnt = Integer.parseInt(tfOrderCnt.getText());
				String bookingDay = tfBookingDay.getText();
				
				//dto에 넣어주기
				FoodOrderDto dto = new FoodOrderDto(num, orderName, orderCnt, bookingDay);
				//예약 삽입 메서드 출력하기
				foodModel.foodOrderInsert(dto);
				//다시 출력
				writeFoodOrderJoin();
				//입력값 초기화
				tfFoodNum.setText("");
				tfOrderName.setText("");
				tfOrderCnt.setText("");
				tfBookingDay.setText("");
				
			}
		});
		
		//예약취소
		btnFoodOrderDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = foodOrderTable.getSelectedRow();
				if (row == -1)
				{
					JOptionPane.showConfirmDialog(Ex1FoodMysqlDb.this, "삭제하려는 예약을 선택하세요");
					return;
				}
				
				int idx = Integer.parseInt(foodOrderTable.getValueAt(row, 0).toString());
				System.out.println(idx);
				
				//해당 메뉴를 예약한 갯수를 구하기
				foodModel.deleteOrder(idx);
				JOptionPane.showConfirmDialog(Ex1FoodMysqlDb.this, "삭제되었습니다.");
				writeFoodOrderJoin();
			}
		});
	}
	
	public void writeFoodMenu() {
		//db에서 전체 등록된 메뉴를 얻는다
		List<Vector<String>> list = foodModel.getAllMenus();
		//기존 메뉴 삭제
		foodResTableModel.setRowCount(0);
		//table에 출력
		for (Vector<String> data:list)
		{
			foodResTableModel.addRow(data);
		}
	}
	
	public void writeFoodOrderJoin() {
		List<Vector<String>> list = foodModel.getAllOrders();
		//기존 메뉴 삭제
		foodOrderTableModel.setRowCount(0);
		for (Vector<String> data:list)
		{
			foodOrderTableModel.addRow(data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1FoodMysqlDb ex1 = new Ex1FoodMysqlDb();
	}
}