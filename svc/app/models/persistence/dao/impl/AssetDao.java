package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;

import javax.inject.Inject;

public class AssetDao extends GenericDao<AssetEntity>
{
    @Inject
    public AssetDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    //Add methods for any Project Entity specific database accesses here.
}
