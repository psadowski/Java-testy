import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class PersonDatabaseTest {

	
	@Mock
	PersonDatabaseService service;
	private PersonMockServiceImpl serv;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		serv = new PersonMockServiceImpl();
		serv.setService(service);
	}

	@After
	public void tearDown() throws Exception {
		service=null;
		serv=null;		
	}

	@Test
	public void CorrectTestAdd() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.AddPerson(person)).thenReturn(new Integer(1));
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		verify(service).AddPerson(person);
	}
	
	@Test
	public void WrongTestAdd() throws SQLException, PersonException {
		Person person = new Person(1,"Adam","Nowak",2500);
		when(service.AddPerson(person)).thenReturn(new Integer(0));
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		verify(service).AddPerson(person);
	}
	
	@Test(expected=PersonException.class)
	public void ExceptionTestAdd() throws SQLException, PersonException{
		Person person = new Person();
		when(service.AddPerson(person)).thenThrow(new SQLException());
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		verify(service).AddPerson(person);
	}
	
	@Test
	public void CorrectTestRemove() throws SQLException, PersonException {
		int id = 1;
		when(service.remove(id)).thenReturn(new Integer(1));
		boolean result = serv.remove(id);
		assertTrue(result);
		verify(service).remove(id);
	}
	
	@Test
	public void WrongTestRemove() throws SQLException, PersonException {
		int id = 0;
		when(service.remove(id)).thenReturn(new Integer(0));
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}
	
	
	@Test(expected=PersonException.class)
	public void ExceptionTestRemove() throws SQLException, PersonException{
		int id = 0;
		when(service.remove(id)).thenThrow(new SQLException());
		boolean result = serv.remove(id);
		assertFalse(result);
		verify(service).remove(id);
	}
	
	@Test
	public void CorrectTestUpdate() throws SQLException, PersonException {
		int id = 1;
		when(service.update(id)).thenReturn(new Integer(1));
		boolean result = serv.update(id);
		assertTrue(result);
		verify(service).update(id);
	}
	
	@Test
	public void WrongTestUpdate() throws SQLException, PersonException {
		int id = 0;
		when(service.update(id)).thenReturn(new Integer(0));
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}
	
	
	@Test(expected=PersonException.class)
	public void ExceptionTestUpdate() throws SQLException, PersonException{
		int id = 0;
		when(service.update(id)).thenThrow(new SQLException());
		boolean result = serv.update(id);
		assertFalse(result);
		verify(service).update(id);
	}
	
	@Test
	public void CorrectTestRead() throws SQLException, PersonException {
		int id = 1;
		when(service.read(id)).thenReturn(new Person(1,"Adam","Nowak",2500));
		boolean result = serv.read(id);
		assertTrue(result);
		verify(service).read(id);
	}
	
	@Test
	public void WrongTestRead() throws SQLException, PersonException {
		int id = 0;
		when(service.read(id)).thenReturn(null);
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}
	
	
	@Test(expected=PersonException.class)
	public void ExceptionTestRead() throws SQLException, PersonException{
		int id = 0;
		when(service.read(id)).thenThrow(new SQLException());
		boolean result = serv.read(id);
		assertFalse(result);
		verify(service).read(id);
	}

}
