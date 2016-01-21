package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import models.persistence.entities.AssetEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by a613794 on 20/01/2016.
 */
public class UpdateAssetServiceOperationTest {

    private JsonNode jsonNode;
    private AssetEntity assetEntity;

    @Test
    public void doExecuteTest()
    {
        AssetServiceTestBuilder assetServiceTestBuilder = new AssetServiceTestBuilder();
        assetServiceTestBuilder.createTestObjects();
        AssetService assetService = assetServiceTestBuilder.getAssetService();
        JsonNode jsonNode = assetService.update(assetServiceTestBuilder.getJsonNode());
        Assert.assertEquals(jsonNode, assetServiceTestBuilder.getJsonNode());
    }



}
