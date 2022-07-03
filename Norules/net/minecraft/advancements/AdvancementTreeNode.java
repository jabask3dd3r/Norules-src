package net.minecraft.advancements;

import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;

public class AdvancementTreeNode
{
    private /* synthetic */ AdvancementTreeNode field_192333_f;
    private /* synthetic */ float field_192336_i;
    private final /* synthetic */ List<AdvancementTreeNode> field_192332_e;
    private /* synthetic */ float field_192338_k;
    private final /* synthetic */ Advancement field_192328_a;
    private final /* synthetic */ AdvancementTreeNode field_192330_c;
    private /* synthetic */ int field_192335_h;
    private final /* synthetic */ AdvancementTreeNode field_192329_b;
    private /* synthetic */ float field_192337_j;
    private /* synthetic */ AdvancementTreeNode field_192334_g;
    private final /* synthetic */ int field_192331_d;
    private /* synthetic */ float field_192339_l;
    
    @Nullable
    private AdvancementTreeNode func_192322_a(final Advancement lllllllllllllllIllllIllllIlIlIlI, @Nullable AdvancementTreeNode lllllllllllllllIllllIllllIlIlIIl) {
        if (lllllllllllllllIllllIllllIlIlIlI.func_192068_c() != null) {
            lllllllllllllllIllllIllllIlIlIIl = new AdvancementTreeNode(lllllllllllllllIllllIllllIlIlIlI, this, lllllllllllllllIllllIllllIlIlIIl, this.field_192332_e.size() + 1, this.field_192335_h + 1);
            this.field_192332_e.add(lllllllllllllllIllllIllllIlIlIIl);
        }
        else {
            for (final Advancement lllllllllllllllIllllIllllIlIllII : lllllllllllllllIllllIllllIlIlIlI.func_192069_e()) {
                lllllllllllllllIllllIllllIlIlIIl = this.func_192322_a(lllllllllllllllIllllIllllIlIllII, lllllllllllllllIllllIllllIlIlIIl);
            }
        }
        return lllllllllllllllIllllIllllIlIlIIl;
    }
    
    private AdvancementTreeNode func_192326_a(final AdvancementTreeNode lllllllllllllllIllllIlllIIlllIII, final AdvancementTreeNode lllllllllllllllIllllIlllIIllIlll) {
        return (this.field_192333_f != null && lllllllllllllllIllllIlllIIlllIII.field_192329_b.field_192332_e.contains(this.field_192333_f)) ? this.field_192333_f : lllllllllllllllIllllIlllIIllIlll;
    }
    
    @Nullable
    private AdvancementTreeNode func_192317_d() {
        if (this.field_192334_g != null) {
            return this.field_192334_g;
        }
        return this.field_192332_e.isEmpty() ? null : this.field_192332_e.get(this.field_192332_e.size() - 1);
    }
    
    private void func_192325_b() {
        float lllllllllllllllIllllIlllIllllIII = 0.0f;
        float lllllllllllllllIllllIlllIlllIlll = 0.0f;
        for (int lllllllllllllllIllllIlllIlllIllI = this.field_192332_e.size() - 1; lllllllllllllllIllllIlllIlllIllI >= 0; --lllllllllllllllIllllIlllIlllIllI) {
            final AdvancementTreeNode advancementTreeNode;
            final AdvancementTreeNode lllllllllllllllIllllIlllIlllIlIl = advancementTreeNode = this.field_192332_e.get(lllllllllllllllIllllIlllIlllIllI);
            advancementTreeNode.field_192336_i += lllllllllllllllIllllIlllIllllIII;
            final AdvancementTreeNode advancementTreeNode2 = lllllllllllllllIllllIlllIlllIlIl;
            advancementTreeNode2.field_192337_j += lllllllllllllllIllllIlllIllllIII;
            lllllllllllllllIllllIlllIlllIlll += lllllllllllllllIllllIlllIlllIlIl.field_192338_k;
            lllllllllllllllIllllIlllIllllIII += lllllllllllllllIllllIlllIlllIlIl.field_192339_l + lllllllllllllllIllllIlllIlllIlll;
        }
    }
    
