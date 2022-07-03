package me.nrules.utils.friend;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;

public class FriendManager
{
    public static /* synthetic */ ArrayList<Friend> friends;
    
    public static void addFriend(final String llllllllllllllIlIlllIlIlIlIllIll, final String llllllllllllllIlIlllIlIlIlIllIlI) {
        FriendManager.friends.add(new Friend(llllllllllllllIlIlllIlIlIlIllIll, llllllllllllllIlIlllIlIlIlIllIlI));
    }
    
    static {
        FriendManager.friends = new ArrayList<Friend>();
    }
    
    public static String getAliasName(final String llllllllllllllIlIlllIlIlIlIlIIII) {
        String llllllllllllllIlIlllIlIlIlIlIIlI = "";
        for (final Friend llllllllllllllIlIlllIlIlIlIlIIIl : FriendManager.friends) {
            if (llllllllllllllIlIlllIlIlIlIlIIIl.name.equalsIgnoreCase(StringUtils.stripControlCodes(llllllllllllllIlIlllIlIlIlIlIIII))) {
                llllllllllllllIlIlllIlIlIlIlIIlI = llllllllllllllIlIlllIlIlIlIlIIIl.alias;
                break;
            }
        }
        if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().player.getGameProfile().getName() == llllllllllllllIlIlllIlIlIlIlIIII) {
            return llllllllllllllIlIlllIlIlIlIlIIII;
        }
        return llllllllllllllIlIlllIlIlIlIlIIlI;
    }
    
    public static boolean isFriend(final String llllllllllllllIlIlllIlIlIlIIIIII) {
        boolean llllllllllllllIlIlllIlIlIIllllll = false;
        for (final Friend llllllllllllllIlIlllIlIlIIlllllI : FriendManager.friends) {
            if (!llllllllllllllIlIlllIlIlIIlllllI.getName().equalsIgnoreCase(StringUtils.stripControlCodes(llllllllllllllIlIlllIlIlIlIIIIII)) && !llllllllllllllIlIlllIlIlIIlllllI.getAlias().equalsIgnoreCase(StringUtils.stripControlCodes(llllllllllllllIlIlllIlIlIlIIIIII))) {
                continue;
            }
            llllllllllllllIlIlllIlIlIIllllll = true;
            break;
        }
        return llllllllllllllIlIlllIlIlIIllllll;
    }
    
    public static void deleteFriend(final String llllllllllllllIlIlllIlIlIlIIlIIl) {
        for (final Friend llllllllllllllIlIlllIlIlIlIIlIII : FriendManager.friends) {
            if (!llllllllllllllIlIlllIlIlIlIIlIII.getName().equalsIgnoreCase(llllllllllllllIlIlllIlIlIlIIlIIl) && !llllllllllllllIlIlllIlIlIlIIlIII.getAlias().equalsIgnoreCase(StringUtils.stripControlCodes(llllllllllllllIlIlllIlIlIlIIlIIl))) {
                continue;
            }
            FriendManager.friends.remove(llllllllllllllIlIlllIlIlIlIIlIII);
            break;
        }
    }
    
    public static class Friend
    {
        private /* synthetic */ String alias;
        private /* synthetic */ String name;
        
        public String getName() {
            return this.name;
        }
        
        public String getAlias() {
            return this.alias;
        }
        
        public Friend(final String llllllllllllllIlIIIlllIlIIlIllII, final String llllllllllllllIlIIIlllIlIIlIlIll) {
            this.name = llllllllllllllIlIIIlllIlIIlIllII;
            this.alias = llllllllllllllIlIIIlllIlIIlIlIll;
        }
        
        public void setName(final String llllllllllllllIlIIIlllIlIIlIIIIl) {
            this.name = llllllllllllllIlIIIlllIlIIlIIIIl;
        }
    }
}
