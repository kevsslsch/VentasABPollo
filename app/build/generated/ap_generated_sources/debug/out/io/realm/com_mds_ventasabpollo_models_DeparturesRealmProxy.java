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
public class com_mds_ventasabpollo_models_DeparturesRealmProxy extends com.mds.ventasabpollo.models.Departures
    implements RealmObjectProxy, com_mds_ventasabpollo_models_DeparturesRealmProxyInterface {

    static final class DeparturesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long salidaIndex;
        long vendedorIndex;
        long registrado_porIndex;
        long autorizado_porIndex;
        long fecha_registroIndex;
        long listaIndex;
        long nombre_listaIndex;
        long estado_actualIndex;

        DeparturesColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Departures");
            this.salidaIndex = addColumnDetails("salida", "salida", objectSchemaInfo);
            this.vendedorIndex = addColumnDetails("vendedor", "vendedor", objectSchemaInfo);
            this.registrado_porIndex = addColumnDetails("registrado_por", "registrado_por", objectSchemaInfo);
            this.autorizado_porIndex = addColumnDetails("autorizado_por", "autorizado_por", objectSchemaInfo);
            this.fecha_registroIndex = addColumnDetails("fecha_registro", "fecha_registro", objectSchemaInfo);
            this.listaIndex = addColumnDetails("lista", "lista", objectSchemaInfo);
            this.nombre_listaIndex = addColumnDetails("nombre_lista", "nombre_lista", objectSchemaInfo);
            this.estado_actualIndex = addColumnDetails("estado_actual", "estado_actual", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        DeparturesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DeparturesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DeparturesColumnInfo src = (DeparturesColumnInfo) rawSrc;
            final DeparturesColumnInfo dst = (DeparturesColumnInfo) rawDst;
            dst.salidaIndex = src.salidaIndex;
            dst.vendedorIndex = src.vendedorIndex;
            dst.registrado_porIndex = src.registrado_porIndex;
            dst.autorizado_porIndex = src.autorizado_porIndex;
            dst.fecha_registroIndex = src.fecha_registroIndex;
            dst.listaIndex = src.listaIndex;
            dst.nombre_listaIndex = src.nombre_listaIndex;
            dst.estado_actualIndex = src.estado_actualIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DeparturesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Departures> proxyState;

    com_mds_ventasabpollo_models_DeparturesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DeparturesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Departures>(this);
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
    public String realmGet$vendedor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.vendedorIndex);
    }

    @Override
    public void realmSet$vendedor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.vendedorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.vendedorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.vendedorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.vendedorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$registrado_por() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.registrado_porIndex);
    }

    @Override
    public void realmSet$registrado_por(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.registrado_porIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.registrado_porIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.registrado_porIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.registrado_porIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$autorizado_por() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.autorizado_porIndex);
    }

    @Override
    public void realmSet$autorizado_por(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.autorizado_porIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.autorizado_porIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.autorizado_porIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.autorizado_porIndex, value);
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
    public String realmGet$estado_actual() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.estado_actualIndex);
    }

    @Override
    public void realmSet$estado_actual(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.estado_actualIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.estado_actualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.estado_actualIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.estado_actualIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Departures", 8, 0);
        builder.addPersistedProperty("salida", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("vendedor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("registrado_por", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("autorizado_por", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_registro", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lista", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_lista", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("estado_actual", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DeparturesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DeparturesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Departures";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Departures";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Departures createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Departures obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Departures.class, true, excludeFields);

        final com_mds_ventasabpollo_models_DeparturesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) obj;
        if (json.has("salida")) {
            if (json.isNull("salida")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'salida' to null.");
            } else {
                objProxy.realmSet$salida((int) json.getInt("salida"));
            }
        }
        if (json.has("vendedor")) {
            if (json.isNull("vendedor")) {
                objProxy.realmSet$vendedor(null);
            } else {
                objProxy.realmSet$vendedor((String) json.getString("vendedor"));
            }
        }
        if (json.has("registrado_por")) {
            if (json.isNull("registrado_por")) {
                objProxy.realmSet$registrado_por(null);
            } else {
                objProxy.realmSet$registrado_por((String) json.getString("registrado_por"));
            }
        }
        if (json.has("autorizado_por")) {
            if (json.isNull("autorizado_por")) {
                objProxy.realmSet$autorizado_por(null);
            } else {
                objProxy.realmSet$autorizado_por((String) json.getString("autorizado_por"));
            }
        }
        if (json.has("fecha_registro")) {
            if (json.isNull("fecha_registro")) {
                objProxy.realmSet$fecha_registro(null);
            } else {
                objProxy.realmSet$fecha_registro((String) json.getString("fecha_registro"));
            }
        }
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
        if (json.has("estado_actual")) {
            if (json.isNull("estado_actual")) {
                objProxy.realmSet$estado_actual(null);
            } else {
                objProxy.realmSet$estado_actual((String) json.getString("estado_actual"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Departures createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Departures obj = new com.mds.ventasabpollo.models.Departures();
        final com_mds_ventasabpollo_models_DeparturesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) obj;
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
            } else if (name.equals("vendedor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$vendedor((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$vendedor(null);
                }
            } else if (name.equals("registrado_por")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$registrado_por((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$registrado_por(null);
                }
            } else if (name.equals("autorizado_por")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autorizado_por((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$autorizado_por(null);
                }
            } else if (name.equals("fecha_registro")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_registro((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_registro(null);
                }
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
            } else if (name.equals("estado_actual")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$estado_actual((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$estado_actual(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_DeparturesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Departures copyOrUpdate(Realm realm, DeparturesColumnInfo columnInfo, com.mds.ventasabpollo.models.Departures object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Departures) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Departures copy(Realm realm, DeparturesColumnInfo columnInfo, com.mds.ventasabpollo.models.Departures newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Departures) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_DeparturesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Departures.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.salidaIndex, realmObjectSource.realmGet$salida());
        builder.addString(columnInfo.vendedorIndex, realmObjectSource.realmGet$vendedor());
        builder.addString(columnInfo.registrado_porIndex, realmObjectSource.realmGet$registrado_por());
        builder.addString(columnInfo.autorizado_porIndex, realmObjectSource.realmGet$autorizado_por());
        builder.addString(columnInfo.fecha_registroIndex, realmObjectSource.realmGet$fecha_registro());
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addString(columnInfo.nombre_listaIndex, realmObjectSource.realmGet$nombre_lista());
        builder.addString(columnInfo.estado_actualIndex, realmObjectSource.realmGet$estado_actual());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_DeparturesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Departures object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Departures.class);
        long tableNativePtr = table.getNativePtr();
        DeparturesColumnInfo columnInfo = (DeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$salida(), false);
        String realmGet$vendedor = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$vendedor();
        if (realmGet$vendedor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vendedorIndex, rowIndex, realmGet$vendedor, false);
        }
        String realmGet$registrado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$registrado_por();
        if (realmGet$registrado_por != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, realmGet$registrado_por, false);
        }
        String realmGet$autorizado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$autorizado_por();
        if (realmGet$autorizado_por != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, realmGet$autorizado_por, false);
        }
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$lista(), false);
        String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$nombre_lista();
        if (realmGet$nombre_lista != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
        }
        String realmGet$estado_actual = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$estado_actual();
        if (realmGet$estado_actual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, realmGet$estado_actual, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Departures.class);
        long tableNativePtr = table.getNativePtr();
        DeparturesColumnInfo columnInfo = (DeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class);
        com.mds.ventasabpollo.models.Departures object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Departures) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$salida(), false);
            String realmGet$vendedor = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$vendedor();
            if (realmGet$vendedor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vendedorIndex, rowIndex, realmGet$vendedor, false);
            }
            String realmGet$registrado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$registrado_por();
            if (realmGet$registrado_por != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, realmGet$registrado_por, false);
            }
            String realmGet$autorizado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$autorizado_por();
            if (realmGet$autorizado_por != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, realmGet$autorizado_por, false);
            }
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$lista(), false);
            String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$nombre_lista();
            if (realmGet$nombre_lista != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
            }
            String realmGet$estado_actual = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$estado_actual();
            if (realmGet$estado_actual != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, realmGet$estado_actual, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Departures object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Departures.class);
        long tableNativePtr = table.getNativePtr();
        DeparturesColumnInfo columnInfo = (DeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$salida(), false);
        String realmGet$vendedor = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$vendedor();
        if (realmGet$vendedor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.vendedorIndex, rowIndex, realmGet$vendedor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.vendedorIndex, rowIndex, false);
        }
        String realmGet$registrado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$registrado_por();
        if (realmGet$registrado_por != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, realmGet$registrado_por, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, false);
        }
        String realmGet$autorizado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$autorizado_por();
        if (realmGet$autorizado_por != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, realmGet$autorizado_por, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, false);
        }
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$lista(), false);
        String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$nombre_lista();
        if (realmGet$nombre_lista != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, false);
        }
        String realmGet$estado_actual = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$estado_actual();
        if (realmGet$estado_actual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, realmGet$estado_actual, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Departures.class);
        long tableNativePtr = table.getNativePtr();
        DeparturesColumnInfo columnInfo = (DeparturesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Departures.class);
        com.mds.ventasabpollo.models.Departures object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Departures) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.salidaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$salida(), false);
            String realmGet$vendedor = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$vendedor();
            if (realmGet$vendedor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.vendedorIndex, rowIndex, realmGet$vendedor, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.vendedorIndex, rowIndex, false);
            }
            String realmGet$registrado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$registrado_por();
            if (realmGet$registrado_por != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, realmGet$registrado_por, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.registrado_porIndex, rowIndex, false);
            }
            String realmGet$autorizado_por = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$autorizado_por();
            if (realmGet$autorizado_por != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, realmGet$autorizado_por, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.autorizado_porIndex, rowIndex, false);
            }
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$lista(), false);
            String realmGet$nombre_lista = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$nombre_lista();
            if (realmGet$nombre_lista != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, realmGet$nombre_lista, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_listaIndex, rowIndex, false);
            }
            String realmGet$estado_actual = ((com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) object).realmGet$estado_actual();
            if (realmGet$estado_actual != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, realmGet$estado_actual, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.estado_actualIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.Departures createDetachedCopy(com.mds.ventasabpollo.models.Departures realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Departures unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Departures();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Departures) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Departures) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_DeparturesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_DeparturesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_DeparturesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$salida(realmSource.realmGet$salida());
        unmanagedCopy.realmSet$vendedor(realmSource.realmGet$vendedor());
        unmanagedCopy.realmSet$registrado_por(realmSource.realmGet$registrado_por());
        unmanagedCopy.realmSet$autorizado_por(realmSource.realmGet$autorizado_por());
        unmanagedCopy.realmSet$fecha_registro(realmSource.realmGet$fecha_registro());
        unmanagedCopy.realmSet$lista(realmSource.realmGet$lista());
        unmanagedCopy.realmSet$nombre_lista(realmSource.realmGet$nombre_lista());
        unmanagedCopy.realmSet$estado_actual(realmSource.realmGet$estado_actual());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Departures = proxy[");
        stringBuilder.append("{salida:");
        stringBuilder.append(realmGet$salida());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vendedor:");
        stringBuilder.append(realmGet$vendedor() != null ? realmGet$vendedor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{registrado_por:");
        stringBuilder.append(realmGet$registrado_por() != null ? realmGet$registrado_por() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autorizado_por:");
        stringBuilder.append(realmGet$autorizado_por() != null ? realmGet$autorizado_por() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_registro:");
        stringBuilder.append(realmGet$fecha_registro() != null ? realmGet$fecha_registro() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lista:");
        stringBuilder.append(realmGet$lista());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_lista:");
        stringBuilder.append(realmGet$nombre_lista() != null ? realmGet$nombre_lista() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{estado_actual:");
        stringBuilder.append(realmGet$estado_actual() != null ? realmGet$estado_actual() : "null");
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
        com_mds_ventasabpollo_models_DeparturesRealmProxy aDepartures = (com_mds_ventasabpollo_models_DeparturesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDepartures.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDepartures.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDepartures.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
