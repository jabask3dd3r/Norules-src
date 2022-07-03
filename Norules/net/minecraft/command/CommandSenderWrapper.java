package net.minecraft.command;

import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.server.*;

public class CommandSenderWrapper implements ICommandSender
{
    @Nullable
    private final /* synthetic */ Vec3d field_194002_b;
    @Nullable
    private final /* synthetic */ BlockPos field_194003_c;
    @Nullable
    private final /* synthetic */ Integer field_194004_d;
    @Nullable
    private final /* synthetic */ Boolean field_194006_f;
    private final /* synthetic */ ICommandSender field_193043_a;
    @Nullable
    private final /* synthetic */ Entity field_194005_e;
    
    @Override
    public BlockPos getPosition() {
        if (this.field_194003_c != null) {
            return this.field_194003_c;
        }
        return (this.field_194005_e != null) ? this.field_194005_e.getPosition() : this.field_193043_a.getPosition();
    }
    
    public CommandSenderWrapper(final ICommandSender llllllllllllllIlllIIIlIIIlllIIIl, @Nullable final Vec3d llllllllllllllIlllIIIlIIIlllIlll, @Nullable final BlockPos llllllllllllllIlllIIIlIIIllIllll, @Nullable final Integer llllllllllllllIlllIIIlIIIlllIlIl, @Nullable final Entity llllllllllllllIlllIIIlIIIllIllIl, @Nullable final Boolean llllllllllllllIlllIIIlIIIllIllII) {
        this.field_193043_a = llllllllllllllIlllIIIlIIIlllIIIl;
        this.field_194002_b = llllllllllllllIlllIIIlIIIlllIlll;
        this.field_194003_c = llllllllllllllIlllIIIlIIIllIllll;
        this.field_194004_d = llllllllllllllIlllIIIlIIIlllIlIl;
        this.field_194005_e = llllllllllllllIlllIIIlIIIllIllIl;
        this.field_194006_f = llllllllllllllIlllIIIlIIIllIllII;
    }
    
    @Override
    public String getName() {
        return (this.field_194005_e != null) ? this.field_194005_e.getName() : this.field_193043_a.getName();
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllIlllIIIlIIIlIIIIII, final String llllllllllllllIlllIIIlIIIIllllll) {
        return (this.field_194004_d == null || this.field_194004_d >= llllllllllllllIlllIIIlIIIlIIIIII) && this.field_193043_a.canCommandSenderUseCommand(llllllllllllllIlllIIIlIIIlIIIIII, llllllllllllllIlllIIIlIIIIllllll);
    }
    
    @Override
    public Vec3d getPositionVector() {
        if (this.field_194002_b != null) {
            return this.field_194002_b;
        }
        return (this.field_194005_e != null) ? this.field_194005_e.getPositionVector() : this.field_193043_a.getPositionVector();
    }
    
    @Override
    public void addChatMessage(final ITextComponent llllllllllllllIlllIIIlIIIlIIIlIl) {
        if (this.field_194006_f == null || this.field_194006_f) {
            this.field_193043_a.addChatMessage(llllllllllllllIlllIIIlIIIlIIIlIl);
        }
    }
    
    public CommandSenderWrapper func_193999_a(final int llllllllllllllIlllIIIlIIIlIlllII) {
        return (this.field_194004_d != null && this.field_194004_d <= llllllllllllllIlllIIIlIIIlIlllII) ? this : new CommandSenderWrapper(this.field_193043_a, this.field_194002_b, this.field_194003_c, llllllllllllllIlllIIIlIIIlIlllII, this.field_194005_e, this.field_194006_f);
    }
    
    @Override
    public void setCommandStat(final CommandResultStats.Type llllllllllllllIlllIIIlIIIIlIlIII, final int llllllllllllllIlllIIIlIIIIlIIlll) {
        if (this.field_194005_e != null) {
            this.field_194005_e.setCommandStat(llllllllllllllIlllIIIlIIIIlIlIII, llllllllllllllIlllIIIlIIIIlIIlll);
        }
        else {
            this.field_193043_a.setCommandStat(llllllllllllllIlllIIIlIIIIlIlIII, llllllllllllllIlllIIIlIIIIlIIlll);
        }
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return (this.field_194006_f != null) ? this.field_194006_f : this.field_193043_a.sendCommandFeedback();
    }
    
    public CommandSenderWrapper func_194001_a(final boolean llllllllllllllIlllIIIlIIIlIlIlII) {
        return (this.field_194006_f == null || (this.field_194006_f && !llllllllllllllIlllIIIlIIIlIlIlII)) ? new CommandSenderWrapper(this.field_193043_a, this.field_194002_b, this.field_194003_c, this.field_194004_d, this.field_194005_e, llllllllllllllIlllIIIlIIIlIlIlII) : this;
    }
    
    public CommandSenderWrapper func_193997_a(final Entity llllllllllllllIlllIIIlIIIllIIIIl, final Vec3d llllllllllllllIlllIIIlIIIllIIIll) {
        return (this.field_194005_e == llllllllllllllIlllIIIlIIIllIIIIl && Objects.equals(this.field_194002_b, llllllllllllllIlllIIIlIIIllIIIll)) ? this : new CommandSenderWrapper(this.field_193043_a, llllllllllllllIlllIIIlIIIllIIIll, new BlockPos(llllllllllllllIlllIIIlIIIllIIIll), this.field_194004_d, llllllllllllllIlllIIIlIIIllIIIIl, this.field_194006_f);
    }
    
    @Override
    public World getEntityWorld() {
        return (this.field_194005_e != null) ? this.field_194005_e.getEntityWorld() : this.field_193043_a.getEntityWorld();
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return (this.field_194005_e != null) ? this.field_194005_e.getDisplayName() : this.field_193043_a.getDisplayName();
    }
    
    public CommandSenderWrapper func_194000_i() {
        return (this.field_194002_b != null) ? this : new CommandSenderWrapper(this.field_193043_a, this.getPositionVector(), this.getPosition(), this.field_194004_d, this.field_194005_e, this.field_194006_f);
    }
    
    @Nullable
    @Override
    public Entity getCommandSenderEntity() {
        return (this.field_194005_e != null) ? this.field_194005_e.getCommandSenderEntity() : this.field_193043_a.getCommandSenderEntity();
    }
    
    @Nullable
    @Override
    public MinecraftServer getServer() {
        return this.field_193043_a.getServer();
    }
    
    public static CommandSenderWrapper func_193998_a(final ICommandSender llllllllllllllIlllIIIlIIIllIlIIl) {
        return (CommandSenderWrapper)((llllllllllllllIlllIIIlIIIllIlIIl instanceof CommandSenderWrapper) ? llllllllllllllIlllIIIlIIIllIlIIl : new CommandSenderWrapper(llllllllllllllIlllIIIlIIIllIlIIl, null, null, null, null, null));
    }
}
