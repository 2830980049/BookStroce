package com.tarena.dao;

import com.tarena.entity.Book;
import com.tarena.entity.Collection;

import java.util.List;

public interface CollectionDao {
    Collection query(String user_id, String product);

    int saveCollect(String user_id, String product);

    int deleteCollect(String user_id, String product);

    List<Book> queryCollect(String user_id);
}
