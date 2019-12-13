package com.tarena.service;

import com.tarena.entity.Book;
import com.tarena.entity.Collection;

import java.util.List;

public interface CollectionService {
    Collection query(String user_id, String product);

    boolean save(String user_id, String product);

    boolean delete(String user_id, String product);

    List<Book> queryCollect(String user_id);
}
