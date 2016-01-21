package models.persistence.dao;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.mockito.Mockito;
import play.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 20/01/2016.
 */
public class AssetDaoTestBuilder {

    private EntityManagerProvider emp;

    private EntityManager em;

    private AssetEntity asset;

    private Query query;

        private List<AssetEntity> resultList;

    void createTestObjects() {
        emp = Mockito.mock(EntityManagerProvider.class);
        em = Mockito.mock(EntityManager.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
        asset = new AssetEntity();
        query = Mockito.mock(Query.class);
        resultList = new ArrayList<>();
        Mockito.when(emp.getEntityManager()).thenReturn(em);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(resultList);
    }

    public Query getQuery()
    {
        return query;
    }

    public List<AssetEntity> getResultList()
    {
        return resultList;
    }

    public EntityManagerProvider getEmp() {
        return emp;
    }

    public EntityManager getEm() {
        return em;
    }

    public AssetEntity getAsset() {
        return asset;
    }
}
