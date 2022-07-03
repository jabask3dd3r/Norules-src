package com.viaversion.viaversion.sponge.platform;

import com.viaversion.viaversion.api.platform.*;
import org.spongepowered.api.scheduler.*;

public class SpongeViaTask implements PlatformTask<Task>
{
    private final /* synthetic */ Task task;
    
    @Override
    public Task getObject() {
        return this.task;
    }
    
    @Override
    public void cancel() {
        this.task.cancel();
    }
    
    public SpongeViaTask(final Task lllllllllllllIIlIIlIlIIIIIIIIIlI) {
        this.task = lllllllllllllIIlIIlIlIIIIIIIIIlI;
    }
}
