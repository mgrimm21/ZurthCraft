package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Names;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileHollowMultiBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
public class BlockQuenchTank extends BlockMultiBlock {
public BlockQuenchTank() {
super(Material.rock);
this.setBlockName(Names.QUENCHTANK);
this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
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

@Override
public TileEntity createNewTileEntity(World world, int metadata) {
return new TileHollowMultiBlock();
}
}