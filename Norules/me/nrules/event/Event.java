package me.nrules.event;

import me.nrules.*;
import java.lang.reflect.*;

public abstract class Event
{
    private /* synthetic */ boolean cancelled;
    
    public Event call() {
        this.cancelled = false;
        call(this);
        return this;
    }
    
    private static final void call(final Event llllllllllllllllIIlIlIlllIIIIIIl) {
        final EventManager eventManager = Main.eventManager;
        final ArrayHelper<Data> llllllllllllllllIIlIlIlllIIIIlIl = EventManager.get(llllllllllllllllIIlIlIlllIIIIIIl.getClass());
        if (llllllllllllllllIIlIlIlllIIIIlIl != null) {
            for (final Data llllllllllllllllIIlIlIlllIIIIlII : llllllllllllllllIIlIlIlllIIIIlIl) {
                try {
                    llllllllllllllllIIlIlIlllIIIIlII.target.invoke(llllllllllllllllIIlIlIlllIIIIlII.source, llllllllllllllllIIlIlIlllIIIIIIl);
                }
                catch (IllegalAccessException llllllllllllllllIIlIlIlllIIIIIll) {
                    llllllllllllllllIIlIlIlllIIIIIll.printStackTrace();
                }
                catch (InvocationTargetException llllllllllllllllIIlIlIlllIIIIIlI) {
                    llllllllllllllllIIlIlIlllIIIIIlI.printStackTrace();
                }
            }
        }
    }
    
    public void setCancelled(final boolean llllllllllllllllIIlIlIlllIIIlllI) {
        this.cancelled = llllllllllllllllIIlIlIlllIIIlllI;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public enum State
    {
        PRE("PRE", 0, "PRE", 0), 
        POST("POST", 1, "POST", 1);
        
        private State(final String lllllllllllllllIlIlIllIIIIlIIlIl, final int lllllllllllllllIlIlIllIIIIlIIIll, final String lllllllllllllllIlIlIllIIIIlIlIll, final int lllllllllllllllIlIlIllIIIIlIlIIl) {
        }
    }
}
