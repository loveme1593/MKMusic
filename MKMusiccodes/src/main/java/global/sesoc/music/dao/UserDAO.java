package global.sesoc.music.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.music.vo.UserVO;

/**
 * 회원 관련 DAO
 */
@Repository
public class UserDAO {
	@Autowired
	SqlSession sqlSession;

	/**
	 * ID로 회원정보 검색
	 * 
	 * @param id
	 *            검색할 아이디
	 * @return 검색된 회원정보. 없으면 null.
	 */
	public UserVO selectUser(String id) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserVO user = null;
		try {
			user = mapper.selectUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/** user 회원가입 */
	public int insertUser(UserVO user) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int result = 0;
		try {
			result = mapper.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
