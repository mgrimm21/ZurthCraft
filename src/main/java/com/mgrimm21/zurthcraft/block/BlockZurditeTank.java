package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Names;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileEntityZurditeTank;
import com.mgrimm21.zurthcraft.util.LogHelper;

public class BlockZurditeTank extends BlockContainer{

	public BlockZurditeTank() {
		super(Material.iron);
		this.setBlockName(Names.ZURDITETANK);
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityZurditeTank();
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block1 = world.getBlock(x, y, z - 1);
			Block block2 = world.getBlock(x, y, z + 1);
			Block block3 = world.getBlock(x - 1, y, z);
			Block block4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if (block1.func_149730_j() && !block2.func_149730_j()) {
				b0 = 3;
			}
			if (block2.func_149730_j() && !block1.func_149730_j()) {
				b0 = 2;
			}
			if (block3.func_149730_j() && !block4.func_149730_j()) {
				b0 = 5;
			}
			if (block4.func_149730_j() && !block3.func_149730_j()) {
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			LogHelper.info("Set Direction");
		}
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
			int i = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (i == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if (i == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if (i == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if (i == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if (item.hasDisplayName()) {
			//((TileEntityAlloySmelter)world.getTileEntity(x, y, z)));
		}
	}
	
	public String getUnlocalizedName()
	{
	return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
	return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
