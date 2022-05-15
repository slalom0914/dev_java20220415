package test.kh0518;

import java.util.List;
import java.util.Vector;


public class Q7 {
	List<String> list2 = new Vector<>();
	public void setList2() {
		// list2가 가리키는 벡터에 파라미터에 있는 문자열 추가하기
		list2.add("이순신");
		list2.add("강감찬");
		list2.add("김유신");
	}

	public void list2_Print() {
		list2.add(1, "토마토");
		// 0번째 있던 이순신을 바나나로 변경
		list2.set(0, "바나나");
		// index가 2인 그러니까 세번째 있는 원소를 제거함
		list2.remove(2);
		// list2의 세번째 원소의 값 읽어오기
		System.out.println("list2의 세번째 원소의 값 읽어오기 : "+list2.get(2));
		// list2에 들어 있는 원소의 수
		System.out.println("list2.size() ==> "+list2.size());
		for (int i = 0; i < list2.size(); i++) {
			String name = list2.get(i);
			System.out.println(name);
		}
	}

	public static void main(String[] args) {
		Q7 lt = new Q7();
		lt.setList2();
		lt.list2_Print();
	}

}
