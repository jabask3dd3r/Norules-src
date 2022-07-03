package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;

public class ScalarNode extends Node
{
    private /* synthetic */ String value;
    private /* synthetic */ DumperOptions.ScalarStyle style;
    
    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }
    
    @Deprecated
    public Character getStyle() {
        return this.style.getChar();
    }
    
    @Deprecated
    public ScalarNode(final Tag lllllllllllllIIIIIllIlllIIIlIlIl, final String lllllllllllllIIIIIllIlllIIIIlllI, final Mark lllllllllllllIIIIIllIlllIIIIllIl, final Mark lllllllllllllIIIIIllIlllIIIlIIlI, final Character lllllllllllllIIIIIllIlllIIIlIIIl) {
        this(lllllllllllllIIIIIllIlllIIIlIlIl, lllllllllllllIIIIIllIlllIIIIlllI, lllllllllllllIIIIIllIlllIIIIllIl, lllllllllllllIIIIIllIlllIIIlIIlI, DumperOptions.ScalarStyle.createStyle(lllllllllllllIIIIIllIlllIIIlIIIl));
    }
    
    @Override
    public NodeId getNodeId() {
        return NodeId.scalar;
    }
    
    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("<").append(this.getClass().getName()).append(" (tag=").append(this.getTag()).append(", value=").append(this.getValue()).append(")>"));
    }
    
    public ScalarNode(final Tag lllllllllllllIIIIIllIlllIIllllII, final String lllllllllllllIIIIIllIlllIIllIlIl, final Mark lllllllllllllIIIIIllIlllIIlllIlI, final Mark lllllllllllllIIIIIllIlllIIllIIll, final DumperOptions.ScalarStyle lllllllllllllIIIIIllIlllIIlllIII) {
        this(lllllllllllllIIIIIllIlllIIllllII, true, lllllllllllllIIIIIllIlllIIllIlIl, lllllllllllllIIIIIllIlllIIlllIlI, lllllllllllllIIIIIllIlllIIllIIll, lllllllllllllIIIIIllIlllIIlllIII);
    }
    
    public ScalarNode(final Tag lllllllllllllIIIIIllIlllIIlIIIlI, final boolean lllllllllllllIIIIIllIlllIIlIIIIl, final String lllllllllllllIIIIIllIlllIIlIIlll, final Mark lllllllllllllIIIIIllIlllIIlIIllI, final Mark lllllllllllllIIIIIllIlllIIIllllI, final DumperOptions.ScalarStyle lllllllllllllIIIIIllIlllIIIlllIl) {
        super(lllllllllllllIIIIIllIlllIIlIIIlI, lllllllllllllIIIIIllIlllIIlIIllI, lllllllllllllIIIIIllIlllIIIllllI);
        if (lllllllllllllIIIIIllIlllIIlIIlll == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = lllllllllllllIIIIIllIlllIIlIIlll;
        if (lllllllllllllIIIIIllIlllIIIlllIl == null) {
            throw new NullPointerException("Scalar style must be provided.");
        }
        this.style = lllllllllllllIIIIIllIlllIIIlllIl;
        this.resolved = lllllllllllllIIIIIllIlllIIlIIIIl;
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Deprecated
    public ScalarNode(final Tag lllllllllllllIIIIIllIllIlllllIll, final boolean lllllllllllllIIIIIllIlllIIIIIIIl, final String lllllllllllllIIIIIllIlllIIIIIIII, final Mark lllllllllllllIIIIIllIllIlllllIII, final Mark lllllllllllllIIIIIllIllIlllllllI, final Character lllllllllllllIIIIIllIllIllllllIl) {
        this(lllllllllllllIIIIIllIllIlllllIll, lllllllllllllIIIIIllIlllIIIIIIIl, lllllllllllllIIIIIllIlllIIIIIIII, lllllllllllllIIIIIllIllIlllllIII, lllllllllllllIIIIIllIllIlllllllI, DumperOptions.ScalarStyle.createStyle(lllllllllllllIIIIIllIllIllllllIl));
    }
}
