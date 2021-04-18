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
public class com_mds_ventasabpollo_models_VisitsMovementsRealmProxy extends com.mds.ventasabpollo.models.VisitsMovements
    implements RealmObjectProxy, com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface {

    static final class VisitsMovementsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long rutaIndex;
        long visitaIndex;
        long clave_articuloIndex;
        long piezas_devolucionIndex;
        long piezas_cambioIndex;
        long piezas_apartadoIndex;
        long fecha_apartadoIndex;
        long enviadaIndex;
        long user_idIndex;

        VisitsMovementsColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("VisitsMovements");
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.visitaIndex = addColumnDetails("visita", "visita", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.piezas_devolucionIndex = addColumnDetails("piezas_devolucion", "piezas_devolucion", objectSchemaInfo);
            this.piezas_cambioIndex = addColumnDetails("piezas_cambio", "piezas_cambio", objectSchemaInfo);
            this.piezas_apartadoIndex = addColumnDetails("piezas_apartado", "piezas_apartado", objectSchemaInfo);
            this.fecha_apartadoIndex = addColumnDetails("fecha_apartado", "fecha_apartado", objectSchemaInfo);
            this.enviadaIndex = addColumnDetails("enviada", "enviada", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        VisitsMovementsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new VisitsMovementsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final VisitsMovementsColumnInfo src = (VisitsMovementsColumnInfo) rawSrc;
            final VisitsMovementsColumnInfo dst = (VisitsMovementsColumnInfo) rawDst;
            dst.rutaIndex = src.rutaIndex;
            dst.visitaIndex = src.visitaIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.piezas_devolucionIndex = src.piezas_devolucionIndex;
            dst.piezas_cambioIndex = src.piezas_cambioIndex;
            dst.piezas_apartadoIndex = src.piezas_apartadoIndex;
            dst.fecha_apartadoIndex = src.fecha_apartadoIndex;
            dst.enviadaIndex = src.enviadaIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private VisitsMovementsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.VisitsMovements> proxyState;

    com_mds_ventasabpollo_models_VisitsMovementsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VisitsMovementsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.VisitsMovements>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rutaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rutaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$visita() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.visitaIndex);
    }

    @Override
    public void realmSet$visita(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.visitaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.visitaIndex, value);
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
    public double realmGet$piezas_devolucion() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.piezas_devolucionIndex);
    }

    @Override
    public void realmSet$piezas_devolucion(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.piezas_devolucionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.piezas_devolucionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$piezas_cambio() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.piezas_cambioIndex);
    }

    @Override
    public void realmSet$piezas_cambio(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.piezas_cambioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.piezas_cambioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$piezas_apartado() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.piezas_apartadoIndex);
    }

    @Override
    public void realmSet$piezas_apartado(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.piezas_apartadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.piezas_apartadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_apartado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_apartadoIndex);
    }

    @Override
    public void realmSet$fecha_apartado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_apartadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_apartadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_apartadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_apartadoIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("VisitsMovements", 9, 0);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("piezas_devolucion", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("piezas_cambio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("piezas_apartado", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha_apartado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("enviada", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static VisitsMovementsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new VisitsMovementsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "VisitsMovements";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "VisitsMovements";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.VisitsMovements createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.VisitsMovements obj = realm.createObjectInternal(com.mds.ventasabpollo.models.VisitsMovements.class, true, excludeFields);

        final com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) obj;
        if (json.has("ruta")) {
            if (json.isNull("ruta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
            } else {
                objProxy.realmSet$ruta((int) json.getInt("ruta"));
            }
        }
        if (json.has("visita")) {
            if (json.isNull("visita")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
            } else {
                objProxy.realmSet$visita((int) json.getInt("visita"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("piezas_devolucion")) {
            if (json.isNull("piezas_devolucion")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_devolucion' to null.");
            } else {
                objProxy.realmSet$piezas_devolucion((double) json.getDouble("piezas_devolucion"));
            }
        }
        if (json.has("piezas_cambio")) {
            if (json.isNull("piezas_cambio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_cambio' to null.");
            } else {
                objProxy.realmSet$piezas_cambio((double) json.getDouble("piezas_cambio"));
            }
        }
        if (json.has("piezas_apartado")) {
            if (json.isNull("piezas_apartado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_apartado' to null.");
            } else {
                objProxy.realmSet$piezas_apartado((double) json.getDouble("piezas_apartado"));
            }
        }
        if (json.has("fecha_apartado")) {
            if (json.isNull("fecha_apartado")) {
                objProxy.realmSet$fecha_apartado(null);
            } else {
                objProxy.realmSet$fecha_apartado((String) json.getString("fecha_apartado"));
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
    public static com.mds.ventasabpollo.models.VisitsMovements createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.VisitsMovements obj = new com.mds.ventasabpollo.models.VisitsMovements();
        final com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) obj;
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
            } else if (name.equals("visita")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$visita((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
                }
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("piezas_devolucion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$piezas_devolucion((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_devolucion' to null.");
                }
            } else if (name.equals("piezas_cambio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$piezas_cambio((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_cambio' to null.");
                }
            } else if (name.equals("piezas_apartado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$piezas_apartado((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'piezas_apartado' to null.");
                }
            } else if (name.equals("fecha_apartado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_apartado((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_apartado(null);
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
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_VisitsMovementsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.VisitsMovements copyOrUpdate(Realm realm, VisitsMovementsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsMovements object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.VisitsMovements) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.VisitsMovements copy(Realm realm, VisitsMovementsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsMovements newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.VisitsMovements) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsMovements.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.visitaIndex, realmObjectSource.realmGet$visita());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.piezas_devolucionIndex, realmObjectSource.realmGet$piezas_devolucion());
        builder.addDouble(columnInfo.piezas_cambioIndex, realmObjectSource.realmGet$piezas_cambio());
        builder.addDouble(columnInfo.piezas_apartadoIndex, realmObjectSource.realmGet$piezas_apartado());
        builder.addString(columnInfo.fecha_apartadoIndex, realmObjectSource.realmGet$fecha_apartado());
        builder.addBoolean(columnInfo.enviadaIndex, realmObjectSource.realmGet$enviada());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_VisitsMovementsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.VisitsMovements object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsMovements.class);
        long tableNativePtr = table.getNativePtr();
        VisitsMovementsColumnInfo columnInfo = (VisitsMovementsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_devolucionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_devolucion(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_cambio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_apartadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_apartado(), false);
        String realmGet$fecha_apartado = ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$fecha_apartado();
        if (realmGet$fecha_apartado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, realmGet$fecha_apartado, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsMovements.class);
        long tableNativePtr = table.getNativePtr();
        VisitsMovementsColumnInfo columnInfo = (VisitsMovementsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class);
        com.mds.ventasabpollo.models.VisitsMovements object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsMovements) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_devolucionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_devolucion(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_cambio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_apartadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_apartado(), false);
            String realmGet$fecha_apartado = ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$fecha_apartado();
            if (realmGet$fecha_apartado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, realmGet$fecha_apartado, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.VisitsMovements object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsMovements.class);
        long tableNativePtr = table.getNativePtr();
        VisitsMovementsColumnInfo columnInfo = (VisitsMovementsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_devolucionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_devolucion(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_cambio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_apartadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_apartado(), false);
        String realmGet$fecha_apartado = ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$fecha_apartado();
        if (realmGet$fecha_apartado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, realmGet$fecha_apartado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsMovements.class);
        long tableNativePtr = table.getNativePtr();
        VisitsMovementsColumnInfo columnInfo = (VisitsMovementsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsMovements.class);
        com.mds.ventasabpollo.models.VisitsMovements object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsMovements) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_devolucionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_devolucion(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_cambio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.piezas_apartadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$piezas_apartado(), false);
            String realmGet$fecha_apartado = ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$fecha_apartado();
            if (realmGet$fecha_apartado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, realmGet$fecha_apartado, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_apartadoIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.VisitsMovements createDetachedCopy(com.mds.ventasabpollo.models.VisitsMovements realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.VisitsMovements unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.VisitsMovements();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.VisitsMovements) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.VisitsMovements) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$visita(realmSource.realmGet$visita());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$piezas_devolucion(realmSource.realmGet$piezas_devolucion());
        unmanagedCopy.realmSet$piezas_cambio(realmSource.realmGet$piezas_cambio());
        unmanagedCopy.realmSet$piezas_apartado(realmSource.realmGet$piezas_apartado());
        unmanagedCopy.realmSet$fecha_apartado(realmSource.realmGet$fecha_apartado());
        unmanagedCopy.realmSet$enviada(realmSource.realmGet$enviada());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("VisitsMovements = proxy[");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{visita:");
        stringBuilder.append(realmGet$visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{piezas_devolucion:");
        stringBuilder.append(realmGet$piezas_devolucion());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{piezas_cambio:");
        stringBuilder.append(realmGet$piezas_cambio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{piezas_apartado:");
        stringBuilder.append(realmGet$piezas_apartado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_apartado:");
        stringBuilder.append(realmGet$fecha_apartado() != null ? realmGet$fecha_apartado() : "null");
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
        com_mds_ventasabpollo_models_VisitsMovementsRealmProxy aVisitsMovements = (com_mds_ventasabpollo_models_VisitsMovementsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVisitsMovements.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVisitsMovements.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVisitsMovements.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
