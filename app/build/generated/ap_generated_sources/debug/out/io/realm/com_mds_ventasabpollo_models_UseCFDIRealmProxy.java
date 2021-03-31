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
public class com_mds_ventasabpollo_models_UseCFDIRealmProxy extends com.mds.ventasabpollo.models.UseCFDI
    implements RealmObjectProxy, com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface {

    static final class UseCFDIColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long descripcionIndex;
        long uso_SATIndex;

        UseCFDIColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UseCFDI");
            this.descripcionIndex = addColumnDetails("descripcion", "descripcion", objectSchemaInfo);
            this.uso_SATIndex = addColumnDetails("uso_SAT", "uso_SAT", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        UseCFDIColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UseCFDIColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UseCFDIColumnInfo src = (UseCFDIColumnInfo) rawSrc;
            final UseCFDIColumnInfo dst = (UseCFDIColumnInfo) rawDst;
            dst.descripcionIndex = src.descripcionIndex;
            dst.uso_SATIndex = src.uso_SATIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UseCFDIColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.UseCFDI> proxyState;

    com_mds_ventasabpollo_models_UseCFDIRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UseCFDIColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.UseCFDI>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$descripcion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcionIndex);
    }

    @Override
    public void realmSet$descripcion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descripcionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descripcionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descripcionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descripcionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uso_SAT() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uso_SATIndex);
    }

    @Override
    public void realmSet$uso_SAT(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.uso_SATIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.uso_SATIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.uso_SATIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.uso_SATIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UseCFDI", 2, 0);
        builder.addPersistedProperty("descripcion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("uso_SAT", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UseCFDIColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UseCFDIColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UseCFDI";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UseCFDI";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.UseCFDI createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.UseCFDI obj = realm.createObjectInternal(com.mds.ventasabpollo.models.UseCFDI.class, true, excludeFields);

        final com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) obj;
        if (json.has("descripcion")) {
            if (json.isNull("descripcion")) {
                objProxy.realmSet$descripcion(null);
            } else {
                objProxy.realmSet$descripcion((String) json.getString("descripcion"));
            }
        }
        if (json.has("uso_SAT")) {
            if (json.isNull("uso_SAT")) {
                objProxy.realmSet$uso_SAT(null);
            } else {
                objProxy.realmSet$uso_SAT((String) json.getString("uso_SAT"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.UseCFDI createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.UseCFDI obj = new com.mds.ventasabpollo.models.UseCFDI();
        final com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("descripcion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion(null);
                }
            } else if (name.equals("uso_SAT")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uso_SAT((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uso_SAT(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_UseCFDIRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.UseCFDI copyOrUpdate(Realm realm, UseCFDIColumnInfo columnInfo, com.mds.ventasabpollo.models.UseCFDI object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.UseCFDI) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.UseCFDI copy(Realm realm, UseCFDIColumnInfo columnInfo, com.mds.ventasabpollo.models.UseCFDI newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.UseCFDI) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.UseCFDI.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.descripcionIndex, realmObjectSource.realmGet$descripcion());
        builder.addString(columnInfo.uso_SATIndex, realmObjectSource.realmGet$uso_SAT());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_UseCFDIRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.UseCFDI object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.UseCFDI.class);
        long tableNativePtr = table.getNativePtr();
        UseCFDIColumnInfo columnInfo = (UseCFDIColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        }
        String realmGet$uso_SAT = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$uso_SAT();
        if (realmGet$uso_SAT != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, realmGet$uso_SAT, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.UseCFDI.class);
        long tableNativePtr = table.getNativePtr();
        UseCFDIColumnInfo columnInfo = (UseCFDIColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class);
        com.mds.ventasabpollo.models.UseCFDI object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.UseCFDI) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            }
            String realmGet$uso_SAT = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$uso_SAT();
            if (realmGet$uso_SAT != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, realmGet$uso_SAT, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.UseCFDI object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.UseCFDI.class);
        long tableNativePtr = table.getNativePtr();
        UseCFDIColumnInfo columnInfo = (UseCFDIColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
        }
        String realmGet$uso_SAT = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$uso_SAT();
        if (realmGet$uso_SAT != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, realmGet$uso_SAT, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.UseCFDI.class);
        long tableNativePtr = table.getNativePtr();
        UseCFDIColumnInfo columnInfo = (UseCFDIColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.UseCFDI.class);
        com.mds.ventasabpollo.models.UseCFDI object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.UseCFDI) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
            }
            String realmGet$uso_SAT = ((com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) object).realmGet$uso_SAT();
            if (realmGet$uso_SAT != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, realmGet$uso_SAT, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.uso_SATIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.UseCFDI createDetachedCopy(com.mds.ventasabpollo.models.UseCFDI realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.UseCFDI unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.UseCFDI();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.UseCFDI) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.UseCFDI) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_UseCFDIRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$descripcion(realmSource.realmGet$descripcion());
        unmanagedCopy.realmSet$uso_SAT(realmSource.realmGet$uso_SAT());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UseCFDI = proxy[");
        stringBuilder.append("{descripcion:");
        stringBuilder.append(realmGet$descripcion() != null ? realmGet$descripcion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uso_SAT:");
        stringBuilder.append(realmGet$uso_SAT() != null ? realmGet$uso_SAT() : "null");
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
        com_mds_ventasabpollo_models_UseCFDIRealmProxy aUseCFDI = (com_mds_ventasabpollo_models_UseCFDIRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUseCFDI.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUseCFDI.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUseCFDI.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
