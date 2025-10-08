package creational.stepbuilder;

public class StepBuilderSqlDemo {
    public static void main(String[] args) {
        SqlQuery query = SqlQuery.builder()
                .select("id, name, balance")
                .from("customers")
                .where("balance > 1000")
                .where("status = 'ACTIVE'")
                .orderBy("balance DESC")
                .limit(10)
                .build();

        //SELECT * form users;

        SqlQuery query2=  SqlQuery.builder().select(Columns.ALL).from("users")
                        .where("id>5")
                .where("name like 'V%'")
                .orderBy("id").limit(10).build();

        System.out.println(query2.build());
    }
}

