package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.reference.Names;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileEntitySkillAltar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSkillAltar extends BlockContainer {

        public BlockSkillAltar() {
		super(Material.wood);
		 this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.69F, 1.0F);
		 this.setBlockName(Names.SKILLALTAR);
	}
        
        public TileEntity createNewTileEntity(World world) {
                return new TileEntitySkillAltar();
        }
       
        @Override
        public int getRenderType() {
                return -1;
        }
       
        @Override
        public boolean isOpaqueCube() {
                return false;
        }
       
        public boolean renderAsNormalBlock() {
                return false;
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
		public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
			 return new TileEntitySkillAltar();
		}

}
