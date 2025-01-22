package com.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggleService {

    @Value("${feature.toggle.product.enabled:true}")
    private boolean productFeatureEnabled;

    public boolean isProductFeatureEnabled() {
        return productFeatureEnabled;
    }
}
