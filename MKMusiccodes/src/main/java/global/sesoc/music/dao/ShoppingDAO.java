package global.sesoc.music.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.music.vo.MusicVO;
import global.sesoc.music.vo.SalesVO;

/**
 * 쇼핑 관련 DAO
 */
@Repository
public class ShoppingDAO {

	@Autowired
	SqlSession sqlSession;

	// 상품의 전체 리스트 불러오기
	public ArrayList<MusicVO> itemList() {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		ArrayList<MusicVO> itemList = new ArrayList();
		try {
			itemList = mapper.itemList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemList;
	}

	// 한 상품의 정보 불러오기
	public MusicVO getItem(int cdnum) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		MusicVO getItem = null;
		try {
			getItem = mapper.getItem(cdnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getItem;
	}

	// 상품 구매하기
	public int purchase(SalesVO sales) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		int result = 0;
		try {
			result = mapper.purchase(sales);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 상품 구매시 판매자의 판매 갯수 바꿔주기
	public int changeQuantity(int quantity, int cdnum) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		Map<String, Object> changeQuantity = new HashMap();
		changeQuantity.put("quantity", quantity);
		changeQuantity.put("cdnum", cdnum);
		int result = 0;
		try {
			result = mapper.changeQuantity(changeQuantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 개인의 구매 내역 불러오기
	public ArrayList<SalesVO> purchaseList(String id) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		ArrayList<SalesVO> purchaseList = new ArrayList();
		try {
			purchaseList = mapper.purchaseList(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return purchaseList;
	}

	// 판매 순위 보여주는 목록 가져오기
	public ArrayList<SalesVO> numsofpurchase() {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		ArrayList<SalesVO> numsofpurchase = new ArrayList();
		try {
			numsofpurchase = mapper.numsofpurchase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numsofpurchase;
	}

	// 판매 내역 불러오기
	public ArrayList<MusicVO> sellItemList(String user_id) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		ArrayList<MusicVO> itemList = new ArrayList();
		try {
			itemList = mapper.sellItemList(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemList;
	}

	// 판매 등록하기
	public int insertItem(MusicVO music) {
		ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
		int result = 0;
		try {
			result = mapper.insertItem(music);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
