package standard.March2019.prob1;

public class Payment {
	
	private int paymentId;
	private String cardNo;
	private PaymentType type;
	
	public Payment(int paymentId, String cardNo, PaymentType type) {
		this.paymentId = paymentId;
		this.cardNo = cardNo;
		this.type = type;
	}
	
	Payment(){
		
	}

	public int getPaymentId() {
		return paymentId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public PaymentType getType() {
		return type;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

}
