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
public class com_mds_ventasabpollo_models_ChangesPricesRealmProxy extends com.mds.ventasabpollo.models.ChangesPrices
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface {

    static final class ChangesPricesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long cambioIndex;
        long visitaIndex;
        long autorizacionIndex;
        long clienteIndex;
        long clave_articuloIndex;
        long cantidadIndex;
        long precio_originalIndex;
        long precio_pactadoIndex;

        ChangesPricesColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ChangesPrices");
            this.cambioIndex = addColumnDetails("cambio", "cambio", objectSchemaInfo);
            this.visitaIndex = addColumnDetails("visita", "visita", objectSchemaInfo);
            this.autorizacionIndex = addColumnDetails("autorizacion", "autorizacion", objectSchemaInfo);
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.cantidadIndex = addColumnDetails("cantidad", "cantidad", objectSchemaInfo);
            this.precio_originalIndex = addColumnDetails("precio_original", "precio_original", objectSchemaInfo);
            this.precio_pactadoIndex = addColumnDetails("precio_pactado", "precio_pactado", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ChangesPricesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChangesPricesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChangesPricesColumnInfo src = (ChangesPricesColumnInfo) rawSrc;
            final ChangesPricesColumnInfo dst = (ChangesPricesColumnInfo) rawDst;
            dst.cambioIndex = src.cambioIndex;
            dst.visitaIndex = src.visitaIndex;
            dst.autorizacionIndex = src.autorizacionIndex;
            dst.clienteIndex = src.clienteIndex;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.precio_originalIndex = src.precio_originalIndex;
            dst.precio_pactadoIndex = src.precio_pactadoIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChangesPricesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.ChangesPrices> proxyState;

    com_mds_ventasabpollo_models_ChangesPricesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChangesPricesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.ChangesPrices>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$cambio() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cambioIndex);
    }

    @Override
    public void realmSet$cambio(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cambioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cambioIndex, value);
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
    public int realmGet$autorizacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.autorizacionIndex);
    }

    @Override
    public void realmSet$autorizacion(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.autorizacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.autorizacionIndex, value);
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
    public double realmGet$cantidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.cantidadIndex);
    }

    @Override
    public void realmSet$cantidad(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.cantidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.cantidadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$precio_original() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precio_originalIndex);
    }

    @Override
    public void realmSet$precio_original(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precio_originalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precio_originalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$precio_pactado() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precio_pactadoIndex);
    }

    @Override
    public void realmSet$precio_pactado(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precio_pactadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precio_pactadoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ChangesPrices", 8, 0);
        builder.addPersistedProperty("cambio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("autorizacion", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cantidad", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio_original", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("precio_pactado", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChangesPricesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChangesPricesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ChangesPrices";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ChangesPrices";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.ChangesPrices createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.ChangesPrices obj = realm.createObjectInternal(com.mds.ventasabpollo.models.ChangesPrices.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) obj;
        if (json.has("cambio")) {
            if (json.isNull("cambio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cambio' to null.");
            } else {
                objProxy.realmSet$cambio((int) json.getInt("cambio"));
            }
        }
        if (json.has("visita")) {
            if (json.isNull("visita")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
            } else {
                objProxy.realmSet$visita((int) json.getInt("visita"));
            }
        }
        if (json.has("autorizacion")) {
            if (json.isNull("autorizacion")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'autorizacion' to null.");
            } else {
                objProxy.realmSet$autorizacion((int) json.getInt("autorizacion"));
            }
        }
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
            } else {
                objProxy.realmSet$cantidad((double) json.getDouble("cantidad"));
            }
        }
        if (json.has("precio_original")) {
            if (json.isNull("precio_original")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio_original' to null.");
            } else {
                objProxy.realmSet$precio_original((double) json.getDouble("precio_original"));
            }
        }
        if (json.has("precio_pactado")) {
            if (json.isNull("precio_pactado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precio_pactado' to null.");
            } else {
                objProxy.realmSet$precio_pactado((double) json.getDouble("precio_pactado"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.ChangesPrices createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.ChangesPrices obj = new com.mds.ventasabpollo.models.ChangesPrices();
        final com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("cambio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cambio((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cambio' to null.");
                }
            } else if (name.equals("visita")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$visita((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'visita' to null.");
                }
            } else if (name.equals("autorizacion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autorizacion((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'autorizacion' to null.");
                }
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cantidad((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
                }
            } else if (name.equals("precio_original")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio_original((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio_original' to null.");
                }
            } else if (name.equals("precio_pactado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$precio_pactado((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precio_pactado' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_ChangesPricesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.ChangesPrices copyOrUpdate(Realm realm, ChangesPricesColumnInfo columnInfo, com.mds.ventasabpollo.models.ChangesPrices object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.ChangesPrices) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.ChangesPrices copy(Realm realm, ChangesPricesColumnInfo columnInfo, com.mds.ventasabpollo.models.ChangesPrices newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.ChangesPrices) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesPrices.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.cambioIndex, realmObjectSource.realmGet$cambio());
        builder.addInteger(columnInfo.visitaIndex, realmObjectSource.realmGet$visita());
        builder.addInteger(columnInfo.autorizacionIndex, realmObjectSource.realmGet$autorizacion());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addDouble(columnInfo.cantidadIndex, realmObjectSource.realmGet$cantidad());
        builder.addDouble(columnInfo.precio_originalIndex, realmObjectSource.realmGet$precio_original());
        builder.addDouble(columnInfo.precio_pactadoIndex, realmObjectSource.realmGet$precio_pactado());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ChangesPricesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.ChangesPrices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesPrices.class);
        long tableNativePtr = table.getNativePtr();
        ChangesPricesColumnInfo columnInfo = (ChangesPricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cambio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizacionIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$autorizacion(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cantidad(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_originalIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_original(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_pactadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_pactado(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesPrices.class);
        long tableNativePtr = table.getNativePtr();
        ChangesPricesColumnInfo columnInfo = (ChangesPricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class);
        com.mds.ventasabpollo.models.ChangesPrices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ChangesPrices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cambio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizacionIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$autorizacion(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cantidad(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_originalIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_original(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_pactadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_pactado(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.ChangesPrices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesPrices.class);
        long tableNativePtr = table.getNativePtr();
        ChangesPricesColumnInfo columnInfo = (ChangesPricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cambio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.autorizacionIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$autorizacion(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cantidad(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_originalIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_original(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.precio_pactadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_pactado(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.ChangesPrices.class);
        long tableNativePtr = table.getNativePtr();
        ChangesPricesColumnInfo columnInfo = (ChangesPricesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.ChangesPrices.class);
        com.mds.ventasabpollo.models.ChangesPrices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.ChangesPrices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.cambioIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cambio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.autorizacionIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$autorizacion(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$cantidad(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_originalIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_original(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.precio_pactadoIndex, rowIndex, ((com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) object).realmGet$precio_pactado(), false);
        }
    }

    public static com.mds.ventasabpollo.models.ChangesPrices createDetachedCopy(com.mds.ventasabpollo.models.ChangesPrices realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.ChangesPrices unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.ChangesPrices();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.ChangesPrices) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.ChangesPrices) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ChangesPricesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$cambio(realmSource.realmGet$cambio());
        unmanagedCopy.realmSet$visita(realmSource.realmGet$visita());
        unmanagedCopy.realmSet$autorizacion(realmSource.realmGet$autorizacion());
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$cantidad(realmSource.realmGet$cantidad());
        unmanagedCopy.realmSet$precio_original(realmSource.realmGet$precio_original());
        unmanagedCopy.realmSet$precio_pactado(realmSource.realmGet$precio_pactado());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChangesPrices = proxy[");
        stringBuilder.append("{cambio:");
        stringBuilder.append(realmGet$cambio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{visita:");
        stringBuilder.append(realmGet$visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autorizacion:");
        stringBuilder.append(realmGet$autorizacion());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio_original:");
        stringBuilder.append(realmGet$precio_original());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precio_pactado:");
        stringBuilder.append(realmGet$precio_pactado());
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
        com_mds_ventasabpollo_models_ChangesPricesRealmProxy aChangesPrices = (com_mds_ventasabpollo_models_ChangesPricesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aChangesPrices.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChangesPrices.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aChangesPrices.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
