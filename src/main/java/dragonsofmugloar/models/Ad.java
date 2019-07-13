package dragonsofmugloar.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Ad {
	@SerializedName("adId")
	@Expose
	private String adId;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("reward")
	@Expose
	private Integer reward;
	@SerializedName("expiresIn")
	@Expose
	private Integer expiresIn;
	@SerializedName("encrypted")
	@Expose
	private Integer encrypted;
	@SerializedName("probability")
	@Expose
	private String probability;
	
	public boolean isEncrypted() {
		return encrypted != null;
	}
}
