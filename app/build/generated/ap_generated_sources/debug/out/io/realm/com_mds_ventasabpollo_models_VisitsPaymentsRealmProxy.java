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
public class com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy extends com.mds.ventasabpollo.models.VisitsPayments
    implements RealmObjectProxy, com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface {

    static final class VisitsPaymentsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long pagoIndex;
        long rutaIndex;
        long visitaIndex;
        long clienteIndex;
        long importeIndex;
        long importe_pagoIndex;
        long importe_saldadoIndex;
        long ultimos_4_tarjetaIndex;
        long metodo_pagoIndex;
        long fechaIndex;
        long fecha_cobradoIndex;
        long enviadoIndex;
        long cobradoIndex;
        long descargadoIndex;
        long user_idIndex;

        VisitsPaymentsColumnInfo(OsSchemaInfo schemaInfo) {
            super(15);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("VisitsPayments");
            this.pagoIndex = addColumnDetails("pago", "pago", objectSchemaInfo);
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.visitaIndex = addColumnDetails("visita", "visita", objectSchemaInfo);
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.importeIndex = addColumnDetails("importe", "importe", objectSchemaInfo);
            this.importe_pagoIndex = addColumnDetails("importe_pago", "importe_pago", objectSchemaInfo);
            this.importe_saldadoIndex = addColumnDetails("importe_saldado", "importe_saldado", objectSchemaInfo);
            this.ultimos_4_tarjetaIndex = addColumnDetails("ultimos_4_tarjeta", "ultimos_4_tarjeta", objectSchemaInfo);
            this.metodo_pagoIndex = addColumnDetails("metodo_pago", "metodo_pago", objectSchemaInfo);
            this.fechaIndex = addColumnDetails("fecha", "fecha", objectSchemaInfo);
            this.fecha_cobradoIndex = addColumnDetails("fecha_cobrado", "fecha_cobrado", objectSchemaInfo);
            this.enviadoIndex = addColumnDetails("enviado", "enviado", objectSchemaInfo);
            this.cobradoIndex = addColumnDetails("cobrado", "cobrado", objectSchemaInfo);
            this.descargadoIndex = addColumnDetails("descargado", "descargado", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        VisitsPaymentsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new VisitsPaymentsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final VisitsPaymentsColumnInfo src = (VisitsPaymentsColumnInfo) rawSrc;
            final VisitsPaymentsColumnInfo dst = (VisitsPaymentsColumnInfo) rawDst;
            dst.pagoIndex = src.pagoIndex;
            dst.rutaIndex = src.rutaIndex;
            dst.visitaIndex = src.visitaIndex;
            dst.clienteIndex = src.clienteIndex;
            dst.importeIndex = src.importeIndex;
            dst.importe_pagoIndex = src.importe_pagoIndex;
            dst.importe_saldadoIndex = src.importe_saldadoIndex;
            dst.ultimos_4_tarjetaIndex = src.ultimos_4_tarjetaIndex;
            dst.metodo_pagoIndex = src.metodo_pagoIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.fecha_cobradoIndex = src.fecha_cobradoIndex;
            dst.enviadoIndex = src.enviadoIndex;
            dst.cobradoIndex = src.cobradoIndex;
            dst.descargadoIndex = src.descargadoIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private VisitsPaymentsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.VisitsPayments> proxyState;

    com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VisitsPaymentsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.VisitsPayments>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$pago() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.pagoIndex);
    }

    @Override
    public void realmSet$pago(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.pagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.pagoIndex, value);
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
    public double realmGet$importe() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.importeIndex);
    }

    @Override
    public void realmSet$importe(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.importeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.importeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$importe_pago() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.importe_pagoIndex);
    }

    @Override
    public void realmSet$importe_pago(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.importe_pagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.importe_pagoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$importe_saldado() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.importe_saldadoIndex);
    }

    @Override
    public void realmSet$importe_saldado(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.importe_saldadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.importe_saldadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ultimos_4_tarjeta() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ultimos_4_tarjetaIndex);
    }

    @Override
    public void realmSet$ultimos_4_tarjeta(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ultimos_4_tarjetaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ultimos_4_tarjetaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$metodo_pago() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metodo_pagoIndex);
    }

    @Override
    public void realmSet$metodo_pago(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metodo_pagoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metodo_pagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metodo_pagoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metodo_pagoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaIndex);
    }

    @Override
    public void realmSet$fecha(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_cobrado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_cobradoIndex);
    }

    @Override
    public void realmSet$fecha_cobrado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_cobradoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_cobradoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_cobradoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_cobradoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$enviado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.enviadoIndex);
    }

    @Override
    public void realmSet$enviado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.enviadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.enviadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$cobrado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.cobradoIndex);
    }

    @Override
    public void realmSet$cobrado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.cobradoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.cobradoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$descargado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.descargadoIndex);
    }

    @Override
    public void realmSet$descargado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.descargadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.descargadoIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("VisitsPayments", 15, 0);
        builder.addPersistedProperty("pago", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("importe", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("importe_pago", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("importe_saldado", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ultimos_4_tarjeta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("metodo_pago", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_cobrado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("enviado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cobrado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("descargado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static VisitsPaymentsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new VisitsPaymentsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "VisitsPayments";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "VisitsPayments";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.VisitsPayments createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.VisitsPayments obj = realm.createObjectInternal(com.mds.ventasabpollo.models.VisitsPayments.class, true, excludeFields);

        final com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) obj;
        if (json.has("pago")) {
            if (json.isNull("pago")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'pago' to null.");
            } else {
                objProxy.realmSet$pago((int) json.getInt("pago"));
            }
        }
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
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("importe")) {
            if (json.isNull("importe")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
            } else {
                objProxy.realmSet$importe((double) json.getDouble("importe"));
            }
        }
        if (json.has("importe_pago")) {
            if (json.isNull("importe_pago")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'importe_pago' to null.");
            } else {
                objProxy.realmSet$importe_pago((double) json.getDouble("importe_pago"));
            }
        }
        if (json.has("importe_saldado")) {
            if (json.isNull("importe_saldado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'importe_saldado' to null.");
            } else {
                objProxy.realmSet$importe_saldado((double) json.getDouble("importe_saldado"));
            }
        }
        if (json.has("ultimos_4_tarjeta")) {
            if (json.isNull("ultimos_4_tarjeta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ultimos_4_tarjeta' to null.");
            } else {
                objProxy.realmSet$ultimos_4_tarjeta((int) json.getInt("ultimos_4_tarjeta"));
            }
        }
        if (json.has("metodo_pago")) {
            if (json.isNull("metodo_pago")) {
                objProxy.realmSet$metodo_pago(null);
            } else {
                objProxy.realmSet$metodo_pago((String) json.getString("metodo_pago"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                objProxy.realmSet$fecha(null);
            } else {
                objProxy.realmSet$fecha((String) json.getString("fecha"));
            }
        }
        if (json.has("fecha_cobrado")) {
            if (json.isNull("fecha_cobrado")) {
                objProxy.realmSet$fecha_cobrado(null);
            } else {
                objProxy.realmSet$fecha_cobrado((String) json.getString("fecha_cobrado"));
            }
        }
        if (json.has("enviado")) {
            if (json.isNull("enviado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
            } else {
                objProxy.realmSet$enviado((boolean) json.getBoolean("enviado"));
            }
        }
        if (json.has("cobrado")) {
            if (json.isNull("cobrado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cobrado' to null.");
            } else {
                objProxy.realmSet$cobrado((boolean) json.getBoolean("cobrado"));
            }
        }
        if (json.has("descargado")) {
            if (json.isNull("descargado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'descargado' to null.");
            } else {
                objProxy.realmSet$descargado((boolean) json.getBoolean("descargado"));
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
    public static com.mds.ventasabpollo.models.VisitsPayments createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.VisitsPayments obj = new com.mds.ventasabpollo.models.VisitsPayments();
        final com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("pago")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pago((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'pago' to null.");
                }
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
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("importe")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$importe((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'importe' to null.");
                }
            } else if (name.equals("importe_pago")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$importe_pago((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'importe_pago' to null.");
                }
            } else if (name.equals("importe_saldado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$importe_saldado((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'importe_saldado' to null.");
                }
            } else if (name.equals("ultimos_4_tarjeta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ultimos_4_tarjeta((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ultimos_4_tarjeta' to null.");
                }
            } else if (name.equals("metodo_pago")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metodo_pago((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metodo_pago(null);
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha(null);
                }
            } else if (name.equals("fecha_cobrado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_cobrado((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_cobrado(null);
                }
            } else if (name.equals("enviado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$enviado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'enviado' to null.");
                }
            } else if (name.equals("cobrado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cobrado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cobrado' to null.");
                }
            } else if (name.equals("descargado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descargado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'descargado' to null.");
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

    private static com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.VisitsPayments copyOrUpdate(Realm realm, VisitsPaymentsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsPayments object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.VisitsPayments) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.VisitsPayments copy(Realm realm, VisitsPaymentsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsPayments newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.VisitsPayments) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsPayments.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.pagoIndex, realmObjectSource.realmGet$pago());
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.visitaIndex, realmObjectSource.realmGet$visita());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addDouble(columnInfo.importeIndex, realmObjectSource.realmGet$importe());
        builder.addDouble(columnInfo.importe_pagoIndex, realmObjectSource.realmGet$importe_pago());
        builder.addDouble(columnInfo.importe_saldadoIndex, realmObjectSource.realmGet$importe_saldado());
        builder.addInteger(columnInfo.ultimos_4_tarjetaIndex, realmObjectSource.realmGet$ultimos_4_tarjeta());
        builder.addString(columnInfo.metodo_pagoIndex, realmObjectSource.realmGet$metodo_pago());
        builder.addString(columnInfo.fechaIndex, realmObjectSource.realmGet$fecha());
        builder.addString(columnInfo.fecha_cobradoIndex, realmObjectSource.realmGet$fecha_cobrado());
        builder.addBoolean(columnInfo.enviadoIndex, realmObjectSource.realmGet$enviado());
        builder.addBoolean(columnInfo.cobradoIndex, realmObjectSource.realmGet$cobrado());
        builder.addBoolean(columnInfo.descargadoIndex, realmObjectSource.realmGet$descargado());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.VisitsPayments object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsPayments.class);
        long tableNativePtr = table.getNativePtr();
        VisitsPaymentsColumnInfo columnInfo = (VisitsPaymentsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$pago(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importe_pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_pago(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importe_saldadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_saldado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ultimos_4_tarjetaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ultimos_4_tarjeta(), false);
        String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$metodo_pago();
        if (realmGet$metodo_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
        }
        String realmGet$fecha = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        }
        String realmGet$fecha_cobrado = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha_cobrado();
        if (realmGet$fecha_cobrado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, realmGet$fecha_cobrado, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$enviado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.cobradoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cobrado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.descargadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$descargado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsPayments.class);
        long tableNativePtr = table.getNativePtr();
        VisitsPaymentsColumnInfo columnInfo = (VisitsPaymentsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class);
        com.mds.ventasabpollo.models.VisitsPayments object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsPayments) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$pago(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importe_pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_pago(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importe_saldadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_saldado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ultimos_4_tarjetaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ultimos_4_tarjeta(), false);
            String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$metodo_pago();
            if (realmGet$metodo_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
            }
            String realmGet$fecha = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            }
            String realmGet$fecha_cobrado = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha_cobrado();
            if (realmGet$fecha_cobrado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, realmGet$fecha_cobrado, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$enviado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.cobradoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cobrado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.descargadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$descargado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.VisitsPayments object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsPayments.class);
        long tableNativePtr = table.getNativePtr();
        VisitsPaymentsColumnInfo columnInfo = (VisitsPaymentsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$pago(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importe_pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_pago(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.importe_saldadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_saldado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ultimos_4_tarjetaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ultimos_4_tarjeta(), false);
        String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$metodo_pago();
        if (realmGet$metodo_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, false);
        }
        String realmGet$fecha = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }
        String realmGet$fecha_cobrado = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha_cobrado();
        if (realmGet$fecha_cobrado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, realmGet$fecha_cobrado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$enviado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.cobradoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cobrado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.descargadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$descargado(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsPayments.class);
        long tableNativePtr = table.getNativePtr();
        VisitsPaymentsColumnInfo columnInfo = (VisitsPaymentsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsPayments.class);
        com.mds.ventasabpollo.models.VisitsPayments object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsPayments) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$pago(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importeIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importe_pagoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_pago(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.importe_saldadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$importe_saldado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.ultimos_4_tarjetaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$ultimos_4_tarjeta(), false);
            String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$metodo_pago();
            if (realmGet$metodo_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, false);
            }
            String realmGet$fecha = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
            }
            String realmGet$fecha_cobrado = ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$fecha_cobrado();
            if (realmGet$fecha_cobrado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, realmGet$fecha_cobrado, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_cobradoIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$enviado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.cobradoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$cobrado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.descargadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$descargado(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.VisitsPayments createDetachedCopy(com.mds.ventasabpollo.models.VisitsPayments realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.VisitsPayments unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.VisitsPayments();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.VisitsPayments) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.VisitsPayments) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$pago(realmSource.realmGet$pago());
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$visita(realmSource.realmGet$visita());
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$importe(realmSource.realmGet$importe());
        unmanagedCopy.realmSet$importe_pago(realmSource.realmGet$importe_pago());
        unmanagedCopy.realmSet$importe_saldado(realmSource.realmGet$importe_saldado());
        unmanagedCopy.realmSet$ultimos_4_tarjeta(realmSource.realmGet$ultimos_4_tarjeta());
        unmanagedCopy.realmSet$metodo_pago(realmSource.realmGet$metodo_pago());
        unmanagedCopy.realmSet$fecha(realmSource.realmGet$fecha());
        unmanagedCopy.realmSet$fecha_cobrado(realmSource.realmGet$fecha_cobrado());
        unmanagedCopy.realmSet$enviado(realmSource.realmGet$enviado());
        unmanagedCopy.realmSet$cobrado(realmSource.realmGet$cobrado());
        unmanagedCopy.realmSet$descargado(realmSource.realmGet$descargado());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("VisitsPayments = proxy[");
        stringBuilder.append("{pago:");
        stringBuilder.append(realmGet$pago());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{visita:");
        stringBuilder.append(realmGet$visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{importe:");
        stringBuilder.append(realmGet$importe());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{importe_pago:");
        stringBuilder.append(realmGet$importe_pago());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{importe_saldado:");
        stringBuilder.append(realmGet$importe_saldado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ultimos_4_tarjeta:");
        stringBuilder.append(realmGet$ultimos_4_tarjeta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{metodo_pago:");
        stringBuilder.append(realmGet$metodo_pago() != null ? realmGet$metodo_pago() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_cobrado:");
        stringBuilder.append(realmGet$fecha_cobrado() != null ? realmGet$fecha_cobrado() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enviado:");
        stringBuilder.append(realmGet$enviado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cobrado:");
        stringBuilder.append(realmGet$cobrado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{descargado:");
        stringBuilder.append(realmGet$descargado());
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
        com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy aVisitsPayments = (com_mds_ventasabpollo_models_VisitsPaymentsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVisitsPayments.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVisitsPayments.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVisitsPayments.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
