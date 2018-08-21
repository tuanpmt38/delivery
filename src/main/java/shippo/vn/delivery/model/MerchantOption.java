package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the merchant_options database table.
 * 
 */
@Entity
@Table(name="merchant_options")
@NamedQuery(name="MerchantOption.findAll", query="SELECT m FROM MerchantOption m")
public class MerchantOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="date_value")
	private Timestamp dateValue;

	private String key;

	@Column(name="number_value")
	private double numberValue;

	@Column(name="string_value")
	private String stringValue;

	@Column(name="user_id")
	private Integer userId;

	public MerchantOption() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDateValue() {
		return this.dateValue;
	}

	public void setDateValue(Timestamp dateValue) {
		this.dateValue = dateValue;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double getNumberValue() {
		return this.numberValue;
	}

	public void setNumberValue(double numberValue) {
		this.numberValue = numberValue;
	}

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}