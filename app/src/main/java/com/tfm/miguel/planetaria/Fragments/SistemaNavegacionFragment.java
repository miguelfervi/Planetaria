package com.tfm.miguel.planetaria.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.estimote.cloud_plugin.common.EstimoteCloudCredentials;
import com.estimote.internal_plugins_api.cloud.CloudCredentials;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.Requirement;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory;
import com.tfm.miguel.planetaria.Activities.Ejercicio1Activity;
import com.tfm.miguel.planetaria.R;
import com.tfm.miguel.planetaria.estimote.ProximityContentAdapter;
import com.tfm.miguel.planetaria.estimote.ProximityContentManager;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/**
 * A simple {@link Fragment} subclass.
 */
public class SistemaNavegacionFragment extends Fragment {


    private ProximityContentManager proximityContentManager;
    private ProximityContentAdapter proximityContentAdapter;
    GridView gridView;
    ImageButton btn1;

    public CloudCredentials cloudCredentials =
            new EstimoteCloudCredentials("gamificacion-proximidad-oms", "e134ca8549d5e356c06504db5b13d0e9");


    public SistemaNavegacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sistema_navegacion, container, false);
        proximityContentAdapter = new ProximityContentAdapter(getActivity());

        gridView = (GridView) view.findViewById(R.id.gridView);

        gridView.setAdapter(proximityContentAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Ejercicio1Activity.class);
                Toast.makeText(getActivity(),"Evento activido",Toast.LENGTH_LONG).show();
                getActivity().startActivity(intent);
            }
        });
        RequirementsWizardFactory
                .createEstimoteRequirementsWizard()
                .fulfillRequirements(getActivity(),
                        new Function0<Unit>() {
                            @Override
                            public Unit invoke() {
                                Log.d("app", "requirements fulfilled");
                                startProximityContentManager();
                                return null;
                            }
                        },
                        new Function1<List<? extends Requirement>, Unit>() {
                            @Override
                            public Unit invoke(List<? extends Requirement> requirements) {
                                Log.e("app", "requirements missing: " + requirements);
                                return null;
                            }
                        },
                        new Function1<Throwable, Unit>() {
                            @Override
                            public Unit invoke(Throwable throwable) {
                                Log.e("app", "requirements error: " + throwable);
                                return null;
                            }
                        });

        return view;
    }


    public void startProximityContentManager() {
        proximityContentManager = new ProximityContentManager(getActivity(), proximityContentAdapter, cloudCredentials);
        proximityContentManager.start();
    }
}
