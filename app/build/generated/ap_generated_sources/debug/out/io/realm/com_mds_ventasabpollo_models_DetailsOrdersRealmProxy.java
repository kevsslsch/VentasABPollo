package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_mds_ventasabpollo_models_DetailsOrdersRealmProxy extends com.mds.ventasabpollo.models.DetailsOrders
    implements RealmObjectProxy, com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface {

    static final class DetailsOrdersColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clave_articuloIndex;
        long articuloIndex;
        long visitaIndex;
        long pedidoIndex;
        long nombre_articuloIndex;
        long nombre_unidadIndex;
        long descripcion_extendidaIndex;
        long cantidadIndex;
        long precioIndex;
        long IVAIndex;
        long IEPSIndex;
        long tasa_IVAIndex;
        long tasa_IEPSIndex;
        long importeIndex;
        long es_creditoIndex;
        long enviadoIndex;
        long fecha_enviadoIndex;

        DetailsOrdersColumnInfo(OsSchemaInfo schemaInfo) {
            super(17);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DetailsOrders");
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.articuloIndex = addColumnDetails("articulo", "articulo", objectSchemaInfo);
            this.visitaIndex = addColumnDetails("visita", "visita", objectSchemaInfo);
            this.pedidoIndex = addColumnDetails("pedido", "pedido", objectSchemaInfo);
            this.nombre_articuloIndex = addColumnDetails("nombre_articulo", "nombre_articulo", objectSchemaInfo);
            this.nombre_unidadIndex = addColumnDetails("nombre_unidad", "nombre_unidad", objectSchemaInfo);
            this.descripcion_extendidaIndex = addColumnDetails("descripcion_extendida", "descripcion_extendida", objectSchemaInfo);
            this.cantidadIndex = addColumnDetails("cantidad", "cantidad", objectSchemaInfo);
            this.precioIndex = addColumnDetails("precio", "precio", objectSchemaInfo);
            this.IVAIndex = addColumnDetails("IVA", "IVA", objectSchemaInfo);
            this.IEPSIndex = addColumnDetails("IEPS", "IEPS", objectSchemaInfo);
            this.tasa_IVAIndex = addColumnDetails("tasa_IVA", "tasa_IVA", objectSchemaInfo);
            this.tasa_IEPSIndex = addColumnDetails("tasa_IEPS", "tasa_IEPS", objectSchemaInfo);
            this.importeIndex = addColumnDetails("importe", "importe", objectSchemaInfo);
            this.es_creditoIndex = addColumnDetails("es_credito", "es_credito", objectSchemaInfo);
            this.enviadoIndex = addColumnDetails("enviado", "enviado", objectSchemaInfo);
            this.fecha_enviadoIndex = addColumnDetails("fecha_enviado", "fecha_enviado", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        DetailsOrdersColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DetailsOrdersColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DetailsOrdersColumnInfo src = (DetailsOrdersColumnInfo) rawSrc;
            final DetailsOrdersColumnInfo dst = (DetailsOrdersColumnInfo) rawDst;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.articuloIndex = src.articuloIndex;
            dst.visitaIndex = src.visitaIndex;
            dst.pedidoIndex = src.pedidoIndex;
            dst.nombre_articuloIndex = src.nombre_articuloIndex;
            dst.nombre_unidadIndex = src.nombre_unidadIndex;
            dst.descripcion_extendidaIndex = src.descripcion_extendidaIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.precioIndex = src.precioIndex;
            dst.IVAIndex = src.IVAIndex;
            dst.IEPSIndex = src.IEPSIndex;
            dst.tasa_IVAIndex = src.tasa_IVAIndex;
            dst.tasa_IEPSIndex = src.tasa_IEPSIndex;
            dst.importeIndex = src.importeIndex;
            dst.es_creditoIndex = src.es_creditoIndex;
            dst.enviadoIndex = src.enviadoIndex;
            dst.fecha_enviadoIndex = src.fecha_enviadoIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DetailsOrdersColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.DetailsOrders> proxyState;

    com_mds_ventasabpollo_models_DetailsOrdersRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DetailsOrdersColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.DetailsOrders>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$clave_articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clave_articuloIndex);
    }

    @Override
    public void realmSet$clave_articulo(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'clave_articulo' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.articuloIndex);
    }

    @Override
    public void realmSet$articulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.articuloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.articuloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$visita() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.visitaIndex);
    }

    @Override
    public void realmSet$visita(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.visitaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.visitaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$pedido() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.pedidoIndex);
    }

    @Override
    public void realmSet$pedido(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.pedidoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.pedidoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_articuloIndex);
    }

    @Override
    public void realmSet$nombre_articulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_articuloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_articuloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_unidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_unidadIndex);
    }

    @Override
    public void realmSet$nombre_unidad(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_unidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_unidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_unidadIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_unidadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$descripcion_extendida() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcion_extendidaIndex);
    }

    @Override
    public void realmSet$descripcion_extendida(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descripcion_extendidaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descripcion_extendidaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descripcion_extendidaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descripcion_extendidaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$cantidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.cantidadIndex);
    }

    @Override
    public void realmSet$cantidad(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.cantidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.cantidadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$precio() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precioIndex);
    }

    @Override
    public void realmSet$precio(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$IVA() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.IVAIndex);
    }

    @Override
    public void realmSet$IVA(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.IVAIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.IVAIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$IEPS() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.IEPSIndex);
    }

    @Override
    public void realmSet$IEPS(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.IEPSIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.IEPSIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$tasa_IVA() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.tasa_IVAIndex);
    }

    @Override
    public void realmSet$tasa_IVA(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.tasa_IVAIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.tasa_IVAIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$tasa_IEPS() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.tasa_IEPSIndex);
    }

    @Override
    public void realmSet$tasa_IEPS(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.tasa_IEPSIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.tasa_IEPSIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$importe() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.importeIndex);
    }

    @Override
    public void realmSet$importe(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.importeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.importeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$es_credito() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.es_creditoIndex);
    }

    @Override
    public void realmSet$es_credito(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.es_creditoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.es_creditoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$enviado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.enviadoIndex);
    }

    @Override
    public void realmSet$enviado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.enviadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.enviadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_enviado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_enviadoIndex);
    }

    @Override
    public void realmSet$fecha_enviado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_enviadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_enviadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_enviadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_enviadoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DetailsOrders", 17, 0);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("articulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("pedido", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_articulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_unidad", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("descripcion_extendida", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("cantidad", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("IVA", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("IEPS", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tasa_IVA", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tasa_IEPS", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("importe", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("es_credito", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("enviado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha_enviado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DetailsOrdersColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DetailsOrdersColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DetailsOrders";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "DetailsOrders";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.DetailsOrders createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.DetailsOrders obj = null;
        if (update) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
            DetailsOrdersColumnInfo columnInfo = (DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
            long pkColumnIndex = columnInfo.clave_articuloIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("clave_articulo")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("clave_articulo"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("clave_articulo")) {
                if (json.isNull("clave_articulo")) {
                    obj = (io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.DetailsOrders.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.DetailsOrders.class, json.getInt("clave_articulo"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clave_articulo'.");
            }
        }

        final com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) obj;
        if (json.has("articulo")) {
            if (json.isNull("articulo")) {
                objProxy.realmSet$articulo(null);
            } else {
                objProxy.realmSet$articulo((String) json.getString("articulo"));
            }
        }
        if (json.has("visita")) {
            if (json.isNull("visita")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
            } else {
                objProxy.realmSet$visita((int) json.getInt("visita"));
            }
        }
        if (json.has("pedido")) {
            if (json.isNull("pedido")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'pedido' to null.");
            } else {
                objProxy.realmSet$pedido((int) json.getInt("pedido"));
            }
        }
        if (json.has("nombre_articulo")) {
            if (json.isNull("nombre_articulo")) {
                objProxy.realmSet$nombre_articulo(null);
            } else {
                objProxy.realmSet$nombre_articulo((String) json.getString("nombre_articulo"));
            }
        }
        if (json.has("nombre_unidad")) {
            if (json.isNull("nombre_unidad")) {
                objProxy.realmSet$nombre_unidad(null);
            } else {
                objProxy.realmSet$nombre_unidad((String) json.getString("nombre_unidad"));
            }
        }
        if (json.has("descripcion_extendida")) {
            if (json.isNull("descripcion_extendida")) {
                objProxy.realmSet$descripcion_extendida(null);
            } else {
                objProxy.realmSet$descripcion_extendida((String) json.getString("descripcion_extendida"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
            } else {
                objProxy.realmSet$cantidad((double) json.getDouble("cantidad"));
            }
        }
        if (json.has("precio")) {
            if (json.isNull("precio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio' to null.");
            } else {
                objProxy.realmSet$precio((double) json.getDouble("precio"));
            }
        }
        if (json.has("IVA")) {
            if (json.isNull("IVA")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'IVA' to null.");
            } else {
                objProxy.realmSet$IVA((double) json.getDouble("IVA"));
            }
        }
        if (json.has("IEPS")) {
            if (json.isNull("IEPS")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'IEPS' to null.");
            } else {
                objProxy.realmSet$IEPS((double) json.getDouble("IEPS"));
            }
        }
        if (json.has("tasa_IVA")) {
            if (json.isNull("tasa_IVA")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'tasa_IVA' to null.");
            } else {
                objProxy.realmSet$tasa_IVA((double) json.getDouble("tasa_IVA"));
            }
        }
        if (json.has("tasa_IEPS")) {
            if (json.isNull("tasa_IEPS")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'tasa_IEPS' to null.");
            } else {
                objProxy.realmSet$tasa_IEPS((double) json.getDouble("tasa_IEPS"));
            }
        }
        if (json.has("importe")) {
            if (json.isNull("importe")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
            } else {
                objProxy.realmSet$importe((double) json.getDouble("importe"));
            }
        }
        if (json.has("es_credito")) {
            if (json.isNull("es_credito")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'es_credito' to null.");
            } else {
                objProxy.realmSet$es_credito((boolean) json.getBoolean("es_credito"));
            }
        }
        if (json.has("enviado")) {
            if (json.isNull("enviado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
            } else {
                objProxy.realmSet$enviado((boolean) json.getBoolean("enviado"));
            }
        }
        if (json.has("fecha_enviado")) {
            if (json.isNull("fecha_enviado")) {
                objProxy.realmSet$fecha_enviado(null);
            } else {
                objProxy.realmSet$fecha_enviado((String) json.getString("fecha_enviado"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.DetailsOrders createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.mds.ventasabpollo.models.DetailsOrders obj = new com.mds.ventasabpollo.models.DetailsOrders();
        final com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$articulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$articulo(null);
                }
            } else if (name.equals("visita")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$visita((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
                }
            } else if (name.equals("pedido")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pedido((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'pedido' to null.");
                }
            } else if (name.equals("nombre_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_articulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_articulo(null);
                }
            } else if (name.equals("nombre_unidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_unidad((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_unidad(null);
                }
            } else if (name.equals("descripcion_extendida")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion_extendida((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion_extendida(null);
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
                }
            } else if (name.equals("precio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio' to null.");
                }
            } else if (name.equals("IVA")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IVA((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'IVA' to null.");
                }
            } else if (name.equals("IEPS")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IEPS((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'IEPS' to null.");
                }
            } else if (name.equals("tasa_IVA")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tasa_IVA((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'tasa_IVA' to null.");
                }
            } else if (name.equals("tasa_IEPS")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tasa_IEPS((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'tasa_IEPS' to null.");
                }
            } else if (name.equals("importe")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$importe((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
                }
            } else if (name.equals("es_credito")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$es_credito((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'es_credito' to null.");
                }
            } else if (name.equals("enviado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$enviado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
                }
            } else if (name.equals("fecha_enviado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_enviado((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_enviado(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clave_articulo'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_DetailsOrdersRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.DetailsOrders copyOrUpdate(Realm realm, DetailsOrdersColumnInfo columnInfo, com.mds.ventasabpollo.models.DetailsOrders object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.DetailsOrders) cachedRealmObject;
        }

        com.mds.ventasabpollo.models.DetailsOrders realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
            long pkColumnIndex = columnInfo.clave_articuloIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.DetailsOrders copy(Realm realm, DetailsOrdersColumnInfo columnInfo, com.mds.ventasabpollo.models.DetailsOrders newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.DetailsOrders) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addString(columnInfo.articuloIndex, realmObjectSource.realmGet$articulo());
        builder.addInteger(columnInfo.visitaIndex, realmObjectSource.realmGet$visita());
        builder.addInteger(columnInfo.pedidoIndex, realmObjectSource.realmGet$pedido());
        builder.addString(columnInfo.nombre_articuloIndex, realmObjectSource.realmGet$nombre_articulo());
        builder.addString(columnInfo.nombre_unidadIndex, realmObjectSource.realmGet$nombre_unidad());
        builder.addString(columnInfo.descripcion_extendidaIndex, realmObjectSource.realmGet$descripcion_extendida());
        builder.addDouble(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());
        builder.addDouble(columnInfo.precioIndex, realmObjectSource.realmGet$precio());
        builder.addDouble(columnInfo.IVAIndex, realmObjectSource.realmGet$IVA());
        builder.addDouble(columnInfo.IEPSIndex, realmObjectSource.realmGet$IEPS());
        builder.addDouble(columnInfo.tasa_IVAIndex, realmObjectSource.realmGet$tasa_IVA());
        builder.addDouble(columnInfo.tasa_IEPSIndex, realmObjectSource.realmGet$tasa_IEPS());
        builder.addDouble(columnInfo.importeIndex, realmObjectSource.realmGet$importe());
        builder.addBoolean(columnInfo.es_creditoIndex, realmObjectSource.realmGet$es_credito());
        builder.addBoolean(columnInfo.enviadoIndex, realmObjectSource.realmGet$enviado());
        builder.addString(columnInfo.fecha_enviadoIndex, realmObjectSource.realmGet$fecha_enviado());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_DetailsOrdersRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.DetailsOrders object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        long tableNativePtr = table.getNativePtr();
        DetailsOrdersColumnInfo columnInfo = (DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
        long pkColumnIndex = columnInfo.clave_articuloIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$articulo();
        if (realmGet$articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.pedidoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$pedido(), false);
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        }
        String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_unidad();
        if (realmGet$nombre_unidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
        }
        String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$descripcion_extendida();
        if (realmGet$descripcion_extendida != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$cantidad(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$precio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IEPS(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$importe(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$es_credito(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$enviado(), false);
        String realmGet$fecha_enviado = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$fecha_enviado();
        if (realmGet$fecha_enviado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, realmGet$fecha_enviado, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        long tableNativePtr = table.getNativePtr();
        DetailsOrdersColumnInfo columnInfo = (DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
        long pkColumnIndex = columnInfo.clave_articuloIndex;
        com.mds.ventasabpollo.models.DetailsOrders object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.DetailsOrders) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$articulo();
            if (realmGet$articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.pedidoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$pedido(), false);
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            }
            String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_unidad();
            if (realmGet$nombre_unidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
            }
            String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$descripcion_extendida();
            if (realmGet$descripcion_extendida != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$cantidad(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$precio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IEPS(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$importe(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$es_credito(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$enviado(), false);
            String realmGet$fecha_enviado = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$fecha_enviado();
            if (realmGet$fecha_enviado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, realmGet$fecha_enviado, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.DetailsOrders object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        long tableNativePtr = table.getNativePtr();
        DetailsOrdersColumnInfo columnInfo = (DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
        long pkColumnIndex = columnInfo.clave_articuloIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
        }
        cache.put(object, rowIndex);
        String realmGet$articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$articulo();
        if (realmGet$articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.articuloIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.pedidoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$pedido(), false);
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
        }
        String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_unidad();
        if (realmGet$nombre_unidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, false);
        }
        String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$descripcion_extendida();
        if (realmGet$descripcion_extendida != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$cantidad(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$precio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IEPS(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$importe(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$es_credito(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$enviado(), false);
        String realmGet$fecha_enviado = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$fecha_enviado();
        if (realmGet$fecha_enviado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, realmGet$fecha_enviado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        long tableNativePtr = table.getNativePtr();
        DetailsOrdersColumnInfo columnInfo = (DetailsOrdersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsOrders.class);
        long pkColumnIndex = columnInfo.clave_articuloIndex;
        com.mds.ventasabpollo.models.DetailsOrders object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.DetailsOrders) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$clave_articulo());
            }
            cache.put(object, rowIndex);
            String realmGet$articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$articulo();
            if (realmGet$articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.articuloIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.pedidoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$pedido(), false);
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
            }
            String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$nombre_unidad();
            if (realmGet$nombre_unidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, false);
            }
            String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$descripcion_extendida();
            if (realmGet$descripcion_extendida != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$cantidad(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$precio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$IEPS(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$importe(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$es_credito(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$enviado(), false);
            String realmGet$fecha_enviado = ((com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) object).realmGet$fecha_enviado();
            if (realmGet$fecha_enviado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, realmGet$fecha_enviado, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_enviadoIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.DetailsOrders createDetachedCopy(com.mds.ventasabpollo.models.DetailsOrders realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.DetailsOrders unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.DetailsOrders();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.DetailsOrders) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.DetailsOrders) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$articulo(realmSource.realmGet$articulo());
        unmanagedCopy.realmSet$visita(realmSource.realmGet$visita());
        unmanagedCopy.realmSet$pedido(realmSource.realmGet$pedido());
        unmanagedCopy.realmSet$nombre_articulo(realmSource.realmGet$nombre_articulo());
        unmanagedCopy.realmSet$nombre_unidad(realmSource.realmGet$nombre_unidad());
        unmanagedCopy.realmSet$descripcion_extendida(realmSource.realmGet$descripcion_extendida());
        unmanagedCopy.realmSet$cantidad(realmSource.realmGet$cantidad());
        unmanagedCopy.realmSet$precio(realmSource.realmGet$precio());
        unmanagedCopy.realmSet$IVA(realmSource.realmGet$IVA());
        unmanagedCopy.realmSet$IEPS(realmSource.realmGet$IEPS());
        unmanagedCopy.realmSet$tasa_IVA(realmSource.realmGet$tasa_IVA());
        unmanagedCopy.realmSet$tasa_IEPS(realmSource.realmGet$tasa_IEPS());
        unmanagedCopy.realmSet$importe(realmSource.realmGet$importe());
        unmanagedCopy.realmSet$es_credito(realmSource.realmGet$es_credito());
        unmanagedCopy.realmSet$enviado(realmSource.realmGet$enviado());
        unmanagedCopy.realmSet$fecha_enviado(realmSource.realmGet$fecha_enviado());

        return unmanagedObject;
    }

    static com.mds.ventasabpollo.models.DetailsOrders update(Realm realm, DetailsOrdersColumnInfo columnInfo, com.mds.ventasabpollo.models.DetailsOrders realmObject, com.mds.ventasabpollo.models.DetailsOrders newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface realmObjectTarget = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) realmObject;
        com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxyInterface) newObject;
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsOrders.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addString(columnInfo.articuloIndex, realmObjectSource.realmGet$articulo());
        builder.addInteger(columnInfo.visitaIndex, realmObjectSource.realmGet$visita());
        builder.addInteger(columnInfo.pedidoIndex, realmObjectSource.realmGet$pedido());
        builder.addString(columnInfo.nombre_articuloIndex, realmObjectSource.realmGet$nombre_articulo());
        builder.addString(columnInfo.nombre_unidadIndex, realmObjectSource.realmGet$nombre_unidad());
        builder.addString(columnInfo.descripcion_extendidaIndex, realmObjectSource.realmGet$descripcion_extendida());
        builder.addDouble(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());
        builder.addDouble(columnInfo.precioIndex, realmObjectSource.realmGet$precio());
        builder.addDouble(columnInfo.IVAIndex, realmObjectSource.realmGet$IVA());
        builder.addDouble(columnInfo.IEPSIndex, realmObjectSource.realmGet$IEPS());
        builder.addDouble(columnInfo.tasa_IVAIndex, realmObjectSource.realmGet$tasa_IVA());
        builder.addDouble(columnInfo.tasa_IEPSIndex, realmObjectSource.realmGet$tasa_IEPS());
        builder.addDouble(columnInfo.importeIndex, realmObjectSource.realmGet$importe());
        builder.addBoolean(columnInfo.es_creditoIndex, realmObjectSource.realmGet$es_credito());
        builder.addBoolean(columnInfo.enviadoIndex, realmObjectSource.realmGet$enviado());
        builder.addString(columnInfo.fecha_enviadoIndex, realmObjectSource.realmGet$fecha_enviado());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DetailsOrders = proxy[");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{articulo:");
        stringBuilder.append(realmGet$articulo() != null ? realmGet$articulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{visita:");
        stringBuilder.append(realmGet$visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pedido:");
        stringBuilder.append(realmGet$pedido());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_articulo:");
        stringBuilder.append(realmGet$nombre_articulo() != null ? realmGet$nombre_articulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_unidad:");
        stringBuilder.append(realmGet$nombre_unidad() != null ? realmGet$nombre_unidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{descripcion_extendida:");
        stringBuilder.append(realmGet$descripcion_extendida() != null ? realmGet$descripcion_extendida() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio:");
        stringBuilder.append(realmGet$precio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IVA:");
        stringBuilder.append(realmGet$IVA());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IEPS:");
        stringBuilder.append(realmGet$IEPS());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tasa_IVA:");
        stringBuilder.append(realmGet$tasa_IVA());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tasa_IEPS:");
        stringBuilder.append(realmGet$tasa_IEPS());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{importe:");
        stringBuilder.append(realmGet$importe());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{es_credito:");
        stringBuilder.append(realmGet$es_credito());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enviado:");
        stringBuilder.append(realmGet$enviado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_enviado:");
        stringBuilder.append(realmGet$fecha_enviado() != null ? realmGet$fecha_enviado() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_mds_ventasabpollo_models_DetailsOrdersRealmProxy aDetailsOrders = (com_mds_ventasabpollo_models_DetailsOrdersRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDetailsOrders.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDetailsOrders.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDetailsOrders.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
