package es.udc.fic.acs.infmsb01.atm.common.model.message.code;

public enum MessageCode {

	REQUESTRECOVERY((byte)1),
	REQUESTENDRECOVERY((byte)2),
	RESPONSEOPENSESSION((byte)11),
	RESPONSECLOSESESSION((byte)12),
	RESPONSESTOPTRAFFIC((byte)13),
	RESPONSERESTARTTRAFFIC((byte)14),
	REQUESTCHECKBALANCE((byte)31),
	REQUESTACCOUNTMOVEMENTS((byte)32),
	REQUESTDEPOSIT((byte)33),
	REQUESTWITHDRAW((byte)34),
	REQUESTACCOUNTSTRANSFER((byte)35),
	RESPONSECHECKBALANCE((byte)61),
	RESPONSEACCOUNTMOVEMENTS((byte)62),
	RESPONSEDEPOSIT((byte)63),
	RESPONSEWITHDRAW((byte)64),
	RESPONSEACCOUNTSTRANSFER((byte)65),
	REQUESTOPENSESSION((byte)81),
	REQUESTCLOSESESSION((byte)82),
	REQUESTSTOPTRAFFIC((byte)83),
	REQUESTRESTARTTRAFFIC((byte)84),
	RESPONSERECOVERY((byte)91),
	RESPONSEENDRECOVERY((byte)92);
	
	private byte code;
	
	private MessageCode(byte code) {
		this.code = code;
	}
	
	public byte getCode() {
		return code;
	}
	
}
