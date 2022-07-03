package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.stats.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerEnchantment extends Container
{
    private final /* synthetic */ Random rand;
    public /* synthetic */ int[] worldClue;
    public /* synthetic */ int[] enchantClue;
    private final /* synthetic */ World worldPointer;
    public /* synthetic */ IInventory tableInventory;
    public /* synthetic */ int[] enchantLevels;
    private final /* synthetic */ BlockPos position;
    public /* synthetic */ int xpSeed;
    
    public int getLapisAmount() {
        final ItemStack lllllllllllllIllIIIllIIIIlIIIIII = this.tableInventory.getStackInSlot(1);
        return lllllllllllllIllIIIllIIIIlIIIIII.func_190926_b() ? 0 : lllllllllllllIllIIIllIIIIlIIIIII.func_190916_E();
    }
    
    protected void broadcastData(final IContainerListener lllllllllllllIllIIIllIIIlIlIIlII) {
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 3, this.xpSeed & 0xFFFFFFF0);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 4, this.enchantClue[0]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 5, this.enchantClue[1]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 6, this.enchantClue[2]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 7, this.worldClue[0]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 8, this.worldClue[1]);
        lllllllllllllIllIIIllIIIlIlIIlII.sendProgressBarUpdate(this, 9, this.worldClue[2]);
    }
    
    @Override
    public boolean enchantItem(final EntityPlayer lllllllllllllIllIIIllIIIIllIIlIl, final int lllllllllllllIllIIIllIIIIllIIlII) {
        ItemStack lllllllllllllIllIIIllIIIIllIIIll = this.tableInventory.getStackInSlot(0);
        final ItemStack lllllllllllllIllIIIllIIIIllIIIlI = this.tableInventory.getStackInSlot(1);
        final int lllllllllllllIllIIIllIIIIllIIIIl = lllllllllllllIllIIIllIIIIllIIlII + 1;
        if ((lllllllllllllIllIIIllIIIIllIIIlI.func_190926_b() || lllllllllllllIllIIIllIIIIllIIIlI.func_190916_E() < lllllllllllllIllIIIllIIIIllIIIIl) && !lllllllllllllIllIIIllIIIIllIIlIl.capabilities.isCreativeMode) {
            return false;
        }
        if (this.enchantLevels[lllllllllllllIllIIIllIIIIllIIlII] > 0 && !lllllllllllllIllIIIllIIIIllIIIll.func_190926_b() && ((lllllllllllllIllIIIllIIIIllIIlIl.experienceLevel >= lllllllllllllIllIIIllIIIIllIIIIl && lllllllllllllIllIIIllIIIIllIIlIl.experienceLevel >= this.enchantLevels[lllllllllllllIllIIIllIIIIllIIlII]) || lllllllllllllIllIIIllIIIIllIIlIl.capabilities.isCreativeMode)) {
            if (!this.worldPointer.isRemote) {
                final List<EnchantmentData> lllllllllllllIllIIIllIIIIllIIIII = this.getEnchantmentList(lllllllllllllIllIIIllIIIIllIIIll, lllllllllllllIllIIIllIIIIllIIlII, this.enchantLevels[lllllllllllllIllIIIllIIIIllIIlII]);
                if (!lllllllllllllIllIIIllIIIIllIIIII.isEmpty()) {
                    lllllllllllllIllIIIllIIIIllIIlIl.func_192024_a(lllllllllllllIllIIIllIIIIllIIIll, lllllllllllllIllIIIllIIIIllIIIIl);
                    final boolean lllllllllllllIllIIIllIIIIlIlllll = lllllllllllllIllIIIllIIIIllIIIll.getItem() == Items.BOOK;
                    if (lllllllllllllIllIIIllIIIIlIlllll) {
                        lllllllllllllIllIIIllIIIIllIIIll = new ItemStack(Items.ENCHANTED_BOOK);
                        this.tableInventory.setInventorySlotContents(0, lllllllllllllIllIIIllIIIIllIIIll);
                    }
                    for (int lllllllllllllIllIIIllIIIIlIllllI = 0; lllllllllllllIllIIIllIIIIlIllllI < lllllllllllllIllIIIllIIIIllIIIII.size(); ++lllllllllllllIllIIIllIIIIlIllllI) {
                        final EnchantmentData lllllllllllllIllIIIllIIIIlIlllIl = lllllllllllllIllIIIllIIIIllIIIII.get(lllllllllllllIllIIIllIIIIlIllllI);
                        if (lllllllllllllIllIIIllIIIIlIlllll) {
                            ItemEnchantedBook.addEnchantment(lllllllllllllIllIIIllIIIIllIIIll, lllllllllllllIllIIIllIIIIlIlllIl);
                        }
                        else {
                            lllllllllllllIllIIIllIIIIllIIIll.addEnchantment(lllllllllllllIllIIIllIIIIlIlllIl.enchantmentobj, lllllllllllllIllIIIllIIIIlIlllIl.enchantmentLevel);
                        }
                    }
                    if (!lllllllllllllIllIIIllIIIIllIIlIl.capabilities.isCreativeMode) {
                        lllllllllllllIllIIIllIIIIllIIIlI.func_190918_g(lllllllllllllIllIIIllIIIIllIIIIl);
                        if (lllllllllllllIllIIIllIIIIllIIIlI.func_190926_b()) {
                            this.tableInventory.setInventorySlotContents(1, ItemStack.field_190927_a);
                        }
                    }
                    lllllllllllllIllIIIllIIIIllIIlIl.addStat(StatList.ITEM_ENCHANTED);
                    if (lllllllllllllIllIIIllIIIIllIIlIl instanceof EntityPlayerMP) {
                        CriteriaTriggers.field_192129_i.func_192190_a((EntityPlayerMP)lllllllllllllIllIIIllIIIIllIIlIl, lllllllllllllIllIIIllIIIIllIIIll, lllllllllllllIllIIIllIIIIllIIIIl);
                    }
                    this.tableInventory.markDirty();
                    this.xpSeed = lllllllllllllIllIIIllIIIIllIIlIl.getXPSeed();
                    this.onCraftMatrixChanged(this.tableInventory);
                    this.worldPointer.playSound(null, this.position, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0f, this.worldPointer.rand.nextFloat() * 0.1f + 0.9f);
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllIllIIIllIIIIIlllIlI) {
        super.onContainerClosed(lllllllllllllIllIIIllIIIIIlllIlI);
        if (!this.worldPointer.isRemote) {
            this.func_193327_a(lllllllllllllIllIIIllIIIIIlllIlI, lllllllllllllIllIIIllIIIIIlllIlI.world, this.tableInventory);
        }
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllllIllIIIllIIIlIIIlllI, final int lllllllllllllIllIIIllIIIlIIIlIlI) {
        if (lllllllllllllIllIIIllIIIlIIIlllI >= 0 && lllllllllllllIllIIIllIIIlIIIlllI <= 2) {
            this.enchantLevels[lllllllllllllIllIIIllIIIlIIIlllI] = lllllllllllllIllIIIllIIIlIIIlIlI;
        }
        else if (lllllllllllllIllIIIllIIIlIIIlllI == 3) {
            this.xpSeed = lllllllllllllIllIIIllIIIlIIIlIlI;
        }
        else if (lllllllllllllIllIIIllIIIlIIIlllI >= 4 && lllllllllllllIllIIIllIIIlIIIlllI <= 6) {
            this.enchantClue[lllllllllllllIllIIIllIIIlIIIlllI - 4] = lllllllllllllIllIIIllIIIlIIIlIlI;
        }
        else if (lllllllllllllIllIIIllIIIlIIIlllI >= 7 && lllllllllllllIllIIIllIIIlIIIlllI <= 9) {
            this.worldClue[lllllllllllllIllIIIllIIIlIIIlllI - 7] = lllllllllllllIllIIIllIIIlIIIlIlI;
        }
        else {
            super.updateProgressBar(lllllllllllllIllIIIllIIIlIIIlllI, lllllllllllllIllIIIllIIIlIIIlIlI);
        }
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllllIllIIIllIIIIlllIllI) {
        if (lllllllllllllIllIIIllIIIIlllIllI == this.tableInventory) {
            final ItemStack lllllllllllllIllIIIllIIIlIIIIIII = lllllllllllllIllIIIllIIIIlllIllI.getStackInSlot(0);
            if (!lllllllllllllIllIIIllIIIlIIIIIII.func_190926_b() && lllllllllllllIllIIIllIIIlIIIIIII.isItemEnchantable()) {
                if (!this.worldPointer.isRemote) {
                    int lllllllllllllIllIIIllIIIIlllllll = 0;
                    for (int lllllllllllllIllIIIllIIIIllllllI = -1; lllllllllllllIllIIIllIIIIllllllI <= 1; ++lllllllllllllIllIIIllIIIIllllllI) {
                        for (int lllllllllllllIllIIIllIIIIlllllIl = -1; lllllllllllllIllIIIllIIIIlllllIl <= 1; ++lllllllllllllIllIIIllIIIIlllllIl) {
                            if ((lllllllllllllIllIIIllIIIIllllllI != 0 || lllllllllllllIllIIIllIIIIlllllIl != 0) && this.worldPointer.isAirBlock(this.position.add(lllllllllllllIllIIIllIIIIlllllIl, 0, lllllllllllllIllIIIllIIIIllllllI)) && this.worldPointer.isAirBlock(this.position.add(lllllllllllllIllIIIllIIIIlllllIl, 1, lllllllllllllIllIIIllIIIIllllllI))) {
                                if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl * 2, 0, lllllllllllllIllIIIllIIIIllllllI * 2)).getBlock() == Blocks.BOOKSHELF) {
                                    ++lllllllllllllIllIIIllIIIIlllllll;
                                }
                                if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl * 2, 1, lllllllllllllIllIIIllIIIIllllllI * 2)).getBlock() == Blocks.BOOKSHELF) {
                                    ++lllllllllllllIllIIIllIIIIlllllll;
                                }
                                if (lllllllllllllIllIIIllIIIIlllllIl != 0 && lllllllllllllIllIIIllIIIIllllllI != 0) {
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl * 2, 0, lllllllllllllIllIIIllIIIIllllllI)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIIllIIIIlllllll;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl * 2, 1, lllllllllllllIllIIIllIIIIllllllI)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIIllIIIIlllllll;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl, 0, lllllllllllllIllIIIllIIIIllllllI * 2)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIIllIIIIlllllll;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIIllIIIIlllllIl, 1, lllllllllllllIllIIIllIIIIllllllI * 2)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIIllIIIIlllllll;
                                    }
                                }
                            }
                        }
                    }
                    this.rand.setSeed(this.xpSeed);
                    for (int lllllllllllllIllIIIllIIIIlllllII = 0; lllllllllllllIllIIIllIIIIlllllII < 3; ++lllllllllllllIllIIIllIIIIlllllII) {
                        this.enchantLevels[lllllllllllllIllIIIllIIIIlllllII] = EnchantmentHelper.calcItemStackEnchantability(this.rand, lllllllllllllIllIIIllIIIIlllllII, lllllllllllllIllIIIllIIIIlllllll, lllllllllllllIllIIIllIIIlIIIIIII);
                        this.enchantClue[lllllllllllllIllIIIllIIIIlllllII] = -1;
                        this.worldClue[lllllllllllllIllIIIllIIIIlllllII] = -1;
                        if (this.enchantLevels[lllllllllllllIllIIIllIIIIlllllII] < lllllllllllllIllIIIllIIIIlllllII + 1) {
                            this.enchantLevels[lllllllllllllIllIIIllIIIIlllllII] = 0;
                        }
                    }
                    for (int lllllllllllllIllIIIllIIIIllllIll = 0; lllllllllllllIllIIIllIIIIllllIll < 3; ++lllllllllllllIllIIIllIIIIllllIll) {
                        if (this.enchantLevels[lllllllllllllIllIIIllIIIIllllIll] > 0) {
                            final List<EnchantmentData> lllllllllllllIllIIIllIIIIllllIlI = this.getEnchantmentList(lllllllllllllIllIIIllIIIlIIIIIII, lllllllllllllIllIIIllIIIIllllIll, this.enchantLevels[lllllllllllllIllIIIllIIIIllllIll]);
                            if (lllllllllllllIllIIIllIIIIllllIlI != null && !lllllllllllllIllIIIllIIIIllllIlI.isEmpty()) {
                                final EnchantmentData lllllllllllllIllIIIllIIIIllllIIl = lllllllllllllIllIIIllIIIIllllIlI.get(this.rand.nextInt(lllllllllllllIllIIIllIIIIllllIlI.size()));
                                this.enchantClue[lllllllllllllIllIIIllIIIIllllIll] = Enchantment.getEnchantmentID(lllllllllllllIllIIIllIIIIllllIIl.enchantmentobj);
                                this.worldClue[lllllllllllllIllIIIllIIIIllllIll] = lllllllllllllIllIIIllIIIIllllIIl.enchantmentLevel;
                            }
                        }
                    }
                    this.detectAndSendChanges();
                }
            }
            else {
                for (int lllllllllllllIllIIIllIIIIllllIII = 0; lllllllllllllIllIIIllIIIIllllIII < 3; ++lllllllllllllIllIIIllIIIIllllIII) {
                    this.enchantLevels[lllllllllllllIllIIIllIIIIllllIII] = 0;
                    this.enchantClue[lllllllllllllIllIIIllIIIIllllIII] = -1;
                    this.worldClue[lllllllllllllIllIIIllIIIIllllIII] = -1;
                }
            }
        }
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllIllIIIllIIIlIllIIll, final World lllllllllllllIllIIIllIIIlIllIIlI, final BlockPos lllllllllllllIllIIIllIIIlIllIIIl) {
        this.tableInventory = new InventoryBasic("Enchant", true, 2) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerEnchantment.this.onCraftMatrixChanged(this);
            }
            
            @Override
            public int getInventoryStackLimit() {
                return 64;
            }
        };
        this.rand = new Random();
        this.enchantLevels = new int[3];
        this.enchantClue = new int[] { -1, -1, -1 };
        this.worldClue = new int[] { -1, -1, -1 };
        this.worldPointer = lllllllllllllIllIIIllIIIlIllIIlI;
        this.position = lllllllllllllIllIIIllIIIlIllIIIl;
        this.xpSeed = lllllllllllllIllIIIllIIIlIllIIll.player.getXPSeed();
        this.addSlotToContainer(new Slot(this.tableInventory, 0, 15, 47) {
            @Override
            public int getSlotStackLimit() {
                return 1;
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllllIIIlIlIllIllllllI) {
                return true;
            }
        });
        this.addSlotToContainer(new Slot(this.tableInventory, 1, 35, 47) {
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIIlllIllIIIlIlIIIll) {
                return lllllllllllllIIlllIllIIIlIlIIIll.getItem() == Items.DYE && EnumDyeColor.byDyeDamage(lllllllllllllIIlllIllIIIlIlIIIll.getMetadata()) == EnumDyeColor.BLUE;
            }
        });
        for (int lllllllllllllIllIIIllIIIlIllIIII = 0; lllllllllllllIllIIIllIIIlIllIIII < 3; ++lllllllllllllIllIIIllIIIlIllIIII) {
            for (int lllllllllllllIllIIIllIIIlIlIllll = 0; lllllllllllllIllIIIllIIIlIlIllll < 9; ++lllllllllllllIllIIIllIIIlIlIllll) {
                this.addSlotToContainer(new Slot(lllllllllllllIllIIIllIIIlIllIIll, lllllllllllllIllIIIllIIIlIlIllll + lllllllllllllIllIIIllIIIlIllIIII * 9 + 9, 8 + lllllllllllllIllIIIllIIIlIlIllll * 18, 84 + lllllllllllllIllIIIllIIIlIllIIII * 18));
            }
        }
        for (int lllllllllllllIllIIIllIIIlIlIlllI = 0; lllllllllllllIllIIIllIIIlIlIlllI < 9; ++lllllllllllllIllIIIllIIIlIlIlllI) {
            this.addSlotToContainer(new Slot(lllllllllllllIllIIIllIIIlIllIIll, lllllllllllllIllIIIllIIIlIlIlllI, 8 + lllllllllllllIllIIIllIIIlIlIlllI * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllIllIIIllIIIIIllIlII) {
        return this.worldPointer.getBlockState(this.position).getBlock() == Blocks.ENCHANTING_TABLE && lllllllllllllIllIIIllIIIIIllIlII.getDistanceSq(this.position.getX() + 0.5, this.position.getY() + 0.5, this.position.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllllIllIIIllIIIlIIlIlll = 0; lllllllllllllIllIIIllIIIlIIlIlll < this.listeners.size(); ++lllllllllllllIllIIIllIIIlIIlIlll) {
            final IContainerListener lllllllllllllIllIIIllIIIlIIlIllI = this.listeners.get(lllllllllllllIllIIIllIIIlIIlIlll);
            this.broadcastData(lllllllllllllIllIIIllIIIlIIlIllI);
        }
    }
    
    private List<EnchantmentData> getEnchantmentList(final ItemStack lllllllllllllIllIIIllIIIIlIIllII, final int lllllllllllllIllIIIllIIIIlIIIllI, final int lllllllllllllIllIIIllIIIIlIIlIlI) {
        this.rand.setSeed(this.xpSeed + lllllllllllllIllIIIllIIIIlIIIllI);
        final List<EnchantmentData> lllllllllllllIllIIIllIIIIlIIlIIl = EnchantmentHelper.buildEnchantmentList(this.rand, lllllllllllllIllIIIllIIIIlIIllII, lllllllllllllIllIIIllIIIIlIIlIlI, false);
        if (lllllllllllllIllIIIllIIIIlIIllII.getItem() == Items.BOOK && lllllllllllllIllIIIllIIIIlIIlIIl.size() > 1) {
            lllllllllllllIllIIIllIIIIlIIlIIl.remove(this.rand.nextInt(lllllllllllllIllIIIllIIIIlIIlIIl.size()));
        }
        return lllllllllllllIllIIIllIIIIlIIlIIl;
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllIllIIIllIIIlIllllII, final World lllllllllllllIllIIIllIIIlIlllllI) {
        this(lllllllllllllIllIIIllIIIlIllllII, lllllllllllllIllIIIllIIIlIlllllI, BlockPos.ORIGIN);
    }
    
    @Override
    public void addListener(final IContainerListener lllllllllllllIllIIIllIIIlIIllllI) {
        super.addListener(lllllllllllllIllIIIllIIIlIIllllI);
        this.broadcastData(lllllllllllllIllIIIllIIIlIIllllI);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIllIIIllIIIIIlIlIlI, final int lllllllllllllIllIIIllIIIIIlIIIll) {
        ItemStack lllllllllllllIllIIIllIIIIIlIlIII = ItemStack.field_190927_a;
        final Slot lllllllllllllIllIIIllIIIIIlIIlll = this.inventorySlots.get(lllllllllllllIllIIIllIIIIIlIIIll);
        if (lllllllllllllIllIIIllIIIIIlIIlll != null && lllllllllllllIllIIIllIIIIIlIIlll.getHasStack()) {
            final ItemStack lllllllllllllIllIIIllIIIIIlIIllI = lllllllllllllIllIIIllIIIIIlIIlll.getStack();
            lllllllllllllIllIIIllIIIIIlIlIII = lllllllllllllIllIIIllIIIIIlIIllI.copy();
            if (lllllllllllllIllIIIllIIIIIlIIIll == 0) {
                if (!this.mergeItemStack(lllllllllllllIllIIIllIIIIIlIIllI, 2, 38, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllllIllIIIllIIIIIlIIIll == 1) {
                if (!this.mergeItemStack(lllllllllllllIllIIIllIIIIIlIIllI, 2, 38, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllllIllIIIllIIIIIlIIllI.getItem() == Items.DYE && EnumDyeColor.byDyeDamage(lllllllllllllIllIIIllIIIIIlIIllI.getMetadata()) == EnumDyeColor.BLUE) {
                if (!this.mergeItemStack(lllllllllllllIllIIIllIIIIIlIIllI, 1, 2, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else {
                if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(lllllllllllllIllIIIllIIIIIlIIllI)) {
                    return ItemStack.field_190927_a;
                }
                if (lllllllllllllIllIIIllIIIIIlIIllI.hasTagCompound() && lllllllllllllIllIIIllIIIIIlIIllI.func_190916_E() == 1) {
                    this.inventorySlots.get(0).putStack(lllllllllllllIllIIIllIIIIIlIIllI.copy());
                    lllllllllllllIllIIIllIIIIIlIIllI.func_190920_e(0);
                }
                else if (!lllllllllllllIllIIIllIIIIIlIIllI.func_190926_b()) {
                    this.inventorySlots.get(0).putStack(new ItemStack(lllllllllllllIllIIIllIIIIIlIIllI.getItem(), 1, lllllllllllllIllIIIllIIIIIlIIllI.getMetadata()));
                    lllllllllllllIllIIIllIIIIIlIIllI.func_190918_g(1);
                }
            }
            if (lllllllllllllIllIIIllIIIIIlIIllI.func_190926_b()) {
                lllllllllllllIllIIIllIIIIIlIIlll.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllIllIIIllIIIIIlIIlll.onSlotChanged();
            }
            if (lllllllllllllIllIIIllIIIIIlIIllI.func_190916_E() == lllllllllllllIllIIIllIIIIIlIlIII.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllllIllIIIllIIIIIlIIlll.func_190901_a(lllllllllllllIllIIIllIIIIIlIlIlI, lllllllllllllIllIIIllIIIIIlIIllI);
        }
        return lllllllllllllIllIIIllIIIIIlIlIII;
    }
}
