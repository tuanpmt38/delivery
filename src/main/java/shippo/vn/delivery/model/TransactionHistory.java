package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the transaction_histories database table.
 * 
 */
@Entity
@Table(name="transaction_histories")
@NamedQuery(name="TransactionHistory.findAll", query="SELECT t FROM TransactionHistory t")
public class TransactionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String barcode;

	@Column(name="completed_by")
	private Integer completedBy;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="final_merchant_balance")
	private double finalMerchantBalance;

	@Column(name="merchant_id")
	private Integer merchantId;

	@Column(name="object_id")
	private Integer objectId;

	@Column(name="object_type")
	private String objectType;

	@Column(name="private_note")
	private String privateNote;

	@Column(name="record_id")
	private Integer recordId;

	@Column(name="trans_amount")
	private double transAmount;

	@Column(name="trans_detail")
	private String transDetail;

	@Column(name="trans_type")
	private String transType;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer version;

	public TransactionHistory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getCompletedBy() {
		return this.completedBy;
	}

	public void setCompletedBy(Integer completedBy) {
		this.completedBy = completedBy;
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

	public double getFinalMerchantBalance() {
		return this.finalMerchantBalance;
	}

	public void setFinalMerchantBalance(double finalMerchantBalance) {
		this.finalMerchantBalance = finalMerchantBalance;
	}

	public Integer getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getPrivateNote() {
		return this.privateNote;
	}

	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public double getTransAmount() {
		return this.transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public String getTransDetail() {
		return this.transDetail;
	}

	public void setTransDetail(String transDetail) {
		this.transDetail = transDetail;
	}

	public String getTransType() {
		return this.transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
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