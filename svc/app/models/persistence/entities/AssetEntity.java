package models.persistence.entities;

import javax.persistence.*;

/**
 * Created by a585493 on 18/01/2016.
 */
@Table(name = "asset")
@Entity
public class AssetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_owner", nullable = false)
    private String assetOwner;

    @Column(name = "asset_type", nullable = false)
    private String assetType;

    @Column(name = "additional_information", nullable = false)
    private String additionalInfo;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetOwner() {
        return assetOwner;
    }
    public void setAssetOwner(String name) {
        this.assetOwner = name;
    }


    public String getAssetType() {
        return assetType;
    }
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
    public void setAdditionalInfo(String info) {
        this.additionalInfo = info;
    }



}
