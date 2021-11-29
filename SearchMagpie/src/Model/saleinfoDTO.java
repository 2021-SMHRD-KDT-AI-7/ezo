package Model;

public class saleinfoDTO {

	private String img;
	private String title;
	private String url;

	public saleinfoDTO(String img, String title, String url) {
		super();
		this.img = img;
		this.title = title;
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "saleinfoDTO [img=" + img + ", title=" + title + ", url=" + url + "]";
	}
}