package net.minecraft.command;

import javax.annotation.*;
import net.minecraft.util.math.*;
import java.util.*;
import java.util.regex.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;

public class EntitySelector
{
    private static final /* synthetic */ String field_190847_u;
    private static final /* synthetic */ String field_190850_x;
    private static final /* synthetic */ Splitter field_190828_b;
    private static final /* synthetic */ Pattern TOKEN_PATTERN;
    private static final /* synthetic */ String field_190845_s;
    private static final /* synthetic */ String field_190834_h;
    private static final /* synthetic */ String field_190846_t;
    private static final /* synthetic */ String field_190848_v;
    private static final /* synthetic */ Set<String> WORLD_BINDING_ARGS;
    private static final /* synthetic */ String field_190832_f;
    private static final /* synthetic */ String field_190842_p;
    private static final /* synthetic */ String field_190836_j;
    private static final /* synthetic */ String field_190838_l;
    private static final /* synthetic */ Predicate<String> field_190851_y;
    private static final /* synthetic */ String field_190831_e;
    private static final /* synthetic */ String field_190841_o;
    private static final /* synthetic */ String field_190844_r;
    private static final /* synthetic */ String field_190840_n;
    private static final /* synthetic */ Set<String> field_190830_d;
    private static final /* synthetic */ String field_190835_i;
    private static final /* synthetic */ String field_190837_k;
    private static final /* synthetic */ String field_190849_w;
    private static final /* synthetic */ String field_190833_g;
    private static final /* synthetic */ String field_190839_m;
    private static final /* synthetic */ String field_190843_q;
    private static final /* synthetic */ Splitter field_190829_c;
    
