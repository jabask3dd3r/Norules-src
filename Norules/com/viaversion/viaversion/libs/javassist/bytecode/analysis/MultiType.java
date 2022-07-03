package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;

public class MultiType extends Type
{
    private /* synthetic */ Type potentialClass;
    private /* synthetic */ Type resolved;
    private /* synthetic */ boolean changed;
    private /* synthetic */ MultiType mergeSource;
    private /* synthetic */ Map<String, CtClass> interfaces;
    
    @Override
    public boolean isArray() {
        return false;
    }
    
    private Map<String, CtClass> mergeMultiInterfaces(final MultiType lllllllllllllIlIIlIlllllllIlIlll, final MultiType lllllllllllllIlIIlIlllllllIllIll) {
        final Map<String, CtClass> lllllllllllllIlIIlIlllllllIllIlI = this.getAllMultiInterfaces(lllllllllllllIlIIlIlllllllIlIlll);
        final Map<String, CtClass> lllllllllllllIlIIlIlllllllIllIIl = this.getAllMultiInterfaces(lllllllllllllIlIIlIlllllllIllIll);
        return this.findCommonInterfaces(lllllllllllllIlIIlIlllllllIllIlI, lllllllllllllIlIIlIlllllllIllIIl);
    }
    
    public MultiType(final Map<String, CtClass> lllllllllllllIlIIllIIIIIIIIllIIl, final Type lllllllllllllIlIIllIIIIIIIIlIlIl) {
        super(null);
        this.changed = false;
        this.interfaces = lllllllllllllIlIIllIIIIIIIIllIIl;
        this.potentialClass = lllllllllllllIlIIllIIIIIIIIlIlIl;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIlIllllllIIllIIl) {
        if (!(lllllllllllllIlIIlIllllllIIllIIl instanceof MultiType)) {
            return false;
        }
        final MultiType lllllllllllllIlIIlIllllllIIlIlll = (MultiType)lllllllllllllIlIIlIllllllIIllIIl;
        if (this.resolved != null) {
            return this.resolved.equals(lllllllllllllIlIIlIllllllIIlIlll.resolved);
        }
        return lllllllllllllIlIIlIllllllIIlIlll.resolved == null && this.interfaces.keySet().equals(lllllllllllllIlIIlIllllllIIlIlll.interfaces.keySet());
    }
    
    @Override
    public boolean isAssignableFrom(final Type lllllllllllllIlIIllIIIIIIIIIIlll) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    private Map<String, CtClass> mergeMultiAndSingle(final MultiType lllllllllllllIlIIlIlllllllIIllIl, final Type lllllllllllllIlIIlIlllllllIIIlll) {
        final Map<String, CtClass> lllllllllllllIlIIlIlllllllIIlIll = this.getAllMultiInterfaces(lllllllllllllIlIIlIlllllllIIllIl);
        final Map<String, CtClass> lllllllllllllIlIIlIlllllllIIlIlI = this.getAllInterfaces(lllllllllllllIlIIlIlllllllIIIlll.getCtClass(), null);
        return this.findCommonInterfaces(lllllllllllllIlIIlIlllllllIIlIll, lllllllllllllIlIIlIlllllllIIlIlI);
    }
    
    private void propogateState() {
        for (MultiType lllllllllllllIlIIlIllllllllllIlI = this.mergeSource; lllllllllllllIlIIlIllllllllllIlI != null; lllllllllllllIlIIlIllllllllllIlI = lllllllllllllIlIIlIllllllllllIlI.mergeSource) {
            lllllllllllllIlIIlIllllllllllIlI.interfaces = this.interfaces;
            lllllllllllllIlIIlIllllllllllIlI.potentialClass = this.potentialClass;
        }
    }
    
