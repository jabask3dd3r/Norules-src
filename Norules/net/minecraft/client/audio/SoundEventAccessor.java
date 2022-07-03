package net.minecraft.client.audio;

import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;

public class SoundEventAccessor implements ISoundEventAccessor<Sound>
{
    private final /* synthetic */ List<ISoundEventAccessor<Sound>> accessorList;
    private final /* synthetic */ ITextComponent subtitle;
    private final /* synthetic */ ResourceLocation location;
    private final /* synthetic */ Random rnd;
    
    public SoundEventAccessor(final ResourceLocation lllllllllllllIllllllIllIlIIIlIIl, @Nullable final String lllllllllllllIllllllIllIlIIIlIII) {
        this.accessorList = (List<ISoundEventAccessor<Sound>>)Lists.newArrayList();
        this.rnd = new Random();
        this.location = lllllllllllllIllllllIllIlIIIlIIl;
        this.subtitle = ((lllllllllllllIllllllIllIlIIIlIII == null) ? null : new TextComponentTranslation(lllllllllllllIllllllIllIlIIIlIII, new Object[0]));
    }
    
    public void addSound(final ISoundEventAccessor<Sound> lllllllllllllIllllllIllIIllIIIIl) {
        this.accessorList.add(lllllllllllllIllllllIllIIllIIIIl);
    }
    
    public ResourceLocation getLocation() {
        return this.location;
    }
    
    @Override
    public Sound cloneEntry() {
        final int lllllllllllllIllllllIllIIlllIIll = this.getWeight();
        if (!this.accessorList.isEmpty() && lllllllllllllIllllllIllIIlllIIll != 0) {
            int lllllllllllllIllllllIllIIlllIIlI = this.rnd.nextInt(lllllllllllllIllllllIllIIlllIIll);
            for (final ISoundEventAccessor<Sound> lllllllllllllIllllllIllIIlllIIIl : this.accessorList) {
                lllllllllllllIllllllIllIIlllIIlI -= lllllllllllllIllllllIllIIlllIIIl.getWeight();
                if (lllllllllllllIllllllIllIIlllIIlI < 0) {
                    return lllllllllllllIllllllIllIIlllIIIl.cloneEntry();
                }
            }
            return SoundHandler.MISSING_SOUND;
        }
        return SoundHandler.MISSING_SOUND;
    }
    
    @Nullable
    public ITextComponent getSubtitle() {
        return this.subtitle;
    }
    
    @Override
    public int getWeight() {
        int lllllllllllllIllllllIllIIlllllll = 0;
        for (final ISoundEventAccessor<Sound> lllllllllllllIllllllIllIIllllllI : this.accessorList) {
            lllllllllllllIllllllIllIIlllllll += lllllllllllllIllllllIllIIllllllI.getWeight();
        }
        return lllllllllllllIllllllIllIIlllllll;
    }
}
