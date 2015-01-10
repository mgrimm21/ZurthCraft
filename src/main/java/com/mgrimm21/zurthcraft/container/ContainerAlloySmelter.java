package com.mgrimm21.zurthcraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

import com.mgrimm21.zurthcraft.client.gui.slot.SlotAlloySmelter;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAlloySmelter extends Container {
	
	private TileEntityAlloySmelter masher;
	private int dualCookTime;
	private int dualPower;
	private int lastItemBurnTime;
	private int lavastored;
	private int waterstored;
	
	public ContainerAlloySmelter(InventoryPlayer inv, TileEntityAlloySmelter teas) {
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		masher = teas;
		this.waterstored = teas.waterstored;
		this.lavastored = teas.lavastored;
		this.addSlotToContainer(new Slot(teas, 0, 8, 64)); //WATER IN
		this.addSlotToContainer(new Slot(teas, 1, 26, 64)); //WATER OUT
		this.addSlotToContainer(new Slot(teas, 2, 44, 64)); //LAVA IN
		this.addSlotToContainer(new Slot(teas, 3, 62, 64)); //LAVA OUT
		this.addSlotToContainer(new Slot(teas, 4, 142, 64)); //BYPRODUCT OUT
		this.addSlotToContainer(new Slot(teas, 5, 80, 31)); //ITEM IN
		this.addSlotToContainer(new SlotAlloySmelter(inv.player, teas, 6, 121, 31)); //ITEM OUT
		this.addSlotToContainer(new Slot(teas, 7, 29, 164)); //UPGRADE SLOT 1
		this.addSlotToContainer(new Slot(teas, 8, 49, 164)); //UPGRADE SLOT 2
		this.addSlotToContainer(new Slot(teas, 9, 69, 164)); //UPGRADE SLOT 3
		this.addSlotToContainer(new Slot(teas, 10, 89, 164)); //UPGRADE SLOT 4
		this.addSlotToContainer(new Slot(teas, 11, 109, 164)); //UPGRADE SLOT 5
		this.addSlotToContainer(new Slot(teas, 12, 129, 164)); //UPGRADE SLOT 6
		//INVENTORY 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		//ACTION BAR
		for (int i = 0; i < 9; i++){ 
			this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
		}
		
		
		
		
	}
	public int getLavaRemainingScaled(int i) { return (this.lavastored * i) / Reference.MAXLAVA; }
	public int getWaterRemainingScaled(int i) {return (this.waterstored * i) / Reference.MAXWATER;}
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.waterstored != this.masher.waterstored)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.waterstored);
                LogHelper.info(this.waterstored);
            }

            if (this.lavastored != this.masher.lavastored)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.lavastored);
                LogHelper.info(this.lavastored);
            }
        }

        this.waterstored = this.masher.waterstored;
        this.lavastored = this.masher.lavastored;
    }
	
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		//crafting.sendProgressBarUpdate(this, 0, this.dualCookTime);
		//crafting.sendProgressBarUpdate(this, 1, this.dualPower);
		crafting.sendProgressBarUpdate(this,0 , this.waterstored);
		crafting.sendProgressBarUpdate(this, 2, this.lavastored);
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_)
    {
        if (p_75137_1_ == 0)
        {
            this.masher.waterstored = p_75137_2_;
        }

        if (p_75137_1_ == 2)
        {
            this.masher.lavastored = p_75137_2_;
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return masher.isUseableByPlayer(player);
	}

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
	
}
