package com.moizdrajcy.toolsapi.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public final class UUIDs {

  private UUIDs() { }

  public static byte[] getBytesFromUUID(UUID uuid) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
    byteBuffer.putLong(uuid.getMostSignificantBits());
    byteBuffer.putLong(uuid.getLeastSignificantBits());

    return byteBuffer.array();
  }

  public static UUID getUUIDFromBytes(byte[] bytes) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
    Long high = byteBuffer.getLong();
    Long low = byteBuffer.getLong();

    return new UUID(high, low);
  }

}
