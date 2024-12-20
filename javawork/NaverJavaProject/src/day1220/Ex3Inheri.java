package day1220;

import day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem
{
	private String sql;
	
	public DataProcess() {
		// TODO Auto-generated constructor stub
//		sql = "select";
//		this.dbServerName = "Mysql"; //protected 인 경우, 직접 접근 가능 (상속관게에서만)
	}
	
	public DataProcess(String dbServerName, int serverPort, String sql)
	{
		super(dbServerName, serverPort);
		this.sql = sql;
	}
	
	public void process()
	{
//		this.serverStart();
		super.serverStart();
		System.out.println("SQL문 " + sql + "처리함");
		this.serverClose();
		System.out.println();
	}
}
////////////////////////////////////////////
public class Ex3Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataProcess data1 = new DataProcess();
		data1.process();
	
		DataProcess data2 = new DataProcess("mariaDB", 3000, "insert");
		data2.process();
	}

}
