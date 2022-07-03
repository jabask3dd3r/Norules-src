package com.viaversion.viaversion.velocity.platform;

import com.viaversion.viaversion.api.platform.*;
import com.velocitypowered.api.scheduler.*;

public class VelocityViaTask implements PlatformTask<ScheduledTask>
{
    private final /* synthetic */ ScheduledTask task;
    
    public VelocityViaTask(final ScheduledTask lllllllllllllllIIIIIlIIIIlllIIIl) {
        this.task = lllllllllllllllIIIIIlIIIIlllIIIl;
    }
    
    @Override
    public void cancel() {
        this.task.cancel();
    }
    
    @Override
    public ScheduledTask getObject() {
        return this.task;
    }
}
