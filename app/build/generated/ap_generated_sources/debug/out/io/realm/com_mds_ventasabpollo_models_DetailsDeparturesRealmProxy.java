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
public class com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy extends com.mds.ventasabpollo.models.DetailsDepartures
    implements RealmObjectProxy, com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface {

    static final class DetailsDeparturesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long salidaIndex;
        long clave_articuloIndex;
        long nombre_articuloIndex;
        long cantidadIndex;

        DetailsDeparturesColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DetailsDepartures");
            this.salidaIndex = addColumnDetails("salida", "salida", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.nombre_articuloIndex = addColumnDetails("nombre_articulo", "nombre_articulo", objectSchemaInfo);
            this.cantidadIndex = addColumnDetails("cantidad", "cantidad", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        DetailsDeparturesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DetailsDeparturesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DetailsDeparturesColumnInfo src = (DetailsDeparturesColumnInfo) rawSrc;
            final DetailsDeparturesColumnInfo dst = (DetailsDeparturesColumnInfo) rawDst;
            dst.salidaIndex = src.salidaIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.nombre_articuloIndex = src.nombre_articuloIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DetailsDeparturesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.DetailsDepartures> proxyState;

    com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DetailsDeparturesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.DetailsDepartures>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public String realmGet$nombre_articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_articuloIndex);
    }

    @Override
    public void realmSet$nombre_articulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_articuloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_articuloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$cantidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadIndex);
    }

    @Override
    public void realmSet$cantidad(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cantidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cantidadIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DetailsDepartures", 4, 0);
        builder.addPersistedProperty("salida", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_articulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("cantidad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DetailsDeparturesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DetailsDeparturesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DetailsDepartures";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "DetailsDepartures";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.DetailsDepartures createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.DetailsDepartures obj = realm.createObjectInternal(com.mds.ventasabpollo.models.DetailsDepartures.class, true, excludeFields);

        final com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) obj;
        if (json.has("salida")) {
            if (json.isNull("salida")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
            } else {
                objProxy.realmSet$salida((int) json.getInt("salida"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("nombre_articulo")) {
            if (json.isNull("nombre_articulo")) {
                objProxy.realmSet$nombre_articulo(null);
            } else {
                objProxy.realmSet$nombre_articulo((String) json.getString("nombre_articulo"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
            } else {
                objProxy.realmSet$cantidad((int) json.getInt("cantidad"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.DetailsDepartures createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.DetailsDepartures obj = new com.mds.ventasabpollo.models.DetailsDepartures();
        final com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("salida")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$salida((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
                }
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("nombre_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_articulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_articulo(null);
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad((int) reader.nextInt());
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

    private static com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.DetailsDepartures copyOrUpdate(Realm realm, DetailsDeparturesColumnInfo columnInfo, com.mds.ventasabpollo.models.DetailsDepartures object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.DetailsDepartures) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.DetailsDepartures copy(Realm realm, DetailsDeparturesColumnInfo columnInfo, com.mds.ventasabpollo.models.DetailsDepartures newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.DetailsDepartures) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsDepartures.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.salidaIndex, realmObjectSource.realmGet$salida());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addString(columnInfo.nombre_articuloIndex, realmObjectSource.realmGet$nombre_articulo());
        builder.addInteger(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.DetailsDepartures object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long tableNativePtr = table.getNativePtr();
        DetailsDeparturesColumnInfo columnInfo = (DetailsDeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$cantidad(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long tableNativePtr = table.getNativePtr();
        DetailsDeparturesColumnInfo columnInfo = (DetailsDeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class);
        com.mds.ventasabpollo.models.DetailsDepartures object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.DetailsDepartures) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$cantidad(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.DetailsDepartures object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long tableNativePtr = table.getNativePtr();
        DetailsDeparturesColumnInfo columnInfo = (DetailsDeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$cantidad(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.DetailsDepartures.class);
        long tableNativePtr = table.getNativePtr();
        DetailsDeparturesColumnInfo columnInfo = (DetailsDeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.DetailsDepartures.class);
        com.mds.ventasabpollo.models.DetailsDepartures object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.DetailsDepartures) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) object).realmGet$cantidad(), false);
        }
    }

    public static com.mds.ventasabpollo.models.DetailsDepartures createDetachedCopy(com.mds.ventasabpollo.models.DetailsDepartures realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.DetailsDepartures unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.DetailsDepartures();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.DetailsDepartures) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.DetailsDepartures) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$salida(realmSource.realmGet$salida());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$nombre_articulo(realmSource.realmGet$nombre_articulo());
        unmanagedCopy.realmSet$cantidad(realmSource.realmGet$cantidad());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DetailsDepartures = proxy[");
        stringBuilder.append("{salida:");
        stringBuilder.append(realmGet$salida());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_articulo:");
        stringBuilder.append(realmGet$nombre_articulo() != null ? realmGet$nombre_articulo() : "null");
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
        com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy aDetailsDepartures = (com_mds_ventasabpollo_models_DetailsDeparturesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDetailsDepartures.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDetailsDepartures.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDetailsDepartures.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
