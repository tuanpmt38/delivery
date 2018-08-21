package shippo.vn.delivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the merchant database table.
 * 
 */
@Entity
@NamedQuery(name="Merchant.findAll", query="SELECT m FROM Merchant m")
public class Merchant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String avatar;

	@JsonProperty("banks")
	private String banks;

	private Timestamp birthday;

	private String code;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String email;

	@Column(name="first_order_at")
	private Timestamp firstOrderAt;

	@Column(name="full_name")
	private String fullName;

	private String gender;

	@Column(name="is_email_verified")
	private Boolean isEmailVerified;

	@Column(name="last_order_at")
	private Timestamp lastOrderAt;

	@JsonProperty("metadata")
	private String metadata;

	private String mobile;

	@Column(name="real_balance")
	private double realBalance;

	private String state;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_id")
	private Integer userId;

	private Integer version;

	public Merchant() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBanks() {
		return this.banks;
	}

	public void setBanks(String banks) {
		this.banks = banks;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFirstOrderAt() {
		return this.firstOrderAt;
	}

	public void setFirstOrderAt(Timestamp firstOrderAt) {
		this.firstOrderAt = firstOrderAt;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsEmailVerified() {
		return this.isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public Timestamp getLastOrderAt() {
		return this.lastOrderAt;
	}

	public void setLastOrderAt(Timestamp lastOrderAt) {
		this.lastOrderAt = lastOrderAt;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getRealBalance() {
		return this.realBalance;
	}

	public void setRealBalance(double realBalance) {
		this.realBalance = realBalance;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}