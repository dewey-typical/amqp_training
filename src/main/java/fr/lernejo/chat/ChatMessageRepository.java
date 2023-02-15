package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ChatMessageRepository {

    List<String> messages = new ArrayList<String>();
    public void addChatMessage(String message) {
        messages.add(message);
    }

    public List<String> getLastTenMessages() {
        if (messages.size() <= 10){
            return messages.subList(0, messages.size());
        } else {
            return messages.subList(messages.size()-10, messages.size());
        }

    }
}
