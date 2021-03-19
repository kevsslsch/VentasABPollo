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
public class com_mds_ventasabpollo_models_PricesRealmProxy extends com.mds.ventasabpollo.models.Prices
    implements RealmObjectProxy, com_mds_ventasabpollo_models_PricesRealmProxyInterface {

    static final class PricesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clienteIndex;
        long clave_articuloIndex;
        long precioIndex;
        long precio_contadoIndex;
        long precio_creditoIndex;
        long tiene_ivaIndex;
        long tasa_IVAIndex;
        long tasa_IEPSIndex;
        long tipo_IEPSIndex;
        long fecha_actualizacionIndex;
        long promedio_piezasIndex;
        long user_idIndex;

        PricesColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Prices");
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.precioIndex = addColumnDetails("precio", "precio", objectSchemaInfo);
            this.precio_contadoIndex = addColumnDetails("precio_contado", "precio_contado", objectSchemaInfo);
            this.precio_creditoIndex = addColumnDetails("precio_credito", "precio_credito", objectSchemaInfo);
            this.tiene_ivaIndex = addColumnDetails("tiene_iva", "tiene_iva", objectSchemaInfo);
            this.tasa_IVAIndex = addColumnDetails("tasa_IVA", "tasa_IVA", objectSchemaInfo);
            this.tasa_IEPSIndex = addColumnDetails("tasa_IEPS", "tasa_IEPS", objectSchemaInfo);
            this.tipo_IEPSIndex = addColumnDetails("tipo_IEPS", "tipo_IEPS", objectSchemaInfo);
            this.fecha_actualizacionIndex = addColumnDetails("fecha_actualizacion", "fecha_actualizacion", objectSchemaInfo);
            this.promedio_piezasIndex = addColumnDetails("promedio_piezas", "promedio_piezas", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PricesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PricesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PricesColumnInfo src = (PricesColumnInfo) rawSrc;
            final PricesColumnInfo dst = (PricesColumnInfo) rawDst;
            dst.clienteIndex = src.clienteIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.precioIndex = src.precioIndex;
            dst.precio_contadoIndex = src.precio_contadoIndex;
            dst.precio_creditoIndex = src.precio_creditoIndex;
            dst.tiene_ivaIndex = src.tiene_ivaIndex;
            dst.tasa_IVAIndex = src.tasa_IVAIndex;
            dst.tasa_IEPSIndex = src.tasa_IEPSIndex;
            dst.tipo_IEPSIndex = src.tipo_IEPSIndex;
            dst.fecha_actualizacionIndex = src.fecha_actualizacionIndex;
            dst.promedio_piezasIndex = src.promedio_piezasIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PricesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Prices> proxyState;

    com_mds_ventasabpollo_models_PricesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PricesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Prices>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$cliente() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clienteIndex);
    }

    @Override
    public void realmSet$cliente(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clienteIndex, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clave_articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clave_articuloIndex, value);
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
    public double realmGet$precio_contado() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precio_contadoIndex);
    }

    @Override
    public void realmSet$precio_contado(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precio_contadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precio_contadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$precio_credito() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precio_creditoIndex);
    }

    @Override
    public void realmSet$precio_credito(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precio_creditoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precio_creditoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$tiene_iva() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.tiene_ivaIndex);
    }

    @Override
    public void realmSet$tiene_iva(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.tiene_ivaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.tiene_ivaIndex, value);
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
    public String realmGet$tipo_IEPS() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tipo_IEPSIndex);
    }

    @Override
    public void realmSet$tipo_IEPS(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tipo_IEPSIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tipo_IEPSIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tipo_IEPSIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tipo_IEPSIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_actualizacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_actualizacionIndex);
    }

    @Override
    public void realmSet$fecha_actualizacion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_actualizacionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_actualizacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_actualizacionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_actualizacionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$promedio_piezas() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.promedio_piezasIndex);
    }

    @Override
    public void realmSet$promedio_piezas(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.promedio_piezasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.promedio_piezasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.user_idIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Prices", 12, 0);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio_contado", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio_credito", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tiene_iva", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tasa_IVA", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tasa_IEPS", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("tipo_IEPS", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_actualizacion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("promedio_piezas", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PricesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PricesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Prices";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Prices";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Prices createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Prices obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Prices.class, true, excludeFields);

        final com_mds_ventasabpollo_models_PricesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_PricesRealmProxyInterface) obj;
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("precio")) {
            if (json.isNull("precio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio' to null.");
            } else {
                objProxy.realmSet$precio((double) json.getDouble("precio"));
            }
        }
        if (json.has("precio_contado")) {
            if (json.isNull("precio_contado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio_contado' to null.");
            } else {
                objProxy.realmSet$precio_contado((double) json.getDouble("precio_contado"));
            }
        }
        if (json.has("precio_credito")) {
            if (json.isNull("precio_credito")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio_credito' to null.");
            } else {
                objProxy.realmSet$precio_credito((double) json.getDouble("precio_credito"));
            }
        }
        if (json.has("tiene_iva")) {
            if (json.isNull("tiene_iva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'tiene_iva' to null.");
            } else {
                objProxy.realmSet$tiene_iva((int) json.getInt("tiene_iva"));
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
        if (json.has("tipo_IEPS")) {
            if (json.isNull("tipo_IEPS")) {
                objProxy.realmSet$tipo_IEPS(null);
            } else {
                objProxy.realmSet$tipo_IEPS((String) json.getString("tipo_IEPS"));
            }
        }
        if (json.has("fecha_actualizacion")) {
            if (json.isNull("fecha_actualizacion")) {
                objProxy.realmSet$fecha_actualizacion(null);
            } else {
                objProxy.realmSet$fecha_actualizacion((String) json.getString("fecha_actualizacion"));
            }
        }
        if (json.has("promedio_piezas")) {
            if (json.isNull("promedio_piezas")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'promedio_piezas' to null.");
            } else {
                objProxy.realmSet$promedio_piezas((int) json.getInt("promedio_piezas"));
            }
        }
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
            } else {
                objProxy.realmSet$user_id((int) json.getInt("user_id"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Prices createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Prices obj = new com.mds.ventasabpollo.models.Prices();
        final com_mds_ventasabpollo_models_PricesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_PricesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("precio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio' to null.");
                }
            } else if (name.equals("precio_contado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio_contado((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio_contado' to null.");
                }
            } else if (name.equals("precio_credito")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio_credito((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio_credito' to null.");
                }
            } else if (name.equals("tiene_iva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tiene_iva((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'tiene_iva' to null.");
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
            } else if (name.equals("tipo_IEPS")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tipo_IEPS((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tipo_IEPS(null);
                }
            } else if (name.equals("fecha_actualizacion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_actualizacion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_actualizacion(null);
                }
            } else if (name.equals("promedio_piezas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$promedio_piezas((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'promedio_piezas' to null.");
                }
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_PricesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_PricesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_PricesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Prices copyOrUpdate(Realm realm, PricesColumnInfo columnInfo, com.mds.ventasabpollo.models.Prices object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Prices) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Prices copy(Realm realm, PricesColumnInfo columnInfo, com.mds.ventasabpollo.models.Prices newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Prices) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_PricesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_PricesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Prices.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.precioIndex, realmObjectSource.realmGet$precio());
        builder.addDouble(columnInfo.precio_contadoIndex, realmObjectSource.realmGet$precio_contado());
        builder.addDouble(columnInfo.precio_creditoIndex, realmObjectSource.realmGet$precio_credito());
        builder.addInteger(columnInfo.tiene_ivaIndex, realmObjectSource.realmGet$tiene_iva());
        builder.addDouble(columnInfo.tasa_IVAIndex, realmObjectSource.realmGet$tasa_IVA());
        builder.addDouble(columnInfo.tasa_IEPSIndex, realmObjectSource.realmGet$tasa_IEPS());
        builder.addString(columnInfo.tipo_IEPSIndex, realmObjectSource.realmGet$tipo_IEPS());
        builder.addString(columnInfo.fecha_actualizacionIndex, realmObjectSource.realmGet$fecha_actualizacion());
        builder.addInteger(columnInfo.promedio_piezasIndex, realmObjectSource.realmGet$promedio_piezas());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_PricesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Prices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Prices.class);
        long tableNativePtr = table.getNativePtr();
        PricesColumnInfo columnInfo = (PricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_contadoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_contado(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_credito(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.tiene_ivaIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tiene_iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
        String realmGet$tipo_IEPS = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tipo_IEPS();
        if (realmGet$tipo_IEPS != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, realmGet$tipo_IEPS, false);
        }
        String realmGet$fecha_actualizacion = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$fecha_actualizacion();
        if (realmGet$fecha_actualizacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, realmGet$fecha_actualizacion, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.promedio_piezasIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$promedio_piezas(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Prices.class);
        long tableNativePtr = table.getNativePtr();
        PricesColumnInfo columnInfo = (PricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class);
        com.mds.ventasabpollo.models.Prices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Prices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_contadoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_contado(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_credito(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.tiene_ivaIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tiene_iva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
            String realmGet$tipo_IEPS = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tipo_IEPS();
            if (realmGet$tipo_IEPS != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, realmGet$tipo_IEPS, false);
            }
            String realmGet$fecha_actualizacion = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$fecha_actualizacion();
            if (realmGet$fecha_actualizacion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, realmGet$fecha_actualizacion, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.promedio_piezasIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$promedio_piezas(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Prices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Prices.class);
        long tableNativePtr = table.getNativePtr();
        PricesColumnInfo columnInfo = (PricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_contadoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_contado(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_credito(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.tiene_ivaIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tiene_iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IVA(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
        String realmGet$tipo_IEPS = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tipo_IEPS();
        if (realmGet$tipo_IEPS != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, realmGet$tipo_IEPS, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, false);
        }
        String realmGet$fecha_actualizacion = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$fecha_actualizacion();
        if (realmGet$fecha_actualizacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, realmGet$fecha_actualizacion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.promedio_piezasIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$promedio_piezas(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Prices.class);
        long tableNativePtr = table.getNativePtr();
        PricesColumnInfo columnInfo = (PricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Prices.class);
        com.mds.ventasabpollo.models.Prices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Prices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precioIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_contadoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_contado(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$precio_credito(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.tiene_ivaIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tiene_iva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IVAIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IVA(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.tasa_IEPSIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tasa_IEPS(), false);
            String realmGet$tipo_IEPS = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$tipo_IEPS();
            if (realmGet$tipo_IEPS != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, realmGet$tipo_IEPS, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tipo_IEPSIndex, rowIndex, false);
            }
            String realmGet$fecha_actualizacion = ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$fecha_actualizacion();
            if (realmGet$fecha_actualizacion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, realmGet$fecha_actualizacion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_actualizacionIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.promedio_piezasIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$promedio_piezas(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_PricesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.Prices createDetachedCopy(com.mds.ventasabpollo.models.Prices realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Prices unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Prices();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Prices) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Prices) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_PricesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_PricesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_PricesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_PricesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$precio(realmSource.realmGet$precio());
        unmanagedCopy.realmSet$precio_contado(realmSource.realmGet$precio_contado());
        unmanagedCopy.realmSet$precio_credito(realmSource.realmGet$precio_credito());
        unmanagedCopy.realmSet$tiene_iva(realmSource.realmGet$tiene_iva());
        unmanagedCopy.realmSet$tasa_IVA(realmSource.realmGet$tasa_IVA());
        unmanagedCopy.realmSet$tasa_IEPS(realmSource.realmGet$tasa_IEPS());
        unmanagedCopy.realmSet$tipo_IEPS(realmSource.realmGet$tipo_IEPS());
        unmanagedCopy.realmSet$fecha_actualizacion(realmSource.realmGet$fecha_actualizacion());
        unmanagedCopy.realmSet$promedio_piezas(realmSource.realmGet$promedio_piezas());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Prices = proxy[");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio:");
        stringBuilder.append(realmGet$precio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio_contado:");
        stringBuilder.append(realmGet$precio_contado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio_credito:");
        stringBuilder.append(realmGet$precio_credito());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tiene_iva:");
        stringBuilder.append(realmGet$tiene_iva());
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
        stringBuilder.append("{tipo_IEPS:");
        stringBuilder.append(realmGet$tipo_IEPS() != null ? realmGet$tipo_IEPS() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_actualizacion:");
        stringBuilder.append(realmGet$fecha_actualizacion() != null ? realmGet$fecha_actualizacion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{promedio_piezas:");
        stringBuilder.append(realmGet$promedio_piezas());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id());
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
        com_mds_ventasabpollo_models_PricesRealmProxy aPrices = (com_mds_ventasabpollo_models_PricesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPrices.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPrices.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPrices.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
