package pocket.incorporation.com.langshow;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{

    private List<Contact> mContacts;
    public ContactAdapter (List<Contact> contactList)
    {
        this.mContacts = contactList;


    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
View itemview = layoutInflater.inflate(R.layout.item_list,viewGroup);
ContactViewHolder contactViewHolder = new ContactViewHolder(itemview);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i)
    {
          Contact contact = mContacts.get(i);
         contactViewHolder.name.setText(contact.getname());
         contactViewHolder.phoneno.setText(contact.getPhoneno());


    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder
    {
         TextView name;
         TextView phoneno;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phoneno = itemView.findViewById(R.id.phoneno);


        }
    }



}
