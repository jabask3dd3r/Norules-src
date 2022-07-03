package net.minecraft.util;

import java.util.*;
import net.minecraft.client.gui.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import org.apache.commons.lang3.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public abstract class TabCompleter
{
    protected /* synthetic */ boolean didComplete;
    protected /* synthetic */ boolean requestedCompletions;
    protected /* synthetic */ List<String> completions;
    protected final /* synthetic */ GuiTextField textField;
    protected final /* synthetic */ boolean hasTargetBlock;
    protected /* synthetic */ int completionIdx;
    
    public void complete() {
        if (this.didComplete) {
            this.textField.deleteFromCursor(0);
            this.textField.deleteFromCursor(this.textField.getNthWordFromPosWS(-1, this.textField.getCursorPosition(), false) - this.textField.getCursorPosition());
            if (this.completionIdx >= this.completions.size()) {
                this.completionIdx = 0;
            }
        }
        else {
            final int lllllllllllllIIIIIlIIlIIlIIlIIII = this.textField.getNthWordFromPosWS(-1, this.textField.getCursorPosition(), false);
            this.completions.clear();
            this.completionIdx = 0;
            final String lllllllllllllIIIIIlIIlIIlIIIllll = this.textField.getText().substring(0, this.textField.getCursorPosition());
            this.requestCompletions(lllllllllllllIIIIIlIIlIIlIIIllll);
            if (this.completions.isEmpty()) {
                return;
            }
            this.didComplete = true;
            this.textField.deleteFromCursor(lllllllllllllIIIIIlIIlIIlIIlIIII - this.textField.getCursorPosition());
        }
        this.textField.writeText(this.completions.get(this.completionIdx++));
    }
    
    public void resetDidComplete() {
        this.didComplete = false;
    }
    
    public TabCompleter(final GuiTextField lllllllllllllIIIIIlIIlIIlIIllIIl, final boolean lllllllllllllIIIIIlIIlIIlIIlIlIl) {
        this.completions = (List<String>)Lists.newArrayList();
        this.textField = lllllllllllllIIIIIlIIlIIlIIllIIl;
        this.hasTargetBlock = lllllllllllllIIIIIlIIlIIlIIlIlIl;
    }
    
    public void resetRequested() {
        this.requestedCompletions = false;
    }
    
    private void requestCompletions(final String lllllllllllllIIIIIlIIlIIlIIIlIII) {
        if (lllllllllllllIIIIIlIIlIIlIIIlIII.length() >= 1) {
            Minecraft.getMinecraft().player.connection.sendPacket(new CPacketTabComplete(lllllllllllllIIIIIlIIlIIlIIIlIII, this.getTargetBlockPos(), this.hasTargetBlock));
            this.requestedCompletions = true;
        }
    }
    
    public void setCompletions(final String... lllllllllllllIIIIIlIIlIIIllllIIl) {
        if (this.requestedCompletions) {
            this.didComplete = false;
            this.completions.clear();
            final char lllllllllllllIIIIIlIIlIIIlllIlIl = (Object)lllllllllllllIIIIIlIIlIIIllllIIl;
            final byte lllllllllllllIIIIIlIIlIIIlllIllI = (byte)lllllllllllllIIIIIlIIlIIIllllIIl.length;
            for (double lllllllllllllIIIIIlIIlIIIlllIlll = 0; lllllllllllllIIIIIlIIlIIIlllIlll < lllllllllllllIIIIIlIIlIIIlllIllI; ++lllllllllllllIIIIIlIIlIIIlllIlll) {
                final String lllllllllllllIIIIIlIIlIIIlllllIl = lllllllllllllIIIIIlIIlIIIlllIlIl[lllllllllllllIIIIIlIIlIIIlllIlll];
                if (!lllllllllllllIIIIIlIIlIIIlllllIl.isEmpty()) {
                    this.completions.add(lllllllllllllIIIIIlIIlIIIlllllIl);
                }
            }
            final String lllllllllllllIIIIIlIIlIIIlllllII = this.textField.getText().substring(this.textField.getNthWordFromPosWS(-1, this.textField.getCursorPosition(), false));
            final String lllllllllllllIIIIIlIIlIIIllllIll = StringUtils.getCommonPrefix(lllllllllllllIIIIIlIIlIIIllllIIl);
            if (!lllllllllllllIIIIIlIIlIIIllllIll.isEmpty() && !lllllllllllllIIIIIlIIlIIIlllllII.equalsIgnoreCase(lllllllllllllIIIIIlIIlIIIllllIll)) {
                this.textField.deleteFromCursor(0);
                this.textField.deleteFromCursor(this.textField.getNthWordFromPosWS(-1, this.textField.getCursorPosition(), false) - this.textField.getCursorPosition());
                this.textField.writeText(lllllllllllllIIIIIlIIlIIIllllIll);
            }
            else if (!this.completions.isEmpty()) {
                this.didComplete = true;
                this.complete();
            }
        }
    }
    
    @Nullable
    public abstract BlockPos getTargetBlockPos();
}
