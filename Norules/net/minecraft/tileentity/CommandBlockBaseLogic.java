package net.minecraft.tileentity;

import net.minecraft.command.*;
import java.text.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.text.*;
import io.netty.buffer.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;

public abstract class CommandBlockBaseLogic implements ICommandSender
{
    private /* synthetic */ long field_193041_b;
    private /* synthetic */ ITextComponent lastOutput;
    private /* synthetic */ String commandStored;
    private /* synthetic */ String customName;
    private /* synthetic */ boolean field_193042_c;
    private final /* synthetic */ CommandResultStats resultStats;
    private /* synthetic */ int successCount;
    private /* synthetic */ boolean trackOutput;
    private static final /* synthetic */ SimpleDateFormat TIMESTAMP_FORMAT;
    
    public boolean tryOpenEditCommandBlock(final EntityPlayer lllllllllllllllIIIlIIIlllIlIIlII) {
        if (!lllllllllllllllIIIlIIIlllIlIIlII.canUseCommandBlock()) {
            return false;
        }
        if (lllllllllllllllIIIlIIIlllIlIIlII.getEntityWorld().isRemote) {
            lllllllllllllllIIIlIIIlllIlIIlII.displayGuiEditCommandCart(this);
        }
        return true;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllllIIIlIIIlllllIIllI) {
        if (this.trackOutput && this.getEntityWorld() != null && !this.getEntityWorld().isRemote) {
            this.lastOutput = new TextComponentString(String.valueOf(new StringBuilder("[").append(CommandBlockBaseLogic.TIMESTAMP_FORMAT.format(new Date())).append("] "))).appendSibling(lllllllllllllllIIIlIIIlllllIIllI);
            this.updateCommand();
        }
    }
    
    public abstract int getCommandBlockType();
    
    public int getSuccessCount() {
        return this.successCount;
    }
    
    public abstract void fillInInfo(final ByteBuf p0);
    
    public CommandResultStats getCommandResultStats() {
        return this.resultStats;
    }
    
    public void setLastOutput(@Nullable final ITextComponent lllllllllllllllIIIlIIIllllIIIlII) {
        this.lastOutput = lllllllllllllllIIIlIIIllllIIIlII;
    }
    
    public void setCommand(final String lllllllllllllllIIIlIIlIIIIlIIlll) {
        this.commandStored = lllllllllllllllIIIlIIlIIIIlIIlll;
        this.successCount = 0;
    }
    
    public boolean shouldTrackOutput() {
        return this.trackOutput;
    }
    
    public String getCommand() {
        return this.commandStored;
    }
    
    public CommandBlockBaseLogic() {
        this.field_193041_b = -1L;
        this.field_193042_c = true;
        this.trackOutput = true;
        this.commandStored = "";
        this.customName = "@";
        this.resultStats = new CommandResultStats();
    }
    
    public void readDataFromNBT(final NBTTagCompound lllllllllllllllIIIlIIlIIIlIIIIlI) {
        this.commandStored = lllllllllllllllIIIlIIlIIIlIIIIlI.getString("Command");
        this.successCount = lllllllllllllllIIIlIIlIIIlIIIIlI.getInteger("SuccessCount");
        if (lllllllllllllllIIIlIIlIIIlIIIIlI.hasKey("CustomName", 8)) {
            this.customName = lllllllllllllllIIIlIIlIIIlIIIIlI.getString("CustomName");
        }
        if (lllllllllllllllIIIlIIlIIIlIIIIlI.hasKey("TrackOutput", 1)) {
            this.trackOutput = lllllllllllllllIIIlIIlIIIlIIIIlI.getBoolean("TrackOutput");
        }
        if (lllllllllllllllIIIlIIlIIIlIIIIlI.hasKey("LastOutput", 8) && this.trackOutput) {
            try {
                this.lastOutput = ITextComponent.Serializer.jsonToComponent(lllllllllllllllIIIlIIlIIIlIIIIlI.getString("LastOutput"));
            }
            catch (Throwable lllllllllllllllIIIlIIlIIIlIIIlII) {
                this.lastOutput = new TextComponentString(lllllllllllllllIIIlIIlIIIlIIIlII.getMessage());
            }
        }
        else {
            this.lastOutput = null;
        }
        if (lllllllllllllllIIIlIIlIIIlIIIIlI.hasKey("UpdateLastExecution")) {
            this.field_193042_c = lllllllllllllllIIIlIIlIIIlIIIIlI.getBoolean("UpdateLastExecution");
        }
        if (this.field_193042_c && lllllllllllllllIIIlIIlIIIlIIIIlI.hasKey("LastExecution")) {
            this.field_193041_b = lllllllllllllllIIIlIIlIIIlIIIIlI.getLong("LastExecution");
        }
        else {
            this.field_193041_b = -1L;
        }
        this.resultStats.readStatsFromNBT(lllllllllllllllIIIlIIlIIIlIIIIlI);
    }
    
    public ITextComponent getLastOutput() {
        return (this.lastOutput == null) ? new TextComponentString("") : this.lastOutput;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllllIIIlIIlIIIIlllIll, final String lllllllllllllllIIIlIIlIIIIlllIIl) {
        return lllllllllllllllIIIlIIlIIIIlllIll <= 2;
    }
    
