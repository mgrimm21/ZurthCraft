package com.mgrimm21.zurthcraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.util.LogHelper;

public class BlockCableCopper extends BlockZurthCraft{

	
	public BlockCableCopper() {
		super();
		this.setBlockName("coppercable");
		this.setBlockBounds(0.4F, 0.4F, 0.0F, 0.6F, 0.6F, 1.0F);
		this.canBlockGrass = false;
		//LogHelper.info(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	
	/**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
	
	  public int onBlockPlaced(World world, int x, int y, 
			  int z, int side, float hitx, float hity, float hitz, int meta)
	    {
		  for (int xx = x - 1; xx < (x + 1); xx++) {
			  for (int yy = y - 1; yy < (y + 1); yy++) {
				  for (int zz = z - 1; zz < (z + 1); zz++) {
					  if (world.getBlock(xx, yy, zz) == ModBlocks.coppercable) {
						  this.setBlockBounds(0.0F, 0.4F, 0.4F, 1.0F, 0.6F, 0.6F);
						 
					  	} else {
					  		 this.setBlockBounds(0.4F, 0.4F, 0.0F, 0.6F, 0.6F, 1.0F);
					  	}
				  }
			  }
		  }
		  
		  
	        return meta;
	    }
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	//@SideOnly(Side.CLIENT)
    //public int getRenderBlockPass()
    //{
    //    return 1;
    //}
	
	public boolean isBlockSolid(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_)
    {
        return true;
    }
	
}
