package com.example.tanya.material_design1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Custom_dialog_add extends Dialog
{
    Button button;
    EditText edthead, edtdesc;
    Update_list list;

    public Custom_dialog_add(@NonNull Context context,Frag_recycler frag)
    {
        super(context);
        list = frag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_add);

        button = (Button)findViewById(R.id.buttonadd);
        edthead = (EditText)findViewById(R.id.edithead);
        edtdesc = (EditText)findViewById(R.id.editdesc);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String head = edthead.getText().toString();
                String desc = edtdesc.getText().toString();
                list.updateList(head,desc);
                dismiss();
            }
        });
    }
}
