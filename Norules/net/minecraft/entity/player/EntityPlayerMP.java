package net.minecraft.entity.player;

import net.minecraft.server.*;
import com.google.common.collect.*;
import net.minecraft.item.crafting.*;
import javax.annotation.*;
import net.minecraft.world.storage.loot.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.village.*;
import net.minecraft.potion.*;
import net.minecraft.advancements.*;
import net.minecraft.network.play.client.*;
import net.minecraft.block.state.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.util.text.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.inventory.*;
import com.mojang.authlib.*;
import net.minecraft.world.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.datasync.*;
import net.minecraft.stats.*;
import net.minecraft.util.datafix.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.server.*;
import net.minecraft.server.management.*;

public class EntityPlayerMP extends EntityPlayer implements IContainerListener
{
    private final /* synthetic */ PlayerAdvancements field_192042_bX;
    private final /* synthetic */ List<Integer> entityRemoveQueue;
    private /* synthetic */ int lastFoodScore;
    private /* synthetic */ EnumChatVisibility chatVisibility;
    private /* synthetic */ int lastLevelScore;
    private /* synthetic */ int lastExperience;
    public final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ StatisticsManagerServer statsFile;
    private /* synthetic */ int lastExperienceScore;
    private final /* synthetic */ RecipeBookServer field_192041_cq;
    private /* synthetic */ Entity spectatingEntity;
    private /* synthetic */ int currentWindowId;
    private /* synthetic */ boolean chatColours;
    private /* synthetic */ int lastFoodLevel;
    public final /* synthetic */ PlayerInteractionManager interactionManager;
    private /* synthetic */ float lastHealth;
    public /* synthetic */ NetHandlerPlayServer connection;
    private /* synthetic */ boolean wasHungry;
    private /* synthetic */ int lastArmorScore;
    private /* synthetic */ int lastAirScore;
    private /* synthetic */ Vec3d field_193107_ct;
    private /* synthetic */ String language;
    private /* synthetic */ float lastHealthScore;
    public /* synthetic */ boolean playerConqueredTheEnd;
    private /* synthetic */ boolean field_192040_cp;
    private /* synthetic */ int field_193108_cu;
    private /* synthetic */ boolean invulnerableDimensionChange;
    public /* synthetic */ boolean isChangingQuantityOnly;
    private /* synthetic */ boolean field_193109_cv;
    private /* synthetic */ long playerLastActiveTime;
    private /* synthetic */ int respawnInvulnerabilityTicks;
    private /* synthetic */ Vec3d field_193110_cw;
    
    @Override
    public void setPositionAndUpdate(final double llllllllllllllllllIllIlIIIllIlIl, final double llllllllllllllllllIllIlIIIllIlII, final double llllllllllllllllllIllIlIIIllIIll) {
        this.connection.setPlayerLocation(llllllllllllllllllIllIlIIIllIlIl, llllllllllllllllllIllIlIIIllIlII, llllllllllllllllllIllIlIIIllIIll, this.rotationYaw, this.rotationPitch);
    }
    
    @Override
    public void addChatMessage(final ITextComponent llllllllllllllllllIllIlIIIIIllll) {
        this.connection.sendPacket(new SPacketChat(llllllllllllllllllIllIlIIIIIllll));
    }
    
    public void setPlayerHealthUpdated() {
        this.lastHealth = -1.0E8f;
    }
    
    @Override
    public void func_192024_a(final ItemStack llllllllllllllllllIlllIIIlIllllI, final int llllllllllllllllllIlllIIIlIllIlI) {
        super.func_192024_a(llllllllllllllllllIlllIIIlIllllI, llllllllllllllllllIlllIIIlIllIlI);
        this.lastExperience = -1;
    }
    
    public Entity getSpectatingEntity() {
        return (this.spectatingEntity == null) ? this : this.spectatingEntity;
    }
    
    @Override
    public void attackTargetEntityWithCurrentItem(final Entity llllllllllllllllllIllIIllIllllIl) {
        if (this.interactionManager.getGameType() == GameType.SPECTATOR) {
            this.setSpectatingEntity(llllllllllllllllllIllIIllIllllIl);
        }
        else {
            super.attackTargetEntityWithCurrentItem(llllllllllllllllllIllIIllIllllIl);
        }
    }
    
    @Override
    public void func_193102_a(final ResourceLocation[] llllllllllllllllllIllIlIIlllllIl) {
        final List<IRecipe> llllllllllllllllllIllIlIlIIIIIII = (List<IRecipe>)Lists.newArrayList();
        final Exception llllllllllllllllllIllIlIIllllIII = (Object)llllllllllllllllllIllIlIIlllllIl;
        final int llllllllllllllllllIllIlIIllllIIl = llllllllllllllllllIllIlIIlllllIl.length;
        for (Exception llllllllllllllllllIllIlIIllllIlI = (Exception)0; llllllllllllllllllIllIlIIllllIlI < llllllllllllllllllIllIlIIllllIIl; ++llllllllllllllllllIllIlIIllllIlI) {
            final ResourceLocation llllllllllllllllllIllIlIIlllllll = llllllllllllllllllIllIlIIllllIII[llllllllllllllllllIllIlIIllllIlI];
            llllllllllllllllllIllIlIlIIIIIII.add(CraftingManager.func_193373_a(llllllllllllllllllIllIlIIlllllll));
        }
        this.func_192021_a(llllllllllllllllllIllIlIlIIIIIII);
    }
    
    @Nullable
    public Vec3d func_193106_Q() {
        return this.field_193110_cw;
    }
    
    @Override
    public void displayGui(final IInteractionObject llllllllllllllllllIllIllIIlIllll) {
        if (llllllllllllllllllIllIllIIlIllll instanceof ILootContainer && ((ILootContainer)llllllllllllllllllIllIllIIlIllll).getLootTable() != null && this.isSpectator()) {
            this.addChatComponentMessage(new TextComponentTranslation("container.spectatorCantOpen", new Object[0]).setStyle(new Style().setColor(TextFormatting.RED)), true);
        }
        else {
            this.getNextWindowId();
            this.connection.sendPacket(new SPacketOpenWindow(this.currentWindowId, llllllllllllllllllIllIllIIlIllll.getGuiID(), llllllllllllllllllIllIllIIlIllll.getDisplayName()));
            this.openContainer = llllllllllllllllllIllIllIIlIllll.createContainer(this.inventory, this);
            this.openContainer.windowId = this.currentWindowId;
            this.openContainer.addListener(this);
        }
    }
    
    @Override
    public void addStat(final StatBase llllllllllllllllllIllIlIlIlIIIlI, final int llllllllllllllllllIllIlIlIIlllIl) {
        if (llllllllllllllllllIllIlIlIlIIIlI != null) {
            this.statsFile.increaseStat(this, llllllllllllllllllIllIlIlIlIIIlI, llllllllllllllllllIllIlIlIIlllIl);
            for (final ScoreObjective llllllllllllllllllIllIlIlIlIIIII : this.getWorldScoreboard().getObjectivesFromCriteria(llllllllllllllllllIllIlIlIlIIIlI.getCriteria())) {
                this.getWorldScoreboard().getOrCreateScore(this.getName(), llllllllllllllllllIllIlIlIlIIIII).increaseScore(llllllllllllllllllIllIlIlIIlllIl);
            }
        }
    }
    
    @Override
    public void sendEndCombat() {
        super.sendEndCombat();
        this.connection.sendPacket(new SPacketCombatEvent(this.getCombatTracker(), SPacketCombatEvent.Event.END_COMBAT));
    }
    
    @Override
    public void displayVillagerTradeGui(final IMerchant llllllllllllllllllIllIllIIIlIllI) {
        this.getNextWindowId();
        this.openContainer = new ContainerMerchant(this.inventory, llllllllllllllllllIllIllIIIlIllI, this.world);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.addListener(this);
        final IInventory llllllllllllllllllIllIllIIIllIll = ((ContainerMerchant)this.openContainer).getMerchantInventory();
        final ITextComponent llllllllllllllllllIllIllIIIllIlI = llllllllllllllllllIllIllIIIlIllI.getDisplayName();
        this.connection.sendPacket(new SPacketOpenWindow(this.currentWindowId, "minecraft:villager", llllllllllllllllllIllIllIIIllIlI, llllllllllllllllllIllIllIIIllIll.getSizeInventory()));
        final MerchantRecipeList llllllllllllllllllIllIllIIIllIIl = llllllllllllllllllIllIllIIIlIllI.getRecipes(this);
        if (llllllllllllllllllIllIllIIIllIIl != null) {
            final PacketBuffer llllllllllllllllllIllIllIIIllIII = new PacketBuffer(Unpooled.buffer());
            llllllllllllllllllIllIllIIIllIII.writeInt(this.currentWindowId);
            llllllllllllllllllIllIllIIIllIIl.writeToBuf(llllllllllllllllllIllIllIIIllIII);
            this.connection.sendPacket(new SPacketCustomPayload("MC|TrList", llllllllllllllllllIllIllIIIllIII));
        }
    }
    
