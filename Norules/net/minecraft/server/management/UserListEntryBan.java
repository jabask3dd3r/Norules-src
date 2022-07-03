package net.minecraft.server.management;

import java.util.*;
import com.google.gson.*;
import java.text.*;

public abstract class UserListEntryBan<T> extends UserListEntry<T>
{
    public static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    protected final /* synthetic */ String bannedBy;
    protected final /* synthetic */ Date banStartDate;
    protected final /* synthetic */ Date banEndDate;
    protected final /* synthetic */ String reason;
    
    public String getBanReason() {
        return this.reason;
    }
    
    @Override
    boolean hasBanExpired() {
        return this.banEndDate != null && this.banEndDate.before(new Date());
    }
    
    protected UserListEntryBan(final T lllllllllllllIlllIlIlIlIllIIIlII, final JsonObject lllllllllllllIlllIlIlIlIlIlllIlI) {
        super(lllllllllllllIlllIlIlIlIllIIIlII, lllllllllllllIlllIlIlIlIlIlllIlI);
        Date lllllllllllllIlllIlIlIlIllIIIIIl = null;
        try {
            final Date lllllllllllllIlllIlIlIlIllIIIIlI = lllllllllllllIlllIlIlIlIlIlllIlI.has("created") ? UserListEntryBan.DATE_FORMAT.parse(lllllllllllllIlllIlIlIlIlIlllIlI.get("created").getAsString()) : new Date();
        }
        catch (ParseException lllllllllllllIlllIlIlIlIllIIIIII) {
            lllllllllllllIlllIlIlIlIllIIIIIl = new Date();
        }
        this.banStartDate = lllllllllllllIlllIlIlIlIllIIIIIl;
        this.bannedBy = (lllllllllllllIlllIlIlIlIlIlllIlI.has("source") ? lllllllllllllIlllIlIlIlIlIlllIlI.get("source").getAsString() : "(Unknown)");
        Date lllllllllllllIlllIlIlIlIlIlllllI = null;
        try {
            final Date lllllllllllllIlllIlIlIlIlIllllll = lllllllllllllIlllIlIlIlIlIlllIlI.has("expires") ? UserListEntryBan.DATE_FORMAT.parse(lllllllllllllIlllIlIlIlIlIlllIlI.get("expires").getAsString()) : null;
        }
        catch (ParseException lllllllllllllIlllIlIlIlIlIllllIl) {
            lllllllllllllIlllIlIlIlIlIlllllI = null;
        }
        this.banEndDate = lllllllllllllIlllIlIlIlIlIlllllI;
        this.reason = (lllllllllllllIlllIlIlIlIlIlllIlI.has("reason") ? lllllllllllllIlllIlIlIlIlIlllIlI.get("reason").getAsString() : "Banned by an operator.");
    }
    
    public Date getBanEndDate() {
        return this.banEndDate;
    }
    
    @Override
    protected void onSerialization(final JsonObject lllllllllllllIlllIlIlIlIlIlIlIII) {
        lllllllllllllIlllIlIlIlIlIlIlIII.addProperty("created", UserListEntryBan.DATE_FORMAT.format(this.banStartDate));
        lllllllllllllIlllIlIlIlIlIlIlIII.addProperty("source", this.bannedBy);
        lllllllllllllIlllIlIlIlIlIlIlIII.addProperty("expires", (this.banEndDate == null) ? "forever" : UserListEntryBan.DATE_FORMAT.format(this.banEndDate));
        lllllllllllllIlllIlIlIlIlIlIlIII.addProperty("reason", this.reason);
    }
    
    public UserListEntryBan(final T lllllllllllllIlllIlIlIlIllIlIIII, final Date lllllllllllllIlllIlIlIlIllIIllll, final String lllllllllllllIlllIlIlIlIllIlIlII, final Date lllllllllllllIlllIlIlIlIllIIllIl, final String lllllllllllllIlllIlIlIlIllIlIIlI) {
        super(lllllllllllllIlllIlIlIlIllIlIIII);
        this.banStartDate = ((lllllllllllllIlllIlIlIlIllIIllll == null) ? new Date() : lllllllllllllIlllIlIlIlIllIIllll);
        this.bannedBy = ((lllllllllllllIlllIlIlIlIllIlIlII == null) ? "(Unknown)" : lllllllllllllIlllIlIlIlIllIlIlII);
        this.banEndDate = lllllllllllllIlllIlIlIlIllIIllIl;
        this.reason = ((lllllllllllllIlllIlIlIlIllIlIIlI == null) ? "Banned by an operator." : lllllllllllllIlllIlIlIlIllIlIIlI);
    }
    
    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }
}
