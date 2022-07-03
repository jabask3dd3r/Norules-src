package me.nrules;

import clickui.*;
import com.kisman.nr.cc.manager.*;
import config.*;
import clickui.settings.*;
import me.nrules.commands.*;
import me.nrules.event.events.*;
import me.nrules.module.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.client.*;
import net.minecraft.util.text.*;
import me.nrules.event.*;
import java.net.*;
import java.awt.*;
import file.impl.*;
import file.*;
import ViaMCP.minecraft.viamcp1_12.*;
import org.lwjgl.opengl.*;

public class Main
{
    public static /* synthetic */ Interface clickGui1;
    public static /* synthetic */ Main instance;
    public static /* synthetic */ FileFactory fileFactory;
    public static /* synthetic */ EventManager eventManager;
    public static /* synthetic */ Managers managers;
    public static /* synthetic */ String name;
    public static /* synthetic */ ConfigManager configManager;
    public static /* synthetic */ ModuleManager moduleManager;
    public static /* synthetic */ SM settingsManager;
    public static /* synthetic */ CommandManager commandManager;
    
    public static void msg(final String lllllllllllllIlIlIlllIIllIlllIII) {
        final String lllllllllllllIlIlIlllIIllIllIlll = String.valueOf(new StringBuilder().append(ChatFormatting.WHITE).append("[").append(ChatFormatting.LIGHT_PURPLE).append("NoRules").append(ChatFormatting.WHITE).append("]: "));
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(String.valueOf(new StringBuilder().append(lllllllllllllIlIlIlllIIllIllIlll).append(lllllllllllllIlIlIlllIIllIlllIII))));
    }
    
    public static void stopClient() {
        EventManager.unregister(Main.instance);
    }
    
    @EventTarget
    public void onKey(final EventKey lllllllllllllIlIlIlllIIllIllIIIl) {
        ModuleManager.getModules().stream().filter(lllllllllllllIlIlIlllIIllIlIIlII -> lllllllllllllIlIlIlllIIllIlIIlII.getKey() == lllllllllllllIlIlIlllIIllIllIIIl.getKey()).forEach(Module::toggle);
    }
    
    public static boolean openWebpage(final URI lllllllllllllIlIlIlllIIllIlIlIlI) {
        final Desktop lllllllllllllIlIlIlllIIllIlIlIll = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (lllllllllllllIlIlIlllIIllIlIlIll != null && lllllllllllllIlIlIlllIIllIlIlIll.isSupported(Desktop.Action.BROWSE)) {
            try {
                lllllllllllllIlIlIlllIIllIlIlIll.browse(lllllllllllllIlIlIlllIIllIlIlIlI);
                return true;
            }
            catch (Exception lllllllllllllIlIlIlllIIllIlIllIl) {
                lllllllllllllIlIlIlllIIllIlIllIl.printStackTrace();
            }
        }
        return false;
    }
    
    static {
        Main.instance = new Main();
        Main.name = "NoRules Free Edition";
    }
    
    public static void startClient() {
        try {
            openWebpage(new URI("https://vk.com/nrclient"));
        }
        catch (Exception lllllllllllllIlIlIlllIIllIllllIl) {
            lllllllllllllIlIlIlllIIllIllllIl.printStackTrace();
        }
        (Main.managers = new Managers()).init();
        Main.settingsManager = new SM();
        Main.eventManager = new EventManager();
        Main.moduleManager = new ModuleManager();
        (Main.fileFactory = new FileFactory()).setupRoot("NoRulesLite");
        Main.fileFactory.add(new ModulesFile());
        Main.configManager = new ConfigManager();
        Main.commandManager = new CommandManager();
        (Main.clickGui1 = new Interface()).setup();
        try {
            ViaMCP.getInstance().start();
        }
        catch (Exception lllllllllllllIlIlIlllIIllIllllII) {
            lllllllllllllIlIlIlllIIllIllllII.printStackTrace();
        }
        Display.setTitle(Main.name);
        EventManager.register(Main.instance);
    }
}