    @Override
    protected void onItemUseFinish() {
        if (!this.activeItemStack.func_190926_b() && this.isHandActive()) {
            this.connection.sendPacket(new SPacketEntityStatus(this, (byte)9));
            super.onItemUseFinish();
        }
    }
    
    public void setElytraFlying() {
        this.setFlag(7, true);
    }
    
    @Override
    protected void onFinishedPotionEffect(final PotionEffect llllllllllllllllllIllIlIIlIIIIIl) {
        super.onFinishedPotionEffect(llllllllllllllllllIllIlIIlIIIIIl);
        this.connection.sendPacket(new SPacketRemoveEntityEffect(this.getEntityId(), llllllllllllllllllIllIlIIlIIIIIl.getPotion()));
        if (llllllllllllllllllIllIlIIlIIIIIl.getPotion() == MobEffects.LEVITATION) {
            this.field_193107_ct = null;
        }
        CriteriaTriggers.field_193139_z.func_193153_a(this);
    }
    
    @Override
    public void dismountRidingEntity() {
        final Entity llllllllllllllllllIllIllIlllIIlI = this.getRidingEntity();
        super.dismountRidingEntity();
        final Entity llllllllllllllllllIllIllIlllIIIl = this.getRidingEntity();
        if (llllllllllllllllllIllIllIlllIIIl != llllllllllllllllllIllIllIlllIIlI && this.connection != null) {
            this.connection.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllllIlllIIlIIIIIII) {
        super.readEntityFromNBT(llllllllllllllllllIlllIIlIIIIIII);
        if (llllllllllllllllllIlllIIlIIIIIII.hasKey("playerGameType", 99)) {
            if (this.getServer().getForceGamemode()) {
                this.interactionManager.setGameType(this.getServer().getGameType());
            }
            else {
                this.interactionManager.setGameType(GameType.getByID(llllllllllllllllllIlllIIlIIIIIII.getInteger("playerGameType")));
            }
        }
        if (llllllllllllllllllIlllIIlIIIIIII.hasKey("enteredNetherPosition", 10)) {
            final NBTTagCompound llllllllllllllllllIlllIIlIIIIIlI = llllllllllllllllllIlllIIlIIIIIII.getCompoundTag("enteredNetherPosition");
            this.field_193110_cw = new Vec3d(llllllllllllllllllIlllIIlIIIIIlI.getDouble("x"), llllllllllllllllllIlllIIlIIIIIlI.getDouble("y"), llllllllllllllllllIlllIIlIIIIIlI.getDouble("z"));
        }
        this.field_192040_cp = llllllllllllllllllIlllIIlIIIIIII.getBoolean("seenCredits");
        if (llllllllllllllllllIlllIIlIIIIIII.hasKey("recipeBook", 10)) {
            this.field_192041_cq.func_192825_a(llllllllllllllllllIlllIIlIIIIIII.getCompoundTag("recipeBook"));
        }
    }
    
    @Override
    public SleepResult trySleep(final BlockPos llllllllllllllllllIllIlllIIlIlII) {
        final SleepResult llllllllllllllllllIllIlllIIlIlll = super.trySleep(llllllllllllllllllIllIlllIIlIlII);
        if (llllllllllllllllllIllIlllIIlIlll == SleepResult.OK) {
            this.addStat(StatList.SLEEP_IN_BED);
            final Packet<?> llllllllllllllllllIllIlllIIlIllI = new SPacketUseBed(this, llllllllllllllllllIllIlllIIlIlII);
            this.getServerWorld().getEntityTracker().sendToAllTrackingEntity(this, llllllllllllllllllIllIlllIIlIllI);
            this.connection.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.connection.sendPacket(llllllllllllllllllIllIlllIIlIllI);
            CriteriaTriggers.field_192136_p.func_192215_a(this);
        }
        return llllllllllllllllllIllIlllIIlIlll;
    }
    
    public void loadResourcePack(final String llllllllllllllllllIllIIllllIllII, final String llllllllllllllllllIllIIllllIlIll) {
        this.connection.sendPacket(new SPacketResourcePackSend(llllllllllllllllllIllIIllllIllII, llllllllllllllllllIllIIllllIlIll));
    }
    
    @Override
    protected void decrementTimeUntilPortal() {
        if (this.timeUntilPortal > 0 && !this.invulnerableDimensionChange) {
            --this.timeUntilPortal;
        }
    }
    
    public void addEntity(final Entity llllllllllllllllllIllIIlllIlIIll) {
        this.entityRemoveQueue.remove((Object)llllllllllllllllllIllIIlllIlIIll.getEntityId());
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }
    
    public void handleClientSettings(final CPacketClientSettings llllllllllllllllllIllIIlllllIlll) {
        this.language = llllllllllllllllllIllIIlllllIlll.getLang();
        this.chatVisibility = llllllllllllllllllIllIIlllllIlll.getChatVisibility();
        this.chatColours = llllllllllllllllllIllIIlllllIlll.isColorsEnabled();
        this.getDataManager().set(EntityPlayerMP.PLAYER_MODEL_FLAG, (byte)llllllllllllllllllIllIIlllllIlll.getModelPartFlags());
        this.getDataManager().set(EntityPlayerMP.MAIN_HAND, (byte)((llllllllllllllllllIllIIlllllIlll.getMainHand() != EnumHandSide.LEFT) ? 1 : 0));
    }
    
    @Override
    protected void func_191955_a(final IBlockState llllllllllllllllllIlllIIIlIIllIl) {
        CriteriaTriggers.field_192124_d.func_192193_a(this, llllllllllllllllllIlllIIIlIIllIl);
    }
    
    @Override
    public void addExperienceLevel(final int llllllllllllllllllIlllIIIllIIlIl) {
        super.addExperienceLevel(llllllllllllllllllIlllIIIllIIlIl);
        this.lastExperience = -1;
    }
    
    public EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }
    
    @Override
    public boolean isSpectatedByPlayer(final EntityPlayerMP llllllllllllllllllIllIlllIllIIlI) {
        if (llllllllllllllllllIllIlllIllIIlI.isSpectator()) {
            return this.getSpectatingEntity() == this;
        }
        return !this.isSpectator() && super.isSpectatedByPlayer(llllllllllllllllllIllIlllIllIIlI);
    }
    
    public String getPlayerIP() {
        String llllllllllllllllllIllIIlllllllll = this.connection.netManager.getRemoteAddress().toString();
        llllllllllllllllllIllIIlllllllll = llllllllllllllllllIllIIlllllllll.substring(llllllllllllllllllIllIIlllllllll.indexOf("/") + 1);
        llllllllllllllllllIllIIlllllllll = llllllllllllllllllIllIIlllllllll.substring(0, llllllllllllllllllIllIIlllllllll.indexOf(":"));
        return llllllllllllllllllIllIIlllllllll;
    }
    
