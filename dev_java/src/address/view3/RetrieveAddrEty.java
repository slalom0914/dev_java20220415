package address.view3;

public class RetrieveAddrEty {
	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO retrieve(AddressVO vo) {
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) 호출 성공");
		AddressVO rVO = null;
		return rVO;
	}
	/***************************************************************************
	 * 회원 목록 보기 구현 - n건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO[] retrieve() {
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");		
		AddressVO[] vos = null;
		return vos;
	}
}

/*
ID,NAME,ADDRESS,TELEPHONE,GENDER,RELATIONSHIP,BIRTHDAY,COMMENTS,REGISTEDATE
3,나초보,서울시 마포구 공덕동,025556968,2,2,19801215,주연테크,REGISTEDATE
1,홍길동,서울시 영등포구 당산동,111,1,동창,19901010,222,20081117
2,이순신,서울시 서초구 양재동,222,2,회사동료,19901110,333,20100113
4,강감찬,경기도 광명시,11,1,동창,19801120,테스트합니다.,2011-03-20
9,나초조,4455,44455,1,44555,19800702,자영업,20110320
7,223,223,223,2,223,223,223,20190609
10,조조,경기도 화성시,44455,1,44555,19800702,자영업,20110320
*/