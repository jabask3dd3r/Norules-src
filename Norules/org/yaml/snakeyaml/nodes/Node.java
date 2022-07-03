package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.error.*;

public abstract class Node
{
    private /* synthetic */ String anchor;
    protected /* synthetic */ Boolean useClassConstructor;
    protected /* synthetic */ Mark endMark;
    private /* synthetic */ Tag tag;
    private /* synthetic */ Mark startMark;
    private /* synthetic */ Class<?> type;
    private /* synthetic */ boolean twoStepsConstruction;
    protected /* synthetic */ boolean resolved;
    
    public Tag getTag() {
        return this.tag;
    }
    
    public Mark getStartMark() {
        return this.startMark;
    }
    
    public String getAnchor() {
        return this.anchor;
    }
    
    public void setAnchor(final String lllllllllllllIIllIIllIIlllIIIllI) {
        this.anchor = lllllllllllllIIllIIllIIlllIIIllI;
    }
    
    public void setTag(final Tag lllllllllllllIIllIIllIIlllllIllI) {
        if (lllllllllllllIIllIIllIIlllllIllI == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.tag = lllllllllllllIIllIIllIIlllllIllI;
    }
    
    public boolean useClassConstructor() {
        if (this.useClassConstructor == null) {
            return (!this.tag.isSecondary() && this.resolved && !Object.class.equals(this.type) && !this.tag.equals(Tag.NULL)) || this.tag.isCompatible(this.getType());
        }
        return this.useClassConstructor;
    }
    
    public Class<?> getType() {
        return this.type;
    }
    
    public boolean isTwoStepsConstruction() {
        return this.twoStepsConstruction;
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    public void setTwoStepsConstruction(final boolean lllllllllllllIIllIIllIIlllIlllll) {
        this.twoStepsConstruction = lllllllllllllIIllIIllIIlllIlllll;
    }
    
    @Deprecated
    public boolean isResolved() {
        return this.resolved;
    }
    
    public abstract NodeId getNodeId();
    
    public Node(final Tag lllllllllllllIIllIIllIlIIIIIlIIl, final Mark lllllllllllllIIllIIllIlIIIIIlIII, final Mark lllllllllllllIIllIIllIlIIIIIIlll) {
        this.setTag(lllllllllllllIIllIIllIlIIIIIlIIl);
        this.startMark = lllllllllllllIIllIIllIlIIIIIlIII;
        this.endMark = lllllllllllllIIllIIllIlIIIIIIlll;
        this.type = Object.class;
        this.twoStepsConstruction = false;
        this.resolved = true;
        this.useClassConstructor = null;
    }
    
    public void setUseClassConstructor(final Boolean lllllllllllllIIllIIllIIlllIlIIlI) {
        this.useClassConstructor = lllllllllllllIIllIIllIIlllIlIIlI;
    }
    
    public void setType(final Class<?> lllllllllllllIIllIIllIIllllIIlll) {
        if (!lllllllllllllIIllIIllIIllllIIlll.isAssignableFrom(this.type)) {
            this.type = lllllllllllllIIllIIllIIllllIIlll;
        }
    }
    
    @Override
    public final boolean equals(final Object lllllllllllllIIllIIllIIllllIlllI) {
        return super.equals(lllllllllllllIIllIIllIIllllIlllI);
    }
    
    public Mark getEndMark() {
        return this.endMark;
    }
}
