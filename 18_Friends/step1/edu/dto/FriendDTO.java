package com.edu.dto;

public class FriendDTO {
	private String name;
	private String jumin1;
	private String jumin2;
	private String tel1;
	private String tel2;
	private String tel3;
	private int gender;
	private int read;
	private int movie;
	private int music;
	private int game;
	private int shopping;

	public FriendDTO() {

	}

	public FriendDTO(String name, String jumin1, String jumin2, String tel1, String tel2, String tel3, int gender,
			int read, int movie, int music, int game, int shopping) {
		super();
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.gender = gender;
		this.read = read;
		this.movie = movie;
		this.music = music;
		this.game = game;
		this.shopping = shopping;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getMovie() {
		return movie;
	}

	public void setMovie(int movie) {
		this.movie = movie;
	}

	public int getMusic() {
		return music;
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public int getShopping() {
		return shopping;
	}

	public void setShopping(int shopping) {
		this.shopping = shopping;
	}

}
