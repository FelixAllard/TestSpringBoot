package com.example.ChamplainPhoneApp2.common;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
public class InventoryIdentifier {

    private String inventoryId;

    public InventoryIdentifier() {
        this.inventoryId = UUID.randomUUID().toString();
    }

    public InventoryIdentifier(String inventoryId) {
        this.inventoryId = inventoryId;
    }

}
