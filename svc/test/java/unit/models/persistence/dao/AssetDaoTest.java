package models.persistence.dao;

import models.persistence.dao.impl.AssetDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.mockito.Mockito;

import java.util.List;

/**
 * Created by a613794 on 19/01/2016.
 */
public class AssetDaoTest {

    private AssetDaoTestBuilder testBuilder = new AssetDaoTestBuilder();
    private EntityManager em;
    private AssetEntity asset;
    private AssetDao assetDao;
    private List<AssetEntity> assetList;

    @Before
    public void before() {
        testBuilder.createTestObjects();
        EntityManagerProvider emp = testBuilder.getEmp();
        em = testBuilder.getEm();
        asset = testBuilder.getAsset();
        assetDao = new AssetDao(emp);
    }

    @Test
    public void createAssetTest() {
        assetDao.create(asset);
        Mockito.verify(em, Mockito.times(1)).persist(asset);
    }

    @Test
    public void deleteAssetTest() {
        assetDao.delete(1L);
        Mockito.verify(em, Mockito.times(1)).getReference(AssetEntity.class, 1L);
    }

    @Test
    public void updateAssetTest() {
        assetDao.update(asset);
        Mockito.verify(em, Mockito.times(1)).merge(asset);
    }

    @Test
    public void findAssetTest() {
        assetDao.find(1L);
        Mockito.verify(em, Mockito.times(1)).find(AssetEntity.class, 1L);
    }

    @Test
    public void listAssetTest() {
        assetList = assetDao.list();
        Assert.assertEquals(assetList, testBuilder.getResultList());
    }
}