    public void setSuccessCount(final int lllllllllllllllIIIlIIlIIIllIlllI) {
        this.successCount = lllllllllllllllIIIlIIlIIIllIlllI;
    }
    
    public void setTrackOutput(final boolean lllllllllllllllIIIlIIIlllIlllIll) {
        this.trackOutput = lllllllllllllllIIIlIIIlllIlllIll;
    }
    
    public void setName(final String lllllllllllllllIIIlIIIllllllIllI) {
        this.customName = lllllllllllllllIIIlIIIllllllIllI;
    }
    
    @Override
    public String getName() {
        return this.customName;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIIIlIIlIIIlIllIIl) {
        lllllllllllllllIIIlIIlIIIlIllIIl.setString("Command", this.commandStored);
        lllllllllllllllIIIlIIlIIIlIllIIl.setInteger("SuccessCount", this.successCount);
        lllllllllllllllIIIlIIlIIIlIllIIl.setString("CustomName", this.customName);
        lllllllllllllllIIIlIIlIIIlIllIIl.setBoolean("TrackOutput", this.trackOutput);
        if (this.lastOutput != null && this.trackOutput) {
            lllllllllllllllIIIlIIlIIIlIllIIl.setString("LastOutput", ITextComponent.Serializer.componentToJson(this.lastOutput));
        }
        lllllllllllllllIIIlIIlIIIlIllIIl.setBoolean("UpdateLastExecution", this.field_193042_c);
        if (this.field_193042_c && this.field_193041_b > 0L) {
            lllllllllllllllIIIlIIlIIIlIllIIl.setLong("LastExecution", this.field_193041_b);
        }
        this.resultStats.writeStatsToNBT(lllllllllllllllIIIlIIlIIIlIllIIl);
        return lllllllllllllllIIIlIIlIIIlIllIIl;
    }
    
    static {
        TIMESTAMP_FORMAT = new SimpleDateFormat("HH:mm:ss");
    }
    
    @Override
    public void setCommandStat(final CommandResultStats.Type lllllllllllllllIIIlIIIllllIIlIll, final int lllllllllllllllIIIlIIIllllIIllll) {
        this.resultStats.setCommandStatForSender(this.getServer(), this, lllllllllllllllIIIlIIIllllIIlIll, lllllllllllllllIIIlIIIllllIIllll);
    }
    
    @Override
    public boolean sendCommandFeedback() {
        final MinecraftServer lllllllllllllllIIIlIIIlllllIIIII = this.getServer();
        return lllllllllllllllIIIlIIIlllllIIIII == null || !lllllllllllllllIIIlIIIlllllIIIII.isAnvilFileSet() || lllllllllllllllIIIlIIIlllllIIIII.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
    }
    
    public abstract void updateCommand();
    
    public boolean trigger(final World lllllllllllllllIIIlIIlIIIIIIIlIl) {
        if (lllllllllllllllIIIlIIlIIIIIIIlIl.isRemote || lllllllllllllllIIIlIIlIIIIIIIlIl.getTotalWorldTime() == this.field_193041_b) {
            return false;
        }
        if ("Searge".equalsIgnoreCase(this.commandStored)) {
            this.lastOutput = new TextComponentString("#itzlipofutzli");
            this.successCount = 1;
            return true;
        }
        final MinecraftServer lllllllllllllllIIIlIIlIIIIIIlIlI = this.getServer();
        Label_0168: {
            if (lllllllllllllllIIIlIIlIIIIIIlIlI != null && lllllllllllllllIIIlIIlIIIIIIlIlI.isAnvilFileSet() && lllllllllllllllIIIlIIlIIIIIIlIlI.isCommandBlockEnabled()) {
                try {
                    this.lastOutput = null;
                    this.successCount = lllllllllllllllIIIlIIlIIIIIIlIlI.getCommandManager().executeCommand(this, this.commandStored);
                    break Label_0168;
                }
                catch (Throwable lllllllllllllllIIIlIIlIIIIIIlIIl) {
                    final CrashReport lllllllllllllllIIIlIIlIIIIIIlIII = CrashReport.makeCrashReport(lllllllllllllllIIIlIIlIIIIIIlIIl, "Executing command block");
                    final CrashReportCategory lllllllllllllllIIIlIIlIIIIIIIlll = lllllllllllllllIIIlIIlIIIIIIlIII.makeCategory("Command to be executed");
                    lllllllllllllllIIIlIIlIIIIIIIlll.setDetail("Command", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return CommandBlockBaseLogic.this.getCommand();
                        }
                    });
                    lllllllllllllllIIIlIIlIIIIIIIlll.setDetail("Name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return CommandBlockBaseLogic.this.getName();
                        }
                    });
                    throw new ReportedException(lllllllllllllllIIIlIIlIIIIIIlIII);
                }
            }
            this.successCount = 0;
        }
        if (this.field_193042_c) {
            this.field_193041_b = lllllllllllllllIIIlIIlIIIIIIIlIl.getTotalWorldTime();
        }
        else {
            this.field_193041_b = -1L;
        }
        return true;
    }
}
