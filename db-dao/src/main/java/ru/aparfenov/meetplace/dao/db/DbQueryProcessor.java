package ru.aparfenov.meetplace.dao.db;

import java.util.List;

/** Responsible for processing the database query result
 * Created by ArtemParfenov on 23.04.2018.
 */
public abstract class DbQueryProcessor<T> {
    /**returns the query processing result as a list of data*/
    public abstract List<T> receiveProcessedData(DbQuery dbQuery);
    /**performs the data processing (maybe saving into DB or some)*/
    public abstract void processData();
}
