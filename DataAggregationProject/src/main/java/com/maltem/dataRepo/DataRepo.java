package com.maltem.dataRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.maltem.model.Message;
import com.maltem.model.RequestDetailMessage;

public class DataRepo {

	public static RequestDetailMessage getRandomObject() {
		Message message1 = new Message("test", "test1 world!", 1548761716001L);
		Message message2 = new Message("test", "test2 world!", 1548761716002L);
		Message message3 = new Message("test", "test3 world!", 1548761716003L);
		Message message4 = new Message("test", "test4 world!", 1548761716004L);
		Message message5 = new Message("test", "test5 world!", 1548761716005L);
		Message message6 = new Message("test", "test6 world!", 1548761716006L);
		Message message7 = new Message("test", "test7 world!", 1548761716007L);
		Message message8 = new Message("test", "test7 world!", 1548761716007L);
		Message message9 = new Message("test", "test7 world!", 1548761716007L);

		RequestDetailMessage requestDetailMessage = new RequestDetailMessage();
		List<Message> messageList = new ArrayList<Message>();
		requestDetailMessage.setSource("gitters");
		requestDetailMessage.setTimestamp(new Date().getTime());
		messageList.add(message1);
		messageList.add(message2);
		messageList.add(message3);
		messageList.add(message4);
		messageList.add(message5);
		messageList.add(message6);
		messageList.add(message7);
		messageList.add(message8);
		messageList.add(message9);

		messageList = messageList.subList(0, (int) (Math.random() * 10));
		requestDetailMessage.setUpdates(messageList);
		return requestDetailMessage;
	}

}
