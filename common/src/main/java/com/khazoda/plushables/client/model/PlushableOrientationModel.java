package com.khazoda.plushables.client.model;

import com.khazoda.plushables.block.BasePlushable;
import com.khazoda.plushables.block.util.VoxelShapeHelper;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class PlushableOrientationModel implements BlockStateModel {
  private static final Direction[] DIRECTIONS = Direction.values();
  private static final int SIDE_COUNT = DIRECTIONS.length + 1;

  private final List<BlockStateModelPart> parts;
  private final Material.Baked particleMaterial;
  private final int materialFlags;

  private PlushableOrientationModel(BlockStateModel model, BlockState state) {
    this.parts = orientParts(model, VoxelShapeHelper.Orientation.of(state.getValue(BasePlushable.ATTACHMENT), state.getValue(BasePlushable.ROTATION)));
    this.particleMaterial = model.particleMaterial();
    this.materialFlags = model.materialFlags();
  }

  public static boolean isPlushableBlockState(BlockState state) {
    return state.getBlock() instanceof BasePlushable;
  }

  public static void wrapPlushableModels(Map<BlockState, BlockStateModel> models, Collection<? extends Block> plushables) {
    Map<Block, Map<Integer, BlockStateModel>> cache = new HashMap<>();

    for (Block plushable : plushables) {
      for (BlockState state : plushable.getStateDefinition().getPossibleStates()) {
        BlockStateModel model = models.get(state);
        if (model == null) continue;

        BlockStateModel wrappedModel = wrapPlushableModel(state, model, cache);
        if (wrappedModel != model) {
          models.put(state, wrappedModel);
        }
      }
    }
  }

  public static BlockStateModel wrapPlushableModel(BlockState state, BlockStateModel model, Map<Block, Map<Integer, BlockStateModel>> cache) {
    if (!isPlushableBlockState(state)) {
      return model;
    }

    int orientation = VoxelShapeHelper.orientationIndex(state.getValue(BasePlushable.ATTACHMENT), state.getValue(BasePlushable.ROTATION));
    return cache.computeIfAbsent(state.getBlock(), ignored -> new ConcurrentHashMap<>())
        .computeIfAbsent(orientation, ignored -> new PlushableOrientationModel(model, state));
  }

  private static List<BlockStateModelPart> orientParts(BlockStateModel model, VoxelShapeHelper.Orientation orientation) {
    List<BlockStateModelPart> sourceParts = new ArrayList<>();
    model.collectParts(RandomSource.create(2000L), sourceParts);

    List<BlockStateModelPart> orientedParts = new ArrayList<>(sourceParts.size());
    for (BlockStateModelPart part : sourceParts) {
      orientedParts.add(new OrientedPart(part, orientation));
    }
    return List.copyOf(orientedParts);
  }

  @Override
  public void collectParts(RandomSource random, List<BlockStateModelPart> output) {
    output.addAll(parts);
  }

  @Override
  public Material.Baked particleMaterial() {
    return particleMaterial;
  }

  @Override
  public int materialFlags() {
    return materialFlags;
  }

  private static final class OrientedPart implements BlockStateModelPart {
    private final VoxelShapeHelper.Orientation orientation;
    private final List<BakedQuad>[] quads;
    private final Material.Baked particleMaterial;
    private final int materialFlags;

    @SuppressWarnings("unchecked")
    private OrientedPart(BlockStateModelPart part, VoxelShapeHelper.Orientation orientation) {
      this.orientation = orientation;
      this.quads = new List[SIDE_COUNT];
      this.particleMaterial = part.particleMaterial();
      this.materialFlags = part.materialFlags();

      for (Direction source : DIRECTIONS) {
        quads[sideIndex(orientation.transform(source))] = transformAll(part.getQuads(source));
      }
      quads[sideIndex(null)] = transformAll(part.getQuads(null));
    }

    private static int sideIndex(@Nullable Direction side) {
      return side == null ? SIDE_COUNT - 1 : side.ordinal();
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable Direction direction) {
      return quads[sideIndex(direction)];
    }

    private List<BakedQuad> transformAll(List<BakedQuad> quads) {
      List<BakedQuad> transformed = new ArrayList<>(quads.size());
      for (BakedQuad quad : quads) {
        transformed.add(transform(quad));
      }
      return List.copyOf(transformed);
    }

    private BakedQuad transform(BakedQuad quad) {
      return new BakedQuad(
          transform(quad.position0()),
          transform(quad.position1()),
          transform(quad.position2()),
          transform(quad.position3()),
          quad.packedUV0(),
          quad.packedUV1(),
          quad.packedUV2(),
          quad.packedUV3(),
          orientation.transform(quad.direction()),
          quad.materialInfo()
      );
    }

    private Vector3f transform(org.joml.Vector3fc position) {
      var transformed = orientation.transform(position.x(), position.y(), position.z());
      return new Vector3f((float) transformed.x, (float) transformed.y, (float) transformed.z);
    }

    @Override
    public boolean useAmbientOcclusion() {
      return false;
    }

    @Override
    public Material.Baked particleMaterial() {
      return particleMaterial;
    }

    @Override
    public int materialFlags() {
      return materialFlags;
    }
  }
}
