package shippo.vn.delivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the delivery_order database table.
 * 
 */
@Entity
@Table(name="delivery_order")
@NamedQuery(name="DeliveryOrder.findAll", query="SELECT d FROM DeliveryOrder d")
public class DeliveryOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String barcode;

	private double cod;

	@Column(name="create_from_order")
	private Integer createFromOrder;

	@Column(name="create_method")
	private String createMethod;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="current_warehouse_id")
	private Integer currentWarehouseId;

	@Column(name="current_warehouse_state")
	private String currentWarehouseState;

	@Column(name="deliver_contact")
	private String deliverContact;

	@Column(name="deliver_detail_address")
	private String deliverDetailAddress;

	@Column(name="deliver_full_address")
	private String deliverFullAddress;

	@Column(name="deliver_location_ids_path")
	private String deliverLocationIdsPath;

	@Column(name="deliver_location_names_path")
	private String deliverLocationNamesPath;

	@Column(name="deliver_phone")
	private String deliverPhone;

	@Column(name="deliver_times")
	private Integer deliverTimes;

	@Column(name="deliver_warehouse_id")
	private Integer deliverWarehouseId;

	@Column(name="delivery_note")
	private String deliveryNote;

	@Column(name="export_warehouse_at")
	private Timestamp exportWarehouseAt;

	@JsonProperty("features")
	private String features;

	private String goods;

	@Column(name="import_warehouse_at")
	private Timestamp importWarehouseAt;

	@Column(name="is_return")
	private Boolean isReturn;

	@Column(name="merchant_id")
	private Integer merchantId;

	@Column(name="merchant_order_code")
	private String merchantOrderCode;

	@Column(name="merchant_private_note")
	private String merchantPrivateNote;

	@Column(name="order_state")
	private String orderState;

	@Column(name="pickup_contact")
	private String pickupContact;

	@Column(name="pickup_detail_address")
	private String pickupDetailAddress;

	@Column(name="pickup_full_address")
	private String pickupFullAddress;

	@Column(name="pickup_location_ids_path")
	private String pickupLocationIdsPath;

	@Column(name="pickup_location_names_path")
	private String pickupLocationNamesPath;

	@Column(name="pickup_note")
	private String pickupNote;

	@Column(name="pickup_phone")
	private String pickupPhone;

	@Column(name="pickup_times")
	private Integer pickupTimes;

	@Column(name="pickup_warehouse_id")
	private Integer pickupWarehouseId;

	@Column(name="real_cod")
	private double realCod;

	private String state;

	@JsonProperty("timeline")
	private String timeline;

	@Column(name="total_fee")
	private double totalFee;

	@Column(name="total_merchant_fee")
	private double totalMerchantFee;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer version;

	private Integer weight;

	public DeliveryOrder() {
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

	public double getCod() {
		return this.cod;
	}

	public void setCod(double cod) {
		this.cod = cod;
	}

	public Integer getCreateFromOrder() {
		return this.createFromOrder;
	}

	public void setCreateFromOrder(Integer createFromOrder) {
		this.createFromOrder = createFromOrder;
	}

	public String getCreateMethod() {
		return this.createMethod;
	}

	public void setCreateMethod(String createMethod) {
		this.createMethod = createMethod;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCurrentWarehouseId() {
		return this.currentWarehouseId;
	}

	public void setCurrentWarehouseId(Integer currentWarehouseId) {
		this.currentWarehouseId = currentWarehouseId;
	}

	public String getCurrentWarehouseState() {
		return this.currentWarehouseState;
	}

	public void setCurrentWarehouseState(String currentWarehouseState) {
		this.currentWarehouseState = currentWarehouseState;
	}

	public String getDeliverContact() {
		return this.deliverContact;
	}

	public void setDeliverContact(String deliverContact) {
		this.deliverContact = deliverContact;
	}

	public String getDeliverDetailAddress() {
		return this.deliverDetailAddress;
	}

	public void setDeliverDetailAddress(String deliverDetailAddress) {
		this.deliverDetailAddress = deliverDetailAddress;
	}

	public String getDeliverFullAddress() {
		return this.deliverFullAddress;
	}

	public void setDeliverFullAddress(String deliverFullAddress) {
		this.deliverFullAddress = deliverFullAddress;
	}

	public String getDeliverLocationIdsPath() {
		return this.deliverLocationIdsPath;
	}

	public void setDeliverLocationIdsPath(String deliverLocationIdsPath) {
		this.deliverLocationIdsPath = deliverLocationIdsPath;
	}

	public String getDeliverLocationNamesPath() {
		return this.deliverLocationNamesPath;
	}

	public void setDeliverLocationNamesPath(String deliverLocationNamesPath) {
		this.deliverLocationNamesPath = deliverLocationNamesPath;
	}

	public String getDeliverPhone() {
		return this.deliverPhone;
	}

	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}

	public Integer getDeliverTimes() {
		return this.deliverTimes;
	}

	public void setDeliverTimes(Integer deliverTimes) {
		this.deliverTimes = deliverTimes;
	}

	public Integer getDeliverWarehouseId() {
		return this.deliverWarehouseId;
	}

	public void setDeliverWarehouseId(Integer deliverWarehouseId) {
		this.deliverWarehouseId = deliverWarehouseId;
	}

	public String getDeliveryNote() {
		return this.deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public Timestamp getExportWarehouseAt() {
		return this.exportWarehouseAt;
	}

	public void setExportWarehouseAt(Timestamp exportWarehouseAt) {
		this.exportWarehouseAt = exportWarehouseAt;
	}

	public String getFeatures() {
		return this.features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getGoods() {
		return this.goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Timestamp getImportWarehouseAt() {
		return this.importWarehouseAt;
	}

	public void setImportWarehouseAt(Timestamp importWarehouseAt) {
		this.importWarehouseAt = importWarehouseAt;
	}

	public Boolean getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(Boolean isReturn) {
		this.isReturn = isReturn;
	}

	public Integer getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantOrderCode() {
		return this.merchantOrderCode;
	}

	public void setMerchantOrderCode(String merchantOrderCode) {
		this.merchantOrderCode = merchantOrderCode;
	}

	public String getMerchantPrivateNote() {
		return this.merchantPrivateNote;
	}

	public void setMerchantPrivateNote(String merchantPrivateNote) {
		this.merchantPrivateNote = merchantPrivateNote;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPickupContact() {
		return this.pickupContact;
	}

	public void setPickupContact(String pickupContact) {
		this.pickupContact = pickupContact;
	}

	public String getPickupDetailAddress() {
		return this.pickupDetailAddress;
	}

	public void setPickupDetailAddress(String pickupDetailAddress) {
		this.pickupDetailAddress = pickupDetailAddress;
	}

	public String getPickupFullAddress() {
		return this.pickupFullAddress;
	}

	public void setPickupFullAddress(String pickupFullAddress) {
		this.pickupFullAddress = pickupFullAddress;
	}

	public String getPickupLocationIdsPath() {
		return this.pickupLocationIdsPath;
	}

	public void setPickupLocationIdsPath(String pickupLocationIdsPath) {
		this.pickupLocationIdsPath = pickupLocationIdsPath;
	}

	public String getPickupLocationNamesPath() {
		return this.pickupLocationNamesPath;
	}

	public void setPickupLocationNamesPath(String pickupLocationNamesPath) {
		this.pickupLocationNamesPath = pickupLocationNamesPath;
	}

	public String getPickupNote() {
		return this.pickupNote;
	}

	public void setPickupNote(String pickupNote) {
		this.pickupNote = pickupNote;
	}

	public String getPickupPhone() {
		return this.pickupPhone;
	}

	public void setPickupPhone(String pickupPhone) {
		this.pickupPhone = pickupPhone;
	}

	public Integer getPickupTimes() {
		return this.pickupTimes;
	}

	public void setPickupTimes(Integer pickupTimes) {
		this.pickupTimes = pickupTimes;
	}

	public Integer getPickupWarehouseId() {
		return this.pickupWarehouseId;
	}

	public void setPickupWarehouseId(Integer pickupWarehouseId) {
		this.pickupWarehouseId = pickupWarehouseId;
	}

	public double getRealCod() {
		return this.realCod;
	}

	public void setRealCod(double realCod) {
		this.realCod = realCod;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTimeline() {
		return this.timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	public double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public double getTotalMerchantFee() {
		return this.totalMerchantFee;
	}

	public void setTotalMerchantFee(double totalMerchantFee) {
		this.totalMerchantFee = totalMerchantFee;
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

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}