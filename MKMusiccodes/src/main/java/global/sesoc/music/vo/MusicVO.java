package global.sesoc.music.vo;

/**
 * 음반정보 VO 
 */
public class MusicVO {
	int cdnum;			//상품 번호
	String artist;		//아티스트
	String title;		//음반 제목
	int price;			//가격
	String sell_id;
	int quantity;
	
	public MusicVO() {
	}

	public int getCdnum() {
		return cdnum;
	}

	public void setCdnum(int cdnum) {
		this.cdnum = cdnum;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSell_id() {
		return sell_id;
	}

	public void setSell_id(String sell_id) {
		this.sell_id = sell_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "MusicVO [cdnum=" + cdnum + ", artist=" + artist + ", title=" + title + ", price=" + price + ", sell_id="
				+ sell_id + ", quantity=" + quantity + "]";
	}
}
