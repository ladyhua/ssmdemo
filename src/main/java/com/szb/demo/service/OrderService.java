package com.szb.demo.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;


public interface OrderService {
	public String selectAllOrder() throws HttpException, IOException;
	public String selectByPrimaryKey(String id) throws HttpException, IOException;
	public String selectOrderByShopId(String shopid) throws HttpException, IOException;
	public String deleteOrder(String id) throws HttpException,IOException;
}
