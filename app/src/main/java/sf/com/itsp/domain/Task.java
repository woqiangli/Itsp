package sf.com.itsp.domain;

public class Task {

    private String address;

    private String operation;

    public Task(String address, String operation) {
        this.address = address;
        this.operation = operation;
    }

    public String getAddress() {
        return address;
    }

    public String getOperation() {
        return operation;
    }
}
