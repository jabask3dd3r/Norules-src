package net.minecraftforge.common.model;

import java.util.*;

public interface IModelState
{
    Optional<TRSRTransformation> apply(final Optional<? extends IModelPart> p0);
}
