package hazmatik.sonictech.world.gen;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class DioritePredicate implements Predicate<IBlockState>
{
	@Override
	public boolean apply(IBlockState input)
	{
		return input != null && input == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
	}
}
