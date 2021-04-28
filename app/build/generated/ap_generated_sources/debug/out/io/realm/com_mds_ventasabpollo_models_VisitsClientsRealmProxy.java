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
public class com_mds_ventasabpollo_models_VisitsClientsRealmProxy extends com.mds.ventasabpollo.models.VisitsClients
    implements RealmObjectProxy, com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface {

    static final class VisitsClientsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long rutaIndex;
        long clienteIndex;
        long listaIndex;
        long clasificacion_visitaIndex;
        long position_clasificacion_visitaIndex;
        long fecha_visita_inicioIndex;
        long fecha_visita_finIndex;
        long fecha_enviadaIndex;
        long lat_visita_inicioIndex;
        long long_visita_inicioIndex;
        long lat_visita_finIndex;
        long long_visita_finIndex;
        long enviadaIndex;
        long es_creditoIndex;
        long es_remisionIndex;
        long visitadaIndex;
        long finalizado_forzadoIndex;
        long estado_ventasIndex;
        long id_dbIndex;
        long facturaIndex;
        long user_idIndex;

        VisitsClientsColumnInfo(OsSchemaInfo schemaInfo) {
            super(22);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("VisitsClients");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.rutaIndex = addColumnDetails("ruta", "ruta", objectSchemaInfo);
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.listaIndex = addColumnDetails("lista", "lista", objectSchemaInfo);
            this.clasificacion_visitaIndex = addColumnDetails("clasificacion_visita", "clasificacion_visita", objectSchemaInfo);
            this.position_clasificacion_visitaIndex = addColumnDetails("position_clasificacion_visita", "position_clasificacion_visita", objectSchemaInfo);
            this.fecha_visita_inicioIndex = addColumnDetails("fecha_visita_inicio", "fecha_visita_inicio", objectSchemaInfo);
            this.fecha_visita_finIndex = addColumnDetails("fecha_visita_fin", "fecha_visita_fin", objectSchemaInfo);
            this.fecha_enviadaIndex = addColumnDetails("fecha_enviada", "fecha_enviada", objectSchemaInfo);
            this.lat_visita_inicioIndex = addColumnDetails("lat_visita_inicio", "lat_visita_inicio", objectSchemaInfo);
            this.long_visita_inicioIndex = addColumnDetails("long_visita_inicio", "long_visita_inicio", objectSchemaInfo);
            this.lat_visita_finIndex = addColumnDetails("lat_visita_fin", "lat_visita_fin", objectSchemaInfo);
            this.long_visita_finIndex = addColumnDetails("long_visita_fin", "long_visita_fin", objectSchemaInfo);
            this.enviadaIndex = addColumnDetails("enviada", "enviada", objectSchemaInfo);
            this.es_creditoIndex = addColumnDetails("es_credito", "es_credito", objectSchemaInfo);
            this.es_remisionIndex = addColumnDetails("es_remision", "es_remision", objectSchemaInfo);
            this.visitadaIndex = addColumnDetails("visitada", "visitada", objectSchemaInfo);
            this.finalizado_forzadoIndex = addColumnDetails("finalizado_forzado", "finalizado_forzado", objectSchemaInfo);
            this.estado_ventasIndex = addColumnDetails("estado_ventas", "estado_ventas", objectSchemaInfo);
            this.id_dbIndex = addColumnDetails("id_db", "id_db", objectSchemaInfo);
            this.facturaIndex = addColumnDetails("factura", "factura", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        VisitsClientsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new VisitsClientsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final VisitsClientsColumnInfo src = (VisitsClientsColumnInfo) rawSrc;
            final VisitsClientsColumnInfo dst = (VisitsClientsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.rutaIndex = src.rutaIndex;
            dst.clienteIndex = src.clienteIndex;
            dst.listaIndex = src.listaIndex;
            dst.clasificacion_visitaIndex = src.clasificacion_visitaIndex;
            dst.position_clasificacion_visitaIndex = src.position_clasificacion_visitaIndex;
            dst.fecha_visita_inicioIndex = src.fecha_visita_inicioIndex;
            dst.fecha_visita_finIndex = src.fecha_visita_finIndex;
            dst.fecha_enviadaIndex = src.fecha_enviadaIndex;
            dst.lat_visita_inicioIndex = src.lat_visita_inicioIndex;
            dst.long_visita_inicioIndex = src.long_visita_inicioIndex;
            dst.lat_visita_finIndex = src.lat_visita_finIndex;
            dst.long_visita_finIndex = src.long_visita_finIndex;
            dst.enviadaIndex = src.enviadaIndex;
            dst.es_creditoIndex = src.es_creditoIndex;
            dst.es_remisionIndex = src.es_remisionIndex;
            dst.visitadaIndex = src.visitadaIndex;
            dst.finalizado_forzadoIndex = src.finalizado_forzadoIndex;
            dst.estado_ventasIndex = src.estado_ventasIndex;
            dst.id_dbIndex = src.id_dbIndex;
            dst.facturaIndex = src.facturaIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private VisitsClientsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.VisitsClients> proxyState;

    com_mds_ventasabpollo_models_VisitsClientsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (VisitsClientsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.VisitsClients>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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
    public int realmGet$clasificacion_visita() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clasificacion_visitaIndex);
    }

    @Override
    public void realmSet$clasificacion_visita(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clasificacion_visitaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clasificacion_visitaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$position_clasificacion_visita() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.position_clasificacion_visitaIndex);
    }

    @Override
    public void realmSet$position_clasificacion_visita(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.position_clasificacion_visitaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.position_clasificacion_visitaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_visita_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_visita_inicioIndex);
    }

    @Override
    public void realmSet$fecha_visita_inicio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_visita_inicioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_visita_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_visita_inicioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_visita_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_visita_fin() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_visita_finIndex);
    }

    @Override
    public void realmSet$fecha_visita_fin(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_visita_finIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_visita_finIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_visita_finIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_visita_finIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_enviada() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_enviadaIndex);
    }

    @Override
    public void realmSet$fecha_enviada(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_enviadaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_enviadaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_enviadaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_enviadaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$lat_visita_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.lat_visita_inicioIndex);
    }

    @Override
    public void realmSet$lat_visita_inicio(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.lat_visita_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.lat_visita_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$long_visita_inicio() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.long_visita_inicioIndex);
    }

    @Override
    public void realmSet$long_visita_inicio(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.long_visita_inicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.long_visita_inicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$lat_visita_fin() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.lat_visita_finIndex);
    }

    @Override
    public void realmSet$lat_visita_fin(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.lat_visita_finIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.lat_visita_finIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$long_visita_fin() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.long_visita_finIndex);
    }

    @Override
    public void realmSet$long_visita_fin(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.long_visita_finIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.long_visita_finIndex, value);
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
    public boolean realmGet$es_credito() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.es_creditoIndex);
    }

    @Override
    public void realmSet$es_credito(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.es_creditoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.es_creditoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$es_remision() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.es_remisionIndex);
    }

    @Override
    public void realmSet$es_remision(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.es_remisionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.es_remisionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$visitada() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.visitadaIndex);
    }

    @Override
    public void realmSet$visitada(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.visitadaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.visitadaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$finalizado_forzado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.finalizado_forzadoIndex);
    }

    @Override
    public void realmSet$finalizado_forzado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.finalizado_forzadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.finalizado_forzadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$estado_ventas() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.estado_ventasIndex);
    }

    @Override
    public void realmSet$estado_ventas(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.estado_ventasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.estado_ventasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_db() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_dbIndex);
    }

    @Override
    public void realmSet$id_db(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_dbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_dbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$factura() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.facturaIndex);
    }

    @Override
    public void realmSet$factura(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.facturaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.facturaIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("VisitsClients", 22, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("ruta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("lista", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("clasificacion_visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("position_clasificacion_visita", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha_visita_inicio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_visita_fin", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_enviada", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lat_visita_inicio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("long_visita_inicio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("lat_visita_fin", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("long_visita_fin", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("enviada", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("es_credito", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("es_remision", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("visitada", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("finalizado_forzado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("estado_ventas", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id_db", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("factura", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static VisitsClientsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new VisitsClientsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "VisitsClients";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "VisitsClients";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.VisitsClients createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.VisitsClients obj = null;
        if (update) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
            VisitsClientsColumnInfo columnInfo = (VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.VisitsClients.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy) realm.createObjectInternal(com.mds.ventasabpollo.models.VisitsClients.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) obj;
        if (json.has("ruta")) {
            if (json.isNull("ruta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
            } else {
                objProxy.realmSet$ruta((int) json.getInt("ruta"));
            }
        }
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("lista")) {
            if (json.isNull("lista")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lista' to null.");
            } else {
                objProxy.realmSet$lista((int) json.getInt("lista"));
            }
        }
        if (json.has("clasificacion_visita")) {
            if (json.isNull("clasificacion_visita")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clasificacion_visita' to null.");
            } else {
                objProxy.realmSet$clasificacion_visita((int) json.getInt("clasificacion_visita"));
            }
        }
        if (json.has("position_clasificacion_visita")) {
            if (json.isNull("position_clasificacion_visita")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'position_clasificacion_visita' to null.");
            } else {
                objProxy.realmSet$position_clasificacion_visita((int) json.getInt("position_clasificacion_visita"));
            }
        }
        if (json.has("fecha_visita_inicio")) {
            if (json.isNull("fecha_visita_inicio")) {
                objProxy.realmSet$fecha_visita_inicio(null);
            } else {
                objProxy.realmSet$fecha_visita_inicio((String) json.getString("fecha_visita_inicio"));
            }
        }
        if (json.has("fecha_visita_fin")) {
            if (json.isNull("fecha_visita_fin")) {
                objProxy.realmSet$fecha_visita_fin(null);
            } else {
                objProxy.realmSet$fecha_visita_fin((String) json.getString("fecha_visita_fin"));
            }
        }
        if (json.has("fecha_enviada")) {
            if (json.isNull("fecha_enviada")) {
                objProxy.realmSet$fecha_enviada(null);
            } else {
                objProxy.realmSet$fecha_enviada((String) json.getString("fecha_enviada"));
            }
        }
        if (json.has("lat_visita_inicio")) {
            if (json.isNull("lat_visita_inicio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lat_visita_inicio' to null.");
            } else {
                objProxy.realmSet$lat_visita_inicio((double) json.getDouble("lat_visita_inicio"));
            }
        }
        if (json.has("long_visita_inicio")) {
            if (json.isNull("long_visita_inicio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'long_visita_inicio' to null.");
            } else {
                objProxy.realmSet$long_visita_inicio((double) json.getDouble("long_visita_inicio"));
            }
        }
        if (json.has("lat_visita_fin")) {
            if (json.isNull("lat_visita_fin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lat_visita_fin' to null.");
            } else {
                objProxy.realmSet$lat_visita_fin((double) json.getDouble("lat_visita_fin"));
            }
        }
        if (json.has("long_visita_fin")) {
            if (json.isNull("long_visita_fin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'long_visita_fin' to null.");
            } else {
                objProxy.realmSet$long_visita_fin((double) json.getDouble("long_visita_fin"));
            }
        }
        if (json.has("enviada")) {
            if (json.isNull("enviada")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'enviada' to null.");
            } else {
                objProxy.realmSet$enviada((boolean) json.getBoolean("enviada"));
            }
        }
        if (json.has("es_credito")) {
            if (json.isNull("es_credito")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'es_credito' to null.");
            } else {
                objProxy.realmSet$es_credito((boolean) json.getBoolean("es_credito"));
            }
        }
        if (json.has("es_remision")) {
            if (json.isNull("es_remision")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'es_remision' to null.");
            } else {
                objProxy.realmSet$es_remision((boolean) json.getBoolean("es_remision"));
            }
        }
        if (json.has("visitada")) {
            if (json.isNull("visitada")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'visitada' to null.");
            } else {
                objProxy.realmSet$visitada((boolean) json.getBoolean("visitada"));
            }
        }
        if (json.has("finalizado_forzado")) {
            if (json.isNull("finalizado_forzado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'finalizado_forzado' to null.");
            } else {
                objProxy.realmSet$finalizado_forzado((boolean) json.getBoolean("finalizado_forzado"));
            }
        }
        if (json.has("estado_ventas")) {
            if (json.isNull("estado_ventas")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'estado_ventas' to null.");
            } else {
                objProxy.realmSet$estado_ventas((boolean) json.getBoolean("estado_ventas"));
            }
        }
        if (json.has("id_db")) {
            if (json.isNull("id_db")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_db' to null.");
            } else {
                objProxy.realmSet$id_db((int) json.getInt("id_db"));
            }
        }
        if (json.has("factura")) {
            if (json.isNull("factura")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'factura' to null.");
            } else {
                objProxy.realmSet$factura((int) json.getInt("factura"));
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
    public static com.mds.ventasabpollo.models.VisitsClients createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.mds.ventasabpollo.models.VisitsClients obj = new com.mds.ventasabpollo.models.VisitsClients();
        final com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("ruta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ruta((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ruta' to null.");
                }
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("lista")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lista((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lista' to null.");
                }
            } else if (name.equals("clasificacion_visita")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clasificacion_visita((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clasificacion_visita' to null.");
                }
            } else if (name.equals("position_clasificacion_visita")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$position_clasificacion_visita((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'position_clasificacion_visita' to null.");
                }
            } else if (name.equals("fecha_visita_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_visita_inicio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_visita_inicio(null);
                }
            } else if (name.equals("fecha_visita_fin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_visita_fin((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_visita_fin(null);
                }
            } else if (name.equals("fecha_enviada")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_enviada((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_enviada(null);
                }
            } else if (name.equals("lat_visita_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lat_visita_inicio((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lat_visita_inicio' to null.");
                }
            } else if (name.equals("long_visita_inicio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$long_visita_inicio((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'long_visita_inicio' to null.");
                }
            } else if (name.equals("lat_visita_fin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lat_visita_fin((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lat_visita_fin' to null.");
                }
            } else if (name.equals("long_visita_fin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$long_visita_fin((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'long_visita_fin' to null.");
                }
            } else if (name.equals("enviada")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$enviada((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'enviada' to null.");
                }
            } else if (name.equals("es_credito")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$es_credito((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'es_credito' to null.");
                }
            } else if (name.equals("es_remision")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$es_remision((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'es_remision' to null.");
                }
            } else if (name.equals("visitada")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$visitada((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'visitada' to null.");
                }
            } else if (name.equals("finalizado_forzado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$finalizado_forzado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'finalizado_forzado' to null.");
                }
            } else if (name.equals("estado_ventas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$estado_ventas((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'estado_ventas' to null.");
                }
            } else if (name.equals("id_db")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_db((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_db' to null.");
                }
            } else if (name.equals("factura")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$factura((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'factura' to null.");
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
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_VisitsClientsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.VisitsClients copyOrUpdate(Realm realm, VisitsClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsClients object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.VisitsClients) cachedRealmObject;
        }

        com.mds.ventasabpollo.models.VisitsClients realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.VisitsClients copy(Realm realm, VisitsClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsClients newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.VisitsClients) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addInteger(columnInfo.clasificacion_visitaIndex, realmObjectSource.realmGet$clasificacion_visita());
        builder.addInteger(columnInfo.position_clasificacion_visitaIndex, realmObjectSource.realmGet$position_clasificacion_visita());
        builder.addString(columnInfo.fecha_visita_inicioIndex, realmObjectSource.realmGet$fecha_visita_inicio());
        builder.addString(columnInfo.fecha_visita_finIndex, realmObjectSource.realmGet$fecha_visita_fin());
        builder.addString(columnInfo.fecha_enviadaIndex, realmObjectSource.realmGet$fecha_enviada());
        builder.addDouble(columnInfo.lat_visita_inicioIndex, realmObjectSource.realmGet$lat_visita_inicio());
        builder.addDouble(columnInfo.long_visita_inicioIndex, realmObjectSource.realmGet$long_visita_inicio());
        builder.addDouble(columnInfo.lat_visita_finIndex, realmObjectSource.realmGet$lat_visita_fin());
        builder.addDouble(columnInfo.long_visita_finIndex, realmObjectSource.realmGet$long_visita_fin());
        builder.addBoolean(columnInfo.enviadaIndex, realmObjectSource.realmGet$enviada());
        builder.addBoolean(columnInfo.es_creditoIndex, realmObjectSource.realmGet$es_credito());
        builder.addBoolean(columnInfo.es_remisionIndex, realmObjectSource.realmGet$es_remision());
        builder.addBoolean(columnInfo.visitadaIndex, realmObjectSource.realmGet$visitada());
        builder.addBoolean(columnInfo.finalizado_forzadoIndex, realmObjectSource.realmGet$finalizado_forzado());
        builder.addBoolean(columnInfo.estado_ventasIndex, realmObjectSource.realmGet$estado_ventas());
        builder.addInteger(columnInfo.id_dbIndex, realmObjectSource.realmGet$id_db());
        builder.addInteger(columnInfo.facturaIndex, realmObjectSource.realmGet$factura());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_VisitsClientsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.VisitsClients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClientsColumnInfo columnInfo = (VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$clasificacion_visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.position_clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$position_clasificacion_visita(), false);
        String realmGet$fecha_visita_inicio = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_inicio();
        if (realmGet$fecha_visita_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, realmGet$fecha_visita_inicio, false);
        }
        String realmGet$fecha_visita_fin = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_fin();
        if (realmGet$fecha_visita_fin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, realmGet$fecha_visita_fin, false);
        }
        String realmGet$fecha_enviada = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_enviada();
        if (realmGet$fecha_enviada != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, realmGet$fecha_enviada, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_inicio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_inicio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_fin(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_fin(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_credito(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_remisionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_remision(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.visitadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$visitada(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.finalizado_forzadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$finalizado_forzado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.estado_ventasIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$estado_ventas(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id_db(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.facturaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$factura(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClientsColumnInfo columnInfo = (VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.mds.ventasabpollo.models.VisitsClients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsClients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$clasificacion_visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.position_clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$position_clasificacion_visita(), false);
            String realmGet$fecha_visita_inicio = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_inicio();
            if (realmGet$fecha_visita_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, realmGet$fecha_visita_inicio, false);
            }
            String realmGet$fecha_visita_fin = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_fin();
            if (realmGet$fecha_visita_fin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, realmGet$fecha_visita_fin, false);
            }
            String realmGet$fecha_enviada = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_enviada();
            if (realmGet$fecha_enviada != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, realmGet$fecha_enviada, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_inicio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_inicio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_fin(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_fin(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_credito(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_remisionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_remision(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.visitadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$visitada(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.finalizado_forzadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$finalizado_forzado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.estado_ventasIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$estado_ventas(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id_db(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.facturaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$factura(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.VisitsClients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClientsColumnInfo columnInfo = (VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$ruta(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lista(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$clasificacion_visita(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.position_clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$position_clasificacion_visita(), false);
        String realmGet$fecha_visita_inicio = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_inicio();
        if (realmGet$fecha_visita_inicio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, realmGet$fecha_visita_inicio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, false);
        }
        String realmGet$fecha_visita_fin = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_fin();
        if (realmGet$fecha_visita_fin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, realmGet$fecha_visita_fin, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, false);
        }
        String realmGet$fecha_enviada = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_enviada();
        if (realmGet$fecha_enviada != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, realmGet$fecha_enviada, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_inicio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_inicio(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_fin(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_fin(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$enviada(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_credito(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.es_remisionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_remision(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.visitadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$visitada(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.finalizado_forzadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$finalizado_forzado(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.estado_ventasIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$estado_ventas(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id_db(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.facturaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$factura(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        long tableNativePtr = table.getNativePtr();
        VisitsClientsColumnInfo columnInfo = (VisitsClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.VisitsClients.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.mds.ventasabpollo.models.VisitsClients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.VisitsClients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rutaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$ruta(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.listaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lista(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$clasificacion_visita(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.position_clasificacion_visitaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$position_clasificacion_visita(), false);
            String realmGet$fecha_visita_inicio = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_inicio();
            if (realmGet$fecha_visita_inicio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, realmGet$fecha_visita_inicio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_visita_inicioIndex, rowIndex, false);
            }
            String realmGet$fecha_visita_fin = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_visita_fin();
            if (realmGet$fecha_visita_fin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, realmGet$fecha_visita_fin, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_visita_finIndex, rowIndex, false);
            }
            String realmGet$fecha_enviada = ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$fecha_enviada();
            if (realmGet$fecha_enviada != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, realmGet$fecha_enviada, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_enviadaIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_inicio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_inicioIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_inicio(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.lat_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$lat_visita_fin(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.long_visita_finIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$long_visita_fin(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.enviadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$enviada(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_credito(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.es_remisionIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$es_remision(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.visitadaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$visitada(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.finalizado_forzadoIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$finalizado_forzado(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.estado_ventasIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$estado_ventas(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$id_db(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.facturaIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$factura(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.VisitsClients createDetachedCopy(com.mds.ventasabpollo.models.VisitsClients realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.VisitsClients unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.VisitsClients();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.VisitsClients) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.VisitsClients) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$ruta(realmSource.realmGet$ruta());
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$lista(realmSource.realmGet$lista());
        unmanagedCopy.realmSet$clasificacion_visita(realmSource.realmGet$clasificacion_visita());
        unmanagedCopy.realmSet$position_clasificacion_visita(realmSource.realmGet$position_clasificacion_visita());
        unmanagedCopy.realmSet$fecha_visita_inicio(realmSource.realmGet$fecha_visita_inicio());
        unmanagedCopy.realmSet$fecha_visita_fin(realmSource.realmGet$fecha_visita_fin());
        unmanagedCopy.realmSet$fecha_enviada(realmSource.realmGet$fecha_enviada());
        unmanagedCopy.realmSet$lat_visita_inicio(realmSource.realmGet$lat_visita_inicio());
        unmanagedCopy.realmSet$long_visita_inicio(realmSource.realmGet$long_visita_inicio());
        unmanagedCopy.realmSet$lat_visita_fin(realmSource.realmGet$lat_visita_fin());
        unmanagedCopy.realmSet$long_visita_fin(realmSource.realmGet$long_visita_fin());
        unmanagedCopy.realmSet$enviada(realmSource.realmGet$enviada());
        unmanagedCopy.realmSet$es_credito(realmSource.realmGet$es_credito());
        unmanagedCopy.realmSet$es_remision(realmSource.realmGet$es_remision());
        unmanagedCopy.realmSet$visitada(realmSource.realmGet$visitada());
        unmanagedCopy.realmSet$finalizado_forzado(realmSource.realmGet$finalizado_forzado());
        unmanagedCopy.realmSet$estado_ventas(realmSource.realmGet$estado_ventas());
        unmanagedCopy.realmSet$id_db(realmSource.realmGet$id_db());
        unmanagedCopy.realmSet$factura(realmSource.realmGet$factura());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    static com.mds.ventasabpollo.models.VisitsClients update(Realm realm, VisitsClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.VisitsClients realmObject, com.mds.ventasabpollo.models.VisitsClients newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface realmObjectTarget = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) realmObject;
        com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_VisitsClientsRealmProxyInterface) newObject;
        Table table = realm.getTable(com.mds.ventasabpollo.models.VisitsClients.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.rutaIndex, realmObjectSource.realmGet$ruta());
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.listaIndex, realmObjectSource.realmGet$lista());
        builder.addInteger(columnInfo.clasificacion_visitaIndex, realmObjectSource.realmGet$clasificacion_visita());
        builder.addInteger(columnInfo.position_clasificacion_visitaIndex, realmObjectSource.realmGet$position_clasificacion_visita());
        builder.addString(columnInfo.fecha_visita_inicioIndex, realmObjectSource.realmGet$fecha_visita_inicio());
        builder.addString(columnInfo.fecha_visita_finIndex, realmObjectSource.realmGet$fecha_visita_fin());
        builder.addString(columnInfo.fecha_enviadaIndex, realmObjectSource.realmGet$fecha_enviada());
        builder.addDouble(columnInfo.lat_visita_inicioIndex, realmObjectSource.realmGet$lat_visita_inicio());
        builder.addDouble(columnInfo.long_visita_inicioIndex, realmObjectSource.realmGet$long_visita_inicio());
        builder.addDouble(columnInfo.lat_visita_finIndex, realmObjectSource.realmGet$lat_visita_fin());
        builder.addDouble(columnInfo.long_visita_finIndex, realmObjectSource.realmGet$long_visita_fin());
        builder.addBoolean(columnInfo.enviadaIndex, realmObjectSource.realmGet$enviada());
        builder.addBoolean(columnInfo.es_creditoIndex, realmObjectSource.realmGet$es_credito());
        builder.addBoolean(columnInfo.es_remisionIndex, realmObjectSource.realmGet$es_remision());
        builder.addBoolean(columnInfo.visitadaIndex, realmObjectSource.realmGet$visitada());
        builder.addBoolean(columnInfo.finalizado_forzadoIndex, realmObjectSource.realmGet$finalizado_forzado());
        builder.addBoolean(columnInfo.estado_ventasIndex, realmObjectSource.realmGet$estado_ventas());
        builder.addInteger(columnInfo.id_dbIndex, realmObjectSource.realmGet$id_db());
        builder.addInteger(columnInfo.facturaIndex, realmObjectSource.realmGet$factura());
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
        StringBuilder stringBuilder = new StringBuilder("VisitsClients = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ruta:");
        stringBuilder.append(realmGet$ruta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lista:");
        stringBuilder.append(realmGet$lista());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clasificacion_visita:");
        stringBuilder.append(realmGet$clasificacion_visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{position_clasificacion_visita:");
        stringBuilder.append(realmGet$position_clasificacion_visita());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_visita_inicio:");
        stringBuilder.append(realmGet$fecha_visita_inicio() != null ? realmGet$fecha_visita_inicio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_visita_fin:");
        stringBuilder.append(realmGet$fecha_visita_fin() != null ? realmGet$fecha_visita_fin() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_enviada:");
        stringBuilder.append(realmGet$fecha_enviada() != null ? realmGet$fecha_enviada() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lat_visita_inicio:");
        stringBuilder.append(realmGet$lat_visita_inicio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{long_visita_inicio:");
        stringBuilder.append(realmGet$long_visita_inicio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lat_visita_fin:");
        stringBuilder.append(realmGet$lat_visita_fin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{long_visita_fin:");
        stringBuilder.append(realmGet$long_visita_fin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{enviada:");
        stringBuilder.append(realmGet$enviada());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{es_credito:");
        stringBuilder.append(realmGet$es_credito());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{es_remision:");
        stringBuilder.append(realmGet$es_remision());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{visitada:");
        stringBuilder.append(realmGet$visitada());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{finalizado_forzado:");
        stringBuilder.append(realmGet$finalizado_forzado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{estado_ventas:");
        stringBuilder.append(realmGet$estado_ventas());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id_db:");
        stringBuilder.append(realmGet$id_db());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{factura:");
        stringBuilder.append(realmGet$factura());
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
        com_mds_ventasabpollo_models_VisitsClientsRealmProxy aVisitsClients = (com_mds_ventasabpollo_models_VisitsClientsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aVisitsClients.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aVisitsClients.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aVisitsClients.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
