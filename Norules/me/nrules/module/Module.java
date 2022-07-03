package me.nrules.module;

import config.*;
import me.nrules.utils.render.*;
import me.nrules.utils.world.*;
import net.minecraft.client.*;
import me.nrules.*;
import clickui.settings.*;
import java.util.*;
import me.nrules.event.*;
import net.minecraft.init.*;
import net.minecraft.network.play.server.*;
import com.google.gson.*;

public class Module implements Serializable
{
    private final /* synthetic */ Translate translate;
    protected static /* synthetic */ SM sm;
    private /* synthetic */ String suffix;
    private /* synthetic */ String moduleName;
    public static /* synthetic */ TimerHelper timerHelper;
    private /* synthetic */ String name;
    private /* synthetic */ int key;
    private /* synthetic */ Category category;
    protected static /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean toggled;
    
    public void setup() {
    }
    
    static {
        Module.mc = Minecraft.getMinecraft();
        Module.sm = Main.settingsManager;
        Module.timerHelper = new TimerHelper();
    }
    
    public Module(final String lllllllllllllIllIIlllIIllIIIIlll, final int lllllllllllllIllIIlllIIllIIIIIlI, final Category lllllllllllllIllIIlllIIllIIIIIIl) {
        this.translate = new Translate(0.0f, 0.0f);
        this.name = lllllllllllllIllIIlllIIllIIIIlll;
        this.key = lllllllllllllIllIIlllIIllIIIIIlI;
        this.category = lllllllllllllIllIIlllIIllIIIIIIl;
        this.toggled = false;
        this.setup();
    }
    
