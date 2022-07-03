package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;

public final class ScalarEvent extends NodeEvent
{
    private final /* synthetic */ ImplicitTuple implicit;
    private final /* synthetic */ DumperOptions.ScalarStyle style;
    private final /* synthetic */ String tag;
    private final /* synthetic */ String value;
    
    @Deprecated
    public ScalarEvent(final String lllllllllllllllllIllllIlIIIlIlII, final String lllllllllllllllllIllllIlIIIllIll, final ImplicitTuple lllllllllllllllllIllllIlIIIlIIlI, final String lllllllllllllllllIllllIlIIIlIIIl, final Mark lllllllllllllllllIllllIlIIIlIIII, final Mark lllllllllllllllllIllllIlIIIIllll, final Character lllllllllllllllllIllllIlIIIlIllI) {
        this(lllllllllllllllllIllllIlIIIlIlII, lllllllllllllllllIllllIlIIIllIll, lllllllllllllllllIllllIlIIIlIIlI, lllllllllllllllllIllllIlIIIlIIIl, lllllllllllllllllIllllIlIIIlIIII, lllllllllllllllllIllllIlIIIIllll, DumperOptions.ScalarStyle.createStyle(lllllllllllllllllIllllIlIIIlIllI));
    }
    
    public ScalarEvent(final String lllllllllllllllllIllllIlIIlIllII, final String lllllllllllllllllIllllIlIIlIlIll, final ImplicitTuple lllllllllllllllllIllllIlIIllIIlI, final String lllllllllllllllllIllllIlIIllIIIl, final Mark lllllllllllllllllIllllIlIIllIIII, final Mark lllllllllllllllllIllllIlIIlIllll, final DumperOptions.ScalarStyle lllllllllllllllllIllllIlIIlIIllI) {
        super(lllllllllllllllllIllllIlIIlIllII, lllllllllllllllllIllllIlIIllIIII, lllllllllllllllllIllllIlIIlIllll);
        this.tag = lllllllllllllllllIllllIlIIlIlIll;
        this.implicit = lllllllllllllllllIllllIlIIllIIlI;
        if (lllllllllllllllllIllllIlIIllIIIl == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = lllllllllllllllllIllllIlIIllIIIl;
        if (lllllllllllllllllIllllIlIIlIIllI == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = lllllllllllllllllIllllIlIIlIIllI;
    }
    
    @Override
    public ID getEventId() {
        return ID.Scalar;
    }
    
    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }
    
    @Deprecated
    public Character getStyle() {
        return this.style.getChar();
    }
    
    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    @Override
    protected String getArguments() {
        return String.valueOf(new StringBuilder().append(super.getArguments()).append(", tag=").append(this.tag).append(", ").append(this.implicit).append(", value=").append(this.value));
    }
    
    public String getValue() {
        return this.value;
    }
    
    public ImplicitTuple getImplicit() {
        return this.implicit;
    }
}
