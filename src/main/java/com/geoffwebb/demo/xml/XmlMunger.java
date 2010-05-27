package com.geoffwebb.demo.xml;

import com.thoughtworks.xstream.XStream;

public class XmlMunger {

	private XStream xstream = new XStream();
	
	public XmlMunger() {
		// make sure we bootstrap the annotation management
		xstream.processAnnotations(Feed.class);
		xstream.processAnnotations(FeedItem.class);
	}
	
	public Feed parseFeed(String input) {		
		return (Feed) xstream.fromXML(input);
	}
}
