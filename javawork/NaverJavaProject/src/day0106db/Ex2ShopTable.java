package day0106db;

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

public class Ex2ShopTable extends JFrame{
	JTextField tfSang, tfSu, tfDan;
	JButton btnAdd, btnDel, btnUpdate, btnSearch;
	DefaultTableModel tableModel;
	JTable table;
	
	ShopModel shopModel = new ShopModel();
	
	public Ex2ShopTable() {
		// TODO Auto-generated constructor stub
		super("shop 관리");
		this.setBounds(300, 100, 600, 400); //시작위치, 프레임 크기 설정
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 종료
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		tfSang = new JTextField(6);
		tfSu = new JTextField(3);
		tfDan = new JTextField(6);
		
		p1.add(new JLabel("상품명"));
		p1.add(tfSang);
		p1.add(new JLabel("수량"));
		p1.add(tfSu);
		p1.add(new JLabel("단가"));
		p1.add(tfDan);
		
		this.add("North", p1);
		
		String[] title = {"인덱스", "상품명", "수량", "단가", "총금액", "입고일"};
		tableModel = new DefaultTableModel(title, 0);
		table=new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		
		//생성된 테이블에 DB 데이터 출력하기
		this.rowSelect();
		
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		btnSearch = new JButton("상품검색");
		
		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		p2.add(btnSearch);
		this.add("South", p2);
		
		//상품추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//일단 입력한 데이터들을 읽어서 dto로 묶어준다
				String sangpum = tfSang.getText();
				if(sangpum.length()==0)
				{
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력하세요");
					return; //메시지 띄운 후 메서드 종료
				}
				String text_su = tfSu.getText();
				int su = 0;
				if (text_su.length()==0)
				{
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "수량을 입력해주세요");
					return;
				}else {
					su = Integer.parseInt(text_su);	
				} 
				String text_dan = tfDan.getText();
				int danga = 0;
				if (text_dan.length()==0)
				{
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "단가를 입력해주세요");
					return;
				} else {
					try {
						danga = Integer.parseInt(text_dan);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(Ex2ShopTable.this, "단가는 숫자로 입력해주세요");
						return;
					}
				}
				
				//insert 메서드 호출
				shopModel.insertShop(new ShopDto(sangpum, su, danga));
				//전체 데이터 다시 출력
				rowSelect();
				//입력한 데이터 초기화
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
		
		//삭제 버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//table의 선택한 행번호 가져오기
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if (row==-1)
				{
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "삭제할 행을 먼저 선택해주세요");
					return;
				}
				
				int idx = Integer.parseInt(table.getValueAt(row, 0).toString());
				shopModel.deleteShop(idx);
				rowSelect();
			}
		});
		
		//수정 버튼 이벤트
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//table의 선택한 행번호 가져오기
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if (row==-1)
				{
					JOptionPane.showMessageDialog(Ex2ShopTable.this, "수정할 행을 먼저 선택해주세요");
					return;
				}
				
				int idx = Integer.parseInt((String)table.getValueAt(row, 0));
				
				String sangpum;
				int danga;
				
				sangpum = JOptionPane.showInputDialog("수정할 상품명을 입력하세요.");
				danga = Integer.parseInt(JOptionPane.showInputDialog("수정할 단가를 입력하세요."));
				
				//수정 메서드 호출
				shopModel.updateShop(idx, sangpum, danga);
				//테이블 다시 출력
				rowSelect();
			}
		});
		
	//검색 이벤트
	btnSearch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//텍스트 필드에서 상품명을 입력하면 상품 출력
			//입력 안하면 전체 출력
			String sangpum = tfSang.getText();
			
			if (sangpum.length() == 0) 
				rowSelect();
			else {
				//일단 기존 데이터 모두 삭제
				tableModel.setRowCount(0);
				List<Vector<String>> searchList = shopModel.getSearchData(sangpum);
				//테이블에 출력
				for(Vector<String> data:searchList)
				{
					tableModel.addRow(data);
				}
			}
		}
	});
	}
	
	public void rowSelect() {
		//기존 테이블의 데이터는 모두 삭제
		tableModel.setRowCount(0);
		
		//db의 모든 데이터 가져오기
		List<Vector<String>> list = shopModel.getAllDatas();
		for (Vector<String> data:list)
		{
			tableModel.addRow(data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2ShopTable ex2 = new Ex2ShopTable();
	}	
}