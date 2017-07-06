package echo.engineer.oneactivity.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fragmentmaster.app.MasterFragment;
import com.fragmentmaster.app.Request;

import echo.engineer.oneactivity.App;
import echo.engineer.oneactivity.MainActivity;
import echo.engineer.oneactivity.R;
import echo.engineer.oneactivity.cmpts.GyroscopeSensorWrapper;

/**
 * HomeFragment
 * Created by Plucky<plucky.pan@ubnt.com> on 6/22/17 2017 15:03.
 */

public class HomeFragment extends MasterFragment implements View.OnClickListener {

    private static final String TAG = "HomeFragment";

    private GyroscopeSensorWrapper sensorWrapper;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnOrderList).setOnClickListener(this);
        view.findViewById(R.id.btnHello).setOnClickListener(this);
        view.findViewById(R.id.btnWorld).setOnClickListener(this);
        view.findViewById(R.id.btnSensor).setOnClickListener(this);
        sensorWrapper = App.getComponent().getGyroscopeSensorWrapper();
        Log.d(TAG, "sensorWrapper=" + (sensorWrapper != null));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOrderList:
                Request request = new Request(OrdersFragment.class);
                startFragment(request);
                break;
            case R.id.btnHello:
                ((MainActivity) getActivity()).sendMessage("hello");
                break;
            case R.id.btnWorld:
                ((MainActivity) getActivity()).sendMessage("world");
                break;
            case R.id.btnSensor:
                sensorWrapper.start();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sensorWrapper.stop();
    }
}
