package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.AssetEntity;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

/**
 * Created by a613794 on 20/01/2016.
 */
public class CreateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateAssetServiceOperation.class);

    private AssetDao dao;

    @Inject
    public CreateAssetServiceOperation(AssetDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        AssetEntity asset = getAssetEntity(jsonRequest);

        dao.create(asset);

        return jsonRequest;
    }

    private AssetEntity getAssetEntity(JsonNode jsonRequest)
    {
        AssetEntity asset = new AssetEntity();

        asset.setAssetOwner(jsonRequest.findPath(WsdsConstants.ASSET_JSON_OWNER_PROPERTY).textValue());

        asset.setAssetType(jsonRequest.findPath(WsdsConstants.ASSET_JSON_TYPE_PROPERTY).textValue());

        asset.setAdditionalInfo(jsonRequest.findPath(WsdsConstants.ASSET_JSON_INFO_PROPERTY).textValue());

        return asset;
    }
}
