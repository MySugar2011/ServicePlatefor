package com.monitor.handler;

import com.monitor.message.Message;

public interface Handler {

	public void handle(Message message);
}
