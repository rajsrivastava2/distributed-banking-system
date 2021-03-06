package es.udc.fic.acs.infmsb01.atm.common.model.message.conversor.instance.data;

import java.io.UnsupportedEncodingException;

import es.udc.fic.acs.infmsb01.atm.common.model.message.Message;
import es.udc.fic.acs.infmsb01.atm.common.model.message.code.MessageCode;
import es.udc.fic.acs.infmsb01.atm.common.model.message.conversor.DataResponseMessageConversor;
import es.udc.fic.acs.infmsb01.atm.common.model.message.instance.data.ResponseWithdraw;
import es.udc.fic.acs.infmsb01.atm.common.model.message.protocol.FAPMessage;

public final class ResponseWithdrawConversor extends
		DataResponseMessageConversor {

	public final FAPMessage create(ResponseWithdraw message) {
		FAPMessage newMessage = new FAPMessage();
		
		super.fill(message, newMessage, MessageCode.RESPONSEWITHDRAW);
		
		double balance = message.getAccountBalance();
		newMessage.appendASCIIField(balance >= 0 ? "+" : "-", 1);
		newMessage.appendNumericField(balance, 10, 2);
		
		return newMessage;
	}
	
	public final ResponseWithdraw create(FAPMessage message) throws UnsupportedEncodingException {
		ResponseWithdraw newMessage = new ResponseWithdraw();
		
		super.fill(message, newMessage);
		String sign = message.extractASCIIField(28, 1);
		double balance = Double.parseDouble(message.extractNumericField(29, 10, 2));
		
		if(sign.equals("-")) {
			balance *= -1;
		}
		
		newMessage.setAccountBalance(balance);
		
		return newMessage;
	}

	@Override
	public FAPMessage create(Message message) {
		return create((ResponseWithdraw) message);
	}
	
}
