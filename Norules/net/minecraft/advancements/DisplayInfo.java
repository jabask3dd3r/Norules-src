package net.minecraft.advancements;

import net.minecraft.util.text.*;
import javax.annotation.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import com.google.gson.*;

public class DisplayInfo
{
    private final /* synthetic */ FrameType field_192303_d;
    private final /* synthetic */ boolean field_193226_f;
    private final /* synthetic */ ResourceLocation field_192302_c;
    private /* synthetic */ float field_192304_e;
    private final /* synthetic */ ITextComponent field_192300_a;
    private final /* synthetic */ boolean field_193227_g;
    private final /* synthetic */ ITextComponent field_193225_b;
    private final /* synthetic */ ItemStack field_192301_b;
    private /* synthetic */ float field_192305_f;
    private final /* synthetic */ boolean field_193228_h;
    
    public void func_192292_a(final float llllllllllllllIIIIIIlIIllIllIlll, final float llllllllllllllIIIIIIlIIllIlllIIl) {
        this.field_192304_e = llllllllllllllIIIIIIlIIllIllIlll;
        this.field_192305_f = llllllllllllllIIIIIIlIIllIlllIIl;
    }
    
    public float func_192299_e() {
        return this.field_192304_e;
    }
    
    @Nullable
    public ResourceLocation func_192293_c() {
        return this.field_192302_c;
    }
    
    public boolean func_193223_h() {
        return this.field_193226_f;
    }
    
    public boolean func_193224_j() {
        return this.field_193228_h;
    }
    
    public static DisplayInfo func_192295_b(final PacketBuffer llllllllllllllIIIIIIlIIlIlIlllIl) throws IOException {
        final ITextComponent llllllllllllllIIIIIIlIIlIlIlllII = llllllllllllllIIIIIIlIIlIlIlllIl.readTextComponent();
        final ITextComponent llllllllllllllIIIIIIlIIlIlIllIll = llllllllllllllIIIIIIlIIlIlIlllIl.readTextComponent();
        final ItemStack llllllllllllllIIIIIIlIIlIlIllIlI = llllllllllllllIIIIIIlIIlIlIlllIl.readItemStackFromBuffer();
        final FrameType llllllllllllllIIIIIIlIIlIlIllIIl = llllllllllllllIIIIIIlIIlIlIlllIl.readEnumValue(FrameType.class);
        final int llllllllllllllIIIIIIlIIlIlIllIII = llllllllllllllIIIIIIlIIlIlIlllIl.readInt();
        final ResourceLocation llllllllllllllIIIIIIlIIlIlIlIlll = ((llllllllllllllIIIIIIlIIlIlIllIII & 0x1) != 0x0) ? llllllllllllllIIIIIIlIIlIlIlllIl.func_192575_l() : null;
        final boolean llllllllllllllIIIIIIlIIlIlIlIllI = (llllllllllllllIIIIIIlIIlIlIllIII & 0x2) != 0x0;
        final boolean llllllllllllllIIIIIIlIIlIlIlIlIl = (llllllllllllllIIIIIIlIIlIlIllIII & 0x4) != 0x0;
        final DisplayInfo llllllllllllllIIIIIIlIIlIlIlIlII = new DisplayInfo(llllllllllllllIIIIIIlIIlIlIllIlI, llllllllllllllIIIIIIlIIlIlIlllII, llllllllllllllIIIIIIlIIlIlIllIll, llllllllllllllIIIIIIlIIlIlIlIlll, llllllllllllllIIIIIIlIIlIlIllIIl, llllllllllllllIIIIIIlIIlIlIlIllI, false, llllllllllllllIIIIIIlIIlIlIlIlIl);
        llllllllllllllIIIIIIlIIlIlIlIlII.func_192292_a(llllllllllllllIIIIIIlIIlIlIlllIl.readFloat(), llllllllllllllIIIIIIlIIlIlIlllIl.readFloat());
        return llllllllllllllIIIIIIlIIlIlIlIlII;
    }
    
    public void func_192290_a(final PacketBuffer llllllllllllllIIIIIIlIIlIllIlIIl) {
        llllllllllllllIIIIIIlIIlIllIlIIl.writeTextComponent(this.field_192300_a);
        llllllllllllllIIIIIIlIIlIllIlIIl.writeTextComponent(this.field_193225_b);
        llllllllllllllIIIIIIlIIlIllIlIIl.writeItemStackToBuffer(this.field_192301_b);
        llllllllllllllIIIIIIlIIlIllIlIIl.writeEnumValue(this.field_192303_d);
        int llllllllllllllIIIIIIlIIlIllIlIll = 0;
        if (this.field_192302_c != null) {
            llllllllllllllIIIIIIlIIlIllIlIll |= 0x1;
        }
        if (this.field_193226_f) {
            llllllllllllllIIIIIIlIIlIllIlIll |= 0x2;
        }
        if (this.field_193228_h) {
            llllllllllllllIIIIIIlIIlIllIlIll |= 0x4;
        }
        llllllllllllllIIIIIIlIIlIllIlIIl.writeInt(llllllllllllllIIIIIIlIIlIllIlIll);
        if (this.field_192302_c != null) {
            llllllllllllllIIIIIIlIIlIllIlIIl.func_192572_a(this.field_192302_c);
        }
        llllllllllllllIIIIIIlIIlIllIlIIl.writeFloat(this.field_192304_e);
        llllllllllllllIIIIIIlIIlIllIlIIl.writeFloat(this.field_192305_f);
    }
    
    public ITextComponent func_192297_a() {
        return this.field_192300_a;
    }
    
