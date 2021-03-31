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
public class com_mds_ventasabpollo_models_MethodPayRealmProxy extends com.mds.ventasabpollo.models.MethodPay
    implements RealmObjectProxy, com_mds_ventasabpollo_models_MethodPayRealmProxyInterface {

    static final class MethodPayColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long descripcionIndex;
        long metodo_SATIndex;

        MethodPayColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MethodPay");
            this.descripcionIndex = addColumnDetails("descripcion", "descripcion", objectSchemaInfo);
            this.metodo_SATIndex = addColumnDetails("metodo_SAT", "metodo_SAT", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        MethodPayColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MethodPayColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MethodPayColumnInfo src = (MethodPayColumnInfo) rawSrc;
            final MethodPayColumnInfo dst = (MethodPayColumnInfo) rawDst;
            dst.descripcionIndex = src.descripcionIndex;
            dst.metodo_SATIndex = src.metodo_SATIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MethodPayColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.MethodPay> proxyState;

    com_mds_ventasabpollo_models_MethodPayRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MethodPayColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.MethodPay>(this);
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
    public String realmGet$metodo_SAT() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metodo_SATIndex);
    }

    @Override
    public void realmSet$metodo_SAT(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metodo_SATIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metodo_SATIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metodo_SATIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metodo_SATIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MethodPay", 2, 0);
        builder.addPersistedProperty("descripcion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("metodo_SAT", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MethodPayColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MethodPayColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MethodPay";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MethodPay";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.MethodPay createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.MethodPay obj = realm.createObjectInternal(com.mds.ventasabpollo.models.MethodPay.class, true, excludeFields);

        final com_mds_ventasabpollo_models_MethodPayRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) obj;
        if (json.has("descripcion")) {
            if (json.isNull("descripcion")) {
                objProxy.realmSet$descripcion(null);
            } else {
                objProxy.realmSet$descripcion((String) json.getString("descripcion"));
            }
        }
        if (json.has("metodo_SAT")) {
            if (json.isNull("metodo_SAT")) {
                objProxy.realmSet$metodo_SAT(null);
            } else {
                objProxy.realmSet$metodo_SAT((String) json.getString("metodo_SAT"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.MethodPay createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.MethodPay obj = new com.mds.ventasabpollo.models.MethodPay();
        final com_mds_ventasabpollo_models_MethodPayRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) obj;
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
            } else if (name.equals("metodo_SAT")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metodo_SAT((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metodo_SAT(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_MethodPayRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.MethodPay copyOrUpdate(Realm realm, MethodPayColumnInfo columnInfo, com.mds.ventasabpollo.models.MethodPay object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.MethodPay) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.MethodPay copy(Realm realm, MethodPayColumnInfo columnInfo, com.mds.ventasabpollo.models.MethodPay newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.MethodPay) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_MethodPayRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.MethodPay.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.descripcionIndex, realmObjectSource.realmGet$descripcion());
        builder.addString(columnInfo.metodo_SATIndex, realmObjectSource.realmGet$metodo_SAT());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_MethodPayRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.MethodPay object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.MethodPay.class);
        long tableNativePtr = table.getNativePtr();
        MethodPayColumnInfo columnInfo = (MethodPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        }
        String realmGet$metodo_SAT = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$metodo_SAT();
        if (realmGet$metodo_SAT != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, realmGet$metodo_SAT, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.MethodPay.class);
        long tableNativePtr = table.getNativePtr();
        MethodPayColumnInfo columnInfo = (MethodPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class);
        com.mds.ventasabpollo.models.MethodPay object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.MethodPay) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            }
            String realmGet$metodo_SAT = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$metodo_SAT();
            if (realmGet$metodo_SAT != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, realmGet$metodo_SAT, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.MethodPay object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.MethodPay.class);
        long tableNativePtr = table.getNativePtr();
        MethodPayColumnInfo columnInfo = (MethodPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
        }
        String realmGet$metodo_SAT = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$metodo_SAT();
        if (realmGet$metodo_SAT != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, realmGet$metodo_SAT, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.MethodPay.class);
        long tableNativePtr = table.getNativePtr();
        MethodPayColumnInfo columnInfo = (MethodPayColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MethodPay.class);
        com.mds.ventasabpollo.models.MethodPay object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.MethodPay) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
            }
            String realmGet$metodo_SAT = ((com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) object).realmGet$metodo_SAT();
            if (realmGet$metodo_SAT != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, realmGet$metodo_SAT, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metodo_SATIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.MethodPay createDetachedCopy(com.mds.ventasabpollo.models.MethodPay realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.MethodPay unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.MethodPay();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.MethodPay) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.MethodPay) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_MethodPayRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_MethodPayRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_MethodPayRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$descripcion(realmSource.realmGet$descripcion());
        unmanagedCopy.realmSet$metodo_SAT(realmSource.realmGet$metodo_SAT());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MethodPay = proxy[");
        stringBuilder.append("{descripcion:");
        stringBuilder.append(realmGet$descripcion() != null ? realmGet$descripcion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{metodo_SAT:");
        stringBuilder.append(realmGet$metodo_SAT() != null ? realmGet$metodo_SAT() : "null");
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
        com_mds_ventasabpollo_models_MethodPayRealmProxy aMethodPay = (com_mds_ventasabpollo_models_MethodPayRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMethodPay.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMethodPay.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMethodPay.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
