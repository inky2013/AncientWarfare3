package net.shadowmage.ancientwarfare.core.util;

import java.util.Collections;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class WorldTools
{

/**
 * SERVER ONLY
 * @param world
 * @param x1
 * @param y1
 * @param z1
 * @param x2
 * @param y2
 * @param z2
 * @return
 */
@SuppressWarnings("unchecked")
public static List<TileEntity> getTileEntitiesInArea(World world, int x1, int y1, int z1, int x2, int y2, int z2)
  {  
  if(world instanceof WorldServer)
    {
    return (List<TileEntity>) ((WorldServer)world).func_147486_a(x1, y1, z1, x2, y2, z2);
    }
  return Collections.emptyList();
  }

/**
 * PROBABLY SLOW AS HELL<br>
 * ONLY WORKS SERVER SIDE UNLESS ENTITY-UNIQUE ID HAS BEEN SYNCHED BY MODDER
 * @param world
 * @param msb
 * @param lsb
 * @return
 */
@SuppressWarnings("unchecked")
public static Entity getEntityByUUID(World world, long msb, long lsb)
  {
  world.getEntityByID(0);
  for(Entity e : (List<Entity>)world.loadedEntityList)
    {
    if(e.getPersistentID().getMostSignificantBits()==msb && e.getPersistentID().getLeastSignificantBits()==lsb)
      {
      return e;
      }
    }
  return null;
  }

}
