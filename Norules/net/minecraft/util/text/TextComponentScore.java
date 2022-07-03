package net.minecraft.util.text;

import net.minecraft.command.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.scoreboard.*;

public class TextComponentScore extends TextComponentBase
{
    private /* synthetic */ String value;
    private final /* synthetic */ String name;
    private final /* synthetic */ String objective;
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("ScoreComponent{name='").append(this.name).append('\'').append("objective='").append(this.objective).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getStyle()).append('}'));
    }
    
    public void resolve(final ICommandSender lllllllllllllllIIllIlIIlIllIIIII) {
        final MinecraftServer lllllllllllllllIIllIlIIlIlIlllll = lllllllllllllllIIllIlIIlIllIIIII.getServer();
        if (lllllllllllllllIIllIlIIlIlIlllll != null && lllllllllllllllIIllIlIIlIlIlllll.isAnvilFileSet() && StringUtils.isNullOrEmpty(this.value)) {
            final Scoreboard lllllllllllllllIIllIlIIlIlIllllI = lllllllllllllllIIllIlIIlIlIlllll.worldServerForDimension(0).getScoreboard();
            final ScoreObjective lllllllllllllllIIllIlIIlIlIlllIl = lllllllllllllllIIllIlIIlIlIllllI.getObjective(this.objective);
            if (lllllllllllllllIIllIlIIlIlIllllI.entityHasObjective(this.name, lllllllllllllllIIllIlIIlIlIlllIl)) {
                final Score lllllllllllllllIIllIlIIlIlIlllII = lllllllllllllllIIllIlIIlIlIllllI.getOrCreateScore(this.name, lllllllllllllllIIllIlIIlIlIlllIl);
                this.setValue(String.format("%d", lllllllllllllllIIllIlIIlIlIlllII.getScorePoints()));
            }
            else {
                this.value = "";
            }
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIllIlIIlIlIIIllI) {
        if (this == lllllllllllllllIIllIlIIlIlIIIllI) {
            return true;
        }
        if (!(lllllllllllllllIIllIlIIlIlIIIllI instanceof TextComponentScore)) {
            return false;
        }
        final TextComponentScore lllllllllllllllIIllIlIIlIlIIIlIl = (TextComponentScore)lllllllllllllllIIllIlIIlIlIIIllI;
        return this.name.equals(lllllllllllllllIIllIlIIlIlIIIlIl.name) && this.objective.equals(lllllllllllllllIIllIlIIlIlIIIlIl.objective) && super.equals(lllllllllllllllIIllIlIIlIlIIIllI);
    }
    
    public TextComponentScore(final String lllllllllllllllIIllIlIIlIllllIll, final String lllllllllllllllIIllIlIIlIllllIlI) {
        this.value = "";
        this.name = lllllllllllllllIIllIlIIlIllllIll;
        this.objective = lllllllllllllllIIllIlIIlIllllIlI;
    }
    
    public void setValue(final String lllllllllllllllIIllIlIIlIllIlIll) {
        this.value = lllllllllllllllIIllIlIIlIllIlIll;
    }
    
    public String getObjective() {
        return this.objective;
    }
    
    @Override
    public String getUnformattedComponentText() {
        return this.value;
    }
    
    @Override
    public TextComponentScore createCopy() {
        final TextComponentScore lllllllllllllllIIllIlIIlIlIlIIII = new TextComponentScore(this.name, this.objective);
        lllllllllllllllIIllIlIIlIlIlIIII.setValue(this.value);
        lllllllllllllllIIllIlIIlIlIlIIII.setStyle(this.getStyle().createShallowCopy());
        for (final ITextComponent lllllllllllllllIIllIlIIlIlIIllll : this.getSiblings()) {
            lllllllllllllllIIllIlIIlIlIlIIII.appendSibling(lllllllllllllllIIllIlIIlIlIIllll.createCopy());
        }
        return lllllllllllllllIIllIlIIlIlIlIIII;
    }
}
