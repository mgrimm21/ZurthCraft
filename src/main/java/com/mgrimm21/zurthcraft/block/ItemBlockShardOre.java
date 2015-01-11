package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockShardOre extends ItemBlock{

	public ItemBlockShardOre(Block block) {
		super(block);
		this.setHasSubtypes(true);
		
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		String name;
		switch(is.getItemDamage()) {
		case 0 : name = "earthshard"; break;
		case 1 : name = "watershard"; break;
		case 2 : name = "fireshard"; break;
		case 3 : name = "airshard"; break;
		case 4 : name = "voidshard"; break;
		case 5 : name = "satanicshard"; break;
		default : name = "heavenlyshard"; break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	
	
	
}
