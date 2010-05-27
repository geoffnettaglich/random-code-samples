package com.geoffwebb.demo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class FeedItem {

	@XStreamAlias("title")
	String title;
	
	@XStreamAlias("desc")
	String description;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
