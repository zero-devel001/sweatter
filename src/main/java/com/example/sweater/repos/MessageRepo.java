package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    Page<Message> findByTag(@Param("tag") String tag, Pageable pageable);
    List<Message> findByTag(String tag);
    Page<Message> findAll(Pageable pageable);
    Page<Message> findByAuthor(Pageable pageable, @Param("author") User author);
}
