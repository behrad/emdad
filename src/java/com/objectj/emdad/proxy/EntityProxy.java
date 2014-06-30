
package com.objectj.emdad.proxy;

import com.objectj.jsa.model.ValueObject;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.proxy.ProxyReferenceException;

import java.sql.ResultSet;
import java.sql.Connection;

public interface EntityProxy {
	public ValueObject create() throws ProxyException;
	public ValueObject create(ValueObject valueObject) throws ProxyException;
	public void update(ValueObject valueObject) throws ProxyException;
    public void updateRela(String id, String[] relaIds) throws ProxyException ;
	public void remove(ValueObject valueObject) throws ProxyException, ProxyReferenceException;
	public void remove(String id) throws ProxyException, ProxyReferenceException;
	public void remove(String[] ids) throws ProxyException, ProxyReferenceException;
	public ValueObject read(String id) throws ProxyException;
	public QueryResult readByEntityId(java.lang.Integer entityId) throws ProxyException;
	public QueryResult read(ValueObject valueObject) throws ProxyException;
	public QueryResult read(String[] ids) throws ProxyException;
	// public QueryResult readAll() throws ProxyException;
	// public QueryResult select(QueryObject queryObject) throws ProxyException;
	// public QueryResult readLimit(int fromIndex, int toIndex) throws ProxyException;
	// public QueryResult readLimitSort(QueryObject queryObject) throws ProxyException;
	// public QueryResult readAllSort(QueryObject queryObject) throws ProxyException;
	// public QueryResult where(QueryObject queryObject) throws ProxyException;
	// public QueryResult advanceReadLimit(QueryObject queryObject) throws ProxyException;
    public ValueObject modelToList(Object o) ;
    public ValueObject resultSetToList(ResultSet resultSet) ;
	public QueryResult readList(QueryObject queryObject) throws ProxyException;
	public QueryResult readModel(QueryObject queryObject) throws ProxyException;
	public QueryResult readCombo(String table, String field) throws ProxyException;
    public QueryResult readCombo(String table, String field, String filter) throws ProxyException;
    public QueryResult readCombo(String table, String field, String filter, String order) throws ProxyException;
	public ResultSet report(QueryObject queryObject, Connection connection) throws ProxyException;
}