    private void func_192327_e() {
        if (this.field_192328_a.func_192068_c() != null) {
            this.field_192328_a.func_192068_c().func_192292_a((float)this.field_192335_h, this.field_192336_i);
        }
        if (!this.field_192332_e.isEmpty()) {
            for (final AdvancementTreeNode lllllllllllllllIllllIlllIIlIlIlI : this.field_192332_e) {
                lllllllllllllllIllllIlllIIlIlIlI.func_192327_e();
            }
        }
    }
    
    private void func_192318_a(final float lllllllllllllllIllllIllllIIIIIIl) {
        this.field_192336_i += lllllllllllllllIllllIllllIIIIIIl;
        for (final AdvancementTreeNode lllllllllllllllIllllIllllIIIIIll : this.field_192332_e) {
            lllllllllllllllIllllIllllIIIIIll.func_192318_a(lllllllllllllllIllllIllllIIIIIIl);
        }
    }
    
    private void func_192316_a(final AdvancementTreeNode lllllllllllllllIllllIlllIIllllll, final float lllllllllllllllIllllIlllIIlllllI) {
        final float lllllllllllllllIllllIlllIlIIIIIl = (float)(lllllllllllllllIllllIlllIIllllll.field_192331_d - this.field_192331_d);
        if (lllllllllllllllIllllIlllIlIIIIIl != 0.0f) {
            lllllllllllllllIllllIlllIIllllll.field_192338_k -= lllllllllllllllIllllIlllIIlllllI / lllllllllllllllIllllIlllIlIIIIIl;
            this.field_192338_k += lllllllllllllllIllllIlllIIlllllI / lllllllllllllllIllllIlllIlIIIIIl;
        }
        lllllllllllllllIllllIlllIIllllll.field_192339_l += lllllllllllllllIllllIlllIIlllllI;
        lllllllllllllllIllllIlllIIllllll.field_192336_i += lllllllllllllllIllllIlllIIlllllI;
        lllllllllllllllIllllIlllIIllllll.field_192337_j += lllllllllllllllIllllIlllIIlllllI;
    }
    
