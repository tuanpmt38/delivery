package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the merchant_pickup_address database table.
 * 
 */
@Entity
@Table(name="merchant_pickup_address")
@NamedQuery(name="MerchantPickupAddress.findAll", query="SELECT m FROM MerchantPickupAddress m")
public class MerchantPickupAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_phone")
	private String contactPhone;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="detail_address")
	private String detailAddress;

	@Column(name="full_address")
	private String fullAddress;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="location_ids_path")
	private Integer locationIdsPath;

	@Column(name="location_names_path")
	private String locationNamesPath;

	@Column(name="merchant_id")
	private Integer merchantId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer version;

	public MerchantPickupAddress() {
	}

	public MerchantPickupAddress(Integer id, Boolean isDeleted, Integer createdBy, Integer merchantId, String detailAddress, String contactName, String contactPhone, String fullAddress, Integer locationIdsPath, String locationNamesPath, Integer version, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.createdBy = createdBy;
		this.isDeleted = isDeleted;
		this.merchantId = merchantId;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.detailAddress = detailAddress;
		this.fullAddress = fullAddress;
		this.locationIdsPath = locationIdsPath;
		this.locationNamesPath = locationNamesPath;
		this.version = version;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getDetailAddress() {
		return this.detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getLocationIdsPath() {
		return this.locationIdsPath;
	}

	public void setLocationIdsPath(Integer locationIdsPath) {
		this.locationIdsPath = locationIdsPath;
	}

	public String getLocationNamesPath() {
		return this.locationNamesPath;
	}

	public void setLocationNamesPath(String locationNamesPath) {
		this.locationNamesPath = locationNamesPath;
	}

	public Integer getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}