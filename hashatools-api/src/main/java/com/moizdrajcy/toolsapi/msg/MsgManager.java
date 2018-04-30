package com.moizdrajcy.toolsapi.msg;

import com.moizdrajcy.toolsapi.user.User;
import java.util.UUID;

public interface MsgManager {

  void add(UUID writer, UUID recipent);

  User getRecipient(User user);

}
