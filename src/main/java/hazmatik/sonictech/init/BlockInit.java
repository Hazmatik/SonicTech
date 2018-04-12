package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.blocks.BlockOreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORE = new BlockOreBase("ore", Material.ROCK, 3.0f, "pickaxe", 2);
}
