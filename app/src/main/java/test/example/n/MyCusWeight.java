package test.example.n;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.Button;

import androidx.annotation.NonNull;

public class MyCusWeight extends Dialog {
    Button btnConfirmWeight, btnCancelWeight;
    Activity activity;

    public MyCusWeight(@NonNull Context context) {
        super(context);
        this.activity = (Activity) context;
        setContentView(R.layout.weight_dialog);
        linkViews();
    }

    private void linkViews() {
        btnConfirmWeight = findViewById(R.id.btnConfirmWeight);
        btnCancelWeight = findViewById(R.id.btnCancelWeight);
    }
}
