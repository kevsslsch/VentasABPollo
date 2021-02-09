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
public class com_mds_ventasabpollo_models_MapRoutesRealmProxy extends com.mds.ventasabpollo.models.MapRoutes
    implements RealmObjectProxy, com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface {

    static final class MapRoutesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long listaIndex;
        long clienteIndex;
        long nombre_clienteIndex;
        long nombre_comercialIndex;
        long latitudIndex;
        long longitudIndex;
        long ordenIndex;
        long user_idIndex;

        MapRoutesColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MapRoutes");
            this.listaIndex = addColumnDetails("lista", "lista", objectSchemaInfo);
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.nombre_clienteIndex = addColumnDetails("nombre_cliente", "nombre_cliente", objectSchemaInfo);
            this.nombre_comercialIndex = addColumnDetails("nombre_comercial", "nombre_comercial", objectSchemaInfo);
            this.latitudIndex = addColumnDetails("latitud", "latitud", objectSchemaInfo);
            this.longitudIndex = addColumnDetails("longitud", "longitud", objectSchemaInfo);
            this.ordenIndex = addColumnDetails("orden", "orden", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        MapRoutesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MapRoutesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MapRoutesColumnInfo src = (MapRoutesColumnInfo) rawSrc;
            final MapRoutesColumnInfo dst = (MapRoutesColumnInfo) rawDst;
            dst.listaIndex = src.listaIndex;
            dst.clienteIndex = src.clienteIndex;
            dst.nombre_clienteIndex = src.nombre_clienteIndex;
            dst.nombre_comercialIndex = src.nombre_comercialIndex;
            dst.latitudIndex = src.latitudIndex;
            dst.longitudIndex = src.longitudIndex;
            dst.ordenIndex = src.ordenIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MapRoutesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.MapRoutes> proxyState;

    com_mds_ventasabpollo_models_MapRoutesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MapRoutesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.MapRoutes>(this);
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
    public String realmGet$nombre_cliente() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_clienteIndex);
    }

    @Override
    public void realmSet$nombre_cliente(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_clienteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_clienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_clienteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_clienteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_comercial() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_comercialIndex);
    }

    @Override
    public void realmSet$nombre_comercial(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_comercialIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_comercialIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_comercialIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_comercialIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitud() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudIndex);
    }

    @Override
    public void realmSet$latitud(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitudIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitudIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitud() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudIndex);
    }

    @Override
    public void realmSet$longitud(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitudIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitudIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MapRoutes", 8, 0);
        builder.addPersistedProperty("lista", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_cliente", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_comercial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("latitud", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitud", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("orden", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MapRoutesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MapRoutesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MapRoutes";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MapRoutes";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.MapRoutes createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.MapRoutes obj = realm.createObjectInternal(com.mds.ventasabpollo.models.MapRoutes.class, true, excludeFields);

        final com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) obj;
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
        if (json.has("nombre_cliente")) {
            if (json.isNull("nombre_cliente")) {
                objProxy.realmSet$nombre_cliente(null);
            } else {
                objProxy.realmSet$nombre_cliente((String) json.getString("nombre_cliente"));
            }
        }
        if (json.has("nombre_comercial")) {
            if (json.isNull("nombre_comercial")) {
                objProxy.realmSet$nombre_comercial(null);
            } else {
                objProxy.realmSet$nombre_comercial((String) json.getString("nombre_comercial"));
            }
        }
        if (json.has("latitud")) {
            if (json.isNull("latitud")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitud' to null.");
            } else {
                objProxy.realmSet$latitud((double) json.getDouble("latitud"));
            }
        }
        if (json.has("longitud")) {
            if (json.isNull("longitud")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitud' to null.");
            } else {
                objProxy.realmSet$longitud((double) json.getDouble("longitud"));
            }
        }
        if (json.has("orden")) {
            if (json.isNull("orden")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'orden' to null.");
            } else {
                objProxy.realmSet$orden((int) json.getInt("orden"));
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
    public static com.mds.ventasabpollo.models.MapRoutes createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.MapRoutes obj = new com.mds.ventasabpollo.models.MapRoutes();
        final com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) obj;
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
            } else if (name.equals("nombre_cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_cliente((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_cliente(null);
                }
            } else if (name.equals("nombre_comercial")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_comercial((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_comercial(null);
                }
            } else if (name.equals("latitud")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitud((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitud' to null.");
                }
            } else if (name.equals("longitud")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitud((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitud' to null.");
                }
            } else if (name.equals("orden")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orden((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'orden' to null.");
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

    private static com_mds_ventasabpollo_models_MapRoutesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.MapRoutes copyOrUpdate(Realm realm, MapRoutesColumnInfo columnInfo, com.mds.ventasabpollo.models.MapRoutes object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.MapRoutes) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.MapRoutes copy(Realm realm, MapRoutesColumnInfo columnInfo, com.mds.ventasabpollo.models.MapRoutes newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.MapRoutes) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.MapRoutes.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addString(columnInfo.nombre_clienteIndex, realmObjectSource.realmGet$nombre_cliente());
        builder.addString(columnInfo.nombre_comercialIndex, realmObjectSource.realmGet$nombre_comercial());
        builder.addDouble(columnInfo.latitudIndex, realmObjectSource.realmGet$latitud());
        builder.addDouble(columnInfo.longitudIndex, realmObjectSource.realmGet$longitud());
        builder.addInteger(columnInfo.ordenIndex, realmObjectSource.realmGet$orden());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_MapRoutesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.MapRoutes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.MapRoutes.class);
        long tableNativePtr = table.getNativePtr();
        MapRoutesColumnInfo columnInfo = (MapRoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$cliente(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$latitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$longitud(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$orden(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.MapRoutes.class);
        long tableNativePtr = table.getNativePtr();
        MapRoutesColumnInfo columnInfo = (MapRoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class);
        com.mds.ventasabpollo.models.MapRoutes object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.MapRoutes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$cliente(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$latitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$longitud(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$orden(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.MapRoutes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.MapRoutes.class);
        long tableNativePtr = table.getNativePtr();
        MapRoutesColumnInfo columnInfo = (MapRoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$cliente(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$latitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$longitud(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$orden(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.MapRoutes.class);
        long tableNativePtr = table.getNativePtr();
        MapRoutesColumnInfo columnInfo = (MapRoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.MapRoutes.class);
        com.mds.ventasabpollo.models.MapRoutes object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.MapRoutes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$cliente(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$latitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$longitud(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ordenIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$orden(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.MapRoutes createDetachedCopy(com.mds.ventasabpollo.models.MapRoutes realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.MapRoutes unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.MapRoutes();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.MapRoutes) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.MapRoutes) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_MapRoutesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$lista(realmSource.realmGet$lista());
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$nombre_cliente(realmSource.realmGet$nombre_cliente());
        unmanagedCopy.realmSet$nombre_comercial(realmSource.realmGet$nombre_comercial());
        unmanagedCopy.realmSet$latitud(realmSource.realmGet$latitud());
        unmanagedCopy.realmSet$longitud(realmSource.realmGet$longitud());
        unmanagedCopy.realmSet$orden(realmSource.realmGet$orden());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MapRoutes = proxy[");
        stringBuilder.append("{lista:");
        stringBuilder.append(realmGet$lista());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_cliente:");
        stringBuilder.append(realmGet$nombre_cliente() != null ? realmGet$nombre_cliente() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_comercial:");
        stringBuilder.append(realmGet$nombre_comercial() != null ? realmGet$nombre_comercial() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitud:");
        stringBuilder.append(realmGet$latitud());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitud:");
        stringBuilder.append(realmGet$longitud());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orden:");
        stringBuilder.append(realmGet$orden());
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
        com_mds_ventasabpollo_models_MapRoutesRealmProxy aMapRoutes = (com_mds_ventasabpollo_models_MapRoutesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMapRoutes.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMapRoutes.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMapRoutes.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
