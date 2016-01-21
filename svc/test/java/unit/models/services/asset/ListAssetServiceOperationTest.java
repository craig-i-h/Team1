package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by a613794 on 21/01/2016.
 */
public class ListAssetServiceOperationTest {

    @Test
    public void listAssetServiceTest()
    {
        AssetServiceTestBuilder assetServiceTestBuilder = new AssetServiceTestBuilder();
        assetServiceTestBuilder.createTestObjects();
        AssetService assetService = assetServiceTestBuilder.getAssetService();
        JsonNode jsonNode = assetService.list();
        Assert.assertEquals(jsonNode, new JSONHelper().toJson(""));
    }
}
