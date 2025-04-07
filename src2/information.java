package src2;
public class information {
    private int id;
    private String name = "Unknown Name";
    private String acountCode;
    private String createdDate;
    private String AmountSavingsDeposit; // số tiên gửi tiết kiệm
    private String SavingDate; // ngày gửi tiết kiệm
    private String InterestRate; // lãi suất
    private String term; // kì hạn
    private String cardNumber; // thẻ
    private String moneyInAccount; // số tiền trong tk

    public information(int id, String name, String acountCode, String createdDate) {
        this.id = id;
        this.name = name;
        this.acountCode = acountCode;
        this.createdDate = createdDate;

    }
    public information() {}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getacountCode(){
        return acountCode;
    }
    public void setAcountCode(String address){
        this.acountCode = address;
    }
    public String getcreatedDate(){
        return createdDate;
    }
    public void setcreatedDate(String createdDate){
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return  id
                + "," + name
                + "," + acountCode
                + "," + createdDate;
    }
}

