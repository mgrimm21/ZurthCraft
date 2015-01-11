package com.mgrimm21.zurthcraft.tileentity;

import com.mgrimm21.zurthcraft.init.ModBlocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySkillAltar extends TileEntity {
	private World world;
	@Override
	public void updateEntity() {
		super.updateEntity();
		boolean canform = false;
		for (int x = -1; x < 1; x++){
			for (int z = -1; z < 1; z++) {
				if (this.getWorldObj().getBlock(xCoord, yCoord, zCoord) != ModBlocks.skillaltar) {
					canform = false;
			break;
		}
			}
		}
		 if (!canform) this.getWorldObj().setTileEntity(xCoord, yCoord, zCoord, new TileEntityCompleteSkillAltar());
	}

	public TileEntitySkillAltar(World world) {
		this.world = world;
	}
	
}
