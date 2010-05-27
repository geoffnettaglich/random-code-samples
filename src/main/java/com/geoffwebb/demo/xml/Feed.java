package com.geoffwebb.demo.xml;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("feed")
public class Feed {

	@XStreamAlias("title")
	String title;

	@XStreamAlias("description")
	String description;

	@XStreamImplicit(itemFieldName = "item")
	List<FeedItem> items;

	public List<FeedItem> getItems() {
		return items;
	}

	public void setItems(List<FeedItem> items) {
		this.items = items;
	}

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
