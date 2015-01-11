package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Names;

import net.minecraft.block.material.Material;

public class BlockAlabasterWood extends BlockZurthCraft{

	public BlockAlabasterWood() {
		super(Material.wood);
		this.setHarvestLevel("axe", 1);
		this.setBlockName(Names.ALABASTERWOOD);
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}
	
}
