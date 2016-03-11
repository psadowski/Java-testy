package Lab4.MP3Player;

import java.util.ArrayList;

public class Mp3PlayerMock implements Mp3Player {
	
	public ArrayList songList;
	private int currentSong = 0;
	private boolean isPlaying;
	private int songTime;
	
	public void play() {
		if(songList != null){
			isPlaying = true;
			songTime = 1;
		}

	}

	public void pause() {
		isPlaying = false;

	}

	public void stop() {
		isPlaying = false;
		songTime = 0;
	}

	public int currentPosition() {
		return songTime = 0;
	}

	public String currentSong() {
		if(songList != null)
			return (String) songList.get(currentSong);
		else return null;
	}

	public void next() {
		if(songList.size()-1 != currentSong){
			currentSong ++;
			play();
		} else {
			currentSong = 0;
		}

	}

	public void prev() {
		if(currentSong != 0){
			currentSong --;
			play();
		} else {
			currentSong = (songList.size()-1);
			play();
		}

	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void loadSongs(ArrayList names) {
		songList = names;

	}

}
