package behavioral.chainofresponsibility;

public class Developer extends Approver {
    @Override
    void approve(String mrBranch) {
        switch (mrBranch) {
            case "testing":
                System.out.println("Developer added optional approval!");
                next.approve(mrBranch);
                break;
            case "master":
            case "hotfix":
                System.out.println("Developer added optional approval!");
               next.approve(mrBranch);
                break;
            default:
                System.out.println("Developer approved MR!");
                break;
        }
    }
}
