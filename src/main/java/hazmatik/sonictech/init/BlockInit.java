package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.blocks.BlockOreBase;
import hazmatik.sonictech.blocks.BlockSTLeaf;
import hazmatik.sonictech.blocks.BlockSTLeafB;
import hazmatik.sonictech.blocks.BlockSTLog;
import hazmatik.sonictech.blocks.BlockSTPlank;
import hazmatik.sonictech.blocks.BlockSTStone;
import hazmatik.sonictech.blocks.BlockMachineFrame;
import hazmatik.sonictech.blocks.BlockMetal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block STONE = new BlockSTStone("st_stone");
	public static final Block ORE = new BlockOreBase("ore");
	public static final Block BLOCK_METAL = new BlockMetal("block");
	public static final Block MACHINE_FRAME = new BlockMachineFrame("machine_frame");
	
	public static final Block PLANKS = new BlockSTPlank("planks");
	public static final Block LOGS = new BlockSTLog("log");
	public static final Block LEAVES_A = new BlockSTLeaf("leaves_a");
	public static final Block LEAVES_B = new BlockSTLeafB("leaves_b");
}
