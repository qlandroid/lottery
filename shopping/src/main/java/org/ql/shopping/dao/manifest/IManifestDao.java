package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.Manifest;

public interface IManifestDao {
	public int addManifest(Manifest manifest);

	public List<Manifest> findAll();

	public List<Manifest> find(Manifest manifest);

	public int update(Manifest manifest);

	public int deleteOfId(long id);

}
