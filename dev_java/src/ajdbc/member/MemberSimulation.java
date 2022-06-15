package ajdbc.member;

public class MemberSimulation {

	public static void main(String[] args) {
		MemberShip ms = new MemberShip();
		boolean isOk = ms.idCheck("tomato");
		System.out.println(isOk);
		int result = ms.memberInsert(null);
		System.out.println("result ==> "+result);
	}

}
