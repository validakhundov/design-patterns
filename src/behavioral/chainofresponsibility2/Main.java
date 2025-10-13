package behavioral.chainofresponsibility2;

public class Main {
    public static void main(String[] args) {
        Approver developer = new Developer();
        Approver stl = new SquadTechLead();
        Approver ttl = new TribeTechLead();

        developer.setNext(stl);
        stl.setNext(ttl);

        developer.approve("hotfix");
    }
}
