package hazmatik.sonictech.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.blocks.BlockSTPlank.WoodType;
import hazmatik.sonictech.blocks.item.ItemBlockVariants;
import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import hazmatik.sonictech.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSTLeaf extends BlockLeaves implements IHasModel, IMetaName
{
	public static final PropertyEnum<WoodType> VARIANT = PropertyEnum.create("type", WoodType.class, new Predicate<WoodType>()
			{
				public boolean apply(@Nullable WoodType apply)
				{
					return apply.getMetadata() < 3;
				}
			});
	
	private String name;
	
	public BlockSTLeaf(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, WoodType.MAGNOLIA).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		setCreativeTab(SonicTech.sonictechtab);
		
		this.name = name;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, DECAYABLE, CHECK_DECAY});
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < WoodType.METADATA_LOOKUP.length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, WoodType.byMetadata(meta % 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = ((WoodType)state.getValue(VARIANT)).getMetadata();
		
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 3;
		}
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 6;
		}
		
		return i;
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(VARIANT).getMetadata());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return WoodType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {return;}
	
	@Override
	protected int getSaplingDropChance(IBlockState state) {return 30;}
	
	@Override
	public EnumType getWoodType(int meta) {return null;}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMetadata()));
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < WoodType.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "leaves_a_" + WoodType.values()[i].getName(), "inventory");
		}
	}
	
	public enum WoodType implements IStringSerializable
	{
		MAGNOLIA(0, "magnolia"),
		CEDAR(1, "cedar"),
		PINE(2, "pine");
	
	
		private static final WoodType[] METADATA_LOOKUP = new WoodType[values().length];
		private final int metadata;
		private final String name;
		
		WoodType(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}
		
		public int getMetadata()
		{
			return this.metadata;
		}
		
		@Override
		public String getName()
		{
			return this.name;
		}
		
		public static WoodType byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(WoodType type : values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
