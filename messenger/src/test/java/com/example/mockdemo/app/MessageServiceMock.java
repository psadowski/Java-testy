package com.example.mockdemo.app;
import java.util.Random;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageServiceMock implements MessageService {

	private Random random  = new Random();
	
	@Override
	public ConnectionStatus checkConnection(String server) {
		if (!server.endsWith(".pl")) {
			return ConnectionStatus.FAILURE;
		}
		return ConnectionStatus.SUCCESS;
	}
	
	@Override
	public SendingStatus send(String server, String message)
			throws MalformedRecipientException {

		if (message == null || message.length() < 3)
			throw new MalformedRecipientException();
		
		if (server == null || server.length() < 4)
			throw new MalformedRecipientException();
		
		if (checkConnection(server) == ConnectionStatus.FAILURE) {
			return SendingStatus.SENDING_ERROR;
		}

		if (random.nextBoolean()) {
			return SendingStatus.SENT;
		}
		return SendingStatus.SENDING_ERROR;
	}



}
