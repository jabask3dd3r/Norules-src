package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public abstract class Event
{
    private final /* synthetic */ Mark endMark;
    private final /* synthetic */ Mark startMark;
    
    public boolean is(final ID lllllllllllllllIlIlIIIIlllIlIIIl) {
        return this.getEventId() == lllllllllllllllIlIlIIIIlllIlIIIl;
    }
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("<").append(this.getClass().getName()).append("(").append(this.getArguments()).append(")>"));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlIlIIIIlllIIlIll) {
        return lllllllllllllllIlIlIIIIlllIIlIll instanceof Event && this.toString().equals(lllllllllllllllIlIlIIIIlllIIlIll.toString());
    }
    
    protected String getArguments() {
        return "";
    }
    
    public Event(final Mark lllllllllllllllIlIlIIIIllllIIlIl, final Mark lllllllllllllllIlIlIIIIllllIIIIl) {
        this.startMark = lllllllllllllllIlIlIIIIllllIIlIl;
        this.endMark = lllllllllllllllIlIlIIIIllllIIIIl;
    }
    
    public Mark getEndMark() {
        return this.endMark;
    }
    
    public Mark getStartMark() {
        return this.startMark;
    }
    
    public abstract ID getEventId();
    
    public enum ID
    {
        StreamEnd, 
        DocumentEnd, 
        SequenceEnd, 
        Alias, 
        DocumentStart, 
        Scalar, 
        MappingStart, 
        MappingEnd, 
        StreamStart, 
        SequenceStart;
    }
}
