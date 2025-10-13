package behavioral.chainofresponsibility2;

public class SquadTechLead extends Approver {
    @Override
    void approve(String mrBranch) {
        switch (mrBranch) {
            case "master":
            case "hotfix":
                next.approve(mrBranch);
                break;
            case "testing":
            default:
                System.out.println("Squad Tech Lead approved MR!");
                break;
        }
    }
}
