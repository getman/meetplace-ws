package ru.aparfenov.meetplace.dao.db;

/**
 * Created by ArtemParfenov on 23.05.2018.
 */
public class PreparedStatementParam {
    private PreparedStatementParamType type;
    private String name;
    private Object value;

    /**returns optional qutation mark for the parmaeter (for example if it is of String type)*/
    public String getQuotationMark() {
        return type.getQuotatuion();
    }

    public PreparedStatementParamType getType() {
        return type;
    }

    public PreparedStatementParam setType(PreparedStatementParamType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public PreparedStatementParam setName(String name) {
        this.name = name;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public PreparedStatementParam setValue(Object value) {
        this.value = value;
        return this;
    }
}
