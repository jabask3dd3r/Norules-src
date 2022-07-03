package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.entity.*;

public class EventAttack extends Event
{
    private final /* synthetic */ Entity targetEntity;
    
    public EventAttack(final Entity lllllllllllllIllllIIlIlIIlIIlIll) {
        this.targetEntity = lllllllllllllIllllIIlIlIIlIIlIll;
    }
    
    public Entity getTargetEntity() {
        return this.targetEntity;
    }
}
