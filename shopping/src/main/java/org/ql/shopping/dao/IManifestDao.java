package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.Manifest;

public interface IManifestDao {
	public int addManifest(Manifest manifest);
	
	public List<Manifest> findAll();
	
	public List<Manifest> find(Manifest manifest);
	
	public int update(Manifest manifest);
	
	public int deleteOfId(long id);
	
}
