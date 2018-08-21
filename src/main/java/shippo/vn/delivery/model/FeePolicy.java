package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the fee_policy database table.
 * 
 */
@Entity
@Table(name="fee_policy")
@NamedQuery(name="FeePolicy.findAll", query="SELECT f FROM FeePolicy f")
public class FeePolicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="apply_from_date")
	private Timestamp applyFromDate;

	@Column(name="apply_to_date")
	private Timestamp applyToDate;

	private String conditions;

	@Column(name="merchant_id")
	private Integer merchantId;

	@Column(name="merchant_type")
	private String merchantType;

	@Column(name="policy_name")
	private String policyName;

	@Column(name="service_fee_id")
	private Integer serviceFeeId;

	public FeePolicy() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getApplyFromDate() {
		return this.applyFromDate;
	}

	public void setApplyFromDate(Timestamp applyFromDate) {
		this.applyFromDate = applyFromDate;
	}

	public Timestamp getApplyToDate() {
		return this.applyToDate;
	}

	public void setApplyToDate(Timestamp applyToDate) {
		this.applyToDate = applyToDate;
	}

	public String getConditions() {
		return this.conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Integer getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Integer getServiceFeeId() {
		return this.serviceFeeId;
	}

	public void setServiceFeeId(Integer serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}

}