package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import net.minecraft.item.Item;

import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.ConfigValues;
import com.mgrimm21.zurthcraft.reference.Names;

public class BlockZincOre extends BlockZurthCraft{
	
	public BlockZincOre() {
		this.setBlockName(Names.ZINCORE);
		this.setHardness(3.0F);
		this.setLightLevel(0.3F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}