    private static List<Predicate<Entity>> getGamemodePredicates(final Map<String, String> llllllllllllllllIIIlIIIIIIIllIII) {
        final List<Predicate<Entity>> llllllllllllllllIIIlIIIIIIlIIIII = (List<Predicate<Entity>>)Lists.newArrayList();
        String llllllllllllllllIIIlIIIIIIIlllll = getArgument(llllllllllllllllIIIlIIIIIIIllIII, EntitySelector.field_190846_t);
        if (llllllllllllllllIIIlIIIIIIIlllll == null) {
            return llllllllllllllllIIIlIIIIIIlIIIII;
        }
        final boolean llllllllllllllllIIIlIIIIIIIllllI = llllllllllllllllIIIlIIIIIIIlllll.startsWith("!");
        if (llllllllllllllllIIIlIIIIIIIllllI) {
            llllllllllllllllIIIlIIIIIIIlllll = llllllllllllllllIIIlIIIIIIIlllll.substring(1);
        }
        GameType llllllllllllllllIIIlIIIIIIIlllII = null;
        try {
            final int llllllllllllllllIIIlIIIIIIIllIll = Integer.parseInt(llllllllllllllllIIIlIIIIIIIlllll);
            final GameType llllllllllllllllIIIlIIIIIIIlllIl = GameType.parseGameTypeWithDefault(llllllllllllllllIIIlIIIIIIIllIll, GameType.NOT_SET);
        }
        catch (Throwable llllllllllllllllIIIlIIIIIIIllIlI) {
            llllllllllllllllIIIlIIIIIIIlllII = GameType.parseGameTypeWithDefault(llllllllllllllllIIIlIIIIIIIlllll, GameType.NOT_SET);
        }
        final GameType llllllllllllllllIIIlIIIIIIIllIIl = llllllllllllllllIIIlIIIIIIIlllII;
        llllllllllllllllIIIlIIIIIIlIIIII.add((Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIllIIlllllIllllIII) {
                if (!(lllllllllllllIIllIIlllllIllllIII instanceof EntityPlayerMP)) {
                    return false;
                }
                final EntityPlayerMP lllllllllllllIIllIIlllllIllllIll = (EntityPlayerMP)lllllllllllllIIllIIlllllIllllIII;
                final GameType lllllllllllllIIllIIlllllIllllIlI = lllllllllllllIIllIIlllllIllllIll.interactionManager.getGameType();
                return llllllllllllllllIIIlIIIIIIIllllI ? (lllllllllllllIIllIIlllllIllllIlI != llllllllllllllllIIIlIIIIIIIllIIl) : (lllllllllllllIIllIIlllllIllllIlI == llllllllllllllllIIIlIIIIIIIllIIl);
            }
        });
        return llllllllllllllllIIIlIIIIIIlIIIII;
    }
    
    @Nullable
    public static <T extends Entity> T matchOneEntity(final ICommandSender llllllllllllllllIIIlIIIIlIlIlIIl, final String llllllllllllllllIIIlIIIIlIlIIlII, final Class<? extends T> llllllllllllllllIIIlIIIIlIlIIIll) throws CommandException {
        final List<T> llllllllllllllllIIIlIIIIlIlIIllI = matchEntities(llllllllllllllllIIIlIIIIlIlIlIIl, llllllllllllllllIIIlIIIIlIlIIlII, llllllllllllllllIIIlIIIIlIlIIIll);
        return (T)((llllllllllllllllIIIlIIIIlIlIIllI.size() == 1) ? ((T)llllllllllllllllIIIlIIIIlIlIIllI.get(0)) : null);
    }
    
    private static <T extends Entity> List<T> getEntitiesFromPredicates(List<T> llllllllllllllllIIIIllllIllIlIIl, final Map<String, String> llllllllllllllllIIIIllllIllIlIII, final ICommandSender llllllllllllllllIIIIllllIllIIlll, final Class<? extends T> llllllllllllllllIIIIllllIllIlllI, final String llllllllllllllllIIIIllllIllIIlIl, final Vec3d llllllllllllllllIIIIllllIllIllII) {
        final int llllllllllllllllIIIIllllIllIlIll = getInt(llllllllllllllllIIIIllllIllIlIII, EntitySelector.field_190845_s, (!llllllllllllllllIIIIllllIllIIlIl.equals("a") && !llllllllllllllllIIIIllllIllIIlIl.equals("e")) ? 1 : 0);
        if (!llllllllllllllllIIIIllllIllIIlIl.equals("p") && !llllllllllllllllIIIIllllIllIIlIl.equals("a") && !llllllllllllllllIIIIllllIllIIlIl.equals("e")) {
            if (llllllllllllllllIIIIllllIllIIlIl.equals("r")) {
                Collections.shuffle(llllllllllllllllIIIIllllIllIlIIl);
            }
        }
        else {
            Collections.sort(llllllllllllllllIIIIllllIllIlIIl, new Comparator<Entity>() {
                @Override
                public int compare(final Entity lllllllllllllIlllIllIllIIIIIIIIl, final Entity lllllllllllllIlllIllIllIIIIIIIII) {
                    return ComparisonChain.start().compare(lllllllllllllIlllIllIllIIIIIIIIl.getDistanceSq(llllllllllllllllIIIIllllIllIllII.xCoord, llllllllllllllllIIIIllllIllIllII.yCoord, llllllllllllllllIIIIllllIllIllII.zCoord), lllllllllllllIlllIllIllIIIIIIIII.getDistanceSq(llllllllllllllllIIIIllllIllIllII.xCoord, llllllllllllllllIIIIllllIllIllII.yCoord, llllllllllllllllIIIIllllIllIllII.zCoord)).result();
                }
            });
        }
        final Entity llllllllllllllllIIIIllllIllIlIlI = llllllllllllllllIIIIllllIllIIlll.getCommandSenderEntity();
        if (llllllllllllllllIIIIllllIllIlIlI != null && llllllllllllllllIIIIllllIllIlllI.isAssignableFrom(llllllllllllllllIIIIllllIllIlIlI.getClass()) && llllllllllllllllIIIIllllIllIlIll == 1 && llllllllllllllllIIIIllllIllIlIIl.contains(llllllllllllllllIIIIllllIllIlIlI) && !"r".equals(llllllllllllllllIIIIllllIllIIlIl)) {
            llllllllllllllllIIIIllllIllIlIIl = (List<T>)Lists.newArrayList((Object[])new Entity[] { llllllllllllllllIIIIllllIllIlIlI });
        }
        if (llllllllllllllllIIIIllllIllIlIll != 0) {
            if (llllllllllllllllIIIIllllIllIlIll < 0) {
                Collections.reverse(llllllllllllllllIIIIllllIllIlIIl);
            }
            llllllllllllllllIIIIllllIllIlIIl = llllllllllllllllIIIIllllIllIlIIl.subList(0, Math.min(Math.abs(llllllllllllllllIIIIllllIllIlIll), llllllllllllllllIIIIllllIllIlIIl.size()));
        }
        return llllllllllllllllIIIIllllIllIlIIl;
    }
    
    private static AxisAlignedBB getAABB(final BlockPos llllllllllllllllIIIIllllIlIIIlll, final int llllllllllllllllIIIIllllIlIIIllI, final int llllllllllllllllIIIIllllIlIlIIlI, final int llllllllllllllllIIIIllllIlIIIlII) {
        final boolean llllllllllllllllIIIIllllIlIlIIII = llllllllllllllllIIIIllllIlIIIllI < 0;
        final boolean llllllllllllllllIIIIllllIlIIllll = llllllllllllllllIIIIllllIlIlIIlI < 0;
        final boolean llllllllllllllllIIIIllllIlIIlllI = llllllllllllllllIIIIllllIlIIIlII < 0;
        final int llllllllllllllllIIIIllllIlIIllIl = llllllllllllllllIIIIllllIlIIIlll.getX() + (llllllllllllllllIIIIllllIlIlIIII ? llllllllllllllllIIIIllllIlIIIllI : 0);
        final int llllllllllllllllIIIIllllIlIIllII = llllllllllllllllIIIIllllIlIIIlll.getY() + (llllllllllllllllIIIIllllIlIIllll ? llllllllllllllllIIIIllllIlIlIIlI : 0);
        final int llllllllllllllllIIIIllllIlIIlIll = llllllllllllllllIIIIllllIlIIIlll.getZ() + (llllllllllllllllIIIIllllIlIIlllI ? llllllllllllllllIIIIllllIlIIIlII : 0);
        final int llllllllllllllllIIIIllllIlIIlIlI = llllllllllllllllIIIIllllIlIIIlll.getX() + (llllllllllllllllIIIIllllIlIlIIII ? 0 : llllllllllllllllIIIIllllIlIIIllI) + 1;
        final int llllllllllllllllIIIIllllIlIIlIIl = llllllllllllllllIIIIllllIlIIIlll.getY() + (llllllllllllllllIIIIllllIlIIllll ? 0 : llllllllllllllllIIIIllllIlIlIIlI) + 1;
        final int llllllllllllllllIIIIllllIlIIlIII = llllllllllllllllIIIIllllIlIIIlll.getZ() + (llllllllllllllllIIIIllllIlIIlllI ? 0 : llllllllllllllllIIIIllllIlIIIlII) + 1;
        return new AxisAlignedBB(llllllllllllllllIIIIllllIlIIllIl, llllllllllllllllIIIIllllIlIIllII, llllllllllllllllIIIIllllIlIIlIll, llllllllllllllllIIIIllllIlIIlIlI, llllllllllllllllIIIIllllIlIIlIIl, llllllllllllllllIIIIllllIlIIlIII);
    }
    
    private static List<Predicate<Entity>> getRadiusPredicates(final Map<String, String> llllllllllllllllIIIIllllllIlIIlI, final Vec3d llllllllllllllllIIIIllllllIIIlll) {
        final double llllllllllllllllIIIIllllllIlIIII = getInt(llllllllllllllllIIIIllllllIlIIlI, EntitySelector.field_190832_f, -1);
        final double llllllllllllllllIIIIllllllIIllll = getInt(llllllllllllllllIIIIllllllIlIIlI, EntitySelector.field_190831_e, -1);
        final boolean llllllllllllllllIIIIllllllIIlllI = llllllllllllllllIIIIllllllIlIIII < -0.5;
        final boolean llllllllllllllllIIIIllllllIIllIl = llllllllllllllllIIIIllllllIIllll < -0.5;
        if (llllllllllllllllIIIIllllllIIlllI && llllllllllllllllIIIIllllllIIllIl) {
            return Collections.emptyList();
        }
        final double llllllllllllllllIIIIllllllIIllII = Math.max(llllllllllllllllIIIIllllllIlIIII, 1.0E-4);
        final double llllllllllllllllIIIIllllllIIlIll = llllllllllllllllIIIIllllllIIllII * llllllllllllllllIIIIllllllIIllII;
        final double llllllllllllllllIIIIllllllIIlIlI = Math.max(llllllllllllllllIIIIllllllIIllll, 1.0E-4);
        final double llllllllllllllllIIIIllllllIIlIIl = llllllllllllllllIIIIllllllIIlIlI * llllllllllllllllIIIIllllllIIlIlI;
        return (List<Predicate<Entity>>)Lists.newArrayList((Object[])new Predicate[] { (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllIIIlIIIIIlllIllIII) {
                    if (llllllllllllllIIIlIIIIIlllIllIII == null) {
                        return false;
                    }
                    final double llllllllllllllIIIlIIIIIlllIlIlll = llllllllllllllllIIIIllllllIIIlll.squareDistanceTo(llllllllllllllIIIlIIIIIlllIllIII.posX, llllllllllllllIIIlIIIIIlllIllIII.posY, llllllllllllllIIIlIIIIIlllIllIII.posZ);
                    return (llllllllllllllllIIIIllllllIIlllI || llllllllllllllIIIlIIIIIlllIlIlll >= llllllllllllllllIIIIllllllIIlIll) && (llllllllllllllllIIIIllllllIIllIl || llllllllllllllIIIlIIIIIlllIlIlll <= llllllllllllllllIIIIllllllIIlIIl);
                }
            } });
    }
    
    private static List<Predicate<Entity>> getTagPredicates(final Map<String, String> llllllllllllllllIIIIlllllllIIllI) {
        final List<Predicate<Entity>> llllllllllllllllIIIIlllllllIIlIl = (List<Predicate<Entity>>)Lists.newArrayList();
        String llllllllllllllllIIIIlllllllIIlII = getArgument(llllllllllllllllIIIIlllllllIIllI, EntitySelector.field_190850_x);
        final boolean llllllllllllllllIIIIlllllllIIIll = llllllllllllllllIIIIlllllllIIlII != null && llllllllllllllllIIIIlllllllIIlII.startsWith("!");
        if (llllllllllllllllIIIIlllllllIIIll) {
            llllllllllllllllIIIIlllllllIIlII = llllllllllllllllIIIIlllllllIIlII.substring(1);
        }
        if (llllllllllllllllIIIIlllllllIIlII != null) {
            final String llllllllllllllllIIIIlllllllIIIlI = llllllllllllllllIIIIlllllllIIlII;
            llllllllllllllllIIIIlllllllIIlIl.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIlIlIlIlIIIllIllIlI) {
                    if (lllllllllllllIlIlIlIlIIIllIllIlI == null) {
                        return false;
                    }
                    if ("".equals(llllllllllllllllIIIIlllllllIIIlI)) {
                        return lllllllllllllIlIlIlIlIIIllIllIlI.getTags().isEmpty() ^ llllllllllllllllIIIIlllllllIIIll;
                    }
                    return lllllllllllllIlIlIlIlIIIllIllIlI.getTags().contains(llllllllllllllllIIIIlllllllIIIlI) ^ llllllllllllllllIIIIlllllllIIIll;
                }
            });
        }
        return llllllllllllllllIIIIlllllllIIlIl;
    }
    
    public static boolean hasArguments(final String llllllllllllllllIIIIlllIllllIIII) {
        return EntitySelector.TOKEN_PATTERN.matcher(llllllllllllllllIIIIlllIllllIIII).matches();
    }
    
    private static List<Predicate<Entity>> getNamePredicates(final Map<String, String> llllllllllllllllIIIIllllllllIIII) {
        final List<Predicate<Entity>> llllllllllllllllIIIIllllllllIlII = (List<Predicate<Entity>>)Lists.newArrayList();
        String llllllllllllllllIIIIllllllllIIll = getArgument(llllllllllllllllIIIIllllllllIIII, EntitySelector.field_190848_v);
        final boolean llllllllllllllllIIIIllllllllIIlI = llllllllllllllllIIIIllllllllIIll != null && llllllllllllllllIIIIllllllllIIll.startsWith("!");
        if (llllllllllllllllIIIIllllllllIIlI) {
            llllllllllllllllIIIIllllllllIIll = llllllllllllllllIIIIllllllllIIll.substring(1);
        }
        if (llllllllllllllllIIIIllllllllIIll != null) {
            final String llllllllllllllllIIIIllllllllIIIl = llllllllllllllllIIIIllllllllIIll;
            llllllllllllllllIIIIllllllllIlII.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIlllIIIlIIIlIlllIIl) {
                    return lllllllllllllIlllIIIlIIIlIlllIIl != null && lllllllllllllIlllIIIlIIIlIlllIIl.getName().equals(llllllllllllllllIIIIllllllllIIIl) != llllllllllllllllIIIIllllllllIIlI;
                }
            });
        }
        return llllllllllllllllIIIIllllllllIlII;
    }
    
    private static Map<String, String> getArgumentMap(@Nullable final String llllllllllllllllIIIIlllIlllIIIll) throws CommandException {
        final Map<String, String> llllllllllllllllIIIIlllIlllIIlll = (Map<String, String>)Maps.newHashMap();
        if (llllllllllllllllIIIIlllIlllIIIll == null) {
            return llllllllllllllllIIIIlllIlllIIlll;
        }
        for (final String llllllllllllllllIIIIlllIlllIIllI : EntitySelector.field_190828_b.split((CharSequence)llllllllllllllllIIIIlllIlllIIIll)) {
            final Iterator<String> llllllllllllllllIIIIlllIlllIIlIl = EntitySelector.field_190829_c.split((CharSequence)llllllllllllllllIIIIlllIlllIIllI).iterator();
            final String llllllllllllllllIIIIlllIlllIIlII = llllllllllllllllIIIIlllIlllIIlIl.next();
            if (!EntitySelector.field_190851_y.apply((Object)llllllllllllllllIIIIlllIlllIIlII)) {
                throw new CommandException("commands.generic.selector_argument", new Object[] { llllllllllllllllIIIIlllIlllIIllI });
            }
            llllllllllllllllIIIIlllIlllIIlll.put(llllllllllllllllIIIIlllIlllIIlII, llllllllllllllllIIIIlllIlllIIlIl.hasNext() ? llllllllllllllllIIIIlllIlllIIlIl.next() : "");
        }
        return llllllllllllllllIIIIlllIlllIIlll;
    }
    
    private static String func_190826_c(final String llllllllllllllllIIIlIIIIlIlllIlI) {
        EntitySelector.field_190830_d.add(llllllllllllllllIIIlIIIIlIlllIlI);
        return llllllllllllllllIIIlIIIIlIlllIlI;
    }
    
    private static List<Predicate<Entity>> getTeamPredicates(final Map<String, String> llllllllllllllllIIIlIIIIIIIIllIl) {
        final List<Predicate<Entity>> llllllllllllllllIIIlIIIIIIIIllII = (List<Predicate<Entity>>)Lists.newArrayList();
        String llllllllllllllllIIIlIIIIIIIIlIll = getArgument(llllllllllllllllIIIlIIIIIIIIllIl, EntitySelector.field_190847_u);
        final boolean llllllllllllllllIIIlIIIIIIIIlIlI = llllllllllllllllIIIlIIIIIIIIlIll != null && llllllllllllllllIIIlIIIIIIIIlIll.startsWith("!");
        if (llllllllllllllllIIIlIIIIIIIIlIlI) {
            llllllllllllllllIIIlIIIIIIIIlIll = llllllllllllllllIIIlIIIIIIIIlIll.substring(1);
        }
        if (llllllllllllllllIIIlIIIIIIIIlIll != null) {
            final String llllllllllllllllIIIlIIIIIIIIlIIl = llllllllllllllllIIIlIIIIIIIIlIll;
            llllllllllllllllIIIlIIIIIIIIllII.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllIIlIllIIlllIIIIlII) {
                    if (!(llllllllllllllIIlIllIIlllIIIIlII instanceof EntityLivingBase)) {
                        return false;
                    }
                    final EntityLivingBase llllllllllllllIIlIllIIlllIIIlIII = (EntityLivingBase)llllllllllllllIIlIllIIlllIIIIlII;
                    final Team llllllllllllllIIlIllIIlllIIIIlll = llllllllllllllIIlIllIIlllIIIlIII.getTeam();
                    final String llllllllllllllIIlIllIIlllIIIIllI = (llllllllllllllIIlIllIIlllIIIIlll == null) ? "" : llllllllllllllIIlIllIIlllIIIIlll.getRegisteredName();
                    return llllllllllllllIIlIllIIlllIIIIllI.equals(llllllllllllllllIIIlIIIIIIIIlIIl) ^ llllllllllllllllIIIlIIIIIIIIlIlI;
                }
            });
        }
        return llllllllllllllllIIIlIIIIIIIIllII;
    }
    
    @Nullable
    public static ITextComponent matchEntitiesToTextComponent(final ICommandSender llllllllllllllllIIIlIIIIlIIllIll, final String llllllllllllllllIIIlIIIIlIIlIlIl) throws CommandException {
        final List<Entity> llllllllllllllllIIIlIIIIlIIllIIl = matchEntities(llllllllllllllllIIIlIIIIlIIllIll, llllllllllllllllIIIlIIIIlIIlIlIl, (Class<? extends Entity>)Entity.class);
        if (llllllllllllllllIIIlIIIIlIIllIIl.isEmpty()) {
            return null;
        }
        final List<ITextComponent> llllllllllllllllIIIlIIIIlIIllIII = (List<ITextComponent>)Lists.newArrayList();
        for (final Entity llllllllllllllllIIIlIIIIlIIlIlll : llllllllllllllllIIIlIIIIlIIllIIl) {
            llllllllllllllllIIIlIIIIlIIllIII.add(llllllllllllllllIIIlIIIIlIIlIlll.getDisplayName());
        }
        return CommandBase.join(llllllllllllllllIIIlIIIIlIIllIII);
    }
    
    private static boolean hasArgument(final Map<String, String> llllllllllllllllIIIIllllIIIlllll) {
        for (final String llllllllllllllllIIIIllllIIIllllI : EntitySelector.WORLD_BINDING_ARGS) {
            if (llllllllllllllllIIIIllllIIIlllll.containsKey(llllllllllllllllIIIIllllIIIllllI)) {
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    private static String getArgument(final Map<String, String> llllllllllllllllIIIIllllIIIIllIl, final String llllllllllllllllIIIIllllIIIIllII) {
        return llllllllllllllllIIIIllllIIIIllIl.get(llllllllllllllllIIIIllllIIIIllII);
    }
    
    private static BlockPos getBlockPosFromArguments(final Map<String, String> llllllllllllllllIIIIllllIIlllIII, final BlockPos llllllllllllllllIIIIllllIIllIlIl) {
        return new BlockPos(getInt(llllllllllllllllIIIIllllIIlllIII, EntitySelector.field_190835_i, llllllllllllllllIIIIllllIIllIlIl.getX()), getInt(llllllllllllllllIIIIllllIIlllIII, EntitySelector.field_190836_j, llllllllllllllllIIIIllllIIllIlIl.getY()), getInt(llllllllllllllllIIIIllllIIlllIII, EntitySelector.field_190837_k, llllllllllllllllIIIIllllIIllIlIl.getZ()));
    }
    
    private static int getInt(final Map<String, String> llllllllllllllllIIIIllllIIIlIlll, final String llllllllllllllllIIIIllllIIIlIllI, final int llllllllllllllllIIIIllllIIIlIIlI) {
        return llllllllllllllllIIIIllllIIIlIlll.containsKey(llllllllllllllllIIIIllllIIIlIllI) ? MathHelper.getInt(llllllllllllllllIIIIllllIIIlIlll.get(llllllllllllllllIIIIllllIIIlIllI), llllllllllllllllIIIIllllIIIlIIlI) : llllllllllllllllIIIIllllIIIlIIlI;
    }
    
    public static <T extends Entity> List<T> matchEntities(final ICommandSender llllllllllllllllIIIlIIIIIllIllII, final String llllllllllllllllIIIlIIIIIllIlIll, final Class<? extends T> llllllllllllllllIIIlIIIIIlllllII) throws CommandException {
        final Matcher llllllllllllllllIIIlIIIIIllllIll = EntitySelector.TOKEN_PATTERN.matcher(llllllllllllllllIIIlIIIIIllIlIll);
        if (!llllllllllllllllIIIlIIIIIllllIll.matches() || !llllllllllllllllIIIlIIIIIllIllII.canCommandSenderUseCommand(1, "@")) {
            return Collections.emptyList();
        }
        final Map<String, String> llllllllllllllllIIIlIIIIIllllIlI = getArgumentMap(llllllllllllllllIIIlIIIIIllllIll.group(2));
        if (!isEntityTypeValid(llllllllllllllllIIIlIIIIIllIllII, llllllllllllllllIIIlIIIIIllllIlI)) {
            return Collections.emptyList();
        }
        final String llllllllllllllllIIIlIIIIIllllIIl = llllllllllllllllIIIlIIIIIllllIll.group(1);
        final BlockPos llllllllllllllllIIIlIIIIIllllIII = getBlockPosFromArguments(llllllllllllllllIIIlIIIIIllllIlI, llllllllllllllllIIIlIIIIIllIllII.getPosition());
        final Vec3d llllllllllllllllIIIlIIIIIlllIlll = getPosFromArguments(llllllllllllllllIIIlIIIIIllllIlI, llllllllllllllllIIIlIIIIIllIllII.getPositionVector());
        final List<World> llllllllllllllllIIIlIIIIIlllIllI = getWorlds(llllllllllllllllIIIlIIIIIllIllII, llllllllllllllllIIIlIIIIIllllIlI);
        final List<T> llllllllllllllllIIIlIIIIIlllIlIl = (List<T>)Lists.newArrayList();
        for (final World llllllllllllllllIIIlIIIIIlllIlII : llllllllllllllllIIIlIIIIIlllIllI) {
            if (llllllllllllllllIIIlIIIIIlllIlII != null) {
                final List<Predicate<Entity>> llllllllllllllllIIIlIIIIIlllIIll = (List<Predicate<Entity>>)Lists.newArrayList();
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getTypePredicates(llllllllllllllllIIIlIIIIIllllIlI, llllllllllllllllIIIlIIIIIllllIIl));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getXpLevelPredicates(llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getGamemodePredicates(llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getTeamPredicates(llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getScorePredicates(llllllllllllllllIIIlIIIIIllIllII, llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getNamePredicates(llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getTagPredicates(llllllllllllllllIIIlIIIIIllllIlI));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getRadiusPredicates(llllllllllllllllIIIlIIIIIllllIlI, llllllllllllllllIIIlIIIIIlllIlll));
                llllllllllllllllIIIlIIIIIlllIIll.addAll(getRotationsPredicates(llllllllllllllllIIIlIIIIIllllIlI));
                if ("s".equalsIgnoreCase(llllllllllllllllIIIlIIIIIllllIIl)) {
                    final Entity llllllllllllllllIIIlIIIIIlllIIlI = llllllllllllllllIIIlIIIIIllIllII.getCommandSenderEntity();
                    if (llllllllllllllllIIIlIIIIIlllIIlI != null && llllllllllllllllIIIlIIIIIlllllII.isAssignableFrom(llllllllllllllllIIIlIIIIIlllIIlI.getClass())) {
                        if (llllllllllllllllIIIlIIIIIllllIlI.containsKey(EntitySelector.field_190838_l) || llllllllllllllllIIIlIIIIIllllIlI.containsKey(EntitySelector.field_190839_m) || llllllllllllllllIIIlIIIIIllllIlI.containsKey(EntitySelector.field_190840_n)) {
                            final int llllllllllllllllIIIlIIIIIlllIIIl = getInt(llllllllllllllllIIIlIIIIIllllIlI, EntitySelector.field_190838_l, 0);
                            final int llllllllllllllllIIIlIIIIIlllIIII = getInt(llllllllllllllllIIIlIIIIIllllIlI, EntitySelector.field_190839_m, 0);
                            final int llllllllllllllllIIIlIIIIIllIllll = getInt(llllllllllllllllIIIlIIIIIllllIlI, EntitySelector.field_190840_n, 0);
                            final AxisAlignedBB llllllllllllllllIIIlIIIIIllIlllI = getAABB(llllllllllllllllIIIlIIIIIllllIII, llllllllllllllllIIIlIIIIIlllIIIl, llllllllllllllllIIIlIIIIIlllIIII, llllllllllllllllIIIlIIIIIllIllll);
                            if (!llllllllllllllllIIIlIIIIIllIlllI.intersectsWith(llllllllllllllllIIIlIIIIIlllIIlI.getEntityBoundingBox())) {
                                return Collections.emptyList();
                            }
                        }
                        for (final Predicate<Entity> llllllllllllllllIIIlIIIIIllIllIl : llllllllllllllllIIIlIIIIIlllIIll) {
                            if (!llllllllllllllllIIIlIIIIIllIllIl.apply((Object)llllllllllllllllIIIlIIIIIlllIIlI)) {
                                return Collections.emptyList();
                            }
                        }
                        return (List<T>)Lists.newArrayList((Object[])new Entity[] { llllllllllllllllIIIlIIIIIlllIIlI });
                    }
                    return Collections.emptyList();
                }
                else {
                    llllllllllllllllIIIlIIIIIlllIlIl.addAll((Collection<? extends T>)filterResults(llllllllllllllllIIIlIIIIIllllIlI, (Class<? extends Entity>)llllllllllllllllIIIlIIIIIlllllII, llllllllllllllllIIIlIIIIIlllIIll, llllllllllllllllIIIlIIIIIllllIIl, llllllllllllllllIIIlIIIIIlllIlII, llllllllllllllllIIIlIIIIIllllIII));
                }
            }
        }
        return getEntitiesFromPredicates(llllllllllllllllIIIlIIIIIlllIlIl, llllllllllllllllIIIlIIIIIllllIlI, llllllllllllllllIIIlIIIIIllIllII, llllllllllllllllIIIlIIIIIlllllII, llllllllllllllllIIIlIIIIIllllIIl, llllllllllllllllIIIlIIIIIlllIlll);
    }
    
    public static List<EntityPlayerMP> func_193531_b(final ICommandSender llllllllllllllllIIIlIIIIlIlIllll, final String llllllllllllllllIIIlIIIIlIlIlllI) throws CommandException {
        return matchEntities(llllllllllllllllIIIlIIIIlIlIllll, llllllllllllllllIIIlIIIIlIlIlllI, (Class<? extends EntityPlayerMP>)EntityPlayerMP.class);
    }
    
    private static List<Predicate<Entity>> getXpLevelPredicates(final Map<String, String> llllllllllllllllIIIlIIIIIIlIlIll) {
        final List<Predicate<Entity>> llllllllllllllllIIIlIIIIIIlIlllI = (List<Predicate<Entity>>)Lists.newArrayList();
        final int llllllllllllllllIIIlIIIIIIlIllIl = getInt(llllllllllllllllIIIlIIIIIIlIlIll, EntitySelector.field_190834_h, -1);
        final int llllllllllllllllIIIlIIIIIIlIllII = getInt(llllllllllllllllIIIlIIIIIIlIlIll, EntitySelector.field_190833_g, -1);
        if (llllllllllllllllIIIlIIIIIIlIllIl > -1 || llllllllllllllllIIIlIIIIIIlIllII > -1) {
            llllllllllllllllIIIlIIIIIIlIlllI.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIIIlIIlllllllllIIIl) {
                    if (!(lllllllllllllIIIlIIlllllllllIIIl instanceof EntityPlayerMP)) {
                        return false;
                    }
                    final EntityPlayerMP lllllllllllllIIIlIIlllllllllIIII = (EntityPlayerMP)lllllllllllllIIIlIIlllllllllIIIl;
                    return (llllllllllllllllIIIlIIIIIIlIllIl <= -1 || lllllllllllllIIIlIIlllllllllIIII.experienceLevel >= llllllllllllllllIIIlIIIIIIlIllIl) && (llllllllllllllllIIIlIIIIIIlIllII <= -1 || lllllllllllllIIIlIIlllllllllIIII.experienceLevel <= llllllllllllllllIIIlIIIIIIlIllII);
                }
            });
        }
        return llllllllllllllllIIIlIIIIIIlIlllI;
    }
    
    private static <T extends Entity> List<T> filterResults(final Map<String, String> llllllllllllllllIIIIlllllIIllllI, final Class<? extends T> llllllllllllllllIIIIlllllIIIlIlI, final List<Predicate<Entity>> llllllllllllllllIIIIlllllIIlllII, final String llllllllllllllllIIIIlllllIIIlIII, final World llllllllllllllllIIIIlllllIIllIlI, final BlockPos llllllllllllllllIIIIlllllIIIIllI) {
        final List<T> llllllllllllllllIIIIlllllIIllIII = (List<T>)Lists.newArrayList();
        String llllllllllllllllIIIIlllllIIlIlll = getArgument(llllllllllllllllIIIIlllllIIllllI, EntitySelector.field_190849_w);
        llllllllllllllllIIIIlllllIIlIlll = ((llllllllllllllllIIIIlllllIIlIlll != null && llllllllllllllllIIIIlllllIIlIlll.startsWith("!")) ? llllllllllllllllIIIIlllllIIlIlll.substring(1) : llllllllllllllllIIIIlllllIIlIlll);
        final boolean llllllllllllllllIIIIlllllIIlIllI = !llllllllllllllllIIIIlllllIIIlIII.equals("e");
        final boolean llllllllllllllllIIIIlllllIIlIlIl = llllllllllllllllIIIIlllllIIIlIII.equals("r") && llllllllllllllllIIIIlllllIIlIlll != null;
        final int llllllllllllllllIIIIlllllIIlIlII = getInt(llllllllllllllllIIIIlllllIIllllI, EntitySelector.field_190838_l, 0);
        final int llllllllllllllllIIIIlllllIIlIIll = getInt(llllllllllllllllIIIIlllllIIllllI, EntitySelector.field_190839_m, 0);
        final int llllllllllllllllIIIIlllllIIlIIlI = getInt(llllllllllllllllIIIIlllllIIllllI, EntitySelector.field_190840_n, 0);
        final int llllllllllllllllIIIIlllllIIlIIIl = getInt(llllllllllllllllIIIIlllllIIllllI, EntitySelector.field_190831_e, -1);
        final Predicate<Entity> llllllllllllllllIIIIlllllIIlIIII = (Predicate<Entity>)Predicates.and((Iterable)llllllllllllllllIIIIlllllIIlllII);
        final Predicate<Entity> llllllllllllllllIIIIlllllIIIllll = (Predicate<Entity>)Predicates.and((Predicate)EntitySelectors.IS_ALIVE, (Predicate)llllllllllllllllIIIIlllllIIlIIII);
        if (!llllllllllllllllIIIIlllllIIllllI.containsKey(EntitySelector.field_190838_l) && !llllllllllllllllIIIIlllllIIllllI.containsKey(EntitySelector.field_190839_m) && !llllllllllllllllIIIIlllllIIllllI.containsKey(EntitySelector.field_190840_n)) {
            if (llllllllllllllllIIIIlllllIIlIIIl >= 0) {
                final AxisAlignedBB llllllllllllllllIIIIlllllIIIlllI = new AxisAlignedBB(llllllllllllllllIIIIlllllIIIIllI.getX() - llllllllllllllllIIIIlllllIIlIIIl, llllllllllllllllIIIIlllllIIIIllI.getY() - llllllllllllllllIIIIlllllIIlIIIl, llllllllllllllllIIIIlllllIIIIllI.getZ() - llllllllllllllllIIIIlllllIIlIIIl, llllllllllllllllIIIIlllllIIIIllI.getX() + llllllllllllllllIIIIlllllIIlIIIl + 1, llllllllllllllllIIIIlllllIIIIllI.getY() + llllllllllllllllIIIIlllllIIlIIIl + 1, llllllllllllllllIIIIlllllIIIIllI.getZ() + llllllllllllllllIIIIlllllIIlIIIl + 1);
                if (llllllllllllllllIIIIlllllIIlIllI && !llllllllllllllllIIIIlllllIIlIlIl) {
                    llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getPlayers((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIIllll));
                }
                else {
                    llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getEntitiesWithinAABB((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, llllllllllllllllIIIIlllllIIIlllI, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIIllll));
                }
            }
            else if (llllllllllllllllIIIIlllllIIIlIII.equals("a")) {
                llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getPlayers((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIlIIII));
            }
            else if (!llllllllllllllllIIIIlllllIIIlIII.equals("p") && (!llllllllllllllllIIIIlllllIIIlIII.equals("r") || llllllllllllllllIIIIlllllIIlIlIl)) {
                llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getEntities((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIIllll));
            }
            else {
                llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getPlayers((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIIllll));
            }
        }
        else {
            final AxisAlignedBB llllllllllllllllIIIIlllllIIIllIl = getAABB(llllllllllllllllIIIIlllllIIIIllI, llllllllllllllllIIIIlllllIIlIlII, llllllllllllllllIIIIlllllIIlIIll, llllllllllllllllIIIIlllllIIlIIlI);
            if (llllllllllllllllIIIIlllllIIlIllI && !llllllllllllllllIIIIlllllIIlIlIl) {
                final Predicate<Entity> llllllllllllllllIIIIlllllIIIllII = (Predicate<Entity>)new Predicate<Entity>() {
                    public boolean apply(@Nullable final Entity lllllllllllllIlIlIllllllIIIIIIll) {
                        return lllllllllllllIlIlIllllllIIIIIIll != null && llllllllllllllllIIIIlllllIIIllIl.intersectsWith(lllllllllllllIlIlIllllllIIIIIIll.getEntityBoundingBox());
                    }
                };
                llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getPlayers((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, (com.google.common.base.Predicate<? super Entity>)Predicates.and((Predicate)llllllllllllllllIIIIlllllIIIllll, (Predicate)llllllllllllllllIIIIlllllIIIllII)));
            }
            else {
                llllllllllllllllIIIIlllllIIllIII.addAll((Collection<? extends T>)llllllllllllllllIIIIlllllIIllIlI.getEntitiesWithinAABB((Class<? extends Entity>)llllllllllllllllIIIIlllllIIIlIlI, llllllllllllllllIIIIlllllIIIllIl, (com.google.common.base.Predicate<? super Entity>)llllllllllllllllIIIIlllllIIIllll));
            }
        }
        return llllllllllllllllIIIIlllllIIllIII;
    }
    
    @Nullable
    public static EntityPlayerMP matchOnePlayer(final ICommandSender llllllllllllllllIIIlIIIIlIllIlll, final String llllllllllllllllIIIlIIIIlIllIlII) throws CommandException {
        return matchOneEntity(llllllllllllllllIIIlIIIIlIllIlll, llllllllllllllllIIIlIIIIlIllIlII, (Class<? extends EntityPlayerMP>)EntityPlayerMP.class);
    }
    
    public static boolean matchesMultiplePlayers(final String llllllllllllllllIIIIlllIllllIllI) throws CommandException {
        final Matcher llllllllllllllllIIIIlllIlllllIlI = EntitySelector.TOKEN_PATTERN.matcher(llllllllllllllllIIIIlllIllllIllI);
        if (!llllllllllllllllIIIIlllIlllllIlI.matches()) {
            return false;
        }
        final Map<String, String> llllllllllllllllIIIIlllIlllllIIl = getArgumentMap(llllllllllllllllIIIIlllIlllllIlI.group(2));
        final String llllllllllllllllIIIIlllIlllllIII = llllllllllllllllIIIIlllIlllllIlI.group(1);
        final int llllllllllllllllIIIIlllIllllIlll = (!"a".equals(llllllllllllllllIIIIlllIlllllIII) && !"e".equals(llllllllllllllllIIIIlllIlllllIII)) ? 1 : 0;
        return getInt(llllllllllllllllIIIIlllIlllllIIl, EntitySelector.field_190845_s, llllllllllllllllIIIIlllIllllIlll) != 1;
    }
    
    private static List<Predicate<Entity>> getRotationsPredicates(final Map<String, String> llllllllllllllllIIIIlllllIllIlII) {
        final List<Predicate<Entity>> llllllllllllllllIIIIlllllIlllIIl = (List<Predicate<Entity>>)Lists.newArrayList();
        if (llllllllllllllllIIIIlllllIllIlII.containsKey(EntitySelector.field_190844_r) || llllllllllllllllIIIIlllllIllIlII.containsKey(EntitySelector.field_190843_q)) {
            final int llllllllllllllllIIIIlllllIlllIII = MathHelper.clampAngle(getInt(llllllllllllllllIIIIlllllIllIlII, EntitySelector.field_190844_r, 0));
            final int llllllllllllllllIIIIlllllIllIlll = MathHelper.clampAngle(getInt(llllllllllllllllIIIIlllllIllIlII, EntitySelector.field_190843_q, 359));
            llllllllllllllllIIIIlllllIlllIIl.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllllIlIIIIIIlIlllIIlI) {
                    if (lllllllllllllllIlIIIIIIlIlllIIlI == null) {
                        return false;
                    }
                    final int lllllllllllllllIlIIIIIIlIlllIIIl = MathHelper.clampAngle(MathHelper.floor(lllllllllllllllIlIIIIIIlIlllIIlI.rotationYaw));
                    if (llllllllllllllllIIIIlllllIlllIII > llllllllllllllllIIIIlllllIllIlll) {
                        return lllllllllllllllIlIIIIIIlIlllIIIl >= llllllllllllllllIIIIlllllIlllIII || lllllllllllllllIlIIIIIIlIlllIIIl <= llllllllllllllllIIIIlllllIllIlll;
                    }
                    return lllllllllllllllIlIIIIIIlIlllIIIl >= llllllllllllllllIIIIlllllIlllIII && lllllllllllllllIlIIIIIIlIlllIIIl <= llllllllllllllllIIIIlllllIllIlll;
                }
            });
        }
        if (llllllllllllllllIIIIlllllIllIlII.containsKey(EntitySelector.field_190842_p) || llllllllllllllllIIIIlllllIllIlII.containsKey(EntitySelector.field_190841_o)) {
            final int llllllllllllllllIIIIlllllIllIllI = MathHelper.clampAngle(getInt(llllllllllllllllIIIIlllllIllIlII, EntitySelector.field_190842_p, 0));
            final int llllllllllllllllIIIIlllllIllIlIl = MathHelper.clampAngle(getInt(llllllllllllllllIIIIlllllIllIlII, EntitySelector.field_190841_o, 359));
            llllllllllllllllIIIIlllllIlllIIl.add((Predicate<Entity>)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIIllIIIIlIllIllIllI) {
                    if (lllllllllllllIIllIIIIlIllIllIllI == null) {
                        return false;
                    }
                    final int lllllllllllllIIllIIIIlIllIlllIII = MathHelper.clampAngle(MathHelper.floor(lllllllllllllIIllIIIIlIllIllIllI.rotationPitch));
                    if (llllllllllllllllIIIIlllllIllIllI > llllllllllllllllIIIIlllllIllIlIl) {
                        return lllllllllllllIIllIIIIlIllIlllIII >= llllllllllllllllIIIIlllllIllIllI || lllllllllllllIIllIIIIlIllIlllIII <= llllllllllllllllIIIIlllllIllIlIl;
                    }
                    return lllllllllllllIIllIIIIlIllIlllIII >= llllllllllllllllIIIIlllllIllIllI && lllllllllllllIIllIIIIlIllIlllIII <= llllllllllllllllIIIIlllllIllIlIl;
                }
            });
        }
        return llllllllllllllllIIIIlllllIlllIIl;
    }
    
    private static double getCoordinate(final Map<String, String> llllllllllllllllIIIIllllIIlIlIlI, final String llllllllllllllllIIIIllllIIlIlIIl, final double llllllllllllllllIIIIllllIIlIlIII, final boolean llllllllllllllllIIIIllllIIlIIIll) {
        return llllllllllllllllIIIIllllIIlIlIlI.containsKey(llllllllllllllllIIIIllllIIlIlIIl) ? (MathHelper.getInt(llllllllllllllllIIIIllllIIlIlIlI.get(llllllllllllllllIIIIllllIIlIlIIl), MathHelper.floor(llllllllllllllllIIIIllllIIlIlIII)) + (llllllllllllllllIIIIllllIIlIIIll ? 0.5 : 0.0)) : llllllllllllllllIIIIllllIIlIlIII;
    }
    
    private static <T extends Entity> boolean isEntityTypeValid(final ICommandSender llllllllllllllllIIIlIIIIIlIIllII, final Map<String, String> llllllllllllllllIIIlIIIIIlIIIllI) {
        final String llllllllllllllllIIIlIIIIIlIIlIlI = getArgument(llllllllllllllllIIIlIIIIIlIIIllI, EntitySelector.field_190849_w);
        if (llllllllllllllllIIIlIIIIIlIIlIlI == null) {
            return true;
        }
        final ResourceLocation llllllllllllllllIIIlIIIIIlIIlIIl = new ResourceLocation(llllllllllllllllIIIlIIIIIlIIlIlI.startsWith("!") ? llllllllllllllllIIIlIIIIIlIIlIlI.substring(1) : llllllllllllllllIIIlIIIIIlIIlIlI);
        if (EntityList.isStringValidEntityName(llllllllllllllllIIIlIIIIIlIIlIIl)) {
            return true;
        }
        final TextComponentTranslation llllllllllllllllIIIlIIIIIlIIlIII = new TextComponentTranslation("commands.generic.entity.invalidType", new Object[] { llllllllllllllllIIIlIIIIIlIIlIIl });
        llllllllllllllllIIIlIIIIIlIIlIII.getStyle().setColor(TextFormatting.RED);
        llllllllllllllllIIIlIIIIIlIIllII.addChatMessage(llllllllllllllllIIIlIIIIIlIIlIII);
        return false;
    }
    
    private static List<World> getWorlds(final ICommandSender llllllllllllllllIIIlIIIIIlIlIlll, final Map<String, String> llllllllllllllllIIIlIIIIIlIlIIll) {
        final List<World> llllllllllllllllIIIlIIIIIlIlIlIl = (List<World>)Lists.newArrayList();
        if (hasArgument(llllllllllllllllIIIlIIIIIlIlIIll)) {
            llllllllllllllllIIIlIIIIIlIlIlIl.add(llllllllllllllllIIIlIIIIIlIlIlll.getEntityWorld());
        }
        else {
            Collections.addAll(llllllllllllllllIIIlIIIIIlIlIlIl, llllllllllllllllIIIlIIIIIlIlIlll.getServer().worldServers);
        }
        return llllllllllllllllIIIlIIIIIlIlIlIl;
    }
    
    private static List<Predicate<Entity>> getScorePredicates(final ICommandSender llllllllllllllllIIIIllllllllllIl, final Map<String, String> llllllllllllllllIIIIllllllllllII) {
        final Map<String, Integer> llllllllllllllllIIIIlllllllllllI = getScoreMap(llllllllllllllllIIIIllllllllllII);
        return llllllllllllllllIIIIlllllllllllI.isEmpty() ? Collections.emptyList() : Lists.newArrayList((Object[])new Predicate[] { (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllllIlIIIlllIlIIIlIIlll) {
                    if (lllllllllllllIlIIIlllIlIIIlIIlll == null) {
                        return false;
                    }
                    final Scoreboard lllllllllllllIlIIIlllIlIIIlIIllI = llllllllllllllllIIIIllllllllllIl.getServer().worldServerForDimension(0).getScoreboard();
                    for (final Map.Entry<String, Integer> lllllllllllllIlIIIlllIlIIIlIIlIl : llllllllllllllllIIIIlllllllllllI.entrySet()) {
                        String lllllllllllllIlIIIlllIlIIIlIIlII = lllllllllllllIlIIIlllIlIIIlIIlIl.getKey();
                        boolean lllllllllllllIlIIIlllIlIIIlIIIll = false;
                        if (lllllllllllllIlIIIlllIlIIIlIIlII.endsWith("_min") && lllllllllllllIlIIIlllIlIIIlIIlII.length() > 4) {
                            lllllllllllllIlIIIlllIlIIIlIIIll = true;
                            lllllllllllllIlIIIlllIlIIIlIIlII = lllllllllllllIlIIIlllIlIIIlIIlII.substring(0, lllllllllllllIlIIIlllIlIIIlIIlII.length() - 4);
                        }
                        final ScoreObjective lllllllllllllIlIIIlllIlIIIlIIIlI = lllllllllllllIlIIIlllIlIIIlIIllI.getObjective(lllllllllllllIlIIIlllIlIIIlIIlII);
                        if (lllllllllllllIlIIIlllIlIIIlIIIlI == null) {
                            return false;
                        }
                        final String lllllllllllllIlIIIlllIlIIIlIIIIl = (lllllllllllllIlIIIlllIlIIIlIIlll instanceof EntityPlayerMP) ? lllllllllllllIlIIIlllIlIIIlIIlll.getName() : lllllllllllllIlIIIlllIlIIIlIIlll.getCachedUniqueIdString();
                        if (!lllllllllllllIlIIIlllIlIIIlIIllI.entityHasObjective(lllllllllllllIlIIIlllIlIIIlIIIIl, lllllllllllllIlIIIlllIlIIIlIIIlI)) {
                            return false;
                        }
                        final Score lllllllllllllIlIIIlllIlIIIlIIIII = lllllllllllllIlIIIlllIlIIIlIIllI.getOrCreateScore(lllllllllllllIlIIIlllIlIIIlIIIIl, lllllllllllllIlIIIlllIlIIIlIIIlI);
                        final int lllllllllllllIlIIIlllIlIIIIlllll = lllllllllllllIlIIIlllIlIIIlIIIII.getScorePoints();
                        if (lllllllllllllIlIIIlllIlIIIIlllll < lllllllllllllIlIIIlllIlIIIlIIlIl.getValue() && lllllllllllllIlIIIlllIlIIIlIIIll) {
                            return false;
                        }
                        if (lllllllllllllIlIIIlllIlIIIIlllll > lllllllllllllIlIIIlllIlIIIlIIlIl.getValue() && !lllllllllllllIlIIIlllIlIIIlIIIll) {
                            return false;
                        }
                    }
                    return true;
                }
            } });
    }
    
    public static Map<String, Integer> getScoreMap(final Map<String, String> llllllllllllllllIIIIllllIIIIIlll) {
        final Map<String, Integer> llllllllllllllllIIIIllllIIIIIllI = (Map<String, Integer>)Maps.newHashMap();
        for (final String llllllllllllllllIIIIllllIIIIIlIl : llllllllllllllllIIIIllllIIIIIlll.keySet()) {
            if (llllllllllllllllIIIIllllIIIIIlIl.startsWith("score_") && llllllllllllllllIIIIllllIIIIIlIl.length() > "score_".length()) {
                llllllllllllllllIIIIllllIIIIIllI.put(llllllllllllllllIIIIllllIIIIIlIl.substring("score_".length()), MathHelper.getInt(llllllllllllllllIIIIllllIIIIIlll.get(llllllllllllllllIIIIllllIIIIIlIl), 1));
            }
        }
        return llllllllllllllllIIIIllllIIIIIllI;
    }
    
    static {
        TOKEN_PATTERN = Pattern.compile("^@([pares])(?:\\[([^ ]*)\\])?$");
        field_190828_b = Splitter.on(',').omitEmptyStrings();
        field_190829_c = Splitter.on('=').limit(2);
        field_190830_d = Sets.newHashSet();
        field_190831_e = func_190826_c("r");
        field_190832_f = func_190826_c("rm");
        field_190833_g = func_190826_c("l");
        field_190834_h = func_190826_c("lm");
        field_190835_i = func_190826_c("x");
        field_190836_j = func_190826_c("y");
        field_190837_k = func_190826_c("z");
        field_190838_l = func_190826_c("dx");
        field_190839_m = func_190826_c("dy");
        field_190840_n = func_190826_c("dz");
        field_190841_o = func_190826_c("rx");
        field_190842_p = func_190826_c("rxm");
        field_190843_q = func_190826_c("ry");
        field_190844_r = func_190826_c("rym");
        field_190845_s = func_190826_c("c");
        field_190846_t = func_190826_c("m");
        field_190847_u = func_190826_c("team");
        field_190848_v = func_190826_c("name");
        field_190849_w = func_190826_c("type");
        field_190850_x = func_190826_c("tag");
        field_190851_y = (Predicate)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllllllIIllIlIlIIIllllll) {
                return lllllllllllllllIIllIlIlIIIllllll != null && (EntitySelector.field_190830_d.contains(lllllllllllllllIIllIlIlIIIllllll) || (lllllllllllllllIIllIlIlIIIllllll.length() > "score_".length() && lllllllllllllllIIllIlIlIIIllllll.startsWith("score_")));
            }
        };
        WORLD_BINDING_ARGS = Sets.newHashSet((Object[])new String[] { EntitySelector.field_190835_i, EntitySelector.field_190836_j, EntitySelector.field_190837_k, EntitySelector.field_190838_l, EntitySelector.field_190839_m, EntitySelector.field_190840_n, EntitySelector.field_190832_f, EntitySelector.field_190831_e });
    }
    
    private static List<Predicate<Entity>> getTypePredicates(final Map<String, String> llllllllllllllllIIIlIIIIIIlllIII, final String llllllllllllllllIIIlIIIIIIllIlll) {
        final String llllllllllllllllIIIlIIIIIIlllIll = getArgument(llllllllllllllllIIIlIIIIIIlllIII, EntitySelector.field_190849_w);
        if (llllllllllllllllIIIlIIIIIIlllIll == null || (!llllllllllllllllIIIlIIIIIIllIlll.equals("e") && !llllllllllllllllIIIlIIIIIIllIlll.equals("r") && !llllllllllllllllIIIlIIIIIIllIlll.equals("s"))) {
            return (List<Predicate<Entity>>)((llllllllllllllllIIIlIIIIIIllIlll.equals("e") || llllllllllllllllIIIlIIIIIIllIlll.equals("s")) ? Collections.emptyList() : Collections.singletonList(new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllIIIIlllIIIllIIIIII) {
                    return llllllllllllllIIIIlllIIIllIIIIII instanceof EntityPlayer;
                }
            }));
        }
        final boolean llllllllllllllllIIIlIIIIIIlllIlI = llllllllllllllllIIIlIIIIIIlllIll.startsWith("!");
        final ResourceLocation llllllllllllllllIIIlIIIIIIlllIIl = new ResourceLocation(llllllllllllllllIIIlIIIIIIlllIlI ? llllllllllllllllIIIlIIIIIIlllIll.substring(1) : llllllllllllllllIIIlIIIIIIlllIll);
        return Collections.singletonList((Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllllIIlllIlIIllIlIlII) {
                return EntityList.isStringEntityName(lllllllllllllllIIlllIlIIllIlIlII, llllllllllllllllIIIlIIIIIIlllIIl) ^ llllllllllllllllIIIlIIIIIIlllIlI;
            }
        });
    }
    
    private static Vec3d getPosFromArguments(final Map<String, String> llllllllllllllllIIIIllllIIllIIlI, final Vec3d llllllllllllllllIIIIllllIIlIllll) {
        return new Vec3d(getCoordinate(llllllllllllllllIIIIllllIIllIIlI, EntitySelector.field_190835_i, llllllllllllllllIIIIllllIIlIllll.xCoord, true), getCoordinate(llllllllllllllllIIIIllllIIllIIlI, EntitySelector.field_190836_j, llllllllllllllllIIIIllllIIlIllll.yCoord, false), getCoordinate(llllllllllllllllIIIIllllIIllIIlI, EntitySelector.field_190837_k, llllllllllllllllIIIIllllIIlIllll.zCoord, true));
    }
}
