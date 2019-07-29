package com.geoffwebb.demo.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/application-context.xml",
    "classpath:/cache-context.xml" })
public class CacheableServiceTest
{
    @Resource(name="cachedService")
    private CacheableService cachedService;

    @Resource(name="uncachedService")
    private CacheableService uncachedService;

    @Before
    public void resetCounters()
    {
        cachedService.reset();
        uncachedService.reset();
    }

    @Test
    public void checkCaching()
    {
        // If we call the same method with the same args ...
        Thing thing = cachedService.thingMaker("test");
        Thing otherThing = cachedService.thingMaker("test");

        // we should get the same object returned
        Assert.assertTrue(thing.equals(otherThing));
        Assert.assertEquals(1, cachedService.thingsMade());
    }

    @Test
    public void checkNormal()
    {
        // if we call the non-cached method with the same args ...
        Thing thing = uncachedService.thingMaker("test");
        Thing otherThing = uncachedService.thingMaker("test");

        // we should get the different object returned
        Assert.assertFalse(thing.equals(otherThing));
        Assert.assertEquals(2, uncachedService.thingsMade());

        // but they should have the same name
        Assert.assertEquals(thing.getName(), otherThing.getName());
    }
}
