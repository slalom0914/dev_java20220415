package aio.step1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCreate {
	String      logPath  = "src\\aio\\step1\\";
	public String setTimer() {
		Calendar cal = Calendar.getInstance();
		int yyyy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH)+1;
		int day =  cal.get(Calendar.DAY_OF_MONTH);
		return yyyy+"-"+
			   (mm < 10 ? "0"+mm:""+mm)+"-"+
			   (day < 10 ? "0"+day:""+day);
	}////////////////end of setTimer	
	public List<Map<String,Object>> getDeptList(){
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("deptno", 10);
		rmap.put("dname", "개발1팀");
		rmap.put("loc", "인천");
		list.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 20);
		rmap.put("dname", "개발2팀");
		rmap.put("loc", "대전");
		list.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 30);
		rmap.put("dname", "공통팀");
		rmap.put("loc", "서울");
		list.add(rmap);
		return list;
	}
	public FileCreate() {
		try {
			String fileName = "log_"+setTimer()+".txt";
			System.out.println(fileName);//log_2020-03-13.txt
			File f = new File(logPath+fileName);
			PrintWriter pw = 
						new PrintWriter(
								new BufferedWriter(//필터클래스-카메라 필터
										new FileWriter(f.getAbsolutePath())));
			//io패키지에는 단독으로 파일을 컨트롤할 수 있는 클래스가 있고
			//그 클래스에 연결해서 사용하는 필터 클래스가 존재함.(기능을 향상해줌)	
			List<Map<String,Object>> list = getDeptList();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<list.size();i++) {
				Map<String,Object> rmap = list.get(i);
				sb.append(rmap.get("deptno").toString()+" "+rmap.get("dname").toString()+" "+rmap.get("loc").toString());
				sb.append("\n");
			}
				pw.write(sb.toString());
				pw.close();//사용한 입출력 클래스는 반드시 닫아줌.			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new FileCreate();
	}

}
