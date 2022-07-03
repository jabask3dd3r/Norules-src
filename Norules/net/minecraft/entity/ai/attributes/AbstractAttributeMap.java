package net.minecraft.entity.ai.attributes;

import net.minecraft.util.*;
import com.google.common.collect.*;
import javax.annotation.*;
import java.util.*;

public abstract class AbstractAttributeMap
{
    protected final /* synthetic */ Map<String, IAttributeInstance> attributesByName;
    protected final /* synthetic */ Multimap<IAttribute, IAttribute> descendantsByParent;
    protected final /* synthetic */ Map<IAttribute, IAttributeInstance> attributes;
    
    protected abstract IAttributeInstance createInstance(final IAttribute p0);
    
    public AbstractAttributeMap() {
        this.attributes = (Map<IAttribute, IAttributeInstance>)Maps.newHashMap();
        this.attributesByName = new LowerStringMap<IAttributeInstance>();
        this.descendantsByParent = (Multimap<IAttribute, IAttribute>)HashMultimap.create();
    }
    
    public void onAttributeModified(final IAttributeInstance llllllllllllllIlIIIIllllIllIIIlI) {
    }
    
    @Nullable
    public IAttributeInstance getAttributeInstanceByName(final String llllllllllllllIlIIIIllllIlllllll) {
        return this.attributesByName.get(llllllllllllllIlIIIIllllIlllllll);
    }
    
    public void removeAttributeModifiers(final Multimap<String, AttributeModifier> llllllllllllllIlIIIIllllIlIIlIlI) {
        for (final Map.Entry<String, AttributeModifier> llllllllllllllIlIIIIllllIlIIllIl : llllllllllllllIlIIIIllllIlIIlIlI.entries()) {
            final IAttributeInstance llllllllllllllIlIIIIllllIlIIllII = this.getAttributeInstanceByName(llllllllllllllIlIIIIllllIlIIllIl.getKey());
            if (llllllllllllllIlIIIIllllIlIIllII != null) {
                llllllllllllllIlIIIIllllIlIIllII.removeModifier(llllllllllllllIlIIIIllllIlIIllIl.getValue());
            }
        }
    }
    
    public IAttributeInstance getAttributeInstance(final IAttribute llllllllllllllIlIIIIlllllIIIIlIl) {
        return this.attributes.get(llllllllllllllIlIIIIlllllIIIIlIl);
    }
    
    public void applyAttributeModifiers(final Multimap<String, AttributeModifier> llllllllllllllIlIIIIllllIIlIIlll) {
        for (final Map.Entry<String, AttributeModifier> llllllllllllllIlIIIIllllIIlIllIl : llllllllllllllIlIIIIllllIIlIIlll.entries()) {
            final IAttributeInstance llllllllllllllIlIIIIllllIIlIlIll = this.getAttributeInstanceByName(llllllllllllllIlIIIIllllIIlIllIl.getKey());
            if (llllllllllllllIlIIIIllllIIlIlIll != null) {
                llllllllllllllIlIIIIllllIIlIlIll.removeModifier(llllllllllllllIlIIIIllllIIlIllIl.getValue());
                llllllllllllllIlIIIIllllIIlIlIll.applyModifier(llllllllllllllIlIIIIllllIIlIllIl.getValue());
            }
        }
    }
    
    public Collection<IAttributeInstance> getAllAttributes() {
        return this.attributesByName.values();
    }
    
    public IAttributeInstance registerAttribute(final IAttribute llllllllllllllIlIIIIllllIllIlIIl) {
        if (this.attributesByName.containsKey(llllllllllllllIlIIIIllllIllIlIIl.getAttributeUnlocalizedName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        final IAttributeInstance llllllllllllllIlIIIIllllIllIllII = this.createInstance(llllllllllllllIlIIIIllllIllIlIIl);
        this.attributesByName.put(llllllllllllllIlIIIIllllIllIlIIl.getAttributeUnlocalizedName(), llllllllllllllIlIIIIllllIllIllII);
        this.attributes.put(llllllllllllllIlIIIIllllIllIlIIl, llllllllllllllIlIIIIllllIllIllII);
        for (IAttribute llllllllllllllIlIIIIllllIllIlIll = llllllllllllllIlIIIIllllIllIlIIl.getParent(); llllllllllllllIlIIIIllllIllIlIll != null; llllllllllllllIlIIIIllllIllIlIll = llllllllllllllIlIIIIllllIllIlIll.getParent()) {
            this.descendantsByParent.put((Object)llllllllllllllIlIIIIllllIllIlIll, (Object)llllllllllllllIlIIIIllllIllIlIIl);
        }
        return llllllllllllllIlIIIIllllIllIllII;
    }
}
