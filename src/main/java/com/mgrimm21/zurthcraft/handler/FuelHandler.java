package com.mgrimm21.zurthcraft.handler;

import com.mgrimm21.zurthcraft.init.ModItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if (fuel.getItem() == ModItems.zurditeDust) return 400;
		
		
		return 0;
	}
}
