package com.mgrimm21.zurthcraft.creativetab;

import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabZurthCraftMain {
	
	public static final CreativeTabs ZURTHRAFT_MAIN = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		
		@Override
		public Item getTabIconItem() {
			return ModItems.zurditeDust;
		}
		
		
	};
}
