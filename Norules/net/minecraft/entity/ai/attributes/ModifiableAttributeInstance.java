package net.minecraft.entity.ai.attributes;

import javax.annotation.*;
import java.util.*;
import com.google.common.collect.*;

public class ModifiableAttributeInstance implements IAttributeInstance
{
    private /* synthetic */ double baseValue;
    private final /* synthetic */ IAttribute genericAttribute;
    private /* synthetic */ double cachedValue;
    private final /* synthetic */ Map<UUID, AttributeModifier> mapByUUID;
    private /* synthetic */ boolean needsUpdate;
    private final /* synthetic */ Map<Integer, Set<AttributeModifier>> mapByOperation;
    private final /* synthetic */ Map<String, Set<AttributeModifier>> mapByName;
    private final /* synthetic */ AbstractAttributeMap attributeMap;
    
    @Nullable
    @Override
    public AttributeModifier getModifier(final UUID llllllllllllllIlIIIIIlIIIlllIIII) {
        return this.mapByUUID.get(llllllllllllllIlIIIIIlIIIlllIIII);
    }
    
    @Override
    public void removeModifier(final UUID llllllllllllllIlIIIIIlIIIlIIllII) {
        final AttributeModifier llllllllllllllIlIIIIIlIIIlIIlIll = this.getModifier(llllllllllllllIlIIIIIlIIIlIIllII);
        if (llllllllllllllIlIIIIIlIIIlIIlIll != null) {
            this.removeModifier(llllllllllllllIlIIIIIlIIIlIIlIll);
        }
    }
    
    protected void flagForUpdate() {
        this.needsUpdate = true;
        this.attributeMap.onAttributeModified(this);
    }
    
    @Override
    public void removeAllModifiers() {
        final Collection<AttributeModifier> llllllllllllllIlIIIIIlIIIlIIIIlI = this.getModifiers();
        if (llllllllllllllIlIIIIIlIIIlIIIIlI != null) {
            for (final AttributeModifier llllllllllllllIlIIIIIlIIIlIIIIIl : Lists.newArrayList((Iterable)llllllllllllllIlIIIIIlIIIlIIIIlI)) {
                this.removeModifier(llllllllllllllIlIIIIIlIIIlIIIIIl);
            }
        }
    }
    
    @Override
    public void removeModifier(final AttributeModifier llllllllllllllIlIIIIIlIIIlIllIII) {
        for (int llllllllllllllIlIIIIIlIIIlIlIlll = 0; llllllllllllllIlIIIIIlIIIlIlIlll < 3; ++llllllllllllllIlIIIIIlIIIlIlIlll) {
            final Set<AttributeModifier> llllllllllllllIlIIIIIlIIIlIlIllI = this.mapByOperation.get(llllllllllllllIlIIIIIlIIIlIlIlll);
            llllllllllllllIlIIIIIlIIIlIlIllI.remove(llllllllllllllIlIIIIIlIIIlIllIII);
        }
        final Set<AttributeModifier> llllllllllllllIlIIIIIlIIIlIlIlIl = this.mapByName.get(llllllllllllllIlIIIIIlIIIlIllIII.getName());
        if (llllllllllllllIlIIIIIlIIIlIlIlIl != null) {
            llllllllllllllIlIIIIIlIIIlIlIlIl.remove(llllllllllllllIlIIIIIlIIIlIllIII);
            if (llllllllllllllIlIIIIIlIIIlIlIlIl.isEmpty()) {
                this.mapByName.remove(llllllllllllllIlIIIIIlIIIlIllIII.getName());
            }
        }
        this.mapByUUID.remove(llllllllllllllIlIIIIIlIIIlIllIII.getID());
        this.flagForUpdate();
    }
    
    @Override
    public Collection<AttributeModifier> getModifiers() {
        final Set<AttributeModifier> llllllllllllllIlIIIIIlIIIllllIlI = (Set<AttributeModifier>)Sets.newHashSet();
        for (int llllllllllllllIlIIIIIlIIIllllIIl = 0; llllllllllllllIlIIIIIlIIIllllIIl < 3; ++llllllllllllllIlIIIIIlIIIllllIIl) {
            llllllllllllllIlIIIIIlIIIllllIlI.addAll(this.getModifiersByOperation(llllllllllllllIlIIIIIlIIIllllIIl));
        }
        return llllllllllllllIlIIIIIlIIIllllIlI;
    }
    
    private Collection<AttributeModifier> getAppliedModifiers(final int llllllllllllllIlIIIIIlIIIIIlllII) {
        final Set<AttributeModifier> llllllllllllllIlIIIIIlIIIIlIIIII = (Set<AttributeModifier>)Sets.newHashSet((Iterable)this.getModifiersByOperation(llllllllllllllIlIIIIIlIIIIIlllII));
        for (IAttribute llllllllllllllIlIIIIIlIIIIIlllll = this.genericAttribute.getParent(); llllllllllllllIlIIIIIlIIIIIlllll != null; llllllllllllllIlIIIIIlIIIIIlllll = llllllllllllllIlIIIIIlIIIIIlllll.getParent()) {
            final IAttributeInstance llllllllllllllIlIIIIIlIIIIIllllI = this.attributeMap.getAttributeInstance(llllllllllllllIlIIIIIlIIIIIlllll);
            if (llllllllllllllIlIIIIIlIIIIIllllI != null) {
                llllllllllllllIlIIIIIlIIIIlIIIII.addAll(llllllllllllllIlIIIIIlIIIIIllllI.getModifiersByOperation(llllllllllllllIlIIIIIlIIIIIlllII));
            }
        }
        return llllllllllllllIlIIIIIlIIIIlIIIII;
    }
    
