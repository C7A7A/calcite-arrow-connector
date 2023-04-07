/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.apachecalcite;

import java.util.Arrays;

import com.ibm.connect.sdk.api.ConnectorFactory;
import com.ibm.wdp.connect.common.sdk.api.models.ConnectionProperties;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightDatasourceTypes;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class ApacheCalciteConnectorFactory implements ConnectorFactory
{
    private static final ApacheCalciteConnectorFactory INSTANCE = new ApacheCalciteConnectorFactory();

    /**
     * A connector factory instance.
     *
     * @return a connector factory instance
     */
    public static ApacheCalciteConnectorFactory getInstance()
    {
        return INSTANCE;
    }

    /**
     * Creates a connector for the given data source type.
     *
     * @param datasourceTypeName
     *            the name of the data source type
     * @param properties
     *            connection properties
     * @return a connector for the given data source type
     */
    @Override
    public ApacheCalciteConnector createConnector(String datasourceTypeName, ConnectionProperties properties)
    {
        if ("apachecalcite".equals(datasourceTypeName)) {
            return new ApacheCalciteConnector(properties);
        }
        throw new UnsupportedOperationException(datasourceTypeName + " is not supported!");
    }

    @Override
    public CustomFlightDatasourceTypes getDatasourceTypes()
    {
        return new CustomFlightDatasourceTypes().datasourceTypes(Arrays.asList(new ApacheCalciteDatasourceType()));
    }
}
