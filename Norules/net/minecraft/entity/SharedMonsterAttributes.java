package net.minecraft.entity;

import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import javax.annotation.*;

public class SharedMonsterAttributes
{
    private static final /* synthetic */ Logger LOGGER;
    
    private static NBTTagCompound writeAttributeInstanceToNBT(final IAttributeInstance lllllllllllllIlllllllllIllIIllIl) {
        final NBTTagCompound lllllllllllllIlllllllllIllIlIIlI = new NBTTagCompound();
        final IAttribute lllllllllllllIlllllllllIllIlIIIl = lllllllllllllIlllllllllIllIIllIl.getAttribute();
        lllllllllllllIlllllllllIllIlIIlI.setString("Name", lllllllllllllIlllllllllIllIlIIIl.getAttributeUnlocalizedName());
        lllllllllllllIlllllllllIllIlIIlI.setDouble("Base", lllllllllllllIlllllllllIllIIllIl.getBaseValue());
        final Collection<AttributeModifier> lllllllllllllIlllllllllIllIlIIII = lllllllllllllIlllllllllIllIIllIl.getModifiers();
        if (lllllllllllllIlllllllllIllIlIIII != null && !lllllllllllllIlllllllllIllIlIIII.isEmpty()) {
            final NBTTagList lllllllllllllIlllllllllIllIIllll = new NBTTagList();
            for (final AttributeModifier lllllllllllllIlllllllllIllIIlllI : lllllllllllllIlllllllllIllIlIIII) {
                if (lllllllllllllIlllllllllIllIIlllI.isSaved()) {
                    lllllllllllllIlllllllllIllIIllll.appendTag(writeAttributeModifierToNBT(lllllllllllllIlllllllllIllIIlllI));
                }
            }
            lllllllllllllIlllllllllIllIlIIlI.setTag("Modifiers", lllllllllllllIlllllllllIllIIllll);
        }
        return lllllllllllllIlllllllllIllIlIIlI;
    }
    
    private static void applyModifiersToAttributeInstance(final IAttributeInstance lllllllllllllIlllllllllIlIlIIlIl, final NBTTagCompound lllllllllllllIlllllllllIlIlIlIlI) {
        lllllllllllllIlllllllllIlIlIIlIl.setBaseValue(lllllllllllllIlllllllllIlIlIlIlI.getDouble("Base"));
        if (lllllllllllllIlllllllllIlIlIlIlI.hasKey("Modifiers", 9)) {
            final NBTTagList lllllllllllllIlllllllllIlIlIlIIl = lllllllllllllIlllllllllIlIlIlIlI.getTagList("Modifiers", 10);
            for (int lllllllllllllIlllllllllIlIlIlIII = 0; lllllllllllllIlllllllllIlIlIlIII < lllllllllllllIlllllllllIlIlIlIIl.tagCount(); ++lllllllllllllIlllllllllIlIlIlIII) {
                final AttributeModifier lllllllllllllIlllllllllIlIlIIlll = readAttributeModifierFromNBT(lllllllllllllIlllllllllIlIlIlIIl.getCompoundTagAt(lllllllllllllIlllllllllIlIlIlIII));
                if (lllllllllllllIlllllllllIlIlIIlll != null) {
                    final AttributeModifier lllllllllllllIlllllllllIlIlIIllI = lllllllllllllIlllllllllIlIlIIlIl.getModifier(lllllllllllllIlllllllllIlIlIIlll.getID());
                    if (lllllllllllllIlllllllllIlIlIIllI != null) {
                        lllllllllllllIlllllllllIlIlIIlIl.removeModifier(lllllllllllllIlllllllllIlIlIIllI);
                    }
                    lllllllllllllIlllllllllIlIlIIlIl.applyModifier(lllllllllllllIlllllllllIlIlIIlll);
                }
            }
        }
    }
    
