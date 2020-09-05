package th.ac.su.cp.smartvote;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Authentication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        Button checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView idCardNumber = findViewById(R.id.id_card_number);
                String textNumber = idCardNumber.getText().toString();
                Log.i("Authentication", "ID Card Number :" + textNumber);
                if (textNumber.length() == 13) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(Authentication.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setPositiveButton("OK", null);
                    if (textNumber.equals("1111111111111") || textNumber.equals("2222222222222")) {
                        dialog.setMessage("คุณเป็นผู้มีสิทธิเลือกตั้ง");
                    } else {
                        dialog.setMessage("คุณไม่มีสิทธิเลือกตั้ง");
                    }
                    dialog.show();
                } else {
                    /*if (textNumber.length() != 13)*/
                    //ไม่กรอกตัวเลข
                    Toast toast = Toast.makeText(Authentication.this, "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}