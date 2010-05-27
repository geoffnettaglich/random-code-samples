package com.geoffwebb.demo.xml;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/application-context.xml" })
public class XmlMungerTest
{

    @Autowired
    private XmlMunger xmlMunger;

    @Test
    public void testXmlParsing()
    {
        Feed output = xmlMunger.parseFeed(INPUT_XML);

        Assert.assertNotNull(output);
        Assert.assertEquals(FEED_TITLE, output.getTitle());
        Assert.assertEquals(FEED_DESC, output.getDescription());
        Assert.assertEquals(1, output.items.size());

        FeedItem item = output.items.get(0);
        Assert.assertEquals(ITEM_TITLE, item.getTitle());
        Assert.assertEquals(ITEM_DESC, item.getDescription());
    }

    private static final String FEED_TITLE = "Interesting news";
    private static final String FEED_DESC  = "fun stuff";
    private static final String ITEM_TITLE = "Item 1";
    private static final String ITEM_DESC  = "Item 1 is really good";

    private static final String INPUT_XML  = "<feed>" + "<title>" + FEED_TITLE
                                               + "</title>" + "<description>"
                                               + FEED_DESC + "</description>"
                                               + "<item>" + "	<title>"
                                               + ITEM_TITLE + "</title>"
                                               + "	<desc>" + ITEM_DESC
                                               + "</desc>" + "</item>"
                                               + "</feed>";
}
