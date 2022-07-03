package net.minecraft.server.management;

import java.io.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;
import com.mojang.authlib.*;
import org.apache.logging.log4j.*;

public class PreYggdrasilConverter
{
    private static final /* synthetic */ Logger LOGGER;
    
    public static String convertMobOwnerIfNeeded(final MinecraftServer llllllllllllllIllIIlIIIIlllIIllI, final String llllllllllllllIllIIlIIIIlllIIlIl) {
        if (StringUtils.isNullOrEmpty(llllllllllllllIllIIlIIIIlllIIlIl) || llllllllllllllIllIIlIIIIlllIIlIl.length() > 16) {
            return llllllllllllllIllIIlIIIIlllIIlIl;
        }
        final GameProfile llllllllllllllIllIIlIIIIlllIIlII = llllllllllllllIllIIlIIIIlllIIllI.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllIllIIlIIIIlllIIlIl);
        if (llllllllllllllIllIIlIIIIlllIIlII != null && llllllllllllllIllIIlIIIIlllIIlII.getId() != null) {
            return llllllllllllllIllIIlIIIIlllIIlII.getId().toString();
        }
        if (!llllllllllllllIllIIlIIIIlllIIllI.isSinglePlayer() && llllllllllllllIllIIlIIIIlllIIllI.isServerInOnlineMode()) {
            final List<GameProfile> llllllllllllllIllIIlIIIIlllIIIll = (List<GameProfile>)Lists.newArrayList();
            final ProfileLookupCallback llllllllllllllIllIIlIIIIlllIIIlI = (ProfileLookupCallback)new ProfileLookupCallback() {
                public void onProfileLookupSucceeded(final GameProfile lllllllllllllllllllIlIIlIlIIlIIl) {
                    llllllllllllllIllIIlIIIIlllIIllI.getPlayerProfileCache().addEntry(lllllllllllllllllllIlIIlIlIIlIIl);
                    llllllllllllllIllIIlIIIIlllIIIll.add(lllllllllllllllllllIlIIlIlIIlIIl);
                }
                
                public void onProfileLookupFailed(final GameProfile lllllllllllllllllllIlIIlIlIIIIIl, final Exception lllllllllllllllllllIlIIlIlIIIIII) {
                    PreYggdrasilConverter.LOGGER.warn("Could not lookup user whitelist entry for {}", (Object)lllllllllllllllllllIlIIlIlIIIIIl.getName(), (Object)lllllllllllllllllllIlIIlIlIIIIII);
                }
            };
            lookupNames(llllllllllllllIllIIlIIIIlllIIllI, Lists.newArrayList((Object[])new String[] { llllllllllllllIllIIlIIIIlllIIlIl }), llllllllllllllIllIIlIIIIlllIIIlI);
            return (!llllllllllllllIllIIlIIIIlllIIIll.isEmpty() && llllllllllllllIllIIlIIIIlllIIIll.get(0).getId() != null) ? llllllllllllllIllIIlIIIIlllIIIll.get(0).getId().toString() : "";
        }
        return EntityPlayer.getUUID(new GameProfile((UUID)null, llllllllllllllIllIIlIIIIlllIIlIl)).toString();
    }
    
    private static void lookupNames(final MinecraftServer llllllllllllllIllIIlIIIIllllllII, final Collection<String> llllllllllllllIllIIlIIIIllllIlII, final ProfileLookupCallback llllllllllllllIllIIlIIIIllllIIll) {
        final String[] llllllllllllllIllIIlIIIIlllllIIl = (String[])Iterators.toArray((Iterator)Iterators.filter((Iterator)llllllllllllllIllIIlIIIIllllIlII.iterator(), (Predicate)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllllIIIlllIlllIIIlllIIl) {
                return !StringUtils.isNullOrEmpty(lllllllllllllIIIlllIlllIIIlllIIl);
            }
        }), (Class)String.class);
        if (llllllllllllllIllIIlIIIIllllllII.isServerInOnlineMode()) {
            llllllllllllllIllIIlIIIIllllllII.getGameProfileRepository().findProfilesByNames(llllllllllllllIllIIlIIIIlllllIIl, Agent.MINECRAFT, llllllllllllllIllIIlIIIIllllIIll);
        }
        else {
            final char llllllllllllllIllIIlIIIIlllIlllI;
            final String llllllllllllllIllIIlIIIIlllIllll = (String)((String[])(Object)(llllllllllllllIllIIlIIIIlllIlllI = (char)(Object)llllllllllllllIllIIlIIIIlllllIIl)).length;
            for (short llllllllllllllIllIIlIIIIllllIIII = 0; llllllllllllllIllIIlIIIIllllIIII < llllllllllllllIllIIlIIIIlllIllll; ++llllllllllllllIllIIlIIIIllllIIII) {
                final String llllllllllllllIllIIlIIIIlllllIII = llllllllllllllIllIIlIIIIlllIlllI[llllllllllllllIllIIlIIIIllllIIII];
                final UUID llllllllllllllIllIIlIIIIllllIlll = EntityPlayer.getUUID(new GameProfile((UUID)null, llllllllllllllIllIIlIIIIlllllIII));
                final GameProfile llllllllllllllIllIIlIIIIllllIllI = new GameProfile(llllllllllllllIllIIlIIIIllllIlll, llllllllllllllIllIIlIIIIlllllIII);
                llllllllllllllIllIIlIIIIllllIIll.onProfileLookupSucceeded(llllllllllllllIllIIlIIIIllllIllI);
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        OLD_IPBAN_FILE = new File("banned-ips.txt");
        OLD_PLAYERBAN_FILE = new File("banned-players.txt");
        OLD_OPS_FILE = new File("ops.txt");
        OLD_WHITELIST_FILE = new File("white-list.txt");
    }
}
