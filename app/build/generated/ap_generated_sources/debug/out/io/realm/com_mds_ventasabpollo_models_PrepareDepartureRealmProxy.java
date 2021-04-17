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
public class com_mds_ventasabpollo_models_PrepareDepartureRealmProxy extends com.mds.ventasabpollo.models.PrepareDeparture
    implements RealmObjectProxy, com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface {

    static final class PrepareDepartureColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clave_articuloIndex;
        long cantidadIndex;

        PrepareDepartureColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PrepareDeparture");
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.cantidadIndex = addColumnDetails("cantidad", "cantidad", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PrepareDepartureColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PrepareDepartureColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PrepareDepartureColumnInfo src = (PrepareDepartureColumnInfo) rawSrc;
            final PrepareDepartureColumnInfo dst = (PrepareDepartureColumnInfo) rawDst;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PrepareDepartureColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.PrepareDeparture> proxyState;

    com_mds_ventasabpollo_models_PrepareDepartureRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PrepareDepartureColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.PrepareDeparture>(this);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PrepareDeparture", 2, 0);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cantidad", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PrepareDepartureColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PrepareDepartureColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PrepareDeparture";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PrepareDeparture";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.PrepareDeparture createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.PrepareDeparture obj = realm.createObjectInternal(com.mds.ventasabpollo.models.PrepareDeparture.class, true, excludeFields);

        final com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) obj;
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.PrepareDeparture createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.PrepareDeparture obj = new com.mds.ventasabpollo.models.PrepareDeparture();
        final com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) obj;
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
            } else if (name.equals("cantidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_PrepareDepartureRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.PrepareDeparture copyOrUpdate(Realm realm, PrepareDepartureColumnInfo columnInfo, com.mds.ventasabpollo.models.PrepareDeparture object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.PrepareDeparture) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.PrepareDeparture copy(Realm realm, PrepareDepartureColumnInfo columnInfo, com.mds.ventasabpollo.models.PrepareDeparture newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.PrepareDeparture) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.PrepareDeparture.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_PrepareDepartureRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.PrepareDeparture object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long tableNativePtr = table.getNativePtr();
        PrepareDepartureColumnInfo columnInfo = (PrepareDepartureColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$cantidad(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long tableNativePtr = table.getNativePtr();
        PrepareDepartureColumnInfo columnInfo = (PrepareDepartureColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class);
        com.mds.ventasabpollo.models.PrepareDeparture object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.PrepareDeparture) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$cantidad(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.PrepareDeparture object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long tableNativePtr = table.getNativePtr();
        PrepareDepartureColumnInfo columnInfo = (PrepareDepartureColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$cantidad(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.PrepareDeparture.class);
        long tableNativePtr = table.getNativePtr();
        PrepareDepartureColumnInfo columnInfo = (PrepareDepartureColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.PrepareDeparture.class);
        com.mds.ventasabpollo.models.PrepareDeparture object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.PrepareDeparture) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) object).realmGet$cantidad(), false);
        }
    }

    public static com.mds.ventasabpollo.models.PrepareDeparture createDetachedCopy(com.mds.ventasabpollo.models.PrepareDeparture realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.PrepareDeparture unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.PrepareDeparture();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.PrepareDeparture) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.PrepareDeparture) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$cantidad(realmSource.realmGet$cantidad());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PrepareDeparture = proxy[");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad());
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
        com_mds_ventasabpollo_models_PrepareDepartureRealmProxy aPrepareDeparture = (com_mds_ventasabpollo_models_PrepareDepartureRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPrepareDeparture.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPrepareDeparture.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPrepareDeparture.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
