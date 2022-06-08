package address.view3;

public class CRUDSimulation {

	public static void main(String[] args) {
		CRUDSimulation cs = new CRUDSimulation();
		RegisterAddrEty insEty = new RegisterAddrEty();
		AddressVO pVO = new AddressVO("나신입", "서울시 영등포구 당산동", "010-555-7777"
                                   , "1", "JAVA과정동기", "19900712", "백엔드개발자", "20220325",0);
		insEty.register(pVO);
		if(pVO.getResult() == 1) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");			
		}
	}
}
