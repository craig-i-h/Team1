package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.AssetEntity;
import models.services.ServiceOperation;
import play.Logger;

/**
 * Created by a613794 on 20/01/2016.
 */
public class UpdateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateAssetServiceOperation.class);

    private AssetDao dao;

    @Inject
    public UpdateAssetServiceOperation(AssetDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        AssetEntity asset = getAssetEntity(jsonRequest);

        dao.update(asset);

        return jsonRequest;
    }

    private AssetEntity getAssetEntity(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ID_PROPERTY).textValue());

        AssetEntity asset = dao.find(id);

        asset.setAssetOwner(jsonRequest.findPath(WsdsConstants.ASSET_JSON_OWNER_PROPERTY).textValue());

        asset.setAssetType(jsonRequest.findPath(WsdsConstants.ASSET_JSON_TYPE_PROPERTY).textValue());

        asset.setAdditionalInfo(jsonRequest.findPath(WsdsConstants.ASSET_JSON_INFO_PROPERTY).textValue());

        return asset;
    }
}