    @Override
    public Type merge(final Type lllllllllllllIlIIlIllllllIlIlIlI) {
        if (this == lllllllllllllIlIIlIllllllIlIlIlI) {
            return this;
        }
        if (lllllllllllllIlIIlIllllllIlIlIlI == MultiType.UNINIT) {
            return this;
        }
        if (lllllllllllllIlIIlIllllllIlIlIlI == MultiType.BOGUS) {
            return MultiType.BOGUS;
        }
        if (lllllllllllllIlIIlIllllllIlIlIlI == null) {
            return this;
        }
        if (this.resolved != null) {
            return this.resolved.merge(lllllllllllllIlIIlIllllllIlIlIlI);
        }
        if (this.potentialClass != null) {
            final Type lllllllllllllIlIIlIllllllIllIIll = this.potentialClass.merge(lllllllllllllIlIIlIllllllIlIlIlI);
            if (!lllllllllllllIlIIlIllllllIllIIll.equals(this.potentialClass) || lllllllllllllIlIIlIllllllIllIIll.popChanged()) {
                this.potentialClass = (Type.OBJECT.equals(lllllllllllllIlIIlIllllllIllIIll) ? null : lllllllllllllIlIIlIllllllIllIIll);
                this.changed = true;
            }
        }
        Map<String, CtClass> lllllllllllllIlIIlIllllllIlIllII = null;
        if (lllllllllllllIlIIlIllllllIlIlIlI instanceof MultiType) {
            final MultiType lllllllllllllIlIIlIllllllIllIIIl = (MultiType)lllllllllllllIlIIlIllllllIlIlIlI;
            if (lllllllllllllIlIIlIllllllIllIIIl.resolved != null) {
                final Map<String, CtClass> lllllllllllllIlIIlIllllllIllIIlI = this.mergeMultiAndSingle(this, lllllllllllllIlIIlIllllllIllIIIl.resolved);
            }
            else {
                final Map<String, CtClass> lllllllllllllIlIIlIllllllIllIIII = this.mergeMultiInterfaces(lllllllllllllIlIIlIllllllIllIIIl, this);
                if (!this.inMergeSource(lllllllllllllIlIIlIllllllIllIIIl)) {
                    this.mergeSource = lllllllllllllIlIIlIllllllIllIIIl;
                }
            }
        }
        else {
            lllllllllllllIlIIlIllllllIlIllII = this.mergeMultiAndSingle(this, lllllllllllllIlIIlIllllllIlIlIlI);
        }
        if (lllllllllllllIlIIlIllllllIlIllII.size() > 1 || (lllllllllllllIlIIlIllllllIlIllII.size() == 1 && this.potentialClass != null)) {
            if (lllllllllllllIlIIlIllllllIlIllII.size() != this.interfaces.size()) {
                this.changed = true;
            }
            else if (!this.changed) {
                for (final String lllllllllllllIlIIlIllllllIlIllll : lllllllllllllIlIIlIllllllIlIllII.keySet()) {
                    if (!this.interfaces.containsKey(lllllllllllllIlIIlIllllllIlIllll)) {
                        this.changed = true;
                    }
                }
            }
            this.interfaces = lllllllllllllIlIIlIllllllIlIllII;
            this.propogateState();
            return this;
        }
        if (lllllllllllllIlIIlIllllllIlIllII.size() == 1) {
            this.resolved = Type.get(lllllllllllllIlIIlIllllllIlIllII.values().iterator().next());
        }
        else if (this.potentialClass != null) {
            this.resolved = this.potentialClass;
        }
        else {
            this.resolved = MultiType.OBJECT;
        }
        this.propogateResolved();
        return this.resolved;
    }
    
    private void propogateResolved() {
        for (MultiType lllllllllllllIlIIlIlllllllllIlII = this.mergeSource; lllllllllllllIlIIlIlllllllllIlII != null; lllllllllllllIlIIlIlllllllllIlII = lllllllllllllIlIIlIlllllllllIlII.mergeSource) {
            lllllllllllllIlIIlIlllllllllIlII.resolved = this.resolved;
        }
    }
    
