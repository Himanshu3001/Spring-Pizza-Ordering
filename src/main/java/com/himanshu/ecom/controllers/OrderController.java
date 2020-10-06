package com.himanshu.ecom.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.himanshu.ecom.entity.Item;
import com.himanshu.ecom.entity.OrderHistory;
import com.himanshu.ecom.entity.User;
import com.himanshu.ecom.service.ItemService;
import com.himanshu.ecom.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	ItemService itemService;

	@Autowired
	OrderService orderService;

	@Autowired
	HttpServletRequest httpServletRequest;

	ArrayList<Integer> list2 = new ArrayList<Integer>();

	List<Item> allItems = new ArrayList<Item>();

	List<OrderHistory> allOrders = new ArrayList<OrderHistory>();

	// @Autowired
	// CartService cartService;

	@RequestMapping("/orderpizza")
	public String add(Model model) {

		List<Item> allItem = itemService.displayItems();

		model.addAttribute("items", allItem);

		return "orderPizza";
		// return "redirect:/";
	}

	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam("itemId") int theItemId, Model model) {

		list2.add(theItemId);

		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("itemID", list2);

		System.out.println("list2:" + list2);

		System.out.println("get sesss:" + session.getAttribute("itemID"));

		// session.setAttribute("itemID", list2);
		System.out.println(theItemId);

		return "redirect:/orderpizza";
	}

	@RequestMapping("/viewcart")
	public String viewCart(HttpSession session, Model model) {

		List<Integer> item = (ArrayList<Integer>) session.getAttribute("itemID");

		allItems = itemService.findItemById(item);

		session.setAttribute("allItems", allItems);

		System.out.println("Syso in contro:" + allItems);
		model.addAttribute("itemAllData", allItems);

		System.out.println(" befoe Buy Now" + allItems);

		if (allItems.isEmpty()) {
			return "redirect:/orderpizza";
		}

		// model.add(temp);
		return "cart";
	}

	@RequestMapping("/buynow")
	public String buyNow(HttpSession session, Model model) {

		List<Item> item = (ArrayList<Item>) session.getAttribute("allItems");
		System.out.println(" Buy Now" + item);

		int sum = 0;
		List<Integer> finalItems = new ArrayList<>();
		;

		int tempid;
		for (Item item2 : item) {
			sum = sum + item2.getPrice();
			tempid = item2.getItemId();
			finalItems.add(tempid);
		}

		System.out.println(sum);

		model.addAttribute("price", sum);
		model.addAttribute("finalItems", finalItems);
		System.out.println("final item id" + finalItems);

		int userId = 100;
		orderService.addOrderDetails(finalItems, userId);

		return "ProcessOrder";
	}

	@RequestMapping("/orderhistory")
	public String orderhistory(Model model,@Valid @ModelAttribute("userReg") User user,BindingResult result) {
		try {
			allOrders = orderService.findUserById();
			if (allOrders==null) {
				return "redirect:/orderpizza";
			}
			
		} catch (Exception e) {
			System.out.println("exception occured:" + e);
		}
		String arr = allOrders.toString();

		System.out.println("arr:" + arr);

		// model.addAttribute("allOrders",allOrders);

		// List<Integer> item=(ArrayList<Integer>)model.getAttribute("allOrders");

		// allItems=itemService.findItemById(item);

		// model.addAttribute("allItems");

		int temp;
		for (OrderHistory item2 : allOrders) {
			temp = item2.getItemId();
			list2.add(temp);
		}

		allItems = itemService.findItemById(list2);
		
		if(allItems==null)
		{
			model.addAttribute("nullObj", 0);
			return "redirect:/orderpizza";
		}

		model.addAttribute("allItems", allItems);

		System.out.println("final:" + allItems);

		// model.addAttribute("allUsers",list2);

		return "orderHistory";
	}

}
