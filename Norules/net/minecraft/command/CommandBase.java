package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.block.properties.*;
import java.util.*;
import com.google.gson.*;
import org.apache.commons.lang3.exception.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import com.google.common.primitives.*;

public abstract class CommandBase implements ICommand
{
    private static /* synthetic */ ICommandListener commandListener;
    private static final /* synthetic */ Splitter field_190797_c;
    private static final /* synthetic */ Splitter field_190796_b;
    
    public static int parseInt(final String lllllllllllllllIIllIIIIlIllIlIII, final int lllllllllllllllIIllIIIIlIllIIlll) throws NumberInvalidException {
        return parseInt(lllllllllllllllIIllIIIIlIllIlIII, lllllllllllllllIIllIIIIlIllIIlll, Integer.MAX_VALUE);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllIIlIlllllIlllIIll, final int lllllllllllllllIIlIlllllIlllIIlI) {
        return false;
    }
    
    public static Entity getEntity(final MinecraftServer lllllllllllllllIIllIIIIIllllIlll, final ICommandSender lllllllllllllllIIllIIIIIllllIllI, final String lllllllllllllllIIllIIIIIllllIIlI) throws EntityNotFoundException, CommandException {
        return getEntity(lllllllllllllllIIllIIIIIllllIlll, lllllllllllllllIIllIIIIIllllIllI, lllllllllllllllIIllIIIIIllllIIlI, (Class<? extends Entity>)Entity.class);
    }
    
    public static String buildString(final String[] lllllllllllllllIIllIIIIIlIIlIlII, final int lllllllllllllllIIllIIIIIlIIlIIll) {
        final StringBuilder lllllllllllllllIIllIIIIIlIIlIIlI = new StringBuilder();
        for (int lllllllllllllllIIllIIIIIlIIlIIIl = lllllllllllllllIIllIIIIIlIIlIIll; lllllllllllllllIIllIIIIIlIIlIIIl < lllllllllllllllIIllIIIIIlIIlIlII.length; ++lllllllllllllllIIllIIIIIlIIlIIIl) {
            if (lllllllllllllllIIllIIIIIlIIlIIIl > lllllllllllllllIIllIIIIIlIIlIIll) {
                lllllllllllllllIIllIIIIIlIIlIIlI.append(" ");
            }
            final String lllllllllllllllIIllIIIIIlIIlIIII = lllllllllllllllIIllIIIIIlIIlIlII[lllllllllllllllIIllIIIIIlIIlIIIl];
            lllllllllllllllIIllIIIIIlIIlIIlI.append(lllllllllllllllIIllIIIIIlIIlIIII);
        }
        return String.valueOf(lllllllllllllllIIllIIIIIlIIlIIlI);
    }
    
    public static void notifyCommandListener(final ICommandSender lllllllllllllllIIlIlllllIlIllIll, final ICommand lllllllllllllllIIlIlllllIlIlllll, final int lllllllllllllllIIlIlllllIlIllIIl, final String lllllllllllllllIIlIlllllIlIlllIl, final Object... lllllllllllllllIIlIlllllIlIlIlll) {
        if (CommandBase.commandListener != null) {
            CommandBase.commandListener.notifyListener(lllllllllllllllIIlIlllllIlIllIll, lllllllllllllllIIlIlllllIlIlllll, lllllllllllllllIIlIlllllIlIllIIl, lllllllllllllllIIlIlllllIlIlllIl, lllllllllllllllIIlIlllllIlIlIlll);
        }
    }
    
    public static CoordinateArg parseCoordinate(final double lllllllllllllllIIllIIIIIlIIIIlll, final String lllllllllllllllIIllIIIIIlIIIIIll, final boolean lllllllllllllllIIllIIIIIlIIIIlIl) throws NumberInvalidException {
        return parseCoordinate(lllllllllllllllIIllIIIIIlIIIIlll, lllllllllllllllIIllIIIIIlIIIIIll, -30000000, 30000000, lllllllllllllllIIllIIIIIlIIIIlIl);
    }
    
