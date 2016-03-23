package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockMessengerTest {

	private Messenger msg;
	private MessageService msv;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "aaa";

	private final String VALID_MESSAGE = "correct message";
	private final String INVALID_MESSAGE = "aa";

	@Before
	public void setUp() throws Exception {
		msv = mock(MessageService.class);
		msg = new Messenger(msv);
	}

	@Test
	public void NullServerConnectionStatus() {
		expect(msv.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		replay(msv);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		verify(msv);
	}

	@Test
	public void CorrectSendingStatus() throws MalformedRecipientException {
		expect(msv.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		replay(msv);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(msv);
	}

	@Test
	public void CorrectServerConnectionStatus() {
		expect(msv.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(msv);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(msv);
	}

	@Test
	public void CorrectServerWithErrorConnectionStatus() {
		expect(msv.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(msv);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(msv);
	}

	@Test
	public void InvalidServerConnectionStatus() {
		expect(msv.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(msv);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(msv);
	}

	@Test
	public void CorrectWithErrorSendingStatus() throws MalformedRecipientException {
		expect(msv.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(msv);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(msv);
	}

	@Test
	public void NullServerInvalidMsgSendingStatus() throws MalformedRecipientException {
		expect(msv.send(null, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void BothNullSendingStatus() throws MalformedRecipientException {
		expect(msv.send(null, null)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void InvalidServerSendingStatus() throws MalformedRecipientException {
		expect(msv.send(INVALID_SERVER2, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void InvalidServerNMsgSendingStatus() throws MalformedRecipientException {
		expect(msv.send(INVALID_SERVER2, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(INVALID_SERVER2, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void InvalidServerNullMsgSendingStatus() throws MalformedRecipientException {
		expect(msv.send(INVALID_SERVER2, null)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(INVALID_SERVER2, null);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void CorrectServerInvalidMessageSendingStatus() throws MalformedRecipientException {
		expect(msv.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void CorrectServerNullMsgSendingStatus() throws MalformedRecipientException {
		expect(msv.send(VALID_SERVER, null)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(msv);
	}

	@Test
	public void CorrectMsgNullServerSendingStatus() throws MalformedRecipientException {
		expect(msv.send(null, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(msv);
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msv);
	}

	@After
	public void tearDown() throws Exception {
		msg = null;
		msv = null;
	}

}
