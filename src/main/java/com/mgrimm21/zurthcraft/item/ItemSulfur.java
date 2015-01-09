package com.mgrimm21.zurthcraft.item;

import com.mgrimm21.zurthcraft.init.ModItems;

public class ItemSulfur extends ItemZurthCraft{

	public ItemSulfur() {
		super();
		this.setUnlocalizedName("sulfur");
		this.maxStackSize = 64;
		this.setContainerItem(ModItems.zurditeIngot);
	}
	
}
