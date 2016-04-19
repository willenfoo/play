package org.apache.play.cache;

public interface ICacheVersion<T> extends ICacheable<T> {

	public int incrObjVersion(String objName, String tabNameSuffix);

	public int incrObjRecVersion(String objName, String tabNameSuffix);

	public int incrObjTabVersion(String objName, String tabNameSuffix);
}
