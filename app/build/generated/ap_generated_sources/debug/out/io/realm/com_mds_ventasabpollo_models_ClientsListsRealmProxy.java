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
public class com_mds_ventasabpollo_models_ClientsListsRealmProxy extends com.mds.ventasabpollo.models.ClientsLists
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface {

    static final class ClientsListsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long listaIndex;
        long clienteIndex;
        long ordenIndex;

        ClientsListsColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ClientsLists");
            this.listaIndex = addColumnDetails("lista", "lista", objectSchemaInfo);
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.ordenIndex = addColumnDetails("orden", "orden", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ClientsListsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ClientsListsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ClientsListsColumnInfo src = (ClientsListsColumnInfo) rawSrc;
            final ClientsListsColumnInfo dst = (ClientsListsColumnInfo) rawDst;
            dst.listaIndex = src.listaIndex;
            dst.clienteIndex = src.clienteIndex;
            dst.ordenIndex = src.ordenIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ClientsListsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.ClientsLists> proxyState;

    com_mds_ventasabpollo_models_ClientsListsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ClientsListsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.ClientsLists>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$lista() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.listaIndex);
    }

    @Override
    public void realmSet$lista(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.listaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.listaIndex, value);
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
    public int realmGet$orden() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ordenIndex);
    }

    @Override
    public void realmSet$orden(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ordenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ordenIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ClientsLists", 3, 0);
        builder.addPersistedProperty("lista", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("orden", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ClientsListsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ClientsListsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ClientsLists";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ClientsLists";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.ClientsLists createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.ClientsLists obj = realm.createObjectInternal(com.mds.ventasabpollo.models.ClientsLists.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) obj;
        if (json.has("lista")) {
            if (json.isNull("lista")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lista' to null.");
            } else {
                objProxy.realmSet$lista((int) json.getInt("lista"));
            }
        }
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("orden")) {
            if (json.isNull("orden")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'orden' to null.");
            } else {
                objProxy.realmSet$orden((int) json.getInt("orden"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.ClientsLists createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.ClientsLists obj = new com.mds.ventasabpollo.models.ClientsLists();
        final com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("lista")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lista((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lista' to null.");
                }
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("orden")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orden((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'orden' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_ClientsListsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.ClientsLists copyOrUpdate(Realm realm, ClientsListsColumnInfo columnInfo, com.mds.ventasabpollo.models.ClientsLists object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.ClientsLists) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.ClientsLists copy(Realm realm, ClientsListsColumnInfo columnInfo, com.mds.ventasabpollo.models.ClientsLists newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.ClientsLists) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.ClientsLists.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.ordenIndex, realmObjectSource.realmGet$orden());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ClientsListsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.ClientsLists object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ClientsLists.class);
        long tableNativePtr = table.getNativePtr();
        ClientsListsColumnInfo columnInfo = (ClientsListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$orden(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ClientsLists.class);
        long tableNativePtr = table.getNativePtr();
        ClientsListsColumnInfo columnInfo = (ClientsListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class);
        com.mds.ventasabpollo.models.ClientsLists object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ClientsLists) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$orden(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.ClientsLists object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ClientsLists.class);
        long tableNativePtr = table.getNativePtr();
        ClientsListsColumnInfo columnInfo = (ClientsListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$orden(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ClientsLists.class);
        long tableNativePtr = table.getNativePtr();
        ClientsListsColumnInfo columnInfo = (ClientsListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ClientsLists.class);
        com.mds.ventasabpollo.models.ClientsLists object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ClientsLists) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) object).realmGet$orden(), false);
        }
    }

    public static com.mds.ventasabpollo.models.ClientsLists createDetachedCopy(com.mds.ventasabpollo.models.ClientsLists realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.ClientsLists unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.ClientsLists();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.ClientsLists) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.ClientsLists) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ClientsListsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$lista(realmSource.realmGet$lista());
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$orden(realmSource.realmGet$orden());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ClientsLists = proxy[");
        stringBuilder.append("{lista:");
        stringBuilder.append(realmGet$lista());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orden:");
        stringBuilder.append(realmGet$orden());
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
        com_mds_ventasabpollo_models_ClientsListsRealmProxy aClientsLists = (com_mds_ventasabpollo_models_ClientsListsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aClientsLists.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aClientsLists.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aClientsLists.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
