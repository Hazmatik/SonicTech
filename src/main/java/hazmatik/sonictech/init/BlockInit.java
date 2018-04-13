package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.blocks.BlockBase;
import hazmatik.sonictech.blocks.BlockOreBase;
import hazmatik.sonictech.blocks.BlockChromititeBase;
import hazmatik.sonictech.blocks.BlockGneissBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORE = new BlockOreBase("ore");
	
	public static final Block CHROMITITE = new BlockBase("stone_chromitite", Material.ROCK, 10.0F, "pickaxe", 3);
	public static final Block CHROMITITE_BRICKS = new BlockChromititeBase("chromitite", 10.0F, "pickaxe", 3);
	public static final Block CHROMITITE_COBBLE = new BlockBase("chromitite_cobblestone", Material.ROCK, 6.0F, "pickaxe", 3);
	public static final Block GNEISS = new BlockBase("stone_gneiss", Material.ROCK, 3.0F, "pickaxe", 1);
	public static final Block GNEISS_BRICKS = new BlockGneissBase("gneiss", 3.0F, "pickaxe", 1);
	public static final Block GNEISS_COBBLE = new BlockBase("gneiss_cobblestone", Material.ROCK, 3.0F, "pickaxe", 1);
	
}
