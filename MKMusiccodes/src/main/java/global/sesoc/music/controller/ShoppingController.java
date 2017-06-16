package global.sesoc.music.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.music.dao.ShoppingDAO;
import global.sesoc.music.vo.MusicVO;
import global.sesoc.music.vo.SalesVO;
import global.sesoc.music.vo.UserVO;

/**
 * 쇼핑 관련 콘트롤러
 */
@RequestMapping(value = "shopping/")
@Controller
public class ShoppingController {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);

	@Autowired
	ShoppingDAO sdao;

	@Autowired
	HttpSession session;

	// 상품 목록 불러오기
	@RequestMapping(value = "itemList", method = RequestMethod.GET)
	public String itemList(Model model) {
		ArrayList<MusicVO> itemList = sdao.itemList();
		model.addAttribute("itemList", itemList);
		return "items/itemList";
	}

	// 한 상품의 정보 불러오기
	@RequestMapping(value = "getItem", method = RequestMethod.GET)
	public String getItem(int cdnum, Model model) {
		MusicVO getItem = sdao.getItem(cdnum);
		model.addAttribute("getItem", getItem);
		return "items/getItem";
	}

	// 상품 구매하기
	@RequestMapping(value = "purchase", method = RequestMethod.GET)
	public String purchase() {
		return "users/loginForm";
	}

	@RequestMapping(value = "purchase", method = RequestMethod.POST)
	public String purchase(SalesVO sales, Model model) {
		UserVO user = (UserVO) session.getAttribute("loginUser");
		String user_id = user.getUser_id();
		int amount = sales.getAmount() * sales.getQuantity();
		sales.setAmount(amount);
		logger.info("상품 구매::" + sales.toString());
		int result = sdao.purchase(sales);
		logger.info("구매 결과::" + result);

		if (result == 1) {
			// 구매 성공한 경우 판매량 올려줌
			sdao.changeQuantity(sales.getQuantity(), sales.getCdnum());
		}

		// 내 구매 내역 저장
		ArrayList<SalesVO> purchaseList = sdao.purchaseList(user_id);
		model.addAttribute("purchaseList", purchaseList);
		int totalNum = 0;
		int totalPrice = 0;
		for (int a = 0; a < purchaseList.size(); a++) {
			totalNum += purchaseList.get(a).getQuantity();
			totalPrice += purchaseList.get(a).getAmount();
		}
		model.addAttribute("totalNum", totalNum);
		model.addAttribute("totalPrice", totalPrice);
		return "items/purchaseList";
	}

	// 내 구매 내역
	@RequestMapping(value = "purchaseList", method = RequestMethod.GET)
	public String purchaseList(Model model) {
		UserVO user = (UserVO) session.getAttribute("loginUser");
		String user_id = user.getUser_id();
		ArrayList<SalesVO> purchaseList = sdao.purchaseList(user_id);
		int totalNum = 0;
		int totalPrice = 0;
		for (int a = 0; a < purchaseList.size(); a++) {
			totalNum += purchaseList.get(a).getQuantity();
			totalPrice += purchaseList.get(a).getAmount();
		}
		model.addAttribute("totalNum", totalNum);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("purchaseList", purchaseList);
		return "items/purchaseList";
	}

	// 판매 순위
	@RequestMapping(value = "numsofpurchase", method = RequestMethod.GET)
	public String numsofpurchase(Model model) {
		logger.info("판매순위");
		ArrayList<SalesVO> numsofpurchase = sdao.numsofpurchase();
		model.addAttribute("numsofpurchase", numsofpurchase);
		return "items/numsofpurchase";
	}

}
