package com.geoffwebb.demo.cache;

public class CacheableService
{

    public static int THINGS_CREATED = 0;

    public Thing thingMaker(String name)
    {
        return makeThing(name);
    }
    
    public int thingsMade()
    {
        return THINGS_CREATED;
    }

    public void reset()
    {
        THINGS_CREATED = 0;
    }

    private Thing makeThing(String name)
    {
        THINGS_CREATED++;
        return new Thing(name);
    }
}
