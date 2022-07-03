package net.minecraft.util.text;

import java.util.function.*;

public class TextComponentKeybind extends TextComponentBase
{
    private final /* synthetic */ String field_193638_c;
    public static /* synthetic */ Function<String, Supplier<String>> field_193637_b;
    private /* synthetic */ Supplier<String> field_193639_d;
    
    @Override
    public String getUnformattedComponentText() {
        if (this.field_193639_d == null) {
            this.field_193639_d = TextComponentKeybind.field_193637_b.apply(this.field_193638_c);
        }
        return this.field_193639_d.get();
    }
    
    public TextComponentKeybind(final String llllllllllllllIIIlIIIllIIlIIIlIl) {
        this.field_193638_c = llllllllllllllIIIlIIIllIIlIIIlIl;
    }
    
    @Override
    public TextComponentKeybind createCopy() {
        final TextComponentKeybind llllllllllllllIIIlIIIllIIIlllIlI = new TextComponentKeybind(this.field_193638_c);
        llllllllllllllIIIlIIIllIIIlllIlI.setStyle(this.getStyle().createShallowCopy());
        for (final ITextComponent llllllllllllllIIIlIIIllIIIlllIIl : this.getSiblings()) {
            llllllllllllllIIIlIIIllIIIlllIlI.appendSibling(llllllllllllllIIIlIIIllIIIlllIIl.createCopy());
        }
        return llllllllllllllIIIlIIIllIIIlllIlI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("KeybindComponent{keybind='").append(this.field_193638_c).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getStyle()).append('}'));
    }
    
    static {
        TextComponentKeybind.field_193637_b = (llllllllllllllIIIlIIIllIIIlIIIlI -> () -> llllllllllllllIIIlIIIllIIIlIIIlI);
    }
    
    public String func_193633_h() {
        return this.field_193638_c;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIlIIIllIIIlIllIl) {
        if (this == llllllllllllllIIIlIIIllIIIlIllIl) {
            return true;
        }
        if (!(llllllllllllllIIIlIIIllIIIlIllIl instanceof TextComponentKeybind)) {
            return false;
        }
        final TextComponentKeybind llllllllllllllIIIlIIIllIIIlIllll = (TextComponentKeybind)llllllllllllllIIIlIIIllIIIlIllIl;
        return this.field_193638_c.equals(llllllllllllllIIIlIIIllIIIlIllll.field_193638_c) && super.equals(llllllllllllllIIIlIIIllIIIlIllIl);
    }
}
