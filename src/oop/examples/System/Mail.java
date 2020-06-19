package oop.examples.System;

public class Mail {

	private String text;
	private String theme;
	private Boolean read;
	
	Mail(String text,String theme,Boolean read){
		this.text=text;
		this.theme=theme;
		this.read=read;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public void read(){

	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(!(obj instanceof Mail))
			return false;
		Mail m = (Mail) obj;
		return this.text.equals(m.text);
	}

//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((date == null) ? 0 : date.hashCode() + roomNumber * roomNumber + duration * duration);
//		return result;
//	}
}

