package com.aggro.asma.blocks;

import com.aggro.asma.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class NoteBlocks extends Block{
	public NoteBlocks(Material p_i45394_1_) {
		super(p_i45394_1_);
		new NoteBlocks(Material.sponge).setBlockName("NoteBlock").setCreativeTab(CreativeTabs.tabMisc).setBlockTextureName(Main.MODID + ":" + "NoteBlock");
		// TODO Auto-generated constructor stub
	}
}
