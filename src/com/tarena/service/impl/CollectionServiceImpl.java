package com.tarena.service.impl;

import com.tarena.dao.impl.CollectionDaoImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Collection;
import com.tarena.service.CollectionService;

import java.util.List;

public class CollectionServiceImpl implements CollectionService {
    private CollectionDaoImpl dao = null;

    public CollectionServiceImpl() {
        dao = new CollectionDaoImpl();
    }

    @Override
    public Collection query(String user_id, String product) {
        if (null != user_id && null != product &&
                !"".equals(user_id) && !"".equals(product)) {
            Collection collection = dao.query(user_id, product);
            return collection;
        }
        return null;
    }

    @Override
    public boolean save(String user_id, String product) {
        if (null != user_id && null != product &&
                !"".equals(user_id) && !"".equals(product)) {
            int num = dao.saveCollect(user_id, product);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String user_id, String product) {
        if (null != user_id && null != product &&
                !"".equals(user_id) && !"".equals(product)) {
            int num = dao.deleteCollect(user_id, product);
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> queryCollect(String user_id) {
        if (null != user_id && !"".equals(user_id)) {
            List<Book> list = dao.queryCollect(user_id);
            return list;
        }
        return null;
    }

}
