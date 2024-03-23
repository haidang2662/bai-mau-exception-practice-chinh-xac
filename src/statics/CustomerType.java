package statics;

public enum CustomerType {

    PERSONAL("Cá nhân"),
    GROUP("Tập thể"),
    ENTERPRISE("Doanh nghiệp");

    public String value;

    CustomerType(String value) {
        this.value = value;
    }

}
