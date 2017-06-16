package global.sesoc.music.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.music.dao.ShoppingDAO;
import global.sesoc.music.vo.MusicVO;
import global.sesoc.music.vo.SalesVO;
import global.sesoc.music.vo.UserVO;

@RequestMapping(value = "sellers/")
@Controller
public class SellerController {

	@Autowired
	HttpSession session;

	@Autowired
	ShoppingDAO shopdao;

	// 판매자의 판매리스트 불러오기
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String sellitemList(Model model) {
		UserVO user = (UserVO) session.getAttribute("loginUser");
		String user_id = user.getUser_id();
		ArrayList<MusicVO> itemList = shopdao.sellItemList(user_id);
		model.addAttribute("itemList", itemList);
		return "sellers/sellItemList";
	}

	// 판매 등록하기
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "sellers/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(MusicVO music, Model model) {
		int result = shopdao.insertItem(music);
		if (result == 1) {
			model.addAttribute("result", "success");
		}
		UserVO user = (UserVO) session.getAttribute("loginUser");
		String user_id = user.getUser_id();
		ArrayList<MusicVO> itemList = shopdao.sellItemList(user_id);
		model.addAttribute("itemList", itemList);
		return "sellers/sellItemList";
	}

}
