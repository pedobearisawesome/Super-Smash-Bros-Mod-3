package com.aggro.asma.blocks;

import java.util.Random;

import com.aggro.asma.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockStage extends Block {

	public BlockStage(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockUnbreakable().setBlockName("StageCore").setLightLevel(16).setBlockTextureName(Main.MODID + ":" + "centerpiece").setCreativeTab(CreativeTabs.tabCombat);
	}
	 @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	    {
		 int songcooldown = 0;
	        if (songcooldown == 0)
	        {
	            world.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
	            songcooldown = 50;
	        
	        }else{
	        	songcooldown--;
	        }
	    }
	 public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
	    {
	        if (p_149670_5_.ridingEntity == null && p_149670_5_.riddenByEntity == null)
	        {
	            p_149670_5_.setFire(5);
	        }
	    }
}
