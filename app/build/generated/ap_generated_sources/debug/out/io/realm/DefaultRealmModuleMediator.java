package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(29);
        modelClasses.add(com.mds.ventasabpollo.models.MapRoutes.class);
        modelClasses.add(com.mds.ventasabpollo.models.TopArticles.class);
        modelClasses.add(com.mds.ventasabpollo.models.DetailsSales.class);
        modelClasses.add(com.mds.ventasabpollo.models.RechargeInventories.class);
        modelClasses.add(com.mds.ventasabpollo.models.Prices.class);
        modelClasses.add(com.mds.ventasabpollo.models.Cities.class);
        modelClasses.add(com.mds.ventasabpollo.models.Images.class);
        modelClasses.add(com.mds.ventasabpollo.models.ChangesInventories.class);
        modelClasses.add(com.mds.ventasabpollo.models.VisitsClasifications.class);
        modelClasses.add(com.mds.ventasabpollo.models.ChangesPrices.class);
        modelClasses.add(com.mds.ventasabpollo.models.VisitsClients.class);
        modelClasses.add(com.mds.ventasabpollo.models.Clients.class);
        modelClasses.add(com.mds.ventasabpollo.models.UseCFDI.class);
        modelClasses.add(com.mds.ventasabpollo.models.DetailsDepartures.class);
        modelClasses.add(com.mds.ventasabpollo.models.PrepareDeparture.class);
        modelClasses.add(com.mds.ventasabpollo.models.DetailsOrders.class);
        modelClasses.add(com.mds.ventasabpollo.models.ClientsLists.class);
        modelClasses.add(com.mds.ventasabpollo.models.Users.class);
        modelClasses.add(com.mds.ventasabpollo.models.Routes.class);
        modelClasses.add(com.mds.ventasabpollo.models.Articles.class);
        modelClasses.add(com.mds.ventasabpollo.models.Lists.class);
        modelClasses.add(com.mds.ventasabpollo.models.WayPay.class);
        modelClasses.add(com.mds.ventasabpollo.models.VisitsPayments.class);
        modelClasses.add(com.mds.ventasabpollo.models.VisitsMovements.class);
        modelClasses.add(com.mds.ventasabpollo.models.BranchOffices.class);
        modelClasses.add(com.mds.ventasabpollo.models.MethodPay.class);
        modelClasses.add(com.mds.ventasabpollo.models.Departures.class);
        modelClasses.add(com.mds.ventasabpollo.models.Inventories.class);
        modelClasses.add(com.mds.ventasabpollo.models.NewClients.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(29);
        infoMap.put(com.mds.ventasabpollo.models.MapRoutes.class, io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.TopArticles.class, io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.DetailsSales.class, io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.RechargeInventories.class, io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Prices.class, io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Cities.class, io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Images.class, io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.ChangesInventories.class, io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.VisitsClasifications.class, io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.ChangesPrices.class, io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.VisitsClients.class, io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Clients.class, io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.UseCFDI.class, io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.DetailsDepartures.class, io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.PrepareDeparture.class, io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.DetailsOrders.class, io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.ClientsLists.class, io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Users.class, io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Routes.class, io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Articles.class, io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Lists.class, io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.WayPay.class, io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.VisitsPayments.class, io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.VisitsMovements.class, io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.BranchOffices.class, io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.MethodPay.class, io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Departures.class, io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.Inventories.class, io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.mds.ventasabpollo.models.NewClients.class, io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            return io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            return io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            return io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            return io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            return io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            return io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            return io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            return io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            return io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            return io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            return io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            return io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            return io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            return io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            return io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            return io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            return io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            return io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            return io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            return io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            return io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            return io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            return io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            return io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            return io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            return io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            return io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            return io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            return io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            return "MapRoutes";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            return "TopArticles";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            return "DetailsSales";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            return "RechargeInventories";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            return "Prices";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            return "Cities";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            return "Images";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            return "ChangesInventories";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            return "VisitsClasifications";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            return "ChangesPrices";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            return "VisitsClients";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            return "Clients";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            return "UseCFDI";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            return "DetailsDepartures";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            return "PrepareDeparture";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            return "DetailsOrders";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            return "ClientsLists";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            return "Users";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            return "Routes";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            return "Articles";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            return "Lists";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            return "WayPay";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            return "VisitsPayments";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            return "VisitsMovements";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            return "BranchOffices";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            return "MethodPay";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            return "Departures";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            return "Inventories";
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            return "NewClients";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_PricesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_UsersRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_ListsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy());
            }
            if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
                return clazz.cast(new io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            com_mds_ventasabpollo_models_MapRoutesRealmProxy.MapRoutesColumnInfo columnInfo = (com_mds_ventasabpollo_models_MapRoutesRealmProxy.MapRoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.MapRoutes) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            com_mds_ventasabpollo_models_TopArticlesRealmProxy.TopArticlesColumnInfo columnInfo = (com_mds_ventasabpollo_models_TopArticlesRealmProxy.TopArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.TopArticles) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            com_mds_ventasabpollo_models_DetailsSalesRealmProxy.DetailsSalesColumnInfo columnInfo = (com_mds_ventasabpollo_models_DetailsSalesRealmProxy.DetailsSalesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsSales.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.DetailsSales) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.RechargeInventoriesColumnInfo columnInfo = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.RechargeInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.RechargeInventories) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            com_mds_ventasabpollo_models_PricesRealmProxy.PricesColumnInfo columnInfo = (com_mds_ventasabpollo_models_PricesRealmProxy.PricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Prices) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            com_mds_ventasabpollo_models_CitiesRealmProxy.CitiesColumnInfo columnInfo = (com_mds_ventasabpollo_models_CitiesRealmProxy.CitiesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Cities) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            com_mds_ventasabpollo_models_ImagesRealmProxy.ImagesColumnInfo columnInfo = (com_mds_ventasabpollo_models_ImagesRealmProxy.ImagesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Images) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.ChangesInventoriesColumnInfo columnInfo = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.ChangesInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.ChangesInventories) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.VisitsClasificationsColumnInfo columnInfo = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.VisitsClasificationsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.VisitsClasifications) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            com_mds_ventasabpollo_models_ChangesPricesRealmProxy.ChangesPricesColumnInfo columnInfo = (com_mds_ventasabpollo_models_ChangesPricesRealmProxy.ChangesPricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.ChangesPrices) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            com_mds_ventasabpollo_models_VisitsClientsRealmProxy.VisitsClientsColumnInfo columnInfo = (com_mds_ventasabpollo_models_VisitsClientsRealmProxy.VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.VisitsClients) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            com_mds_ventasabpollo_models_ClientsRealmProxy.ClientsColumnInfo columnInfo = (com_mds_ventasabpollo_models_ClientsRealmProxy.ClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Clients) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            com_mds_ventasabpollo_models_UseCFDIRealmProxy.UseCFDIColumnInfo columnInfo = (com_mds_ventasabpollo_models_UseCFDIRealmProxy.UseCFDIColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.UseCFDI) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.DetailsDeparturesColumnInfo columnInfo = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.DetailsDeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.DetailsDepartures) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.PrepareDepartureColumnInfo columnInfo = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.PrepareDepartureColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.PrepareDeparture) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.DetailsOrdersColumnInfo columnInfo = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.DetailsOrders) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            com_mds_ventasabpollo_models_ClientsListsRealmProxy.ClientsListsColumnInfo columnInfo = (com_mds_ventasabpollo_models_ClientsListsRealmProxy.ClientsListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.ClientsLists) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            com_mds_ventasabpollo_models_UsersRealmProxy.UsersColumnInfo columnInfo = (com_mds_ventasabpollo_models_UsersRealmProxy.UsersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Users) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            com_mds_ventasabpollo_models_RoutesRealmProxy.RoutesColumnInfo columnInfo = (com_mds_ventasabpollo_models_RoutesRealmProxy.RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Routes) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            com_mds_ventasabpollo_models_ArticlesRealmProxy.ArticlesColumnInfo columnInfo = (com_mds_ventasabpollo_models_ArticlesRealmProxy.ArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Articles) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            com_mds_ventasabpollo_models_ListsRealmProxy.ListsColumnInfo columnInfo = (com_mds_ventasabpollo_models_ListsRealmProxy.ListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Lists) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            com_mds_ventasabpollo_models_WayPayRealmProxy.WayPayColumnInfo columnInfo = (com_mds_ventasabpollo_models_WayPayRealmProxy.WayPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.WayPay.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.WayPay) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.VisitsPaymentsColumnInfo columnInfo = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.VisitsPaymentsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.VisitsPayments) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.VisitsMovementsColumnInfo columnInfo = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.VisitsMovementsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.VisitsMovements) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            com_mds_ventasabpollo_models_BranchOfficesRealmProxy.BranchOfficesColumnInfo columnInfo = (com_mds_ventasabpollo_models_BranchOfficesRealmProxy.BranchOfficesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.BranchOffices) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            com_mds_ventasabpollo_models_MethodPayRealmProxy.MethodPayColumnInfo columnInfo = (com_mds_ventasabpollo_models_MethodPayRealmProxy.MethodPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.MethodPay) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            com_mds_ventasabpollo_models_DeparturesRealmProxy.DeparturesColumnInfo columnInfo = (com_mds_ventasabpollo_models_DeparturesRealmProxy.DeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Departures) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            com_mds_ventasabpollo_models_InventoriesRealmProxy.InventoriesColumnInfo columnInfo = (com_mds_ventasabpollo_models_InventoriesRealmProxy.InventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Inventories.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.Inventories) obj, update, cache, flags));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            com_mds_ventasabpollo_models_NewClientsRealmProxy.NewClientsColumnInfo columnInfo = (com_mds_ventasabpollo_models_NewClientsRealmProxy.NewClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class);
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.copyOrUpdate(realm, columnInfo, (com.mds.ventasabpollo.models.NewClients) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.MapRoutes) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.TopArticles) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsSales) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.RechargeInventories) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Prices) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Cities) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Images) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ChangesInventories) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsClasifications) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ChangesPrices) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsClients) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Clients) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insert(realm, (com.mds.ventasabpollo.models.UseCFDI) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsDepartures) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insert(realm, (com.mds.ventasabpollo.models.PrepareDeparture) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsOrders) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ClientsLists) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Users) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Routes) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Articles) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Lists) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insert(realm, (com.mds.ventasabpollo.models.WayPay) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsPayments) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsMovements) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.BranchOffices) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insert(realm, (com.mds.ventasabpollo.models.MethodPay) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Departures) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Inventories) object, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.NewClients) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
                io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.MapRoutes) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
                io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.TopArticles) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsSales) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
                io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.RechargeInventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
                io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Prices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
                io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Cities) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
                io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Images) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
                io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ChangesInventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsClasifications) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
                io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ChangesPrices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsClients) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
                io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Clients) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
                io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insert(realm, (com.mds.ventasabpollo.models.UseCFDI) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsDepartures) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
                io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insert(realm, (com.mds.ventasabpollo.models.PrepareDeparture) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insert(realm, (com.mds.ventasabpollo.models.DetailsOrders) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
                io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.ClientsLists) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
                io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Users) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
                io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Routes) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
                io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Articles) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
                io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Lists) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
                io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insert(realm, (com.mds.ventasabpollo.models.WayPay) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsPayments) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.VisitsMovements) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
                io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.BranchOffices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
                io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insert(realm, (com.mds.ventasabpollo.models.MethodPay) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
                io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Departures) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
                io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insert(realm, (com.mds.ventasabpollo.models.Inventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
                io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insert(realm, (com.mds.ventasabpollo.models.NewClients) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
                    io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
                    io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
                    io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
                    io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
                    io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
                    io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
                    io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
                    io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
                    io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
                    io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
                    io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
                    io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
                    io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
                    io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
                    io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
                    io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
                    io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
                    io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
                    io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.MapRoutes) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.TopArticles) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsSales) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.RechargeInventories) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Prices) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Cities) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Images) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ChangesInventories) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsClasifications) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ChangesPrices) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsClients) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Clients) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.UseCFDI) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsDepartures) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.PrepareDeparture) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsOrders) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ClientsLists) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Users) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Routes) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Articles) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Lists) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.WayPay) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsPayments) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsMovements) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.BranchOffices) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.MethodPay) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Departures) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Inventories) obj, cache);
        } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.NewClients) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
                io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.MapRoutes) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
                io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.TopArticles) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsSales) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
                io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.RechargeInventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
                io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Prices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
                io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Cities) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
                io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Images) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
                io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ChangesInventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsClasifications) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
                io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ChangesPrices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsClients) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
                io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Clients) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
                io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.UseCFDI) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsDepartures) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
                io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.PrepareDeparture) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
                io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.DetailsOrders) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
                io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.ClientsLists) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
                io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Users) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
                io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Routes) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
                io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Articles) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
                io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Lists) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
                io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.WayPay) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsPayments) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
                io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.VisitsMovements) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
                io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.BranchOffices) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
                io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.MethodPay) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
                io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Departures) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
                io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.Inventories) object, cache);
            } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
                io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insertOrUpdate(realm, (com.mds.ventasabpollo.models.NewClients) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
                    io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
                    io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
                    io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
                    io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
                    io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
                    io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
                    io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
                    io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
                    io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
                    io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
                    io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
                    io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
                    io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
                    io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
                    io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
                    io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
                    io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
                    io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
                    io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
                    io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
                    io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
                    io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.mds.ventasabpollo.models.MapRoutes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.MapRoutes) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.TopArticles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.TopArticles) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsSales.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsSalesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.DetailsSales) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.RechargeInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.RechargeInventories) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Prices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PricesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Prices) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Cities.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Cities) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Images.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Images) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesInventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.ChangesInventories) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClasifications.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.VisitsClasifications) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ChangesPrices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.ChangesPrices) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.VisitsClients) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Clients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Clients) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.UseCFDI.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.UseCFDI) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsDepartures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.DetailsDepartures) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.PrepareDeparture.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.PrepareDeparture) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.DetailsOrders.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.DetailsOrders) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.ClientsLists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.ClientsLists) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Users.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_UsersRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Users) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Routes.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Routes) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Articles.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Articles) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Lists.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_ListsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Lists) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.WayPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_WayPayRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.WayPay) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsPayments.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.VisitsPayments) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.VisitsMovements.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.VisitsMovements) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.BranchOffices.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.BranchOffices) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.MethodPay.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.MethodPay) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Departures.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Departures) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.Inventories.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_InventoriesRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.Inventories) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mds.ventasabpollo.models.NewClients.class)) {
            return clazz.cast(io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy.createDetachedCopy((com.mds.ventasabpollo.models.NewClients) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
