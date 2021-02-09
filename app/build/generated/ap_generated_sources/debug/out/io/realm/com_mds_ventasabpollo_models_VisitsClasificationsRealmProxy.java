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
public class com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy extends com.mds.ventasabpollo.models.VisitsClasifications
    implements RealmObjectProxy, com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface {

    static final class VisitsClasificationsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clasificacionIndex;
        long nombre_clasificacionIndex;

        VisitsClasificationsColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("VisitsClasifications");
            this.clasificacionIndex = addColumnDetails("clasificacion", "clasificacion", objectSchemaInfo);
            this.nombre_clasificacionIndex = addColumnDetails("nombre_clasificacion", "nombre_clasificacion", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        VisitsClasificationsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new VisitsClasificationsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final VisitsClasificationsColumnInfo src = (VisitsClasificationsColumnInfo) rawSrc;
            final VisitsClasificationsColumnInfo dst = (VisitsClasificationsColumnInfo) rawDst;
            dst.clasificacionIndex = src.clasificacionIndex;
            dst.nombre_clasificacionIndex = src.nombre_clasificacionIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private VisitsClasificationsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.VisitsClasifications> proxyState;

    com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VisitsClasificationsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.VisitsClasifications>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$clasificacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clasificacionIndex);
    }

    @Override
    public void realmSet$clasificacion(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clasificacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clasificacionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_clasificacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_clasificacionIndex);
    }

    @Override
    public void realmSet$nombre_clasificacion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_clasificacionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_clasificacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_clasificacionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_clasificacionIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("VisitsClasifications", 2, 0);
        builder.addPersistedProperty("clasificacion", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_clasificacion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static VisitsClasificationsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new VisitsClasificationsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "VisitsClasifications";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "VisitsClasifications";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.VisitsClasifications createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.VisitsClasifications obj = realm.createObjectInternal(com.mds.ventasabpollo.models.VisitsClasifications.class, true, excludeFields);

        final com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) obj;
        if (json.has("clasificacion")) {
            if (json.isNull("clasificacion")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clasificacion' to null.");
            } else {
                objProxy.realmSet$clasificacion((int) json.getInt("clasificacion"));
            }
        }
        if (json.has("nombre_clasificacion")) {
            if (json.isNull("nombre_clasificacion")) {
                objProxy.realmSet$nombre_clasificacion(null);
            } else {
                objProxy.realmSet$nombre_clasificacion((String) json.getString("nombre_clasificacion"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.VisitsClasifications createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.VisitsClasifications obj = new com.mds.ventasabpollo.models.VisitsClasifications();
        final com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clasificacion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clasificacion((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clasificacion' to null.");
                }
            } else if (name.equals("nombre_clasificacion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_clasificacion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_clasificacion(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.VisitsClasifications copyOrUpdate(Realm realm, VisitsClasificationsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsClasifications object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.VisitsClasifications) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.VisitsClasifications copy(Realm realm, VisitsClasificationsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsClasifications newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.VisitsClasifications) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClasifications.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clasificacionIndex, realmObjectSource.realmGet$clasificacion());
        builder.addString(columnInfo.nombre_clasificacionIndex, realmObjectSource.realmGet$nombre_clasificacion());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.VisitsClasifications object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClasificationsColumnInfo columnInfo = (VisitsClasificationsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clasificacionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$clasificacion(), false);
        String realmGet$nombre_clasificacion = ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$nombre_clasificacion();
        if (realmGet$nombre_clasificacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, realmGet$nombre_clasificacion, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClasificationsColumnInfo columnInfo = (VisitsClasificationsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class);
        com.mds.ventasabpollo.models.VisitsClasifications object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsClasifications) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clasificacionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$clasificacion(), false);
            String realmGet$nombre_clasificacion = ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$nombre_clasificacion();
            if (realmGet$nombre_clasificacion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, realmGet$nombre_clasificacion, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.VisitsClasifications object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClasificationsColumnInfo columnInfo = (VisitsClasificationsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clasificacionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$clasificacion(), false);
        String realmGet$nombre_clasificacion = ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$nombre_clasificacion();
        if (realmGet$nombre_clasificacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, realmGet$nombre_clasificacion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClasifications.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClasificationsColumnInfo columnInfo = (VisitsClasificationsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClasifications.class);
        com.mds.ventasabpollo.models.VisitsClasifications object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsClasifications) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clasificacionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$clasificacion(), false);
            String realmGet$nombre_clasificacion = ((com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) object).realmGet$nombre_clasificacion();
            if (realmGet$nombre_clasificacion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, realmGet$nombre_clasificacion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clasificacionIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.VisitsClasifications createDetachedCopy(com.mds.ventasabpollo.models.VisitsClasifications realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.VisitsClasifications unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.VisitsClasifications();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.VisitsClasifications) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.VisitsClasifications) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$clasificacion(realmSource.realmGet$clasificacion());
        unmanagedCopy.realmSet$nombre_clasificacion(realmSource.realmGet$nombre_clasificacion());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("VisitsClasifications = proxy[");
        stringBuilder.append("{clasificacion:");
        stringBuilder.append(realmGet$clasificacion());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_clasificacion:");
        stringBuilder.append(realmGet$nombre_clasificacion() != null ? realmGet$nombre_clasificacion() : "null");
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
        com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy aVisitsClasifications = (com_mds_ventasabpollo_models_VisitsClasificationsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVisitsClasifications.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVisitsClasifications.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVisitsClasifications.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
