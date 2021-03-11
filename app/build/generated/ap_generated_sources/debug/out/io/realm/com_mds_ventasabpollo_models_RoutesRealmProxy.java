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
public class com_mds_ventasabpollo_models_RoutesRealmProxy extends com.mds.ventasabpollo.models.Routes
    implements RealmObjectProxy, com_mds_ventasabpollo_models_RoutesRealmProxyInterface {

    static final class RoutesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long rutaIndex;
        long salidaIndex;
        long autorizador_inicioIndex;
        long autorizado_finIndex;
        long nombre_autorizador_inicioIndex;
        long fecha_inicioIndex;
        long fecha_finIndex;
        long enviadaIndex;
        long user_idIndex;

        RoutesColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Routes");
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.salidaIndex = addColumnDetails("salida", "salida", objectSchemaInfo);
            this.autorizador_inicioIndex = addColumnDetails("autorizador_inicio", "autorizador_inicio", objectSchemaInfo);
            this.autorizado_finIndex = addColumnDetails("autorizado_fin", "autorizado_fin", objectSchemaInfo);
            this.nombre_autorizador_inicioIndex = addColumnDetails("nombre_autorizador_inicio", "nombre_autorizador_inicio", objectSchemaInfo);
            this.fecha_inicioIndex = addColumnDetails("fecha_inicio", "fecha_inicio", objectSchemaInfo);
            this.fecha_finIndex = addColumnDetails("fecha_fin", "fecha_fin", objectSchemaInfo);
            this.enviadaIndex = addColumnDetails("enviada", "enviada", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        RoutesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RoutesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RoutesColumnInfo src = (RoutesColumnInfo) rawSrc;
            final RoutesColumnInfo dst = (RoutesColumnInfo) rawDst;
            dst.rutaIndex = src.rutaIndex;
            dst.salidaIndex = src.salidaIndex;
            dst.autorizador_inicioIndex = src.autorizador_inicioIndex;
            dst.autorizado_finIndex = src.autorizado_finIndex;
            dst.nombre_autorizador_inicioIndex = src.nombre_autorizador_inicioIndex;
            dst.fecha_inicioIndex = src.fecha_inicioIndex;
            dst.fecha_finIndex = src.fecha_finIndex;
            dst.enviadaIndex = src.enviadaIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RoutesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Routes> proxyState;

    com_mds_ventasabpollo_models_RoutesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RoutesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Routes>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ruta() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rutaIndex);
    }

    @Override
    public void realmSet$ruta(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'ruta' cannot be changed after object was created.");
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
    public int realmGet$autorizador_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.autorizador_inicioIndex);
    }

    @Override
    public void realmSet$autorizador_inicio(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.autorizador_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.autorizador_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$autorizado_fin() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.autorizado_finIndex);
    }

    @Override
    public void realmSet$autorizado_fin(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.autorizado_finIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.autorizado_finIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_autorizador_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_autorizador_inicioIndex);
    }

    @Override
    public void realmSet$nombre_autorizador_inicio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_autorizador_inicioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_autorizador_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_autorizador_inicioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_autorizador_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_inicioIndex);
    }

    @Override
    public void realmSet$fecha_inicio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_inicioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_inicioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_fin() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_finIndex);
    }

    @Override
    public void realmSet$fecha_fin(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_finIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_finIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_finIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_finIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$enviada() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.enviadaIndex);
    }

    @Override
    public void realmSet$enviada(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.enviadaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.enviadaIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Routes", 9, 0);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("salida", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("autorizador_inicio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("autorizado_fin", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_autorizador_inicio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_inicio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_fin", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("enviada", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RoutesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RoutesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Routes";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Routes";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Routes createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Routes obj = null;
        if (update) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
            RoutesColumnInfo columnInfo = (RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
            long pkColumnIndex = columnInfo.rutaIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("ruta")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("ruta"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("ruta")) {
                if (json.isNull("ruta")) {
                    obj = (io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.Routes.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.Routes.class, json.getInt("ruta"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ruta'.");
            }
        }

        final com_mds_ventasabpollo_models_RoutesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) obj;
        if (json.has("salida")) {
            if (json.isNull("salida")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
            } else {
                objProxy.realmSet$salida((int) json.getInt("salida"));
            }
        }
        if (json.has("autorizador_inicio")) {
            if (json.isNull("autorizador_inicio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'autorizador_inicio' to null.");
            } else {
                objProxy.realmSet$autorizador_inicio((int) json.getInt("autorizador_inicio"));
            }
        }
        if (json.has("autorizado_fin")) {
            if (json.isNull("autorizado_fin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'autorizado_fin' to null.");
            } else {
                objProxy.realmSet$autorizado_fin((int) json.getInt("autorizado_fin"));
            }
        }
        if (json.has("nombre_autorizador_inicio")) {
            if (json.isNull("nombre_autorizador_inicio")) {
                objProxy.realmSet$nombre_autorizador_inicio(null);
            } else {
                objProxy.realmSet$nombre_autorizador_inicio((String) json.getString("nombre_autorizador_inicio"));
            }
        }
        if (json.has("fecha_inicio")) {
            if (json.isNull("fecha_inicio")) {
                objProxy.realmSet$fecha_inicio(null);
            } else {
                objProxy.realmSet$fecha_inicio((String) json.getString("fecha_inicio"));
            }
        }
        if (json.has("fecha_fin")) {
            if (json.isNull("fecha_fin")) {
                objProxy.realmSet$fecha_fin(null);
            } else {
                objProxy.realmSet$fecha_fin((String) json.getString("fecha_fin"));
            }
        }
        if (json.has("enviada")) {
            if (json.isNull("enviada")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'enviada' to null.");
            } else {
                objProxy.realmSet$enviada((boolean) json.getBoolean("enviada"));
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
    public static com.mds.ventasabpollo.models.Routes createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.mds.ventasabpollo.models.Routes obj = new com.mds.ventasabpollo.models.Routes();
        final com_mds_ventasabpollo_models_RoutesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("ruta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ruta((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("salida")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$salida((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
                }
            } else if (name.equals("autorizador_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autorizador_inicio((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'autorizador_inicio' to null.");
                }
            } else if (name.equals("autorizado_fin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autorizado_fin((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'autorizado_fin' to null.");
                }
            } else if (name.equals("nombre_autorizador_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_autorizador_inicio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_autorizador_inicio(null);
                }
            } else if (name.equals("fecha_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_inicio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_inicio(null);
                }
            } else if (name.equals("fecha_fin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_fin((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_fin(null);
                }
            } else if (name.equals("enviada")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$enviada((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'enviada' to null.");
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
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ruta'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_RoutesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Routes copyOrUpdate(Realm realm, RoutesColumnInfo columnInfo, com.mds.ventasabpollo.models.Routes object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Routes) cachedRealmObject;
        }

        com.mds.ventasabpollo.models.Routes realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
            long pkColumnIndex = columnInfo.rutaIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Routes copy(Realm realm, RoutesColumnInfo columnInfo, com.mds.ventasabpollo.models.Routes newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Routes) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_RoutesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.salidaIndex, realmObjectSource.realmGet$salida());
        builder.addInteger(columnInfo.autorizador_inicioIndex, realmObjectSource.realmGet$autorizador_inicio());
        builder.addInteger(columnInfo.autorizado_finIndex, realmObjectSource.realmGet$autorizado_fin());
        builder.addString(columnInfo.nombre_autorizador_inicioIndex, realmObjectSource.realmGet$nombre_autorizador_inicio());
        builder.addString(columnInfo.fecha_inicioIndex, realmObjectSource.realmGet$fecha_inicio());
        builder.addString(columnInfo.fecha_finIndex, realmObjectSource.realmGet$fecha_fin());
        builder.addBoolean(columnInfo.enviadaIndex, realmObjectSource.realmGet$enviada());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_RoutesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Routes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        long tableNativePtr = table.getNativePtr();
        RoutesColumnInfo columnInfo = (RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
        long pkColumnIndex = columnInfo.rutaIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizador_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizador_inicio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizado_finIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizado_fin(), false);
        String realmGet$nombre_autorizador_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$nombre_autorizador_inicio();
        if (realmGet$nombre_autorizador_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, realmGet$nombre_autorizador_inicio, false);
        }
        String realmGet$fecha_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_inicio();
        if (realmGet$fecha_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, realmGet$fecha_inicio, false);
        }
        String realmGet$fecha_fin = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_fin();
        if (realmGet$fecha_fin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, realmGet$fecha_fin, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        long tableNativePtr = table.getNativePtr();
        RoutesColumnInfo columnInfo = (RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
        long pkColumnIndex = columnInfo.rutaIndex;
        com.mds.ventasabpollo.models.Routes object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Routes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizador_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizador_inicio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizado_finIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizado_fin(), false);
            String realmGet$nombre_autorizador_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$nombre_autorizador_inicio();
            if (realmGet$nombre_autorizador_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, realmGet$nombre_autorizador_inicio, false);
            }
            String realmGet$fecha_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_inicio();
            if (realmGet$fecha_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, realmGet$fecha_inicio, false);
            }
            String realmGet$fecha_fin = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_fin();
            if (realmGet$fecha_fin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, realmGet$fecha_fin, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Routes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        long tableNativePtr = table.getNativePtr();
        RoutesColumnInfo columnInfo = (RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
        long pkColumnIndex = columnInfo.rutaIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$salida(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizador_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizador_inicio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizado_finIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizado_fin(), false);
        String realmGet$nombre_autorizador_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$nombre_autorizador_inicio();
        if (realmGet$nombre_autorizador_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, realmGet$nombre_autorizador_inicio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, false);
        }
        String realmGet$fecha_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_inicio();
        if (realmGet$fecha_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, realmGet$fecha_inicio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, false);
        }
        String realmGet$fecha_fin = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_fin();
        if (realmGet$fecha_fin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, realmGet$fecha_fin, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        long tableNativePtr = table.getNativePtr();
        RoutesColumnInfo columnInfo = (RoutesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Routes.class);
        long pkColumnIndex = columnInfo.rutaIndex;
        com.mds.ventasabpollo.models.Routes object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Routes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$ruta());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$salida(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizador_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizador_inicio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizado_finIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$autorizado_fin(), false);
            String realmGet$nombre_autorizador_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$nombre_autorizador_inicio();
            if (realmGet$nombre_autorizador_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, realmGet$nombre_autorizador_inicio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_autorizador_inicioIndex, rowIndex, false);
            }
            String realmGet$fecha_inicio = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_inicio();
            if (realmGet$fecha_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, realmGet$fecha_inicio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_inicioIndex, rowIndex, false);
            }
            String realmGet$fecha_fin = ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$fecha_fin();
            if (realmGet$fecha_fin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, realmGet$fecha_fin, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_finIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_RoutesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.Routes createDetachedCopy(com.mds.ventasabpollo.models.Routes realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Routes unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Routes();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Routes) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Routes) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_RoutesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_RoutesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$salida(realmSource.realmGet$salida());
        unmanagedCopy.realmSet$autorizador_inicio(realmSource.realmGet$autorizador_inicio());
        unmanagedCopy.realmSet$autorizado_fin(realmSource.realmGet$autorizado_fin());
        unmanagedCopy.realmSet$nombre_autorizador_inicio(realmSource.realmGet$nombre_autorizador_inicio());
        unmanagedCopy.realmSet$fecha_inicio(realmSource.realmGet$fecha_inicio());
        unmanagedCopy.realmSet$fecha_fin(realmSource.realmGet$fecha_fin());
        unmanagedCopy.realmSet$enviada(realmSource.realmGet$enviada());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    static com.mds.ventasabpollo.models.Routes update(Realm realm, RoutesColumnInfo columnInfo, com.mds.ventasabpollo.models.Routes realmObject, com.mds.ventasabpollo.models.Routes newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_mds_ventasabpollo_models_RoutesRealmProxyInterface realmObjectTarget = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) realmObject;
        com_mds_ventasabpollo_models_RoutesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_RoutesRealmProxyInterface) newObject;
        Table table = realm.getTable(com.mds.ventasabpollo.models.Routes.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.salidaIndex, realmObjectSource.realmGet$salida());
        builder.addInteger(columnInfo.autorizador_inicioIndex, realmObjectSource.realmGet$autorizador_inicio());
        builder.addInteger(columnInfo.autorizado_finIndex, realmObjectSource.realmGet$autorizado_fin());
        builder.addString(columnInfo.nombre_autorizador_inicioIndex, realmObjectSource.realmGet$nombre_autorizador_inicio());
        builder.addString(columnInfo.fecha_inicioIndex, realmObjectSource.realmGet$fecha_inicio());
        builder.addString(columnInfo.fecha_finIndex, realmObjectSource.realmGet$fecha_fin());
        builder.addBoolean(columnInfo.enviadaIndex, realmObjectSource.realmGet$enviada());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Routes = proxy[");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{salida:");
        stringBuilder.append(realmGet$salida());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autorizador_inicio:");
        stringBuilder.append(realmGet$autorizador_inicio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autorizado_fin:");
        stringBuilder.append(realmGet$autorizado_fin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_autorizador_inicio:");
        stringBuilder.append(realmGet$nombre_autorizador_inicio() != null ? realmGet$nombre_autorizador_inicio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_inicio:");
        stringBuilder.append(realmGet$fecha_inicio() != null ? realmGet$fecha_inicio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_fin:");
        stringBuilder.append(realmGet$fecha_fin() != null ? realmGet$fecha_fin() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enviada:");
        stringBuilder.append(realmGet$enviada());
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
        com_mds_ventasabpollo_models_RoutesRealmProxy aRoutes = (com_mds_ventasabpollo_models_RoutesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRoutes.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRoutes.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRoutes.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
