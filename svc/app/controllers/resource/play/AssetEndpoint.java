package controllers.resource.play;

import com.google.inject.Inject;
import models.services.asset.AssetService;
import play.Logger;

/**
 * Created by a613794 on 21/01/2016.
 */
public class AssetEndpoint extends ResourceEndpoint<AssetService> {

        private static final Logger.ALogger logger = Logger.of(AssetEndpoint.class);

        @Inject public AssetEndpoint(AssetService assetService)
        {
            super(assetService);
        }
    }
