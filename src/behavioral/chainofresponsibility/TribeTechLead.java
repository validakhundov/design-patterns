package behavioral.chainofresponsibility;

public class TribeTechLead extends Approver {
    @Override
    void approve(String mrBranch) {
        switch (mrBranch) {
            case "master":
            case "testing":
            case "hotfix":
            default:
                System.out.println("Tribe Tech Lead approved MR!");
                break;
        }
    }
}
