package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.entity.*;

public class EventNameTags extends Event
{
    private /* synthetic */ String renderedName;
    private final /* synthetic */ EntityLivingBase entity;
    
    public void setRenderedName(final String lllllllllllllIllIllllIIllIIllIII) {
        this.renderedName = lllllllllllllIllIllllIIllIIllIII;
    }
    
    public String getRenderedName() {
        return this.renderedName;
    }
    
    public EventNameTags(final EntityLivingBase lllllllllllllIllIllllIIllIllIIII, final String lllllllllllllIllIllllIIllIllIlII) {
        this.entity = lllllllllllllIllIllllIIllIllIIII;
        this.renderedName = lllllllllllllIllIllllIIllIllIlII;
    }
    
    public EntityLivingBase getEntity() {
        return this.entity;
    }
}
