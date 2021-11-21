package Model;

public class webDTO {
	private int web_key;
	private String name;
	private String web_url;

	public webDTO(int web_key, String name, String web_url) {
		super();
		this.web_key = web_key;
		this.name = name;
		this.web_url = web_url;
	}

	public int getWeb_key() {
		return web_key;
	}

	public void setWeb_key(int web_key) {
		this.web_key = web_key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	@Override
	public String toString() {
		return "webDTO [web_key=" + web_key + ", name=" + name + ", web_url=" + web_url + "]";
	}
}
