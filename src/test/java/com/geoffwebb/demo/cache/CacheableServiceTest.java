package com.geoffwebb.demo.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/application-context.xml",
    "classpath:/cache-context.xml" })
public class CacheableServiceTest
{
    @Autowired
    protected CacheableService cacheableService;

    @Before
    public void resetCounters()
    {
        cacheableService.reset();
    }

    @Test
    public void checkCaching()
    {
        // If we call the same method with the same args ...
        Thing thing = cacheableService.cacheableThingMaker("test");
        Thing otherThing = cacheableService.cacheableThingMaker("test");

        // we should get the same object returned
        Assert.assertTrue(thing.equals(otherThing));
        Assert.assertEquals(1, cacheableService.thingsMade());
    }

    @Test
    public void checkNormal()
    {
        // if we call the non-cached method with the same args ...
        Thing thing = cacheableService.thingMaker("test");
        Thing otherThing = cacheableService.thingMaker("test");

        // we should get the different object returned
        Assert.assertFalse(thing.equals(otherThing));
        Assert.assertEquals(2, cacheableService.thingsMade());

        // but they should have the same name
        Assert.assertEquals(thing.getName(), otherThing.getName());
    }
}
