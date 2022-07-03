package net.minecraft.util.text;

import net.minecraft.util.text.event.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class Style
{
    private /* synthetic */ Boolean strikethrough;
    private /* synthetic */ ClickEvent clickEvent;
    private static final /* synthetic */ Style ROOT;
    private /* synthetic */ HoverEvent hoverEvent;
    private /* synthetic */ Boolean italic;
    private /* synthetic */ Boolean underlined;
    private /* synthetic */ Style parentStyle;
    private /* synthetic */ String insertion;
    private /* synthetic */ Boolean obfuscated;
    private /* synthetic */ Boolean bold;
    private /* synthetic */ TextFormatting color;
    
    static /* synthetic */ void access$0(final Style llllllllllllllIlIIlllIllllIIIlIl, final Boolean llllllllllllllIlIIlllIllllIIIlII) {
        llllllllllllllIlIIlllIllllIIIlIl.bold = llllllllllllllIlIIlllIllllIIIlII;
    }
    
    @Nullable
    public TextFormatting getColor() {
        return (this.color == null) ? this.getParent().getColor() : this.color;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIIlllIlllllIIIlI = this.color.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.bold.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.italic.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.underlined.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.strikethrough.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.obfuscated.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.clickEvent.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.hoverEvent.hashCode();
        llllllllllllllIlIIlllIlllllIIIlI = 31 * llllllllllllllIlIIlllIlllllIIIlI + this.insertion.hashCode();
        return llllllllllllllIlIIlllIlllllIIIlI;
    }
    
    static /* synthetic */ void access$1(final Style llllllllllllllIlIIlllIlllIlllIll, final Boolean llllllllllllllIlIIlllIlllIlllIIl) {
        llllllllllllllIlIIlllIlllIlllIll.italic = llllllllllllllIlIIlllIlllIlllIIl;
    }
    
    @Nullable
    public String getInsertion() {
        return (this.insertion == null) ? this.getParent().getInsertion() : this.insertion;
    }
    
    @Nullable
    public ClickEvent getClickEvent() {
        return (this.clickEvent == null) ? this.getParent().getClickEvent() : this.clickEvent;
    }
    
    public Style setInsertion(final String llllllllllllllIlIIllllIIIIIIIlll) {
        this.insertion = llllllllllllllIlIIllllIIIIIIIlll;
        return this;
    }
    
    public boolean getStrikethrough() {
        return (this.strikethrough == null) ? this.getParent().getStrikethrough() : this.strikethrough;
    }
    
    public Style setUnderlined(final Boolean llllllllllllllIlIIllllIIIIIlllIl) {
        this.underlined = llllllllllllllIlIIllllIIIIIlllIl;
        return this;
    }
    
    public Style setClickEvent(final ClickEvent llllllllllllllIlIIllllIIIIIlIIIl) {
        this.clickEvent = llllllllllllllIlIIllllIIIIIlIIIl;
        return this;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Style{hasParent=").append(this.parentStyle != null).append(", color=").append(this.color).append(", bold=").append(this.bold).append(", italic=").append(this.italic).append(", underlined=").append(this.underlined).append(", obfuscated=").append(this.obfuscated).append(", clickEvent=").append(this.getClickEvent()).append(", hoverEvent=").append(this.getHoverEvent()).append(", insertion=").append(this.getInsertion()).append('}'));
    }
    
    public boolean getItalic() {
        return (this.italic == null) ? this.getParent().getItalic() : this.italic;
    }
    
    static /* synthetic */ void access$7(final Style llllllllllllllIlIIlllIlllIIlllIl, final ClickEvent llllllllllllllIlIIlllIlllIIlllII) {
        llllllllllllllIlIIlllIlllIIlllIl.clickEvent = llllllllllllllIlIIlllIlllIIlllII;
    }
    
    static /* synthetic */ void access$5(final Style llllllllllllllIlIIlllIlllIlIIlIl, final TextFormatting llllllllllllllIlIIlllIlllIlIIlII) {
        llllllllllllllIlIIlllIlllIlIIlIl.color = llllllllllllllIlIIlllIlllIlIIlII;
    }
    
    public Style createDeepCopy() {
        final Style llllllllllllllIlIIlllIllllIIlllI = new Style();
        llllllllllllllIlIIlllIllllIIlllI.setBold(this.getBold());
        llllllllllllllIlIIlllIllllIIlllI.setItalic(this.getItalic());
        llllllllllllllIlIIlllIllllIIlllI.setStrikethrough(this.getStrikethrough());
        llllllllllllllIlIIlllIllllIIlllI.setUnderlined(this.getUnderlined());
        llllllllllllllIlIIlllIllllIIlllI.setObfuscated(this.getObfuscated());
        llllllllllllllIlIIlllIllllIIlllI.setColor(this.getColor());
        llllllllllllllIlIIlllIllllIIlllI.setClickEvent(this.getClickEvent());
        llllllllllllllIlIIlllIllllIIlllI.setHoverEvent(this.getHoverEvent());
        llllllllllllllIlIIlllIllllIIlllI.setInsertion(this.getInsertion());
        return llllllllllllllIlIIlllIllllIIlllI;
    }
    
    static /* synthetic */ void access$6(final Style llllllllllllllIlIIlllIlllIlIIIIl, final String llllllllllllllIlIIlllIlllIlIIIII) {
        llllllllllllllIlIIlllIlllIlIIIIl.insertion = llllllllllllllIlIIlllIlllIlIIIII;
    }
    
    public Style setStrikethrough(final Boolean llllllllllllllIlIIllllIIIIlIIIll) {
        this.strikethrough = llllllllllllllIlIIllllIIIIlIIIll;
        return this;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIlllIlllllIlIII) {
        if (this == llllllllllllllIlIIlllIlllllIlIII) {
            return true;
        }
        if (!(llllllllllllllIlIIlllIlllllIlIII instanceof Style)) {
            return false;
        }
        final Style llllllllllllllIlIIlllIlllllIlIlI = (Style)llllllllllllllIlIIlllIlllllIlIII;
        if (this.getBold() == llllllllllllllIlIIlllIlllllIlIlI.getBold() && this.getColor() == llllllllllllllIlIIlllIlllllIlIlI.getColor() && this.getItalic() == llllllllllllllIlIIlllIlllllIlIlI.getItalic() && this.getObfuscated() == llllllllllllllIlIIlllIlllllIlIlI.getObfuscated() && this.getStrikethrough() == llllllllllllllIlIIlllIlllllIlIlI.getStrikethrough() && this.getUnderlined() == llllllllllllllIlIIlllIlllllIlIlI.getUnderlined()) {
            if (this.getClickEvent() != null) {
                if (!this.getClickEvent().equals(llllllllllllllIlIIlllIlllllIlIlI.getClickEvent())) {
                    return false;
                }
            }
            else if (llllllllllllllIlIIlllIlllllIlIlI.getClickEvent() != null) {
                return false;
            }
            if (this.getHoverEvent() != null) {
                if (!this.getHoverEvent().equals(llllllllllllllIlIIlllIlllllIlIlI.getHoverEvent())) {
                    return false;
                }
            }
            else if (llllllllllllllIlIIlllIlllllIlIlI.getHoverEvent() != null) {
                return false;
            }
            if (this.getInsertion() != null) {
                if (!this.getInsertion().equals(llllllllllllllIlIIlllIlllllIlIlI.getInsertion())) {
                    return false;
                }
            }
            else if (llllllllllllllIlIIlllIlllllIlIlI.getInsertion() != null) {
                return false;
            }
            final boolean llllllllllllllIlIIlllIlllllIlIll = true;
            return llllllllllllllIlIIlllIlllllIlIll;
        }
        final boolean llllllllllllllIlIIlllIlllllIllII = false;
        return llllllllllllllIlIIlllIlllllIllII;
    }
    
    public Style setBold(final Boolean llllllllllllllIlIIllllIIIIlIllll) {
        this.bold = llllllllllllllIlIIllllIIIIlIllll;
        return this;
    }
    
    public boolean getObfuscated() {
        return (this.obfuscated == null) ? this.getParent().getObfuscated() : this.obfuscated;
    }
    
    static /* synthetic */ void access$3(final Style llllllllllllllIlIIlllIlllIlIllIl, final Boolean llllllllllllllIlIIlllIlllIlIllII) {
        llllllllllllllIlIIlllIlllIlIllIl.strikethrough = llllllllllllllIlIIlllIlllIlIllII;
    }
    
    public Style setParentStyle(final Style llllllllllllllIlIIlllIllllllllll) {
        this.parentStyle = llllllllllllllIlIIlllIllllllllll;
        return this;
    }
    
    public Style setItalic(final Boolean llllllllllllllIlIIllllIIIIlIlIIl) {
        this.italic = llllllllllllllIlIIllllIIIIlIlIIl;
        return this;
    }
    
    public boolean getBold() {
        return (this.bold == null) ? this.getParent().getBold() : this.bold;
    }
    
    static {
        ROOT = new Style() {
            @Override
            public Style createDeepCopy() {
                return this;
            }
            
            @Override
            public Style setColor(final TextFormatting lllllllllllllIIIIlllIIlIIlIIIIll) {
                throw new UnsupportedOperationException();
            }
            
            @Nullable
            @Override
            public String getInsertion() {
                return null;
            }
            
            @Override
            public String getFormattingCode() {
                return "";
            }
            
            @Override
            public Style setParentStyle(final Style lllllllllllllIIIIlllIIlIIIllIIll) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Style createShallowCopy() {
                return this;
            }
            
            @Override
            public boolean getObfuscated() {
                return false;
            }
            
            @Override
            public boolean getBold() {
                return false;
            }
            
            @Override
            public Style setBold(final Boolean lllllllllllllIIIIlllIIlIIlIIIIIl) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Style setUnderlined(final Boolean lllllllllllllIIIIlllIIlIIIlllIll) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean getStrikethrough() {
                return false;
            }
            
            @Override
            public boolean getItalic() {
                return false;
            }
            
            @Override
            public Style setClickEvent(final ClickEvent lllllllllllllIIIIlllIIlIIIllIlll) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public String toString() {
                return "Style.ROOT";
            }
            
            @Nullable
            @Override
            public ClickEvent getClickEvent() {
                return null;
            }
            
            @Override
            public Style setObfuscated(final Boolean lllllllllllllIIIIlllIIlIIIlllIIl) {
                throw new UnsupportedOperationException();
            }
            
            @Nullable
            @Override
            public TextFormatting getColor() {
                return null;
            }
            
            @Override
            public Style setHoverEvent(final HoverEvent lllllllllllllIIIIlllIIlIIIllIlIl) {
                throw new UnsupportedOperationException();
            }
            
            @Nullable
            @Override
            public HoverEvent getHoverEvent() {
                return null;
            }
            
            @Override
            public Style setItalic(final Boolean lllllllllllllIIIIlllIIlIIIllllll) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Style setStrikethrough(final Boolean lllllllllllllIIIIlllIIlIIIllllIl) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean getUnderlined() {
                return false;
            }
        };
    }
    
    public Style createShallowCopy() {
        final Style llllllllllllllIlIIlllIllllIlllII = new Style();
        llllllllllllllIlIIlllIllllIlllII.bold = this.bold;
        llllllllllllllIlIIlllIllllIlllII.italic = this.italic;
        llllllllllllllIlIIlllIllllIlllII.strikethrough = this.strikethrough;
        llllllllllllllIlIIlllIllllIlllII.underlined = this.underlined;
        llllllllllllllIlIIlllIllllIlllII.obfuscated = this.obfuscated;
        llllllllllllllIlIIlllIllllIlllII.color = this.color;
        llllllllllllllIlIIlllIllllIlllII.clickEvent = this.clickEvent;
        llllllllllllllIlIIlllIllllIlllII.hoverEvent = this.hoverEvent;
        llllllllllllllIlIIlllIllllIlllII.parentStyle = this.parentStyle;
        llllllllllllllIlIIlllIllllIlllII.insertion = this.insertion;
        return llllllllllllllIlIIlllIllllIlllII;
    }
    
    private Style getParent() {
        return (this.parentStyle == null) ? Style.ROOT : this.parentStyle;
    }
    
    @Nullable
    public HoverEvent getHoverEvent() {
        return (this.hoverEvent == null) ? this.getParent().getHoverEvent() : this.hoverEvent;
    }
    
    static /* synthetic */ void access$4(final Style llllllllllllllIlIIlllIlllIlIlIIl, final Boolean llllllllllllllIlIIlllIlllIlIlIII) {
        llllllllllllllIlIIlllIlllIlIlIIl.obfuscated = llllllllllllllIlIIlllIlllIlIlIII;
    }
    
    public Style setHoverEvent(final HoverEvent llllllllllllllIlIIllllIIIIIIlIll) {
        this.hoverEvent = llllllllllllllIlIIllllIIIIIIlIll;
        return this;
    }
    
    static /* synthetic */ void access$2(final Style llllllllllllllIlIIlllIlllIllIIIl, final Boolean llllllllllllllIlIIlllIlllIllIIII) {
        llllllllllllllIlIIlllIlllIllIIIl.underlined = llllllllllllllIlIIlllIlllIllIIII;
    }
    
    public Style setColor(final TextFormatting llllllllllllllIlIIllllIIIIllIlll) {
        this.color = llllllllllllllIlIIllllIIIIllIlll;
        return this;
    }
    
    public boolean isEmpty() {
        return this.bold == null && this.italic == null && this.strikethrough == null && this.underlined == null && this.obfuscated == null && this.color == null && this.clickEvent == null && this.hoverEvent == null && this.insertion == null;
    }
    
    public String getFormattingCode() {
        if (this.isEmpty()) {
            return (this.parentStyle != null) ? this.parentStyle.getFormattingCode() : "";
        }
        final StringBuilder llllllllllllllIlIIlllIlllllllIll = new StringBuilder();
        if (this.getColor() != null) {
            llllllllllllllIlIIlllIlllllllIll.append(this.getColor());
        }
        if (this.getBold()) {
            llllllllllllllIlIIlllIlllllllIll.append(TextFormatting.BOLD);
        }
        if (this.getItalic()) {
            llllllllllllllIlIIlllIlllllllIll.append(TextFormatting.ITALIC);
        }
        if (this.getUnderlined()) {
            llllllllllllllIlIIlllIlllllllIll.append(TextFormatting.UNDERLINE);
        }
        if (this.getObfuscated()) {
            llllllllllllllIlIIlllIlllllllIll.append(TextFormatting.OBFUSCATED);
        }
        if (this.getStrikethrough()) {
            llllllllllllllIlIIlllIlllllllIll.append(TextFormatting.STRIKETHROUGH);
        }
        return String.valueOf(llllllllllllllIlIIlllIlllllllIll);
    }
    
    public boolean getUnderlined() {
        return (this.underlined == null) ? this.getParent().getUnderlined() : this.underlined;
    }
    
    public Style setObfuscated(final Boolean llllllllllllllIlIIllllIIIIIllIIl) {
        this.obfuscated = llllllllllllllIlIIllllIIIIIllIIl;
        return this;
    }
    
    static /* synthetic */ void access$8(final Style llllllllllllllIlIIlllIlllIIllIIl, final HoverEvent llllllllllllllIlIIlllIlllIIllIII) {
        llllllllllllllIlIIlllIlllIIllIIl.hoverEvent = llllllllllllllIlIIlllIlllIIllIII;
    }
    
    public static class Serializer implements JsonDeserializer<Style>, JsonSerializer<Style>
    {
        @Nullable
        public Style deserialize(final JsonElement lllllllllllllllIlIIIIIlIllIlIIlI, final Type lllllllllllllllIlIIIIIlIllIlllll, final JsonDeserializationContext lllllllllllllllIlIIIIIlIllIlIIIl) throws JsonParseException {
            if (!lllllllllllllllIlIIIIIlIllIlIIlI.isJsonObject()) {
                return null;
            }
            final Style lllllllllllllllIlIIIIIlIllIlllIl = new Style();
            final JsonObject lllllllllllllllIlIIIIIlIllIlllII = lllllllllllllllIlIIIIIlIllIlIIlI.getAsJsonObject();
            if (lllllllllllllllIlIIIIIlIllIlllII == null) {
                return null;
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("bold")) {
                Style.access$0(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("bold").getAsBoolean());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("italic")) {
                Style.access$1(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("italic").getAsBoolean());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("underlined")) {
                Style.access$2(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("underlined").getAsBoolean());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("strikethrough")) {
                Style.access$3(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("strikethrough").getAsBoolean());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("obfuscated")) {
                Style.access$4(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("obfuscated").getAsBoolean());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("color")) {
                Style.access$5(lllllllllllllllIlIIIIIlIllIlllIl, (TextFormatting)lllllllllllllllIlIIIIIlIllIlIIIl.deserialize(lllllllllllllllIlIIIIIlIllIlllII.get("color"), (Type)TextFormatting.class));
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("insertion")) {
                Style.access$6(lllllllllllllllIlIIIIIlIllIlllIl, lllllllllllllllIlIIIIIlIllIlllII.get("insertion").getAsString());
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("clickEvent")) {
                final JsonObject lllllllllllllllIlIIIIIlIllIllIll = lllllllllllllllIlIIIIIlIllIlllII.getAsJsonObject("clickEvent");
                if (lllllllllllllllIlIIIIIlIllIllIll != null) {
                    final JsonPrimitive lllllllllllllllIlIIIIIlIllIllIlI = lllllllllllllllIlIIIIIlIllIllIll.getAsJsonPrimitive("action");
                    final ClickEvent.Action lllllllllllllllIlIIIIIlIllIllIIl = (lllllllllllllllIlIIIIIlIllIllIlI == null) ? null : ClickEvent.Action.getValueByCanonicalName(lllllllllllllllIlIIIIIlIllIllIlI.getAsString());
                    final JsonPrimitive lllllllllllllllIlIIIIIlIllIllIII = lllllllllllllllIlIIIIIlIllIllIll.getAsJsonPrimitive("value");
                    final String lllllllllllllllIlIIIIIlIllIlIlll = (lllllllllllllllIlIIIIIlIllIllIII == null) ? null : lllllllllllllllIlIIIIIlIllIllIII.getAsString();
                    if (lllllllllllllllIlIIIIIlIllIllIIl != null && lllllllllllllllIlIIIIIlIllIlIlll != null && lllllllllllllllIlIIIIIlIllIllIIl.shouldAllowInChat()) {
                        Style.access$7(lllllllllllllllIlIIIIIlIllIlllIl, new ClickEvent(lllllllllllllllIlIIIIIlIllIllIIl, lllllllllllllllIlIIIIIlIllIlIlll));
                    }
                }
            }
            if (lllllllllllllllIlIIIIIlIllIlllII.has("hoverEvent")) {
                final JsonObject lllllllllllllllIlIIIIIlIllIlIllI = lllllllllllllllIlIIIIIlIllIlllII.getAsJsonObject("hoverEvent");
                if (lllllllllllllllIlIIIIIlIllIlIllI != null) {
                    final JsonPrimitive lllllllllllllllIlIIIIIlIllIlIlIl = lllllllllllllllIlIIIIIlIllIlIllI.getAsJsonPrimitive("action");
                    final HoverEvent.Action lllllllllllllllIlIIIIIlIllIlIlII = (lllllllllllllllIlIIIIIlIllIlIlIl == null) ? null : HoverEvent.Action.getValueByCanonicalName(lllllllllllllllIlIIIIIlIllIlIlIl.getAsString());
                    final ITextComponent lllllllllllllllIlIIIIIlIllIlIIll = (ITextComponent)lllllllllllllllIlIIIIIlIllIlIIIl.deserialize(lllllllllllllllIlIIIIIlIllIlIllI.get("value"), (Type)ITextComponent.class);
                    if (lllllllllllllllIlIIIIIlIllIlIlII != null && lllllllllllllllIlIIIIIlIllIlIIll != null && lllllllllllllllIlIIIIIlIllIlIlII.shouldAllowInChat()) {
                        Style.access$8(lllllllllllllllIlIIIIIlIllIlllIl, new HoverEvent(lllllllllllllllIlIIIIIlIllIlIlII, lllllllllllllllIlIIIIIlIllIlIIll));
                    }
                }
            }
            return lllllllllllllllIlIIIIIlIllIlllIl;
        }
        
        @Nullable
        public JsonElement serialize(final Style lllllllllllllllIlIIIIIlIllIIIlII, final Type lllllllllllllllIlIIIIIlIllIIIIll, final JsonSerializationContext lllllllllllllllIlIIIIIlIllIIIIlI) {
            if (lllllllllllllllIlIIIIIlIllIIIlII.isEmpty()) {
                return null;
            }
            final JsonObject lllllllllllllllIlIIIIIlIllIIIIIl = new JsonObject();
            if (lllllllllllllllIlIIIIIlIllIIIlII.bold != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.addProperty("bold", lllllllllllllllIlIIIIIlIllIIIlII.bold);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.italic != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.addProperty("italic", lllllllllllllllIlIIIIIlIllIIIlII.italic);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.underlined != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.addProperty("underlined", lllllllllllllllIlIIIIIlIllIIIlII.underlined);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.strikethrough != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.addProperty("strikethrough", lllllllllllllllIlIIIIIlIllIIIlII.strikethrough);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.obfuscated != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.addProperty("obfuscated", lllllllllllllllIlIIIIIlIllIIIlII.obfuscated);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.color != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.add("color", lllllllllllllllIlIIIIIlIllIIIIlI.serialize((Object)lllllllllllllllIlIIIIIlIllIIIlII.color));
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.insertion != null) {
                lllllllllllllllIlIIIIIlIllIIIIIl.add("insertion", lllllllllllllllIlIIIIIlIllIIIIlI.serialize((Object)lllllllllllllllIlIIIIIlIllIIIlII.insertion));
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.clickEvent != null) {
                final JsonObject lllllllllllllllIlIIIIIlIllIIIIII = new JsonObject();
                lllllllllllllllIlIIIIIlIllIIIIII.addProperty("action", lllllllllllllllIlIIIIIlIllIIIlII.clickEvent.getAction().getCanonicalName());
                lllllllllllllllIlIIIIIlIllIIIIII.addProperty("value", lllllllllllllllIlIIIIIlIllIIIlII.clickEvent.getValue());
                lllllllllllllllIlIIIIIlIllIIIIIl.add("clickEvent", (JsonElement)lllllllllllllllIlIIIIIlIllIIIIII);
            }
            if (lllllllllllllllIlIIIIIlIllIIIlII.hoverEvent != null) {
                final JsonObject lllllllllllllllIlIIIIIlIlIllllll = new JsonObject();
                lllllllllllllllIlIIIIIlIlIllllll.addProperty("action", lllllllllllllllIlIIIIIlIllIIIlII.hoverEvent.getAction().getCanonicalName());
                lllllllllllllllIlIIIIIlIlIllllll.add("value", lllllllllllllllIlIIIIIlIllIIIIlI.serialize((Object)lllllllllllllllIlIIIIIlIllIIIlII.hoverEvent.getValue()));
                lllllllllllllllIlIIIIIlIllIIIIIl.add("hoverEvent", (JsonElement)lllllllllllllllIlIIIIIlIlIllllll);
            }
            return (JsonElement)lllllllllllllllIlIIIIIlIllIIIIIl;
        }
    }
}
