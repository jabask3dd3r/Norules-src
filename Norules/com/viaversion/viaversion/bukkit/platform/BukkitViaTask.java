package com.viaversion.viaversion.bukkit.platform;

import com.viaversion.viaversion.api.platform.*;
import org.bukkit.scheduler.*;
import com.google.common.base.*;

public class BukkitViaTask implements PlatformTask<BukkitTask>
{
    private final /* synthetic */ BukkitTask task;
    
    public BukkitViaTask(final BukkitTask lllllllllllllIllIIllIIlIlIllIIll) {
        this.task = lllllllllllllIllIIllIIlIlIllIIll;
    }
    
    @Override
    public void cancel() {
        Preconditions.checkArgument(this.task != null, (Object)"Task cannot be cancelled");
        this.task.cancel();
    }
    
    @Override
    public BukkitTask getObject() {
        return this.task;
    }
}
