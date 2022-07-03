package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.command.*;
import net.minecraft.nbt.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;

public class CommandSummon extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIIIIIlIIIIIIIIIlI, final ICommandSender llllllllllllllIIIIIIIlllllllIIIl, final String[] llllllllllllllIIIIIIIlllllllIIII) throws CommandException {
        if (llllllllllllllIIIIIIIlllllllIIII.length < 1) {
            throw new WrongUsageException("commands.summon.usage", new Object[0]);
        }
        final String llllllllllllllIIIIIIIlllllllllll = llllllllllllllIIIIIIIlllllllIIII[0];
        BlockPos llllllllllllllIIIIIIIllllllllllI = llllllllllllllIIIIIIIlllllllIIIl.getPosition();
        final Vec3d llllllllllllllIIIIIIIlllllllllIl = llllllllllllllIIIIIIIlllllllIIIl.getPositionVector();
        double llllllllllllllIIIIIIIlllllllllII = llllllllllllllIIIIIIIlllllllllIl.xCoord;
        double llllllllllllllIIIIIIIllllllllIll = llllllllllllllIIIIIIIlllllllllIl.yCoord;
        double llllllllllllllIIIIIIIllllllllIlI = llllllllllllllIIIIIIIlllllllllIl.zCoord;
        if (llllllllllllllIIIIIIIlllllllIIII.length >= 4) {
            llllllllllllllIIIIIIIlllllllllII = CommandBase.parseDouble(llllllllllllllIIIIIIIlllllllllII, llllllllllllllIIIIIIIlllllllIIII[1], true);
            llllllllllllllIIIIIIIllllllllIll = CommandBase.parseDouble(llllllllllllllIIIIIIIllllllllIll, llllllllllllllIIIIIIIlllllllIIII[2], false);
            llllllllllllllIIIIIIIllllllllIlI = CommandBase.parseDouble(llllllllllllllIIIIIIIllllllllIlI, llllllllllllllIIIIIIIlllllllIIII[3], true);
            llllllllllllllIIIIIIIllllllllllI = new BlockPos(llllllllllllllIIIIIIIlllllllllII, llllllllllllllIIIIIIIllllllllIll, llllllllllllllIIIIIIIllllllllIlI);
        }
        final World llllllllllllllIIIIIIIllllllllIIl = llllllllllllllIIIIIIIlllllllIIIl.getEntityWorld();
        if (!llllllllllllllIIIIIIIllllllllIIl.isBlockLoaded(llllllllllllllIIIIIIIllllllllllI)) {
            throw new CommandException("commands.summon.outOfWorld", new Object[0]);
        }
        if (EntityList.field_191307_a.equals(new ResourceLocation(llllllllllllllIIIIIIIlllllllllll))) {
            llllllllllllllIIIIIIIllllllllIIl.addWeatherEffect(new EntityLightningBolt(llllllllllllllIIIIIIIllllllllIIl, llllllllllllllIIIIIIIlllllllllII, llllllllllllllIIIIIIIllllllllIll, llllllllllllllIIIIIIIllllllllIlI, false));
            CommandBase.notifyCommandListener(llllllllllllllIIIIIIIlllllllIIIl, this, "commands.summon.success", new Object[0]);
        }
        else {
            NBTTagCompound llllllllllllllIIIIIIIllllllllIII = new NBTTagCompound();
            boolean llllllllllllllIIIIIIIlllllllIlll = false;
            if (llllllllllllllIIIIIIIlllllllIIII.length >= 5) {
                final String llllllllllllllIIIIIIIlllllllIllI = CommandBase.buildString(llllllllllllllIIIIIIIlllllllIIII, 4);
                try {
                    llllllllllllllIIIIIIIllllllllIII = JsonToNBT.getTagFromJson(llllllllllllllIIIIIIIlllllllIllI);
                    llllllllllllllIIIIIIIlllllllIlll = true;
                }
                catch (NBTException llllllllllllllIIIIIIIlllllllIlIl) {
                    throw new CommandException("commands.summon.tagError", new Object[] { llllllllllllllIIIIIIIlllllllIlIl.getMessage() });
                }
            }
            llllllllllllllIIIIIIIllllllllIII.setString("id", llllllllllllllIIIIIIIlllllllllll);
            final Entity llllllllllllllIIIIIIIlllllllIlII = AnvilChunkLoader.readWorldEntityPos(llllllllllllllIIIIIIIllllllllIII, llllllllllllllIIIIIIIllllllllIIl, llllllllllllllIIIIIIIlllllllllII, llllllllllllllIIIIIIIllllllllIll, llllllllllllllIIIIIIIllllllllIlI, true);
            if (llllllllllllllIIIIIIIlllllllIlII == null) {
                throw new CommandException("commands.summon.failed", new Object[0]);
            }
            llllllllllllllIIIIIIIlllllllIlII.setLocationAndAngles(llllllllllllllIIIIIIIlllllllllII, llllllllllllllIIIIIIIllllllllIll, llllllllllllllIIIIIIIllllllllIlI, llllllllllllllIIIIIIIlllllllIlII.rotationYaw, llllllllllllllIIIIIIIlllllllIlII.rotationPitch);
            if (!llllllllllllllIIIIIIIlllllllIlll && llllllllllllllIIIIIIIlllllllIlII instanceof EntityLiving) {
                ((EntityLiving)llllllllllllllIIIIIIIlllllllIlII).onInitialSpawn(llllllllllllllIIIIIIIllllllllIIl.getDifficultyForLocation(new BlockPos(llllllllllllllIIIIIIIlllllllIlII)), null);
            }
            CommandBase.notifyCommandListener(llllllllllllllIIIIIIIlllllllIIIl, this, "commands.summon.success", new Object[0]);
        }
    }
    
    @Override
    public String getCommandName() {
        return "summon";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIIIIIlIIIIIIlIIlI) {
        return "commands.summon.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIIIIIIlllllIlIlll, final ICommandSender llllllllllllllIIIIIIIlllllIlIllI, final String[] llllllllllllllIIIIIIIlllllIlIlIl, @Nullable final BlockPos llllllllllllllIIIIIIIlllllIlIIlI) {
        if (llllllllllllllIIIIIIIlllllIlIlIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIIIIIIlllllIlIlIl, EntityList.getEntityNameList());
        }
        return (llllllllllllllIIIIIIIlllllIlIlIl.length > 1 && llllllllllllllIIIIIIIlllllIlIlIl.length <= 4) ? CommandBase.getTabCompletionCoordinate(llllllllllllllIIIIIIIlllllIlIlIl, 1, llllllllllllllIIIIIIIlllllIlIIlI) : Collections.emptyList();
    }
}
