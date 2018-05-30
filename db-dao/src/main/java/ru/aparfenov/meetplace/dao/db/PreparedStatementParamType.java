package ru.aparfenov.meetplace.dao.db;

/**
 * Created by ArtemParfenov on 23.05.2018.
 */
public enum PreparedStatementParamType {
    STRING("'"),
    NUMBER("");
    private String quotation;
    PreparedStatementParamType(String newQuotation) {
        quotation = newQuotation;
    }

    public String getQuotatuion() {
        return quotation;
    }
}
