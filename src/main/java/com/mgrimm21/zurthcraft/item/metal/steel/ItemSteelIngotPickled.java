package com.mgrimm21.zurthcraft.item.metal.steel;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.mgrimm21.zurthcraft.item.ItemZurthCraft;

public class ItemSteelIngotPickled extends ItemZurthCraft{

	public ItemSteelIngotPickled() {
		super();
		this.setUnlocalizedName("steelingotpickled");
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Pickled");
	}
	
}