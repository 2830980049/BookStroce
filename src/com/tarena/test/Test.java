package com.tarena.test;

import java.sql.Connection;
import java.util.List;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.*;
import com.tarena.service.impl.AddressServiceImpl;
import com.tarena.util.DBUtil;

public class Test {

	public static void main(String[] args) {
//		BookDaoImpl dao = new BookDaoImpl();
//		PageBean<Book> bean = dao.queryPage(2, 3);
//		System.out.println(bean.getTotalPage());
//		System.out.println(bean.getListBean());
//		PageBean<Book> bean = dao.searchQuery(1, 1, "java");
//		System.out.println(bean.getTotalPage());
//		System.out.println(bean.getListBean());
//		Car c = new Car();
//		c.setUser_id("18385056630");
//		c.setPruduct("9787111213826");
//		c.setCount(2);;
//		int num = dao.saveCar(c);
//		System.out.println(num);
		//List<Book> list=
		AddressServiceImpl service=new AddressServiceImpl();
		List<Address> addresses=service.queryAddressUser("17685346276");
		System.out.println(addresses);
	}

}