    private static ItemStack func_193221_a(final JsonObject llllllllllllllIIIIIIlIIlIlllIIll) {
        if (!llllllllllllllIIIIIIlIIlIlllIIll.has("item")) {
            throw new JsonSyntaxException("Unsupported icon type, currently only items are supported (add 'item' key)");
        }
        final Item llllllllllllllIIIIIIlIIlIlllIlIl = JsonUtils.getItem(llllllllllllllIIIIIIlIIlIlllIIll, "item");
        final int llllllllllllllIIIIIIlIIlIlllIlII = JsonUtils.getInt(llllllllllllllIIIIIIlIIlIlllIIll, "data", 0);
        return new ItemStack(llllllllllllllIIIIIIlIIlIlllIlIl, 1, llllllllllllllIIIIIIlIIlIlllIlII);
    }
    
    public FrameType func_192291_d() {
        return this.field_192303_d;
    }
    
    public ITextComponent func_193222_b() {
        return this.field_193225_b;
    }
    
    public boolean func_193220_i() {
        return this.field_193227_g;
    }
    
    public DisplayInfo(final ItemStack llllllllllllllIIIIIIlIIlllIIIllI, final ITextComponent llllllllllllllIIIIIIlIIlllIIIlIl, final ITextComponent llllllllllllllIIIIIIlIIlllIIIlII, @Nullable final ResourceLocation llllllllllllllIIIIIIlIIlllIIllII, final FrameType llllllllllllllIIIIIIlIIlllIIlIll, final boolean llllllllllllllIIIIIIlIIlllIIIIIl, final boolean llllllllllllllIIIIIIlIIlllIIIIII, final boolean llllllllllllllIIIIIIlIIlllIIlIII) {
        this.field_192300_a = llllllllllllllIIIIIIlIIlllIIIlIl;
        this.field_193225_b = llllllllllllllIIIIIIlIIlllIIIlII;
        this.field_192301_b = llllllllllllllIIIIIIlIIlllIIIllI;
        this.field_192302_c = llllllllllllllIIIIIIlIIlllIIllII;
        this.field_192303_d = llllllllllllllIIIIIIlIIlllIIlIll;
        this.field_193226_f = llllllllllllllIIIIIIlIIlllIIIIIl;
        this.field_193227_g = llllllllllllllIIIIIIlIIlllIIIIII;
        this.field_193228_h = llllllllllllllIIIIIIlIIlllIIlIII;
    }
    
    public static DisplayInfo func_192294_a(final JsonObject llllllllllllllIIIIIIlIIllIIIIIll, final JsonDeserializationContext llllllllllllllIIIIIIlIIllIIIIIlI) {
        final ITextComponent llllllllllllllIIIIIIlIIllIIIlIll = JsonUtils.deserializeClass(llllllllllllllIIIIIIlIIllIIIIIll, "title", llllllllllllllIIIIIIlIIllIIIIIlI, (Class<? extends ITextComponent>)ITextComponent.class);
        final ITextComponent llllllllllllllIIIIIIlIIllIIIlIlI = JsonUtils.deserializeClass(llllllllllllllIIIIIIlIIllIIIIIll, "description", llllllllllllllIIIIIIlIIllIIIIIlI, (Class<? extends ITextComponent>)ITextComponent.class);
        if (llllllllllllllIIIIIIlIIllIIIlIll != null && llllllllllllllIIIIIIlIIllIIIlIlI != null) {
            final ItemStack llllllllllllllIIIIIIlIIllIIIlIIl = func_193221_a(JsonUtils.getJsonObject(llllllllllllllIIIIIIlIIllIIIIIll, "icon"));
            final ResourceLocation llllllllllllllIIIIIIlIIllIIIlIII = llllllllllllllIIIIIIlIIllIIIIIll.has("background") ? new ResourceLocation(JsonUtils.getString(llllllllllllllIIIIIIlIIllIIIIIll, "background")) : null;
            final FrameType llllllllllllllIIIIIIlIIllIIIIlll = llllllllllllllIIIIIIlIIllIIIIIll.has("frame") ? FrameType.func_192308_a(JsonUtils.getString(llllllllllllllIIIIIIlIIllIIIIIll, "frame")) : FrameType.TASK;
            final boolean llllllllllllllIIIIIIlIIllIIIIllI = JsonUtils.getBoolean(llllllllllllllIIIIIIlIIllIIIIIll, "show_toast", true);
            final boolean llllllllllllllIIIIIIlIIllIIIIlIl = JsonUtils.getBoolean(llllllllllllllIIIIIIlIIllIIIIIll, "announce_to_chat", true);
            final boolean llllllllllllllIIIIIIlIIllIIIIlII = JsonUtils.getBoolean(llllllllllllllIIIIIIlIIllIIIIIll, "hidden", false);
            return new DisplayInfo(llllllllllllllIIIIIIlIIllIIIlIIl, llllllllllllllIIIIIIlIIllIIIlIll, llllllllllllllIIIIIIlIIllIIIlIlI, llllllllllllllIIIIIIlIIllIIIlIII, llllllllllllllIIIIIIlIIllIIIIlll, llllllllllllllIIIIIIlIIllIIIIllI, llllllllllllllIIIIIIlIIllIIIIlIl, llllllllllllllIIIIIIlIIllIIIIlII);
        }
        throw new JsonSyntaxException("Both title and description must be set");
    }
    
    public ItemStack func_192298_b() {
        return this.field_192301_b;
    }
    
    public float func_192296_f() {
        return this.field_192305_f;
    }
}