    public void setSuffix(final String lllllllllllllIllIIlllIIlIlIIIlll) {
        this.suffix = lllllllllllllIllIIlllIIlIlIIIlll;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    @Override
    public void load(final JsonObject lllllllllllllIllIIlllIIlIIIlIIII) {
        if (lllllllllllllIllIIlllIIlIIIlIIII.has("toggled")) {
            this.setToggled(lllllllllllllIllIIlllIIlIIIlIIII.get("toggled").getAsBoolean());
        }
        if (lllllllllllllIllIIlllIIlIIIlIIII.has("key")) {
            this.setKey(lllllllllllllIllIIlllIIlIIIlIIII.get("key").getAsInt());
        }
        final List<Setting> lllllllllllllIllIIlllIIlIIIlIlII = Main.settingsManager.getSettingsByMod(this);
        if (lllllllllllllIllIIlllIIlIIIlIIII.has("Properties") && lllllllllllllIllIIlllIIlIIIlIlII != null && !lllllllllllllIllIIlllIIlIIIlIlII.isEmpty()) {
            final JsonObject lllllllllllllIllIIlllIIlIIIlIIll = lllllllllllllIllIIlllIIlIIIlIIII.getAsJsonObject("Properties");
            for (final Setting lllllllllllllIllIIlllIIlIIIlIIlI : lllllllllllllIllIIlllIIlIIIlIlII) {
                if (lllllllllllllIllIIlllIIlIIIlIIll.has(lllllllllllllIllIIlllIIlIIIlIIlI.getName())) {
                    final double lllllllllllllIllIIlllIIlIIIIlIll;
                    switch (((String)(lllllllllllllIllIIlllIIlIIIIlIll = (double)lllllllllllllIllIIlllIIlIIIlIIlI.mode.toUpperCase())).hashCode()) {
                        case -1846317855: {
                            if (!((String)lllllllllllllIllIIlllIIlIIIIlIll).equals("SLIDER")) {
                                continue;
                            }
                            lllllllllllllIllIIlllIIlIIIlIIlI.setValDouble(lllllllllllllIllIIlllIIlIIIlIIll.get(lllllllllllllIllIIlllIIlIIIlIIlI.getName()).getAsDouble());
                            continue;
                        }
                        case 64089320: {
                            if (!((String)lllllllllllllIllIIlllIIlIIIIlIll).equals("CHECK")) {
                                continue;
                            }
                            lllllllllllllIllIIlllIIlIIIlIIlI.setValBoolean(lllllllllllllIllIIlllIIlIIIlIIll.get(lllllllllllllIllIIlllIIlIIIlIIlI.getName()).getAsBoolean());
                            continue;
                        }
                        case 64305518: {
                            if (!((String)lllllllllllllIllIIlllIIlIIIIlIll).equals("COMBO")) {
                                continue;
                            }
                            lllllllllllllIllIIlllIIlIIIlIIlI.setValString(lllllllllllllIllIIlllIIlIIIlIIll.get(lllllllllllllIllIIlllIIlIIIlIIlI.getName()).getAsString());
                            continue;
                        }
                        default: {
                            continue;
                        }
                    }
                }
            }
        }
    }
    
    public Translate getTranslate() {
        return this.translate;
    }
    
    public void onEnable() {
        EventManager.register(this);
    }
    
    public Module(final String lllllllllllllIllIIlllIIlIllllIIl, final Category lllllllllllllIllIIlllIIlIllllIll) {
        this.translate = new Translate(0.0f, 0.0f);
        this.name = lllllllllllllIllIIlllIIlIllllIIl;
        this.key = -1;
        this.category = lllllllllllllIllIIlllIIlIllllIll;
        this.toggled = false;
        this.setup();
    }
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public void setCategory(final Category lllllllllllllIllIIlllIIlIlIlIIll) {
        this.category = lllllllllllllIllIIlllIIlIlIlIIll;
    }
    
    public void setToggled(final boolean lllllllllllllIllIIlllIIlIIlIIIII) {
        if (this.toggled != lllllllllllllIllIIlllIIlIIlIIIII) {
            this.toggled = lllllllllllllIllIIlllIIlIIlIIIII;
            this.onToggle();
            if (this.toggled) {
                if (Module.mc.player != null) {
                    Module.mc.player.playSound(SoundEvents.ENTITY_LIGHTNING_IMPACT, 0.5f, 1.0f);
                }
                this.onEnable();
            }
            else {
                if (Module.mc.player != null) {
                    Module.mc.player.playSound(SoundEvents.ENTITY_EGG_THROW, 0.5f, 1.0f);
                }
                this.onDisable();
            }
        }
    }
    
    public int getKey() {
        return this.key;
    }
    
    public boolean onSendChatMessage(final String lllllllllllllIllIIlllIIlIIllllII) {
        return true;
    }
    
    public void setKey(final int lllllllllllllIllIIlllIIlIlIllllI) {
        this.key = lllllllllllllIllIIlllIIlIlIllllI;
    }
    
    public void setModuleName(final String lllllllllllllIllIIlllIIlIlIIIIII) {
        this.moduleName = lllllllllllllIllIIlllIIlIlIIIIII;
    }
    
    public void setName(final String lllllllllllllIllIIlllIIlIllIIlll) {
        this.name = lllllllllllllIllIIlllIIlIllIIlll;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public boolean onRecieveChatMessage(final SPacketChat lllllllllllllIllIIlllIIlIIlllIlI) {
        return true;
    }
    
    @Override
    public JsonObject save() {
        final JsonObject lllllllllllllIllIIlllIIlIIlIlllI = new JsonObject();
        lllllllllllllIllIIlllIIlIIlIlllI.addProperty("toggled", Boolean.valueOf(this.isToggled()));
        lllllllllllllIllIIlllIIlIIlIlllI.addProperty("key", (Number)this.getKey());
        final List<Setting> lllllllllllllIllIIlllIIlIIlIllIl = Main.settingsManager.getSettingsByMod(this);
        if (lllllllllllllIllIIlllIIlIIlIllIl != null && !lllllllllllllIllIIlllIIlIIlIllIl.isEmpty()) {
            final JsonObject lllllllllllllIllIIlllIIlIIlIllII = new JsonObject();
            for (final Setting lllllllllllllIllIIlllIIlIIlIlIll : lllllllllllllIllIIlllIIlIIlIllIl) {
                final int lllllllllllllIllIIlllIIlIIlIIlII;
                switch (((String)(lllllllllllllIllIIlllIIlIIlIIlII = (int)lllllllllllllIllIIlllIIlIIlIlIll.mode.toUpperCase())).hashCode()) {
                    case -1846317855: {
                        if (!((String)lllllllllllllIllIIlllIIlIIlIIlII).equals("SLIDER")) {
                            continue;
                        }
                        lllllllllllllIllIIlllIIlIIlIllII.addProperty(lllllllllllllIllIIlllIIlIIlIlIll.getName(), (Number)lllllllllllllIllIIlllIIlIIlIlIll.getValDouble());
                        continue;
                    }
                    case 64089320: {
                        if (!((String)lllllllllllllIllIIlllIIlIIlIIlII).equals("CHECK")) {
                            continue;
                        }
                        lllllllllllllIllIIlllIIlIIlIllII.addProperty(lllllllllllllIllIIlllIIlIIlIlIll.getName(), Boolean.valueOf(lllllllllllllIllIIlllIIlIIlIlIll.getValBoolean()));
                        continue;
                    }
                    case 64305518: {
                        if (!((String)lllllllllllllIllIIlllIIlIIlIIlII).equals("COMBO")) {
                            continue;
                        }
                        lllllllllllllIllIIlllIIlIIlIllII.addProperty(lllllllllllllIllIIlllIIlIIlIlIll.getName(), lllllllllllllIllIIlllIIlIIlIlIll.getValString());
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            lllllllllllllIllIIlllIIlIIlIlllI.add("Properties", (JsonElement)lllllllllllllIllIIlllIIlIIlIllII);
        }
        return lllllllllllllIllIIlllIIlIIlIlllI;
    }
    
    public void onToggle() {
    }
    
    public void onDisable() {
        EventManager.unregister(this);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getModuleName() {
        return (this.moduleName == null) ? this.name : this.moduleName;
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        this.onToggle();
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
}