    public static boolean parseBoolean(final String lllllllllllllllIIllIIIIlIIIlllll) throws CommandException {
        if ("true".equals(lllllllllllllllIIllIIIIlIIIlllll) || "1".equals(lllllllllllllllIIllIIIIlIIIlllll)) {
            return true;
        }
        if (!"false".equals(lllllllllllllllIIllIIIIlIIIlllll) && !"0".equals(lllllllllllllllIIllIIIIlIIIlllll)) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[] { lllllllllllllllIIllIIIIlIIIlllll });
        }
        return false;
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllllllIIllIIIIlIllllIll, final ICommandSender lllllllllllllllIIllIIIIlIllllIlI) {
        return lllllllllllllllIIllIIIIlIllllIlI.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }
    
    public static <T extends Entity> T getEntity(final MinecraftServer lllllllllllllllIIllIIIIIlllIIlII, final ICommandSender lllllllllllllllIIllIIIIIlllIlIlI, final String lllllllllllllllIIllIIIIIlllIIIlI, final Class<? extends T> lllllllllllllllIIllIIIIIlllIlIII) throws CommandException, EntityNotFoundException {
        Entity lllllllllllllllIIllIIIIIlllIIlll = EntitySelector.matchOneEntity(lllllllllllllllIIllIIIIIlllIlIlI, lllllllllllllllIIllIIIIIlllIIIlI, (Class<? extends Entity>)lllllllllllllllIIllIIIIIlllIlIII);
        if (lllllllllllllllIIllIIIIIlllIIlll == null) {
            lllllllllllllllIIllIIIIIlllIIlll = lllllllllllllllIIllIIIIIlllIIlII.getPlayerList().getPlayerByUsername(lllllllllllllllIIllIIIIIlllIIIlI);
        }
        if (lllllllllllllllIIllIIIIIlllIIlll == null) {
            try {
                final UUID lllllllllllllllIIllIIIIIlllIIllI = UUID.fromString(lllllllllllllllIIllIIIIIlllIIIlI);
                lllllllllllllllIIllIIIIIlllIIlll = lllllllllllllllIIllIIIIIlllIIlII.getEntityFromUuid(lllllllllllllllIIllIIIIIlllIIllI);
                if (lllllllllllllllIIllIIIIIlllIIlll == null) {
                    lllllllllllllllIIllIIIIIlllIIlll = lllllllllllllllIIllIIIIIlllIIlII.getPlayerList().getPlayerByUUID(lllllllllllllllIIllIIIIIlllIIllI);
                }
            }
            catch (IllegalArgumentException lllllllllllllllIIllIIIIIlllIIlIl) {
                if (lllllllllllllllIIllIIIIIlllIIIlI.split("-").length == 5) {
                    throw new EntityNotFoundException("commands.generic.entity.invalidUuid", new Object[] { lllllllllllllllIIllIIIIIlllIIIlI });
                }
            }
        }
        if (lllllllllllllllIIllIIIIIlllIIlll != null && lllllllllllllllIIllIIIIIlllIlIII.isAssignableFrom(lllllllllllllllIIllIIIIIlllIIlll.getClass())) {
            return (T)lllllllllllllllIIllIIIIIlllIIlll;
        }
        throw new EntityNotFoundException(lllllllllllllllIIllIIIIIlllIIIlI);
    }
    
    public static double parseDouble(final double lllllllllllllllIIllIIIIIIlIIllll, String lllllllllllllllIIllIIIIIIlIIlllI, final int lllllllllllllllIIllIIIIIIlIIllIl, final int lllllllllllllllIIllIIIIIIlIlIlII, final boolean lllllllllllllllIIllIIIIIIlIlIIll) throws NumberInvalidException {
        final boolean lllllllllllllllIIllIIIIIIlIlIIlI = lllllllllllllllIIllIIIIIIlIIlllI.startsWith("~");
        if (lllllllllllllllIIllIIIIIIlIlIIlI && Double.isNaN(lllllllllllllllIIllIIIIIIlIIllll)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIIIlIIllll });
        }
        double lllllllllllllllIIllIIIIIIlIlIIIl = lllllllllllllllIIllIIIIIIlIlIIlI ? lllllllllllllllIIllIIIIIIlIIllll : 0.0;
        if (!lllllllllllllllIIllIIIIIIlIlIIlI || lllllllllllllllIIllIIIIIIlIIlllI.length() > 1) {
            final boolean lllllllllllllllIIllIIIIIIlIlIIII = lllllllllllllllIIllIIIIIIlIIlllI.contains(".");
            if (lllllllllllllllIIllIIIIIIlIlIIlI) {
                lllllllllllllllIIllIIIIIIlIIlllI = lllllllllllllllIIllIIIIIIlIIlllI.substring(1);
            }
            lllllllllllllllIIllIIIIIIlIlIIIl += parseDouble(lllllllllllllllIIllIIIIIIlIIlllI);
            if (!lllllllllllllllIIllIIIIIIlIlIIII && !lllllllllllllllIIllIIIIIIlIlIIlI && lllllllllllllllIIllIIIIIIlIlIIll) {
                lllllllllllllllIIllIIIIIIlIlIIIl += 0.5;
            }
        }
        if (lllllllllllllllIIllIIIIIIlIIllIl != 0 || lllllllllllllllIIllIIIIIIlIlIlII != 0) {
            if (lllllllllllllllIIllIIIIIIlIlIIIl < lllllllllllllllIIllIIIIIIlIIllIl) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIIIlIlIIIl), lllllllllllllllIIllIIIIIIlIIllIl });
            }
            if (lllllllllllllllIIllIIIIIIlIlIIIl > lllllllllllllllIIllIIIIIIlIlIlII) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIIIlIlIIIl), lllllllllllllllIIllIIIIIIlIlIlII });
            }
        }
        return lllllllllllllllIIllIIIIIIlIlIIIl;
    }
    
    public static CoordinateArg parseCoordinate(final double lllllllllllllllIIllIIIIIIlllIIII, String lllllllllllllllIIllIIIIIIllIllll, final int lllllllllllllllIIllIIIIIIlllIlll, final int lllllllllllllllIIllIIIIIIllIllIl, final boolean lllllllllllllllIIllIIIIIIllIllII) throws NumberInvalidException {
        final boolean lllllllllllllllIIllIIIIIIlllIlII = ((String)lllllllllllllllIIllIIIIIIllIllll).startsWith("~");
        if (lllllllllllllllIIllIIIIIIlllIlII && Double.isNaN(lllllllllllllllIIllIIIIIIlllIIII)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIIIlllIIII });
        }
        double lllllllllllllllIIllIIIIIIlllIIll = 0.0;
        if (!lllllllllllllllIIllIIIIIIlllIlII || ((String)lllllllllllllllIIllIIIIIIllIllll).length() > 1) {
            final boolean lllllllllllllllIIllIIIIIIlllIIlI = ((String)lllllllllllllllIIllIIIIIIllIllll).contains(".");
            if (lllllllllllllllIIllIIIIIIlllIlII) {
                lllllllllllllllIIllIIIIIIllIllll = ((String)lllllllllllllllIIllIIIIIIllIllll).substring(1);
            }
            lllllllllllllllIIllIIIIIIlllIIll += parseDouble((String)lllllllllllllllIIllIIIIIIllIllll);
            if (!lllllllllllllllIIllIIIIIIlllIIlI && !lllllllllllllllIIllIIIIIIlllIlII && lllllllllllllllIIllIIIIIIllIllII) {
                lllllllllllllllIIllIIIIIIlllIIll += 0.5;
            }
        }
        final double lllllllllllllllIIllIIIIIIlllIIIl = lllllllllllllllIIllIIIIIIlllIIll + (lllllllllllllllIIllIIIIIIlllIlII ? lllllllllllllllIIllIIIIIIlllIIII : 0.0);
        if (lllllllllllllllIIllIIIIIIlllIlll != 0 || lllllllllllllllIIllIIIIIIllIllIl != 0) {
            if (lllllllllllllllIIllIIIIIIlllIIIl < lllllllllllllllIIllIIIIIIlllIlll) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIIIlllIIIl), lllllllllllllllIIllIIIIIIlllIlll });
            }
            if (lllllllllllllllIIllIIIIIIlllIIIl > lllllllllllllllIIllIIIIIIllIllIl) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIIIlllIIIl), lllllllllllllllIIllIIIIIIllIllIl });
            }
        }
        return new CoordinateArg(lllllllllllllllIIllIIIIIIlllIIIl, lllllllllllllllIIllIIIIIIlllIIll, lllllllllllllllIIllIIIIIIlllIlII);
    }
    
    public static List<String> getListOfStringsMatchingLastWord(final String[] lllllllllllllllIIlIllllllIIIlIII, final String... lllllllllllllllIIlIllllllIIIlIIl) {
        return getListOfStringsMatchingLastWord(lllllllllllllllIIlIllllllIIIlIII, Arrays.asList(lllllllllllllllIIlIllllllIIIlIIl));
    }
    
    public static Block getBlockByText(final ICommandSender lllllllllllllllIIllIIIIIIIlllIll, final String lllllllllllllllIIllIIIIIIIlllIII) throws NumberInvalidException {
        final ResourceLocation lllllllllllllllIIllIIIIIIIlllIIl = new ResourceLocation(lllllllllllllllIIllIIIIIIIlllIII);
        if (!Block.REGISTRY.containsKey(lllllllllllllllIIllIIIIIIIlllIIl)) {
            throw new NumberInvalidException("commands.give.block.notFound", new Object[] { lllllllllllllllIIllIIIIIIIlllIIl });
        }
        return Block.REGISTRY.getObject(lllllllllllllllIIllIIIIIIIlllIIl);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllIIllIIIIlIlllIllI, final ICommandSender lllllllllllllllIIllIIIIlIlllIlIl, final String[] lllllllllllllllIIllIIIIlIlllIlII, @Nullable final BlockPos lllllllllllllllIIllIIIIlIlllIIll) {
        return Collections.emptyList();
    }
    
    private static Map<IProperty<?>, Comparable<?>> func_190795_c(final Block lllllllllllllllIIllIIIIIIIIIIIIl, final String lllllllllllllllIIllIIIIIIIIIIIII) throws InvalidBlockStateException {
        final Map<IProperty<?>, Comparable<?>> lllllllllllllllIIlIlllllllllllll = (Map<IProperty<?>, Comparable<?>>)Maps.newHashMap();
        if ("default".equals(lllllllllllllllIIllIIIIIIIIIIIII)) {
            return (Map<IProperty<?>, Comparable<?>>)lllllllllllllllIIllIIIIIIIIIIIIl.getDefaultState().getProperties();
        }
        final BlockStateContainer lllllllllllllllIIlIllllllllllllI = lllllllllllllllIIllIIIIIIIIIIIIl.getBlockState();
        for (final String lllllllllllllllIIlIlllllllllllII : CommandBase.field_190796_b.split((CharSequence)lllllllllllllllIIllIIIIIIIIIIIII)) {
            final Iterator<String> lllllllllllllllIIlIllllllllllIll = CommandBase.field_190797_c.split((CharSequence)lllllllllllllllIIlIlllllllllllII).iterator();
            if (lllllllllllllllIIlIllllllllllIll.hasNext()) {
                final IProperty<?> lllllllllllllllIIlIllllllllllIlI = lllllllllllllllIIlIllllllllllllI.getProperty(lllllllllllllllIIlIllllllllllIll.next());
                if (lllllllllllllllIIlIllllllllllIlI != null) {
                    if (lllllllllllllllIIlIllllllllllIll.hasNext()) {
                        final Comparable<?> lllllllllllllllIIlIllllllllllIIl = func_190792_a(lllllllllllllllIIlIllllllllllIlI, lllllllllllllllIIlIllllllllllIll.next());
                        if (lllllllllllllllIIlIllllllllllIIl != null) {
                            lllllllllllllllIIlIlllllllllllll.put(lllllllllllllllIIlIllllllllllIlI, lllllllllllllllIIlIllllllllllIIl);
                            continue;
                        }
                    }
                }
            }
            throw new InvalidBlockStateException("commands.generic.blockstate.invalid", new Object[] { lllllllllllllllIIllIIIIIIIIIIIII, Block.REGISTRY.getNameForObject(lllllllllllllllIIllIIIIIIIIIIIIl) });
        }
        return lllllllllllllllIIlIlllllllllllll;
    }
    
    public static String joinNiceStringFromCollection(final Collection<String> lllllllllllllllIIlIllllllIllIlIl) {
        return joinNiceString(lllllllllllllllIIlIllllllIllIlIl.toArray(new String[lllllllllllllllIIlIllllllIllIlIl.size()]));
    }
    
    public static String joinNiceString(final Object[] lllllllllllllllIIlIlllllllIlIlII) {
        final StringBuilder lllllllllllllllIIlIlllllllIlIIll = new StringBuilder();
        for (int lllllllllllllllIIlIlllllllIlIIlI = 0; lllllllllllllllIIlIlllllllIlIIlI < lllllllllllllllIIlIlllllllIlIlII.length; ++lllllllllllllllIIlIlllllllIlIIlI) {
            final String lllllllllllllllIIlIlllllllIlIIIl = lllllllllllllllIIlIlllllllIlIlII[lllllllllllllllIIlIlllllllIlIIlI].toString();
            if (lllllllllllllllIIlIlllllllIlIIlI > 0) {
                if (lllllllllllllllIIlIlllllllIlIIlI == lllllllllllllllIIlIlllllllIlIlII.length - 1) {
                    lllllllllllllllIIlIlllllllIlIIll.append(" and ");
                }
                else {
                    lllllllllllllllIIlIlllllllIlIIll.append(", ");
                }
            }
            lllllllllllllllIIlIlllllllIlIIll.append(lllllllllllllllIIlIlllllllIlIIIl);
        }
        return String.valueOf(lllllllllllllllIIlIlllllllIlIIll);
    }
    
    public static EntityPlayerMP getPlayer(final MinecraftServer lllllllllllllllIIllIIIIlIIIIlIII, final ICommandSender lllllllllllllllIIllIIIIlIIIIIlll, final String lllllllllllllllIIllIIIIlIIIIIllI) throws CommandException, PlayerNotFoundException {
        return func_193512_a(lllllllllllllllIIllIIIIlIIIIlIII, EntitySelector.matchOnePlayer(lllllllllllllllIIllIIIIlIIIIIlll, lllllllllllllllIIllIIIIlIIIIIllI), lllllllllllllllIIllIIIIlIIIIIllI);
    }
    
    protected static SyntaxErrorException toSyntaxException(final JsonParseException lllllllllllllllIIllIIIIllIIIllll) {
        final Throwable lllllllllllllllIIllIIIIllIIIlllI = ExceptionUtils.getRootCause((Throwable)lllllllllllllllIIllIIIIllIIIllll);
        String lllllllllllllllIIllIIIIllIIIllIl = "";
        if (lllllllllllllllIIllIIIIllIIIlllI != null) {
            lllllllllllllllIIllIIIIllIIIllIl = lllllllllllllllIIllIIIIllIIIlllI.getMessage();
            if (lllllllllllllllIIllIIIIllIIIllIl.contains("setLenient")) {
                lllllllllllllllIIllIIIIllIIIllIl = lllllllllllllllIIllIIIIllIIIllIl.substring(lllllllllllllllIIllIIIIllIIIllIl.indexOf("to accept ") + 10);
            }
        }
        return new SyntaxErrorException("commands.tellraw.jsonException", new Object[] { lllllllllllllllIIllIIIIllIIIllIl });
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }
    
    public int getRequiredPermissionLevel() {
        return 4;
    }
    
    public static String getPlayerName(final MinecraftServer lllllllllllllllIIllIIIIIllIlIIIl, final ICommandSender lllllllllllllllIIllIIIIIllIlIIII, final String lllllllllllllllIIllIIIIIllIIllll) throws PlayerNotFoundException, CommandException {
        try {
            return getPlayer(lllllllllllllllIIllIIIIIllIlIIIl, lllllllllllllllIIllIIIIIllIlIIII, lllllllllllllllIIllIIIIIllIIllll).getName();
        }
        catch (CommandException lllllllllllllllIIllIIIIIllIIlllI) {
            if (EntitySelector.hasArguments(lllllllllllllllIIllIIIIIllIIllll)) {
                throw lllllllllllllllIIllIIIIIllIIlllI;
            }
            return lllllllllllllllIIllIIIIIllIIllll;
        }
    }
    
    private static EntityPlayerMP func_193512_a(final MinecraftServer lllllllllllllllIIllIIIIlIIIIIIIl, @Nullable EntityPlayerMP lllllllllllllllIIllIIIIIllllllIl, final String lllllllllllllllIIllIIIIIllllllII) throws CommandException {
        if (lllllllllllllllIIllIIIIIllllllIl == null) {
            try {
                lllllllllllllllIIllIIIIIllllllIl = lllllllllllllllIIllIIIIlIIIIIIIl.getPlayerList().getPlayerByUUID(UUID.fromString(lllllllllllllllIIllIIIIIllllllII));
            }
            catch (IllegalArgumentException ex) {}
        }
        if (lllllllllllllllIIllIIIIIllllllIl == null) {
            lllllllllllllllIIllIIIIIllllllIl = lllllllllllllllIIllIIIIlIIIIIIIl.getPlayerList().getPlayerByUsername(lllllllllllllllIIllIIIIIllllllII);
        }
        if (lllllllllllllllIIllIIIIIllllllIl == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { lllllllllllllllIIllIIIIIllllllII });
        }
        return (EntityPlayerMP)lllllllllllllllIIllIIIIIllllllIl;
    }
    
    public static long parseLong(final String lllllllllllllllIIllIIIIlIlIIllII, final long lllllllllllllllIIllIIIIlIlIIllll, final long lllllllllllllllIIllIIIIlIlIIlllI) throws NumberInvalidException {
        final long lllllllllllllllIIllIIIIlIlIIllIl = parseLong(lllllllllllllllIIllIIIIlIlIIllII);
        if (lllllllllllllllIIllIIIIlIlIIllIl < lllllllllllllllIIllIIIIlIlIIllll) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllllllIIllIIIIlIlIIllIl, lllllllllllllllIIllIIIIlIlIIllll });
        }
        if (lllllllllllllllIIllIIIIlIlIIllIl > lllllllllllllllIIllIIIIlIlIIlllI) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllllllIIllIIIIlIlIIllIl, lllllllllllllllIIllIIIIlIlIIlllI });
        }
        return lllllllllllllllIIllIIIIlIlIIllIl;
    }
    
    public static int parseInt(final String lllllllllllllllIIllIIIIlIllIlllI) throws NumberInvalidException {
        try {
            return Integer.parseInt(lllllllllllllllIIllIIIIlIllIlllI);
        }
        catch (NumberFormatException lllllllllllllllIIllIIIIlIllIllll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIlIllIlllI });
        }
    }
    
    public static Item getItemByText(final ICommandSender lllllllllllllllIIllIIIIIIlIIIlII, final String lllllllllllllllIIllIIIIIIlIIIIll) throws NumberInvalidException {
        final ResourceLocation lllllllllllllllIIllIIIIIIlIIIIlI = new ResourceLocation(lllllllllllllllIIllIIIIIIlIIIIll);
        final Item lllllllllllllllIIllIIIIIIlIIIIIl = Item.REGISTRY.getObject(lllllllllllllllIIllIIIIIIlIIIIlI);
        if (lllllllllllllllIIllIIIIIIlIIIIIl == null) {
            throw new NumberInvalidException("commands.give.item.notFound", new Object[] { lllllllllllllllIIllIIIIIIlIIIIlI });
        }
        return lllllllllllllllIIllIIIIIIlIIIIIl;
    }
    
    @Nullable
    private static <T extends Comparable<T>> T func_190792_a(final IProperty<T> lllllllllllllllIIlIllllllllIlIIl, final String lllllllllllllllIIlIllllllllIlIII) {
        return (T)lllllllllllllllIIlIllllllllIlIIl.parseValue(lllllllllllllllIIlIllllllllIlIII).orNull();
    }
    
    static {
        field_190796_b = Splitter.on(',');
        field_190797_c = Splitter.on('=').limit(2);
    }
    
    public static void setCommandListener(final ICommandListener lllllllllllllllIIlIlllllIlIlIlII) {
        CommandBase.commandListener = lllllllllllllllIIlIlllllIlIlIlII;
    }
    
    public static Predicate<IBlockState> func_190791_b(final Block lllllllllllllllIIllIIIIIIIIIlllI, final String lllllllllllllllIIllIIIIIIIIIllIl) throws InvalidBlockStateException {
        if (!"*".equals(lllllllllllllllIIllIIIIIIIIIllIl) && !"-1".equals(lllllllllllllllIIllIIIIIIIIIllIl)) {
            try {
                final int lllllllllllllllIIllIIIIIIIIlIIIl = Integer.parseInt(lllllllllllllllIIllIIIIIIIIIllIl);
                return (Predicate<IBlockState>)new Predicate<IBlockState>() {
                    public boolean apply(@Nullable final IBlockState lllllllllllllIllIllIIIIllIIlllII) {
                        return lllllllllllllllIIllIIIIIIIIlIIIl == lllllllllllllIllIllIIIIllIIlllII.getBlock().getMetaFromState(lllllllllllllIllIllIIIIllIIlllII);
                    }
                };
            }
            catch (RuntimeException lllllllllllllllIIllIIIIIIIIlIIII) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllllllIIllIIIIIIIIIllll = func_190795_c(lllllllllllllllIIllIIIIIIIIIlllI, lllllllllllllllIIllIIIIIIIIIllIl);
                return (Predicate<IBlockState>)new Predicate<IBlockState>() {
                    public boolean apply(@Nullable final IBlockState lllllllllllllIllIlIllIllIlIIlIlI) {
                        if (lllllllllllllIllIlIllIllIlIIlIlI != null && lllllllllllllllIIllIIIIIIIIIlllI == lllllllllllllIllIlIllIllIlIIlIlI.getBlock()) {
                            for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllllIllIlIllIllIlIIlIIl : lllllllllllllllIIllIIIIIIIIIllll.entrySet()) {
                                if (!lllllllllllllIllIlIllIllIlIIlIlI.getValue(lllllllllllllIllIlIllIllIlIIlIIl.getKey()).equals(lllllllllllllIllIlIllIllIlIIlIIl.getValue())) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                };
            }
        }
        return (Predicate<IBlockState>)Predicates.alwaysTrue();
    }
    
    @Override
    public int compareTo(final ICommand lllllllllllllllIIlIlllllIlIlIIII) {
        return this.getCommandName().compareTo(lllllllllllllllIIlIlllllIlIlIIII.getCommandName());
    }
    
    public static NBTTagCompound entityToNBT(final Entity lllllllllllllllIIllIIIIllIIIIllI) {
        final NBTTagCompound lllllllllllllllIIllIIIIllIIIIlIl = lllllllllllllllIIllIIIIllIIIIllI.writeToNBT(new NBTTagCompound());
        if (lllllllllllllllIIllIIIIllIIIIllI instanceof EntityPlayer) {
            final ItemStack lllllllllllllllIIllIIIIllIIIIlII = ((EntityPlayer)lllllllllllllllIIllIIIIllIIIIllI).inventory.getCurrentItem();
            if (!lllllllllllllllIIllIIIIllIIIIlII.func_190926_b()) {
                lllllllllllllllIIllIIIIllIIIIlIl.setTag("SelectedItem", lllllllllllllllIIllIIIIllIIIIlII.writeToNBT(new NBTTagCompound()));
            }
        }
        return lllllllllllllllIIllIIIIllIIIIlIl;
    }
    
    public static int parseInt(final String lllllllllllllllIIllIIIIlIllIIIlI, final int lllllllllllllllIIllIIIIlIlIlllIl, final int lllllllllllllllIIllIIIIlIlIlllII) throws NumberInvalidException {
        final int lllllllllllllllIIllIIIIlIlIlllll = parseInt(lllllllllllllllIIllIIIIlIllIIIlI);
        if (lllllllllllllllIIllIIIIlIlIlllll < lllllllllllllllIIllIIIIlIlIlllIl) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllllllIIllIIIIlIlIlllll, lllllllllllllllIIllIIIIlIlIlllIl });
        }
        if (lllllllllllllllIIllIIIIlIlIlllll > lllllllllllllllIIllIIIIlIlIlllII) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllllllIIllIIIIlIlIlllll, lllllllllllllllIIllIIIIlIlIlllII });
        }
        return lllllllllllllllIIllIIIIlIlIlllll;
    }
    
    public static ITextComponent getChatComponentFromNthArg(final ICommandSender lllllllllllllllIIllIIIIIlIllIlll, final String[] lllllllllllllllIIllIIIIIlIllIIll, final int lllllllllllllllIIllIIIIIlIllIIlI) throws PlayerNotFoundException, CommandException {
        return getChatComponentFromNthArg(lllllllllllllllIIllIIIIIlIllIlll, lllllllllllllllIIllIIIIIlIllIIll, lllllllllllllllIIllIIIIIlIllIIlI, false);
    }
    
    public static String getEntityName(final MinecraftServer lllllllllllllllIIllIIIIIlIllllll, final ICommandSender lllllllllllllllIIllIIIIIllIIIIll, final String lllllllllllllllIIllIIIIIllIIIIlI) throws CommandException, EntityNotFoundException {
        try {
            return getPlayer(lllllllllllllllIIllIIIIIlIllllll, lllllllllllllllIIllIIIIIllIIIIll, lllllllllllllllIIllIIIIIllIIIIlI).getName();
        }
        catch (PlayerNotFoundException lllllllllllllllIIllIIIIIllIIIIIl) {
            try {
                return getEntity(lllllllllllllllIIllIIIIIlIllllll, lllllllllllllllIIllIIIIIllIIIIll, lllllllllllllllIIllIIIIIllIIIIlI).getCachedUniqueIdString();
            }
            catch (EntityNotFoundException lllllllllllllllIIllIIIIIllIIIIII) {
                if (EntitySelector.hasArguments(lllllllllllllllIIllIIIIIllIIIIlI)) {
                    throw lllllllllllllllIIllIIIIIllIIIIII;
                }
                return lllllllllllllllIIllIIIIIllIIIIlI;
            }
        }
    }
    
    public static List<String> getTabCompletionCoordinate(final String[] lllllllllllllllIIlIllllllIlIlllI, final int lllllllllllllllIIlIllllllIlIIllI, @Nullable final BlockPos lllllllllllllllIIlIllllllIlIllII) {
        if (lllllllllllllllIIlIllllllIlIllII == null) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { "~" });
        }
        final int lllllllllllllllIIlIllllllIlIlIll = lllllllllllllllIIlIllllllIlIlllI.length - 1;
        String lllllllllllllllIIlIllllllIlIlIII = null;
        if (lllllllllllllllIIlIllllllIlIlIll == lllllllllllllllIIlIllllllIlIIllI) {
            final String lllllllllllllllIIlIllllllIlIlIlI = Integer.toString(lllllllllllllllIIlIllllllIlIllII.getX());
        }
        else if (lllllllllllllllIIlIllllllIlIlIll == lllllllllllllllIIlIllllllIlIIllI + 1) {
            final String lllllllllllllllIIlIllllllIlIlIIl = Integer.toString(lllllllllllllllIIlIllllllIlIllII.getY());
        }
        else {
            if (lllllllllllllllIIlIllllllIlIlIll != lllllllllllllllIIlIllllllIlIIllI + 2) {
                return Collections.emptyList();
            }
            lllllllllllllllIIlIllllllIlIlIII = Integer.toString(lllllllllllllllIIlIllllllIlIllII.getZ());
        }
        return (List<String>)Lists.newArrayList((Object[])new String[] { lllllllllllllllIIlIllllllIlIlIII });
    }
    
    public static List<String> getListOfStringsMatchingLastWord(final String[] lllllllllllllllIIlIllllllIIIIIII, final Collection<?> lllllllllllllllIIlIlllllIlllllll) {
        final String lllllllllllllllIIlIlllllIllllllI = lllllllllllllllIIlIllllllIIIIIII[lllllllllllllllIIlIllllllIIIIIII.length - 1];
        final List<String> lllllllllllllllIIlIlllllIlllllIl = (List<String>)Lists.newArrayList();
        if (!lllllllllllllllIIlIlllllIlllllll.isEmpty()) {
            for (final String lllllllllllllllIIlIlllllIlllllII : Iterables.transform((Iterable)lllllllllllllllIIlIlllllIlllllll, Functions.toStringFunction())) {
                if (doesStringStartWith(lllllllllllllllIIlIlllllIllllllI, lllllllllllllllIIlIlllllIlllllII)) {
                    lllllllllllllllIIlIlllllIlllllIl.add(lllllllllllllllIIlIlllllIlllllII);
                }
            }
            if (lllllllllllllllIIlIlllllIlllllIl.isEmpty()) {
                for (final Object lllllllllllllllIIlIlllllIllllIll : lllllllllllllllIIlIlllllIlllllll) {
                    if (lllllllllllllllIIlIlllllIllllIll instanceof ResourceLocation && doesStringStartWith(lllllllllllllllIIlIlllllIllllllI, ((ResourceLocation)lllllllllllllllIIlIlllllIllllIll).getResourcePath())) {
                        lllllllllllllllIIlIlllllIlllllIl.add(String.valueOf(lllllllllllllllIIlIlllllIllllIll));
                    }
                }
            }
        }
        return lllllllllllllllIIlIlllllIlllllIl;
    }
    
    public static EntityPlayerMP getCommandSenderAsPlayer(final ICommandSender lllllllllllllllIIllIIIIlIIIlllII) throws PlayerNotFoundException {
        if (lllllllllllllllIIllIIIIlIIIlllII instanceof EntityPlayerMP) {
            return (EntityPlayerMP)lllllllllllllllIIllIIIIlIIIlllII;
        }
        throw new PlayerNotFoundException("commands.generic.player.unspecified");
    }
    
    public static BlockPos parseBlockPos(final ICommandSender lllllllllllllllIIllIIIIlIIlllllI, final String[] lllllllllllllllIIllIIIIlIlIIIIlI, final int lllllllllllllllIIllIIIIlIlIIIIIl, final boolean lllllllllllllllIIllIIIIlIIlllIll) throws NumberInvalidException {
        final BlockPos lllllllllllllllIIllIIIIlIIllllll = lllllllllllllllIIllIIIIlIIlllllI.getPosition();
        return new BlockPos(parseDouble(lllllllllllllllIIllIIIIlIIllllll.getX(), lllllllllllllllIIllIIIIlIlIIIIlI[lllllllllllllllIIllIIIIlIlIIIIIl], -30000000, 30000000, lllllllllllllllIIllIIIIlIIlllIll), parseDouble(lllllllllllllllIIllIIIIlIIllllll.getY(), lllllllllllllllIIllIIIIlIlIIIIlI[lllllllllllllllIIllIIIIlIlIIIIIl + 1], 0, 256, false), parseDouble(lllllllllllllllIIllIIIIlIIllllll.getZ(), lllllllllllllllIIllIIIIlIlIIIIlI[lllllllllllllllIIllIIIIlIlIIIIIl + 2], -30000000, 30000000, lllllllllllllllIIllIIIIlIIlllIll));
    }
    
    public static boolean doesStringStartWith(final String lllllllllllllllIIlIllllllIIlIIII, final String lllllllllllllllIIlIllllllIIIllIl) {
        return lllllllllllllllIIlIllllllIIIllIl.regionMatches(true, 0, lllllllllllllllIIlIllllllIIlIIII, 0, lllllllllllllllIIlIllllllIIlIIII.length());
    }
    
    public static ITextComponent getChatComponentFromNthArg(final ICommandSender lllllllllllllllIIllIIIIIlIlIIIIl, final String[] lllllllllllllllIIllIIIIIlIlIlIII, final int lllllllllllllllIIllIIIIIlIlIIlll, final boolean lllllllllllllllIIllIIIIIlIIllllI) throws CommandException, PlayerNotFoundException {
        final ITextComponent lllllllllllllllIIllIIIIIlIlIIlIl = new TextComponentString("");
        for (int lllllllllllllllIIllIIIIIlIlIIlII = lllllllllllllllIIllIIIIIlIlIIlll; lllllllllllllllIIllIIIIIlIlIIlII < lllllllllllllllIIllIIIIIlIlIlIII.length; ++lllllllllllllllIIllIIIIIlIlIIlII) {
            if (lllllllllllllllIIllIIIIIlIlIIlII > lllllllllllllllIIllIIIIIlIlIIlll) {
                lllllllllllllllIIllIIIIIlIlIIlIl.appendText(" ");
            }
            ITextComponent lllllllllllllllIIllIIIIIlIlIIIll = new TextComponentString(lllllllllllllllIIllIIIIIlIlIlIII[lllllllllllllllIIllIIIIIlIlIIlII]);
            if (lllllllllllllllIIllIIIIIlIIllllI) {
                final ITextComponent lllllllllllllllIIllIIIIIlIlIIIlI = EntitySelector.matchEntitiesToTextComponent(lllllllllllllllIIllIIIIIlIlIIIIl, lllllllllllllllIIllIIIIIlIlIlIII[lllllllllllllllIIllIIIIIlIlIIlII]);
                if (lllllllllllllllIIllIIIIIlIlIIIlI == null) {
                    if (EntitySelector.hasArguments(lllllllllllllllIIllIIIIIlIlIlIII[lllllllllllllllIIllIIIIIlIlIIlII])) {
                        throw new PlayerNotFoundException("commands.generic.selector.notFound", new Object[] { lllllllllllllllIIllIIIIIlIlIlIII[lllllllllllllllIIllIIIIIlIlIIlII] });
                    }
                }
                else {
                    lllllllllllllllIIllIIIIIlIlIIIll = lllllllllllllllIIllIIIIIlIlIIIlI;
                }
            }
            lllllllllllllllIIllIIIIIlIlIIlIl.appendSibling(lllllllllllllllIIllIIIIIlIlIIIll);
        }
        return lllllllllllllllIIllIIIIIlIlIIlIl;
    }
    
    public static double parseDouble(final String lllllllllllllllIIllIIIIlIIllIlII) throws NumberInvalidException {
        try {
            final double lllllllllllllllIIllIIIIlIIllIllI = Double.parseDouble(lllllllllllllllIIllIIIIlIIllIlII);
            if (!Doubles.isFinite(lllllllllllllllIIllIIIIlIIllIllI)) {
                throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIlIIllIlII });
            }
            return lllllllllllllllIIllIIIIlIIllIllI;
        }
        catch (NumberFormatException lllllllllllllllIIllIIIIlIIllIlIl) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIlIIllIlII });
        }
    }
    
    public static ITextComponent join(final List<ITextComponent> lllllllllllllllIIlIllllllIlllIIl) {
        final ITextComponent lllllllllllllllIIlIllllllIlllIll = new TextComponentString("");
        for (int lllllllllllllllIIlIllllllIlllIlI = 0; lllllllllllllllIIlIllllllIlllIlI < lllllllllllllllIIlIllllllIlllIIl.size(); ++lllllllllllllllIIlIllllllIlllIlI) {
            if (lllllllllllllllIIlIllllllIlllIlI > 0) {
                if (lllllllllllllllIIlIllllllIlllIlI == lllllllllllllllIIlIllllllIlllIIl.size() - 1) {
                    lllllllllllllllIIlIllllllIlllIll.appendText(" and ");
                }
                else if (lllllllllllllllIIlIllllllIlllIlI > 0) {
                    lllllllllllllllIIlIllllllIlllIll.appendText(", ");
                }
            }
            lllllllllllllllIIlIllllllIlllIll.appendSibling(lllllllllllllllIIlIllllllIlllIIl.get(lllllllllllllllIIlIllllllIlllIlI));
        }
        return lllllllllllllllIIlIllllllIlllIll;
    }
    
    public static void notifyCommandListener(final ICommandSender lllllllllllllllIIlIlllllIllIllIl, final ICommand lllllllllllllllIIlIlllllIllIllII, final String lllllllllllllllIIlIlllllIllIlIll, final Object... lllllllllllllllIIlIlllllIllIIllI) {
        notifyCommandListener(lllllllllllllllIIlIlllllIllIllIl, lllllllllllllllIIlIlllllIllIllII, 0, lllllllllllllllIIlIlllllIllIlIll, lllllllllllllllIIlIlllllIllIIllI);
    }
    
    public static List<String> getTabCompletionCoordinateXZ(final String[] lllllllllllllllIIlIllllllIIlllIl, final int lllllllllllllllIIlIllllllIIlIllI, @Nullable final BlockPos lllllllllllllllIIlIllllllIIllIll) {
        if (lllllllllllllllIIlIllllllIIllIll == null) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { "~" });
        }
        final int lllllllllllllllIIlIllllllIIllIlI = lllllllllllllllIIlIllllllIIlllIl.length - 1;
        String lllllllllllllllIIlIllllllIIllIII = null;
        if (lllllllllllllllIIlIllllllIIllIlI == lllllllllllllllIIlIllllllIIlIllI) {
            final String lllllllllllllllIIlIllllllIIllIIl = Integer.toString(lllllllllllllllIIlIllllllIIllIll.getX());
        }
        else {
            if (lllllllllllllllIIlIllllllIIllIlI != lllllllllllllllIIlIllllllIIlIllI + 1) {
                return Collections.emptyList();
            }
            lllllllllllllllIIlIllllllIIllIII = Integer.toString(lllllllllllllllIIlIllllllIIllIll.getZ());
        }
        return (List<String>)Lists.newArrayList((Object[])new String[] { lllllllllllllllIIlIllllllIIllIII });
    }
    
    public static double parseDouble(final double lllllllllllllllIIllIIIIIIllIIlIl, final String lllllllllllllllIIllIIIIIIllIIlII, final boolean lllllllllllllllIIllIIIIIIllIIIll) throws NumberInvalidException {
        return parseDouble(lllllllllllllllIIllIIIIIIllIIlIl, lllllllllllllllIIllIIIIIIllIIlII, -30000000, 30000000, lllllllllllllllIIllIIIIIIllIIIll);
    }
    
    private static <T extends Comparable<T>> IBlockState func_190793_a(final IBlockState lllllllllllllllIIllIIIIIIIIlllIl, final IProperty<T> lllllllllllllllIIllIIIIIIIIllIIl, final Comparable<?> lllllllllllllllIIllIIIIIIIIllIII) {
        return lllllllllllllllIIllIIIIIIIIlllIl.withProperty(lllllllllllllllIIllIIIIIIIIllIIl, lllllllllllllllIIllIIIIIIIIllIII);
    }
    
    public static double parseDouble(final String lllllllllllllllIIllIIIIlIIlIIlII, final double lllllllllllllllIIllIIIIlIIlIIlll, final double lllllllllllllllIIllIIIIlIIlIIIlI) throws NumberInvalidException {
        final double lllllllllllllllIIllIIIIlIIlIIlIl = parseDouble(lllllllllllllllIIllIIIIlIIlIIlII);
        if (lllllllllllllllIIllIIIIlIIlIIlIl < lllllllllllllllIIllIIIIlIIlIIlll) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIlIIlIIlIl), String.format("%.2f", lllllllllllllllIIllIIIIlIIlIIlll) });
        }
        if (lllllllllllllllIIllIIIIlIIlIIlIl > lllllllllllllllIIllIIIIlIIlIIIlI) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllllllIIllIIIIlIIlIIlIl), String.format("%.2f", lllllllllllllllIIllIIIIlIIlIIIlI) });
        }
        return lllllllllllllllIIllIIIIlIIlIIlIl;
    }
    
    public static long parseLong(final String lllllllllllllllIIllIIIIlIlIllIII) throws NumberInvalidException {
        try {
            return Long.parseLong(lllllllllllllllIIllIIIIlIlIllIII);
        }
        catch (NumberFormatException lllllllllllllllIIllIIIIlIlIlIlll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllllllIIllIIIIlIlIllIII });
        }
    }
    
    public static double parseDouble(final String lllllllllllllllIIllIIIIlIIlIlllI, final double lllllllllllllllIIllIIIIlIIlIllll) throws NumberInvalidException {
        return parseDouble(lllllllllllllllIIllIIIIlIIlIlllI, lllllllllllllllIIllIIIIlIIlIllll, Double.MAX_VALUE);
    }
    
    public static IBlockState func_190794_a(final Block lllllllllllllllIIllIIIIIIIlIllll, final String lllllllllllllllIIllIIIIIIIlIlllI) throws InvalidBlockStateException, NumberInvalidException {
        try {
            final int lllllllllllllllIIllIIIIIIIlIllIl = Integer.parseInt(lllllllllllllllIIllIIIIIIIlIlllI);
            if (lllllllllllllllIIllIIIIIIIlIllIl < 0) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllllllIIllIIIIIIIlIllIl, 0 });
            }
            if (lllllllllllllllIIllIIIIIIIlIllIl > 15) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllllllIIllIIIIIIIlIllIl, 15 });
            }
            return lllllllllllllllIIllIIIIIIIlIllll.getStateFromMeta(Integer.parseInt(lllllllllllllllIIllIIIIIIIlIlllI));
        }
        catch (RuntimeException lllllllllllllllIIllIIIIIIIlIllII) {
            try {
                final Map<IProperty<?>, Comparable<?>> lllllllllllllllIIllIIIIIIIlIlIll = func_190795_c(lllllllllllllllIIllIIIIIIIlIllll, lllllllllllllllIIllIIIIIIIlIlllI);
                IBlockState lllllllllllllllIIllIIIIIIIlIlIlI = lllllllllllllllIIllIIIIIIIlIllll.getDefaultState();
                for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllllllIIllIIIIIIIlIlIIl : lllllllllllllllIIllIIIIIIIlIlIll.entrySet()) {
                    lllllllllllllllIIllIIIIIIIlIlIlI = func_190793_a(lllllllllllllllIIllIIIIIIIlIlIlI, lllllllllllllllIIllIIIIIIIlIlIIl.getKey(), lllllllllllllllIIllIIIIIIIlIlIIl.getValue());
                }
                return lllllllllllllllIIllIIIIIIIlIlIlI;
            }
            catch (RuntimeException lllllllllllllllIIllIIIIIIIlIlIII) {
                throw new InvalidBlockStateException("commands.generic.blockstate.invalid", new Object[] { lllllllllllllllIIllIIIIIIIlIlllI, Block.REGISTRY.getNameForObject(lllllllllllllllIIllIIIIIIIlIllll) });
            }
        }
    }
    
    public static List<Entity> getEntityList(final MinecraftServer lllllllllllllllIIllIIIIIllIllIll, final ICommandSender lllllllllllllllIIllIIIIIllIllIlI, final String lllllllllllllllIIllIIIIIllIlIllI) throws EntityNotFoundException, CommandException {
        return EntitySelector.hasArguments(lllllllllllllllIIllIIIIIllIlIllI) ? EntitySelector.matchEntities(lllllllllllllllIIllIIIIIllIllIlI, lllllllllllllllIIllIIIIIllIlIllI, (Class<? extends Entity>)Entity.class) : Lists.newArrayList((Object[])new Entity[] { getEntity(lllllllllllllllIIllIIIIIllIllIll, lllllllllllllllIIllIIIIIllIllIlI, lllllllllllllllIIllIIIIIllIlIllI) });
    }
    
    public static List<EntityPlayerMP> func_193513_a(final MinecraftServer lllllllllllllllIIllIIIIlIIIlIIlI, final ICommandSender lllllllllllllllIIllIIIIlIIIlIlIl, final String lllllllllllllllIIllIIIIlIIIlIlII) throws CommandException {
        final List<EntityPlayerMP> lllllllllllllllIIllIIIIlIIIlIIll = EntitySelector.func_193531_b(lllllllllllllllIIllIIIIlIIIlIlIl, lllllllllllllllIIllIIIIlIIIlIlII);
        return lllllllllllllllIIllIIIIlIIIlIIll.isEmpty() ? Lists.newArrayList((Object[])new EntityPlayerMP[] { func_193512_a(lllllllllllllllIIllIIIIlIIIlIIlI, null, lllllllllllllllIIllIIIIlIIIlIlII) }) : lllllllllllllllIIllIIIIlIIIlIIll;
    }
    
    public static class CoordinateArg
    {
        private final /* synthetic */ double amount;
        private final /* synthetic */ boolean isRelative;
        private final /* synthetic */ double result;
        
        public double getAmount() {
            return this.amount;
        }
        
        public double getResult() {
            return this.result;
        }
        
        protected CoordinateArg(final double lIllIlIllllIIIl, final double lIllIlIllllIIII, final boolean lIllIlIllllIIll) {
            this.result = lIllIlIllllIIIl;
            this.amount = lIllIlIllllIIII;
            this.isRelative = lIllIlIllllIIll;
        }
        
        public boolean isRelative() {
            return this.isRelative;
        }
    }
}
