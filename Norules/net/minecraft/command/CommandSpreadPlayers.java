package net.minecraft.command;

import net.minecraft.server.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.material.*;

public class CommandSpreadPlayers extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIllIIIlllIIlIIII) {
        return "commands.spreadplayers.usage";
    }
    
    @Override
    public String getCommandName() {
        return "spreadplayers";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllllIllIIIlIIIllllIl, final ICommandSender llllllllllllllllIllIIIlIIIllllII, final String[] llllllllllllllllIllIIIlIIIlllIIl, @Nullable final BlockPos llllllllllllllllIllIIIlIIIlllIII) {
        return (llllllllllllllllIllIIIlIIIlllIIl.length >= 1 && llllllllllllllllIllIIIlIIIlllIIl.length <= 2) ? CommandBase.getTabCompletionCoordinateXZ(llllllllllllllllIllIIIlIIIlllIIl, 0, llllllllllllllllIllIIIlIIIlllIII) : Collections.emptyList();
    }
    
    private void spread(final ICommandSender llllllllllllllllIllIIIllIIlIIllI, final List<Entity> llllllllllllllllIllIIIllIIIIlIIl, final Position llllllllllllllllIllIIIllIIIIIlll, final double llllllllllllllllIllIIIllIIIIIlIl, final double llllllllllllllllIllIIIllIIlIIIIl, final World llllllllllllllllIllIIIllIIIIIIll, final boolean llllllllllllllllIllIIIllIIIIIIlI) throws CommandException {
        final Random llllllllllllllllIllIIIllIIIlllII = new Random();
        final double llllllllllllllllIllIIIllIIIllIlI = llllllllllllllllIllIIIllIIIIIlll.x - llllllllllllllllIllIIIllIIlIIIIl;
        final double llllllllllllllllIllIIIllIIIllIII = llllllllllllllllIllIIIllIIIIIlll.z - llllllllllllllllIllIIIllIIlIIIIl;
        final double llllllllllllllllIllIIIllIIIlIllI = llllllllllllllllIllIIIllIIIIIlll.x + llllllllllllllllIllIIIllIIlIIIIl;
        final double llllllllllllllllIllIIIllIIIlIlII = llllllllllllllllIllIIIllIIIIIlll.z + llllllllllllllllIllIIIllIIlIIIIl;
        final Position[] llllllllllllllllIllIIIllIIIlIIlI = this.createInitialPositions(llllllllllllllllIllIIIllIIIlllII, llllllllllllllllIllIIIllIIIIIIlI ? this.getNumberOfTeams(llllllllllllllllIllIIIllIIIIlIIl) : llllllllllllllllIllIIIllIIIIlIIl.size(), llllllllllllllllIllIIIllIIIllIlI, llllllllllllllllIllIIIllIIIllIII, llllllllllllllllIllIIIllIIIlIllI, llllllllllllllllIllIIIllIIIlIlII);
        final int llllllllllllllllIllIIIllIIIlIIII = this.spreadPositions(llllllllllllllllIllIIIllIIIIIlll, llllllllllllllllIllIIIllIIIIIlIl, llllllllllllllllIllIIIllIIIIIIll, llllllllllllllllIllIIIllIIIlllII, llllllllllllllllIllIIIllIIIllIlI, llllllllllllllllIllIIIllIIIllIII, llllllllllllllllIllIIIllIIIlIllI, llllllllllllllllIllIIIllIIIlIlII, llllllllllllllllIllIIIllIIIlIIlI, llllllllllllllllIllIIIllIIIIIIlI);
        final double llllllllllllllllIllIIIllIIIIllll = this.setPlayerPositions(llllllllllllllllIllIIIllIIIIlIIl, llllllllllllllllIllIIIllIIIIIIll, llllllllllllllllIllIIIllIIIlIIlI, llllllllllllllllIllIIIllIIIIIIlI);
        CommandBase.notifyCommandListener(llllllllllllllllIllIIIllIIlIIllI, this, String.valueOf(new StringBuilder("commands.spreadplayers.success.").append(llllllllllllllllIllIIIllIIIIIIlI ? "teams" : "players")), llllllllllllllllIllIIIllIIIlIIlI.length, llllllllllllllllIllIIIllIIIIIlll.x, llllllllllllllllIllIIIllIIIIIlll.z);
        if (llllllllllllllllIllIIIllIIIlIIlI.length > 1) {
            llllllllllllllllIllIIIllIIlIIllI.addChatMessage(new TextComponentTranslation(String.valueOf(new StringBuilder("commands.spreadplayers.info.").append(llllllllllllllllIllIIIllIIIIIIlI ? "teams" : "players")), new Object[] { String.format("%.2f", llllllllllllllllIllIIIllIIIIllll), llllllllllllllllIllIIIllIIIlIIII }));
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllllIllIIIllIlllllII, final ICommandSender llllllllllllllllIllIIIllIllllIll, final String[] llllllllllllllllIllIIIllIllIIIII) throws CommandException {
        if (llllllllllllllllIllIIIllIllIIIII.length < 6) {
            throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
        }
        int llllllllllllllllIllIIIllIllllIII = 0;
        final BlockPos llllllllllllllllIllIIIllIlllIlll = llllllllllllllllIllIIIllIllllIll.getPosition();
        final double llllllllllllllllIllIIIllIlllIllI = CommandBase.parseDouble(llllllllllllllllIllIIIllIlllIlll.getX(), llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++], true);
        final double llllllllllllllllIllIIIllIlllIlII = CommandBase.parseDouble(llllllllllllllllIllIIIllIlllIlll.getZ(), llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++], true);
        final double llllllllllllllllIllIIIllIlllIIlI = CommandBase.parseDouble(llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++], 0.0);
        final double llllllllllllllllIllIIIllIlllIIII = CommandBase.parseDouble(llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++], llllllllllllllllIllIIIllIlllIIlI + 1.0);
        final boolean llllllllllllllllIllIIIllIllIlllI = CommandBase.parseBoolean(llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++]);
        final List<Entity> llllllllllllllllIllIIIllIllIllII = (List<Entity>)Lists.newArrayList();
        while (llllllllllllllllIllIIIllIllllIII < llllllllllllllllIllIIIllIllIIIII.length) {
            final String llllllllllllllllIllIIIllIllIlIlI = llllllllllllllllIllIIIllIllIIIII[llllllllllllllllIllIIIllIllllIII++];
            if (EntitySelector.hasArguments(llllllllllllllllIllIIIllIllIlIlI)) {
                final List<Entity> llllllllllllllllIllIIIllIllIlIIl = EntitySelector.matchEntities(llllllllllllllllIllIIIllIllllIll, llllllllllllllllIllIIIllIllIlIlI, (Class<? extends Entity>)Entity.class);
                if (llllllllllllllllIllIIIllIllIlIIl.isEmpty()) {
                    throw new EntityNotFoundException("commands.generic.selector.notFound", new Object[] { llllllllllllllllIllIIIllIllIlIlI });
                }
                llllllllllllllllIllIIIllIllIllII.addAll(llllllllllllllllIllIIIllIllIlIIl);
            }
            else {
                final EntityPlayer llllllllllllllllIllIIIllIllIlIII = llllllllllllllllIllIIIllIlllllII.getPlayerList().getPlayerByUsername(llllllllllllllllIllIIIllIllIlIlI);
                if (llllllllllllllllIllIIIllIllIlIII == null) {
                    throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { llllllllllllllllIllIIIllIllIlIlI });
                }
                llllllllllllllllIllIIIllIllIllII.add(llllllllllllllllIllIIIllIllIlIII);
            }
        }
        llllllllllllllllIllIIIllIllllIll.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllllllIllIIIllIllIllII.size());
        if (llllllllllllllllIllIIIllIllIllII.isEmpty()) {
            throw new EntityNotFoundException("commands.spreadplayers.noop");
        }
        llllllllllllllllIllIIIllIllllIll.addChatMessage(new TextComponentTranslation(String.valueOf(new StringBuilder("commands.spreadplayers.spreading.").append(llllllllllllllllIllIIIllIllIlllI ? "teams" : "players")), new Object[] { llllllllllllllllIllIIIllIllIllII.size(), llllllllllllllllIllIIIllIlllIIII, llllllllllllllllIllIIIllIlllIllI, llllllllllllllllIllIIIllIlllIlII, llllllllllllllllIllIIIllIlllIIlI }));
        this.spread(llllllllllllllllIllIIIllIllllIll, llllllllllllllllIllIIIllIllIllII, new Position(llllllllllllllllIllIIIllIlllIllI, llllllllllllllllIllIIIllIlllIlII), llllllllllllllllIllIIIllIlllIIlI, llllllllllllllllIllIIIllIlllIIII, llllllllllllllllIllIIIllIllIllII.get(0).world, llllllllllllllllIllIIIllIllIlllI);
    }
    
    private int spreadPositions(final Position llllllllllllllllIllIIIlIlIllIllI, final double llllllllllllllllIllIIIlIlIIlllll, final World llllllllllllllllIllIIIlIlIIllllI, final Random llllllllllllllllIllIIIlIlIIlllIl, final double llllllllllllllllIllIIIlIlIllIIlI, final double llllllllllllllllIllIIIlIlIllIIIl, final double llllllllllllllllIllIIIlIlIllIIII, final double llllllllllllllllIllIIIlIlIlIllll, final Position[] llllllllllllllllIllIIIlIlIlIlllI, final boolean llllllllllllllllIllIIIlIlIIlIlll) throws CommandException {
        boolean llllllllllllllllIllIIIlIlIlIllII = true;
        double llllllllllllllllIllIIIlIlIlIlIll = 3.4028234663852886E38;
        int llllllllllllllllIllIIIlIlIlIlIlI;
        for (llllllllllllllllIllIIIlIlIlIlIlI = 0; llllllllllllllllIllIIIlIlIlIlIlI < 10000 && llllllllllllllllIllIIIlIlIlIllII; ++llllllllllllllllIllIIIlIlIlIlIlI) {
            llllllllllllllllIllIIIlIlIlIllII = false;
            llllllllllllllllIllIIIlIlIlIlIll = 3.4028234663852886E38;
            for (int llllllllllllllllIllIIIlIlIlIlIIl = 0; llllllllllllllllIllIIIlIlIlIlIIl < llllllllllllllllIllIIIlIlIlIlllI.length; ++llllllllllllllllIllIIIlIlIlIlIIl) {
                final Position llllllllllllllllIllIIIlIlIlIlIII = llllllllllllllllIllIIIlIlIlIlllI[llllllllllllllllIllIIIlIlIlIlIIl];
                int llllllllllllllllIllIIIlIlIlIIlll = 0;
                final Position llllllllllllllllIllIIIlIlIlIIllI = new Position();
                for (int llllllllllllllllIllIIIlIlIlIIlIl = 0; llllllllllllllllIllIIIlIlIlIIlIl < llllllllllllllllIllIIIlIlIlIlllI.length; ++llllllllllllllllIllIIIlIlIlIIlIl) {
                    if (llllllllllllllllIllIIIlIlIlIlIIl != llllllllllllllllIllIIIlIlIlIIlIl) {
                        final Position llllllllllllllllIllIIIlIlIlIIlII = llllllllllllllllIllIIIlIlIlIlllI[llllllllllllllllIllIIIlIlIlIIlIl];
                        final double llllllllllllllllIllIIIlIlIlIIIll = llllllllllllllllIllIIIlIlIlIlIII.dist(llllllllllllllllIllIIIlIlIlIIlII);
                        llllllllllllllllIllIIIlIlIlIlIll = Math.min(llllllllllllllllIllIIIlIlIlIIIll, llllllllllllllllIllIIIlIlIlIlIll);
                        if (llllllllllllllllIllIIIlIlIlIIIll < llllllllllllllllIllIIIlIlIIlllll) {
                            ++llllllllllllllllIllIIIlIlIlIIlll;
                            final Position position = llllllllllllllllIllIIIlIlIlIIllI;
                            position.x += llllllllllllllllIllIIIlIlIlIIlII.x - llllllllllllllllIllIIIlIlIlIlIII.x;
                            final Position position2 = llllllllllllllllIllIIIlIlIlIIllI;
                            position2.z += llllllllllllllllIllIIIlIlIlIIlII.z - llllllllllllllllIllIIIlIlIlIlIII.z;
                        }
                    }
                }
                if (llllllllllllllllIllIIIlIlIlIIlll > 0) {
                    final Position position3 = llllllllllllllllIllIIIlIlIlIIllI;
                    position3.x /= llllllllllllllllIllIIIlIlIlIIlll;
                    final Position position4 = llllllllllllllllIllIIIlIlIlIIllI;
                    position4.z /= llllllllllllllllIllIIIlIlIlIIlll;
                    final double llllllllllllllllIllIIIlIlIlIIIlI = llllllllllllllllIllIIIlIlIlIIllI.getLength();
                    if (llllllllllllllllIllIIIlIlIlIIIlI > 0.0) {
                        llllllllllllllllIllIIIlIlIlIIllI.normalize();
                        llllllllllllllllIllIIIlIlIlIlIII.moveAway(llllllllllllllllIllIIIlIlIlIIllI);
                    }
                    else {
                        llllllllllllllllIllIIIlIlIlIlIII.randomize(llllllllllllllllIllIIIlIlIIlllIl, llllllllllllllllIllIIIlIlIllIIlI, llllllllllllllllIllIIIlIlIllIIIl, llllllllllllllllIllIIIlIlIllIIII, llllllllllllllllIllIIIlIlIlIllll);
                    }
                    llllllllllllllllIllIIIlIlIlIllII = true;
                }
                if (llllllllllllllllIllIIIlIlIlIlIII.clamp(llllllllllllllllIllIIIlIlIllIIlI, llllllllllllllllIllIIIlIlIllIIIl, llllllllllllllllIllIIIlIlIllIIII, llllllllllllllllIllIIIlIlIlIllll)) {
                    llllllllllllllllIllIIIlIlIlIllII = true;
                }
            }
            if (!llllllllllllllllIllIIIlIlIlIllII) {
                final int llllllllllllllllIllIIIlIlIIlIIII = (Object)llllllllllllllllIllIIIlIlIlIlllI;
                final int length = llllllllllllllllIllIIIlIlIlIlllI.length;
                for (char llllllllllllllllIllIIIlIlIIlIIlI = '\0'; llllllllllllllllIllIIIlIlIIlIIlI < length; ++llllllllllllllllIllIIIlIlIIlIIlI) {
                    final Position llllllllllllllllIllIIIlIlIlIIIIl = llllllllllllllllIllIIIlIlIIlIIII[llllllllllllllllIllIIIlIlIIlIIlI];
                    if (!llllllllllllllllIllIIIlIlIlIIIIl.isSafe(llllllllllllllllIllIIIlIlIIllllI)) {
                        llllllllllllllllIllIIIlIlIlIIIIl.randomize(llllllllllllllllIllIIIlIlIIlllIl, llllllllllllllllIllIIIlIlIllIIlI, llllllllllllllllIllIIIlIlIllIIIl, llllllllllllllllIllIIIlIlIllIIII, llllllllllllllllIllIIIlIlIlIllll);
                        llllllllllllllllIllIIIlIlIlIllII = true;
                    }
                }
            }
        }
        if (llllllllllllllllIllIIIlIlIlIlIlI >= 10000) {
            throw new CommandException(String.valueOf(new StringBuilder("commands.spreadplayers.failure.").append(llllllllllllllllIllIIIlIlIIlIlll ? "teams" : "players")), new Object[] { llllllllllllllllIllIIIlIlIlIlllI.length, llllllllllllllllIllIIIlIlIllIllI.x, llllllllllllllllIllIIIlIlIllIllI.z, String.format("%.2f", llllllllllllllllIllIIIlIlIlIlIll) });
        }
        return llllllllllllllllIllIIIlIlIlIlIlI;
    }
    
    private int getNumberOfTeams(final List<Entity> llllllllllllllllIllIIIlIllIllIll) {
        final Set<Team> llllllllllllllllIllIIIlIllIlllll = (Set<Team>)Sets.newHashSet();
        for (final Entity llllllllllllllllIllIIIlIllIlllIl : llllllllllllllllIllIIIlIllIllIll) {
            if (llllllllllllllllIllIIIlIllIlllIl instanceof EntityPlayer) {
                llllllllllllllllIllIIIlIllIlllll.add(llllllllllllllllIllIIIlIllIlllIl.getTeam());
            }
            else {
                llllllllllllllllIllIIIlIllIlllll.add(null);
            }
        }
        return llllllllllllllllIllIIIlIllIlllll.size();
    }
    
    private double setPlayerPositions(final List<Entity> llllllllllllllllIllIIIlIIllllIll, final World llllllllllllllllIllIIIlIIllllIlI, final Position[] llllllllllllllllIllIIIlIIllIlIlI, final boolean llllllllllllllllIllIIIlIIllIlIIl) {
        double llllllllllllllllIllIIIlIIlllIlll = 0.0;
        int llllllllllllllllIllIIIlIIlllIllI = 0;
        final Map<Team, Position> llllllllllllllllIllIIIlIIlllIlIl = (Map<Team, Position>)Maps.newHashMap();
        for (int llllllllllllllllIllIIIlIIlllIlII = 0; llllllllllllllllIllIIIlIIlllIlII < llllllllllllllllIllIIIlIIllllIll.size(); ++llllllllllllllllIllIIIlIIlllIlII) {
            final Entity llllllllllllllllIllIIIlIIlllIIll = llllllllllllllllIllIIIlIIllllIll.get(llllllllllllllllIllIIIlIIlllIlII);
            Position llllllllllllllllIllIIIlIIlllIIIl = null;
            if (llllllllllllllllIllIIIlIIllIlIIl) {
                final Team llllllllllllllllIllIIIlIIlllIIII = (llllllllllllllllIllIIIlIIlllIIll instanceof EntityPlayer) ? llllllllllllllllIllIIIlIIlllIIll.getTeam() : null;
                if (!llllllllllllllllIllIIIlIIlllIlIl.containsKey(llllllllllllllllIllIIIlIIlllIIII)) {
                    llllllllllllllllIllIIIlIIlllIlIl.put(llllllllllllllllIllIIIlIIlllIIII, llllllllllllllllIllIIIlIIllIlIlI[llllllllllllllllIllIIIlIIlllIllI++]);
                }
                final Position llllllllllllllllIllIIIlIIlllIIlI = llllllllllllllllIllIIIlIIlllIlIl.get(llllllllllllllllIllIIIlIIlllIIII);
            }
            else {
                llllllllllllllllIllIIIlIIlllIIIl = llllllllllllllllIllIIIlIIllIlIlI[llllllllllllllllIllIIIlIIlllIllI++];
            }
            llllllllllllllllIllIIIlIIlllIIll.setPositionAndUpdate(MathHelper.floor(llllllllllllllllIllIIIlIIlllIIIl.x) + 0.5f, llllllllllllllllIllIIIlIIlllIIIl.getSpawnY(llllllllllllllllIllIIIlIIllllIlI), MathHelper.floor(llllllllllllllllIllIIIlIIlllIIIl.z) + 0.5);
            double llllllllllllllllIllIIIlIIllIllll = Double.MAX_VALUE;
            final float llllllllllllllllIllIIIlIIlIllllI = (Object)llllllllllllllllIllIIIlIIllIlIlI;
            for (boolean llllllllllllllllIllIIIlIIlIlllll = llllllllllllllllIllIIIlIIllIlIlI.length != 0, llllllllllllllllIllIIIlIIllIIIII = false; llllllllllllllllIllIIIlIIllIIIII < llllllllllllllllIllIIIlIIlIlllll; ++llllllllllllllllIllIIIlIIllIIIII) {
                final Position llllllllllllllllIllIIIlIIllIlllI = llllllllllllllllIllIIIlIIlIllllI[llllllllllllllllIllIIIlIIllIIIII];
                if (llllllllllllllllIllIIIlIIlllIIIl != llllllllllllllllIllIIIlIIllIlllI) {
                    final double llllllllllllllllIllIIIlIIllIllIl = llllllllllllllllIllIIIlIIlllIIIl.dist(llllllllllllllllIllIIIlIIllIlllI);
                    llllllllllllllllIllIIIlIIllIllll = Math.min(llllllllllllllllIllIIIlIIllIllIl, llllllllllllllllIllIIIlIIllIllll);
                }
            }
            llllllllllllllllIllIIIlIIlllIlll += llllllllllllllllIllIIIlIIllIllll;
        }
        llllllllllllllllIllIIIlIIlllIlll /= llllllllllllllllIllIIIlIIllllIll.size();
        return llllllllllllllllIllIIIlIIlllIlll;
    }
    
    private Position[] createInitialPositions(final Random llllllllllllllllIllIIIlIIlIlIIlI, final int llllllllllllllllIllIIIlIIlIlIIIl, final double llllllllllllllllIllIIIlIIlIlIIII, final double llllllllllllllllIllIIIlIIlIIIllI, final double llllllllllllllllIllIIIlIIlIIlllI, final double llllllllllllllllIllIIIlIIlIIllIl) {
        final Position[] llllllllllllllllIllIIIlIIlIIllII = new Position[llllllllllllllllIllIIIlIIlIlIIIl];
        for (int llllllllllllllllIllIIIlIIlIIlIll = 0; llllllllllllllllIllIIIlIIlIIlIll < llllllllllllllllIllIIIlIIlIIllII.length; ++llllllllllllllllIllIIIlIIlIIlIll) {
            final Position llllllllllllllllIllIIIlIIlIIlIlI = new Position();
            llllllllllllllllIllIIIlIIlIIlIlI.randomize(llllllllllllllllIllIIIlIIlIlIIlI, llllllllllllllllIllIIIlIIlIlIIII, llllllllllllllllIllIIIlIIlIIIllI, llllllllllllllllIllIIIlIIlIIlllI, llllllllllllllllIllIIIlIIlIIllIl);
            llllllllllllllllIllIIIlIIlIIllII[llllllllllllllllIllIIIlIIlIIlIll] = llllllllllllllllIllIIIlIIlIIlIlI;
        }
        return llllllllllllllllIllIIIlIIlIIllII;
    }
    
    static class Position
    {
        /* synthetic */ double x;
        /* synthetic */ double z;
        
        Position() {
        }
        
        void normalize() {
            final double lllllllllllllIIIIIlIIIIlIIlllIll = this.getLength();
            this.x /= lllllllllllllIIIIIlIIIIlIIlllIll;
            this.z /= lllllllllllllIIIIIlIIIIlIIlllIll;
        }
        
        Position(final double lllllllllllllIIIIIlIIIIlIlIIllll, final double lllllllllllllIIIIIlIIIIlIlIIlIll) {
            this.x = lllllllllllllIIIIIlIIIIlIlIIllll;
            this.z = lllllllllllllIIIIIlIIIIlIlIIlIll;
        }
        
        public void moveAway(final Position lllllllllllllIIIIIlIIIIlIIllIIII) {
            this.x -= lllllllllllllIIIIIlIIIIlIIllIIII.x;
            this.z -= lllllllllllllIIIIIlIIIIlIIllIIII.z;
        }
        
        public void randomize(final Random lllllllllllllIIIIIlIIIIIlllllIll, final double lllllllllllllIIIIIlIIIIIlllllIlI, final double lllllllllllllIIIIIlIIIIIllllllll, final double lllllllllllllIIIIIlIIIIIlllllIII, final double lllllllllllllIIIIIlIIIIIllllllIl) {
            this.x = MathHelper.nextDouble(lllllllllllllIIIIIlIIIIIlllllIll, lllllllllllllIIIIIlIIIIIlllllIlI, lllllllllllllIIIIIlIIIIIlllllIII);
            this.z = MathHelper.nextDouble(lllllllllllllIIIIIlIIIIIlllllIll, lllllllllllllIIIIIlIIIIIllllllll, lllllllllllllIIIIIlIIIIIllllllIl);
        }
        
        public int getSpawnY(final World lllllllllllllIIIIIlIIIIlIIIlIllI) {
            BlockPos lllllllllllllIIIIIlIIIIlIIIllIII = new BlockPos(this.x, 256.0, this.z);
            while (lllllllllllllIIIIIlIIIIlIIIllIII.getY() > 0) {
                lllllllllllllIIIIIlIIIIlIIIllIII = lllllllllllllIIIIIlIIIIlIIIllIII.down();
                if (lllllllllllllIIIIIlIIIIlIIIlIllI.getBlockState(lllllllllllllIIIIIlIIIIlIIIllIII).getMaterial() != Material.AIR) {
                    return lllllllllllllIIIIIlIIIIlIIIllIII.getY() + 1;
                }
            }
            return 257;
        }
        
        public boolean isSafe(final World lllllllllllllIIIIIlIIIIlIIIIlIll) {
            BlockPos lllllllllllllIIIIIlIIIIlIIIIlllI = new BlockPos(this.x, 256.0, this.z);
            while (lllllllllllllIIIIIlIIIIlIIIIlllI.getY() > 0) {
                lllllllllllllIIIIIlIIIIlIIIIlllI = lllllllllllllIIIIIlIIIIlIIIIlllI.down();
                final Material lllllllllllllIIIIIlIIIIlIIIIllIl = lllllllllllllIIIIIlIIIIlIIIIlIll.getBlockState(lllllllllllllIIIIIlIIIIlIIIIlllI).getMaterial();
                if (lllllllllllllIIIIIlIIIIlIIIIllIl != Material.AIR) {
                    return !lllllllllllllIIIIIlIIIIlIIIIllIl.isLiquid() && lllllllllllllIIIIIlIIIIlIIIIllIl != Material.FIRE;
                }
            }
            return false;
        }
        
        public boolean clamp(final double lllllllllllllIIIIIlIIIIlIIlIIIlI, final double lllllllllllllIIIIIlIIIIlIIlIIlll, final double lllllllllllllIIIIIlIIIIlIIlIIllI, final double lllllllllllllIIIIIlIIIIlIIlIIlIl) {
            boolean lllllllllllllIIIIIlIIIIlIIlIIlII = false;
            if (this.x < lllllllllllllIIIIIlIIIIlIIlIIIlI) {
                this.x = lllllllllllllIIIIIlIIIIlIIlIIIlI;
                lllllllllllllIIIIIlIIIIlIIlIIlII = true;
            }
            else if (this.x > lllllllllllllIIIIIlIIIIlIIlIIllI) {
                this.x = lllllllllllllIIIIIlIIIIlIIlIIllI;
                lllllllllllllIIIIIlIIIIlIIlIIlII = true;
            }
            if (this.z < lllllllllllllIIIIIlIIIIlIIlIIlll) {
                this.z = lllllllllllllIIIIIlIIIIlIIlIIlll;
                lllllllllllllIIIIIlIIIIlIIlIIlII = true;
            }
            else if (this.z > lllllllllllllIIIIIlIIIIlIIlIIlIl) {
                this.z = lllllllllllllIIIIIlIIIIlIIlIIlIl;
                lllllllllllllIIIIIlIIIIlIIlIIlII = true;
            }
            return lllllllllllllIIIIIlIIIIlIIlIIlII;
        }
        
        double dist(final Position lllllllllllllIIIIIlIIIIlIlIIIIIl) {
            final double lllllllllllllIIIIIlIIIIlIlIIIlII = this.x - lllllllllllllIIIIIlIIIIlIlIIIIIl.x;
            final double lllllllllllllIIIIIlIIIIlIlIIIIll = this.z - lllllllllllllIIIIIlIIIIlIlIIIIIl.z;
            return Math.sqrt(lllllllllllllIIIIIlIIIIlIlIIIlII * lllllllllllllIIIIIlIIIIlIlIIIlII + lllllllllllllIIIIIlIIIIlIlIIIIll * lllllllllllllIIIIIlIIIIlIlIIIIll);
        }
        
        float getLength() {
            return MathHelper.sqrt(this.x * this.x + this.z * this.z);
        }
    }
}
