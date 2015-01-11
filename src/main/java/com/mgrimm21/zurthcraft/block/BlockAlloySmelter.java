package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.zurthcraft;
import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.reference.GuiID;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAlloySmelter extends BlockContainer{

	private Random rnd;
	private final boolean isActive;
	private static boolean keepInventory = false;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	private IIcon iconSide;
	
	private final int MAXLAVA = 4000;
	private final int MAXWATER = 4000;
	
	public BlockAlloySmelter(boolean blockState) {
		super(Material.iron);
		this.setHardness(2.2F);
		this.setLightOpacity(255);
		this.setHarvestLevel("pickaxe", 1);
		if (!blockState) {
			this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
		}
		rnd = new Random();
		isActive = blockState;
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
	blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" +  (this.isActive ? "alloysmeltersideon" : "alloysmeltersideoff"));
	iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "alloysmelterfronton" : "alloysmelterfrontoff"));
	//LogHelper.info(Reference.MOD_ID + (this.isActive ? "alloysmelterfronton" : "alloysmelterfrontoff"));
	//LogHelper.info(Reference.MOD_ID + (this.isActive ? "alloysmeltersideon" : "alloysmeltersideoff"));
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
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
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		
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
		
		if (itemstack.hasDisplayName()) {
			//((TileEntityAlloySmelter)world.getTileEntity(x, y, z)));
		}
		
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			LogHelper.info("is remote");
			return true;
		} else if(!player.isSneaking()) {
			TileEntityAlloySmelter entity = (TileEntityAlloySmelter)  world.getTileEntity(x, y, z);
			if (entity != null) {
				LogHelper.info("Opening GUI");
				FMLNetworkHandler.openGui(player, zurthcraft.instance, GuiID.ALLOYSMELTER.ordinal(), world, x, y, z);
				LogHelper.info("gui opened, returning true.");
				return true;
				
			}
			
		} else {
			LogHelper.info("is sneaking");
			return false;
		}
		return false;
	}
	
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
	return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		LogHelper.info("Creating Tile Entity");
		return new TileEntityAlloySmelter();
	}
	
	
	
	public static void updateBlockState(boolean issmelting, World world, int x, int y, int z) {
		int i = world.getBlockMetadata(x, y, z);
		TileEntity entity = world.getTileEntity(x, y, z);
		keepInventory = true;
		
		if (issmelting) {
			world.setBlock(x, y, z, ModBlocks.alloysmelteractive);
		}else {
			world.setBlock(x, y, z, ModBlocks.alloysmelteridle);
		}
		
		keepInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
		
		if (entity != null) {
			entity.validate();
			world.setTileEntity(x, y, z, entity);
		}
	}
}
