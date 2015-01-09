package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElectrostaticGenerator extends BlockZurthCraft{

	public BlockElectrostaticGenerator() {
		super(Material.glass);
		this.setBlockName("electrostaticgenerator");
		this.setLightOpacity(20);
	}

	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
	
}
