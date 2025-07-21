package org.example.jmx;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.example.service.ProductService;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class ProductMonitor implements ProductMonitorMBean{
    @Inject
    private ProductService productService;

    private int cachedProductCount;

    @PostConstruct
    public void registerMBean() {
        try {
            ObjectName name = new ObjectName("org.example.jmx:type=ProductMonitor");
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            mbs.registerMBean(this, name);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register MBean", e);
        }
    }

    @Override
    public int getTotalProducts() {
        return productService.getProducts().size();
    }

    @Override
    public void clearCache() {
        System.out.println("[JMX] Clearing product cache...");
        cachedProductCount = 0;
    }
}
