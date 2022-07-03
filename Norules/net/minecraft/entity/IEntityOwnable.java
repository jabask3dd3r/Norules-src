package net.minecraft.entity;

import javax.annotation.*;
import java.util.*;

public interface IEntityOwnable
{
    @Nullable
    Entity getOwner();
    
    @Nullable
    UUID getOwnerId();
}
