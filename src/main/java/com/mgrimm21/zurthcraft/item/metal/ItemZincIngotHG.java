package com.mgrimm21.zurthcraft.item.metal;

import java.util.List;

import com.mgrimm21.zurthcraft.item.ItemZurthCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemZincIngotHG extends ItemZurthCraft{

	public ItemZincIngotHG() {
		super();
		this.setUnlocalizedName("zincingothg");
		this.maxStackSize = 64;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("High Grade: 99.95% pure");
	}
	
}
