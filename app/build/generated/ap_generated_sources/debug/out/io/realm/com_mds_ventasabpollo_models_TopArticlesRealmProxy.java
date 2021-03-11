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
public class com_mds_ventasabpollo_models_TopArticlesRealmProxy extends com.mds.ventasabpollo.models.TopArticles
    implements RealmObjectProxy, com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface {

    static final class TopArticlesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clave_articuloIndex;
        long clicksIndex;
        long es_topIndex;
        long fecha_registroIndex;
        long user_idIndex;

        TopArticlesColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("TopArticles");
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.clicksIndex = addColumnDetails("clicks", "clicks", objectSchemaInfo);
            this.es_topIndex = addColumnDetails("es_top", "es_top", objectSchemaInfo);
            this.fecha_registroIndex = addColumnDetails("fecha_registro", "fecha_registro", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        TopArticlesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TopArticlesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TopArticlesColumnInfo src = (TopArticlesColumnInfo) rawSrc;
            final TopArticlesColumnInfo dst = (TopArticlesColumnInfo) rawDst;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.clicksIndex = src.clicksIndex;
            dst.es_topIndex = src.es_topIndex;
            dst.fecha_registroIndex = src.fecha_registroIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TopArticlesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.TopArticles> proxyState;

    com_mds_ventasabpollo_models_TopArticlesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TopArticlesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.TopArticles>(this);
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
    public int realmGet$clicks() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clicksIndex);
    }

    @Override
    public void realmSet$clicks(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clicksIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clicksIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$es_top() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.es_topIndex);
    }

    @Override
    public void realmSet$es_top(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.es_topIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.es_topIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_registro() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_registroIndex);
    }

    @Override
    public void realmSet$fecha_registro(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_registroIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_registroIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_registroIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_registroIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("TopArticles", 5, 0);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clicks", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("es_top", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha_registro", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TopArticlesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TopArticlesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "TopArticles";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "TopArticles";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.TopArticles createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.TopArticles obj = realm.createObjectInternal(com.mds.ventasabpollo.models.TopArticles.class, true, excludeFields);

        final com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) obj;
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("clicks")) {
            if (json.isNull("clicks")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clicks' to null.");
            } else {
                objProxy.realmSet$clicks((int) json.getInt("clicks"));
            }
        }
        if (json.has("es_top")) {
            if (json.isNull("es_top")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'es_top' to null.");
            } else {
                objProxy.realmSet$es_top((boolean) json.getBoolean("es_top"));
            }
        }
        if (json.has("fecha_registro")) {
            if (json.isNull("fecha_registro")) {
                objProxy.realmSet$fecha_registro(null);
            } else {
                objProxy.realmSet$fecha_registro((String) json.getString("fecha_registro"));
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
    public static com.mds.ventasabpollo.models.TopArticles createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.TopArticles obj = new com.mds.ventasabpollo.models.TopArticles();
        final com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) obj;
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
            } else if (name.equals("clicks")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clicks((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clicks' to null.");
                }
            } else if (name.equals("es_top")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$es_top((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'es_top' to null.");
                }
            } else if (name.equals("fecha_registro")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_registro((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_registro(null);
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

    private static com_mds_ventasabpollo_models_TopArticlesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.TopArticles copyOrUpdate(Realm realm, TopArticlesColumnInfo columnInfo, com.mds.ventasabpollo.models.TopArticles object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.TopArticles) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.TopArticles copy(Realm realm, TopArticlesColumnInfo columnInfo, com.mds.ventasabpollo.models.TopArticles newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.TopArticles) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.TopArticles.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addInteger(columnInfo.clicksIndex, realmObjectSource.realmGet$clicks());
        builder.addBoolean(columnInfo.es_topIndex, realmObjectSource.realmGet$es_top());
        builder.addString(columnInfo.fecha_registroIndex, realmObjectSource.realmGet$fecha_registro());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_TopArticlesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.TopArticles object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.TopArticles.class);
        long tableNativePtr = table.getNativePtr();
        TopArticlesColumnInfo columnInfo = (TopArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clicksIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clicks(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_topIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$es_top(), false);
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.TopArticles.class);
        long tableNativePtr = table.getNativePtr();
        TopArticlesColumnInfo columnInfo = (TopArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class);
        com.mds.ventasabpollo.models.TopArticles object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.TopArticles) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clicksIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clicks(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_topIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$es_top(), false);
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.TopArticles object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.TopArticles.class);
        long tableNativePtr = table.getNativePtr();
        TopArticlesColumnInfo columnInfo = (TopArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clicksIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clicks(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_topIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$es_top(), false);
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.TopArticles.class);
        long tableNativePtr = table.getNativePtr();
        TopArticlesColumnInfo columnInfo = (TopArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.TopArticles.class);
        com.mds.ventasabpollo.models.TopArticles object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.TopArticles) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clicksIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$clicks(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_topIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$es_top(), false);
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.TopArticles createDetachedCopy(com.mds.ventasabpollo.models.TopArticles realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.TopArticles unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.TopArticles();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.TopArticles) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.TopArticles) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_TopArticlesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$clicks(realmSource.realmGet$clicks());
        unmanagedCopy.realmSet$es_top(realmSource.realmGet$es_top());
        unmanagedCopy.realmSet$fecha_registro(realmSource.realmGet$fecha_registro());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TopArticles = proxy[");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clicks:");
        stringBuilder.append(realmGet$clicks());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{es_top:");
        stringBuilder.append(realmGet$es_top());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_registro:");
        stringBuilder.append(realmGet$fecha_registro() != null ? realmGet$fecha_registro() : "null");
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
        com_mds_ventasabpollo_models_TopArticlesRealmProxy aTopArticles = (com_mds_ventasabpollo_models_TopArticlesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTopArticles.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTopArticles.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTopArticles.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
