package hazmatik.sonictech.blocks;

import java.util.Random;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.blocks.item.ItemBlockVariants;
import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.init.SlabInit;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class SlabGneiss extends BlockSlab
{
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);
	
	public SlabGneiss(String name)
	{
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(10.0f);
		this.setResistance(10.0f);
		
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		
		if(!this.isDouble())
		{
			state.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		}
		
		this.setDefaultState(state);
		this.useNeighborBrightness = !this.isDouble();
	}
	
	@Override
	public String getUnlocalizedName(int meta) 
	{
		return super.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty() 
	{
		return VARIANT;
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) 
	{
		return Variant.DEFAULT;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(SlabInit.SLAB_GNEISS_HALF);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) 
	{
		return new ItemStack(SlabInit.SLAB_GNEISS_HALF);
	}
	
	@Override
	public IBlockState getStateFromMeta(final int meta) 
	{
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		
		if(!this.isDouble())
		{
			state = state.withProperty(HALF, ((meta & 8)!= 0)?EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		}
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int meta = 0;
		
		if(!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP)
		{
			meta |= 8;
		}
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		if(!this.isDouble())
		{
			return new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
		}
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static class DoubleCS extends SlabGneiss
	{
		public DoubleCS(String name) 
		{
			super(name);
		}

		@Override
		public boolean isDouble() 
		{
			return true;
		}
	}
	
	public static class HalfCS extends SlabGneiss
	{

		public HalfCS(String name) 
		{
			super(name);
		}
		
		@Override
		public boolean isDouble()
		{
			return false;
		}
	}
	
	public enum Variant implements IStringSerializable
	{
		DEFAULT;
		
		@Override
		public String getName() 
		{
			return "default";
		}
	}

}