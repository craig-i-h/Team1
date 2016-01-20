package models.persistence.entities;

import org.junit.*;

/**
 * Created by a613794 on 19/01/2016.
 */
public class AssetEntityTest {

    private AssetEntity assetEntity = new AssetEntity();

    @Before
    public void before()
    {
        assetEntity.setId(1L);
        assetEntity.setAssetOwner("Owner");
        assetEntity.setAssetType("TV");
        assetEntity.setAdditionalInfo("Curved");
    }

    @Test
    public void idTest()
    {
        Assert.assertTrue(assetEntity.getId() == 1L);
    }

    @Test
    public void assetOwnerTest()
    {
        Assert.assertEquals(assetEntity.getAssetOwner(), "Owner");
    }

    @Test
    public void assetTypeTest()
    {
          Assert.assertEquals(assetEntity.getAssetType(), "TV");
    }
    @Test
    public void additionalInfoTest()
    {
        Assert.assertEquals(assetEntity.getAdditionalInfo(), "Curved");
    }
}
