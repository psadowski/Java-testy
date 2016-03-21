package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoMessengerTest {

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "aa";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "aa";

	@Mock
	MessageService msv;
	private Messenger msg;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		msg = new Messenger(msv);
	}

	@Test
	public void NullServerConnectionTest() {
		when(msv.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		verify(msv).checkConnection(null);
	}

	@Test
	public void InvalidServerConnectionTest() {
		when(msv.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(msv).checkConnection(INVALID_SERVER);
	}

	@Test
	public void CorrectServerWithErrorConnectionStatus() {
		when(msv.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(msv).checkConnection(VALID_SERVER);
	}

	@Test
	public void CorretServerConnetionStatus() {
		when(msv.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(msv).checkConnection(VALID_SERVER);
	}

	@Test
	public void NullMsgInvalidServerSendingStatus() throws MalformedRecipientException {
		when(msv.send(INVALID_SERVER2, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER2, null);
		assertEquals(2, result);
		verify(msv).send(INVALID_SERVER2, null);
	}

	@Test
	public void NullServerCorrectMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msv).send(null, VALID_MESSAGE);
	}

	@Test
	public void NullServerInvalidMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(null, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv).send(null, INVALID_MESSAGE);
	}

	@Test
	public void NullServerNMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(null, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, null);
		assertEquals(2, result);
		verify(msv).send(null, null);
	}

	@Test
	public void CorrectWithNoErrorSendingStatus() throws MalformedRecipientException {
		when(msv.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(msv).send(VALID_SERVER, VALID_MESSAGE);
	}

	@Test
	public void CorrectWithSendingErrorSendingStatus() throws MalformedRecipientException {
		when(msv.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(msv).send(VALID_SERVER, VALID_MESSAGE);
	}

	@Test
	public void CorrectServerInvalidMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv).send(VALID_SERVER, INVALID_MESSAGE);
	}

	@Test
	public void NullMsgCorrectServerSendingStatus() throws MalformedRecipientException {
		when(msv.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(msv).send(VALID_SERVER, null);
	}

	@Test
	public void InvalidServerCorrectMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(INVALID_SERVER2, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		verify(msv).send(INVALID_SERVER2, VALID_MESSAGE);
	}

	@Test
	public void InvalidServerNMsgSendingStatus() throws MalformedRecipientException {
		when(msv.send(INVALID_SERVER2, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER2, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(msv).send(INVALID_SERVER2, INVALID_MESSAGE);
	}

	@After
	public void tearDown() throws Exception {
		msg = null;
		msv = null;
	}
}
