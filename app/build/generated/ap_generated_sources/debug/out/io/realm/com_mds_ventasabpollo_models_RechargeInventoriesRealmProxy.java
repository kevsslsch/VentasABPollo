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
public class com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy extends com.mds.ventasabpollo.models.RechargeInventories
    implements RealmObjectProxy, com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface {

    static final class RechargeInventoriesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long rutaIndex;
        long salidaIndex;
        long recargaIndex;
        long clave_articuloIndex;
        long cantidadIndex;
        long fechaIndex;

        RechargeInventoriesColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RechargeInventories");
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.salidaIndex = addColumnDetails("salida", "salida", objectSchemaInfo);
            this.recargaIndex = addColumnDetails("recarga", "recarga", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.cantidadIndex = addColumnDetails("cantidad", "cantidad", objectSchemaInfo);
            this.fechaIndex = addColumnDetails("fecha", "fecha", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        RechargeInventoriesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RechargeInventoriesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RechargeInventoriesColumnInfo src = (RechargeInventoriesColumnInfo) rawSrc;
            final RechargeInventoriesColumnInfo dst = (RechargeInventoriesColumnInfo) rawDst;
            dst.rutaIndex = src.rutaIndex;
            dst.salidaIndex = src.salidaIndex;
            dst.recargaIndex = src.recargaIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RechargeInventoriesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.RechargeInventories> proxyState;

    com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RechargeInventoriesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.RechargeInventories>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ruta() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rutaIndex);
    }

    @Override
    public void realmSet$ruta(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rutaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rutaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$salida() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.salidaIndex);
    }

    @Override
    public void realmSet$salida(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.salidaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.salidaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$recarga() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.recargaIndex);
    }

    @Override
    public void realmSet$recarga(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.recargaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.recargaIndex, value);
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
    public String realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaIndex);
    }

    @Override
    public void realmSet$fecha(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RechargeInventories", 6, 0);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("salida", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("recarga", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cantidad", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RechargeInventoriesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RechargeInventoriesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RechargeInventories";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RechargeInventories";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.RechargeInventories createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.RechargeInventories obj = realm.createObjectInternal(com.mds.ventasabpollo.models.RechargeInventories.class, true, excludeFields);

        final com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) obj;
        if (json.has("ruta")) {
            if (json.isNull("ruta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
            } else {
                objProxy.realmSet$ruta((int) json.getInt("ruta"));
            }
        }
        if (json.has("salida")) {
            if (json.isNull("salida")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
            } else {
                objProxy.realmSet$salida((int) json.getInt("salida"));
            }
        }
        if (json.has("recarga")) {
            if (json.isNull("recarga")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'recarga' to null.");
            } else {
                objProxy.realmSet$recarga((int) json.getInt("recarga"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
            } else {
                objProxy.realmSet$cantidad((double) json.getDouble("cantidad"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                objProxy.realmSet$fecha(null);
            } else {
                objProxy.realmSet$fecha((String) json.getString("fecha"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.RechargeInventories createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.RechargeInventories obj = new com.mds.ventasabpollo.models.RechargeInventories();
        final com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("ruta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ruta((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
                }
            } else if (name.equals("salida")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$salida((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
                }
            } else if (name.equals("recarga")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$recarga((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'recarga' to null.");
                }
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.RechargeInventories copyOrUpdate(Realm realm, RechargeInventoriesColumnInfo columnInfo, com.mds.ventasabpollo.models.RechargeInventories object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.RechargeInventories) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.RechargeInventories copy(Realm realm, RechargeInventoriesColumnInfo columnInfo, com.mds.ventasabpollo.models.RechargeInventories newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.RechargeInventories) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.RechargeInventories.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.salidaIndex, realmObjectSource.realmGet$salida());
        builder.addInteger(columnInfo.recargaIndex, realmObjectSource.realmGet$recarga());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());
        builder.addString(columnInfo.fechaIndex, realmObjectSource.realmGet$fecha());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.RechargeInventories object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.RechargeInventories.class);
        long tableNativePtr = table.getNativePtr();
        RechargeInventoriesColumnInfo columnInfo = (RechargeInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.recargaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$recarga(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$cantidad(), false);
        String realmGet$fecha = ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.RechargeInventories.class);
        long tableNativePtr = table.getNativePtr();
        RechargeInventoriesColumnInfo columnInfo = (RechargeInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class);
        com.mds.ventasabpollo.models.RechargeInventories object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.RechargeInventories) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.recargaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$recarga(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$cantidad(), false);
            String realmGet$fecha = ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.RechargeInventories object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.RechargeInventories.class);
        long tableNativePtr = table.getNativePtr();
        RechargeInventoriesColumnInfo columnInfo = (RechargeInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.recargaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$recarga(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$cantidad(), false);
        String realmGet$fecha = ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.RechargeInventories.class);
        long tableNativePtr = table.getNativePtr();
        RechargeInventoriesColumnInfo columnInfo = (RechargeInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.RechargeInventories.class);
        com.mds.ventasabpollo.models.RechargeInventories object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.RechargeInventories) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.recargaIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$recarga(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$cantidad(), false);
            String realmGet$fecha = ((com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.RechargeInventories createDetachedCopy(com.mds.ventasabpollo.models.RechargeInventories realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.RechargeInventories unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.RechargeInventories();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.RechargeInventories) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.RechargeInventories) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$salida(realmSource.realmGet$salida());
        unmanagedCopy.realmSet$recarga(realmSource.realmGet$recarga());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$cantidad(realmSource.realmGet$cantidad());
        unmanagedCopy.realmSet$fecha(realmSource.realmGet$fecha());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RechargeInventories = proxy[");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{salida:");
        stringBuilder.append(realmGet$salida());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recarga:");
        stringBuilder.append(realmGet$recarga());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
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
        com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy aRechargeInventories = (com_mds_ventasabpollo_models_RechargeInventoriesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRechargeInventories.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRechargeInventories.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRechargeInventories.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
