import Constant.AccountStatus;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword(){
        this.password = "123456";
        return true;
    };

    protected String getId() {
        return this.id;
    }
}
