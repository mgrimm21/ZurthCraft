package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.reference.Reference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockElectricFurnace extends BlockZurthCraft{
	
	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;
	public IIcon Side3;
	public IIcon Side4;
	public IIcon Side5;
	

	public BlockElectricFurnace() {
		super();
		this.setBlockName("electricfurnace");
	}
	
	@Override
	public void registerBlockIcons(IIconRegister Icon) {
		Side0 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Bottom");
		Side1 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Top");
		Side2 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Left");
		Side3 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Right");
		Side4 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Front");
		Side5 = Icon.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "Back");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		
		if (side == 0){
			return Side0;
		} else if (side == 1) {
			return Side1;
		} else if (side == 2) {
			return Side2;
		}else if (side == 3) {
			return Side3;
		}else if (side == 4) {
			return Side4;
		}else if (side == 5) {
			return Side5;
		} else {
			return null;
		}
		
	}
	
	
	
	
	
 }
