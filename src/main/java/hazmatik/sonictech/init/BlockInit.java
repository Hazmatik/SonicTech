package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.blocks.BlockOreBase;
import hazmatik.sonictech.blocks.BlockSTStone;
import hazmatik.sonictech.blocks.SlabChromitite;
import hazmatik.sonictech.blocks.SlabChromititeBrick;
import hazmatik.sonictech.blocks.SlabGneiss;
import hazmatik.sonictech.blocks.SlabGneissBrick;
import hazmatik.sonictech.blocks.BlockMachineFrame;
import hazmatik.sonictech.blocks.BlockMetal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block STONE = new BlockSTStone("st_stone");
	public static final Block ORE = new BlockOreBase("ore");
	public static final Block BLOCK_METAL = new BlockMetal("block");
	public static final Block MACHINE_FRAME = new BlockMachineFrame("machine_frame");
	
}
