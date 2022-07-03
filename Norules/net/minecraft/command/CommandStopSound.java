package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;
import io.netty.buffer.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;

public class CommandStopSound extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIllllIIIIIIlllIlII, final int llllllllllllllIllllIIIIIIlllIIll) {
        return llllllllllllllIllllIIIIIIlllIIll == 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIllllIIIIIIllllIII, final ICommandSender llllllllllllllIllllIIIIIIllllIll, final String[] llllllllllllllIllllIIIIIIlllIlll, @Nullable final BlockPos llllllllllllllIllllIIIIIIllllIIl) {
        if (llllllllllllllIllllIIIIIIlllIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIIIIIlllIlll, llllllllllllllIllllIIIIIIllllIII.getAllUsernames());
        }
        if (llllllllllllllIllllIIIIIIlllIlll.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIIIIIlllIlll, SoundCategory.getSoundCategoryNames());
        }
        return (llllllllllllllIllllIIIIIIlllIlll.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIIIIIlllIlll, SoundEvent.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIllllIIIIIlIIIlIII, final ICommandSender llllllllllllllIllllIIIIIlIIIIlll, final String[] llllllllllllllIllllIIIIIlIIIIllI) throws CommandException {
        if (llllllllllllllIllllIIIIIlIIIIllI.length >= 1 && llllllllllllllIllllIIIIIlIIIIllI.length <= 3) {
            int llllllllllllllIllllIIIIIlIIlIIII = 0;
            final EntityPlayerMP llllllllllllllIllllIIIIIlIIIllll = CommandBase.getPlayer(llllllllllllllIllllIIIIIlIIIlIII, llllllllllllllIllllIIIIIlIIIIlll, llllllllllllllIllllIIIIIlIIIIllI[llllllllllllllIllllIIIIIlIIlIIII++]);
            String llllllllllllllIllllIIIIIlIIIlllI = "";
            String llllllllllllllIllllIIIIIlIIIllIl = "";
            if (llllllllllllllIllllIIIIIlIIIIllI.length >= 2) {
                final String llllllllllllllIllllIIIIIlIIIllII = llllllllllllllIllllIIIIIlIIIIllI[llllllllllllllIllllIIIIIlIIlIIII++];
                final SoundCategory llllllllllllllIllllIIIIIlIIIlIll = SoundCategory.getByName(llllllllllllllIllllIIIIIlIIIllII);
                if (llllllllllllllIllllIIIIIlIIIlIll == null) {
                    throw new CommandException("commands.stopsound.unknownSoundSource", new Object[] { llllllllllllllIllllIIIIIlIIIllII });
                }
                llllllllllllllIllllIIIIIlIIIlllI = llllllllllllllIllllIIIIIlIIIlIll.getName();
            }
            if (llllllllllllllIllllIIIIIlIIIIllI.length == 3) {
                llllllllllllllIllllIIIIIlIIIllIl = llllllllllllllIllllIIIIIlIIIIllI[llllllllllllllIllllIIIIIlIIlIIII++];
            }
            final PacketBuffer llllllllllllllIllllIIIIIlIIIlIlI = new PacketBuffer(Unpooled.buffer());
            llllllllllllllIllllIIIIIlIIIlIlI.writeString(llllllllllllllIllllIIIIIlIIIlllI);
            llllllllllllllIllllIIIIIlIIIlIlI.writeString(llllllllllllllIllllIIIIIlIIIllIl);
            llllllllllllllIllllIIIIIlIIIllll.connection.sendPacket(new SPacketCustomPayload("MC|StopSound", llllllllllllllIllllIIIIIlIIIlIlI));
            if (llllllllllllllIllllIIIIIlIIIlllI.isEmpty() && llllllllllllllIllllIIIIIlIIIllIl.isEmpty()) {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIIIIlIIIIlll, this, "commands.stopsound.success.all", llllllllllllllIllllIIIIIlIIIllll.getName());
            }
            else if (llllllllllllllIllllIIIIIlIIIllIl.isEmpty()) {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIIIIlIIIIlll, this, "commands.stopsound.success.soundSource", llllllllllllllIllllIIIIIlIIIlllI, llllllllllllllIllllIIIIIlIIIllll.getName());
            }
            else {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIIIIlIIIIlll, this, "commands.stopsound.success.individualSound", llllllllllllllIllllIIIIIlIIIllIl, llllllllllllllIllllIIIIIlIIIlllI, llllllllllllllIllllIIIIIlIIIllll.getName());
            }
            return;
        }
        throw new WrongUsageException(this.getCommandUsage(llllllllllllllIllllIIIIIlIIIIlll), new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllllIIIIIlIIlllll) {
        return "commands.stopsound.usage";
    }
    
    @Override
    public String getCommandName() {
        return "stopsound";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
