package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Names;
import com.mgrimm21.zurthcraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAlabasterSapling extends BlockSapling implements IGrowable{
	
	public BlockAlabasterSapling() {
		this.setBlockName(Names.ALABASTERSAPLING);
		this.setHardness(2.2F);
		this.setLightOpacity(255);
		this.setHarvestLevel("axe", 1);
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}
	@Override
	public String getUnlocalizedName()
	{
	return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
	blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
	return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
		
	
}
