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
public class com_mds_ventasabpollo_models_CitiesRealmProxy extends com.mds.ventasabpollo.models.Cities
    implements RealmObjectProxy, com_mds_ventasabpollo_models_CitiesRealmProxyInterface {

    static final class CitiesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long positionIndex;
        long ciudadIndex;
        long nombre_ciudadIndex;

        CitiesColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Cities");
            this.positionIndex = addColumnDetails("position", "position", objectSchemaInfo);
            this.ciudadIndex = addColumnDetails("ciudad", "ciudad", objectSchemaInfo);
            this.nombre_ciudadIndex = addColumnDetails("nombre_ciudad", "nombre_ciudad", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        CitiesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CitiesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CitiesColumnInfo src = (CitiesColumnInfo) rawSrc;
            final CitiesColumnInfo dst = (CitiesColumnInfo) rawDst;
            dst.positionIndex = src.positionIndex;
            dst.ciudadIndex = src.ciudadIndex;
            dst.nombre_ciudadIndex = src.nombre_ciudadIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CitiesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Cities> proxyState;

    com_mds_ventasabpollo_models_CitiesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CitiesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Cities>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$position() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.positionIndex);
    }

    @Override
    public void realmSet$position(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.positionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ciudad() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ciudadIndex);
    }

    @Override
    public void realmSet$ciudad(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ciudadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ciudadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_ciudad() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_ciudadIndex);
    }

    @Override
    public void realmSet$nombre_ciudad(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_ciudadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_ciudadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_ciudadIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_ciudadIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Cities", 3, 0);
        builder.addPersistedProperty("position", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ciudad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_ciudad", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CitiesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CitiesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Cities";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Cities";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Cities createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Cities obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Cities.class, true, excludeFields);

        final com_mds_ventasabpollo_models_CitiesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_CitiesRealmProxyInterface) obj;
        if (json.has("position")) {
            if (json.isNull("position")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
            } else {
                objProxy.realmSet$position((int) json.getInt("position"));
            }
        }
        if (json.has("ciudad")) {
            if (json.isNull("ciudad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad' to null.");
            } else {
                objProxy.realmSet$ciudad((int) json.getInt("ciudad"));
            }
        }
        if (json.has("nombre_ciudad")) {
            if (json.isNull("nombre_ciudad")) {
                objProxy.realmSet$nombre_ciudad(null);
            } else {
                objProxy.realmSet$nombre_ciudad((String) json.getString("nombre_ciudad"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Cities createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Cities obj = new com.mds.ventasabpollo.models.Cities();
        final com_mds_ventasabpollo_models_CitiesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_CitiesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("position")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$position((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
                }
            } else if (name.equals("ciudad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ciudad((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad' to null.");
                }
            } else if (name.equals("nombre_ciudad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_ciudad((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_ciudad(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_CitiesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Cities copyOrUpdate(Realm realm, CitiesColumnInfo columnInfo, com.mds.ventasabpollo.models.Cities object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Cities) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Cities copy(Realm realm, CitiesColumnInfo columnInfo, com.mds.ventasabpollo.models.Cities newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Cities) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_CitiesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_CitiesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Cities.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.positionIndex, realmObjectSource.realmGet$position());
        builder.addInteger(columnInfo.ciudadIndex, realmObjectSource.realmGet$ciudad());
        builder.addString(columnInfo.nombre_ciudadIndex, realmObjectSource.realmGet$nombre_ciudad());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_CitiesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Cities object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Cities.class);
        long tableNativePtr = table.getNativePtr();
        CitiesColumnInfo columnInfo = (CitiesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$position(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$ciudad(), false);
        String realmGet$nombre_ciudad = ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$nombre_ciudad();
        if (realmGet$nombre_ciudad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, realmGet$nombre_ciudad, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Cities.class);
        long tableNativePtr = table.getNativePtr();
        CitiesColumnInfo columnInfo = (CitiesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class);
        com.mds.ventasabpollo.models.Cities object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Cities) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$position(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$ciudad(), false);
            String realmGet$nombre_ciudad = ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$nombre_ciudad();
            if (realmGet$nombre_ciudad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, realmGet$nombre_ciudad, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Cities object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Cities.class);
        long tableNativePtr = table.getNativePtr();
        CitiesColumnInfo columnInfo = (CitiesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$position(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$ciudad(), false);
        String realmGet$nombre_ciudad = ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$nombre_ciudad();
        if (realmGet$nombre_ciudad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, realmGet$nombre_ciudad, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Cities.class);
        long tableNativePtr = table.getNativePtr();
        CitiesColumnInfo columnInfo = (CitiesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Cities.class);
        com.mds.ventasabpollo.models.Cities object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Cities) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$position(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$ciudad(), false);
            String realmGet$nombre_ciudad = ((com_mds_ventasabpollo_models_CitiesRealmProxyInterface) object).realmGet$nombre_ciudad();
            if (realmGet$nombre_ciudad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, realmGet$nombre_ciudad, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_ciudadIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.Cities createDetachedCopy(com.mds.ventasabpollo.models.Cities realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Cities unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Cities();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Cities) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Cities) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_CitiesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_CitiesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_CitiesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_CitiesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$position(realmSource.realmGet$position());
        unmanagedCopy.realmSet$ciudad(realmSource.realmGet$ciudad());
        unmanagedCopy.realmSet$nombre_ciudad(realmSource.realmGet$nombre_ciudad());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Cities = proxy[");
        stringBuilder.append("{position:");
        stringBuilder.append(realmGet$position());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ciudad:");
        stringBuilder.append(realmGet$ciudad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_ciudad:");
        stringBuilder.append(realmGet$nombre_ciudad() != null ? realmGet$nombre_ciudad() : "null");
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
        com_mds_ventasabpollo_models_CitiesRealmProxy aCities = (com_mds_ventasabpollo_models_CitiesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCities.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCities.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCities.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