    private AdvancementTreeNode func_192324_a(AdvancementTreeNode lllllllllllllllIllllIlllIlIlIIlI) {
        if (this.field_192330_c == null) {
            return (AdvancementTreeNode)lllllllllllllllIllllIlllIlIlIIlI;
        }
        AdvancementTreeNode lllllllllllllllIllllIlllIlIlllII = this;
        AdvancementTreeNode lllllllllllllllIllllIlllIlIllIll = this;
        AdvancementTreeNode lllllllllllllllIllllIlllIlIllIlI = this.field_192330_c;
        AdvancementTreeNode lllllllllllllllIllllIlllIlIllIIl = this.field_192329_b.field_192332_e.get(0);
        float lllllllllllllllIllllIlllIlIllIII = this.field_192337_j;
        float lllllllllllllllIllllIlllIlIlIlll = this.field_192337_j;
        float lllllllllllllllIllllIlllIlIlIllI = lllllllllllllllIllllIlllIlIllIlI.field_192337_j;
        float lllllllllllllllIllllIlllIlIlIlIl = lllllllllllllllIllllIlllIlIllIIl.field_192337_j;
        while (lllllllllllllllIllllIlllIlIllIlI.func_192317_d() != null && lllllllllllllllIllllIlllIlIlllII.func_192321_c() != null) {
            lllllllllllllllIllllIlllIlIllIlI = lllllllllllllllIllllIlllIlIllIlI.func_192317_d();
            lllllllllllllllIllllIlllIlIlllII = lllllllllllllllIllllIlllIlIlllII.func_192321_c();
            lllllllllllllllIllllIlllIlIllIIl = lllllllllllllllIllllIlllIlIllIIl.func_192321_c();
            lllllllllllllllIllllIlllIlIllIll = lllllllllllllllIllllIlllIlIllIll.func_192317_d();
            lllllllllllllllIllllIlllIlIllIll.field_192333_f = this;
            final float lllllllllllllllIllllIlllIlIlIlII = lllllllllllllllIllllIlllIlIllIlI.field_192336_i + lllllllllllllllIllllIlllIlIlIllI - (lllllllllllllllIllllIlllIlIlllII.field_192336_i + lllllllllllllllIllllIlllIlIllIII) + 1.0f;
            if (lllllllllllllllIllllIlllIlIlIlII > 0.0f) {
                lllllllllllllllIllllIlllIlIllIlI.func_192326_a(this, (AdvancementTreeNode)lllllllllllllllIllllIlllIlIlIIlI).func_192316_a(this, lllllllllllllllIllllIlllIlIlIlII);
                lllllllllllllllIllllIlllIlIllIII += lllllllllllllllIllllIlllIlIlIlII;
                lllllllllllllllIllllIlllIlIlIlll += lllllllllllllllIllllIlllIlIlIlII;
            }
            lllllllllllllllIllllIlllIlIlIllI += lllllllllllllllIllllIlllIlIllIlI.field_192337_j;
            lllllllllllllllIllllIlllIlIllIII += lllllllllllllllIllllIlllIlIlllII.field_192337_j;
            lllllllllllllllIllllIlllIlIlIlIl += lllllllllllllllIllllIlllIlIllIIl.field_192337_j;
            lllllllllllllllIllllIlllIlIlIlll += lllllllllllllllIllllIlllIlIllIll.field_192337_j;
        }
        if (lllllllllllllllIllllIlllIlIllIlI.func_192317_d() != null && lllllllllllllllIllllIlllIlIllIll.func_192317_d() == null) {
            lllllllllllllllIllllIlllIlIllIll.field_192334_g = lllllllllllllllIllllIlllIlIllIlI.func_192317_d();
            final AdvancementTreeNode advancementTreeNode = lllllllllllllllIllllIlllIlIllIll;
            advancementTreeNode.field_192337_j += lllllllllllllllIllllIlllIlIlIllI - lllllllllllllllIllllIlllIlIlIlll;
        }
        else {
            if (lllllllllllllllIllllIlllIlIlllII.func_192321_c() != null && lllllllllllllllIllllIlllIlIllIIl.func_192321_c() == null) {
                lllllllllllllllIllllIlllIlIllIIl.field_192334_g = lllllllllllllllIllllIlllIlIlllII.func_192321_c();
                final AdvancementTreeNode advancementTreeNode2 = lllllllllllllllIllllIlllIlIllIIl;
                advancementTreeNode2.field_192337_j += lllllllllllllllIllllIlllIlIllIII - lllllllllllllllIllllIlllIlIlIlIl;
            }
            lllllllllllllllIllllIlllIlIlIIlI = this;
        }
        return (AdvancementTreeNode)lllllllllllllllIllllIlllIlIlIIlI;
    }
    
    public static void func_192323_a(final Advancement lllllllllllllllIllllIlllIIIlIIII) {
        if (lllllllllllllllIllllIlllIIIlIIII.func_192068_c() == null) {
            throw new IllegalArgumentException("Can't position children of an invisible root!");
        }
        final AdvancementTreeNode lllllllllllllllIllllIlllIIIlIIll = new AdvancementTreeNode(lllllllllllllllIllllIlllIIIlIIII, null, null, 1, 0);
        lllllllllllllllIllllIlllIIIlIIll.func_192320_a();
        final float lllllllllllllllIllllIlllIIIlIIIl = lllllllllllllllIllllIlllIIIlIIll.func_192319_a(0.0f, 0, lllllllllllllllIllllIlllIIIlIIll.field_192336_i);
        if (lllllllllllllllIllllIlllIIIlIIIl < 0.0f) {
            lllllllllllllllIllllIlllIIIlIIll.func_192318_a(-lllllllllllllllIllllIlllIIIlIIIl);
        }
        lllllllllllllllIllllIlllIIIlIIll.func_192327_e();
    }
    
