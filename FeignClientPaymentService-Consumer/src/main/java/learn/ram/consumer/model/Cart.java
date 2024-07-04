package learn.ram.consumer.model;


public class Cart {

	@Override
	public String toString() {
		return "Cart [id=" + id + ", code=" + code + ", amount=" + amount + "]";
	}
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Cart(Integer id, String code, double amount) {
		super();
		this.id = id;
		this.code = code;
		this.amount = amount;
	}
	private String code;
	private double amount;
}
