package shippo.vn.delivery.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the order_comment database table.
 * 
 */
@Entity
@Table(name="order_comment")
@NamedQuery(name="OrderComment.findAll", query="SELECT o FROM OrderComment o")
public class OrderComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="comment_object")
	private String commentObject;

	@Column(name="comment_source")
	private String commentSource;

	private String content;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="order_id")
	private Integer orderId;

	private String scope;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	private Integer version;

	public OrderComment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentObject() {
		return this.commentObject;
	}

	public void setCommentObject(String commentObject) {
		this.commentObject = commentObject;
	}

	public String getCommentSource() {
		return this.commentSource;
	}

	public void setCommentSource(String commentSource) {
		this.commentSource = commentSource;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
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