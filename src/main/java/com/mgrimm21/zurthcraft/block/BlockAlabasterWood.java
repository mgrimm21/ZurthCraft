package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.material.Material;

public class BlockAlabasterWood extends BlockZurthCraft{

	public BlockAlabasterWood() {
		super(Material.wood);
		this.setHarvestLevel("axe", 1);
		this.setBlockName("alabasterwood");
	}
	
}