    private double computeValue() {
        double llllllllllllllIlIIIIIlIIIIllIIlI = this.getBaseValue();
        for (final AttributeModifier llllllllllllllIlIIIIIlIIIIllIIIl : this.getAppliedModifiers(0)) {
            llllllllllllllIlIIIIIlIIIIllIIlI += llllllllllllllIlIIIIIlIIIIllIIIl.getAmount();
        }
        double llllllllllllllIlIIIIIlIIIIllIIII = llllllllllllllIlIIIIIlIIIIllIIlI;
        for (final AttributeModifier llllllllllllllIlIIIIIlIIIIlIllll : this.getAppliedModifiers(1)) {
            llllllllllllllIlIIIIIlIIIIllIIII += llllllllllllllIlIIIIIlIIIIllIIlI * llllllllllllllIlIIIIIlIIIIlIllll.getAmount();
        }
        for (final AttributeModifier llllllllllllllIlIIIIIlIIIIlIlllI : this.getAppliedModifiers(2)) {
            llllllllllllllIlIIIIIlIIIIllIIII *= 1.0 + llllllllllllllIlIIIIIlIIIIlIlllI.getAmount();
        }
        return this.genericAttribute.clampValue(llllllllllllllIlIIIIIlIIIIllIIII);
    }
    
    @Override
    public double getAttributeValue() {
        if (this.needsUpdate) {
            this.cachedValue = this.computeValue();
            this.needsUpdate = false;
        }
        return this.cachedValue;
    }
    
    @Override
    public IAttribute getAttribute() {
        return this.genericAttribute;
    }
    
    @Override
    public Collection<AttributeModifier> getModifiersByOperation(final int llllllllllllllIlIIIIIlIIIlllllll) {
        return this.mapByOperation.get(llllllllllllllIlIIIIIlIIIlllllll);
    }
    
    @Override
    public boolean hasModifier(final AttributeModifier llllllllllllllIlIIIIIlIIIllIllII) {
        return this.mapByUUID.get(llllllllllllllIlIIIIIlIIIllIllII.getID()) != null;
    }
    
    @Override
    public double getBaseValue() {
        return this.baseValue;
    }
    
    public ModifiableAttributeInstance(final AbstractAttributeMap llllllllllllllIlIIIIIlIIlIIlIIll, final IAttribute llllllllllllllIlIIIIIlIIlIIlIIlI) {
        this.mapByOperation = (Map<Integer, Set<AttributeModifier>>)Maps.newHashMap();
        this.mapByName = (Map<String, Set<AttributeModifier>>)Maps.newHashMap();
        this.mapByUUID = (Map<UUID, AttributeModifier>)Maps.newHashMap();
        this.needsUpdate = true;
        this.attributeMap = llllllllllllllIlIIIIIlIIlIIlIIll;
        this.genericAttribute = llllllllllllllIlIIIIIlIIlIIlIIlI;
        this.baseValue = llllllllllllllIlIIIIIlIIlIIlIIlI.getDefaultValue();
        for (int llllllllllllllIlIIIIIlIIlIIlIlIl = 0; llllllllllllllIlIIIIIlIIlIIlIlIl < 3; ++llllllllllllllIlIIIIIlIIlIIlIlIl) {
            this.mapByOperation.put(llllllllllllllIlIIIIIlIIlIIlIlIl, Sets.newHashSet());
        }
    }
    
    @Override
    public void applyModifier(final AttributeModifier llllllllllllllIlIIIIIlIIIllIIlIl) {
        if (this.getModifier(llllllllllllllIlIIIIIlIIIllIIlIl.getID()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        Set<AttributeModifier> llllllllllllllIlIIIIIlIIIllIIlII = this.mapByName.get(llllllllllllllIlIIIIIlIIIllIIlIl.getName());
        if (llllllllllllllIlIIIIIlIIIllIIlII == null) {
            llllllllllllllIlIIIIIlIIIllIIlII = (Set<AttributeModifier>)Sets.newHashSet();
            this.mapByName.put(llllllllllllllIlIIIIIlIIIllIIlIl.getName(), llllllllllllllIlIIIIIlIIIllIIlII);
        }
        this.mapByOperation.get(llllllllllllllIlIIIIIlIIIllIIlIl.getOperation()).add(llllllllllllllIlIIIIIlIIIllIIlIl);
        llllllllllllllIlIIIIIlIIIllIIlII.add(llllllllllllllIlIIIIIlIIIllIIlIl);
        this.mapByUUID.put(llllllllllllllIlIIIIIlIIIllIIlIl.getID(), llllllllllllllIlIIIIIlIIIllIIlIl);
        this.flagForUpdate();
    }
    
    @Override
    public void setBaseValue(final double llllllllllllllIlIIIIIlIIlIIIIlll) {
        if (llllllllllllllIlIIIIIlIIlIIIIlll != this.getBaseValue()) {
            this.baseValue = llllllllllllllIlIIIIIlIIlIIIIlll;
            this.flagForUpdate();
        }
    }
}
