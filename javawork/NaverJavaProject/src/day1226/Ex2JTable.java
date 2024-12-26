package day1226;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame {
    
    private JTable table;
    
    public Ex2JTable() {
        super("JTable 공부");
        this.setBounds(300, 100, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼 클릭시 종료
        this.initDesign();
        this.setVisible(true);
    }
    
    public void initDesign() {
        Vector<String> title = new Vector<String>();
        title.add("이름");
        title.add("혈액형");
        title.add("나이");
        
        //벡터 내부에 벡터가 존재하므로 행과 열을 가진 자료형이 만들어진다
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        
        Vector<String> row1 = new Vector<String>();
        row1.add("이미자");
        row1.add("AB");
        row1.add("23");
        data.add(row1);

        Vector<String> row2 = new Vector<String>();
        row2.add("손기자");
        row2.add("A");
        row2.add("34");
        data.add(row2);

        Vector<String> row3 = new Vector<String>();
        row3.add("박민영");
        row3.add("B");
        row3.add("19");
        data.add(row3);

        //table 생성
        table = new JTable(data, title);
        
        this.add("North", new JLabel("데이터출력테이블", JLabel.CENTER));
        this.add("Center", new JScrollPane(table));
    }
    
    public static void main(String[] args) {
        new Ex2JTable();
    }
}
