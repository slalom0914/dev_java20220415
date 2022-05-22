package address.view;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();
	private AddressVO inVO = new AddressVO();

	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";

	public AddressCtrl(AddressVO vo) {
		this.inVO = vo;
	}

	public AddressVO send(AddressVO vo) throws Exception {
		String command = inVO.getCommand();

		if (command.equals(_DEL)) {
			DeleteAddrEty delEty = new DeleteAddrEty();
			returnVO = delEty.delete(vo);
		} else if (command.equals(_INS)) {
			RegisterAddrEty insEty = new RegisterAddrEty();
			returnVO = insEty.register(vo);
			//insEty.insertAddress(vo);
		} else if (command.equals(_MOD)) {
			ModifyAddrEty modEty = new ModifyAddrEty();
			returnVO = modEty.modify(vo);
		} else if (command.equals(_SEL)) {
			RetrieveAddrEty selEty = new RetrieveAddrEty();
			returnVO = selEty.retrieve(vo);
		} else
			throw new Exception("잘못된 Command명(" + command + ")입니다.");

		return returnVO;
	}

	public AddressVO[] send() throws Exception {
		String command = inVO.getCommand();

		AddressVO[] returnVOs = null;
		if (command.equals(_ALL)) {

		} else
			throw new Exception("잘못된 List 조회 Command입니다.");

		return returnVOs;
	}
	
}
	
