package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by a613794 on 21/01/2016.
 */
public class DeleteAssetServiceTest {

    @Test
    public void deleteServiceOpTest() {
        AssetServiceTestBuilder assetServiceTestBuilder = new AssetServiceTestBuilder();
        assetServiceTestBuilder.createTestObjects();
        AssetService assetService = assetServiceTestBuilder.getAssetService();
        JsonNode jsonNode = assetService.delete(assetServiceTestBuilder.getJsonNode());
        Assert.assertEquals(jsonNode, assetServiceTestBuilder.getJsonNode());
    }
}
