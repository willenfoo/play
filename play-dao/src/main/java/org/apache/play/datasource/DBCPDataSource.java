package org.apache.play.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSource extends BasicDataSource implements IDataSource {
	private BasicDataSource datasource = new BasicDataSource();

	
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public int getInitialSize() {
		return datasource.getInitialSize();
	}

	
	public void setInitialSize(int initialSize) {
		datasource.setInitialSize(initialSize);
	}

	
	public int getMaxActive() {
		return datasource.getMaxActive();
	}

	
	public void setMaxActive(int maxActive) {
		datasource.setMaxActive(maxActive);
	}

	
	public int getMinIdle() {
		return datasource.getMinIdle();
	}

	
	public void setMinIdle(int minIdle) {
		datasource.setMinIdle(minIdle);
	}

	
	public int getMaxIdle() {
		return datasource.getMaxIdle();
	}

	
	public void setMaxIdle(int maxIdle) {
		datasource.setMaxIdle(maxIdle);
	}

	
	public long getMaxWait() {
		return datasource.getMaxWait();
	}

	
	public void setMaxWait(long maxWait) {
		datasource.setMaxWait(maxWait);
	}

	
	public boolean isPoolPreparedStatements() {
		return datasource.isPoolPreparedStatements();
	}

	
	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.datasource.setPoolPreparedStatements(poolPreparedStatements);
	}

	
	public boolean getDefaultReadOnly() {
		return datasource.getDefaultReadOnly();
	}

	
	public void setDefaultReadOnly(boolean defaultReadOnly) {
		this.datasource.setDefaultReadOnly(defaultReadOnly);
	}

	
	public boolean getLogAbandoned() {
		return datasource.getLogAbandoned();
	}

	
	public void setLogAbandoned(boolean logAbandoned) {
		datasource.setLogAbandoned(logAbandoned);
	}

	
	public boolean getRemoveAbandoned() {
		return datasource.getRemoveAbandoned();
	}

	
	public void setRemoveAbandoned(boolean removeAbandoned) {
		datasource.setRemoveAbandoned(removeAbandoned);
	}

	
	public int getRemoveAbandonedTimeout() {
		return datasource.getRemoveAbandonedTimeout();
	}

	
	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
	}

	
	public boolean getTestOnBorrow() {
		return datasource.getTestOnBorrow();
	}

	
	public void setTestOnBorrow(boolean testOnBorrow) {
		datasource.setTestOnBorrow(testOnBorrow);
	}

	
	public boolean getTestWhileIdle() {
		return datasource.getTestWhileIdle();
	}

	
	public void setTestWhileIdle(boolean testWhileIdle) {
		datasource.setTestWhileIdle(testWhileIdle);
	}

	
	public Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

	
	public Connection getConnection(String username, String password)
			throws SQLException {
		return datasource.getConnection(username, password);
	}

	
	public PrintWriter getLogWriter() throws SQLException {
		return datasource.getLogWriter();
	}

	
	public void setLogWriter(PrintWriter out) throws SQLException {
		datasource.setLogWriter(out);
	}

	
	public void setLoginTimeout(int seconds) throws SQLException {
		datasource.setLoginTimeout(seconds);
	}

	
	public int getLoginTimeout() throws SQLException {
		return datasource.getLoginTimeout();
	}

	
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return datasource.unwrap(iface);
	}

	
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return datasource.isWrapperFor(iface);
	}

	
	public String getDriverClassName() {
		return datasource.getDriverClassName();
	}

	
	public void setDriverClassName(String driverClassName) {
		datasource.setDriverClassName(driverClassName);
	}

	
	public String getUrl() {
		return datasource.getUrl();
	}

	
	public void setUrl(String url) {
		this.datasource.setUrl(url);
	}

	
	public String getUsername() {
		return datasource.getUsername();
	}

	
	public void setUsername(String username) {
		datasource.setUsername(username);
	}

	
	public String getPassword() {
		return datasource.getPassword();
	}

	
	public void setPassword(String password) {
		datasource.setPassword(password);
	}

	
	public String getValidationQuery() {
		return datasource.getValidationQuery();
	}

	
	public void setValidationQuery(String validationQuery) {
		datasource.setValidationQuery(validationQuery);
	}

	
	public long getMinEvictableIdleTimeMillis() {
		return datasource.getMinEvictableIdleTimeMillis();
	}

	
	public long getTimeBetweenEvictionRunsMillis() {
		return datasource.getTimeBetweenEvictionRunsMillis();
	}

	
	public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	}

	
	public void setTimeBetweenEvictionRunsMillis(
			long timeBetweenEvictionRunsMillis) {
		datasource
				.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	}

	
	public int getMaxOpenPreparedStatements() {
		return datasource.getMaxOpenPreparedStatements();
	}

	
	public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
		datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
	}

	
	public void close() throws SQLException {
		datasource.close();
	}
}
