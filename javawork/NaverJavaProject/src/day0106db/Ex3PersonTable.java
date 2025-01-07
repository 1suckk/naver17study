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

public class Ex3PersonTable extends JFrame{
	JTextField tfName, tfAge, tfBlood, tfHp;
	JButton btnAdd, btnDel;
	DefaultTableModel tableModel;
	JTable table;
	
	PersonModel personModel = new PersonModel();
	
	public Ex3PersonTable() {
		super();
		this.setBounds(300, 100, 600, 400); //시작위치, 프레임 크기 설정
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 종료
		this.setVisible(true);
	}
	
		public void initDesign() {
			JPanel p1 = new JPanel();
			tfName = new JTextField(6);
			tfAge = new JTextField(3);
			tfBlood = new JTextField(6);
			tfHp = new JTextField(6);
			
			p1.add(new JLabel("이름"));
			p1.add(tfName);
			p1.add(new JLabel("나이"));
			p1.add(tfAge);
			p1.add(new JLabel("혈액형"));
			p1.add(tfBlood);
			p1.add(new JLabel("핸드폰"));
			p1.add(tfHp);
			
			this.add("North", p1);
			
			String[] title = {"인덱스", "이름", "혈액형", "나이", "핸드폰"};
			tableModel = new DefaultTableModel(title, 0);
			table=new JTable(tableModel);
			this.add("Center", new JScrollPane(table));
			
			//생성된 테이블에 DB 데이터 출력하기
			this.rowSelect();
			
			btnAdd = new JButton("상품추가");
			btnDel = new JButton("상품삭제");
			
			JPanel p2 = new JPanel();
			p2.add(btnAdd);
			p2.add(btnDel);
			this.add("South", p2);
			
			//상품추가 버튼 이벤트
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//일단 입력한 데이터들을 읽어서 dto로 묶어준다
					String name = tfName.getText();
					if(name.length()==0)
					{
						JOptionPane.showMessageDialog(Ex3PersonTable.this, "이름을 입력하세요");
						return; //메시지 띄운 후 메서드 종료
					}
					
					String blood = tfBlood.getText();
					if(blood.length()==0)
					{
						JOptionPane.showConfirmDialog(Ex3PersonTable.this, "혈액형을 입력하세요.");
						return;
					}
					
					String text_age = tfAge.getText();
					int age = 0;
					if (text_age.length()==0)
					{
						JOptionPane.showMessageDialog(Ex3PersonTable.this, "나이를 입력해주세요");
						return;
					}else {
						age = Integer.parseInt(text_age);	
					} 
					
					String hp = tfHp.getText();
					if(hp.length()==0)
					{
						JOptionPane.showConfirmDialog(Ex3PersonTable.this, "전번을 입력하세요.");
						return;
					}
					
					//insert 메서드 호출
					personModel.insertPerson(new PersonDto(name, blood, age, hp));
					//전체 데이터 다시 출력
					rowSelect();
					//입력한 데이터 초기화
					tfName.setText("");
					tfBlood.setText("");
					tfAge.setText("");
					tfHp.setText("");
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
						JOptionPane.showMessageDialog(Ex3PersonTable.this, "삭제할 행을 먼저 선택해주세요");
						return;
					}
					
					int num = Integer.parseInt(table.getValueAt(row, 0).toString());
					personModel.deletePerson(num);
					rowSelect();
				}
			});
		}
		
		public void rowSelect() {
			//기존 테이블의 데이터는 모두 삭제
			tableModel.setRowCount(0);
			
			//db의 모든 데이터 가져오기
			List<Vector<String>> list = personModel.getAllDatas();
			for (Vector<String> data:list)
			{
				tableModel.addRow(data);
			}
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonTable ex3 = new Ex3PersonTable();
	}

}
