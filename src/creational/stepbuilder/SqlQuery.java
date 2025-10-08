package creational.stepbuilder;

public class SqlQuery {
    private String select;
    private String from;
    private String where;
    private String orderBy;
    private Integer limit;

    private SqlQuery() {
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append(select)
                .append(" FROM ").append(from);

        if (where != null) sb.append(" WHERE ").append(where);
        if (orderBy != null) sb.append(" ORDER BY ").append(orderBy);
        if (limit != null) sb.append(" LIMIT ").append(limit);

        return sb.toString();
    }

    // ---------- Step Builder ----------
    public static SelectStep builder() {
        return new Steps();
    }

    public interface SelectStep {
        FromStep select(String columns);
    }

    public interface FromStep {
        WhereStep from(String table);
    }

    public interface WhereStep {
        WhereStep where(String condition); // can be repeated

        OrderByStep orderBy(String order);

        LimitStep limit(int limit);

        SqlQuery build();
    }

    public interface OrderByStep {
        LimitStep limit(int limit);

        SqlQuery build();
    }

    public interface LimitStep {
        SqlQuery build();
    }

    private static class Steps implements SelectStep, FromStep, WhereStep, OrderByStep, LimitStep {
        private final SqlQuery query = new SqlQuery();

        @Override
        public FromStep select(String columns) {
            query.select = columns;
            return this;
        }

        @Override
        public WhereStep from(String table) {
            query.from = table;
            return this;
        }

        @Override
        public WhereStep where(String condition) {
            if (query.where == null) query.where = condition;
            else query.where += " AND " + condition;
            return this;
        }

        @Override
        public OrderByStep orderBy(String order) {
            query.orderBy = order;
            return this;
        }

        @Override
        public LimitStep limit(int limit) {
            query.limit = limit;
            return this;
        }

        @Override
        public SqlQuery build() {
            return query;
        }
    }
}

