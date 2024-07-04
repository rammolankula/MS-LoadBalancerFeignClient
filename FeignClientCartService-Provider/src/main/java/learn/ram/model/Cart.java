package learn.ram.model;



public class Cart {

	private Integer id;
	private String code;
	private double amount;
	public Cart(Integer id, String code, double amount) {
		super();
		this.id = id;
		this.code = code;
		this.amount = amount;
	}
	public Cart() {
	}
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
	
}
