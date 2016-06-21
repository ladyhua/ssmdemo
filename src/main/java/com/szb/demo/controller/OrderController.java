package com.szb.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szb.demo.service.OrderService;
/** 
 * @Description 直接与前台交互的订单controller
 * @author hlz
 * @date 2016年4月28日 上午9:19:31 
 * @version V1.3.1
 */ 
  	
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	OrderService orderService;
	
	 
	/** 
	 * @Description 查询所有订单
	 * @author hlz
	 * @param response
	 * @throws IOException  
	 */
	  	
	@RequestMapping("selectAllOrder") 
	public void getAllOrder(HttpServletResponse response) throws IOException {
		
		String json = orderService.selectAllOrder();
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	
	 
	/** 
	 * @Description 通过id查询订单信息
	 * @author hlz
	 * @param request
	 * @param response
	 * @param id 订单id
	 * @throws IOException  
	 */
	  	
	@RequestMapping("selectOrderById")
	public void selectOrder(HttpServletRequest request,HttpServletResponse response,String id) throws IOException {
		
		String json = orderService.selectByPrimaryKey(id);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	
	 
	/** 
	 * @Description 通过店铺id查询该店铺的订单
	 * @author hlz
	 * @param response
	 * @param shopid
	 * @throws IOException  
	 */
	  	
	@RequestMapping("selectOrderByShopId")
	public void selectOrderByShopId(HttpServletResponse response,String shopid) throws IOException {
		String json = orderService.selectOrderByShopId(shopid);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	
	@RequestMapping("deleteOrder")
	public void deleteOrder(HttpServletResponse response,String id) throws IOException {
		String json = orderService.deleteOrder(id);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
