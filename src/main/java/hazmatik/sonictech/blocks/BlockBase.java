package hazmatik.sonictech.blocks;

import java.util.Random;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material, float hardness, String toolClass, int level)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SonicTech.sonictechtab);
		setHardness(hardness);
		setHarvestLevel(toolClass, level);
		
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels()
	{
		SonicTech.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
