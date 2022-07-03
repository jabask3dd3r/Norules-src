package net.minecraft.util.text;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.command.*;

public class TextComponentUtils
{
    public static ITextComponent processComponent(final ICommandSender lllllllllllllIlllIIIIIIIIlIIllIl, final ITextComponent lllllllllllllIlllIIIIIIIIlIIllII, final Entity lllllllllllllIlllIIIIIIIIIlllIII) throws CommandException {
        ITextComponent lllllllllllllIlllIIIIIIIIlIIIllI = null;
        if (lllllllllllllIlllIIIIIIIIlIIllII instanceof TextComponentScore) {
            final TextComponentScore lllllllllllllIlllIIIIIIIIlIIIlIl = (TextComponentScore)lllllllllllllIlllIIIIIIIIlIIllII;
            String lllllllllllllIlllIIIIIIIIlIIIlII = lllllllllllllIlllIIIIIIIIlIIIlIl.getName();
            if (EntitySelector.hasArguments(lllllllllllllIlllIIIIIIIIlIIIlII)) {
                final List<Entity> lllllllllllllIlllIIIIIIIIlIIIIll = EntitySelector.matchEntities(lllllllllllllIlllIIIIIIIIlIIllIl, lllllllllllllIlllIIIIIIIIlIIIlII, (Class<? extends Entity>)Entity.class);
                if (lllllllllllllIlllIIIIIIIIlIIIIll.size() != 1) {
                    throw new EntityNotFoundException("commands.generic.selector.notFound", new Object[] { lllllllllllllIlllIIIIIIIIlIIIlII });
                }
                final Entity lllllllllllllIlllIIIIIIIIlIIIIlI = lllllllllllllIlllIIIIIIIIlIIIIll.get(0);
                if (lllllllllllllIlllIIIIIIIIlIIIIlI instanceof EntityPlayer) {
                    lllllllllllllIlllIIIIIIIIlIIIlII = lllllllllllllIlllIIIIIIIIlIIIIlI.getName();
                }
                else {
                    lllllllllllllIlllIIIIIIIIlIIIlII = lllllllllllllIlllIIIIIIIIlIIIIlI.getCachedUniqueIdString();
                }
            }
            final String lllllllllllllIlllIIIIIIIIlIIIIIl = (lllllllllllllIlllIIIIIIIIIlllIII != null && lllllllllllllIlllIIIIIIIIlIIIlII.equals("*")) ? lllllllllllllIlllIIIIIIIIIlllIII.getName() : lllllllllllllIlllIIIIIIIIlIIIlII;
            final ITextComponent lllllllllllllIlllIIIIIIIIlIIlIlI = new TextComponentScore(lllllllllllllIlllIIIIIIIIlIIIIIl, lllllllllllllIlllIIIIIIIIlIIIlIl.getObjective());
            ((TextComponentScore)lllllllllllllIlllIIIIIIIIlIIlIlI).setValue(lllllllllllllIlllIIIIIIIIlIIIlIl.getUnformattedComponentText());
            ((TextComponentScore)lllllllllllllIlllIIIIIIIIlIIlIlI).resolve(lllllllllllllIlllIIIIIIIIlIIllIl);
        }
        else if (lllllllllllllIlllIIIIIIIIlIIllII instanceof TextComponentSelector) {
            final String lllllllllllllIlllIIIIIIIIlIIIIII = ((TextComponentSelector)lllllllllllllIlllIIIIIIIIlIIllII).getSelector();
            ITextComponent lllllllllllllIlllIIIIIIIIlIIlIIl = EntitySelector.matchEntitiesToTextComponent(lllllllllllllIlllIIIIIIIIlIIllIl, lllllllllllllIlllIIIIIIIIlIIIIII);
            if (lllllllllllllIlllIIIIIIIIlIIlIIl == null) {
                lllllllllllllIlllIIIIIIIIlIIlIIl = new TextComponentString("");
            }
        }
        else if (lllllllllllllIlllIIIIIIIIlIIllII instanceof TextComponentString) {
            final ITextComponent lllllllllllllIlllIIIIIIIIlIIlIII = new TextComponentString(((TextComponentString)lllllllllllllIlllIIIIIIIIlIIllII).getText());
        }
        else if (lllllllllllllIlllIIIIIIIIlIIllII instanceof TextComponentKeybind) {
            final ITextComponent lllllllllllllIlllIIIIIIIIlIIIlll = new TextComponentKeybind(((TextComponentKeybind)lllllllllllllIlllIIIIIIIIlIIllII).func_193633_h());
        }
        else {
            if (!(lllllllllllllIlllIIIIIIIIlIIllII instanceof TextComponentTranslation)) {
                return lllllllllllllIlllIIIIIIIIlIIllII;
            }
            final Object[] lllllllllllllIlllIIIIIIIIIllllll = ((TextComponentTranslation)lllllllllllllIlllIIIIIIIIlIIllII).getFormatArgs();
            for (int lllllllllllllIlllIIIIIIIIIlllllI = 0; lllllllllllllIlllIIIIIIIIIlllllI < lllllllllllllIlllIIIIIIIIIllllll.length; ++lllllllllllllIlllIIIIIIIIIlllllI) {
                final Object lllllllllllllIlllIIIIIIIIIllllIl = lllllllllllllIlllIIIIIIIIIllllll[lllllllllllllIlllIIIIIIIIIlllllI];
                if (lllllllllllllIlllIIIIIIIIIllllIl instanceof ITextComponent) {
                    lllllllllllllIlllIIIIIIIIIllllll[lllllllllllllIlllIIIIIIIIIlllllI] = processComponent(lllllllllllllIlllIIIIIIIIlIIllIl, (ITextComponent)lllllllllllllIlllIIIIIIIIIllllIl, lllllllllllllIlllIIIIIIIIIlllIII);
                }
            }
            lllllllllllllIlllIIIIIIIIlIIIllI = new TextComponentTranslation(((TextComponentTranslation)lllllllllllllIlllIIIIIIIIlIIllII).getKey(), lllllllllllllIlllIIIIIIIIIllllll);
        }
        final Style lllllllllllllIlllIIIIIIIIIllllII = lllllllllllllIlllIIIIIIIIlIIllII.getStyle();
        if (lllllllllllllIlllIIIIIIIIIllllII != null) {
            lllllllllllllIlllIIIIIIIIlIIIllI.setStyle(lllllllllllllIlllIIIIIIIIIllllII.createShallowCopy());
        }
        for (final ITextComponent lllllllllllllIlllIIIIIIIIIlllIll : lllllllllllllIlllIIIIIIIIlIIllII.getSiblings()) {
            lllllllllllllIlllIIIIIIIIlIIIllI.appendSibling(processComponent(lllllllllllllIlllIIIIIIIIlIIllIl, lllllllllllllIlllIIIIIIIIIlllIll, lllllllllllllIlllIIIIIIIIIlllIII));
        }
        return lllllllllllllIlllIIIIIIIIlIIIllI;
    }
}
