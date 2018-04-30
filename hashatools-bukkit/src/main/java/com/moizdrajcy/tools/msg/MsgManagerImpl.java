package com.moizdrajcy.tools.msg;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.msg.MsgManager;
import com.moizdrajcy.toolsapi.user.User;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MsgManagerImpl implements MsgManager {

  private final HashaTools plugin;
  private final Cache<UUID, UUID> msgCache = CacheBuilder.newBuilder().expireAfterAccess(60, TimeUnit.SECONDS).build();

  public MsgManagerImpl(HashaTools plugin) {
    this.plugin = plugin;
  }

  @Override
  public void add(UUID writer, UUID recipient) {
    this.msgCache.put(writer, recipient);
    this.msgCache.put(recipient, writer);

  }

  @Override
  public User getRecipient(User user) {
    return this.plugin.getUserManager().get(this.msgCache.getIfPresent(user.getUUID())).get();
  }

}
