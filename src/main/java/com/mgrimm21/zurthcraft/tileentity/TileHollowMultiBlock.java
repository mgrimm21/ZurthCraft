package com.mgrimm21.zurthcraft.tileentity;

import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumDifficulty;
public class TileHollowMultiBlock extends TileMultiBlock {
public TileHollowMultiBlock() {};
private boolean hasdoneit = false;
private boolean isformed = false;
@Override
public void doMultiBlockStuff() {
// Sets diamond block 6 blocks above the master
//if (worldObj.isAirBlock(xCoord, yCoord + 6, zCoord))
//worldObj.setBlock(xCoord, yCoord + 6, zCoord, Blocks.diamond_block);
	
	//if (!hasdoneit) {
		//worldObj.setBlock(xCoord, yCoord + 6, zCoord, ModBlocks.blockofcopper);
		//hasdoneit = true;
	//}
	if(worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Blocks.iron_block) {
		LogHelper.info("IS IRON BLOCK");
		worldObj.setBlock(xCoord, yCoord + 1, zCoord, ModBlocks.blockofsteel);
	} else if (worldObj.getBlock(xCoord, yCoord + 1, zCoord) == ModBlocks.bauxiteore) {
		worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);
		worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.diamond_block);
	}
	
	//CHECKS MULTIBLOCK
	if (!checkMultiBlockForm()) {
		
		resetStructure();
		hasdoneit = false;
		isformed = false;
	}
	
	
}
    

@Override
public void masterWriteToNBT(NBTTagCompound tag) {
}
@Override
public void masterReadFromNBT(NBTTagCompound tag) {
}
@Override
public boolean checkMultiBlockForm() {
int i = 0;
// Scan a 3x3x3 area, starting with the bottom left corner
for (int x = xCoord - 1; x < xCoord + 2; x++)
for (int y = yCoord; y < yCoord + 3; y++)
for (int z = zCoord - 1; z < zCoord + 2; z++) {
TileEntity tile = worldObj.getTileEntity(x, y, z);
// Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock (if ours is already part of one)
if (tile != null && (tile instanceof TileHollowMultiBlock)) {
if (this.isMaster()) {
if (((TileHollowMultiBlock)tile).hasMaster())
i++;
} else if (!((TileHollowMultiBlock)tile).hasMaster())
i++;
}
}

if (worldObj.getBlock(xCoord, yCoord + 3, zCoord) != ModBlocks.electrostaticgenerator) {
	//LogHelper.info(worldObj.getBlock(xCoord, yCoord + 3, zCoord));
	return false;
}

// check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
//LogHelper.info(i == 26);
for (int zz = zCoord - 1; zz < zCoord + 2; zz++) {
	for (int xx = xCoord - 1; xx < xCoord + 2; xx++) {
		if (zz != zCoord & xx != xCoord) {
			if (!worldObj.isAirBlock(xx, yCoord + 3, zz)) {
				LogHelper.info("not air block");
				return false;
			}
		}
	}
}
if (!(i == 26 && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))) {
	//LogHelper.info("not 26");
} else {
	if (!isformed) {
		isformed = true;
		LogHelper.info("formed");
	}
	
}
return i == 26 && !worldObj.isAirBlock(xCoord, yCoord + 1, zCoord);
}
@Override
public void setupStructure() {
for (int x = xCoord - 1; x < xCoord + 2; x++)
for (int y = yCoord; y < yCoord + 3; y++)
for (int z = zCoord - 1; z < zCoord + 2; z++) {
TileEntity tile = worldObj.getTileEntity(x, y, z);
// Check if block is bottom center block
boolean master = (x == xCoord && y == yCoord && z == zCoord);
if (tile != null && (tile instanceof TileHollowMultiBlock)) {
((TileHollowMultiBlock) tile).setMasterCoords(xCoord, yCoord, zCoord);
((TileHollowMultiBlock) tile).setHasMaster(true);
((TileHollowMultiBlock) tile).setIsMaster(master);
}
}
}
@Override
public void resetStructure() {
for (int x = xCoord - 1; x < xCoord + 2; x++)
for (int y = yCoord; y < yCoord + 3; y++)
for (int z = zCoord - 1; z < zCoord + 2; z++) {
TileEntity tile = worldObj.getTileEntity(x, y, z);
if (tile != null && (tile instanceof TileMultiBlock))
((TileMultiBlock) tile).reset();
}
}
}