    public static NBTTagList writeBaseAttributeMapToNBT(final AbstractAttributeMap lllllllllllllIlllllllllIlllIIIIl) {
        final NBTTagList lllllllllllllIlllllllllIlllIIIII = new NBTTagList();
        for (final IAttributeInstance lllllllllllllIlllllllllIllIlllll : lllllllllllllIlllllllllIlllIIIIl.getAllAttributes()) {
            lllllllllllllIlllllllllIlllIIIII.appendTag(writeAttributeInstanceToNBT(lllllllllllllIlllllllllIllIlllll));
        }
        return lllllllllllllIlllllllllIlllIIIII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MAX_HEALTH = new RangedAttribute(null, "generic.maxHealth", 20.0, 0.0, 1024.0).setDescription("Max Health").setShouldWatch(true);
        FOLLOW_RANGE = new RangedAttribute(null, "generic.followRange", 32.0, 0.0, 2048.0).setDescription("Follow Range");
        KNOCKBACK_RESISTANCE = new RangedAttribute(null, "generic.knockbackResistance", 0.0, 0.0, 1.0).setDescription("Knockback Resistance");
        MOVEMENT_SPEED = new RangedAttribute(null, "generic.movementSpeed", 0.699999988079071, 0.0, 1024.0).setDescription("Movement Speed").setShouldWatch(true);
        field_193334_e = new RangedAttribute(null, "generic.flyingSpeed", 0.4000000059604645, 0.0, 1024.0).setDescription("Flying Speed").setShouldWatch(true);
        ATTACK_DAMAGE = new RangedAttribute(null, "generic.attackDamage", 2.0, 0.0, 2048.0);
        ATTACK_SPEED = new RangedAttribute(null, "generic.attackSpeed", 4.0, 0.0, 1024.0).setShouldWatch(true);
        ARMOR = new RangedAttribute(null, "generic.armor", 0.0, 0.0, 30.0).setShouldWatch(true);
        ARMOR_TOUGHNESS = new RangedAttribute(null, "generic.armorToughness", 0.0, 0.0, 20.0).setShouldWatch(true);
        LUCK = new RangedAttribute(null, "generic.luck", 0.0, -1024.0, 1024.0).setShouldWatch(true);
    }
    
    public static NBTTagCompound writeAttributeModifierToNBT(final AttributeModifier lllllllllllllIlllllllllIllIIIIlI) {
        final NBTTagCompound lllllllllllllIlllllllllIllIIIIll = new NBTTagCompound();
        lllllllllllllIlllllllllIllIIIIll.setString("Name", lllllllllllllIlllllllllIllIIIIlI.getName());
        lllllllllllllIlllllllllIllIIIIll.setDouble("Amount", lllllllllllllIlllllllllIllIIIIlI.getAmount());
        lllllllllllllIlllllllllIllIIIIll.setInteger("Operation", lllllllllllllIlllllllllIllIIIIlI.getOperation());
        lllllllllllllIlllllllllIllIIIIll.setUniqueId("UUID", lllllllllllllIlllllllllIllIIIIlI.getID());
        return lllllllllllllIlllllllllIllIIIIll;
    }
    
    public static void setAttributeModifiers(final AbstractAttributeMap lllllllllllllIlllllllllIlIlllIll, final NBTTagList lllllllllllllIlllllllllIlIllIlIl) {
        for (int lllllllllllllIlllllllllIlIlllIIl = 0; lllllllllllllIlllllllllIlIlllIIl < lllllllllllllIlllllllllIlIllIlIl.tagCount(); ++lllllllllllllIlllllllllIlIlllIIl) {
            final NBTTagCompound lllllllllllllIlllllllllIlIlllIII = lllllllllllllIlllllllllIlIllIlIl.getCompoundTagAt(lllllllllllllIlllllllllIlIlllIIl);
            final IAttributeInstance lllllllllllllIlllllllllIlIllIlll = lllllllllllllIlllllllllIlIlllIll.getAttributeInstanceByName(lllllllllllllIlllllllllIlIlllIII.getString("Name"));
            if (lllllllllllllIlllllllllIlIllIlll == null) {
                SharedMonsterAttributes.LOGGER.warn("Ignoring unknown attribute '{}'", (Object)lllllllllllllIlllllllllIlIlllIII.getString("Name"));
            }
            else {
                applyModifiersToAttributeInstance(lllllllllllllIlllllllllIlIllIlll, lllllllllllllIlllllllllIlIlllIII);
            }
        }
    }
    
    @Nullable
    public static AttributeModifier readAttributeModifierFromNBT(final NBTTagCompound lllllllllllllIlllllllllIlIIllIIl) {
        final UUID lllllllllllllIlllllllllIlIIllIll = lllllllllllllIlllllllllIlIIllIIl.getUniqueId("UUID");
        try {
            return new AttributeModifier(lllllllllllllIlllllllllIlIIllIll, lllllllllllllIlllllllllIlIIllIIl.getString("Name"), lllllllllllllIlllllllllIlIIllIIl.getDouble("Amount"), lllllllllllllIlllllllllIlIIllIIl.getInteger("Operation"));
        }
        catch (Exception lllllllllllllIlllllllllIlIIllIlI) {
            SharedMonsterAttributes.LOGGER.warn("Unable to create attribute: {}", (Object)lllllllllllllIlllllllllIlIIllIlI.getMessage());
            return null;
        }
    }
}
