package behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        AuthenticationHandler auth = new AuthenticationHandler("12345");
        ContentTypeHandler type = new ContentTypeHandler("json");
        PayloadHandler payload = new PayloadHandler("Body: {\"username\" = \"john\"}");

        auth.next = type;
        type.next = payload;

        System.out.print("Headers with authentication:");
        String withAuthentication = auth.addHandler("");
        System.out.println(withAuthentication);

        System.out.println("---");

        System.out.print("Headers without authentication:");
        String withoutAuthentication = type.addHandler("");
        System.out.println(withoutAuthentication);
    }
}
