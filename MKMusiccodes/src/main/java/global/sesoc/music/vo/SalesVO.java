package global.sesoc.music.vo;

/**
 * 구매 처리, 내 구매내역, 판매실적에 사용할 VO
 */
public class SalesVO {
	String buy_id; // 구매자 아이디
	int cdnum; // 상품 번호
	int quantity; // 수량
	int amount; // 합계 금액 (수량 * 상품가격)
	String salesdate; // 판매일
	String artist; // 아티스트 이름
	String title; // 음반 제목
	String cnt; // 판매 순위에 사용할 합계 수량

	public SalesVO() {
	}

	public SalesVO(String buy_id, int cdnum, int quantity, int amount, String salesdate, String artist, String title,
			String cnt) {
		this.buy_id = buy_id;
		this.cdnum = cdnum;
		this.quantity = quantity;
		this.amount = amount;
		this.salesdate = salesdate;
		this.artist = artist;
		this.title = title;
		this.cnt = cnt;
	}

	public String getBuy_id() {
		return buy_id;
	}

	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}

	public int getCdnum() {
		return cdnum;
	}

	public void setCdnum(int cdnum) {
		this.cdnum = cdnum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(String salesdate) {
		this.salesdate = salesdate;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "SalesVO [buy_id=" + buy_id + ", cdnum=" + cdnum + ", quantity=" + quantity + ", amount=" + amount
				+ ", salesdate=" + salesdate + ", artist=" + artist + ", title=" + title + ", cnt=" + cnt + "]";
	}
}
