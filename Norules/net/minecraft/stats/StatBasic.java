package net.minecraft.stats;

import net.minecraft.util.text.*;

public class StatBasic extends StatBase
{
    @Override
    public StatBase registerStat() {
        super.registerStat();
        StatList.BASIC_STATS.add(this);
        return this;
    }
    
    public StatBasic(final String llllllllllllllIllIIIIIlIlIIllIlI, final ITextComponent llllllllllllllIllIIIIIlIlIIllIIl, final IStatType llllllllllllllIllIIIIIlIlIIlIlII) {
        super(llllllllllllllIllIIIIIlIlIIllIlI, llllllllllllllIllIIIIIlIlIIllIIl, llllllllllllllIllIIIIIlIlIIlIlII);
    }
    
    public StatBasic(final String llllllllllllllIllIIIIIlIlIIIllll, final ITextComponent llllllllllllllIllIIIIIlIlIIIlIll) {
        super(llllllllllllllIllIIIIIlIlIIIllll, llllllllllllllIllIIIIIlIlIIIlIll);
    }
}
