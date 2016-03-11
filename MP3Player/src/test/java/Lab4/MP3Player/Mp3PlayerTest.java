package Lab4.MP3Player;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class Mp3PlayerTest {

	private Mp3Player mp3;
	private ArrayList list = new ArrayList();

	@Before
	public void setUp() {
	mp3 = new Mp3PlayerMock();
	list = new ArrayList();
	list.add("Bill Chase −− Open Up Wide");
	list.add("Jethro Tull −− Locomotive Breath");
	list.add("The Boomtown Rats −− Monday");
	list.add("Carl Orff −− O Fortuna");
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(list);
		assertThat(mp3.currentSong(),notNullValue());
		
		
		mp3.play();
		assertThat(mp3.isPlaying(), equalTo(true));
		assertThat(mp3.currentSong(), equalTo(list.get(0)));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		
		mp3.pause();
		assertThat(mp3.isPlaying(), equalTo(false));
		assertThat(mp3.currentSong(), equalTo(list.get(0)));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		
		mp3.stop();
		assertThat(mp3.isPlaying(), equalTo(false));
		assertThat(mp3.currentSong(), equalTo(list.get(0)));
		assertThat(mp3.currentPosition(), equalTo(0));
	}

	@Test
	public void testPlayNoList() {
		assertThat(mp3.currentSong(),equalTo(null));
		
		mp3.play();
		assertThat(mp3.isPlaying(), equalTo(false));
		assertThat(mp3.currentSong(), equalTo(null));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		
		mp3.pause();
		assertThat(mp3.isPlaying(), equalTo(false));
		assertThat(mp3.currentSong(), equalTo(null));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		
		mp3.stop();
		assertThat(mp3.isPlaying(), equalTo(false));
		assertThat(mp3.currentSong(), equalTo(null));
		assertThat(mp3.currentPosition(), equalTo(0));
	}

	@Test
	public void testAdvance() {
		mp3.loadSongs(list);
		mp3.play();
		assertThat(mp3.isPlaying(), equalTo(true));
		assertThat(mp3.currentSong(), equalTo(list.get(0)));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		
		mp3.prev();
		assertThat(mp3.isPlaying(), equalTo(true));
		assertThat(mp3.currentSong(), equalTo(list.get(3)));
		assertThat(mp3.currentPosition(), equalTo(0));
		
		mp3.next();
		assertThat(mp3.currentSong(), is(equalTo(list.get(0))));
		
		mp3.next();
		assertThat(mp3.currentSong(), equalTo(list.get(1)));
		
		mp3.prev();
		assertThat(mp3.currentSong(), equalTo(list.get(0)));
		
		mp3.next();
		assertThat(mp3.currentSong(), equalTo(list.get(1)));
		
		mp3.next();
		assertThat(mp3.currentSong(), equalTo(list.get(2)));
		
		mp3.next();
		assertEquals(list.get(3), mp3.currentSong());
		assertEquals(0, mp3.currentPosition());
		assertTrue(mp3.isPlaying());
	}

	@After
	public void teardown() {
		mp3 = null;
		list = null;
	}

}
