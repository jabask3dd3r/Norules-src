package net.minecraft.stats;

import java.text.*;
import net.minecraft.util.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.util.text.*;

public class StatBase
{
    private final /* synthetic */ IScoreCriteria objectiveCriteria;
    public final /* synthetic */ String statId;
    private static final /* synthetic */ DecimalFormat decimalFormat;
    public static /* synthetic */ IStatType simpleStatType;
    private static final /* synthetic */ NumberFormat numberFormat;
    public static /* synthetic */ IStatType distanceStatType;
    public static /* synthetic */ IStatType divideByTen;
    private final /* synthetic */ ITextComponent statName;
    public /* synthetic */ boolean isIndependent;
    private /* synthetic */ Class<? extends IJsonSerializable> serializableClazz;
    private final /* synthetic */ IStatType formatter;
    public static /* synthetic */ IStatType timeStatType;
    
    public StatBase(final String lllllllllllllIllIIIlllIIIlIIIIlI, final ITextComponent lllllllllllllIllIIIlllIIIlIIIIIl, final IStatType lllllllllllllIllIIIlllIIIlIIIIII) {
        this.statId = lllllllllllllIllIIIlllIIIlIIIIlI;
        this.statName = lllllllllllllIllIIIlllIIIlIIIIIl;
        this.formatter = lllllllllllllIllIIIlllIIIlIIIIII;
        this.objectiveCriteria = new ScoreCriteriaStat(this);
        IScoreCriteria.INSTANCES.put(this.objectiveCriteria.getName(), this.objectiveCriteria);
    }
    
    public String format(final int lllllllllllllIllIIIlllIIIIlIlIll) {
        return this.formatter.format(lllllllllllllIllIIIlllIIIIlIlIll);
    }
    
    @Override
    public int hashCode() {
        return this.statId.hashCode();
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Stat{id=").append(this.statId).append(", nameId=").append(this.statName).append(", awardLocallyOnly=").append(this.isIndependent).append(", formatter=").append(this.formatter).append(", objectiveCriteria=").append(this.objectiveCriteria).append('}'));
    }
    
    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }
    
    static {
        numberFormat = NumberFormat.getIntegerInstance(Locale.US);
        StatBase.simpleStatType = new IStatType() {
            @Override
            public String format(final int llllllllllllllIlllIlIIIlIIllIlIl) {
                return StatBase.numberFormat.format(llllllllllllllIlllIlIIIlIIllIlIl);
            }
        };
        decimalFormat = new DecimalFormat("########0.00");
        StatBase.timeStatType = new IStatType() {
            @Override
            public String format(final int llllllllllllllllIIlllllIlIlllllI) {
                final double llllllllllllllllIIlllllIlIllllIl = llllllllllllllllIIlllllIlIlllllI / 20.0;
                final double llllllllllllllllIIlllllIlIllllII = llllllllllllllllIIlllllIlIllllIl / 60.0;
                final double llllllllllllllllIIlllllIlIlllIll = llllllllllllllllIIlllllIlIllllII / 60.0;
                final double llllllllllllllllIIlllllIlIlllIlI = llllllllllllllllIIlllllIlIlllIll / 24.0;
                final double llllllllllllllllIIlllllIlIlllIIl = llllllllllllllllIIlllllIlIlllIlI / 365.0;
                if (llllllllllllllllIIlllllIlIlllIIl > 0.5) {
                    return String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(llllllllllllllllIIlllllIlIlllIIl))).append(" y"));
                }
                if (llllllllllllllllIIlllllIlIlllIlI > 0.5) {
                    return String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(llllllllllllllllIIlllllIlIlllIlI))).append(" d"));
                }
                if (llllllllllllllllIIlllllIlIlllIll > 0.5) {
                    return String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(llllllllllllllllIIlllllIlIlllIll))).append(" h"));
                }
                return (llllllllllllllllIIlllllIlIllllII > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(llllllllllllllllIIlllllIlIllllII))).append(" m")) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIlllllIlIllllIl)).append(" s"));
            }
        };
        StatBase.distanceStatType = new IStatType() {
            @Override
            public String format(final int lIIIlIlIIIIIlll) {
                final double lIIIlIlIIIIlIIl = lIIIlIlIIIIIlll / 100.0;
                final double lIIIlIlIIIIlIII = lIIIlIlIIIIlIIl / 1000.0;
                if (lIIIlIlIIIIlIII > 0.5) {
                    return String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lIIIlIlIIIIlIII))).append(" km"));
                }
                return (lIIIlIlIIIIlIIl > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lIIIlIlIIIIlIIl))).append(" m")) : String.valueOf(new StringBuilder(String.valueOf(lIIIlIlIIIIIlll)).append(" cm"));
            }
        };
        StatBase.divideByTen = new IStatType() {
            @Override
            public String format(final int lllllllllllllllllIlIlllllIIlIllI) {
                return StatBase.decimalFormat.format(lllllllllllllllllIlIlllllIIlIllI * 0.1);
            }
        };
    }
    
    public StatBase registerStat() {
        if (StatList.ID_TO_STAT_MAP.containsKey(this.statId)) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Duplicate stat id: \"").append(StatList.ID_TO_STAT_MAP.get(this.statId).statName).append("\" and \"").append(this.statName).append("\" at id ").append(this.statId)));
        }
        StatList.ALL_STATS.add(this);
        StatList.ID_TO_STAT_MAP.put(this.statId, this);
        return this;
    }
    
    public ITextComponent getStatName() {
        final ITextComponent lllllllllllllIllIIIlllIIIIlIIlll = this.statName.createCopy();
        lllllllllllllIllIIIlllIIIIlIIlll.getStyle().setColor(TextFormatting.GRAY);
        return lllllllllllllIllIIIlllIIIIlIIlll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIIlllIIIIlIIIII) {
        if (this == lllllllllllllIllIIIlllIIIIlIIIII) {
            return true;
        }
        if (lllllllllllllIllIIIlllIIIIlIIIII != null && this.getClass() == lllllllllllllIllIIIlllIIIIlIIIII.getClass()) {
            final StatBase lllllllllllllIllIIIlllIIIIIlllll = (StatBase)lllllllllllllIllIIIlllIIIIlIIIII;
            return this.statId.equals(lllllllllllllIllIIIlllIIIIIlllll.statId);
        }
        return false;
    }
    
    public IScoreCriteria getCriteria() {
        return this.objectiveCriteria;
    }
    
    public StatBase(final String lllllllllllllIllIIIlllIIIIlllIII, final ITextComponent lllllllllllllIllIIIlllIIIIllIlll) {
        this(lllllllllllllIllIIIlllIIIIlllIII, lllllllllllllIllIIIlllIIIIllIlll, StatBase.simpleStatType);
    }
    
    public Class<? extends IJsonSerializable> getSerializableClazz() {
        return this.serializableClazz;
    }
}
