package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the delivery_order_fees database table.
 * 
 */
@Entity
@Table(name="delivery_order_fees")
@NamedQuery(name="DeliveryOrderFee.findAll", query="SELECT d FROM DeliveryOrderFee d")
public class DeliveryOrderFee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="charge_type")
	private String chargeType;

	@Column(name="display_type")
	private String displayType;

	@Column(name="fee_code")
	private String feeCode;

	@Column(name="fee_group")
	private String feeGroup;

	@Column(name="fee_name")
	private String feeName;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="is_manual")
	private Boolean isManual;

	@Column(name="lastest_cal_at")
	private Timestamp lastestCalAt;

	private String note;

	@Column(name="order_id")
	private Integer orderId;

	private double quantity;

	@Column(name="raw_amount")
	private double rawAmount;

	@Column(name="real_amount")
	private double realAmount;

	@Column(name="service_fee_id")
	private Integer serviceFeeId;

	@Column(name="unit_price")
	private double unitPrice;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer version;

	public DeliveryOrderFee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getDisplayType() {
		return this.displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getFeeCode() {
		return this.feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getFeeGroup() {
		return this.feeGroup;
	}

	public void setFeeGroup(String feeGroup) {
		this.feeGroup = feeGroup;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsManual() {
		return this.isManual;
	}

	public void setIsManual(Boolean isManual) {
		this.isManual = isManual;
	}

	public Timestamp getLastestCalAt() {
		return this.lastestCalAt;
	}

	public void setLastestCalAt(Timestamp lastestCalAt) {
		this.lastestCalAt = lastestCalAt;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRawAmount() {
		return this.rawAmount;
	}

	public void setRawAmount(double rawAmount) {
		this.rawAmount = rawAmount;
	}

	public double getRealAmount() {
		return this.realAmount;
	}

	public void setRealAmount(double realAmount) {
		this.realAmount = realAmount;
	}

	public Integer getServiceFeeId() {
		return this.serviceFeeId;
	}

	public void setServiceFeeId(Integer serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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