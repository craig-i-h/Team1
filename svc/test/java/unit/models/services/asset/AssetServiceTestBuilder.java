package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.UnavailableServiceOperation;
import org.mockito.Mockito;

/**
 * Created by a613794 on 20/01/2016.
 */
public class AssetServiceTestBuilder {


    private JsonNode jsonNode;
    private AssetService assetService;
    private CreateAssetServiceOperation createAssetServiceOperation;
    private ListAssetServiceOperation listAssetServiceOperation;
    private UpdateAssetServiceOperation updateAssetServiceOperation;
    private DeleteAssetServiceOperation deleteAssetServiceOperation;
    private GetAssetServiceOperation getAssetServiceOperation;
    private JSONHelper jsonHelper;

    void createTestObjects()
    {
        createAssetServiceOperation = Mockito.mock(CreateAssetServiceOperation.class);
        listAssetServiceOperation = Mockito.mock(ListAssetServiceOperation.class);
        updateAssetServiceOperation = Mockito.mock(UpdateAssetServiceOperation.class);
        deleteAssetServiceOperation = Mockito.mock(DeleteAssetServiceOperation.class);
        getAssetServiceOperation = Mockito.mock(GetAssetServiceOperation.class);
        listAssetServiceOperation = Mockito.mock(ListAssetServiceOperation.class);
        jsonHelper = Mockito.mock(JSONHelper.class);
        jsonNode = Mockito.mock(JsonNode.class);
        Mockito.when(listAssetServiceOperation.execute(jsonHelper.toJson(""))).thenReturn(jsonNode);


        Mockito.when(deleteAssetServiceOperation.execute(jsonNode)).thenReturn(jsonNode);
        Mockito.when(createAssetServiceOperation.execute(jsonNode)).thenReturn(jsonNode);
        Mockito.when(updateAssetServiceOperation.execute(jsonNode)).thenReturn(jsonNode);
        Mockito.when(getAssetServiceOperation.execute(jsonNode)).thenReturn(jsonNode);
        Mockito.when(listAssetServiceOperation.execute(new JSONHelper().toJson(""))).thenReturn(new JSONHelper().toJson(""));

        assetService = new AssetService(new UnavailableServiceOperation(new JSONHelper()), createAssetServiceOperation,
                listAssetServiceOperation, updateAssetServiceOperation, deleteAssetServiceOperation,
                getAssetServiceOperation,new JSONHelper()
        );
    }

    public AssetService getAssetService() {
        return assetService;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public ListAssetServiceOperation getListAssetServiceOperation() {
        return listAssetServiceOperation;
    }

    public JSONHelper getJsonHelper() {
        return jsonHelper;
    }
}
