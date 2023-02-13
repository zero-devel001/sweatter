package com.example.sweater.service;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Page<Message> messagesList(Pageable pageable, String filter,User user) {
        Page<Message> page;
        if (filter != null && !filter.isEmpty()) {
            page = messageRepo.findByTag(filter, pageable);
        } else {
            page = messageRepo.findAll(pageable);
        }
        return page;
    }

    public Page<Message> messagesListForUser(Pageable pageable, User user) {
        return messageRepo.findByAuthor(pageable, user);
    }

    public void saveMessage(Message message) {
        messageRepo.save(message);
    }
}
