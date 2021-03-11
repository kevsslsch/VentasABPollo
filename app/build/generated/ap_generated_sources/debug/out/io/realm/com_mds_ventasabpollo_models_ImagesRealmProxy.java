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
public class com_mds_ventasabpollo_models_ImagesRealmProxy extends com.mds.ventasabpollo.models.Images
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ImagesRealmProxyInterface {

    static final class ImagesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long fotoIndex;
        long clave_integerIndex;
        long texto_base64Index;
        long tablaIndex;

        ImagesColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Images");
            this.fotoIndex = addColumnDetails("foto", "foto", objectSchemaInfo);
            this.clave_integerIndex = addColumnDetails("clave_integer", "clave_integer", objectSchemaInfo);
            this.texto_base64Index = addColumnDetails("texto_base64", "texto_base64", objectSchemaInfo);
            this.tablaIndex = addColumnDetails("tabla", "tabla", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ImagesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ImagesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ImagesColumnInfo src = (ImagesColumnInfo) rawSrc;
            final ImagesColumnInfo dst = (ImagesColumnInfo) rawDst;
            dst.fotoIndex = src.fotoIndex;
            dst.clave_integerIndex = src.clave_integerIndex;
            dst.texto_base64Index = src.texto_base64Index;
            dst.tablaIndex = src.tablaIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ImagesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Images> proxyState;

    com_mds_ventasabpollo_models_ImagesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ImagesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Images>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$foto() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.fotoIndex);
    }

    @Override
    public void realmSet$foto(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.fotoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.fotoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$clave_integer() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clave_integerIndex);
    }

    @Override
    public void realmSet$clave_integer(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clave_integerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clave_integerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$texto_base64() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.texto_base64Index);
    }

    @Override
    public void realmSet$texto_base64(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.texto_base64Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.texto_base64Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.texto_base64Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.texto_base64Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tabla() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tablaIndex);
    }

    @Override
    public void realmSet$tabla(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tablaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tablaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tablaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tablaIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Images", 4, 0);
        builder.addPersistedProperty("foto", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_integer", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("texto_base64", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tabla", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ImagesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ImagesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Images";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Images";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Images createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Images obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Images.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ImagesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ImagesRealmProxyInterface) obj;
        if (json.has("foto")) {
            if (json.isNull("foto")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'foto' to null.");
            } else {
                objProxy.realmSet$foto((int) json.getInt("foto"));
            }
        }
        if (json.has("clave_integer")) {
            if (json.isNull("clave_integer")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_integer' to null.");
            } else {
                objProxy.realmSet$clave_integer((int) json.getInt("clave_integer"));
            }
        }
        if (json.has("texto_base64")) {
            if (json.isNull("texto_base64")) {
                objProxy.realmSet$texto_base64(null);
            } else {
                objProxy.realmSet$texto_base64((String) json.getString("texto_base64"));
            }
        }
        if (json.has("tabla")) {
            if (json.isNull("tabla")) {
                objProxy.realmSet$tabla(null);
            } else {
                objProxy.realmSet$tabla((String) json.getString("tabla"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Images createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Images obj = new com.mds.ventasabpollo.models.Images();
        final com_mds_ventasabpollo_models_ImagesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ImagesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("foto")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$foto((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'foto' to null.");
                }
            } else if (name.equals("clave_integer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_integer((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_integer' to null.");
                }
            } else if (name.equals("texto_base64")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$texto_base64((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$texto_base64(null);
                }
            } else if (name.equals("tabla")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tabla((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tabla(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_ImagesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Images copyOrUpdate(Realm realm, ImagesColumnInfo columnInfo, com.mds.ventasabpollo.models.Images object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Images) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Images copy(Realm realm, ImagesColumnInfo columnInfo, com.mds.ventasabpollo.models.Images newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Images) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ImagesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ImagesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Images.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.fotoIndex, realmObjectSource.realmGet$foto());
        builder.addInteger(columnInfo.clave_integerIndex, realmObjectSource.realmGet$clave_integer());
        builder.addString(columnInfo.texto_base64Index, realmObjectSource.realmGet$texto_base64());
        builder.addString(columnInfo.tablaIndex, realmObjectSource.realmGet$tabla());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ImagesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Images object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Images.class);
        long tableNativePtr = table.getNativePtr();
        ImagesColumnInfo columnInfo = (ImagesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.fotoIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$foto(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_integerIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$clave_integer(), false);
        String realmGet$texto_base64 = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$texto_base64();
        if (realmGet$texto_base64 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.texto_base64Index, rowIndex, realmGet$texto_base64, false);
        }
        String realmGet$tabla = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$tabla();
        if (realmGet$tabla != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tablaIndex, rowIndex, realmGet$tabla, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Images.class);
        long tableNativePtr = table.getNativePtr();
        ImagesColumnInfo columnInfo = (ImagesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class);
        com.mds.ventasabpollo.models.Images object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Images) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.fotoIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$foto(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_integerIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$clave_integer(), false);
            String realmGet$texto_base64 = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$texto_base64();
            if (realmGet$texto_base64 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.texto_base64Index, rowIndex, realmGet$texto_base64, false);
            }
            String realmGet$tabla = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$tabla();
            if (realmGet$tabla != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tablaIndex, rowIndex, realmGet$tabla, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Images object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Images.class);
        long tableNativePtr = table.getNativePtr();
        ImagesColumnInfo columnInfo = (ImagesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.fotoIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$foto(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_integerIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$clave_integer(), false);
        String realmGet$texto_base64 = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$texto_base64();
        if (realmGet$texto_base64 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.texto_base64Index, rowIndex, realmGet$texto_base64, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.texto_base64Index, rowIndex, false);
        }
        String realmGet$tabla = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$tabla();
        if (realmGet$tabla != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tablaIndex, rowIndex, realmGet$tabla, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tablaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Images.class);
        long tableNativePtr = table.getNativePtr();
        ImagesColumnInfo columnInfo = (ImagesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Images.class);
        com.mds.ventasabpollo.models.Images object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Images) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.fotoIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$foto(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_integerIndex, rowIndex, ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$clave_integer(), false);
            String realmGet$texto_base64 = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$texto_base64();
            if (realmGet$texto_base64 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.texto_base64Index, rowIndex, realmGet$texto_base64, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.texto_base64Index, rowIndex, false);
            }
            String realmGet$tabla = ((com_mds_ventasabpollo_models_ImagesRealmProxyInterface) object).realmGet$tabla();
            if (realmGet$tabla != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tablaIndex, rowIndex, realmGet$tabla, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tablaIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.Images createDetachedCopy(com.mds.ventasabpollo.models.Images realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Images unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Images();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Images) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Images) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ImagesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ImagesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ImagesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ImagesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$foto(realmSource.realmGet$foto());
        unmanagedCopy.realmSet$clave_integer(realmSource.realmGet$clave_integer());
        unmanagedCopy.realmSet$texto_base64(realmSource.realmGet$texto_base64());
        unmanagedCopy.realmSet$tabla(realmSource.realmGet$tabla());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Images = proxy[");
        stringBuilder.append("{foto:");
        stringBuilder.append(realmGet$foto());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_integer:");
        stringBuilder.append(realmGet$clave_integer());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{texto_base64:");
        stringBuilder.append(realmGet$texto_base64() != null ? realmGet$texto_base64() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tabla:");
        stringBuilder.append(realmGet$tabla() != null ? realmGet$tabla() : "null");
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
        com_mds_ventasabpollo_models_ImagesRealmProxy aImages = (com_mds_ventasabpollo_models_ImagesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aImages.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aImages.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aImages.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
