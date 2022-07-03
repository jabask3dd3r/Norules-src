package net.minecraft.entity.ai;

import net.minecraft.profiler.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.*;

public class EntityAITasks
{
    private /* synthetic */ int disabledControlFlags;
    private final /* synthetic */ Set<EntityAITaskEntry> taskEntries;
    private /* synthetic */ int tickCount;
    private final /* synthetic */ Set<EntityAITaskEntry> executingTaskEntries;
    private /* synthetic */ int tickRate;
    private final /* synthetic */ Profiler theProfiler;
    
    public void addTask(final int llllllllllllllIlIllIIllllIIllIlI, final EntityAIBase llllllllllllllIlIllIIllllIIlIllI) {
        this.taskEntries.add(new EntityAITaskEntry(llllllllllllllIlIllIIllllIIllIlI, llllllllllllllIlIllIIllllIIlIllI));
    }
    
    private boolean canUse(final EntityAITaskEntry llllllllllllllIlIllIIlllIlllIIlI) {
        if (this.executingTaskEntries.isEmpty()) {
            return true;
        }
        if (this.isControlFlagDisabled(llllllllllllllIlIllIIlllIlllIIlI.action.getMutexBits())) {
            return false;
        }
        for (final EntityAITaskEntry llllllllllllllIlIllIIlllIlllIIIl : this.executingTaskEntries) {
            if (llllllllllllllIlIllIIlllIlllIIIl != llllllllllllllIlIllIIlllIlllIIlI) {
                if (llllllllllllllIlIllIIlllIlllIIlI.priority >= llllllllllllllIlIllIIlllIlllIIIl.priority) {
                    if (!this.areTasksCompatible(llllllllllllllIlIllIIlllIlllIIlI, llllllllllllllIlIllIIlllIlllIIIl)) {
                        return false;
                    }
                    continue;
                }
                else {
                    if (!llllllllllllllIlIllIIlllIlllIIIl.action.isInterruptible()) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public EntityAITasks(final Profiler llllllllllllllIlIllIIllllIIlllll) {
        this.taskEntries = (Set<EntityAITaskEntry>)Sets.newLinkedHashSet();
        this.executingTaskEntries = (Set<EntityAITaskEntry>)Sets.newLinkedHashSet();
        this.tickRate = 3;
        this.theProfiler = llllllllllllllIlIllIIllllIIlllll;
    }
    
    public boolean isControlFlagDisabled(final int llllllllllllllIlIllIIlllIllIIIII) {
        return (this.disabledControlFlags & llllllllllllllIlIllIIlllIllIIIII) > 0;
    }
    
    public void disableControlFlag(final int llllllllllllllIlIllIIlllIlIlllII) {
        this.disabledControlFlags |= llllllllllllllIlIllIIlllIlIlllII;
    }
    
    public void setControlFlag(final int llllllllllllllIlIllIIlllIlIIllII, final boolean llllllllllllllIlIllIIlllIlIIlllI) {
        if (llllllllllllllIlIllIIlllIlIIlllI) {
            this.enableControlFlag(llllllllllllllIlIllIIlllIlIIllII);
        }
        else {
            this.disableControlFlag(llllllllllllllIlIllIIlllIlIIllII);
        }
    }
    
    public void enableControlFlag(final int llllllllllllllIlIllIIlllIlIlIllI) {
        this.disabledControlFlags &= ~llllllllllllllIlIllIIlllIlIlIllI;
    }
    
    private boolean areTasksCompatible(final EntityAITaskEntry llllllllllllllIlIllIIlllIllIIlll, final EntityAITaskEntry llllllllllllllIlIllIIlllIllIlIII) {
        return (llllllllllllllIlIllIIlllIllIIlll.action.getMutexBits() & llllllllllllllIlIllIIlllIllIlIII.action.getMutexBits()) == 0x0;
    }
    
    public void removeTask(final EntityAIBase llllllllllllllIlIllIIllllIIIlIlI) {
        final Iterator<EntityAITaskEntry> llllllllllllllIlIllIIllllIIIlllI = this.taskEntries.iterator();
        while (llllllllllllllIlIllIIllllIIIlllI.hasNext()) {
            final EntityAITaskEntry llllllllllllllIlIllIIllllIIIllIl = llllllllllllllIlIllIIllllIIIlllI.next();
            final EntityAIBase llllllllllllllIlIllIIllllIIIllII = llllllllllllllIlIllIIllllIIIllIl.action;
            if (llllllllllllllIlIllIIllllIIIllII == llllllllllllllIlIllIIllllIIIlIlI) {
                if (llllllllllllllIlIllIIllllIIIllIl.using) {
                    llllllllllllllIlIllIIllllIIIllIl.using = false;
                    llllllllllllllIlIllIIllllIIIllIl.action.resetTask();
                    this.executingTaskEntries.remove(llllllllllllllIlIllIIllllIIIllIl);
                }
                llllllllllllllIlIllIIllllIIIlllI.remove();
            }
        }
    }
    
    public void onUpdateTasks() {
        this.theProfiler.startSection("goalSetup");
        if (this.tickCount++ % this.tickRate == 0) {
            for (final EntityAITaskEntry llllllllllllllIlIllIIllllIIIIIlI : this.taskEntries) {
                if (llllllllllllllIlIllIIllllIIIIIlI.using) {
                    if (this.canUse(llllllllllllllIlIllIIllllIIIIIlI) && this.canContinue(llllllllllllllIlIllIIllllIIIIIlI)) {
                        continue;
                    }
                    llllllllllllllIlIllIIllllIIIIIlI.using = false;
                    llllllllllllllIlIllIIllllIIIIIlI.action.resetTask();
                    this.executingTaskEntries.remove(llllllllllllllIlIllIIllllIIIIIlI);
                }
                else {
                    if (!this.canUse(llllllllllllllIlIllIIllllIIIIIlI) || !llllllllllllllIlIllIIllllIIIIIlI.action.shouldExecute()) {
                        continue;
                    }
                    llllllllllllllIlIllIIllllIIIIIlI.using = true;
                    llllllllllllllIlIllIIllllIIIIIlI.action.startExecuting();
                    this.executingTaskEntries.add(llllllllllllllIlIllIIllllIIIIIlI);
                }
            }
        }
        else {
            final Iterator<EntityAITaskEntry> llllllllllllllIlIllIIllllIIIIIIl = this.executingTaskEntries.iterator();
            while (llllllllllllllIlIllIIllllIIIIIIl.hasNext()) {
                final EntityAITaskEntry llllllllllllllIlIllIIllllIIIIIII = llllllllllllllIlIllIIllllIIIIIIl.next();
                if (!this.canContinue(llllllllllllllIlIllIIllllIIIIIII)) {
                    llllllllllllllIlIllIIllllIIIIIII.using = false;
                    llllllllllllllIlIllIIllllIIIIIII.action.resetTask();
                    llllllllllllllIlIllIIllllIIIIIIl.remove();
                }
            }
        }
        this.theProfiler.endSection();
        if (!this.executingTaskEntries.isEmpty()) {
            this.theProfiler.startSection("goalTick");
            for (final EntityAITaskEntry llllllllllllllIlIllIIlllIlllllll : this.executingTaskEntries) {
                llllllllllllllIlIllIIlllIlllllll.action.updateTask();
            }
            this.theProfiler.endSection();
        }
    }
    
    private boolean canContinue(final EntityAITaskEntry llllllllllllllIlIllIIlllIllllIII) {
        return llllllllllllllIlIllIIlllIllllIII.action.continueExecuting();
    }
    
    class EntityAITaskEntry
    {
        public final /* synthetic */ int priority;
        public final /* synthetic */ EntityAIBase action;
        public /* synthetic */ boolean using;
        
        @Override
        public boolean equals(@Nullable final Object llllllllllllllllIllIIlllIIIIIlIl) {
            return this == llllllllllllllllIllIIlllIIIIIlIl || (llllllllllllllllIllIIlllIIIIIlIl != null && this.getClass() == llllllllllllllllIllIIlllIIIIIlIl.getClass() && this.action.equals(((EntityAITaskEntry)llllllllllllllllIllIIlllIIIIIlIl).action));
        }
        
        @Override
        public int hashCode() {
            return this.action.hashCode();
        }
        
        public EntityAITaskEntry(final int llllllllllllllllIllIIlllIIIIlIlI, final EntityAIBase llllllllllllllllIllIIlllIIIIlIIl) {
            this.priority = llllllllllllllllIllIIlllIIIIlIlI;
            this.action = llllllllllllllllIllIIlllIIIIlIIl;
        }
    }
}
