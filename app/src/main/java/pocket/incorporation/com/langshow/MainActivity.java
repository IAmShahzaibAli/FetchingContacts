package pocket.incorporation.com.langshow;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
 RecyclerView mRecyclerView;
    private List<Contact> mContactList = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mRecyclerView = (RecyclerView)findViewById(R.id.rv);

    }

    void  getContacts()
    {

        ContentResolver mcontentResolver = this.getContentResolver();
        Cursor cursor = mcontentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneno = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Contact contact = new Contact();
            contact.setName(name);
            contact.setPhoneno(phoneno);
            mContactList.add(contact);
            cursor.moveToNext();


        }

    }



}
