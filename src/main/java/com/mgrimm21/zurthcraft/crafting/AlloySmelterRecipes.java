package com.mgrimm21.zurthcraft.crafting;

import com.mgrimm21.zurthcraft.init.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloySmelterRecipes {

	public AlloySmelterRecipes() {
		 
		
		
	}
	
	
	public static ItemStack getSmeltingResult(Item item) {return getOutput(item);}
	
	public static ItemStack getOutput(Item item) {
		if (item == ModItems.zurditeIngot) return new ItemStack(ModItems.zincingothg);
		if (item == ModItems.zurditeNugget) return new ItemStack(ModItems.zincnugget);
		
		
		
		
		
		return null;
	}
	
	public static boolean hasLiquidRequired(int water, int lava, ItemStack item) {
		if (item.getItem() == ModItems.zurditeIngot && lava > 999) return true;
		if (item.getItem() == ModItems.zurditeNugget && lava > 999) return true;
		if (item.getItem() == ModItems.zurditeDust && water > 999) return true;
		
		
		return false;
	}
	
	public static AlloySmelterLiquid getLiquidRequired(ItemStack item) {
		if (item.getItem() == ModItems.zurditeIngot) return AlloySmelterLiquid.lava;
		if (item.getItem() == ModItems.zurditeNugget) return AlloySmelterLiquid.lava;
		if (item.getItem() == ModItems.zurditeDust) return AlloySmelterLiquid.water;
		return AlloySmelterLiquid.none;
	}
	
}
