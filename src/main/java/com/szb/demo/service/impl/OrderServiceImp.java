package com.szb.demo.service.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;

import com.szb.demo.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
	
	@Override
	public String selectAllOrder() throws HttpException, IOException {
		// TODO Auto-generated method stub
        HttpClient client = new HttpClient();
        
        HttpMethod method = new GetMethod("http://localhost:8080/springmvcdemo/order/selectAllOrder");   

        client.executeMethod(method);   

        System.out.println(method.getStatusLine());   


        System.out.println(method.getResponseBodyAsString());   

        //释放连接   

        method.releaseConnection();   
        
        return method.getResponseBodyAsString();
	}
	
	@Override
	public String selectByPrimaryKey(String id) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		
		PostMethod post = new PostMethod("http://localhost:8080/springmvcdemo/order/selectOrderById");
		
		NameValuePair[] param = { new NameValuePair("id",id) };
		
		post.setRequestBody(param);
		
		client.executeMethod(post);
		
		System.out.println(post.getStatusLine());
		
		System.out.println(post.getResponseBodyAsString());
		
		post.releaseConnection();
		
		return post.getResponseBodyAsString();
	}
	
	@Override
	public String selectOrderByShopId(String shopid) throws HttpException, IOException {
		HttpClient client = new HttpClient();
        
        HttpMethod method = new GetMethod("http://localhost:8080/springmvcdemo/order/selectOrderByShopId?shopid="+shopid);   

        client.executeMethod(method);   

        System.out.println(method.getStatusLine());   


        System.out.println(method.getResponseBodyAsString());   

        //释放连接   

        method.releaseConnection();   
        
        return method.getResponseBodyAsString();
	}
	
	@Override
	public String deleteOrder(String id) throws HttpException,IOException {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod("http://localhost:8080/springmvcdemo/order/deleteOrder?id="+id);
		client.executeMethod(method);
		System.out.println(method.getStatusLine());
		System.out.println(method.getResponseBodyAsString());
		method.releaseConnection();
		return method.getResponseBodyAsString();
	}
}
