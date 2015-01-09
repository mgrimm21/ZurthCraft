package com.mgrimm21.zurthcraft.item.metal.steel;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.mgrimm21.zurthcraft.item.ItemZurthCraft;

public class ItemSteelIngotFluxed extends ItemZurthCraft{

	public ItemSteelIngotFluxed() {
		super();
		this.setUnlocalizedName("steelingotfluxed");
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Fluxed");
	}
	
}