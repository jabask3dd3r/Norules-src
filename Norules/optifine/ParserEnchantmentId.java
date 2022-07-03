package optifine;

import net.minecraft.enchantment.*;

public class ParserEnchantmentId implements IParserInt
{
    @Override
    public int parse(final String llIIIlIIIllllIl, final int llIIIlIIIllllII) {
        final Enchantment llIIIlIIIlllllI = Enchantment.getEnchantmentByLocation(llIIIlIIIllllIl);
        return (llIIIlIIIlllllI == null) ? llIIIlIIIllllII : Enchantment.getEnchantmentID(llIIIlIIIlllllI);
    }
}
