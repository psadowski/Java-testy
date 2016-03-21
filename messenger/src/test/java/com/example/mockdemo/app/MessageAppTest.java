package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class MessageAppTest {
	
	private MessageServiceMock msm;
	private Messenger msg;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 ="aa"; 
	
	
	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception {
		msm = new MessageServiceMock();
		msg = new Messenger(msm);
	}
	
	@Test 
	public void CheckShortServerConnection() {
		assertEquals(1, msg.testConnection(INVALID_SERVER2));
	}
	
	@Test
	public void CheckNotPlServerConnection() {
		assertEquals(1, msg.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void CheckCorrectServerConnection() {
		assertEquals(0, msg.testConnection(VALID_SERVER));
	}
	
	@Test
	public void CheckNullServerSendingStatus() {
		assertEquals(2, msg.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void CheckNullMessageSendingStatus() {
		assertEquals(2, msg.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void CheckBothNullSendingStatus() {
		assertEquals(2, msg.sendMessage(null, null));
	}
	
	@Test
	public void CheckNullServerInvalidMsgSendingStatus() {
		assertEquals(2, msg.sendMessage(null, INVALID_MESSAGE));
	}
	
	@Test
	public void CheckNullMsgInvalidServerSendingStatus() {
		assertEquals(2, msg.sendMessage(INVALID_SERVER, null));
	}
	
	@Test
	public void CheckShortMsgSendingStatus() {
		assertEquals(2, msg.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void CheckShortServerSendingStatus() {
		assertEquals(2, msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE));
	}
	
	@Test
	public void CheckInvalidServerSendingStatus() {
		assertEquals(1, msg.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	
	@Test
	public void CheckCorrectSendingStatus() {
		assertThat(msg.sendMessage(VALID_SERVER, VALID_MESSAGE),
				either(equalTo(0)).or(equalTo(1)));
	}

	@After
	public void tearDown() throws Exception {
		msg = null;
		msm = null;
	}
}
