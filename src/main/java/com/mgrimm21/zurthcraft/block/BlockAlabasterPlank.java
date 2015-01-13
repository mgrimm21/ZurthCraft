package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Names;

public class BlockAlabasterPlank extends BlockZurthCraft{

	 public BlockAlabasterPlank() {
		super(Material.wood);
		this.setBlockName(Names.ALABASTERPLANK);
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}
}
