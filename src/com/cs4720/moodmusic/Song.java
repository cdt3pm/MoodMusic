package com.cs4720.moodmusic;

public class Song {

	private String title;
	private String artist;
	private String album;
	private int id;
	
	public Song() {
		this.title = "";
		this.artist = "";
		this.album = "";
		this.id = 0;
	}
	
	public Song(String title, String artist, String album, int id) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Title: " + this.title + " Artist: " + this.artist + " Album: " + this.album;
	}
	
}
