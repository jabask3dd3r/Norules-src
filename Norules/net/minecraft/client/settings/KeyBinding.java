package net.minecraft.client.settings;

import java.util.*;
import net.minecraft.util.*;
import java.util.function.*;
import com.google.common.collect.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;

public class KeyBinding implements Comparable<KeyBinding>
{
    private static final /* synthetic */ Map<String, KeyBinding> KEYBIND_ARRAY;
    private static final /* synthetic */ Map<String, Integer> field_193627_d;
    private static final /* synthetic */ Set<String> KEYBIND_SET;
    private final /* synthetic */ String keyDescription;
    private /* synthetic */ int keyCode;
    private final /* synthetic */ int keyCodeDefault;
    private /* synthetic */ int pressTime;
    private final /* synthetic */ String keyCategory;
    private static final /* synthetic */ IntHashMap<KeyBinding> HASH;
    public /* synthetic */ boolean pressed;
    
    public static void resetKeyBindingArrayAndHash() {
        KeyBinding.HASH.clearMap();
        for (final KeyBinding llllllllllllllIlIIlIIlIlIllIIlll : KeyBinding.KEYBIND_ARRAY.values()) {
            KeyBinding.HASH.addKey(llllllllllllllIlIIlIIlIlIllIIlll.keyCode, llllllllllllllIlIIlIIlIlIllIIlll);
        }
    }
    
    public boolean isPressed() {
        if (this.pressTime == 0) {
            return false;
        }
        --this.pressTime;
        return true;
    }
    
    public String getKeyCategory() {
        return this.keyCategory;
    }
    
    public KeyBinding(final String llllllllllllllIlIIlIIlIlIlIlllll, final int llllllllllllllIlIIlIIlIlIlIllllI, final String llllllllllllllIlIIlIIlIlIlIllIIl) {
        this.keyDescription = llllllllllllllIlIIlIIlIlIlIlllll;
        this.keyCode = llllllllllllllIlIIlIIlIlIlIllllI;
        this.keyCodeDefault = llllllllllllllIlIIlIIlIlIlIllllI;
        this.keyCategory = llllllllllllllIlIIlIIlIlIlIllIIl;
        KeyBinding.KEYBIND_ARRAY.put(llllllllllllllIlIIlIIlIlIlIlllll, this);
        KeyBinding.HASH.addKey(llllllllllllllIlIIlIIlIlIlIllllI, this);
        KeyBinding.KEYBIND_SET.add(llllllllllllllIlIIlIIlIlIlIllIIl);
    }
    
    public static Supplier<String> func_193626_b(final String llllllllllllllIlIIlIIlIlIIllIIll) {
        final KeyBinding llllllllllllllIlIIlIIlIlIIllIlII = KeyBinding.KEYBIND_ARRAY.get(llllllllllllllIlIIlIIlIlIIllIIll);
        return (llllllllllllllIlIIlIIlIlIIllIlII == null) ? (() -> llllllllllllllIlIIlIIlIlIIllIIll) : (() -> GameSettings.getKeyDisplayString(llllllllllllllIlIIlIIlIlIIllIlII.getKeyCode()));
    }
    
    public static void setKeyBindState(final int llllllllllllllIlIIlIIlIlIllllIII, final boolean llllllllllllllIlIIlIIlIlIlllIlll) {
        if (llllllllllllllIlIIlIIlIlIllllIII != 0) {
            final KeyBinding llllllllllllllIlIIlIIlIlIllllIIl = KeyBinding.HASH.lookup(llllllllllllllIlIIlIIlIlIllllIII);
            if (llllllllllllllIlIIlIIlIlIllllIIl != null) {
                llllllllllllllIlIIlIIlIlIllllIIl.pressed = llllllllllllllIlIIlIIlIlIlllIlll;
            }
        }
    }
    
    public int getKeyCodeDefault() {
        return this.keyCodeDefault;
    }
    
    static {
        KEYBIND_ARRAY = Maps.newHashMap();
        HASH = new IntHashMap<KeyBinding>();
        KEYBIND_SET = Sets.newHashSet();
        (field_193627_d = Maps.newHashMap()).put("key.categories.movement", 1);
        KeyBinding.field_193627_d.put("key.categories.gameplay", 2);
        KeyBinding.field_193627_d.put("key.categories.inventory", 3);
        KeyBinding.field_193627_d.put("key.categories.creative", 4);
        KeyBinding.field_193627_d.put("key.categories.multiplayer", 5);
        KeyBinding.field_193627_d.put("key.categories.ui", 6);
        KeyBinding.field_193627_d.put("key.categories.misc", 7);
    }
    
    public static void updateKeyBindState() {
        for (final KeyBinding llllllllllllllIlIIlIIlIlIlllIIlI : KeyBinding.KEYBIND_ARRAY.values()) {
            try {
                setKeyBindState(llllllllllllllIlIIlIIlIlIlllIIlI.keyCode, llllllllllllllIlIIlIIlIlIlllIIlI.keyCode < 256 && Keyboard.isKeyDown(llllllllllllllIlIIlIIlIlIlllIIlI.keyCode));
            }
            catch (IndexOutOfBoundsException ex) {}
        }
    }
    
    public int getKeyCode() {
        return this.keyCode;
    }
    
    public String getKeyDescription() {
        return this.keyDescription;
    }
    
    public static void onTick(final int llllllllllllllIlIIlIIlIllIIIIIII) {
        if (llllllllllllllIlIIlIIlIllIIIIIII != 0) {
            final KeyBinding llllllllllllllIlIIlIIlIllIIIIIIl = KeyBinding.HASH.lookup(llllllllllllllIlIIlIIlIllIIIIIII);
            if (llllllllllllllIlIIlIIlIllIIIIIIl != null) {
                final KeyBinding keyBinding = llllllllllllllIlIIlIIlIllIIIIIIl;
                ++keyBinding.pressTime;
            }
        }
    }
    
    public static Set<String> getKeybinds() {
        return KeyBinding.KEYBIND_SET;
    }
    
    public static void unPressAllKeys() {
        for (final KeyBinding llllllllllllllIlIIlIIlIlIllIllII : KeyBinding.KEYBIND_ARRAY.values()) {
            llllllllllllllIlIIlIIlIlIllIllII.unpressKey();
        }
    }
    
    public boolean isKeyDown() {
        return this.pressed;
    }
    
    public void setKeyCode(final int llllllllllllllIlIIlIIlIlIlIIIIII) {
        this.keyCode = llllllllllllllIlIIlIIlIlIlIIIIII;
    }
    
    @Override
    public int compareTo(final KeyBinding llllllllllllllIlIIlIIlIlIIlllIlI) {
        return this.keyCategory.equals(llllllllllllllIlIIlIIlIlIIlllIlI.keyCategory) ? I18n.format(this.keyDescription, new Object[0]).compareTo(I18n.format(llllllllllllllIlIIlIIlIlIIlllIlI.keyDescription, new Object[0])) : KeyBinding.field_193627_d.get(this.keyCategory).compareTo(KeyBinding.field_193627_d.get(llllllllllllllIlIIlIIlIlIIlllIlI.keyCategory));
    }
    
    private void unpressKey() {
        this.pressTime = 0;
        this.pressed = false;
    }
}