    public boolean isAssignableTo(final Type lllllllllllllIlIIllIIIIIIIIIIIlI) {
        if (this.resolved != null) {
            return lllllllllllllIlIIllIIIIIIIIIIIlI.isAssignableFrom(this.resolved);
        }
        if (Type.OBJECT.equals(lllllllllllllIlIIllIIIIIIIIIIIlI)) {
            return true;
        }
        if (this.potentialClass != null && !lllllllllllllIlIIllIIIIIIIIIIIlI.isAssignableFrom(this.potentialClass)) {
            this.potentialClass = null;
        }
        final Map<String, CtClass> lllllllllllllIlIIllIIIIIIIIIIIIl = this.mergeMultiAndSingle(this, lllllllllllllIlIIllIIIIIIIIIIIlI);
        if (lllllllllllllIlIIllIIIIIIIIIIIIl.size() == 1 && this.potentialClass == null) {
            this.resolved = Type.get(lllllllllllllIlIIllIIIIIIIIIIIIl.values().iterator().next());
            this.propogateResolved();
            return true;
        }
        if (lllllllllllllIlIIllIIIIIIIIIIIIl.size() >= 1) {
            this.interfaces = lllllllllllllIlIIllIIIIIIIIIIIIl;
            this.propogateState();
            return true;
        }
        if (this.potentialClass != null) {
            this.resolved = this.potentialClass;
            this.propogateResolved();
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.resolved != null) {
            return this.resolved.hashCode();
        }
        return this.interfaces.keySet().hashCode();
    }
    
    @Override
    public String toString() {
        if (this.resolved != null) {
            return this.resolved.toString();
        }
        final StringBuffer lllllllllllllIlIIlIlllllIlIIllIl = new StringBuffer("{");
        for (final String lllllllllllllIlIIlIlllllIlIIllll : this.interfaces.keySet()) {
            lllllllllllllIlIIlIlllllIlIIllIl.append(lllllllllllllIlIIlIlllllIlIIllll).append(", ");
        }
        if (this.potentialClass != null) {
            lllllllllllllIlIIlIlllllIlIIllIl.append("*").append(this.potentialClass.toString());
        }
        else {
            lllllllllllllIlIIlIlllllIlIIllIl.setLength(lllllllllllllIlIIlIlllllIlIIllIl.length() - 2);
        }
        lllllllllllllIlIIlIlllllIlIIllIl.append("}");
        return lllllllllllllIlIIlIlllllIlIIllIl.toString();
    }
    
    private boolean inMergeSource(MultiType lllllllllllllIlIIlIllllllIllllll) {
        while (lllllllllllllIlIIlIllllllIllllll != null) {
            if (lllllllllllllIlIIlIllllllIllllll == this) {
                return true;
            }
            lllllllllllllIlIIlIllllllIllllll = lllllllllllllIlIIlIllllllIllllll.mergeSource;
        }
        return false;
    }
    
    public MultiType(final Map<String, CtClass> lllllllllllllIlIIllIIIIIIIIllllI) {
        this(lllllllllllllIlIIllIIIIIIIIllllI, null);
    }
    
    @Override
    boolean popChanged() {
        final boolean lllllllllllllIlIIllIIIIIIIIIlIll = this.changed;
        this.changed = false;
        return lllllllllllllIlIIllIIIIIIIIIlIll;
    }
    
    private Map<String, CtClass> getAllMultiInterfaces(final MultiType lllllllllllllIlIIlIllllllllIlIIl) {
        final Map<String, CtClass> lllllllllllllIlIIlIllllllllIlIII = new HashMap<String, CtClass>();
        for (final CtClass lllllllllllllIlIIlIllllllllIlIll : lllllllllllllIlIIlIllllllllIlIIl.interfaces.values()) {
            lllllllllllllIlIIlIllllllllIlIII.put(lllllllllllllIlIIlIllllllllIlIll.getName(), lllllllllllllIlIIlIllllllllIlIll);
            this.getAllInterfaces(lllllllllllllIlIIlIllllllllIlIll, lllllllllllllIlIIlIllllllllIlIII);
        }
        return lllllllllllllIlIIlIllllllllIlIII;
    }
    
    @Override
    public Type getComponent() {
        return null;
    }
    
    @Override
    public int getSize() {
        return 1;
    }
    
    @Override
    public boolean isReference() {
        return true;
    }
    
    @Override
    public CtClass getCtClass() {
        if (this.resolved != null) {
            return this.resolved.getCtClass();
        }
        return Type.OBJECT.getCtClass();
    }
}
