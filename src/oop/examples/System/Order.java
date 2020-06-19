package oop.examples.System;

public class Order {
	private int id;
	private String text;
	private boolean executed;

	Order(int id, String text){
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	public String toString() {
		return id + " " + text;
	}
	public boolean equals(Object o) { 
		  
	       
		if (o == this) { 
			return true; 
     } 

    
		if (!(o instanceof Order)) { 
			return false; 
     } 
       
		Order or = (Order) o; 
        
		return this.text == or.text;
 }
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((text == null) ? 0 : text.hashCode() + id * id);
	    
	    return result;
	}
	
	
}
