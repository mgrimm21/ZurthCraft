package com.mgrimm21.zurthcraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.mgrimm21.zurthcraft.block.BlockAlloySmelter;
import com.mgrimm21.zurthcraft.crafting.AlloySmelterLiquid;
import com.mgrimm21.zurthcraft.crafting.AlloySmelterRecipes;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.util.LogHelper;
import com.mojang.realmsclient.dto.PlayerInfo;

public class TileEntityAlloySmelter extends TileEntity implements ISidedInventory{
	private ItemStack slots[];
	private String customName;
	private int xx;
	private int yy;
	private int zz;
	private final int STACKLIMIT = 64;
	private final int SLOTSNUM = 6;
	private int currentfuelslot; //0 = water 1 = nothing 2 = lava
	private int lastfuelslot; //0 = water 1 = nothing 2 = lava
	private  AlloySmelterLiquid liquidused;
	public int lavastored;
	private final int MAXLAVA = Reference.MAXLAVA;
	public int waterstored;
	private final int MAXWATER = Reference.MAXWATER;
	private int cooktime;
	private boolean hasautomationupgrade = false;
	private final int speed = 100;
	private final int[] slots_top = new int[] {5}; 
	private final int[] slots_bottom = new int[] {1, 3, 4, 6};
	private final int[] slots_side = new int[] {0, 2};
	@Override
	public int[] getAccessibleSlotsFromSide(int i){return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);}
	public TileEntityAlloySmelter() {slots = new ItemStack[13];}
	@Override
	public int getSizeInventory() {return slots.length;}
	public int getLavaRemainingScaled(int i) { return (this.lavastored * i) / MAXLAVA; }
	public int getProgressScaled(int i) { return (cooktime * i) / this.speed; }
	public int getWaterRemainingScaled(int i) {return (this.waterstored * i) / MAXWATER;}
	@Override
	public ItemStack getStackInSlot(int i) {
		try{
			return slots[i];
		} catch(NullPointerException e){
			LogHelper.info(e);
			return null;
		}
		
	}
	public void checkUpgrades() {
		for (int i = 7; i < 11; i++) {
			Item item = slots[i].getItem();
			if (item == null) hasautomationupgrade = false;
			if (item == ModItems.automationupgrade){
				hasautomationupgrade = true;
				break;
			} else {
				hasautomationupgrade = false;
				 
			}
		}
	}
	public boolean hasUpgrades() {
		for (int i = 7; i < slots.length - 1; i++) {
			if (slots[i] == null) return false;
			Item item = slots[i].getItem();
			if (item == ModItems.automationupgrade){
				return true;
			}
		}
		return false;
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (slots[slot] != null) {
			ItemStack itemstack = slots[slot];
			slots[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}
	public String getInventoryName() {return this.hasCustomInventoryName() ? this.customName : "container.alloysmelter";}
	public boolean hasCustomInventoryName() {return this.customName != null && this.customName.length() > 0;}
	public void setGuiDisplayName(String name) {this.customName = name;}
	public int getInventoryStackLimit() {return this.STACKLIMIT;}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			
			return false;
		} else {
			return player.getDistanceSq((double)xCoord + 0.5D,(double) yCoord + 0.5D,(double) zCoord + 0.5D) <= 64;
		}
	}
	public void openInventory() {}
	public void closeInventory() {}
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		if (slot == 0 && item.getItem() == Items.water_bucket) return true;
		if (slot == 2 && item.getItem() == Items.lava_bucket) return true;
		return false;
	}
	public boolean isItemFuel(ItemStack item) {return true;} //{return getItemFuelAmount(item) > 0;}
	public int getItemFuelAmount(ItemStack item) {
		if (item == null) {
			return 0;
		} else {
			Item itemn = item.getItem();
			int fs = currentfuelslot;
			lastfuelslot = fs;
			currentfuelslot = 0;
			if (itemn == Items.lava_bucket && currentfuelslot == 2) return 1000;
			if (itemn == Items.water_bucket && currentfuelslot == 0) return 1000;
			return 0;
		}
	}
	
	public ItemStack decrStackSize(int i, int j) {
		if (i > 6) {
			if (!hasUpgrades()) {
				this.hasautomationupgrade = false;
			}
		}
		if (slots[i] != null) {
			if (slots[i].stackSize <= j) {
				ItemStack itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}
			
			ItemStack itemstack1 = slots[i].splitStack(j);
			if (slots[i].stackSize == 0) {
				slots[i] = null;
			}
			return itemstack1;
		} else {
			return null;
		}
		
	}
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
			
			if (b0 >= 0 && b0 < slots.length) {
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		this.lavastored = nbt.getShort("LavaStored");
		this.waterstored = nbt.getShort("WaterStored");
		cooktime = nbt.getShort("CookTime");
	}
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("LavaStored", (short)this.lavastored);
		nbt.setShort("WaterStored",(short)this.waterstored);
		nbt.setShort("CookTime", (short)cooktime);
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < slots.length; i++) {
		if(slots[i] != null) {
			NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		nbt.setTag("Items", list);
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		if (side == 0) return false;
		if (slot == 0 && itemstack.getItem() == Items.water_bucket) return true;
		if (slot == 0 && itemstack.getItem() != Items.water_bucket) return false;
		if (slot == 2 && itemstack.getItem() == Items.lava_bucket) return true;
		if (slot == 2 && itemstack.getItem() != Items.lava_bucket) return false;
	return false;
			 
		//return this.isItemValidForSlot(var1, itemstack);
	}

	
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		if (side != 0) return false;
		for (int i = 7; i < slots.length; i++) {
			if (slots[i] != null) {
				if (slots[i].getItem() == ModItems.automationupgrade) return true;
			}
		}
		return false;
		
		//if (side != 0) {
		//	return false;
		//} 
		//if (slot == 1 || slot == 3 || slot == 4) {
		//	return true;
		//} else if (slot == 6 && hasUpgrades()){
		//	return true;
		//}
	
	
	//return false;
	}
	private boolean canSmelt() {
		//CHECKS FOR ITEM IN SMELTING INPUT SLOT - RETURNS FALSE IF EMPTY
		if (slots[5] == null) return false;
		//SETS ITEMSTACK TO THE ITEM IN THE SMELTING INPUT SLOT
		ItemStack itemstack = AlloySmelterRecipes.getSmeltingResult(slots[5].getItem());
		//IF THE ITEMSTACK IS NULL RETURNS FALSE
		if (itemstack == null) return false;
		//CHECKS TO SEE IF THE REQUIRED AMOUNT OF LIQUID NEEDED FOR THE CRAFTING OPERATION IS PRESENT, BREAKS THE
		//CODE IF NOT
		if (!AlloySmelterRecipes.hasLiquidRequired(waterstored, lavastored, itemstack)) {
			return false;
		}
		//CHECKS TO SEE IF THE OUTPUT SLOT IS EMPTY
		if (slots[6] == null) return true;
		//IF THE OUTPUT SLOT WAS NOT EMPTY CHECKS IF IT IS THE ITEM IT IS ABLE TO SMELT
		if (!slots[6].isItemEqual(itemstack)) return false;
		if (slots[6].stackSize < getInventoryStackLimit() && slots[6].stackSize < slots[6].getMaxStackSize()) return true;
		return slots[6].stackSize < itemstack.getMaxStackSize();
	}
	private void smeltItem() {
		if (canSmelt()) {
			ItemStack itemstack = AlloySmelterRecipes.getSmeltingResult(slots[5].getItem());
			liquidused = AlloySmelterRecipes.getLiquidRequired(itemstack);
			if (slots[6] == null) {
				slots[6] = itemstack.copy();
			} else if (slots[6].isItemEqual(itemstack)) {
				slots[6].stackSize += itemstack.stackSize;
			}
			//MIGHT NEED CHANGED
			for (int i = 5; i < 7; i++) {
				if (slots[i].stackSize <= 0) {
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				} else {
					slots[i].stackSize--;
				}
				
				if (slots[i].stackSize <= 0) {
					slots[i] = null;
				}
				
			}
			
		}
	}
	public boolean isSmelting() {return this.cooktime > 0;}
	public void updateEntity() {
		boolean addedlava = false;
		boolean addedWater = false;
		boolean removedWater = false;
		boolean removedLava = false;
		boolean flag = false;
		boolean flag2 =false;
		//checkUpgrades();
		if (!worldObj.isRemote){
		if (this.isSmelting()) {
			if (this.liquidused != AlloySmelterLiquid.none) {
				if (this.liquidused == AlloySmelterLiquid.lava) {
					this.lavastored -= 1000;
					LogHelper.info("-1000 lava");
				}
				if (this.liquidused == AlloySmelterLiquid.water) {
					this.waterstored -= 1000;
					LogHelper.info("-1000 water");	
				}
			}
		}
		
		if (canSmelt()) {
			cooktime++;
			
			if(this.cooktime == this.speed) {
				this.cooktime = 0;
				this.smeltItem();
				flag = true;
			} else {
				cooktime = 0;
			}
			if (this.waterstored == 0 && this.lavastored == 0) flag = true;
			BlockAlloySmelter.updateBlockState(isSmelting(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		
	if (!isWaterFull()){
		if (this.slots[0] != null) {
			this.waterstored += 1000;
			addedWater = true;
			LogHelper.info("+1000 water");
			LogHelper.info(waterstored);
			LogHelper.info(this);
			this.slots[0] = null;
			if (this.slots[1] == null) {
				this.slots[1] = new ItemStack(Items.bucket);
			} else if (this.slots[1].getItem() == Items.bucket) {
				if (this.slots[1].stackSize < 16) this.slots[1].stackSize++;
			}
			
		}
		flag = true;
	}
	if (!isLavaFull()){
		if (this.slots[2] != null) {
			this.lavastored += 1000;
			addedlava = true;
			LogHelper.info("+1000 lava");
			LogHelper.info(lavastored);
			LogHelper.info(this);
			this.slots[2] = null;
			if (this.slots[3] == null) {
				this.slots[3] = new ItemStack(Items.bucket);
			} else if (this.slots[3].getItem() == Items.bucket) {
				if (this.slots[3].stackSize < 16) this.slots[3].stackSize++;
			}
			
			
		}
		flag = true;
	}
		}
		if (flag) this.markDirty();
		
		if (hasUpgrades()) {
			if (worldObj.getBlock(xCoord + 1, yCoord, zCoord) == Blocks.chest) {
				Item item = slots[6].getItem();
			}
		}
		
		
	}
	public boolean anyUsableLiquidPresent() {return anyUsableLavaInTank() || anyUsableWaterInTank();}
	public boolean anyUsableLavaInTank() {return lavastored >= 1000;}
	public boolean anyUsableWaterInTank() {return waterstored >= 1000;}
	public boolean areTanksFull() {return isWaterFull() && isLavaFull();}
	public boolean isWaterFull() {return waterstored >= MAXWATER;}
	public boolean isLavaFull() {return lavastored == MAXLAVA;}
	public boolean hasLavaInTank() {return lavastored > 0;}
	public boolean hasWaterInTank() {return waterstored > 0;}
}