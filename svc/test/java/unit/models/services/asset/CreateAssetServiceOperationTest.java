package models.services.asset;


import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Created by a613794 on 20/01/2016.
 */
public class CreateAssetServiceOperationTest {


    @Test
    public void CreateAssetEntityTest()
    {
        AssetServiceTestBuilder assetServiceTestBuilder = new AssetServiceTestBuilder();
        assetServiceTestBuilder.createTestObjects();
        AssetService assetService = assetServiceTestBuilder.getAssetService();
        JsonNode jsonNode = assetService.create(assetServiceTestBuilder.getJsonNode());
        Assert.assertEquals(jsonNode, assetServiceTestBuilder.getJsonNode());
    }


}
