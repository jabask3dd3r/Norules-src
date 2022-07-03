package net.minecraft.client.renderer.block.model.multipart;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.client.renderer.block.model.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;

public class Multipart
{
    private /* synthetic */ BlockStateContainer stateContainer;
    private final /* synthetic */ List<Selector> selectors;
    
    public Set<VariantList> getVariants() {
        final Set<VariantList> llllllllllllIlllllIlIllIIIlIIIll = (Set<VariantList>)Sets.newHashSet();
        for (final Selector llllllllllllIlllllIlIllIIIlIIIlI : this.selectors) {
            llllllllllllIlllllIlIllIIIlIIIll.add(llllllllllllIlllllIlIllIIIlIIIlI.getVariantList());
        }
        return llllllllllllIlllllIlIllIIIlIIIll;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.selectors.hashCode() + ((this.stateContainer == null) ? 0 : this.stateContainer.hashCode());
    }
    
    public BlockStateContainer getStateContainer() {
        return this.stateContainer;
    }
    
    public Multipart(final List<Selector> llllllllllllIlllllIlIllIIIlIllII) {
        this.selectors = llllllllllllIlllllIlIllIIIlIllII;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIlIllIIIIIllIl) {
        if (this == llllllllllllIlllllIlIllIIIIIllIl) {
            return true;
        }
        if (llllllllllllIlllllIlIllIIIIIllIl instanceof Multipart) {
            final Multipart llllllllllllIlllllIlIllIIIIIllll = (Multipart)llllllllllllIlllllIlIllIIIIIllIl;
            if (this.selectors.equals(llllllllllllIlllllIlIllIIIIIllll.selectors)) {
                if (this.stateContainer == null) {
                    return llllllllllllIlllllIlIllIIIIIllll.stateContainer == null;
                }
                return this.stateContainer.equals(llllllllllllIlllllIlIllIIIIIllll.stateContainer);
            }
        }
        return false;
    }
    
    public List<Selector> getSelectors() {
        return this.selectors;
    }
    
    public void setStateContainer(final BlockStateContainer llllllllllllIlllllIlIllIIIIllIlI) {
        this.stateContainer = llllllllllllIlllllIlIllIIIIllIlI;
    }
    
    public static class Deserializer implements JsonDeserializer<Multipart>
    {
        private List<Selector> getSelectors(final JsonDeserializationContext lllllllllllllIIIllIllIllIIllIIII, final JsonArray lllllllllllllIIIllIllIllIIlIllll) {
            final List<Selector> lllllllllllllIIIllIllIllIIllIIlI = (List<Selector>)Lists.newArrayList();
            for (final JsonElement lllllllllllllIIIllIllIllIIllIIIl : lllllllllllllIIIllIllIllIIlIllll) {
                lllllllllllllIIIllIllIllIIllIIlI.add((Selector)lllllllllllllIIIllIllIllIIllIIII.deserialize(lllllllllllllIIIllIllIllIIllIIIl, (Type)Selector.class));
            }
            return lllllllllllllIIIllIllIllIIllIIlI;
        }
        
        public Multipart deserialize(final JsonElement lllllllllllllIIIllIllIllIlIIlIIl, final Type lllllllllllllIIIllIllIllIlIIlllI, final JsonDeserializationContext lllllllllllllIIIllIllIllIlIIllIl) throws JsonParseException {
            return new Multipart(this.getSelectors(lllllllllllllIIIllIllIllIlIIllIl, lllllllllllllIIIllIllIllIlIIlIIl.getAsJsonArray()));
        }
    }
}
