package com.mds.ventasabpollo.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Cities;
import com.mds.ventasabpollo.models.NewClients;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TabFragmentDomicilies extends Fragment {

    Realm realm;
    int idNewClient;

    EditText editTxtStreet, editTxtNoExterior, editTxtNoInterior, editTxtColony, editTxtPostalCode,
             editTxtPhone, editTxtDescription, editTxtLocation, editTxtMunicipality;
    String calle, no_exterior, no_interior, colonia, codigo_postal, telefono, descripcion, localidad, municipio;
    int      ciudad, position_spinner;
    Spinner spinnerCities;

    RealmResults<Cities> listCities;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.tab_fragment_domicilies, container, false);

        realm = Realm.getDefaultInstance();

        editTxtStreet = view.findViewById(R.id.editTxtStreet);
        editTxtNoExterior = view.findViewById(R.id.editTxtNoExterior);
        editTxtNoInterior = view.findViewById(R.id.editTxtNoInterior);
        editTxtColony = view.findViewById(R.id.editTxtColony);
        editTxtPostalCode = view.findViewById(R.id.editTxtPostalCode);
        editTxtPhone = view.findViewById(R.id.editTxtPhone);
        editTxtDescription = view.findViewById(R.id.editTxtDescription);
        editTxtLocation = view.findViewById(R.id.editTxtLocation);
        editTxtMunicipality = view.findViewById(R.id.editTxtMunicipality);
        spinnerCities = view.findViewById(R.id.spinnerCities);

        populateListCities();
        showData();

        editTxtStreet.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtNoExterior.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtNoInterior.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtColony.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtPostalCode.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtPhone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtDescription.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtLocation.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtMunicipality.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });

        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                position_spinner = position;
                updateValues();

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


        return view;
    }

    public void showData(){
        SPClass spClass = new SPClass(getActivity());
        BaseApp baseApp = new BaseApp(getActivity());

        try{
            idNewClient = spClass.intGetSP("idNewClient");

            RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("id", idNewClient).findAll();

            if(newClients.get(0) != null){

                RealmResults<Cities> cities = realm.where(Cities.class).equalTo("ciudad", newClients.get(0).getCiudad()).findAll();

                editTxtStreet.setText(newClients.get(0).getNombre_calle());
                editTxtNoExterior.setText(newClients.get(0).getNo_exterior());
                editTxtNoInterior.setText(newClients.get(0).getNo_interior());
                editTxtColony.setText(newClients.get(0).getColonia());
                editTxtPostalCode.setText(newClients.get(0).getCodigo_postal());
               // editTxtCity.setText(newClients.get(0).getCiudad());
                editTxtPhone.setText(newClients.get(0).getTelefono());
                editTxtDescription.setText(newClients.get(0).getDescripcion());
                editTxtLocation.setText(newClients.get(0).getLocalidad());
                editTxtMunicipality.setText(newClients.get(0).getMunicipio());

                if(cities.size() > 0){
                    spinnerCities.setSelection(cities.get(0).getPosition()-1);
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " + ex);
        }
    }

    public void updateValues(){
        SPClass spClass = new SPClass(getActivity());
        BaseApp baseApp = new BaseApp(getActivity());

        try{
            realm = Realm.getDefaultInstance();
            idNewClient = spClass.intGetSP("idNewClient");

            RealmResults<Cities> cities = realm.where(Cities.class).equalTo("position", position_spinner+1).findAll();

            calle = editTxtStreet.getText().toString();
            no_exterior = editTxtNoExterior.getText().toString();
            no_interior = editTxtNoInterior.getText().toString();
            colonia = editTxtColony.getText().toString();
            codigo_postal = editTxtPostalCode.getText().toString();
            telefono = editTxtPhone.getText().toString();
            descripcion = editTxtDescription.getText().toString();
            localidad = editTxtLocation.getText().toString();
            municipio = editTxtMunicipality.getText().toString();

            if(cities.size() > 0){
                ciudad = cities.get(0).getCiudad();
            }

            RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("id", idNewClient).findAll();
            if(newClients.get(0) != null){
                realm.beginTransaction();

                newClients.get(0).setNombre_calle(calle);
                newClients.get(0).setNo_exterior(no_exterior);
                newClients.get(0).setNo_interior(no_interior);
                newClients.get(0).setColonia(colonia);
                newClients.get(0).setCodigo_postal(codigo_postal);
                newClients.get(0).setCiudad(ciudad);
                newClients.get(0).setTelefono(telefono);
                newClients.get(0).setDescripcion(descripcion);
                newClients.get(0).setLocalidad(localidad);
                newClients.get(0).setMunicipio(municipio);

                realm.commitTransaction();
                baseApp.showLog("Cambios guardados");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " +  ex);
        }
    }

    public void populateListCities(){
        BaseApp baseApp = new BaseApp(getActivity());

        try {

            List<String> listArray = new ArrayList<>();
            listCities = realm.where(Cities.class).findAll();

            if (listCities.size() == 0) {
                baseApp.showToast("No se encontraron Ciudades para cargar.");
                //finish();
                spinnerCities.setEnabled(false);
            } else {

                for (int i = 0; i < listCities.size(); i++) {
                    listArray.add(listCities.get(i).getNombre_ciudad().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getActivity(), android.R.layout.simple_spinner_item, listArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCities.setAdapter(adapter);
                spinnerCities.setEnabled(true);

                //RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
                //spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Ciudades por este error: " + ex);
        }
    }

}