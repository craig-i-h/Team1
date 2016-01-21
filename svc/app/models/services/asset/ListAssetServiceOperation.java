package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.AssetEntity;
import models.services.ServiceOperation;
import play.Logger;

import java.util.List;

/**
 * Created by a613794 on 20/01/2016.
 */
public class ListAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListAssetServiceOperation.class);
    private AssetDao dao;
    private JSONHelper jsonHelper;

    @Inject
    public ListAssetServiceOperation(AssetDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;
        this.jsonHelper = jsonHelper;
    }

    @Override
    protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<AssetEntity> assets = dao.list();
        return jsonHelper.toJson(assets);
    }
}
