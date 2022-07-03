package net.minecraft.advancements;

import net.minecraft.util.*;
import com.google.gson.*;

public interface ICriterionTrigger<T extends ICriterionInstance>
{
    void func_192164_b(final PlayerAdvancements p0, final Listener<T> p1);
    
    void func_192167_a(final PlayerAdvancements p0);
    
    void func_192165_a(final PlayerAdvancements p0, final Listener<T> p1);
    
    ResourceLocation func_192163_a();
    
    T func_192166_a(final JsonObject p0, final JsonDeserializationContext p1);
    
    public static class Listener<T extends ICriterionInstance>
    {
        private final /* synthetic */ Advancement field_192161_b;
        private final /* synthetic */ T field_192160_a;
        private final /* synthetic */ String field_192162_c;
        
        public Listener(final T llllllllllllIlllllIllIllIllllIll, final Advancement llllllllllllIlllllIllIllIllllllI, final String llllllllllllIlllllIllIllIlllllIl) {
            this.field_192160_a = llllllllllllIlllllIllIllIllllIll;
            this.field_192161_b = llllllllllllIlllllIllIllIllllllI;
            this.field_192162_c = llllllllllllIlllllIllIllIlllllIl;
        }
        
        public T func_192158_a() {
            return this.field_192160_a;
        }
        
        @Override
        public int hashCode() {
            int llllllllllllIlllllIllIllIllIIIll = this.field_192160_a.hashCode();
            llllllllllllIlllllIllIllIllIIIll = 31 * llllllllllllIlllllIllIllIllIIIll + this.field_192161_b.hashCode();
            llllllllllllIlllllIllIllIllIIIll = 31 * llllllllllllIlllllIllIllIllIIIll + this.field_192162_c.hashCode();
            return llllllllllllIlllllIllIllIllIIIll;
        }
        
        @Override
        public boolean equals(final Object llllllllllllIlllllIllIllIllIlIII) {
            if (this == llllllllllllIlllllIllIllIllIlIII) {
                return true;
            }
            if (llllllllllllIlllllIllIllIllIlIII != null && this.getClass() == llllllllllllIlllllIllIllIllIlIII.getClass()) {
                final Listener<?> llllllllllllIlllllIllIllIllIlIlI = (Listener<?>)llllllllllllIlllllIllIllIllIlIII;
                return this.field_192160_a.equals(llllllllllllIlllllIllIllIllIlIlI.field_192160_a) && this.field_192161_b.equals(llllllllllllIlllllIllIllIllIlIlI.field_192161_b) && this.field_192162_c.equals(llllllllllllIlllllIllIllIllIlIlI.field_192162_c);
            }
            return false;
        }
        
        public void func_192159_a(final PlayerAdvancements llllllllllllIlllllIllIllIlllIIII) {
            llllllllllllIlllllIllIllIlllIIII.func_192750_a(this.field_192161_b, this.field_192162_c);
        }
    }
}