    private float func_192319_a(final float lllllllllllllllIllllIllllIIIlllI, final int lllllllllllllllIllllIllllIIlIIlI, float lllllllllllllllIllllIllllIIIllII) {
        this.field_192336_i += lllllllllllllllIllllIllllIIIlllI;
        this.field_192335_h = lllllllllllllllIllllIllllIIlIIlI;
        if (this.field_192336_i < lllllllllllllllIllllIllllIIIllII) {
            lllllllllllllllIllllIllllIIIllII = this.field_192336_i;
        }
        for (final AdvancementTreeNode lllllllllllllllIllllIllllIIlIIII : this.field_192332_e) {
            lllllllllllllllIllllIllllIIIllII = lllllllllllllllIllllIllllIIlIIII.func_192319_a(lllllllllllllllIllllIllllIIIlllI + this.field_192337_j, lllllllllllllllIllllIllllIIlIIlI + 1, lllllllllllllllIllllIllllIIIllII);
        }
        return lllllllllllllllIllllIllllIIIllII;
    }
    
    @Nullable
    private AdvancementTreeNode func_192321_c() {
        if (this.field_192334_g != null) {
            return this.field_192334_g;
        }
        return this.field_192332_e.isEmpty() ? null : this.field_192332_e.get(0);
    }
    
    private void func_192320_a() {
        if (this.field_192332_e.isEmpty()) {
            if (this.field_192330_c != null) {
                this.field_192336_i = this.field_192330_c.field_192336_i + 1.0f;
            }
            else {
                this.field_192336_i = 0.0f;
            }
        }
        else {
            AdvancementTreeNode lllllllllllllllIllllIllllIlIIIIl = null;
            for (final AdvancementTreeNode lllllllllllllllIllllIllllIlIIIII : this.field_192332_e) {
                lllllllllllllllIllllIllllIlIIIII.func_192320_a();
                lllllllllllllllIllllIllllIlIIIIl = lllllllllllllllIllllIllllIlIIIII.func_192324_a((lllllllllllllllIllllIllllIlIIIIl == null) ? lllllllllllllllIllllIllllIlIIIII : lllllllllllllllIllllIllllIlIIIIl);
            }
            this.func_192325_b();
            final float lllllllllllllllIllllIllllIIlllll = (this.field_192332_e.get(0).field_192336_i + this.field_192332_e.get(this.field_192332_e.size() - 1).field_192336_i) / 2.0f;
            if (this.field_192330_c != null) {
                this.field_192336_i = this.field_192330_c.field_192336_i + 1.0f;
                this.field_192337_j = this.field_192336_i - lllllllllllllllIllllIllllIIlllll;
            }
            else {
                this.field_192336_i = lllllllllllllllIllllIllllIIlllll;
            }
        }
    }
    
    public AdvancementTreeNode(final Advancement lllllllllllllllIllllIlllllIIIlII, @Nullable final AdvancementTreeNode lllllllllllllllIllllIlllllIIIIll, @Nullable final AdvancementTreeNode lllllllllllllllIllllIlllllIIIIlI, final int lllllllllllllllIllllIllllIlllIIl, final int lllllllllllllllIllllIllllIlllIII) {
        this.field_192332_e = (List<AdvancementTreeNode>)Lists.newArrayList();
        if (lllllllllllllllIllllIlllllIIIlII.func_192068_c() == null) {
            throw new IllegalArgumentException("Can't position an invisible advancement!");
        }
        this.field_192328_a = lllllllllllllllIllllIlllllIIIlII;
        this.field_192329_b = lllllllllllllllIllllIlllllIIIIll;
        this.field_192330_c = lllllllllllllllIllllIlllllIIIIlI;
        this.field_192331_d = lllllllllllllllIllllIllllIlllIIl;
        this.field_192333_f = this;
        this.field_192335_h = lllllllllllllllIllllIllllIlllIII;
        this.field_192336_i = -1.0f;
        AdvancementTreeNode lllllllllllllllIllllIllllIllllll = null;
        for (final Advancement lllllllllllllllIllllIllllIlllllI : lllllllllllllllIllllIlllllIIIlII.func_192069_e()) {
            lllllllllllllllIllllIllllIllllll = this.func_192322_a(lllllllllllllllIllllIllllIlllllI, lllllllllllllllIllllIllllIllllll);
        }
    }
}
