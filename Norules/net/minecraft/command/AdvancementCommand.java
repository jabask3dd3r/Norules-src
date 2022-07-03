package net.minecraft.command;

import com.google.common.collect.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class AdvancementCommand extends CommandBase
{
    private List<Advancement> func_193514_a(final Advancement lIIIllllIIIII, final Mode lIIIllllIIlII) {
        final List<Advancement> lIIIllllIIIll = (List<Advancement>)Lists.newArrayList();
        if (lIIIllllIIlII.field_193555_h) {
            for (Advancement lIIIllllIIIlI = lIIIllllIIIII.func_192070_b(); lIIIllllIIIlI != null; lIIIllllIIIlI = lIIIllllIIIlI.func_192070_b()) {
                lIIIllllIIIll.add(lIIIllllIIIlI);
            }
        }
        lIIIllllIIIll.add(lIIIllllIIIII);
        if (lIIIllllIIlII.field_193556_i) {
            this.func_193515_a(lIIIllllIIIII, lIIIllllIIIll);
        }
        return lIIIllllIIIll;
    }
    
    private void func_193515_a(final Advancement lIIIllllIllll, final List<Advancement> lIIIlllllIIlI) {
        for (final Advancement lIIIlllllIIIl : lIIIllllIllll.func_192069_e()) {
            lIIIlllllIIlI.add(lIIIlllllIIIl);
            this.func_193515_a(lIIIlllllIIIl, lIIIlllllIIlI);
        }
    }
    
    private void func_193516_a(final MinecraftServer lIIlIIIIIIIlI, final ICommandSender lIIlIIIIIIIIl, final String[] lIIlIIIIIIIII, final EntityPlayerMP lIIlIIIIIlIll, final ActionType lIIlIIIIIlIlI, final Mode lIIlIIIIIlIIl) throws CommandException {
        if (lIIlIIIIIlIIl == Mode.EVERYTHING) {
            if (lIIlIIIIIIIII.length != 3) {
                throw lIIlIIIIIlIIl.func_193544_a(lIIlIIIIIlIlI);
            }
            final int lIIlIIIIIlIII = lIIlIIIIIlIlI.func_193532_a(lIIlIIIIIlIll, lIIlIIIIIIIlI.func_191949_aK().func_192780_b());
            if (lIIlIIIIIlIII == 0) {
                throw lIIlIIIIIlIIl.func_193543_a(lIIlIIIIIlIlI, lIIlIIIIIlIll.getName());
            }
            lIIlIIIIIlIIl.func_193546_a(lIIlIIIIIIIIl, this, lIIlIIIIIlIlI, lIIlIIIIIlIll.getName(), lIIlIIIIIlIII);
        }
        else {
            if (lIIlIIIIIIIII.length < 4) {
                throw lIIlIIIIIlIIl.func_193544_a(lIIlIIIIIlIlI);
            }
            final Advancement lIIlIIIIIIlll = func_192551_a(lIIlIIIIIIIlI, lIIlIIIIIIIII[3]);
            if (lIIlIIIIIlIIl == Mode.ONLY && lIIlIIIIIIIII.length == 5) {
                final String lIIlIIIIIIllI = lIIlIIIIIIIII[4];
                if (!lIIlIIIIIIlll.func_192073_f().keySet().contains(lIIlIIIIIIllI)) {
                    throw new CommandException("commands.advancement.criterionNotFound", new Object[] { lIIlIIIIIIlll.func_192067_g(), lIIlIIIIIIIII[4] });
                }
                if (!lIIlIIIIIlIlI.func_193535_a(lIIlIIIIIlIll, lIIlIIIIIIlll, lIIlIIIIIIllI)) {
                    throw new CommandException(String.valueOf(new StringBuilder(String.valueOf(lIIlIIIIIlIlI.field_193541_d)).append(".criterion.failed")), new Object[] { lIIlIIIIIIlll.func_192067_g(), lIIlIIIIIlIll.getName(), lIIlIIIIIIllI });
                }
                CommandBase.notifyCommandListener(lIIlIIIIIIIIl, this, String.valueOf(new StringBuilder(String.valueOf(lIIlIIIIIlIlI.field_193541_d)).append(".criterion.success")), lIIlIIIIIIlll.func_192067_g(), lIIlIIIIIlIll.getName(), lIIlIIIIIIllI);
            }
            else {
                if (lIIlIIIIIIIII.length != 4) {
                    throw lIIlIIIIIlIIl.func_193544_a(lIIlIIIIIlIlI);
                }
                final List<Advancement> lIIlIIIIIIlIl = this.func_193514_a(lIIlIIIIIIlll, lIIlIIIIIlIIl);
                final int lIIlIIIIIIlII = lIIlIIIIIlIlI.func_193532_a(lIIlIIIIIlIll, lIIlIIIIIIlIl);
                if (lIIlIIIIIIlII == 0) {
                    throw lIIlIIIIIlIIl.func_193543_a(lIIlIIIIIlIlI, lIIlIIIIIIlll.func_192067_g(), lIIlIIIIIlIll.getName());
                }
                lIIlIIIIIlIIl.func_193546_a(lIIlIIIIIIIIl, this, lIIlIIIIIlIlI, lIIlIIIIIIlll.func_192067_g(), lIIlIIIIIlIll.getName(), lIIlIIIIIIlII);
            }
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lIIIllIIlIlII, final int lIIIllIIlIIll) {
        return lIIIllIIlIlII.length > 1 && ("grant".equals(lIIIllIIlIlII[0]) || "revoke".equals(lIIIllIIlIlII[0]) || "test".equals(lIIIllIIlIlII[0])) && lIIIllIIlIIll == 1;
    }
    
    private void func_192554_c(final ICommandSender lIIIlllIIllIl, final EntityPlayerMP lIIIlllIlIIll, final Advancement lIIIlllIlIIlI, final String lIIIlllIlIIIl) throws CommandException {
        final PlayerAdvancements lIIIlllIlIIII = lIIIlllIlIIll.func_192039_O();
        final CriterionProgress lIIIlllIIllll = lIIIlllIlIIII.func_192747_a(lIIIlllIlIIlI).func_192106_c(lIIIlllIlIIIl);
        if (lIIIlllIIllll == null) {
            throw new CommandException("commands.advancement.criterionNotFound", new Object[] { lIIIlllIlIIlI.func_192067_g(), lIIIlllIlIIIl });
        }
        if (!lIIIlllIIllll.func_192151_a()) {
            throw new CommandException("commands.advancement.test.criterion.notDone", new Object[] { lIIIlllIlIIll.getName(), lIIIlllIlIIlI.func_192067_g(), lIIIlllIlIIIl });
        }
        CommandBase.notifyCommandListener(lIIIlllIIllIl, this, "commands.advancement.test.criterion.success", lIIIlllIlIIll.getName(), lIIIlllIlIIlI.func_192067_g(), lIIIlllIlIIIl);
    }
    
    @Override
    public String getCommandName() {
        return "advancement";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    private void func_192552_c(final ICommandSender lIIIllIllllII, final EntityPlayerMP lIIIllIlllIll, final Advancement lIIIllIlllIlI) throws CommandException {
        final AdvancementProgress lIIIllIlllllI = lIIIllIlllIll.func_192039_O().func_192747_a(lIIIllIlllIlI);
        if (!lIIIllIlllllI.func_192105_a()) {
            throw new CommandException("commands.advancement.test.advancement.notDone", new Object[] { lIIIllIlllIll.getName(), lIIIllIlllIlI.func_192067_g() });
        }
        CommandBase.notifyCommandListener(lIIIllIllllII, this, "commands.advancement.test.advancement.success", lIIIllIlllIll.getName(), lIIIllIlllIlI.func_192067_g());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIIlIIIlIllll) {
        return "commands.advancement.usage";
    }
    
    public static Advancement func_192551_a(final MinecraftServer lIIIllIIIllIl, final String lIIIllIIIllII) throws CommandException {
        final Advancement lIIIllIIIlIll = lIIIllIIIllIl.func_191949_aK().func_192778_a(new ResourceLocation(lIIIllIIIllII));
        if (lIIIllIIIlIll == null) {
            throw new CommandException("commands.advancement.advancementNotFound", new Object[] { lIIIllIIIllII });
        }
        return lIIIllIIIlIll;
    }
    
    private List<ResourceLocation> func_193517_a(final MinecraftServer lIIIllIIllllI) {
        final List<ResourceLocation> lIIIllIIlllIl = (List<ResourceLocation>)Lists.newArrayList();
        for (final Advancement lIIIllIIlllII : lIIIllIIllllI.func_191949_aK().func_192780_b()) {
            lIIIllIIlllIl.add(lIIIllIIlllII.func_192067_g());
        }
        return lIIIllIIlllIl;
    }
    
    @Override
    public void execute(final MinecraftServer lIIlIIIIlllll, final ICommandSender lIIlIIIIllllI, final String[] lIIlIIIlIIlII) throws CommandException {
        if (lIIlIIIlIIlII.length < 1) {
            throw new WrongUsageException("commands.advancement.usage", new Object[0]);
        }
        final ActionType lIIlIIIlIIIll = ActionType.func_193536_a(lIIlIIIlIIlII[0]);
        if (lIIlIIIlIIIll != null) {
            if (lIIlIIIlIIlII.length < 3) {
                throw lIIlIIIlIIIll.func_193534_a();
            }
            final EntityPlayerMP lIIlIIIlIIIlI = CommandBase.getPlayer(lIIlIIIIlllll, lIIlIIIIllllI, lIIlIIIlIIlII[1]);
            final Mode lIIlIIIlIIIIl = Mode.func_193547_a(lIIlIIIlIIlII[2]);
            if (lIIlIIIlIIIIl == null) {
                throw lIIlIIIlIIIll.func_193534_a();
            }
            this.func_193516_a(lIIlIIIIlllll, lIIlIIIIllllI, lIIlIIIlIIlII, lIIlIIIlIIIlI, lIIlIIIlIIIll, lIIlIIIlIIIIl);
        }
        else {
            if (!"test".equals(lIIlIIIlIIlII[0])) {
                throw new WrongUsageException("commands.advancement.usage", new Object[0]);
            }
            if (lIIlIIIlIIlII.length == 3) {
                this.func_192552_c(lIIlIIIIllllI, CommandBase.getPlayer(lIIlIIIIlllll, lIIlIIIIllllI, lIIlIIIlIIlII[1]), func_192551_a(lIIlIIIIlllll, lIIlIIIlIIlII[2]));
            }
            else {
                if (lIIlIIIlIIlII.length != 4) {
                    throw new WrongUsageException("commands.advancement.test.usage", new Object[0]);
                }
                this.func_192554_c(lIIlIIIIllllI, CommandBase.getPlayer(lIIlIIIIlllll, lIIlIIIIllllI, lIIlIIIlIIlII[1]), func_192551_a(lIIlIIIIlllll, lIIlIIIlIIlII[2]), lIIlIIIlIIlII[3]);
            }
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lIIIllIlIlIII, final ICommandSender lIIIllIllIIII, final String[] lIIIllIlIIlll, @Nullable final BlockPos lIIIllIlIlllI) {
        if (lIIIllIlIIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, "grant", "revoke", "test");
        }
        final ActionType lIIIllIlIllIl = ActionType.func_193536_a(lIIIllIlIIlll[0]);
        if (lIIIllIlIllIl != null) {
            if (lIIIllIlIIlll.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, lIIIllIlIlIII.getAllUsernames());
            }
            if (lIIIllIlIIlll.length == 3) {
                return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, Mode.field_193553_f);
            }
            final Mode lIIIllIlIllII = Mode.func_193547_a(lIIIllIlIIlll[2]);
            if (lIIIllIlIllII != null && lIIIllIlIllII != Mode.EVERYTHING) {
                if (lIIIllIlIIlll.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, this.func_193517_a(lIIIllIlIlIII));
                }
                if (lIIIllIlIIlll.length == 5 && lIIIllIlIllII == Mode.ONLY) {
                    final Advancement lIIIllIlIlIll = lIIIllIlIlIII.func_191949_aK().func_192778_a(new ResourceLocation(lIIIllIlIIlll[3]));
                    if (lIIIllIlIlIll != null) {
                        return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, lIIIllIlIlIll.func_192073_f().keySet());
                    }
                }
            }
        }
        if ("test".equals(lIIIllIlIIlll[0])) {
            if (lIIIllIlIIlll.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, lIIIllIlIlIII.getAllUsernames());
            }
            if (lIIIllIlIIlll.length == 3) {
                return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, this.func_193517_a(lIIIllIlIlIII));
            }
            if (lIIIllIlIIlll.length == 4) {
                final Advancement lIIIllIlIlIlI = lIIIllIlIlIII.func_191949_aK().func_192778_a(new ResourceLocation(lIIIllIlIIlll[2]));
                if (lIIIllIlIlIlI != null) {
                    return CommandBase.getListOfStringsMatchingLastWord(lIIIllIlIIlll, lIIIllIlIlIlI.func_192073_f().keySet());
                }
            }
        }
        return Collections.emptyList();
    }
    
    enum Mode
    {
        ONLY("ONLY", 0, "only", false, false), 
        THROUGH("THROUGH", 1, "through", true, true), 
        UNTIL("UNTIL", 3, "until", true, false);
        
        final /* synthetic */ boolean field_193556_i;
        final /* synthetic */ boolean field_193555_h;
        
        FROM("FROM", 2, "from", false, true), 
        EVERYTHING("EVERYTHING", 4, "everything", true, true);
        
        final /* synthetic */ String field_193554_g;
        static final /* synthetic */ String[] field_193553_f;
        
        CommandException func_193543_a(final ActionType llllllllllllllIlllIlIlIIlIllIIII, final Object... llllllllllllllIlllIlIlIIlIlIllll) {
            return new CommandException(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIlIlIIlIllIIII.field_193541_d)).append(".").append(this.field_193554_g).append(".failed")), llllllllllllllIlllIlIlIIlIlIllll);
        }
        
        private Mode(final String llllllllllllllIlllIlIlIIlIllllII, final int llllllllllllllIlllIlIlIIlIlllIll, final String llllllllllllllIlllIlIlIIllIIIIII, final boolean llllllllllllllIlllIlIlIIlIlllIIl, final boolean llllllllllllllIlllIlIlIIlIlllllI) {
            this.field_193554_g = llllllllllllllIlllIlIlIIllIIIIII;
            this.field_193555_h = llllllllllllllIlllIlIlIIlIlllIIl;
            this.field_193556_i = llllllllllllllIlllIlIlIIlIlllllI;
        }
        
        static {
            field_193553_f = new String[values().length];
            for (int llllllllllllllIlllIlIlIIllIIlIIl = 0; llllllllllllllIlllIlIlIIllIIlIIl < values().length; ++llllllllllllllIlllIlIlIIllIIlIIl) {
                Mode.field_193553_f[llllllllllllllIlllIlIlIIllIIlIIl] = values()[llllllllllllllIlllIlIlIIllIIlIIl].field_193554_g;
            }
        }
        
        void func_193546_a(final ICommandSender llllllllllllllIlllIlIlIIlIlIIIlI, final AdvancementCommand llllllllllllllIlllIlIlIIlIIlllII, final ActionType llllllllllllllIlllIlIlIIlIlIIIII, final Object... llllllllllllllIlllIlIlIIlIIlllll) {
            CommandBase.notifyCommandListener(llllllllllllllIlllIlIlIIlIlIIIlI, llllllllllllllIlllIlIlIIlIIlllII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIlIlIIlIlIIIII.field_193541_d)).append(".").append(this.field_193554_g).append(".success")), llllllllllllllIlllIlIlIIlIIlllll);
        }
        
        @Nullable
        static Mode func_193547_a(final String llllllllllllllIlllIlIlIIlIIlIIlI) {
            int llllllllllllllIlllIlIlIIlIIIlllI;
            for (float llllllllllllllIlllIlIlIIlIIIllll = ((Mode[])(Object)(llllllllllllllIlllIlIlIIlIIIlllI = (int)(Object)values())).length, llllllllllllllIlllIlIlIIlIIlIIII = 0; llllllllllllllIlllIlIlIIlIIlIIII < llllllllllllllIlllIlIlIIlIIIllll; ++llllllllllllllIlllIlIlIIlIIlIIII) {
                final Mode llllllllllllllIlllIlIlIIlIIlIIll = llllllllllllllIlllIlIlIIlIIIlllI[llllllllllllllIlllIlIlIIlIIlIIII];
                if (llllllllllllllIlllIlIlIIlIIlIIll.field_193554_g.equals(llllllllllllllIlllIlIlIIlIIlIIlI)) {
                    return llllllllllllllIlllIlIlIIlIIlIIll;
                }
            }
            return null;
        }
        
        CommandException func_193544_a(final ActionType llllllllllllllIlllIlIlIIlIlIlIIl) {
            return new CommandException(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIlIlIIlIlIlIIl.field_193541_d)).append(".").append(this.field_193554_g).append(".usage")), new Object[0]);
        }
    }
    
    enum ActionType
    {
        REVOKE(1, "revoke") {
            @Override
            protected boolean func_193535_a(final EntityPlayerMP lllllllllllllIIllIIIllllIlllllII, final Advancement lllllllllllllIIllIIIllllIllllllI, final String lllllllllllllIIllIIIllllIllllIlI) {
                return lllllllllllllIIllIIIllllIlllllII.func_192039_O().func_192744_b(lllllllllllllIIllIIIllllIllllllI, lllllllllllllIIllIIIllllIllllIlI);
            }
            
            @Override
            protected boolean func_193537_a(final EntityPlayerMP lllllllllllllIIllIIIlllllIIIlIII, final Advancement lllllllllllllIIllIIIlllllIIIIlll) {
                final AdvancementProgress lllllllllllllIIllIIIlllllIIIlIlI = lllllllllllllIIllIIIlllllIIIlIII.func_192039_O().func_192747_a(lllllllllllllIIllIIIlllllIIIIlll);
                if (!lllllllllllllIIllIIIlllllIIIlIlI.func_192108_b()) {
                    return false;
                }
                for (final String lllllllllllllIIllIIIlllllIIIlIIl : lllllllllllllIIllIIIlllllIIIlIlI.func_192102_e()) {
                    lllllllllllllIIllIIIlllllIIIlIII.func_192039_O().func_192744_b(lllllllllllllIIllIIIlllllIIIIlll, lllllllllllllIIllIIIlllllIIIlIIl);
                }
                return true;
            }
        };
        
        final /* synthetic */ String field_193540_c;
        
        GRANT(0, "grant") {
            @Override
            protected boolean func_193535_a(final EntityPlayerMP lllllllllllllIIIIIlIlIlllIllIIlI, final Advancement lllllllllllllIIIIIlIlIlllIllIlII, final String lllllllllllllIIIIIlIlIlllIllIIII) {
                return lllllllllllllIIIIIlIlIlllIllIIlI.func_192039_O().func_192750_a(lllllllllllllIIIIIlIlIlllIllIlII, lllllllllllllIIIIIlIlIlllIllIIII);
            }
            
            @Override
            protected boolean func_193537_a(final EntityPlayerMP lllllllllllllIIIIIlIlIllllIIIIlI, final Advancement lllllllllllllIIIIIlIlIllllIIIIIl) {
                final AdvancementProgress lllllllllllllIIIIIlIlIllllIIIIII = lllllllllllllIIIIIlIlIllllIIIIlI.func_192039_O().func_192747_a(lllllllllllllIIIIIlIlIllllIIIIIl);
                if (lllllllllllllIIIIIlIlIllllIIIIII.func_192105_a()) {
                    return false;
                }
                for (final String lllllllllllllIIIIIlIlIlllIllllll : lllllllllllllIIIIIlIlIllllIIIIII.func_192107_d()) {
                    lllllllllllllIIIIIlIlIllllIIIIlI.func_192039_O().func_192750_a(lllllllllllllIIIIIlIlIllllIIIIIl, lllllllllllllIIIIIlIlIlllIllllll);
                }
                return true;
            }
        };
        
        final /* synthetic */ String field_193541_d;
        
        @Nullable
        static ActionType func_193536_a(final String lllllllllllllIIIIlllIIIIllIIlIII) {
            final double lllllllllllllIIIIlllIIIIllIIIIlI;
            final short lllllllllllllIIIIlllIIIIllIIIIll = (short)((ActionType[])(Object)(lllllllllllllIIIIlllIIIIllIIIIlI = (double)(Object)values())).length;
            for (String lllllllllllllIIIIlllIIIIllIIIlII = (String)0; lllllllllllllIIIIlllIIIIllIIIlII < lllllllllllllIIIIlllIIIIllIIIIll; ++lllllllllllllIIIIlllIIIIllIIIlII) {
                final ActionType lllllllllllllIIIIlllIIIIllIIIlll = lllllllllllllIIIIlllIIIIllIIIIlI[lllllllllllllIIIIlllIIIIllIIIlII];
                if (lllllllllllllIIIIlllIIIIllIIIlll.field_193540_c.equals(lllllllllllllIIIIlllIIIIllIIlIII)) {
                    return lllllllllllllIIIIlllIIIIllIIIlll;
                }
            }
            return null;
        }
        
        public int func_193532_a(final EntityPlayerMP lllllllllllllIIIIlllIIIIlIllIlll, final Iterable<Advancement> lllllllllllllIIIIlllIIIIlIllIllI) {
            int lllllllllllllIIIIlllIIIIlIllIlIl = 0;
            for (final Advancement lllllllllllllIIIIlllIIIIlIllIlII : lllllllllllllIIIIlllIIIIlIllIllI) {
                if (this.func_193537_a(lllllllllllllIIIIlllIIIIlIllIlll, lllllllllllllIIIIlllIIIIlIllIlII)) {
                    ++lllllllllllllIIIIlllIIIIlIllIlIl;
                }
            }
            return lllllllllllllIIIIlllIIIIlIllIlIl;
        }
        
        protected abstract boolean func_193535_a(final EntityPlayerMP p0, final Advancement p1, final String p2);
        
        protected abstract boolean func_193537_a(final EntityPlayerMP p0, final Advancement p1);
        
        CommandException func_193534_a() {
            return new CommandException(String.valueOf(new StringBuilder(String.valueOf(this.field_193541_d)).append(".usage")), new Object[0]);
        }
        
        private ActionType(final String lllllllllllllIIIIlllIIIIllIlIIII, final int lllllllllllllIIIIlllIIIIllIIllll, final String lllllllllllllIIIIlllIIIIllIIlllI) {
            this.field_193540_c = lllllllllllllIIIIlllIIIIllIIlllI;
            this.field_193541_d = String.valueOf(new StringBuilder("commands.advancement.").append(lllllllllllllIIIIlllIIIIllIIlllI));
        }
    }
}
