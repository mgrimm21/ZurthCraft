package com.mgrimm21.zurthcraft.item.metal;

import java.util.List;

import com.mgrimm21.zurthcraft.item.ItemZurthCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemZincIngotSHG extends ItemZurthCraft{

	public ItemZincIngotSHG() {
		super();
		this.setUnlocalizedName("zincingotshg");
		this.maxStackSize = 64;
		
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Special High Grade: 99.99% pure");
	}
	
}
