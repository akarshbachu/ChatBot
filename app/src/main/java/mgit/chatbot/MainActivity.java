package mgit.chatbot;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton send;
    ListView lv;
    EditText et1;
    ArrayList<String> strArr;
    ArrayAdapter<String> adapter;
    int count=0,count1=0;
    String questGreet[]={"good","doing well"};
    String greetAns[]={"hi","hello","hey"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Questions you can ask");
        builder.setMessage("1.hello,hi,hey,hola"+"\n"+"2.how are you"+"\n"+"3.what is your name"+"\n"+"4.author name");
        builder.show();
        send=(ImageButton)findViewById(R.id.send);
        lv=(ListView)findViewById(R.id.listView);
        et1=(EditText)findViewById(R.id.et);
        strArr=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strArr);

        lv.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=et1.getText().toString();
                strArr.add(temp);
                adapter.notifyDataSetChanged();
                count++;
                et1.setText("");
                if(temp.equals("hello")||temp.equals("hi")||temp.equals("hey")||temp.equals("hola")){

                    if(count==0)
                    {
                        strArr.add(greetAns[0]);
                    }
                    else if(count==1){
                        strArr.add(greetAns[1]);
                    }
                    else{
                        strArr.add(greetAns[2]);
                        count=0;
                    }
                    adapter.notifyDataSetChanged();
                }
                else if(temp.equals("How are you")||temp.equals("How Are You")||temp.equals("HOW ARE YOU")||temp.equals("how are you")){
                    if(count1==0)
                    {
                        strArr.add(questGreet[0]);
                    }

                    else{
                        strArr.add(questGreet[0]);
                        count1=0;
                    }
                    adapter.notifyDataSetChanged();
                }
                else if(temp.equals("what is your name")){
                    strArr.add("BOT");
                    adapter.notifyDataSetChanged();
                }
                else if(temp.equals("author name")){
                    strArr.add("Akarsh");
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    strArr.add("enter the valid keyword");
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}
