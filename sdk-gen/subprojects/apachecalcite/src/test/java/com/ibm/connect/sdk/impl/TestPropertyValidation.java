/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.ibm.connect.sdk.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yourorganizationname.connect.apachecalcite.ApacheCalciteConnectorFactory;
import com.ibm.wdp.connect.common.sdk.api.models.ConnectionProperties;

public class TestPropertyValidation
{
    /**
     * Test connection properties negative.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testConnectionPropertiesNegative()
    {
        final String typeName = "TODO";
        final ConnectionProperties properties = new ConnectionProperties();
        // Setup connection properties
        ApacheCalciteConnectorFactory.getInstance().createConnector(typeName, properties);
    }

    /**
     * Test connection properties.
     */
    @Test
    public void testConnectionProperties()
    {
        final String typeName = "apachecalcite";
        final ConnectionProperties properties = new ConnectionProperties();
        // Setup connection properties
        assertNotNull(ApacheCalciteConnectorFactory.getInstance().createConnector(typeName, properties));
    }
}
