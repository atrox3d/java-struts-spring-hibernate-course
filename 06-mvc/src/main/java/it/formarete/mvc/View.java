package it.formarete.mvc;

public class View implements ISubscriber {

	private String html;
	
	public View() {
		html = "<h1>hello nobody</h1>";
	}
	
	public void wakeUp(Publisher model, String attribute) {
		html = "<h1>hello " + attribute + "!</h1>";
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
