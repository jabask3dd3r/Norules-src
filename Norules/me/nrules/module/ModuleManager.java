package me.nrules.module;

import java.util.stream.*;
import net.minecraft.network.play.server.*;
import me.nrules.module.movement.*;
import me.nrules.module.player.*;
import me.nrules.module.render.*;
import me.nrules.module.misc.*;
import me.nrules.module.exploit.*;
import me.nrules.module.combat.*;
import java.util.*;
import font.*;
import me.nrules.*;

public class ModuleManager
{
    private static /* synthetic */ ArrayList<Module> modules;
    
    public List<Module> getCheats(final Category lllllIlllIlI) {
        return getModules().stream().filter(lllllIIlIIIl -> lllllIIlIIIl.getCategory() == lllllIlllIlI).collect((Collector<? super Object, ?, List<Module>>)Collectors.toList());
    }
    
    public Module get(final Class<?> lllllIlIlIlI) {
        return getModules().stream().filter(lllllIIIIlll -> lllllIIIIlll.getClass() == lllllIlIlIlI).findFirst().orElse(null);
    }
    
    public static boolean onReceiveChatMessage(final SPacketChat lllllIlIIlII) {
        for (final Module lllllIlIIlIl : getModules()) {
            if (lllllIlIIlIl.isToggled()) {
                return lllllIlIIlIl.onRecieveChatMessage(lllllIlIIlII);
            }
        }
        return true;
    }
    
    public ModuleManager() {
        ModuleManager.modules.add(new AntiBot());
        ModuleManager.modules.add(new AutoArmor());
        ModuleManager.modules.add(new AutoGApple());
        ModuleManager.modules.add(new FastBow());
        ModuleManager.modules.add(new HitBox());
        ModuleManager.modules.add(new Killaura());
        ModuleManager.modules.add(new AutoTotem());
        ModuleManager.modules.add(new TriggerBot());
        ModuleManager.modules.add(new Velocity());
        ModuleManager.modules.add(new AirJump());
        ModuleManager.modules.add(new AutoPotion());
        ModuleManager.modules.add(new Fly());
        ModuleManager.modules.add(new GuiWalk());
        ModuleManager.modules.add(new NoSlowDown());
        ModuleManager.modules.add(new NoWeb());
        ModuleManager.modules.add(new Speed());
        ModuleManager.modules.add(new Spider());
        ModuleManager.modules.add(new Sprint());
        ModuleManager.modules.add(new Step());
        ModuleManager.modules.add(new TargetStrafe());
        ModuleManager.modules.add(new WaterFeatures());
        ModuleManager.modules.add(new NoJumpDelay());
        ModuleManager.modules.add(new FastPlace());
        ModuleManager.modules.add(new NoFall());
        ModuleManager.modules.add(new Freecam());
        ModuleManager.modules.add(new NoClip());
        ModuleManager.modules.add(new NoPush());
        ModuleManager.modules.add(new FullBright());
        ModuleManager.modules.add(new NoOverlay());
        ModuleManager.modules.add(new Animation());
        ModuleManager.modules.add(new DamageParticle());
        ModuleManager.modules.add(new Trajectories());
        ModuleManager.modules.add(new NameProtect());
        ModuleManager.modules.add(new Chams());
        ModuleManager.modules.add(new NoSBoard());
        ModuleManager.modules.add(new ChestESP());
        ModuleManager.modules.add(new ESP());
        ModuleManager.modules.add(new ModuleList());
        ModuleManager.modules.add(new SkyColor());
        ModuleManager.modules.add(new ClickGUI());
        ModuleManager.modules.add(new NameTags());
        ModuleManager.modules.add(new CustomModel());
        ModuleManager.modules.add(new CameraClip());
        ModuleManager.modules.add(new Tracers());
        ModuleManager.modules.add(new Notifications());
        ModuleManager.modules.add(new AutoTool());
        ModuleManager.modules.add(new MiddleClickFriend());
        ModuleManager.modules.add(new Spammer());
        ModuleManager.modules.add(new XCarry());
        ModuleManager.modules.add(new Timer());
        ModuleManager.modules.add(new AutoLogin());
        ModuleManager.modules.add(new AutoAccept());
        ModuleManager.modules.add(new VisualSnow());
        ModuleManager.modules.add(new Panic());
        ModuleManager.modules.add(new WorldTime());
        ModuleManager.modules.add(new MClickPearl());
        ModuleManager.modules.add(new AntiLogger());
        ModuleManager.modules.add(new OffHand());
        ModuleManager.modules.add(new AutoTrap());
        final MinecraftFontRenderer llllllIIIIII = FontLoader.INSTANCE.comfortaa_bold_20;
        ModuleManager.modules.sort(Comparator.comparingInt(lllllIIlIlII -> llllllIIIIII.getStringWidth(lllllIIlIlII.getName())).reversed());
    }
    
    public static ArrayList<Module> getModules() {
        return ModuleManager.modules;
    }
    
    public Module getModuleByName(final String lllllIllIllI) {
        return ModuleManager.modules.stream().filter(lllllIIIlIlI -> lllllIIIlIlI.getName().equalsIgnoreCase(lllllIllIllI)).findFirst().orElse(null);
    }
    
    static {
        ModuleManager.modules = new ArrayList<Module>();
    }
    
    public static boolean onSendMessage(final String lllllIllIIlI) {
        if (lllllIllIIlI.startsWith(".")) {
            Main.commandManager.callCommand(lllllIllIIlI.substring(1));
            return false;
        }
        for (final Module lllllIllIIIl : getModules()) {
            if (lllllIllIIIl.isToggled()) {
                return lllllIllIIIl.onSendChatMessage(lllllIllIIlI);
            }
        }
        return true;
    }
    
    public Module getModule(final Class lllllIIllIll) {
        for (final Module lllllIIlllII : ModuleManager.modules) {
            if (lllllIIlllII.getClass() != lllllIIllIll) {
                continue;
            }
            return lllllIIlllII;
        }
        return null;
    }
}
