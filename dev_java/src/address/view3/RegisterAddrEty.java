package address.view3;

public class RegisterAddrEty {
    /****************************************************************************
     * 회원등록 구현
	   INSERT INTO mkaddrtb(id, name, address, telephone
                          , gender, relationship, birthday
                          , comments, registedate)
                     values(11,'나신입','서울시 강남구 대치동','0105557777'
                           ,1, '회사동료', '1999-10-27'
                           ,'Front-End개발자', '2022-04-16')
     * @param vo - 사용자가 입력한 값 담기
     * @return - 등록 성공 여부 담기
     ***************************************************************************/
	public AddressVO register(AddressVO vo) {
		System.out.println("RegisterAddrEty register 호출 성공");
		return vo;
	}

}
