package behavioral.chainofresponsibility;

public class Developer extends Approver {
    @Override
    void approve(String mrBranch) {
        switch (mrBranch) {
            case "testing":
                next.approve(mrBranch);
                break;
            case "master":
            case "hotfix":
                System.out.println("TTL approval is needed!");
                break;
            default:
                System.out.println("Developer approved MR!");
                break;
        }
    }
}
