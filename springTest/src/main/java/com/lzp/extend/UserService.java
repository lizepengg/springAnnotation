package com.lzp.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@EventListener(classes = {ApplicationEvent.class})
	public void listener(ApplicationEvent event) { //同通过传入参数来获取事件
		System.out.println("listener监听到的事件："+event);
	}

}
