package ViaMCP.minecraft.viamcp1_12.utils;

import com.viaversion.viaversion.api.platform.*;
import java.util.concurrent.*;

public class FutureTaskId implements PlatformTask<Future<?>>
{
    private final /* synthetic */ Future<?> object;
    
    @Override
    public void cancel() {
        this.object.cancel(false);
    }
    
    @Override
    public Future<?> getObject() {
        return this.object;
    }
    
    public FutureTaskId(final Future<?> llllllllllllllIIlIllllllllIIlIll) {
        this.object = llllllllllllllIIlIllllllllIIlIll;
    }
}
