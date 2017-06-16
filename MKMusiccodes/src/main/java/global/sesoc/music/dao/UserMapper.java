package global.sesoc.music.dao;

import global.sesoc.music.vo.UserVO;

/**
 * 회원 관련 Mybatis 사용 메서드
 */
public interface UserMapper {
	// ID로 해당 회원 정보 검색
	public UserVO selectUser(String user_id) throws Exception;

	// 회원가입
	public int insertUser(UserVO user) throws Exception;
}
