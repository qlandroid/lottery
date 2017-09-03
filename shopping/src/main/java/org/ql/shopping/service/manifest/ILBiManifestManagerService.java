package org.ql.shopping.service.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestLBiChange;

public interface ILBiManifestManagerService {

	public void addManifest(ManifestLBiChange manager);

	public void updateById(ManifestLBiChange manager);

	public void deleteById(ManifestLBiChange manager);

	public List<ManifestLBiChange> findAnd(ManifestLBiChange manager);

	public List<ManifestLBiChange> findOr(ManifestLBiChange manager);

	public Long getTotalCount(ManifestLBiChange manager);

	public Long getTotalCountOr(ManifestLBiChange manager);

	public Long getTotalCountAnd(ManifestLBiChange manager);

}
