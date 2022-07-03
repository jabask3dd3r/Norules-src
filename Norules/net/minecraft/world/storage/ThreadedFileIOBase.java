package net.minecraft.world.storage;

import com.google.common.collect.*;
import java.util.*;

public class ThreadedFileIOBase implements Runnable
{
    private static final /* synthetic */ ThreadedFileIOBase INSTANCE;
    private volatile /* synthetic */ long writeQueuedCounter;
    private volatile /* synthetic */ long savedIOCounter;
    private volatile /* synthetic */ boolean isThreadWaiting;
    private final /* synthetic */ List<IThreadedFileIO> threadedIOQueue;
    
    public void queueIO(final IThreadedFileIO llllllllllllllIllllIIllIlllIIlII) {
        if (!this.threadedIOQueue.contains(llllllllllllllIllllIIllIlllIIlII)) {
            ++this.writeQueuedCounter;
            this.threadedIOQueue.add(llllllllllllllIllllIIllIlllIIlII);
        }
    }
    
    private ThreadedFileIOBase() {
        this.threadedIOQueue = Collections.synchronizedList((List<IThreadedFileIO>)Lists.newArrayList());
        final Thread llllllllllllllIllllIIlllIIIlllII = new Thread(this, "File IO Thread");
        llllllllllllllIllllIIlllIIIlllII.setPriority(1);
        llllllllllllllIllllIIlllIIIlllII.start();
    }
    
    @Override
    public void run() {
        while (true) {
            this.processQueue();
        }
    }
    
    static {
        INSTANCE = new ThreadedFileIOBase();
    }
    
    private void processQueue() {
        for (int llllllllllllllIllllIIllIlllllllI = 0; llllllllllllllIllllIIllIlllllllI < this.threadedIOQueue.size(); ++llllllllllllllIllllIIllIlllllllI) {
            final IThreadedFileIO llllllllllllllIllllIIllIllllllII = this.threadedIOQueue.get(llllllllllllllIllllIIllIlllllllI);
            final boolean llllllllllllllIllllIIllIlllllIlI = llllllllllllllIllllIIllIllllllII.writeNextIO();
            if (!llllllllllllllIllllIIllIlllllIlI) {
                this.threadedIOQueue.remove(llllllllllllllIllllIIllIlllllllI--);
                ++this.savedIOCounter;
            }
            try {
                Thread.sleep(this.isThreadWaiting ? 0L : 10L);
            }
            catch (InterruptedException llllllllllllllIllllIIllIlllllIII) {
                llllllllllllllIllllIIllIlllllIII.printStackTrace();
            }
        }
        if (this.threadedIOQueue.isEmpty()) {
            try {
                Thread.sleep(25L);
            }
            catch (InterruptedException llllllllllllllIllllIIllIllllIlll) {
                llllllllllllllIllllIIllIllllIlll.printStackTrace();
            }
        }
    }
    
    public static ThreadedFileIOBase getThreadedIOInstance() {
        return ThreadedFileIOBase.INSTANCE;
    }
    
    public void waitForFinish() throws InterruptedException {
        this.isThreadWaiting = true;
        while (this.writeQueuedCounter != this.savedIOCounter) {
            Thread.sleep(10L);
        }
        this.isThreadWaiting = false;
    }
}
