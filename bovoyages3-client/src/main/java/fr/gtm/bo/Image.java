package fr.gtm.bo;

public class Image {

	private String image;
	private long fkDestination;
	public Image() {}
	public Image(String image,long fkDestination) {
		this.image=image;
		this.fkDestination=fkDestination;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getFkDestination() {
		return fkDestination;
	}

	public void setFkDestination(long fkDestination) {
		this.fkDestination = fkDestination;
	}

}