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
public class com_mds_ventasabpollo_models_UsersRealmProxy extends com.mds.ventasabpollo.models.Users
    implements RealmObjectProxy, com_mds_ventasabpollo_models_UsersRealmProxyInterface {

    static final class UsersColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long personaIndex;
        long nombre_personaIndex;

        UsersColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Users");
            this.personaIndex = addColumnDetails("persona", "persona", objectSchemaInfo);
            this.nombre_personaIndex = addColumnDetails("nombre_persona", "nombre_persona", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        UsersColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UsersColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UsersColumnInfo src = (UsersColumnInfo) rawSrc;
            final UsersColumnInfo dst = (UsersColumnInfo) rawDst;
            dst.personaIndex = src.personaIndex;
            dst.nombre_personaIndex = src.nombre_personaIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UsersColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Users> proxyState;

    com_mds_ventasabpollo_models_UsersRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UsersColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Users>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$persona() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.personaIndex);
    }

    @Override
    public void realmSet$persona(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.personaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.personaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_persona() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_personaIndex);
    }

    @Override
    public void realmSet$nombre_persona(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_personaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_personaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_personaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_personaIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Users", 2, 0);
        builder.addPersistedProperty("persona", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_persona", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UsersColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UsersColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Users";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Users";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Users createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Users obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Users.class, true, excludeFields);

        final com_mds_ventasabpollo_models_UsersRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_UsersRealmProxyInterface) obj;
        if (json.has("persona")) {
            if (json.isNull("persona")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'persona' to null.");
            } else {
                objProxy.realmSet$persona((int) json.getInt("persona"));
            }
        }
        if (json.has("nombre_persona")) {
            if (json.isNull("nombre_persona")) {
                objProxy.realmSet$nombre_persona(null);
            } else {
                objProxy.realmSet$nombre_persona((String) json.getString("nombre_persona"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Users createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Users obj = new com.mds.ventasabpollo.models.Users();
        final com_mds_ventasabpollo_models_UsersRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_UsersRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("persona")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$persona((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'persona' to null.");
                }
            } else if (name.equals("nombre_persona")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_persona((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_persona(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_UsersRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_UsersRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_UsersRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Users copyOrUpdate(Realm realm, UsersColumnInfo columnInfo, com.mds.ventasabpollo.models.Users object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Users) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Users copy(Realm realm, UsersColumnInfo columnInfo, com.mds.ventasabpollo.models.Users newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Users) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_UsersRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_UsersRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Users.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.personaIndex, realmObjectSource.realmGet$persona());
        builder.addString(columnInfo.nombre_personaIndex, realmObjectSource.realmGet$nombre_persona());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_UsersRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Users object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Users.class);
        long tableNativePtr = table.getNativePtr();
        UsersColumnInfo columnInfo = (UsersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.personaIndex, rowIndex, ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$persona(), false);
        String realmGet$nombre_persona = ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$nombre_persona();
        if (realmGet$nombre_persona != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, realmGet$nombre_persona, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Users.class);
        long tableNativePtr = table.getNativePtr();
        UsersColumnInfo columnInfo = (UsersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class);
        com.mds.ventasabpollo.models.Users object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Users) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.personaIndex, rowIndex, ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$persona(), false);
            String realmGet$nombre_persona = ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$nombre_persona();
            if (realmGet$nombre_persona != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, realmGet$nombre_persona, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Users object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Users.class);
        long tableNativePtr = table.getNativePtr();
        UsersColumnInfo columnInfo = (UsersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.personaIndex, rowIndex, ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$persona(), false);
        String realmGet$nombre_persona = ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$nombre_persona();
        if (realmGet$nombre_persona != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, realmGet$nombre_persona, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Users.class);
        long tableNativePtr = table.getNativePtr();
        UsersColumnInfo columnInfo = (UsersColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Users.class);
        com.mds.ventasabpollo.models.Users object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Users) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.personaIndex, rowIndex, ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$persona(), false);
            String realmGet$nombre_persona = ((com_mds_ventasabpollo_models_UsersRealmProxyInterface) object).realmGet$nombre_persona();
            if (realmGet$nombre_persona != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, realmGet$nombre_persona, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_personaIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.Users createDetachedCopy(com.mds.ventasabpollo.models.Users realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Users unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Users();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Users) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Users) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_UsersRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_UsersRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_UsersRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_UsersRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$persona(realmSource.realmGet$persona());
        unmanagedCopy.realmSet$nombre_persona(realmSource.realmGet$nombre_persona());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Users = proxy[");
        stringBuilder.append("{persona:");
        stringBuilder.append(realmGet$persona());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_persona:");
        stringBuilder.append(realmGet$nombre_persona() != null ? realmGet$nombre_persona() : "null");
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
        com_mds_ventasabpollo_models_UsersRealmProxy aUsers = (com_mds_ventasabpollo_models_UsersRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUsers.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUsers.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUsers.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
