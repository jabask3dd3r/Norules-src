package com.viaversion.viaversion.bungee.platform;

import com.viaversion.viaversion.api.platform.*;
import net.md_5.bungee.api.scheduler.*;

public class BungeeViaTask implements PlatformTask<ScheduledTask>
{
    private final /* synthetic */ ScheduledTask task;
    
    public BungeeViaTask(final ScheduledTask llllllllllllllllIlIlIlIIIIlIIIIl) {
        this.task = llllllllllllllllIlIlIlIIIIlIIIIl;
    }
    
    @Override
    public ScheduledTask getObject() {
        return this.task;
    }
    
    @Override
    public void cancel() {
        this.task.cancel();
    }
}
