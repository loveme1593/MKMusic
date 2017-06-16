package global.sesoc.music.dao;

import java.util.ArrayList;
import java.util.Map;

import global.sesoc.music.vo.MusicVO;
import global.sesoc.music.vo.SalesVO;

/**
 * 쇼핑 관련 Mybatis 사용 메서드
 */
public interface ShoppingMapper {

	// 상품의 전체 목록 불러오기
	public ArrayList<MusicVO> itemList() throws Exception;

	// 한 상품의 정보 불러오기
	public MusicVO getItem(int cdnum) throws Exception;

	// 상품 구매하기
	public int purchase(SalesVO Sales) throws Exception;

	// 상품 구매시 판매자의 판매 갯수 바꾸기
	public int changeQuantity(Map<String, Object> changeQuantity) throws Exception;

	// 개인의 구매 내역 불러오기
	public ArrayList<SalesVO> purchaseList(String id) throws Exception;

	// sales의 전체 내역 불러오기
	public ArrayList<SalesVO> numsofpurchase() throws Exception;

	// 해당하는 판매자의 판매 리스트 모두 불러오기
	public ArrayList<MusicVO> sellItemList(String user_id) throws Exception;

	// 상품 등록하기
	public int insertItem(MusicVO music) throws Exception;

}
