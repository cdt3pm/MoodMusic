package spotify.model;

import java.util.List;

public class SearchQuery {
	private Info info;
	private List<Results> tracks;
	
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public List<Results> getTracks() {
		return tracks;
	}
	public void setTracks(List<Results> tracks) {
		this.tracks = tracks;
	}
}
