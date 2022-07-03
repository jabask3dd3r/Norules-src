package net.minecraft.entity.ai.attributes;

import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;

public class AttributeMap extends AbstractAttributeMap
{
    private final /* synthetic */ Set<IAttributeInstance> attributeInstanceSet;
    protected final /* synthetic */ Map<String, IAttributeInstance> descriptionToAttributeInstanceMap;
    
    @Override
    public ModifiableAttributeInstance getAttributeInstanceByName(final String lllllllllllllIlllIIIIllIIlIlIIII) {
        IAttributeInstance lllllllllllllIlllIIIIllIIlIlIIlI = super.getAttributeInstanceByName(lllllllllllllIlllIIIIllIIlIlIIII);
        if (lllllllllllllIlllIIIIllIIlIlIIlI == null) {
            lllllllllllllIlllIIIIllIIlIlIIlI = this.descriptionToAttributeInstanceMap.get(lllllllllllllIlllIIIIllIIlIlIIII);
        }
        return (ModifiableAttributeInstance)lllllllllllllIlllIIIIllIIlIlIIlI;
    }
    
    @Override
    protected IAttributeInstance createInstance(final IAttribute lllllllllllllIlllIIIIllIIlIIIIlI) {
        return new ModifiableAttributeInstance(this, lllllllllllllIlllIIIIllIIlIIIIlI);
    }
    
    @Override
    public ModifiableAttributeInstance getAttributeInstance(final IAttribute lllllllllllllIlllIIIIllIIlIllIII) {
        return (ModifiableAttributeInstance)super.getAttributeInstance(lllllllllllllIlllIIIIllIIlIllIII);
    }
    
    public AttributeMap() {
        this.attributeInstanceSet = (Set<IAttributeInstance>)Sets.newHashSet();
        this.descriptionToAttributeInstanceMap = new LowerStringMap<IAttributeInstance>();
    }
    
    @Override
    public IAttributeInstance registerAttribute(final IAttribute lllllllllllllIlllIIIIllIIlIIlIlI) {
        final IAttributeInstance lllllllllllllIlllIIIIllIIlIIlIIl = super.registerAttribute(lllllllllllllIlllIIIIllIIlIIlIlI);
        if (lllllllllllllIlllIIIIllIIlIIlIlI instanceof RangedAttribute && ((RangedAttribute)lllllllllllllIlllIIIIllIIlIIlIlI).getDescription() != null) {
            this.descriptionToAttributeInstanceMap.put(((RangedAttribute)lllllllllllllIlllIIIIllIIlIIlIlI).getDescription(), lllllllllllllIlllIIIIllIIlIIlIIl);
        }
        return lllllllllllllIlllIIIIllIIlIIlIIl;
    }
    
    public Collection<IAttributeInstance> getWatchedAttributes() {
        final Set<IAttributeInstance> lllllllllllllIlllIIIIllIIIlIlIIl = (Set<IAttributeInstance>)Sets.newHashSet();
        for (final IAttributeInstance lllllllllllllIlllIIIIllIIIlIlIII : this.getAllAttributes()) {
            if (lllllllllllllIlllIIIIllIIIlIlIII.getAttribute().getShouldWatch()) {
                lllllllllllllIlllIIIIllIIIlIlIIl.add(lllllllllllllIlllIIIIllIIIlIlIII);
            }
        }
        return lllllllllllllIlllIIIIllIIIlIlIIl;
    }
    
    @Override
    public void onAttributeModified(final IAttributeInstance lllllllllllllIlllIIIIllIIIllIlIl) {
        if (lllllllllllllIlllIIIIllIIIllIlIl.getAttribute().getShouldWatch()) {
            this.attributeInstanceSet.add(lllllllllllllIlllIIIIllIIIllIlIl);
        }
        for (final IAttribute lllllllllllllIlllIIIIllIIIlllIII : this.descendantsByParent.get((Object)lllllllllllllIlllIIIIllIIIllIlIl.getAttribute())) {
            final ModifiableAttributeInstance lllllllllllllIlllIIIIllIIIllIlll = this.getAttributeInstance(lllllllllllllIlllIIIIllIIIlllIII);
            if (lllllllllllllIlllIIIIllIIIllIlll != null) {
                lllllllllllllIlllIIIIllIIIllIlll.flagForUpdate();
            }
        }
    }
    
    public Set<IAttributeInstance> getAttributeInstanceSet() {
        return this.attributeInstanceSet;
    }
}
