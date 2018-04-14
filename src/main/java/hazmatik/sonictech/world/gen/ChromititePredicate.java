package hazmatik.sonictech.world.gen;

import com.google.common.base.Predicate;

import hazmatik.sonictech.blocks.BlockSTStone;
import hazmatik.sonictech.blocks.BlockSTStone.StoneType;
import hazmatik.sonictech.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class ChromititePredicate implements Predicate<IBlockState>
{
	@Override
	public boolean apply(IBlockState input)
	{
		return input != null && input == BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.CHROMITITE);
	}
}
