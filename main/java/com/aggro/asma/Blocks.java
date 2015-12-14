package com.aggro.asma;

import com.aggro.asma.blocks.NoteBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks {
	public static void main(){
		initBlock();
		registerBlock();
	}
	
	public static Block noteBlock = new NoteBlocks(Material.sponge);
	
	public static void initBlock(){
		
	}
	
	public static void registerBlock(){
		GameRegistry.registerBlock(noteBlock, noteBlock.getUnlocalizedName());
		
	}
}
