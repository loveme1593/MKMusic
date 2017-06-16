package global.sesoc.music.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.music.dao.UserDAO;
import global.sesoc.music.dao.UserMapper;
import global.sesoc.music.vo.UserVO;

/**
 * 회원 로그인, 로그아웃 처리 콘트롤러
 */
@RequestMapping(value = "users/")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO dao;

	@Autowired
	HttpSession session;

	/** join Form 열기 */
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinForm() {
		return "users/joinForm";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinForm(UserVO user, Model model) {
		int result = dao.insertUser(user);
		logger.info("join result::"+result);
		if (result == 1) {
			model.addAttribute("joinResult", "success");
		}
		return "users/loginForm";
	}

	/** id 중복여부 체크 */
	@RequestMapping(value = "idCheck", method = RequestMethod.GET)
	public String idCheck() {
		return "users/idCheck";
	}

	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public @ResponseBody String idCheck(String user_id) {
		UserVO user = dao.selectUser(user_id);
		if (user == null) {
			return "success";
		} else {
			return "false";
		}
	}

	/**
	 * 로그인 폼 보기
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm() {
		session.removeAttribute("errorMsg");
		return "users/loginForm";
	}

	@RequestMapping(value = "loginInterceptor", method = RequestMethod.GET)
	public String loginInterceptor() {
		return "users/loginForm";
	}

	/**
	 * 로그인 처리
	 * 
	 * @param id
	 *            사용자가 입력한 아이디
	 * @param password
	 *            사용자가 입력한 비밀번호
	 * @param model
	 *            모델 객체
	 * @param session
	 *            HttpSession객체
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String user_id, String user_password, Model model, HttpSession session) {
		UserVO user = dao.selectUser(user_id);
		if (user != null && user.getUser_password().equals(user_password)) {
			session.setAttribute("loginUser", user);
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "ID 또는 비밀번호가 틀립니다.");
			return "users/loginForm";
		}
	}

	/**
	 * 로그아웃 처리
	 * 
	 * @param session
	 *            HttpSession객체
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
