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
public class com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy extends com.mds.ventasabpollo.models.ChangesInventories
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface {

    static final class ChangesInventoriesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long rutaIndex;
        long clave_articuloIndex;
        long cantidad_anteriorIndex;
        long cantidad_nuevaIndex;
        long fechaIndex;
        long enviadoIndex;
        long user_idIndex;

        ChangesInventoriesColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ChangesInventories");
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.cantidad_anteriorIndex = addColumnDetails("cantidad_anterior", "cantidad_anterior", objectSchemaInfo);
            this.cantidad_nuevaIndex = addColumnDetails("cantidad_nueva", "cantidad_nueva", objectSchemaInfo);
            this.fechaIndex = addColumnDetails("fecha", "fecha", objectSchemaInfo);
            this.enviadoIndex = addColumnDetails("enviado", "enviado", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ChangesInventoriesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChangesInventoriesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChangesInventoriesColumnInfo src = (ChangesInventoriesColumnInfo) rawSrc;
            final ChangesInventoriesColumnInfo dst = (ChangesInventoriesColumnInfo) rawDst;
            dst.rutaIndex = src.rutaIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.cantidad_anteriorIndex = src.cantidad_anteriorIndex;
            dst.cantidad_nuevaIndex = src.cantidad_nuevaIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.enviadoIndex = src.enviadoIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChangesInventoriesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.ChangesInventories> proxyState;

    com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChangesInventoriesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.ChangesInventories>(this);
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
    public double realmGet$cantidad_anterior() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.cantidad_anteriorIndex);
    }

    @Override
    public void realmSet$cantidad_anterior(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.cantidad_anteriorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.cantidad_anteriorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$cantidad_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.cantidad_nuevaIndex);
    }

    @Override
    public void realmSet$cantidad_nueva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.cantidad_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.cantidad_nuevaIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ChangesInventories", 7, 0);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cantidad_anterior", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cantidad_nueva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("enviado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChangesInventoriesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChangesInventoriesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ChangesInventories";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ChangesInventories";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.ChangesInventories createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.ChangesInventories obj = realm.createObjectInternal(com.mds.ventasabpollo.models.ChangesInventories.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) obj;
        if (json.has("ruta")) {
            if (json.isNull("ruta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
            } else {
                objProxy.realmSet$ruta((int) json.getInt("ruta"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("cantidad_anterior")) {
            if (json.isNull("cantidad_anterior")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad_anterior' to null.");
            } else {
                objProxy.realmSet$cantidad_anterior((double) json.getDouble("cantidad_anterior"));
            }
        }
        if (json.has("cantidad_nueva")) {
            if (json.isNull("cantidad_nueva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad_nueva' to null.");
            } else {
                objProxy.realmSet$cantidad_nueva((double) json.getDouble("cantidad_nueva"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                objProxy.realmSet$fecha(null);
            } else {
                objProxy.realmSet$fecha((String) json.getString("fecha"));
            }
        }
        if (json.has("enviado")) {
            if (json.isNull("enviado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
            } else {
                objProxy.realmSet$enviado((boolean) json.getBoolean("enviado"));
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
    public static com.mds.ventasabpollo.models.ChangesInventories createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.ChangesInventories obj = new com.mds.ventasabpollo.models.ChangesInventories();
        final com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) obj;
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
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("cantidad_anterior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad_anterior((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad_anterior' to null.");
                }
            } else if (name.equals("cantidad_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad_nueva((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad_nueva' to null.");
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha(null);
                }
            } else if (name.equals("enviado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$enviado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
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

    private static com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.ChangesInventories copyOrUpdate(Realm realm, ChangesInventoriesColumnInfo columnInfo, com.mds.ventasabpollo.models.ChangesInventories object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.ChangesInventories) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.ChangesInventories copy(Realm realm, ChangesInventoriesColumnInfo columnInfo, com.mds.ventasabpollo.models.ChangesInventories newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.ChangesInventories) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesInventories.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.cantidad_anteriorIndex, realmObjectSource.realmGet$cantidad_anterior());
        builder.addDouble(columnInfo.cantidad_nuevaIndex, realmObjectSource.realmGet$cantidad_nueva());
        builder.addString(columnInfo.fechaIndex, realmObjectSource.realmGet$fecha());
        builder.addBoolean(columnInfo.enviadoIndex, realmObjectSource.realmGet$enviado());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.ChangesInventories object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesInventories.class);
        long tableNativePtr = table.getNativePtr();
        ChangesInventoriesColumnInfo columnInfo = (ChangesInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_nueva(), false);
        String realmGet$fecha = ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$enviado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesInventories.class);
        long tableNativePtr = table.getNativePtr();
        ChangesInventoriesColumnInfo columnInfo = (ChangesInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class);
        com.mds.ventasabpollo.models.ChangesInventories object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ChangesInventories) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_nueva(), false);
            String realmGet$fecha = ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$enviado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.ChangesInventories object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesInventories.class);
        long tableNativePtr = table.getNativePtr();
        ChangesInventoriesColumnInfo columnInfo = (ChangesInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_nueva(), false);
        String realmGet$fecha = ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$enviado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesInventories.class);
        long tableNativePtr = table.getNativePtr();
        ChangesInventoriesColumnInfo columnInfo = (ChangesInventoriesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesInventories.class);
        com.mds.ventasabpollo.models.ChangesInventories object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ChangesInventories) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$cantidad_nueva(), false);
            String realmGet$fecha = ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$enviado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.ChangesInventories createDetachedCopy(com.mds.ventasabpollo.models.ChangesInventories realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.ChangesInventories unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.ChangesInventories();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.ChangesInventories) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.ChangesInventories) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$cantidad_anterior(realmSource.realmGet$cantidad_anterior());
        unmanagedCopy.realmSet$cantidad_nueva(realmSource.realmGet$cantidad_nueva());
        unmanagedCopy.realmSet$fecha(realmSource.realmGet$fecha());
        unmanagedCopy.realmSet$enviado(realmSource.realmGet$enviado());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChangesInventories = proxy[");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad_anterior:");
        stringBuilder.append(realmGet$cantidad_anterior());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad_nueva:");
        stringBuilder.append(realmGet$cantidad_nueva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enviado:");
        stringBuilder.append(realmGet$enviado());
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
        com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy aChangesInventories = (com_mds_ventasabpollo_models_ChangesInventoriesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aChangesInventories.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChangesInventories.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aChangesInventories.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