    public void sendContainerToPlayer(final Container llllllllllllllllllIllIlIlllIIlII) {
        this.updateCraftingInventory(llllllllllllllllllIllIlIlllIIlII, llllllllllllllllllIllIlIlllIIlII.getInventory());
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void addSelfToInternalCraftingInventory() {
        this.openContainer.addListener(this);
    }
    
    public StatisticsManagerServer getStatFile() {
        return this.statsFile;
    }
    
    public void closeContainer() {
        this.openContainer.onContainerClosed(this);
        this.openContainer = this.inventoryContainer;
    }
    
    @Override
    public void sendSlotContents(final Container llllllllllllllllllIllIlIlllIlIlI, final int llllllllllllllllllIllIlIlllIllIl, final ItemStack llllllllllllllllllIllIlIlllIlIII) {
        if (!(llllllllllllllllllIllIlIlllIlIlI.getSlot(llllllllllllllllllIllIlIlllIllIl) instanceof SlotCrafting)) {
            if (llllllllllllllllllIllIlIlllIlIlI == this.inventoryContainer) {
                CriteriaTriggers.field_192125_e.func_192208_a(this, this.inventory);
            }
            if (!this.isChangingQuantityOnly) {
                this.connection.sendPacket(new SPacketSetSlot(llllllllllllllllllIllIlIlllIlIlI.windowId, llllllllllllllllllIllIlIlllIllIl, llllllllllllllllllIllIlIlllIlIII));
            }
        }
    }
    
    @Override
    protected CooldownTracker createCooldownTracker() {
        return new CooldownTrackerServer(this);
    }
    
    @Override
    protected void updateFallState(final double llllllllllllllllllIllIllIllIIllI, final boolean llllllllllllllllllIllIllIllIIlIl, final IBlockState llllllllllllllllllIllIllIllIIlII, final BlockPos llllllllllllllllllIllIllIllIIIll) {
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllllIlllIIIllIllIl) {
        super.writeEntityToNBT(llllllllllllllllllIlllIIIllIllIl);
        llllllllllllllllllIlllIIIllIllIl.setInteger("playerGameType", this.interactionManager.getGameType().getID());
        llllllllllllllllllIlllIIIllIllIl.setBoolean("seenCredits", this.field_192040_cp);
        if (this.field_193110_cw != null) {
            final NBTTagCompound llllllllllllllllllIlllIIIlllIIll = new NBTTagCompound();
            llllllllllllllllllIlllIIIlllIIll.setDouble("x", this.field_193110_cw.xCoord);
            llllllllllllllllllIlllIIIlllIIll.setDouble("y", this.field_193110_cw.yCoord);
            llllllllllllllllllIlllIIIlllIIll.setDouble("z", this.field_193110_cw.zCoord);
            llllllllllllllllllIlllIIIllIllIl.setTag("enteredNetherPosition", llllllllllllllllllIlllIIIlllIIll);
        }
        final Entity llllllllllllllllllIlllIIIlllIIlI = this.getLowestRidingEntity();
        final Entity llllllllllllllllllIlllIIIlllIIIl = this.getRidingEntity();
        if (llllllllllllllllllIlllIIIlllIIIl != null && llllllllllllllllllIlllIIIlllIIlI != this && llllllllllllllllllIlllIIIlllIIlI.getRecursivePassengersByType(EntityPlayerMP.class).size() == 1) {
            final NBTTagCompound llllllllllllllllllIlllIIIlllIIII = new NBTTagCompound();
            final NBTTagCompound llllllllllllllllllIlllIIIllIllll = new NBTTagCompound();
            llllllllllllllllllIlllIIIlllIIlI.writeToNBTOptional(llllllllllllllllllIlllIIIllIllll);
            llllllllllllllllllIlllIIIlllIIII.setUniqueId("Attach", llllllllllllllllllIlllIIIlllIIIl.getUniqueID());
            llllllllllllllllllIlllIIIlllIIII.setTag("Entity", llllllllllllllllllIlllIIIllIllll);
            llllllllllllllllllIlllIIIllIllIl.setTag("RootVehicle", llllllllllllllllllIlllIIIlllIIII);
        }
        llllllllllllllllllIlllIIIllIllIl.setTag("recipeBook", this.field_192041_cq.func_192824_e());
    }
    
    @Override
    public void setGameType(final GameType llllllllllllllllllIllIlIIIIllIll) {
        this.interactionManager.setGameType(llllllllllllllllllIllIlIIIIllIll);
        this.connection.sendPacket(new SPacketChangeGameState(3, (float)llllllllllllllllllIllIlIIIIllIll.getID()));
        if (llllllllllllllllllIllIlIIIIllIll == GameType.SPECTATOR) {
            this.func_192030_dh();
            this.dismountRidingEntity();
        }
        else {
            this.setSpectatingEntity(this);
        }
        this.sendPlayerAbilities();
        this.markPotionsDirty();
    }
    
    @Override
    public void displayGuiCommandBlock(final TileEntityCommandBlock llllllllllllllllllIllIlIllllIlII) {
        llllllllllllllllllIllIlIllllIlII.setSendToClient(true);
        this.sendTileEntityUpdate(llllllllllllllllllIllIlIllllIlII);
    }
    
    @Nullable
    public ITextComponent getTabListDisplayName() {
        return null;
    }
    
    public boolean isInvulnerableDimensionChange() {
        return this.invulnerableDimensionChange;
    }
    
    private boolean canPlayersAttack() {
        return this.mcServer.isPVPEnabled();
    }
    
    public void handleFalling(final double llllllllllllllllllIllIllIlIlIIII, final boolean llllllllllllllllllIllIllIlIIIlII) {
        final int llllllllllllllllllIllIllIlIIlllI = MathHelper.floor(this.posX);
        final int llllllllllllllllllIllIllIlIIllIl = MathHelper.floor(this.posY - 0.20000000298023224);
        final int llllllllllllllllllIllIllIlIIllII = MathHelper.floor(this.posZ);
        BlockPos llllllllllllllllllIllIllIlIIlIll = new BlockPos(llllllllllllllllllIllIllIlIIlllI, llllllllllllllllllIllIllIlIIllIl, llllllllllllllllllIllIllIlIIllII);
        IBlockState llllllllllllllllllIllIllIlIIlIlI = this.world.getBlockState(llllllllllllllllllIllIllIlIIlIll);
        if (llllllllllllllllllIllIllIlIIlIlI.getMaterial() == Material.AIR) {
            final BlockPos llllllllllllllllllIllIllIlIIlIIl = llllllllllllllllllIllIllIlIIlIll.down();
            final IBlockState llllllllllllllllllIllIllIlIIlIII = this.world.getBlockState(llllllllllllllllllIllIllIlIIlIIl);
            final Block llllllllllllllllllIllIllIlIIIlll = llllllllllllllllllIllIllIlIIlIII.getBlock();
            if (llllllllllllllllllIllIllIlIIIlll instanceof BlockFence || llllllllllllllllllIllIllIlIIIlll instanceof BlockWall || llllllllllllllllllIllIllIlIIIlll instanceof BlockFenceGate) {
                llllllllllllllllllIllIllIlIIlIll = llllllllllllllllllIllIllIlIIlIIl;
                llllllllllllllllllIllIllIlIIlIlI = llllllllllllllllllIllIllIlIIlIII;
            }
        }
        super.updateFallState(llllllllllllllllllIllIllIlIlIIII, llllllllllllllllllIllIllIlIIIlII, llllllllllllllllllIllIllIlIIlIlI, llllllllllllllllllIllIllIlIIlIll);
    }
    
    private void getNextWindowId() {
        this.currentWindowId = this.currentWindowId % 100 + 1;
    }
    
    @Override
    public boolean canAttackPlayer(final EntityPlayer llllllllllllllllllIllIlllIllllll) {
        return this.canPlayersAttack() && super.canAttackPlayer(llllllllllllllllllIllIlllIllllll);
    }
    
    private Collection<ScoreObjective> func_192038_E(final Entity llllllllllllllllllIllIlllllIIllI) {
        final String llllllllllllllllllIllIlllllIIlIl = (llllllllllllllllllIllIlllllIIllI instanceof EntityPlayer) ? llllllllllllllllllIllIlllllIIllI.getName() : llllllllllllllllllIllIlllllIIllI.getCachedUniqueIdString();
        final ScorePlayerTeam llllllllllllllllllIllIlllllIIlII = this.getWorldScoreboard().getPlayersTeam(this.getName());
        if (llllllllllllllllllIllIlllllIIlII != null) {
            final int llllllllllllllllllIllIlllllIIIll = llllllllllllllllllIllIlllllIIlII.getChatFormat().getColorIndex();
            if (llllllllllllllllllIllIlllllIIIll >= 0 && llllllllllllllllllIllIlllllIIIll < IScoreCriteria.KILLED_BY_TEAM.length) {
                for (final ScoreObjective llllllllllllllllllIllIlllllIIIlI : this.getWorldScoreboard().getObjectivesFromCriteria(IScoreCriteria.KILLED_BY_TEAM[llllllllllllllllllIllIlllllIIIll])) {
                    final Score llllllllllllllllllIllIlllllIIIIl = this.getWorldScoreboard().getOrCreateScore(llllllllllllllllllIllIlllllIIlIl, llllllllllllllllllIllIlllllIIIlI);
                    llllllllllllllllllIllIlllllIIIIl.incrementScore();
                }
            }
        }
        final ScorePlayerTeam llllllllllllllllllIllIlllllIIIII = this.getWorldScoreboard().getPlayersTeam(llllllllllllllllllIllIlllllIIlIl);
        if (llllllllllllllllllIllIlllllIIIII != null) {
            final int llllllllllllllllllIllIllllIlllll = llllllllllllllllllIllIlllllIIIII.getChatFormat().getColorIndex();
            if (llllllllllllllllllIllIllllIlllll >= 0 && llllllllllllllllllIllIllllIlllll < IScoreCriteria.TEAM_KILL.length) {
                return this.getWorldScoreboard().getObjectivesFromCriteria(IScoreCriteria.TEAM_KILL[llllllllllllllllllIllIllllIlllll]);
            }
        }
        return (Collection<ScoreObjective>)Lists.newArrayList();
    }
    
    public void setEntityActionState(final float llllllllllllllllllIllIlIlIlIllII, final float llllllllllllllllllIllIlIlIlIlIll, final boolean llllllllllllllllllIllIlIlIlIlIlI, final boolean llllllllllllllllllIllIlIlIlIlIIl) {
        if (this.isRiding()) {
            if (llllllllllllllllllIllIlIlIlIllII >= -1.0f && llllllllllllllllllIllIlIlIlIllII <= 1.0f) {
                this.moveStrafing = llllllllllllllllllIllIlIlIlIllII;
            }
            if (llllllllllllllllllIllIlIlIlIlIll >= -1.0f && llllllllllllllllllIllIlIlIlIlIll <= 1.0f) {
                this.field_191988_bg = llllllllllllllllllIllIlIlIlIlIll;
            }
            this.isJumping = llllllllllllllllllIllIlIlIlIlIlI;
            this.setSneaking(llllllllllllllllllIllIlIlIlIlIIl);
        }
    }
    
    public void updateHeldItem() {
        if (!this.isChangingQuantityOnly) {
            this.connection.sendPacket(new SPacketSetSlot(-1, -1, this.inventory.getItemStack()));
        }
    }
    
    public void mountEntityAndWakeUp() {
        this.field_193109_cv = true;
        this.removePassengers();
        if (this.sleeping) {
            this.wakeUpPlayer(true, false, false);
        }
    }
    
    @Override
    public void addChatComponentMessage(final ITextComponent llllllllllllllllllIllIlIIllIIlII, final boolean llllllllllllllllllIllIlIIllIIIll) {
        this.connection.sendPacket(new SPacketChat(llllllllllllllllllIllIlIIllIIlII, llllllllllllllllllIllIlIIllIIIll ? ChatType.GAME_INFO : ChatType.CHAT));
    }
    
    @Override
    public void openBook(final ItemStack llllllllllllllllllIllIlIllllllIl, final EnumHand llllllllllllllllllIllIlIllllllII) {
        final Item llllllllllllllllllIllIllIIIIIIII = llllllllllllllllllIllIlIllllllIl.getItem();
        if (llllllllllllllllllIllIllIIIIIIII == Items.WRITTEN_BOOK) {
            final PacketBuffer llllllllllllllllllIllIlIllllllll = new PacketBuffer(Unpooled.buffer());
            llllllllllllllllllIllIlIllllllll.writeEnumValue(llllllllllllllllllIllIlIllllllII);
            this.connection.sendPacket(new SPacketCustomPayload("MC|BOpen", llllllllllllllllllIllIlIllllllll));
        }
    }
    
    @Override
    public void wakeUpPlayer(final boolean llllllllllllllllllIllIlllIIIlIII, final boolean llllllllllllllllllIllIlllIIIlIll, final boolean llllllllllllllllllIllIlllIIIIllI) {
        if (this.isPlayerSleeping()) {
            this.getServerWorld().getEntityTracker().sendToTrackingAndSelf(this, new SPacketAnimation(this, 2));
        }
        super.wakeUpPlayer(llllllllllllllllllIllIlllIIIlIII, llllllllllllllllllIllIlllIIIlIll, llllllllllllllllllIllIlllIIIIllI);
        if (this.connection != null) {
            this.connection.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    public void updateCraftingInventory(final Container llllllllllllllllllIllIlIllIlllIl, final NonNullList<ItemStack> llllllllllllllllllIllIlIllIlllII) {
        this.connection.sendPacket(new SPacketWindowItems(llllllllllllllllllIllIlIllIlllIl.windowId, llllllllllllllllllIllIlIllIlllII));
        this.connection.sendPacket(new SPacketSetSlot(-1, -1, this.inventory.getItemStack()));
    }
    
    public void clearElytraFlying() {
        this.setFlag(7, true);
        this.setFlag(7, false);
    }
    
    @Override
    public void displayGUIChest(final IInventory llllllllllllllllllIllIllIIlIlIII) {
        if (llllllllllllllllllIllIllIIlIlIII instanceof ILootContainer && ((ILootContainer)llllllllllllllllllIllIllIIlIlIII).getLootTable() != null && this.isSpectator()) {
            this.addChatComponentMessage(new TextComponentTranslation("container.spectatorCantOpen", new Object[0]).setStyle(new Style().setColor(TextFormatting.RED)), true);
        }
        else {
            if (this.openContainer != this.inventoryContainer) {
                this.closeScreen();
            }
            if (llllllllllllllllllIllIllIIlIlIII instanceof ILockableContainer) {
                final ILockableContainer llllllllllllllllllIllIllIIlIIlll = (ILockableContainer)llllllllllllllllllIllIllIIlIlIII;
                if (llllllllllllllllllIllIllIIlIIlll.isLocked() && !this.canOpen(llllllllllllllllllIllIllIIlIIlll.getLockCode()) && !this.isSpectator()) {
                    this.connection.sendPacket(new SPacketChat(new TextComponentTranslation("container.isLocked", new Object[] { llllllllllllllllllIllIllIIlIlIII.getDisplayName() }), ChatType.GAME_INFO));
                    this.connection.sendPacket(new SPacketSoundEffect(SoundEvents.BLOCK_CHEST_LOCKED, SoundCategory.BLOCKS, this.posX, this.posY, this.posZ, 1.0f, 1.0f));
                    return;
                }
            }
            this.getNextWindowId();
            if (llllllllllllllllllIllIllIIlIlIII instanceof IInteractionObject) {
                this.connection.sendPacket(new SPacketOpenWindow(this.currentWindowId, ((IInteractionObject)llllllllllllllllllIllIllIIlIlIII).getGuiID(), llllllllllllllllllIllIllIIlIlIII.getDisplayName(), llllllllllllllllllIllIllIIlIlIII.getSizeInventory()));
                this.openContainer = ((IInteractionObject)llllllllllllllllllIllIllIIlIlIII).createContainer(this.inventory, this);
            }
            else {
                this.connection.sendPacket(new SPacketOpenWindow(this.currentWindowId, "minecraft:container", llllllllllllllllllIllIllIIlIlIII.getDisplayName(), llllllllllllllllllIllIllIIlIlIII.getSizeInventory()));
                this.openContainer = new ContainerChest(this.inventory, llllllllllllllllllIllIllIIlIlIII, this);
            }
            this.openContainer.windowId = this.currentWindowId;
            this.openContainer.addListener(this);
        }
    }
    
    @Override
    public void openGuiHorseInventory(final AbstractHorse llllllllllllllllllIllIllIIIIlIlI, final IInventory llllllllllllllllllIllIllIIIIlIIl) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        this.getNextWindowId();
        this.connection.sendPacket(new SPacketOpenWindow(this.currentWindowId, "EntityHorse", llllllllllllllllllIllIllIIIIlIIl.getDisplayName(), llllllllllllllllllIllIllIIIIlIIl.getSizeInventory(), llllllllllllllllllIllIllIIIIlIlI.getEntityId()));
        this.openContainer = new ContainerHorseInventory(this.inventory, llllllllllllllllllIllIllIIIIlIIl, llllllllllllllllllIllIllIIIIlIlI, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.addListener(this);
    }
    
    public void markPlayerActive() {
        this.playerLastActiveTime = MinecraftServer.getCurrentTimeMillis();
    }
    
    public void removeEntity(final Entity llllllllllllllllllIllIIlllIllIIl) {
        if (llllllllllllllllllIllIIlllIllIIl instanceof EntityPlayer) {
            this.connection.sendPacket(new SPacketDestroyEntities(new int[] { llllllllllllllllllIllIIlllIllIIl.getEntityId() }));
        }
        else {
            this.entityRemoveQueue.add(llllllllllllllllllIllIIlllIllIIl.getEntityId());
        }
    }
    
    @Override
    public boolean isCreative() {
        return this.interactionManager.getGameType() == GameType.CREATIVE;
    }
    
    public void closeScreen() {
        this.connection.sendPacket(new SPacketCloseWindow(this.openContainer.windowId));
        this.closeContainer();
    }
    
    @Override
    protected void updatePotionMetadata() {
        if (this.isSpectator()) {
            this.resetPotionEffectMetadata();
            this.setInvisible(true);
        }
        else {
            super.updatePotionMetadata();
        }
        this.getServerWorld().getEntityTracker().updateVisibility(this);
    }
    
    @Override
    protected void frostWalk(final BlockPos llllllllllllllllllIllIllIlIlllll) {
        if (!this.isSpectator()) {
            super.frostWalk(llllllllllllllllllIllIllIlIlllll);
        }
    }
    
    @Override
    public void onEnchantmentCritical(final Entity llllllllllllllllllIllIlIIIlIIlll) {
        this.getServerWorld().getEntityTracker().sendToTrackingAndSelf(this, new SPacketAnimation(llllllllllllllllllIllIlIIIlIIlll, 5));
    }
    
    @Override
    protected void onNewPotionEffect(final PotionEffect llllllllllllllllllIllIlIIlIlIIII) {
        super.onNewPotionEffect(llllllllllllllllllIllIlIIlIlIIII);
        this.connection.sendPacket(new SPacketEntityEffect(this.getEntityId(), llllllllllllllllllIllIlIIlIlIIII));
        if (llllllllllllllllllIllIlIIlIlIIII.getPotion() == MobEffects.LEVITATION) {
            this.field_193108_cu = this.ticksExisted;
            this.field_193107_ct = new Vec3d(this.posX, this.posY, this.posZ);
        }
        CriteriaTriggers.field_193139_z.func_193153_a(this);
    }
    
    @Override
    public void sendProgressBarUpdate(final Container llllllllllllllllllIllIlIllIIllll, final int llllllllllllllllllIllIlIllIlIIlI, final int llllllllllllllllllIllIlIllIlIIIl) {
        this.connection.sendPacket(new SPacketWindowProperty(llllllllllllllllllIllIlIllIIllll.windowId, llllllllllllllllllIllIlIllIlIIlI, llllllllllllllllllIllIlIllIlIIIl));
    }
    
    @Nullable
    @Override
    public Entity changeDimension(int llllllllllllllllllIllIlllIllIllI) {
        this.invulnerableDimensionChange = true;
        if (this.dimension == 0 && llllllllllllllllllIllIlllIllIllI == -1) {
            this.field_193110_cw = new Vec3d(this.posX, this.posY, this.posZ);
        }
        else if (this.dimension != -1 && llllllllllllllllllIllIlllIllIllI != 0) {
            this.field_193110_cw = null;
        }
        if (this.dimension == 1 && llllllllllllllllllIllIlllIllIllI == 1) {
            this.world.removeEntity(this);
            if (!this.playerConqueredTheEnd) {
                this.playerConqueredTheEnd = true;
                this.connection.sendPacket(new SPacketChangeGameState(4, this.field_192040_cp ? 0.0f : 1.0f));
                this.field_192040_cp = true;
            }
            return this;
        }
        if (this.dimension == 0 && llllllllllllllllllIllIlllIllIllI == 1) {
            llllllllllllllllllIllIlllIllIllI = 1;
        }
        this.mcServer.getPlayerList().changePlayerDimension(this, llllllllllllllllllIllIlllIllIllI);
        this.connection.sendPacket(new SPacketEffect(1032, BlockPos.ORIGIN, 0, false));
        this.lastExperience = -1;
        this.lastHealth = -1.0f;
        this.lastFoodLevel = -1;
        return this;
    }
    
    @Override
    public void takeStat(final StatBase llllllllllllllllllIllIlIlIIlIlIl) {
        if (llllllllllllllllllIllIlIlIIlIlIl != null) {
            this.statsFile.unlockAchievement(this, llllllllllllllllllIllIlIlIIlIlIl, 0);
            for (final ScoreObjective llllllllllllllllllIllIlIlIIlIlII : this.getWorldScoreboard().getObjectivesFromCriteria(llllllllllllllllllIllIlIlIIlIlIl.getCriteria())) {
                this.getWorldScoreboard().getOrCreateScore(this.getName(), llllllllllllllllllIllIlIlIIlIlII).setScorePoints(0);
            }
        }
    }
    
    @Override
    public void func_191956_a(final Entity llllllllllllllllllIllIlllllllIll, final int llllllllllllllllllIllIlllllllIlI, final DamageSource llllllllllllllllllIllIlllllllIIl) {
        if (llllllllllllllllllIllIlllllllIll != this) {
            super.func_191956_a(llllllllllllllllllIllIlllllllIll, llllllllllllllllllIllIlllllllIlI, llllllllllllllllllIllIlllllllIIl);
            this.addScore(llllllllllllllllllIllIlllllllIlI);
            final Collection<ScoreObjective> llllllllllllllllllIllIlllllllIII = this.getWorldScoreboard().getObjectivesFromCriteria(IScoreCriteria.TOTAL_KILL_COUNT);
            if (llllllllllllllllllIllIlllllllIll instanceof EntityPlayer) {
                this.addStat(StatList.PLAYER_KILLS);
                llllllllllllllllllIllIlllllllIII.addAll(this.getWorldScoreboard().getObjectivesFromCriteria(IScoreCriteria.PLAYER_KILL_COUNT));
            }
            else {
                this.addStat(StatList.MOB_KILLS);
            }
            llllllllllllllllllIllIlllllllIII.addAll(this.func_192038_E(llllllllllllllllllIllIlllllllIll));
            for (final ScoreObjective llllllllllllllllllIllIllllllIlll : llllllllllllllllllIllIlllllllIII) {
                this.getWorldScoreboard().getOrCreateScore(this.getName(), llllllllllllllllllIllIllllllIlll).incrementScore();
            }
            CriteriaTriggers.field_192122_b.func_192211_a(this, llllllllllllllllllIllIlllllllIll, llllllllllllllllllIllIlllllllIIl);
        }
    }
    
    public EntityPlayerMP(final MinecraftServer llllllllllllllllllIlllIIlIIIlllI, final WorldServer llllllllllllllllllIlllIIlIIIllIl, final GameProfile llllllllllllllllllIlllIIlIIlIlII, final PlayerInteractionManager llllllllllllllllllIlllIIlIIlIIll) {
        super(llllllllllllllllllIlllIIlIIIllIl, llllllllllllllllllIlllIIlIIlIlII);
        this.language = "en_US";
        this.entityRemoveQueue = (List<Integer>)Lists.newLinkedList();
        this.lastHealthScore = Float.MIN_VALUE;
        this.lastFoodScore = Integer.MIN_VALUE;
        this.lastAirScore = Integer.MIN_VALUE;
        this.lastArmorScore = Integer.MIN_VALUE;
        this.lastLevelScore = Integer.MIN_VALUE;
        this.lastExperienceScore = Integer.MIN_VALUE;
        this.lastHealth = -1.0E8f;
        this.lastFoodLevel = -99999999;
        this.wasHungry = true;
        this.lastExperience = -99999999;
        this.respawnInvulnerabilityTicks = 60;
        this.chatColours = true;
        this.playerLastActiveTime = System.currentTimeMillis();
        this.field_192041_cq = new RecipeBookServer();
        llllllllllllllllllIlllIIlIIlIIll.thisPlayerMP = this;
        this.interactionManager = llllllllllllllllllIlllIIlIIlIIll;
        BlockPos llllllllllllllllllIlllIIlIIlIIlI = llllllllllllllllllIlllIIlIIIllIl.getSpawnPoint();
        if (llllllllllllllllllIlllIIlIIIllIl.provider.func_191066_m() && llllllllllllllllllIlllIIlIIIllIl.getWorldInfo().getGameType() != GameType.ADVENTURE) {
            int llllllllllllllllllIlllIIlIIlIIIl = Math.max(0, llllllllllllllllllIlllIIlIIIlllI.getSpawnRadius(llllllllllllllllllIlllIIlIIIllIl));
            final int llllllllllllllllllIlllIIlIIlIIII = MathHelper.floor(llllllllllllllllllIlllIIlIIIllIl.getWorldBorder().getClosestDistance(llllllllllllllllllIlllIIlIIlIIlI.getX(), llllllllllllllllllIlllIIlIIlIIlI.getZ()));
            if (llllllllllllllllllIlllIIlIIlIIII < llllllllllllllllllIlllIIlIIlIIIl) {
                llllllllllllllllllIlllIIlIIlIIIl = llllllllllllllllllIlllIIlIIlIIII;
            }
            if (llllllllllllllllllIlllIIlIIlIIII <= 1) {
                llllllllllllllllllIlllIIlIIlIIIl = 1;
            }
            llllllllllllllllllIlllIIlIIlIIlI = llllllllllllllllllIlllIIlIIIllIl.getTopSolidOrLiquidBlock(llllllllllllllllllIlllIIlIIlIIlI.add(this.rand.nextInt(llllllllllllllllllIlllIIlIIlIIIl * 2 + 1) - llllllllllllllllllIlllIIlIIlIIIl, 0, this.rand.nextInt(llllllllllllllllllIlllIIlIIlIIIl * 2 + 1) - llllllllllllllllllIlllIIlIIlIIIl));
        }
        this.mcServer = llllllllllllllllllIlllIIlIIIlllI;
        this.statsFile = llllllllllllllllllIlllIIlIIIlllI.getPlayerList().getPlayerStatsFile(this);
        this.field_192042_bX = llllllllllllllllllIlllIIlIIIlllI.getPlayerList().func_192054_h(this);
        this.stepHeight = 1.0f;
        this.moveToBlockPosAndAngles(llllllllllllllllllIlllIIlIIlIIlI, 0.0f, 0.0f);
        while (!llllllllllllllllllIlllIIlIIIllIl.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && this.posY < 255.0) {
            this.setPosition(this.posX, this.posY + 1.0, this.posZ);
        }
    }
    
    public void setSpectatingEntity(final Entity llllllllllllllllllIllIIlllIIIlIl) {
        final Entity llllllllllllllllllIllIIlllIIIlll = this.getSpectatingEntity();
        this.spectatingEntity = ((llllllllllllllllllIllIIlllIIIlIl == null) ? this : llllllllllllllllllIllIIlllIIIlIl);
        if (llllllllllllllllllIllIIlllIIIlll != this.spectatingEntity) {
            this.connection.sendPacket(new SPacketCamera(this.spectatingEntity));
            this.setPositionAndUpdate(this.spectatingEntity.posX, this.spectatingEntity.posY, this.spectatingEntity.posZ);
        }
    }
    
    @Override
    public void sendAllWindowProperties(final Container llllllllllllllllllIllIlIllIIIlll, final IInventory llllllllllllllllllIllIlIllIIIllI) {
        for (int llllllllllllllllllIllIlIllIIIlIl = 0; llllllllllllllllllIllIlIllIIIlIl < llllllllllllllllllIllIlIllIIIllI.getFieldCount(); ++llllllllllllllllllIllIlIllIIIlIl) {
            this.connection.sendPacket(new SPacketWindowProperty(llllllllllllllllllIllIlIllIIIlll.windowId, llllllllllllllllllIllIlIllIIIlIl, llllllllllllllllllIllIlIllIIIllI.getField(llllllllllllllllllIllIlIllIIIlIl)));
        }
    }
    
    @Override
    public boolean isEntityInvulnerable(final DamageSource llllllllllllllllllIllIllIllIlIII) {
        return super.isEntityInvulnerable(llllllllllllllllllIllIllIllIlIII) || this.isInvulnerableDimensionChange();
    }
    
    @Override
    public void sendPlayerAbilities() {
        if (this.connection != null) {
            this.connection.sendPacket(new SPacketPlayerAbilities(this.capabilities));
            this.updatePotionMetadata();
        }
    }
    
    @Override
    public void sendEnterCombat() {
        super.sendEnterCombat();
        this.connection.sendPacket(new SPacketCombatEvent(this.getCombatTracker(), SPacketCombatEvent.Event.ENTER_COMBAT));
    }
    
    @Override
    public void swingArm(final EnumHand llllllllllllllllllIllIIllIllIIll) {
        super.swingArm(llllllllllllllllllIllIIllIllIIll);
        this.resetCooldown();
    }
    
    public void clearInvulnerableDimensionChange() {
        this.invulnerableDimensionChange = false;
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllllIlllIIIIIlIIII) {
        final boolean llllllllllllllllllIlllIIIIIIllll = this.world.getGameRules().getBoolean("showDeathMessages");
        this.connection.sendPacket(new SPacketCombatEvent(this.getCombatTracker(), SPacketCombatEvent.Event.ENTITY_DIED, llllllllllllllllllIlllIIIIIIllll));
        if (llllllllllllllllllIlllIIIIIIllll) {
            final Team llllllllllllllllllIlllIIIIIIlllI = this.getTeam();
            if (llllllllllllllllllIlllIIIIIIlllI != null && llllllllllllllllllIlllIIIIIIlllI.getDeathMessageVisibility() != Team.EnumVisible.ALWAYS) {
                if (llllllllllllllllllIlllIIIIIIlllI.getDeathMessageVisibility() == Team.EnumVisible.HIDE_FOR_OTHER_TEAMS) {
                    this.mcServer.getPlayerList().sendMessageToAllTeamMembers(this, this.getCombatTracker().getDeathMessage());
                }
                else if (llllllllllllllllllIlllIIIIIIlllI.getDeathMessageVisibility() == Team.EnumVisible.HIDE_FOR_OWN_TEAM) {
                    this.mcServer.getPlayerList().sendMessageToTeamOrAllPlayers(this, this.getCombatTracker().getDeathMessage());
                }
            }
            else {
                this.mcServer.getPlayerList().sendChatMsg(this.getCombatTracker().getDeathMessage());
            }
        }
        this.func_192030_dh();
        if (!this.world.getGameRules().getBoolean("keepInventory") && !this.isSpectator()) {
            this.func_190776_cN();
            this.inventory.dropAllItems();
        }
        for (final ScoreObjective llllllllllllllllllIlllIIIIIIllIl : this.world.getScoreboard().getObjectivesFromCriteria(IScoreCriteria.DEATH_COUNT)) {
            final Score llllllllllllllllllIlllIIIIIIllII = this.getWorldScoreboard().getOrCreateScore(this.getName(), llllllllllllllllllIlllIIIIIIllIl);
            llllllllllllllllllIlllIIIIIIllII.incrementScore();
        }
        final EntityLivingBase llllllllllllllllllIlllIIIIIIlIll = this.getAttackingEntity();
        if (llllllllllllllllllIlllIIIIIIlIll != null) {
            final EntityList.EntityEggInfo llllllllllllllllllIlllIIIIIIlIlI = EntityList.ENTITY_EGGS.get(EntityList.func_191301_a(llllllllllllllllllIlllIIIIIIlIll));
            if (llllllllllllllllllIlllIIIIIIlIlI != null) {
                this.addStat(llllllllllllllllllIlllIIIIIIlIlI.entityKilledByStat);
            }
            llllllllllllllllllIlllIIIIIIlIll.func_191956_a(this, this.scoreValue, llllllllllllllllllIlllIIIIIlIIII);
        }
        this.addStat(StatList.DEATHS);
        this.takeStat(StatList.TIME_SINCE_DEATH);
        this.extinguish();
        this.setFlag(0, false);
        this.getCombatTracker().reset();
    }
    
    public void onUpdateEntity() {
        try {
            super.onUpdate();
            for (int llllllllllllllllllIlllIIIIllIIlI = 0; llllllllllllllllllIlllIIIIllIIlI < this.inventory.getSizeInventory(); ++llllllllllllllllllIlllIIIIllIIlI) {
                final ItemStack llllllllllllllllllIlllIIIIllIIIl = this.inventory.getStackInSlot(llllllllllllllllllIlllIIIIllIIlI);
                if (!llllllllllllllllllIlllIIIIllIIIl.func_190926_b() && llllllllllllllllllIlllIIIIllIIIl.getItem().isMap()) {
                    final Packet<?> llllllllllllllllllIlllIIIIllIIII = ((ItemMapBase)llllllllllllllllllIlllIIIIllIIIl.getItem()).createMapDataPacket(llllllllllllllllllIlllIIIIllIIIl, this.world, this);
                    if (llllllllllllllllllIlllIIIIllIIII != null) {
                        this.connection.sendPacket(llllllllllllllllllIlllIIIIllIIII);
                    }
                }
            }
            if (this.getHealth() != this.lastHealth || this.lastFoodLevel != this.foodStats.getFoodLevel() || this.foodStats.getSaturationLevel() == 0.0f != this.wasHungry) {
                this.connection.sendPacket(new SPacketUpdateHealth(this.getHealth(), this.foodStats.getFoodLevel(), this.foodStats.getSaturationLevel()));
                this.lastHealth = this.getHealth();
                this.lastFoodLevel = this.foodStats.getFoodLevel();
                this.wasHungry = (this.foodStats.getSaturationLevel() == 0.0f);
            }
            if (this.getHealth() + this.getAbsorptionAmount() != this.lastHealthScore) {
                this.lastHealthScore = this.getHealth() + this.getAbsorptionAmount();
                this.updateScorePoints(IScoreCriteria.HEALTH, MathHelper.ceil(this.lastHealthScore));
            }
            if (this.foodStats.getFoodLevel() != this.lastFoodScore) {
                this.lastFoodScore = this.foodStats.getFoodLevel();
                this.updateScorePoints(IScoreCriteria.FOOD, MathHelper.ceil((float)this.lastFoodScore));
            }
            if (this.getAir() != this.lastAirScore) {
                this.lastAirScore = this.getAir();
                this.updateScorePoints(IScoreCriteria.AIR, MathHelper.ceil((float)this.lastAirScore));
            }
            if (this.getTotalArmorValue() != this.lastArmorScore) {
                this.lastArmorScore = this.getTotalArmorValue();
                this.updateScorePoints(IScoreCriteria.ARMOR, MathHelper.ceil((float)this.lastArmorScore));
            }
            if (this.experienceTotal != this.lastExperienceScore) {
                this.lastExperienceScore = this.experienceTotal;
                this.updateScorePoints(IScoreCriteria.XP, MathHelper.ceil((float)this.lastExperienceScore));
            }
            if (this.experienceLevel != this.lastLevelScore) {
                this.lastLevelScore = this.experienceLevel;
                this.updateScorePoints(IScoreCriteria.LEVEL, MathHelper.ceil((float)this.lastLevelScore));
            }
            if (this.experienceTotal != this.lastExperience) {
                this.lastExperience = this.experienceTotal;
                this.connection.sendPacket(new SPacketSetExperience(this.experience, this.experienceTotal, this.experienceLevel));
            }
            if (this.ticksExisted % 20 == 0) {
                CriteriaTriggers.field_192135_o.func_192215_a(this);
            }
        }
        catch (Throwable llllllllllllllllllIlllIIIIlIllll) {
            final CrashReport llllllllllllllllllIlllIIIIlIlllI = CrashReport.makeCrashReport(llllllllllllllllllIlllIIIIlIllll, "Ticking player");
            final CrashReportCategory llllllllllllllllllIlllIIIIlIllIl = llllllllllllllllllIlllIIIIlIlllI.makeCategory("Player being ticked");
            this.addEntityCrashInfo(llllllllllllllllllIlllIIIIlIllIl);
            throw new ReportedException(llllllllllllllllllIlllIIIIlIlllI);
        }
    }
    
    @Override
    public boolean isSpectator() {
        return this.interactionManager.getGameType() == GameType.SPECTATOR;
    }
    
    public RecipeBookServer func_192037_E() {
        return this.field_192041_cq;
    }
    
    private void sendTileEntityUpdate(final TileEntity llllllllllllllllllIllIlllIlIlIII) {
        if (llllllllllllllllllIllIlllIlIlIII != null) {
            final SPacketUpdateTileEntity llllllllllllllllllIllIlllIlIlIlI = llllllllllllllllllIllIlllIlIlIII.getUpdatePacket();
            if (llllllllllllllllllIllIlllIlIlIlI != null) {
                this.connection.sendPacket(llllllllllllllllllIllIlllIlIlIlI);
            }
        }
    }
    
    public boolean func_193105_t() {
        return this.field_193109_cv;
    }
    
    @Override
    public void func_192022_b(final List<IRecipe> llllllllllllllllllIllIlIIlllIIlI) {
        this.field_192041_cq.func_193834_b(llllllllllllllllllIllIlIIlllIIlI, this);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllllIllIllllIIllll, final float llllllllllllllllllIllIllllIIlllI) {
        if (this.isEntityInvulnerable(llllllllllllllllllIllIllllIIllll)) {
            return false;
        }
        final boolean llllllllllllllllllIllIllllIIllIl = this.mcServer.isDedicatedServer() && this.canPlayersAttack() && "fall".equals(llllllllllllllllllIllIllllIIllll.damageType);
        if (!llllllllllllllllllIllIllllIIllIl && this.respawnInvulnerabilityTicks > 0 && llllllllllllllllllIllIllllIIllll != DamageSource.outOfWorld) {
            return false;
        }
        if (llllllllllllllllllIllIllllIIllll instanceof EntityDamageSource) {
            final Entity llllllllllllllllllIllIllllIIllII = llllllllllllllllllIllIllllIIllll.getEntity();
            if (llllllllllllllllllIllIllllIIllII instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)llllllllllllllllllIllIllllIIllII)) {
                return false;
            }
            if (llllllllllllllllllIllIllllIIllII instanceof EntityArrow) {
                final EntityArrow llllllllllllllllllIllIllllIIlIll = (EntityArrow)llllllllllllllllllIllIllllIIllII;
                if (llllllllllllllllllIllIllllIIlIll.shootingEntity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)llllllllllllllllllIllIllllIIlIll.shootingEntity)) {
                    return false;
                }
            }
        }
        return super.attackEntityFrom(llllllllllllllllllIllIllllIIllll, llllllllllllllllllIllIllllIIlllI);
    }
    
    @Override
    public void func_192021_a(final List<IRecipe> llllllllllllllllllIllIlIlIIIlIlI) {
        this.field_192041_cq.func_193835_a(llllllllllllllllllIllIlIlIIIlIlI, this);
    }
    
    @Override
    public void onItemPickup(final Entity llllllllllllllllllIllIlllIIlllll, final int llllllllllllllllllIllIlllIIllllI) {
        super.onItemPickup(llllllllllllllllllIllIlllIIlllll, llllllllllllllllllIllIlllIIllllI);
        this.openContainer.detectAndSendChanges();
    }
    
    public void func_193104_a(final EntityPlayerMP llllllllllllllllllIllIlIIlIlIlIl, final boolean llllllllllllllllllIllIlIIlIlIlll) {
        if (llllllllllllllllllIllIlIIlIlIlll) {
            this.inventory.copyInventory(llllllllllllllllllIllIlIIlIlIlIl.inventory);
            this.setHealth(llllllllllllllllllIllIlIIlIlIlIl.getHealth());
            this.foodStats = llllllllllllllllllIllIlIIlIlIlIl.foodStats;
            this.experienceLevel = llllllllllllllllllIllIlIIlIlIlIl.experienceLevel;
            this.experienceTotal = llllllllllllllllllIllIlIIlIlIlIl.experienceTotal;
            this.experience = llllllllllllllllllIllIlIIlIlIlIl.experience;
            this.setScore(llllllllllllllllllIllIlIIlIlIlIl.getScore());
            this.lastPortalPos = llllllllllllllllllIllIlIIlIlIlIl.lastPortalPos;
            this.lastPortalVec = llllllllllllllllllIllIlIIlIlIlIl.lastPortalVec;
            this.teleportDirection = llllllllllllllllllIllIlIIlIlIlIl.teleportDirection;
        }
        else if (this.world.getGameRules().getBoolean("keepInventory") || llllllllllllllllllIllIlIIlIlIlIl.isSpectator()) {
            this.inventory.copyInventory(llllllllllllllllllIllIlIIlIlIlIl.inventory);
            this.experienceLevel = llllllllllllllllllIllIlIIlIlIlIl.experienceLevel;
            this.experienceTotal = llllllllllllllllllIllIlIIlIlIlIl.experienceTotal;
            this.experience = llllllllllllllllllIllIlIIlIlIlIl.experience;
            this.setScore(llllllllllllllllllIllIlIIlIlIlIl.getScore());
        }
        this.xpSeed = llllllllllllllllllIllIlIIlIlIlIl.xpSeed;
        this.theInventoryEnderChest = llllllllllllllllllIllIlIIlIlIlIl.theInventoryEnderChest;
        this.getDataManager().set(EntityPlayerMP.PLAYER_MODEL_FLAG, (Byte)llllllllllllllllllIllIlIIlIlIlIl.getDataManager().get((DataParameter<T>)EntityPlayerMP.PLAYER_MODEL_FLAG));
        this.lastExperience = -1;
        this.lastHealth = -1.0f;
        this.lastFoodLevel = -1;
        this.field_192041_cq.func_193824_a(llllllllllllllllllIllIlIIlIlIlIl.field_192041_cq);
        this.entityRemoveQueue.addAll(llllllllllllllllllIllIlIIlIlIlIl.entityRemoveQueue);
        this.field_192040_cp = llllllllllllllllllIllIlIIlIlIlIl.field_192040_cp;
        this.field_193110_cw = llllllllllllllllllIllIlIIlIlIlIl.field_193110_cw;
        this.func_192029_h(llllllllllllllllllIllIlIIlIlIlIl.func_192023_dk());
        this.func_192031_i(llllllllllllllllllIllIlIIlIlIlIl.func_192025_dl());
    }
    
    public static void func_191522_a(final DataFixer llllllllllllllllllIlllIIIlllllII) {
        llllllllllllllllllIlllIIIlllllII.registerWalker(FixTypes.PLAYER, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lIllllIlIIlI, final NBTTagCompound lIllllIlIIIl, final int lIllllIlIlII) {
                if (lIllllIlIIIl.hasKey("RootVehicle", 10)) {
                    final NBTTagCompound lIllllIlIIll = lIllllIlIIIl.getCompoundTag("RootVehicle");
                    if (lIllllIlIIll.hasKey("Entity", 10)) {
                        lIllllIlIIll.setTag("Entity", lIllllIlIIlI.process(FixTypes.ENTITY, lIllllIlIIll.getCompoundTag("Entity"), lIllllIlIlII));
                    }
                }
                return lIllllIlIIIl;
            }
        });
    }
    
    @Override
    public boolean startRiding(final Entity llllllllllllllllllIllIllIlllllll, final boolean llllllllllllllllllIllIllIllllIIl) {
        final Entity llllllllllllllllllIllIllIlllllIl = this.getRidingEntity();
        if (!super.startRiding(llllllllllllllllllIllIllIlllllll, llllllllllllllllllIllIllIllllIIl)) {
            return false;
        }
        final Entity llllllllllllllllllIllIllIlllllII = this.getRidingEntity();
        if (llllllllllllllllllIllIllIlllllII != llllllllllllllllllIllIllIlllllIl && this.connection != null) {
            this.connection.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
        return true;
    }
    
    @Override
    protected void onChangedPotionEffect(final PotionEffect llllllllllllllllllIllIlIIlIIIllI, final boolean llllllllllllllllllIllIlIIlIIlIII) {
        super.onChangedPotionEffect(llllllllllllllllllIllIlIIlIIIllI, llllllllllllllllllIllIlIIlIIlIII);
        this.connection.sendPacket(new SPacketEntityEffect(this.getEntityId(), llllllllllllllllllIllIlIIlIIIllI));
        CriteriaTriggers.field_193139_z.func_193153_a(this);
    }
    
    @Override
    public void onCriticalHit(final Entity llllllllllllllllllIllIlIIIlIllll) {
        this.getServerWorld().getEntityTracker().sendToTrackingAndSelf(this, new SPacketAnimation(llllllllllllllllllIllIlIIIlIllll, 4));
    }
    
    @Override
    public void openEditSign(final TileEntitySign llllllllllllllllllIllIllIIllIllI) {
        llllllllllllllllllIllIllIIllIllI.setPlayer(this);
        this.connection.sendPacket(new SPacketSignEditorOpen(llllllllllllllllllIllIllIIllIllI.getPos()));
    }
    
    private void updateScorePoints(final IScoreCriteria llllllllllllllllllIlllIIIIlIIIIl, final int llllllllllllllllllIlllIIIIlIIIII) {
        for (final ScoreObjective llllllllllllllllllIlllIIIIIlllll : this.getWorldScoreboard().getObjectivesFromCriteria(llllllllllllllllllIlllIIIIlIIIIl)) {
            final Score llllllllllllllllllIlllIIIIIllllI = this.getWorldScoreboard().getOrCreateScore(this.getName(), llllllllllllllllllIlllIIIIIlllll);
            llllllllllllllllllIlllIIIIIllllI.setScorePoints(llllllllllllllllllIlllIIIIlIIIII);
        }
    }
    
    @Override
    public void onUpdate() {
        this.interactionManager.updateBlockRemoving();
        --this.respawnInvulnerabilityTicks;
        if (this.hurtResistantTime > 0) {
            --this.hurtResistantTime;
        }
        this.openContainer.detectAndSendChanges();
        if (!this.world.isRemote && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        while (!this.entityRemoveQueue.isEmpty()) {
            final int llllllllllllllllllIlllIIIlIIIIIl = Math.min(this.entityRemoveQueue.size(), Integer.MAX_VALUE);
            final int[] llllllllllllllllllIlllIIIlIIIIII = new int[llllllllllllllllllIlllIIIlIIIIIl];
            final Iterator<Integer> llllllllllllllllllIlllIIIIllllll = this.entityRemoveQueue.iterator();
            int llllllllllllllllllIlllIIIIlllllI = 0;
            while (llllllllllllllllllIlllIIIIllllll.hasNext() && llllllllllllllllllIlllIIIIlllllI < llllllllllllllllllIlllIIIlIIIIIl) {
                llllllllllllllllllIlllIIIlIIIIII[llllllllllllllllllIlllIIIIlllllI++] = llllllllllllllllllIlllIIIIllllll.next();
                llllllllllllllllllIlllIIIIllllll.remove();
            }
            this.connection.sendPacket(new SPacketDestroyEntities(llllllllllllllllllIlllIIIlIIIIII));
        }
        final Entity llllllllllllllllllIlllIIIIllllIl = this.getSpectatingEntity();
        if (llllllllllllllllllIlllIIIIllllIl != this) {
            if (llllllllllllllllllIlllIIIIllllIl.isEntityAlive()) {
                this.setPositionAndRotation(llllllllllllllllllIlllIIIIllllIl.posX, llllllllllllllllllIlllIIIIllllIl.posY, llllllllllllllllllIlllIIIIllllIl.posZ, llllllllllllllllllIlllIIIIllllIl.rotationYaw, llllllllllllllllllIlllIIIIllllIl.rotationPitch);
                this.mcServer.getPlayerList().serverUpdateMovingPlayer(this);
                if (this.isSneaking()) {
                    this.setSpectatingEntity(this);
                }
            }
            else {
                this.setSpectatingEntity(this);
            }
        }
        CriteriaTriggers.field_193135_v.func_193182_a(this);
        if (this.field_193107_ct != null) {
            CriteriaTriggers.field_193133_t.func_193162_a(this, this.field_193107_ct, this.ticksExisted - this.field_193108_cu);
        }
        this.field_192042_bX.func_192741_b(this);
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllllIllIlIIIIIlIIl, final String llllllllllllllllllIllIlIIIIIlIII) {
        if ("seed".equals(llllllllllllllllllIllIlIIIIIlIII) && !this.mcServer.isDedicatedServer()) {
            return true;
        }
        if ("tell".equals(llllllllllllllllllIllIlIIIIIlIII) || "help".equals(llllllllllllllllllIllIlIIIIIlIII) || "me".equals(llllllllllllllllllIllIlIIIIIlIII) || "trigger".equals(llllllllllllllllllIllIlIIIIIlIII)) {
            return true;
        }
        if (!this.mcServer.getPlayerList().canSendCommands(this.getGameProfile())) {
            return false;
        }
        final UserListOpsEntry llllllllllllllllllIllIlIIIIIIlll = this.mcServer.getPlayerList().getOppedPlayers().getEntry(this.getGameProfile());
        if (llllllllllllllllllIllIlIIIIIIlll != null) {
            return llllllllllllllllllIllIlIIIIIIlll.getPermissionLevel() >= llllllllllllllllllIllIlIIIIIlIIl;
        }
        return this.mcServer.getOpPermissionLevel() >= llllllllllllllllllIllIlIIIIIlIIl;
    }
    
    public PlayerAdvancements func_192039_O() {
        return this.field_192042_bX;
    }
    
    public WorldServer getServerWorld() {
        return (WorldServer)this.world;
    }
    
    public long getLastActiveTime() {
        return this.playerLastActiveTime;
    }
}
