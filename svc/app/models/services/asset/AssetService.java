package models.services.asset;

import akka.dispatch.sysmsg.Create;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import models.services.project.FindProjectServiceOperation;

/**
 * Created by a613794 on 20/01/2016.
 */
public class AssetService extends Service {

    private CreateAssetServiceOperation createAssetServiceOperation;
    private ListAssetServiceOperation listAssetServiceOperation;
    private UpdateAssetServiceOperation updateAssetServiceOperation;
    private DeleteAssetServiceOperation deleteAssetServiceOperation;
    private GetAssetServiceOperation getAssetServiceOperation;
    private JSONHelper jsonHelper;

    @Inject
    public AssetService(UnavailableServiceOperation unavailableServiceOperation,
                        CreateAssetServiceOperation createAssetServiceOperation,
                        ListAssetServiceOperation listAssetServiceOperation,
                        UpdateAssetServiceOperation updateAssetServiceOperation,
                        DeleteAssetServiceOperation deleteAssetServiceOperation,
                        GetAssetServiceOperation getAssetServiceOperation,
                        JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);
        this.createAssetServiceOperation = createAssetServiceOperation;

        this.listAssetServiceOperation = listAssetServiceOperation;

        this.updateAssetServiceOperation = updateAssetServiceOperation;

        this.deleteAssetServiceOperation = deleteAssetServiceOperation;

        this.getAssetServiceOperation = getAssetServiceOperation;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listAssetServiceOperation.execute(jsonHelper.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteAssetServiceOperation.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return getAssetServiceOperation.execute(identifier);
    }


}
