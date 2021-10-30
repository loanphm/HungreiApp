package test.example.n;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.Button;

import androidx.annotation.NonNull;

public class MyCusHeight extends Dialog {
    Button btnConfirmHeight, btnCancelHeight;
    Activity activity;

    public MyCusHeight(@NonNull Context context) {
        super(context);
        this.activity = (Activity) context;
        setContentView(R.layout.height_dialog);
        linkViews();
    }

    private void linkViews() {
        btnConfirmHeight = findViewById(R.id.btnConfirmHeight);
        btnCancelHeight = findViewById(R.id.btnCancelHeight);
    }
}
