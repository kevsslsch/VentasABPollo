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
public class com_mds_ventasabpollo_models_ListsRealmProxy extends com.mds.ventasabpollo.models.Lists
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ListsRealmProxyInterface {

    static final class ListsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long listaIndex;
        long nombre_listaIndex;
        long nombre_rutaIndex;
        long comentariosIndex;
        long dia_semanaIndex;
        long user_idIndex;

        ListsColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Lists");
            this.listaIndex = addColumnDetails("lista", "lista", objectSchemaInfo);
            this.nombre_listaIndex = addColumnDetails("nombre_lista", "nombre_lista", objectSchemaInfo);
            this.nombre_rutaIndex = addColumnDetails("nombre_ruta", "nombre_ruta", objectSchemaInfo);
            this.comentariosIndex = addColumnDetails("comentarios", "comentarios", objectSchemaInfo);
            this.dia_semanaIndex = addColumnDetails("dia_semana", "dia_semana", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ListsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ListsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ListsColumnInfo src = (ListsColumnInfo) rawSrc;
            final ListsColumnInfo dst = (ListsColumnInfo) rawDst;
            dst.listaIndex = src.listaIndex;
            dst.nombre_listaIndex = src.nombre_listaIndex;
            dst.nombre_rutaIndex = src.nombre_rutaIndex;
            dst.comentariosIndex = src.comentariosIndex;
            dst.dia_semanaIndex = src.dia_semanaIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ListsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Lists> proxyState;

    com_mds_ventasabpollo_models_ListsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ListsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Lists>(this);
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
    public String realmGet$nombre_lista() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_listaIndex);
    }

    @Override
    public void realmSet$nombre_lista(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_listaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_listaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_listaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_listaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_ruta() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_rutaIndex);
    }

    @Override
    public void realmSet$nombre_ruta(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_rutaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_rutaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_rutaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_rutaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$comentarios() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.comentariosIndex);
    }

    @Override
    public void realmSet$comentarios(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.comentariosIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.comentariosIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.comentariosIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.comentariosIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$dia_semana() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.dia_semanaIndex);
    }

    @Override
    public void realmSet$dia_semana(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.dia_semanaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.dia_semanaIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Lists", 6, 0);
        builder.addPersistedProperty("lista", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_lista", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_ruta", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("comentarios", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("dia_semana", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ListsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ListsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Lists";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Lists";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Lists createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Lists obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Lists.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ListsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ListsRealmProxyInterface) obj;
        if (json.has("lista")) {
            if (json.isNull("lista")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lista' to null.");
            } else {
                objProxy.realmSet$lista((int) json.getInt("lista"));
            }
        }
        if (json.has("nombre_lista")) {
            if (json.isNull("nombre_lista")) {
                objProxy.realmSet$nombre_lista(null);
            } else {
                objProxy.realmSet$nombre_lista((String) json.getString("nombre_lista"));
            }
        }
        if (json.has("nombre_ruta")) {
            if (json.isNull("nombre_ruta")) {
                objProxy.realmSet$nombre_ruta(null);
            } else {
                objProxy.realmSet$nombre_ruta((String) json.getString("nombre_ruta"));
            }
        }
        if (json.has("comentarios")) {
            if (json.isNull("comentarios")) {
                objProxy.realmSet$comentarios(null);
            } else {
                objProxy.realmSet$comentarios((String) json.getString("comentarios"));
            }
        }
        if (json.has("dia_semana")) {
            if (json.isNull("dia_semana")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'dia_semana' to null.");
            } else {
                objProxy.realmSet$dia_semana((int) json.getInt("dia_semana"));
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
    public static com.mds.ventasabpollo.models.Lists createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Lists obj = new com.mds.ventasabpollo.models.Lists();
        final com_mds_ventasabpollo_models_ListsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ListsRealmProxyInterface) obj;
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
            } else if (name.equals("nombre_lista")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_lista((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_lista(null);
                }
            } else if (name.equals("nombre_ruta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_ruta((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_ruta(null);
                }
            } else if (name.equals("comentarios")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$comentarios((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$comentarios(null);
                }
            } else if (name.equals("dia_semana")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dia_semana((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'dia_semana' to null.");
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

    private static com_mds_ventasabpollo_models_ListsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ListsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ListsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Lists copyOrUpdate(Realm realm, ListsColumnInfo columnInfo, com.mds.ventasabpollo.models.Lists object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Lists) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Lists copy(Realm realm, ListsColumnInfo columnInfo, com.mds.ventasabpollo.models.Lists newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Lists) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ListsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ListsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Lists.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addString(columnInfo.nombre_listaIndex, realmObjectSource.realmGet$nombre_lista());
        builder.addString(columnInfo.nombre_rutaIndex, realmObjectSource.realmGet$nombre_ruta());
        builder.addString(columnInfo.comentariosIndex, realmObjectSource.realmGet$comentarios());
        builder.addInteger(columnInfo.dia_semanaIndex, realmObjectSource.realmGet$dia_semana());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ListsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Lists object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Lists.class);
        long tableNativePtr = table.getNativePtr();
        ListsColumnInfo columnInfo = (ListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$lista(), false);
        String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_lista();
        if (realmGet$nombre_lista != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
        }
        String realmGet$nombre_ruta = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_ruta();
        if (realmGet$nombre_ruta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, realmGet$nombre_ruta, false);
        }
        String realmGet$comentarios = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$comentarios();
        if (realmGet$comentarios != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.comentariosIndex, rowIndex, realmGet$comentarios, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dia_semanaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$dia_semana(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Lists.class);
        long tableNativePtr = table.getNativePtr();
        ListsColumnInfo columnInfo = (ListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class);
        com.mds.ventasabpollo.models.Lists object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Lists) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$lista(), false);
            String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_lista();
            if (realmGet$nombre_lista != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
            }
            String realmGet$nombre_ruta = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_ruta();
            if (realmGet$nombre_ruta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, realmGet$nombre_ruta, false);
            }
            String realmGet$comentarios = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$comentarios();
            if (realmGet$comentarios != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.comentariosIndex, rowIndex, realmGet$comentarios, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dia_semanaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$dia_semana(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Lists object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Lists.class);
        long tableNativePtr = table.getNativePtr();
        ListsColumnInfo columnInfo = (ListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$lista(), false);
        String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_lista();
        if (realmGet$nombre_lista != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, false);
        }
        String realmGet$nombre_ruta = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_ruta();
        if (realmGet$nombre_ruta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, realmGet$nombre_ruta, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, false);
        }
        String realmGet$comentarios = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$comentarios();
        if (realmGet$comentarios != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.comentariosIndex, rowIndex, realmGet$comentarios, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.comentariosIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dia_semanaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$dia_semana(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Lists.class);
        long tableNativePtr = table.getNativePtr();
        ListsColumnInfo columnInfo = (ListsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Lists.class);
        com.mds.ventasabpollo.models.Lists object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Lists) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$lista(), false);
            String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_lista();
            if (realmGet$nombre_lista != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, false);
            }
            String realmGet$nombre_ruta = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$nombre_ruta();
            if (realmGet$nombre_ruta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, realmGet$nombre_ruta, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_rutaIndex, rowIndex, false);
            }
            String realmGet$comentarios = ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$comentarios();
            if (realmGet$comentarios != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.comentariosIndex, rowIndex, realmGet$comentarios, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.comentariosIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dia_semanaIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$dia_semana(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ListsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.Lists createDetachedCopy(com.mds.ventasabpollo.models.Lists realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Lists unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Lists();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Lists) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Lists) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ListsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ListsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ListsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ListsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$lista(realmSource.realmGet$lista());
        unmanagedCopy.realmSet$nombre_lista(realmSource.realmGet$nombre_lista());
        unmanagedCopy.realmSet$nombre_ruta(realmSource.realmGet$nombre_ruta());
        unmanagedCopy.realmSet$comentarios(realmSource.realmGet$comentarios());
        unmanagedCopy.realmSet$dia_semana(realmSource.realmGet$dia_semana());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Lists = proxy[");
        stringBuilder.append("{lista:");
        stringBuilder.append(realmGet$lista());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_lista:");
        stringBuilder.append(realmGet$nombre_lista() != null ? realmGet$nombre_lista() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_ruta:");
        stringBuilder.append(realmGet$nombre_ruta() != null ? realmGet$nombre_ruta() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comentarios:");
        stringBuilder.append(realmGet$comentarios() != null ? realmGet$comentarios() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dia_semana:");
        stringBuilder.append(realmGet$dia_semana());
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
        com_mds_ventasabpollo_models_ListsRealmProxy aLists = (com_mds_ventasabpollo_models_ListsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLists.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLists.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLists.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
